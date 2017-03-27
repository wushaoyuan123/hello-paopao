package cn.bdqn.document.controller;

import org.springframework.beans.factory.annotation.Autowired;

import cn.bdqn.document.service.category.ICategoryService;
import cn.bdqn.document.service.dept.IDeptService;
import cn.bdqn.document.service.document.IDocumentService;
import cn.bdqn.document.service.emp.IEmpService;

public class BaseController {

	protected IEmpService empService;
	protected IDeptService deptService;
	protected ICategoryService categoryService;
	protected IDocumentService documentService;
	
	@Autowired
	public void setEmpService(IEmpService empService) {
		this.empService = empService;
	}
	@Autowired
	public void setDeptService(IDeptService deptService) {
		this.deptService = deptService;
	}
	@Autowired
	public void setCategoryService(ICategoryService categoryService) {
		this.categoryService = categoryService;
	}
	@Autowired
	public void setDocumentService(IDocumentService documentService) {
		this.documentService = documentService;
	}
}
