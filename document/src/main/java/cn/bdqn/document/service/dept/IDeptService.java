package cn.bdqn.document.service.dept;

import java.util.List;

import cn.bdqn.document.entity.Dept;

public interface IDeptService {

	//保存部门
	public void saveDept(Dept dept);
	
	//更新部门
	public void updateDept(Dept dept);
	
	//删除部门
	public void deleteDept(Integer id);
	
	//查询全部部门列表
	public List<Dept> findDept(String name);
	
	//根据ID获得单个部门
	public Dept getDept(Integer id);
	
	//获取按部门编号升序排序的第一个部门
	public Dept getFirstDept();
	
}
