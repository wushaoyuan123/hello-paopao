package cn.bdqn.document.form;

import org.hibernate.validator.constraints.NotBlank;

import cn.bdqn.document.entity.Emp;

public class LoginForm extends Emp{
	
	private String vcode;
	
	
	@NotBlank
	@Override
	public String getUserName() {
		return super.getUserName();
	}
	
	@NotBlank
	@Override
	public String getPassword() {	
		return super.getPassword();
	}
	
	@NotBlank
	public String getVcode() {
		return vcode;
	}
	public void setVcode(String vcode) {
		this.vcode = vcode;
	}
	

}
