package cn.bdqn.document.controller.document;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import cn.bdqn.document.controller.BaseController;
import cn.bdqn.document.entity.Category;
import cn.bdqn.document.entity.Dept;
import cn.bdqn.document.entity.Emp;
import cn.bdqn.document.form.DocumentForm;

@Controller
@RequestMapping("/background/doc")
public class AddDocumentController extends BaseController{

	@RequestMapping(value="add",method=RequestMethod.GET)
	public String doGet(
		DocumentForm documentForm,
		HttpSession session,
		ModelMap modelMap
	){
		//根据指定的范围加载分类下拉列表
		Integer scope=documentForm.getScope();
		List<Category> categorys=null;
		
		//如果是公司范围
		if(scope==1){
			categorys=categoryService.findCategory(1, null, null, null);
		}
		//如果是部门范围
		else if(scope==2){
			Dept dept=(Dept)session.getAttribute("dept");
			categorys=categoryService.findCategory(2,dept.getId(),null,null);
		}
		//如果是个人范围
		else if(scope==3){
			Emp emp=(Emp)session.getAttribute("emp");
			categorys=categoryService.findCategory(3,null,emp.getId(),null);
		}
		modelMap.addAttribute("categorys", categorys);
		
		
		return "background/doc/add";
	}
	
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String doPost(
		@Valid DocumentForm documentForm,
		BindingResult br,
		HttpSession session
	)throws Exception{
		if(br.hasErrors()){
			return "background/doc/add";
		}
			
		//获得ServletContext
		ServletContext sc=session.getServletContext();
		//获得upload目录的绝对路径
		String uploadPath=sc.getRealPath("/WEB-INF/upload");
		
		MultipartFile upload=documentForm.getUpload();
		//获得原始文件名
		String fileName=upload.getOriginalFilename();
		//从原始文件名中获得文件后缀
		String ext=FilenameUtils.getExtension(fileName);
		//生成新文件名
		fileName=System.currentTimeMillis()+"."+ext;
		//转存文件
		upload.transferTo(new File(uploadPath, fileName));
		
		//补全数据
		documentForm.setFileName(fileName);
		documentForm.setLength((int)upload.getSize());
		documentForm.setAddTime(new Date());
		documentForm.setDel(false);
		
		Emp emp=(Emp)session.getAttribute("emp");
		documentForm.setEid(emp.getId());
		
		if(documentForm.getScope()==2){
			Dept dept=(Dept)session.getAttribute("dept");
			documentForm.setDid(dept.getId());
		}
		
		documentService.saveDocument(documentForm);
		
		return "redirect:../index.html";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}








