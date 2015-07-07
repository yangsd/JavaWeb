package com.example.page;

/**
 * 分页查询条件
 * 
 * @author sdyang
 * @date 2015年7月7日 下午3:55:33
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
	 * 计算偏移量
	 * @author sdyang
	 * @date 2015年7月7日 下午4:03:18
	 */
	public void calculateOffset(){
		//偏移量 = （ 当前页数  - 1 ） * 行数
		this.setOffset((this.getCurrentPage() - 1 ) * this.getRows());
	}

}
