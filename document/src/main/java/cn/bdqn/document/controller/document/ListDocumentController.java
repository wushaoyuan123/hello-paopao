package cn.bdqn.document.controller.document;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.bdqn.document.controller.BaseController;
import cn.bdqn.document.entity.Dept;
import cn.bdqn.document.entity.Emp;
import cn.bdqn.document.form.DocumentSearchForm;
import cn.bdqn.document.util.Page;

@Controller
@RequestMapping("/background/doc")
public class ListDocumentController extends BaseController{

	@RequestMapping("index")
	public String service(DocumentSearchForm searchForm,ModelMap model,HttpSession session){
		
		Page page=null;
		Integer scope=searchForm.getScope();
		if(scope==1){
			page=documentService.findDocument(searchForm.getPageIndex(),2,scope,null,null,searchForm.getCid(),searchForm.getTitle());
		}
		if(scope==2){
			Dept dept=(Dept)session.getAttribute("dept");		
			page=documentService.findDocument(searchForm.getPageIndex(),2,scope,null,dept.getId(),searchForm.getCid(),searchForm.getTitle());
		}		
		if(scope==3){
			Emp emp=(Emp)session.getAttribute("emp");
			page=documentService.findDocument(searchForm.getPageIndex(),2,scope,emp.getId(),null,searchForm.getCid(),searchForm.getTitle());
		}
		
		model.addAttribute("p",page);
		
		return "background/doc/index";
	}
	
	
	
}
