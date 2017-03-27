package cn.bdqn.document.service.document;

import cn.bdqn.document.entity.Document;
import cn.bdqn.document.util.Page;

public interface IDocumentService {

	public void saveDocument(Document document);
	
	public Page findDocument(int pageIndex,int pageSize,Integer scope,Integer eid,Integer did,Integer cid,String title);
}
