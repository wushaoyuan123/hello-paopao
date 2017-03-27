package cn.bdqn.document.controller.category;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.bdqn.document.controller.BaseController;
import cn.bdqn.document.entity.Category;
import cn.bdqn.document.entity.Dept;
import cn.bdqn.document.entity.Emp;
import cn.bdqn.document.form.CategorySearchForm;
import cn.bdqn.document.form.SwitchDeptForm;

@Controller
@RequestMapping("/background/category")
public class ListCategoryController extends BaseController{
	
	@ModelAttribute("depts")
	public List<Dept> getDeptList(){
		return deptService.findDept(null);
	}
	
	@ModelAttribute
	public SwitchDeptForm getSwitchDeptForm(){
		return new SwitchDeptForm();
	}
	
	
	@RequestMapping("index")
	public ModelAndView service(
		CategorySearchForm searchForm,
		SwitchDeptForm switchDeptForm,
		HttpSession session		
	){
		//获得session中的部门对象
		Dept dept=(Dept)session.getAttribute("dept");
		//设置切换部门表单的部门编号属性
		switchDeptForm.setDid(dept.getId());
		
		int scope=searchForm.getScope();
		//如果要查询部门范围
		if(scope==2){
			searchForm.setDid(dept.getId());
		}
		//如果要查询员工个人范围
		else if(scope==3){
			Emp emp=(Emp)session.getAttribute("emp");
			searchForm.setEid(emp.getId());
		}
		
		List<Category> categorys=categoryService.findCategory(searchForm);
				
		
		
		return new ModelAndView("background/category/index").addObject("categorys", categorys);
	}
	
	@RequestMapping("switch")
	public String switchDept(
		SwitchDeptForm switchDeptForm,
		HttpSession session
	){
		Dept dept=deptService.getDept(switchDeptForm.getDid());
		session.setAttribute("dept",dept);
		return "redirect:index.html?scope=2";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}






