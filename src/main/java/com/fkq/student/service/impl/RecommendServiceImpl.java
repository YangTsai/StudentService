package com.fkq.student.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fkq.student.constant.Constant;
import com.fkq.student.service.IRecommendService;

public class RecommendServiceImpl implements IRecommendService{

	@Override
	public List<String> getBanner() {
		// TODO Auto-generated method stub
		List<String> filePath = new ArrayList<String>();
		File file = new File(Constant.IMAGE_PATH_TEST);
		File[] files = file.listFiles();
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				if (files[i].getName().endsWith(".jpg") || files[i].getName().endsWith(".png")
						|| files[i].getName().endsWith(".gif")) {
					filePath.add(Constant.BANNER_PATH + files[i].getName());
				}
			}
		}
		return filePath;
	}

	@Override
	public List<String> getStudyInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getTeacherList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getVideoList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getInformationList() {
		// TODO Auto-generated method stub
		return null;
	}

}
