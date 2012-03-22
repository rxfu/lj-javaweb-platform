package com.pl.common.util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class FileUploadUtil {
	/**
	 * 将file更名保存到uploads文件夹后，返回更改后的文件名
	 * @param file
	 * @return 更改后的文件名
	 * @throws Exception
	 */
	public String saveFile(File file,String oldFileName) throws Exception{
		String root = ServletActionContext.getServletContext().getRealPath("/uploads");
		String suffix = oldFileName.substring(oldFileName.indexOf("."),oldFileName.length());
		String destDirFileName = IDFactory.getId()+suffix;
		File destFile = new File(root+"/"+destDirFileName);
		FileUtils.copyFile(file, destFile);
		return destDirFileName;
	}
}
