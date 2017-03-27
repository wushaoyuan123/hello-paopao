package cn.bdqn.document.service.emp;

import org.apache.ibatis.annotations.Param;

import cn.bdqn.document.entity.Emp;
import cn.bdqn.document.util.Page;

public interface IEmpService {
	
	//员工登录
	public LoginResult login(String userName,String password);

	//保存员工
	public void saveEmp(Emp emp);
	
	//分页查询员工
	public Page findEmp(int pageIndex,int pageSize,Integer did,String realName);
	
	//根据id获得单个员工
	public Emp getEmpById(Integer id);
	
	//更新员工
	public void updateEmp(Emp emp);
	
	//删除员工
	public void deleteEmp(Integer id);
	
	//重置密码
	public void updatePassword(Integer id,String password);
	
	//根据部门编号查询员工数量
	public int getEmpCount(Integer did);
	
}







