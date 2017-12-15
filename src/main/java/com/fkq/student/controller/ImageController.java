package com.fkq.student.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fkq.student.pojo.JsonResult;
import com.fkq.student.util.FileUtil;


/**
 * 
 * @description 图片相关接口
 * @author hyy
 * @date 2017年12月4日
 */

@Controller
@RequestMapping("/images")
public class ImageController {

	@RequestMapping(value = "/getBanner", method = RequestMethod.GET)
	public @ResponseBody JsonResult getBanner(HttpServletRequest request, Model model) {
		JsonResult baseModel = new JsonResult();
		List<String>  pathList = FileUtil.getBannerImages();
		if(pathList !=null && pathList.size()>0) {
			baseModel.setResult(true);
			baseModel.setMsg("OK");
		}else {
			baseModel.setResult(false);
			baseModel.setMsg("没有图片");
		}
		baseModel.setData(pathList);
		return baseModel;
	}
}
