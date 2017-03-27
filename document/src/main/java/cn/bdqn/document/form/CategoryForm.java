package cn.bdqn.document.form;

import org.hibernate.validator.constraints.NotBlank;

import cn.bdqn.document.entity.Category;

public class CategoryForm extends Category{

	@NotBlank
	@Override
	public String getName() {	
		return super.getName();
	}
	
}
