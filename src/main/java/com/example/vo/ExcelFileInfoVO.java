package com.example.vo;

import java.util.List;
import java.util.Map;

public class ExcelFileInfoVO {
	private int columnCount = 0;//返回记录的列总数
	private int rowCount=0;
	private Map columnNames = null;//列名列表
	private List resultSet = null;//记录,每行数据是个Array
	private List resultHead= null;//记录表头
	
	private String resultString = "";
	

	public String getResultString() {
		return resultString;
	}

	public void setResultString(String resultString) {
		this.resultString = resultString;
	}

	public int getColumnCount() {
		return columnCount;
	}

	public void setColumnCount(int columnCount) {
		this.columnCount = columnCount;
	}
	public Map getColumnNames() {
		return columnNames;
	}
	public void setColumnNames(Map columnNames) {
		this.columnNames = columnNames;
	}
	
	public List getResultSet(){
		return this.resultSet;
	}
	public void setResultSet(List resultSet) {
		this.resultSet = resultSet;
	}
			
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public List getResultHead() {
		return resultHead;
	}
	public void setResultHead(List resultHead) {
		this.resultHead = resultHead;
	}
	
}

