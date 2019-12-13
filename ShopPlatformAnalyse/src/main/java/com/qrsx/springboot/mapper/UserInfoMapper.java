package com.qrsx.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.qrsx.springboot.pojo.UserInfo;

/**
 * 
 * @ClassName: UserInfoMapper
 * @author zsd
 * @date 2019年12月11日
 *
 */
@Mapper
public interface UserInfoMapper {
	//登录，验证用户名和密码，并修改状态
	UserInfo checkPassword(UserInfo userInfo);

	int updateStatus(int userId);

	/**
	 *  @author: Yuyang Lu
	 *  @Date:  下午 7:33
	 *  @Description: 添加用户信息
	 */
	public Integer insertUser(UserInfo userInfo);

	/**
	 *  @author: Yuyang Lu
	 *  @Date:  下午 7:34
	 *  @Description: 查找用户名
	 */
	public String selectUser(String userName);
}