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
			logger.trace("Ŀ¼�����ڣ�׼������Ŀ¼��");
			if(file.getParentFile().mkdirs())
			{
				logger.trace("�ɹ�����Ŀ¼��");
				result = true;
			}else
			{
				logger.error("����Ŀ¼ʧ�ܣ�");
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
			logger.trace("�ļ��Ѿ����ڣ�׼��ɾ����");
			if(file.delete())
			{
				logger.trace("�ɹ�ɾ���ļ���");
			}else
			{
				logger.error("ɾ���ļ�ʧ�ܣ�");
			}
	    }
	}

}
