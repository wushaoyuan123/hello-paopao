package cn.bdqn.document.service.dept.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.bdqn.document.dao.dept.IDeptDAO;
import cn.bdqn.document.entity.Dept;
import cn.bdqn.document.service.dept.IDeptService;

@Service
@Transactional
public class DeptServiceImpl implements IDeptService{

	private IDeptDAO deptDAO;
	
	@Autowired
	public void setDeptDAO(IDeptDAO deptDAO) {
		this.deptDAO = deptDAO;
	}
	
	@Override
	public void saveDept(Dept dept) {
		deptDAO.saveDept(dept);
	}

	@Override
	public void updateDept(Dept dept) {
		deptDAO.updateDept(dept);
	}

	@Override
	public void deleteDept(Integer id) {
		deptDAO.deleteDept(id);
	}

	@Override
	public List<Dept> findDept(String name) {
		if(name!=null){
			name="%"+name+"%";
		}
		return deptDAO.findDept(name);
	}

	@Override
	public Dept getDept(Integer id) {
		return deptDAO.getDept(id);
	}

	
	@Override
	public Dept getFirstDept() {
		return deptDAO.getFirstDept();
	}
	
	
	
}
