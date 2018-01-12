package com.fkq.student.service;

import java.util.List;

public interface IRecommendService {
	
	/**
	 * 获取banner图片
	 */
	public List<String> getBanner();
	
	
	/**
	 * 获取学习账单
	 */
	public List<String> getStudyInfo();
	
	/**
	 * 获取教师列表
	 */
	public List<String> getTeacherList();
	
	/**
	 * 获取视频列表
	 */
	public List<String> getVideoList();
	
	/**
	 * 获取资讯列表
	 */
	public List<String> getInformationList();

}
