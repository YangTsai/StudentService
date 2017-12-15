package com.fkq.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fkq.student.pojo.JsonResult;
import com.fkq.student.pojo.User;
import com.fkq.student.service.IUserService;

/**
 * 
 * @description 用户相关controller
 * @author hyy
 * @date 2017年11月27日
 */

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	/**
	 * 用户注册
	 * 
	 * @param phoneNumber手机号
	 * @param password密码
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public JsonResult regist(String phoneNumber, String password) throws Exception {
		JsonResult result = userService.regist(phoneNumber, password);
		return result;
	}

	/**
	 * 用户登录
	 * 
	 * @param phoneNumber
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public JsonResult login(String phoneNumber,String password) throws Exception {
		JsonResult result = userService.login(phoneNumber, password);
		return result;
	}

	/**
	 * 获取用户信息
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public JsonResult getUser(@RequestParam("id") String id) throws Exception{
		JsonResult result = userService.getUserById(id);
		return result;
	}

	/**
	 * 更新用户密码
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/updatePwd", method = RequestMethod.POST)
	public JsonResult updatePwd(String phoneNumber, String password) throws Exception{
		JsonResult result = userService.updatePwd(phoneNumber, password);
		return result;
	}

	/**
	 * 更新用户信息
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public JsonResult updateUser(User user) throws Exception{
		JsonResult result = userService.updateUser(user);
		return result;
	}

}
