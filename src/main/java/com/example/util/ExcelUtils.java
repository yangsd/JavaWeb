package com.example.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;

import com.example.exception.BusinessException;
import com.example.vo.ExcelFileInfoVO;

/**
 * 
 * @author sdyang
 * @date 2015��7��3�� ����4:38:12
 */
public class ExcelUtils {

	private static Logger logger = LogManager.getLogger(ExcelUtils.class);

	/**
	 * 
	 * @author sdyang
	 * @date 2015��7��16�� ����9:44:49
	 * @param excelVO
	 * @return
	 */
	public static HSSFWorkbook writeData(ExcelFileInfoVO excelVO) throws BusinessException{

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

	/**
	 * 
	 * @author sdyang
	 * @date 2015��7��16�� ����9:44:32
	 * @param in
	 * @return
	 * @throws BusinessException
	 */
	public static Map<Integer, List<String>> readData(InputStream in)
			throws BusinessException {
		POIFSFileSystem fs;
		HSSFWorkbook wb = null;
		HSSFSheet sheet;
		HSSFRow row;
		Map<Integer, List<String>> content = new HashMap<Integer, List<String>>();
		List<String> rowData = null;

		try {
			fs = new POIFSFileSystem(in);
			wb = new HSSFWorkbook(fs);
		} catch (IOException e) {
			e.printStackTrace();
			throw new BusinessException(e.toString());
		}
		sheet = wb.getSheetAt(0);
		// �õ�������
		int rowNum = sheet.getLastRowNum();
		row = sheet.getRow(0);
		int colNum = row.getPhysicalNumberOfCells();
		// ��������Ӧ�ôӵڶ��п�ʼ,��һ��Ϊ��ͷ�ı���
		for (int i = 1; i <= rowNum; i++) {
			rowData = new ArrayList<String>();
			row = sheet.getRow(i);
			int j = 0;
			while (j < colNum) {
				rowData.add(row.getCell((short) j).toString());
				j++;
			}
			content.put(i, rowData);
		}

		readMap(content);
		
		return content;
	}

	private static void readMap(Map<Integer, List<String>> content) {
		String str = "";
		for (Integer key : content.keySet()) {

			for (int i = 0; i < content.get(key).size(); i++) {
				str = str + content.get(key).get(i).toString() + "  ";
			}
			System.out.println("key= " + key + " and value= " + str);
			str = "";
		}
	}

}
