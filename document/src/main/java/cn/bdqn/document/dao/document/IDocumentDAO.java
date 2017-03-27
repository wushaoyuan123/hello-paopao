package cn.bdqn.document.dao.document;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.bdqn.document.entity.Document;
import cn.bdqn.mybatis.plugin.PageParam;

public interface IDocumentDAO {
	
	public void saveDocument(Document document);
	
	public List<Document> findDocument(
		@Param("pageParam") PageParam param,
		@Param("scope") Integer scope,
		@Param("eid") Integer eid,
		@Param("did") Integer did,
		@Param("cid") Integer cid,
		@Param("title") String title
	);
}







