package com.example.vo;

import java.util.List;

/**
 * 
 * @author sdyang
 * @date 2015��7��13�� ����10:01:14
 */
public class ExcelFileInfoVO {
	/**
	 * ��¼��������
	 */
	private int columnCount;

	/**
	 * ����
	 */
	private String excelTitle;

	/**
	 * ��ͷ
	 */
	private List<String> excelHead;

	/**
	 * ����
	 */
	private List excelBody;

	/**
	 * ��ѯ��sql���
	 */
	private String sqlString;

	public int getColumnCount() {
		return columnCount;
	}

	public void setColumnCount(int columnCount) {
		this.columnCount = columnCount;
	}

	public String getExcelTitle() {
		return excelTitle;
	}

	public void setExcelTitle(String excelTitle) {
		this.excelTitle = excelTitle;
	}

	public List<String> getExcelHead() {
		return excelHead;
	}

	public void setExcelHead(List<String> excelHead) {
		this.excelHead = excelHead;
	}

	public List getExcelBody() {
		return excelBody;
	}

	public void setExcelBody(List excelBody) {
		this.excelBody = excelBody;
	}

	public String getSqlString() {
		return sqlString;
	}

	public void setSqlString(String sqlString) {
		this.sqlString = sqlString;
	}

}
