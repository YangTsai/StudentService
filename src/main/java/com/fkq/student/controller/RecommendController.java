package com.fkq.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fkq.student.pojo.JsonResult;
import com.fkq.student.service.IRecommendService;

/**
 * 
 * @description 推荐页
 * @author hyy
 * @date 2018年1月12日
 */

@RestController
@RequestMapping("/recommend")
public class RecommendController {
	
	@Autowired
	public IRecommendService iRecommendService;
	
	public JsonResult getRecommend() throws Exception{
		JsonResult result = new JsonResult();
		//获取图片文件
		List<String> filePath = iRecommendService.getBanner();
		
		return result;
	}

}
