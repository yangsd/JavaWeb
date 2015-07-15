package com.example.vo;

import java.util.List;

/**
 * 
 * @author sdyang
 * @date 2015年7月13日 上午10:01:14
 */
public class ExcelFileInfoVO {
	/**
	 * 记录的列总数
	 */
	private int columnCount;

	/**
	 * 标题
	 */
	private String excelTitle;

	/**
	 * 表头
	 */
	private List<String> excelHead;

	/**
	 * 表体
	 */
	private List excelBody;

	/**
	 * 查询的sql语句
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
