package com.example.page;

import java.util.List;

/**
 * 
 * @author sdyang
 * @date 2015��7��2�� ����4:23:57
 */
public class PageResult {

	private int total;

	private List<?> rows;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}
