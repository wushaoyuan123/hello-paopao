package cn.bdqn.document.controller.emp;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.bdqn.document.controller.BaseController;
import cn.bdqn.document.entity.Dept;
import cn.bdqn.document.form.EmpSearchForm;
import cn.bdqn.document.util.Page;

@Controller
@RequestMapping("/background/emp")
public class ListEmpController extends BaseController{

	@ModelAttribute("depts")
	public List<Dept> getDepts(){
		return deptService.findDept(null);
	}
	
	
	@RequestMapping("index")
	public ModelAndView service(EmpSearchForm searchForm){
		
		Page page=empService.findEmp(
			searchForm.getPageIndex(), 
			searchForm.getPageSize(), 
			searchForm.getDid(), 
			searchForm.getRealName()
		);
		
		
		
		return new ModelAndView("background/emp/index").addObject("p",page);
	}
	
}











