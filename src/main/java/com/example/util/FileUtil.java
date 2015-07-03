package com.example.util;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileUtil {
	
	private static Logger logger = LogManager.getLogger(FileUtil.class);
	
	public boolean checkParentFile(String filePath)
	{
		boolean result = false;
		
		File file = new File(filePath);
		if(!file.getParentFile().exists())
		{
			logger.trace("目录不存在，准备创建目录！");
			if(file.getParentFile().mkdirs())
			{
				logger.trace("成功创建目录！");
				result = true;
			}else
			{
				logger.error("创建目录失败！");
			}
		}else
		{
			result = true;
		}
		return result;
	}
	
	public void checkFile(String filePath)
	{
		File file = new File(filePath);
		if(file.exists())
		{
			logger.trace("文件已经存在，准备删除！");
			if(file.delete())
			{
				logger.trace("成功删除文件！");
			}else
			{
				logger.error("删除文件失败！");
			}
	    }
	}

}
