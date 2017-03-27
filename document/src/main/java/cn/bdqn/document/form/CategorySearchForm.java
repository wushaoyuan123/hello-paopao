package cn.bdqn.document.form;

import cn.bdqn.document.entity.Category;

public class CategorySearchForm extends Category{
	
	public CategorySearchForm() {
		//将分类范围初始化位员工个人分类
		this.setScope(3);
	}
}
