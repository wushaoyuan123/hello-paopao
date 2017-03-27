package cn.bdqn.document.service.document;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.bdqn.document.dao.document.IDocumentDAO;
import cn.bdqn.document.entity.Document;
import cn.bdqn.document.util.Page;
import cn.bdqn.mybatis.plugin.PageParam;

@Service("documentService")
@Transactional
public class DocumentServiceImpl implements IDocumentService {
	
	private IDocumentDAO documentDAO;
	
	@Autowired
	public void setDocumentDAO(IDocumentDAO documentDAO) {
		this.documentDAO = documentDAO;
	}
	
	
	@Override
	public void saveDocument(Document document) {
		documentDAO.saveDocument(document);
	}

	@Override
	public Page findDocument(int pageIndex, int pageSize,Integer scope,Integer eid,Integer did,Integer cid, String title) {
		PageParam param=new PageParam(pageIndex, pageSize);
		if(title!=null){
			title="%"+title+"%";
		}
		List<Document> results=documentDAO.findDocument(param,scope,eid,did,cid,title);
		
		return new Page(pageIndex, pageSize, param.getRowCount(),param.getPageCount(), results);
	}
}












