package com.fkq.student.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fkq.student.constant.Constant;
import com.fkq.student.constant.ConstantStr;
import com.fkq.student.dao.UserMapper;
import com.fkq.student.pojo.JsonResult;
import com.fkq.student.pojo.User;
import com.fkq.student.pojo.UserExample;
import com.fkq.student.pojo.UserExample.Criteria;
import com.fkq.student.service.IUserService;
import com.fkq.student.util.UUIDUtil;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public boolean checkPhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andPhoneNumberEqualTo(phoneNumber);
		List<User> list = userMapper.selectByExample(example);
		if (list == null || list.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	public JsonResult getUserById(String id) {
		JsonResult result = new JsonResult();
		User user = userMapper.selectByPrimaryKey(id);
		if (user != null) {
			user.setHeadUrl(Constant.HEAD_PATH + user.getHeadUrl());
			result.setResult(true);
			result.setMsg(ConstantStr.user_info_success);
			result.setData(user);
		} else {
			result.setResult(false);
			result.setMsg(ConstantStr.user_info_fail);
			result.setData(null);
		}
		return result;
	}

	@Override
	public JsonResult regist(String phoneNumber, String password) {
		// TODO Auto-generated method stub
		JsonResult model = new JsonResult();
		// 检查手机号是否被注册
		if (!checkPhoneNumber(phoneNumber)) {
			User user = new User();
			user.setId(UUIDUtil.getUUid());
			// 默认添加手机号为用户名
			user.setUserName(phoneNumber);
			user.setPhoneNumber(phoneNumber);
			user.setPassword(password);
			user.setCreateDate(new Date());
			user.setUpdateDate(new Date());
			// 添加用户数据
			int count = userMapper.insert(user);
			if (count > 0) {
				model.setMsg(ConstantStr.add_success);
				model.setResult(true);
			} else {
				model.setResult(false);
				model.setMsg(ConstantStr.add_fail);
			}
		} else {
			model.setResult(false);
			model.setMsg(ConstantStr.add_successed);
		}
		return model;
	}

	@Override
	public JsonResult login(String phoneNumber, String password) {
		JsonResult model = new JsonResult();
		boolean result = checkPhoneNumber(phoneNumber);
		if (result) {
			UserExample example = new UserExample();
			Criteria criteria = example.createCriteria();
			criteria.andPhoneNumberEqualTo(phoneNumber);
			criteria.andPasswordEqualTo(password);
			List<User> list = userMapper.selectByExample(example);
			if (list != null && list.size() > 0) {
				model.setResult(true);
				model.setMsg(ConstantStr.login_success);
				model.setData(list.get(0));
			} else {
				model.setMsg(ConstantStr.login_fail);
			}
		} else {
			model.setResult(false);
			model.setMsg(ConstantStr.user_no_register);
		}
		return model;
	}

	@Override
	public JsonResult updateUser(User user) {
		JsonResult model = new JsonResult();
		int count = userMapper.updateByPrimaryKeySelective(user);
		if (count > 0) {
			model.setResult(true);
			model.setMsg("更新信息成功");
		} else {
			model.setResult(false);
			model.setMsg("更新信息失败");
		}
		return model;
	}

	@Override
	public JsonResult updatePwd(String phoneNumber, String password) {
		JsonResult model = new JsonResult();
		boolean result = checkPhoneNumber(phoneNumber);
		if (result) {
			UserExample example = new UserExample();
			Criteria criteria = example.createCriteria();
			criteria.andPhoneNumberEqualTo(phoneNumber);
			User user = new User();
			user.setPhoneNumber(phoneNumber);
			user.setPassword(password);
			int count = userMapper.updateByExampleSelective(user, example);
			if (count > 0) {
				model.setResult(true);
				model.setMsg(ConstantStr.update_pwd_success);
			} else {
				model.setResult(true);
				model.setMsg(ConstantStr.update_pwd_fail);
			}
		} else {
			model.setResult(false);
			model.setMsg(ConstantStr.user_no_register);
		}
		return model;
	}
}
