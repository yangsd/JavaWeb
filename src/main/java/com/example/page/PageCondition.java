package com.example.page;

/**
 * ��ҳ��ѯ����
 * 
 * @author sdyang
 * @date 2015��7��7�� ����3:55:33
 */
public class PageCondition {

	private int currentPage;

	private int rows;

	private int offset;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getOffset() {
		return offset;
	}

	private void setOffset(int offset) {
		this.offset = offset;
	}
	
	/**
	 * ����ƫ����
	 * @author sdyang
	 * @date 2015��7��7�� ����4:03:18
	 */
	public void calculateOffset(){
		//ƫ���� = �� ��ǰҳ��  - 1 �� * ����
		this.setOffset((this.getCurrentPage() - 1 ) * this.getRows());
	}

}
