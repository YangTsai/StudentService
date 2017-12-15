package com.fkq.student.service;

import com.fkq.student.pojo.JsonResult;
import com.fkq.student.pojo.User;

/**
 * 用户服务层
 * 
 * @description
 * @author hyy
 * @date 2017年11月27日
 */

public interface IUserService {

	/**
	 * 检测手机号是否注册
	 * 
	 * @param phoneNumber
	 * @return 是否注册
	 */
	public boolean checkPhoneNumber(String phoneNumber);

	/**
	 * 用户注册
	 * 
	 * @param phoneNumber手机号
	 * @param password密码（加密之后）
	 * @return
	 */
	public JsonResult regist(String phoneNumber, String password);

	/**
	 * 用户登录
	 * 
	 * @param phoneNumber
	 * @param password
	 * @return
	 */
	public JsonResult login(String phoneNumber, String password);

	/**
	 * 通过Id获取User对象
	 * 
	 * @param id
	 * @return
	 */
	public JsonResult getUserById(String id);

	/**
	 * 更新用户其他信息 通过主键更新
	 * 
	 * @param user
	 * @return
	 */
	public JsonResult updateUser(User user);

	/**
	 * 更新用户其他信息 通过手机号更新
	 * 
	 * @param user
	 * @return
	 */
	public JsonResult updatePwd(String phoneNumber, String password);

}
