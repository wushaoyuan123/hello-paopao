package cn.bdqn.document.controller.emp;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.bdqn.document.controller.BaseController;
import cn.bdqn.document.entity.Dept;
import cn.bdqn.document.entity.Emp;
import cn.bdqn.document.form.EmpForm;
import cn.bdqn.document.util.Message;

@Controller
@RequestMapping("/background/emp")
public class EditEmpController extends BaseController{

	@ModelAttribute("depts")
	public List<Dept> getDetpList(){
		return deptService.findDept(null);
	}
	
	//edit_1.html
	@RequestMapping(value="edit_{id}",method=RequestMethod.GET)
	public ModelAndView doGet(@PathVariable("id") Integer id){
		Emp emp=empService.getEmpById(id);
		EmpForm empForm=new EmpForm(emp);
		return new ModelAndView("background/emp/edit").addObject("empForm",empForm);
	}
	
	@RequestMapping(value="edit_{id}",method=RequestMethod.POST)
	public String doPost(
		@Valid EmpForm empForm,
		BindingResult br,
		ModelMap model
		
	){
		if(br.hasErrors()){
			return "background/emp/edit";
		}
		
		empService.updateEmp(empForm);
		
		model.addAttribute("message",new Message(Message.SUCCESS,"员工修改成功","员工管理","emp"));		
		return "background/message";
	}
	
	
	
	
	
}










