package cn.bdqn.document.service.emp;

import cn.bdqn.document.entity.Emp;

public class LoginResult {
	
	//登录成功
	public static final int LOGIN_SUCCESS=1;
	//由于用户名错误导致的登录失败
	public static final int INVALID_USER_NAME=-1;
	//由于密码错误导致的登录失败
	public static final int INVALID_PASSWORD=-2;
	
	//登录状态
	private int status;
	//员工
	private Emp emp;
	
	public LoginResult() {
		// TODO Auto-generated constructor stub
	}
	
	public LoginResult(int status, Emp emp) {
		super();
		this.status = status;
		this.emp = emp;
	}

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}

}
