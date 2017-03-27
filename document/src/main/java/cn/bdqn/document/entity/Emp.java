package cn.bdqn.document.entity;

import java.util.Date;

public class Emp {
	
	//员工编号
	private Integer id;
	//部门编号
	private Integer did;
	//部门名称
	private String dname;	
	//用户名
	private String userName;
	//密码
	private String password;
	//盐
	private String salt;
	//真实姓名
	private String realName;
	//系统权限
	private String sysPrivs;
	//分类权限
	private String catPrivs;
	//文档权限
	private String docPrivs;
	//添加日期
	private Date addTime;
	//是否管理员
	private Boolean admin;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getSysPrivs() {
		return sysPrivs;
	}
	public void setSysPrivs(String sysPrivs) {
		this.sysPrivs = sysPrivs;
	}
	public String getCatPrivs() {
		return catPrivs;
	}
	public void setCatPrivs(String catPrivs) {
		this.catPrivs = catPrivs;
	}
	public String getDocPrivs() {
		return docPrivs;
	}
	public void setDocPrivs(String docPrivs) {
		this.docPrivs = docPrivs;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
