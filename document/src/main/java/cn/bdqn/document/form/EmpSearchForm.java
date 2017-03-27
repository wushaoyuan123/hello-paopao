package cn.bdqn.document.form;

import cn.bdqn.document.entity.Emp;

public class EmpSearchForm extends Emp{
	
	private int pageIndex=1;
	private int pageSize=2;
	
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
	
	

}
