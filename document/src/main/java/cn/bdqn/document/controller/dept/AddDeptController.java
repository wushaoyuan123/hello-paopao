package cn.bdqn.document.controller.dept;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.bdqn.document.controller.BaseController;
import cn.bdqn.document.form.DeptForm;
import cn.bdqn.document.util.Message;

@Controller
@RequestMapping("/background/dept")
public class AddDeptController extends BaseController{

	@ModelAttribute
	public DeptForm getDeptForm(){
		return new DeptForm();
	}
	
	@RequestMapping(value="add",method=RequestMethod.GET)
	public String doGet(){
		return "background/dept/add";
	}
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String doPost(
		@Valid DeptForm deptForm,
		BindingResult br,
		ModelMap model
	){
		if(br.hasErrors()){
			return "background/dept/add";
		}
		deptService.saveDept(deptForm);
		
		model.addAttribute("message",new Message(Message.SUCCESS,"部门添加成功","部门管理","dept"));		
		return "background/message";
	}
	
	
	
	
	
	
	
	
	
	
}
