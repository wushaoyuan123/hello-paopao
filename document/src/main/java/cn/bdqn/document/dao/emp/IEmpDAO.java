package cn.bdqn.document.dao.emp;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.bdqn.document.entity.Emp;
import cn.bdqn.mybatis.plugin.PageParam;

public interface IEmpDAO {
	
	//根据用户名获取单个用户对象
	public Emp getEmp(String userName);
	
	//根据id获得单个员工
	public Emp getEmpById(Integer id);
	
	//保存员工
	public void saveEmp(Emp emp);
	
	//更新员工
	public void updateEmp(Emp emp);
	
	//删除员工
	public void deleteEmp(Integer id);
	
	//分页查询员工列表
	public List<Emp> findEmp(
		@Param("pageParam") PageParam param,
		@Param("did") Integer did,
		@Param("realName") String realName
	);
	
	//重置密码
	public void updatePassword(
		@Param("id") Integer id,
		@Param("password") String password,
		@Param("salt") String salt
	);
	
	//根据部门编号查询员工数量
	public int getEmpCount(Integer did);
	
}









