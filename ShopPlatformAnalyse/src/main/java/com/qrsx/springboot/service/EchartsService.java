package com.qrsx.springboot.service;

import java.util.List;

import com.qrsx.springboot.pojo.ActiveCount;
import com.qrsx.springboot.pojo.OrderCount;
import com.qrsx.springboot.pojo.Sunburst;

/**
 * @ClassName:  EchartsService   
 * @Description:最终图表业务层实现
 * @date 2019年12月20日   
 */
public interface EchartsService {

	//24小时活跃人数折线图，按天查询活跃人数
	List<ActiveCount> select(String date);

	//订单统计表查询
	List<OrderCount> order();

	//获取Top3的信息
	List<Sunburst> getAllGoodsOrderCount(String time);

}
