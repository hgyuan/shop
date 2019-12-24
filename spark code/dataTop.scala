package com.qrsx.shop

import java.util.Calendar

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SaveMode
import org.apache.spark.sql.hive.HiveContext

object dataTop {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("hive1")
    val sc = new SparkContext(conf)
    val hiveContext = new HiveContext(sc)
    hiveContext.sql("use shopping")
    /**
     * 查询生成DataFrame
     */
    val cal = Calendar.getInstance
    val year = cal.get(Calendar.YEAR)
    val month = cal.get(Calendar.MONTH)
    val Day = cal.get(Calendar.DAY_OF_MONTH)
    hiveContext.sql(
      "create table if not exists goods_order_record(goods_id int,goods_name String,Goods_category String, one int) partitioned by (day string) row format delimited fields terminated by ','"
    )
    hiveContext.sql("insert into goods_order_record partition(day='"+year+"-"+(month+1)+"-"+Day+"') "+
      "select id,goods_name,Goods_category,one from goods_order_all where logid = 'hot_goods' and day='"+year+"-"+(month+1)+"-"+Day+"'")

    val goods = hiveContext.sql(
      "select goods_id,goods_name,goods_category,sum(one) sum,day from goods_order_record group by goods_id,goods_name,goods_category,day "
    )

    hiveContext.sql("drop table if exists goods_order_count")
    goods.write.mode(SaveMode.Overwrite).saveAsTable("goods_order_count")

    val hotgoods = hiveContext.sql(
      "select goods_id,goods_name,goods_category,sum,day from(select goods_id,goods_name,goods_category,sum,day ,row_number() over (partition by goods_category order by sum desc ) rank from goods_order_count) t where t.rank<=3 "
    )
    goods.write.mode("append")
      .format("jdbc")
      .option("driver","com.mysql.jdbc.Driver")
      .option("url","jdbc:mysql://192.168.14.33:3306/shop_platform_analyse?useUnicode=true&characterEncoding=UTF-8")
      .option("dbtable","goods_order_count")
      .option("user","root")
      .option("password","123456")
      .option("truncate","false").save()
    sc.stop()
  }
}