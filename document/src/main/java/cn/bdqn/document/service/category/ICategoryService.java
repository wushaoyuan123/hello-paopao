package cn.bdqn.document.service.category;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.bdqn.document.entity.Category;

public interface ICategoryService {

	public void saveCategory(Category category);
	
	public List<Category> findCategory(Category category);
	
	public List<Category> findCategory(
		Integer scope,
		Integer did,
		Integer eid,
		String name
	);
}
