package com.example.vo;

import java.util.List;
import java.util.Map;

public class ExcelFileInfoVO {
	private int columnCount = 0;//���ؼ�¼��������
	private int rowCount=0;
	private Map columnNames = null;//�����б�
	private List resultSet = null;//��¼,ÿ�������Ǹ�Array
	private List resultHead= null;//��¼��ͷ
	
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

