package cn.bdqn.document.controller.emp;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.bdqn.document.controller.BaseController;
import cn.bdqn.document.entity.Dept;
import cn.bdqn.document.form.EmpForm;
import cn.bdqn.document.util.Message;

@Controller
@RequestMapping("/background/emp")
public class AddEmpController extends BaseController{

	@ModelAttribute
	public EmpForm getEmpForm(){
		return new EmpForm();
	}
	
	@ModelAttribute("depts")
	public List<Dept> getDetpList(){
		return deptService.findDept(null);
	}

	@RequestMapping(value="add",method=RequestMethod.GET)
	public String doGet(){
		return "background/emp/add";
	}
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String doPost(
		@Valid EmpForm empForm,
		BindingResult br,
		ModelMap model
	){
		if(br.hasErrors()){
			return "background/emp/add";
		}
		
		//设置默认密码
		empForm.setPassword("123456");
		//设置是否管理员
		empForm.setAdmin(false);
		//设置添加时间
		empForm.setAddTime(new Date());
		
		//保存员工
		empService.saveEmp(empForm);
		
		model.addAttribute("message",new Message(Message.SUCCESS,"员工添加成功","员工管理","emp"));		
		return "background/message";
	}
	
}










