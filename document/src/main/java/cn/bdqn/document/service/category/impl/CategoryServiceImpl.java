package cn.bdqn.document.service.category.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.bdqn.document.dao.category.ICategoryDAO;
import cn.bdqn.document.entity.Category;
import cn.bdqn.document.service.category.ICategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService{
	
	private ICategoryDAO categoryDAO;
	
	@Autowired
	public void setCategoryDAO(ICategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}
	
	@Override
	public void saveCategory(Category category) {
		categoryDAO.saveCategory(category);
	}
	
	@Override
	public List<Category> findCategory(Category category) {
		String name=category.getName();
		if(name!=null){
			name="%"+name+"%";			
		}
				
		return categoryDAO.findCategory(
			category.getScope(),
			category.getDid(),
			category.getEid(),
			name
		);
	}

	
	
	@Override
	public List<Category> findCategory(Integer scope, Integer did, Integer eid, String name) {
		return categoryDAO.findCategory(scope, did, eid, name);
	}
	
}






