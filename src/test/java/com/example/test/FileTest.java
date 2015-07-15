package com.example.test;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

public class FileTest {

	public static void main(String[] args) throws IOException {
		
		Workbook wb = new HSSFWorkbook();
	    FileOutputStream fileOut = new FileOutputStream("src/main/webapp/file/workbook.xls");
	    wb.write(fileOut);
	    fileOut.close();
	    
//		FileUtil util = new FileUtil();
//		util.checkParentFile("src/main/webapp/file/¶ÌÐÅ·¢ËÍ¼à¿Ø.xls");
//		util.checkFile("src/main/webapp/file/¶ÌÐÅ·¢ËÍ¼à¿Ø.xls");
	}

}
