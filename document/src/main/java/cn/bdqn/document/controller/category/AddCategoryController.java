package cn.bdqn.document.controller.category;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.bdqn.document.controller.BaseController;
import cn.bdqn.document.entity.Dept;
import cn.bdqn.document.entity.Emp;
import cn.bdqn.document.form.CategoryForm;
import cn.bdqn.document.util.Message;

@Controller
@RequestMapping("/background/category")
public class AddCategoryController extends BaseController{

	@RequestMapping(value="add",method=RequestMethod.GET)
	public String doGet(CategoryForm categoryForm,HttpSession session){
		//获得范围编号
		int scope=categoryForm.getScope();
		//如果编号为2，说明要为部门添加分类
		if(scope==2){
			//从session中获取部门对象
			Dept dept=(Dept)session.getAttribute("dept");
			categoryForm.setDid(dept.getId());
		}
		//如果编号为3，说明要为员工添加分类
		if(scope==3){
			//从session中获取员工
			Emp emp=(Emp)session.getAttribute("emp");
			categoryForm.setEid(emp.getId());
		}
		
		
		
		return "background/category/add";
	}
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String doPost(
		@Valid 	CategoryForm categoryForm,
		BindingResult br,
		ModelMap model
	){
		if(br.hasErrors()){
			return "background/category/add";
		}
		categoryService.saveCategory(categoryForm);
		
		model.addAttribute("message",new Message(Message.SUCCESS,"分类添加成功","分类管理","category"));		
		return "background/message";
	}
}










