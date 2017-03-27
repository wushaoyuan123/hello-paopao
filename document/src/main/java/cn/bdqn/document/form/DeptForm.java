package cn.bdqn.document.form;

import org.hibernate.validator.constraints.NotBlank;

import cn.bdqn.document.entity.Dept;

public class DeptForm extends Dept{
	
	public DeptForm() {
		// TODO Auto-generated constructor stub
	}
	
	public DeptForm(Dept dept) {
		this.setId(dept.getId());
		this.setName(dept.getName());
	}
	
	
	@NotBlank
	@Override
	public String getName() {	
		return super.getName();
	}
	
}
