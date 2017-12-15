package com.fkq.student.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import com.fkq.student.constant.Constant;

/**
 * 
 * @author ASUS
 *
 */

public class FileUtil {

	/**
	 * 获取Banner图片
	 * 
	 * @return
	 */
	public static List<String> getBannerImages() {
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
}
