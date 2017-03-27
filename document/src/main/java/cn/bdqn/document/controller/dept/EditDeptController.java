package cn.bdqn.document.controller.dept;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.bdqn.document.controller.BaseController;
import cn.bdqn.document.entity.Dept;
import cn.bdqn.document.form.DeptForm;
import cn.bdqn.document.util.Message;

@Controller
@RequestMapping("/background/dept")
public class EditDeptController extends BaseController{
	
	// /background/dept/edit_5.html
	@RequestMapping(value="edit_{id}",method=RequestMethod.GET)
	public ModelAndView doGet(@PathVariable Integer id){
		Dept dept=deptService.getDept(id);		
		return new ModelAndView("background/dept/edit").addObject("deptForm",new DeptForm(dept));		
	}
	
	@RequestMapping(value="edit_{id}",method=RequestMethod.POST)
	public String doPost(
		@Valid DeptForm deptForm,
		BindingResult br,
		ModelMap model
	){
		if(br.hasErrors()){
			return "background/dept/edit";
		}
		deptService.updateDept(deptForm);
		
		model.addAttribute("message",new Message(Message.SUCCESS,"部门修改成功","部门管理","dept"));		
		return "background/message";	
	}
	
	
}














