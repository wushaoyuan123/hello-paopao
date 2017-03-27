package cn.bdqn.document.dao.category;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.bdqn.document.entity.Category;

public interface ICategoryDAO {

	public void saveCategory(Category category);
	
	public List<Category> findCategory(
		@Param("scope")Integer scope,
		@Param("did")Integer did,
		@Param("eid")Integer eid,
		@Param("name")String name
	);
}
