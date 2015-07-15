package com.example.util;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;

import com.example.vo.ExcelFileInfoVO;

/**
 * 
 * @author sdyang
 * @date 2015��7��3�� ����4:38:12
 */
public class ExcelUtils {

	private static Logger logger = LogManager.getLogger(ExcelUtils.class);

	public HSSFWorkbook getData(ExcelFileInfoVO excelVO) {

		List<String> excelHead = excelVO.getExcelHead();

		List excelBody = excelVO.getExcelBody();

		HSSFWorkbook wb = new HSSFWorkbook();

		Row row = null;

		CreationHelper createHelper = wb.getCreationHelper();
		
		HSSFSheet sheet1 = wb.createSheet("SQL Results");  

		// str����Ϊ��ѯ��sql��� String sql = excelVO.getSqlString();

		int rowCount = excelBody.size();
		int columnCount = excelVO.getColumnCount();

		// ����Excel�ļ���ͷ��������һ��Ϊ����
		row = sheet1.createRow((short) 0);
		for (int i = 0; i < columnCount; i++) {
			String data = (String) excelHead.get(i);
			row.createCell(i).setCellValue(
					createHelper.createRichTextString(data));
		}

		// ����Excel�ļ��ı��壬�ò���Ϊ��ѯ�Ľ��
		for (int i = 0; i < rowCount; i++) {

			List data = (List) excelBody.get(i);

			row = sheet1.createRow((short) i + 1);
			for (int k = 0; k < columnCount; k++) {

				// cell = (XSSFCell)row.createCell(k); //
				// cell.setCellValue(data[k]);
				// cell.setCellType(XSSFCell.CELL_TYPE_NUMERIC);

				row.createCell(k).setCellValue(
						createHelper.createRichTextString(data.get(k)
								.toString()));
			}
		}
		
		return wb;

	}

	
}
