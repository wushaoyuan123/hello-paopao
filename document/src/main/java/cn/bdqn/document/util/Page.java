package cn.bdqn.document.util;

import java.util.List;

public class Page {

	private int pageIndex;

	private int pageSize;

	private int rowCount;

	private int pageCount;

	private List results;
	
	public Page() {
		// TODO Auto-generated constructor stub
	}
	
	public Page(int pageIndex, int pageSize, int rowCount, int pageCount,
			List results) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.rowCount = rowCount;
		this.pageCount = pageCount;
		this.results = results;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public List getResults() {
		return results;
	}

	public void setResults(List results) {
		this.results = results;
	}
	
	
	
	
	
	
	

}










