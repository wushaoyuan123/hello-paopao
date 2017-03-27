package cn.bdqn.document.service.emp.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcwleud.encrypt.MD5Util;

import cn.bdqn.document.dao.emp.IEmpDAO;
import cn.bdqn.document.entity.Emp;
import cn.bdqn.document.service.emp.IEmpService;
import cn.bdqn.document.service.emp.LoginResult;
import cn.bdqn.document.util.Page;
import cn.bdqn.document.util.PasswordUtil;
import cn.bdqn.mybatis.plugin.PageParam;

@Service
@Transactional
public class EmpServiceImpl implements IEmpService{
	
	private IEmpDAO empDAO;
	
	@Autowired
	public void setEmpDAO(IEmpDAO empDAO) {
		this.empDAO = empDAO;
	}
	
	
	@Override
	public LoginResult login(String userName, String password) {
		Emp emp=empDAO.getEmp(userName);		
		if(emp==null){
			return new LoginResult(LoginResult.INVALID_USER_NAME,null);
		}
		else{
			//为用户提交的密码添加盐
			password=PasswordUtil.addSalt(password,emp.getSalt());
			//为用户提交的密码生成MD5
			password=MD5Util.stringToMD5(password,2);
			
			if(!password.equals(emp.getPassword())){
				return new LoginResult(LoginResult.INVALID_PASSWORD,null);
			}
			else{
				return new LoginResult(LoginResult.LOGIN_SUCCESS,emp);
			}
		}
	}

	@Override
	public void saveEmp(Emp emp) {
		//获得密码
		String password=emp.getPassword();
		//生成“盐”
		String salt=PasswordUtil.getSalt();
		//为密码添加盐
		password=PasswordUtil.addSalt(password, salt);
		//生成MD5
		password=MD5Util.stringToMD5(password, 2);
		//更新属性
		emp.setPassword(password);
		emp.setSalt(salt);
		
		empDAO.saveEmp(emp);
		
	}
	
	@Override
	public Page findEmp(int pageIndex, int pageSize, Integer did, String realName) {
		PageParam param=new PageParam(pageIndex, pageSize);
		if(realName!=null){
			realName="%"+realName+"%";
		}		
		List<Emp> results=empDAO.findEmp(param, did, realName);
		
		return new Page(pageIndex, pageSize, param.getRowCount(),param.getPageCount(), results);
	}
	
	@Override
	public Emp getEmpById(Integer id) {
		return empDAO.getEmpById(id);
	}
	
	@Override
	public void updateEmp(Emp emp) {
		empDAO.updateEmp(emp);
	}
	
	@Override
	public void deleteEmp(Integer id) {
		empDAO.deleteEmp(id);
	}
	
	@Override
	public void updatePassword(Integer id, String password) {
		//重新生成“盐”
		String salt=PasswordUtil.getSalt();
		//为密码添加“盐”
		password=PasswordUtil.addSalt(password, salt);
		//为密码生成MD5
		password=MD5Util.stringToMD5(password, 2);
		
		empDAO.updatePassword(id, password, salt);
		
	}
	
	@Override
	public int getEmpCount(Integer did) {
		return empDAO.getEmpCount(did);
	}
}










