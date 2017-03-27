package cn.bdqn.document.form;

import java.util.Arrays;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.ArrayUtils;
import org.hibernate.validator.constraints.NotBlank;

import cn.bdqn.document.entity.Emp;
import cn.bdqn.document.util.ArrayUtil;

public class EmpForm extends Emp{

	public EmpForm() {
		// TODO Auto-generated constructor stub
	}
	
	public EmpForm(Emp emp) {
		this.setId(emp.getId());
		this.setDid(emp.getDid());
		this.setUserName(emp.getUserName());
		this.setRealName(emp.getRealName());
		this.sysPrivsArray=ArrayUtil.toArray(emp.getSysPrivs());
		this.catPrivsArray=ArrayUtil.toArray(emp.getCatPrivs());
		this.docPrivsArray=ArrayUtil.toArray(emp.getDocPrivs());		
	}

	private Integer[] sysPrivsArray;
	private Integer[] catPrivsArray;
	private Integer[] docPrivsArray;
	
	public Integer[] getSysPrivsArray() {
		return sysPrivsArray;
	}
	public void setSysPrivsArray(Integer[] sysPrivsArray) {
		this.sysPrivsArray = sysPrivsArray;
		this.setSysPrivs(ArrayUtil.toString(sysPrivsArray));
	}
	
	public Integer[] getCatPrivsArray() {
		return catPrivsArray;
	}
	public void setCatPrivsArray(Integer[] catPrivsArray) {
		this.catPrivsArray = catPrivsArray;
		this.setCatPrivs(ArrayUtil.toString(catPrivsArray));
	}
	
	public Integer[] getDocPrivsArray() {
		return docPrivsArray;
	}
	public void setDocPrivsArray(Integer[] docPrivsArray) {
		this.docPrivsArray = docPrivsArray;
		this.setDocPrivs(ArrayUtil.toString(docPrivsArray));
	}
	
	
	@NotNull
	@Override
	public Integer getDid() {		
		return super.getDid();
	}
	
	@NotBlank
	@Override
	public String getUserName() {	
		return super.getUserName();
	}
	
	@NotBlank
	@Override
	public String getRealName() {
		return super.getRealName();
	}

	
}




