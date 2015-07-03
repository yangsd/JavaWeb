package com.example.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.vo.ExcelFileInfoVO;

/**
 * 
 * @author sdyang
 * @date 2015��7��3�� ����4:38:12
 */
public class ExcelUtils {

	private static Logger logger = LogManager.getLogger(ExcelUtils.class);

	public void writeData(String fileName, ExcelFileInfoVO complexReportRs) {
		XSSFCell cell = null;

		FileUtil fileUtil = new FileUtil();
		FileOutputStream fileout = null;

		Workbook wb = new XSSFWorkbook();

		Row row = null;

		CreationHelper createHelper = wb.getCreationHelper();

		Sheet sheet1 = wb.createSheet("SQL Results");

		// str����Ϊ��ѯ��sql���
		String str = complexReportRs.getResultString();
		// resultHeadΪExcel�ļ��ı�ͷ
		List resultHead = complexReportRs.getResultHead();
		// resultSetΪExcel�ļ��ı���
		List resultSet = complexReportRs.getResultSet();

		int rowCount = resultSet.size();
		int columnCount = complexReportRs.getColumnCount();

		// ����Excel�ļ���ͷ��������һ�еı���
		row = sheet1.createRow((short) 0);
		for (int i = 0; i < columnCount; i++) {
			String data = (String) resultHead.get(i);
			row.createCell(i).setCellValue(
					createHelper.createRichTextString(data));
		}

		// ����Excel�ļ��ı��壬�ò���Ϊ��ѯ�Ľ��
		for (int i = 0; i < rowCount; i++) {

			String[] data = (String[]) resultSet.get(i);

			row = sheet1.createRow((short) i + 1);
			for (int k = 0; k < columnCount; k++) {

				// cell = (XSSFCell)row.createCell(k);
				// cell.setCellValue(data[k]);
				// cell.setCellType(XSSFCell.CELL_TYPE_NUMERIC);

				row.createCell(k).setCellValue(
						createHelper.createRichTextString(data[k]));
			}
		}

		try {
			if (fileUtil.checkParentFile(fileName)) {
				fileUtil.checkFile(fileName);

				fileout = new FileOutputStream(fileName);

			} else {
				logger.error("�����ļ���" + fileName + "ʧ�ܣ�");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			wb.write(fileout);
		} catch (IOException e) {

			e.printStackTrace();
		}
		try {
			fileout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("�ɹ�����Excel�ļ���" + fileName);
	}

}
