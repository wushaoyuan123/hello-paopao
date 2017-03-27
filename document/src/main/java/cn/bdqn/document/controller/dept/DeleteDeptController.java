package cn.bdqn.document.controller.dept;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import cn.bdqn.document.controller.BaseController;
import cn.bdqn.document.util.Message;

@Controller
@RequestMapping("/background/dept")
public class DeleteDeptController extends BaseController{

	// /background/dept/delete_5.html
	@RequestMapping("delete_{id}")
	public String service(@PathVariable("id") Integer id,ModelMap model){
		//查询部门下属员工人数
		int empCount=empService.getEmpCount(id);
		if(empCount>0){
			Message message=new Message(Message.ERROR,"有关联的员工信息，无法删除部门","部门管理","dept");
			model.addAttribute("message",message);
			return "background/message";
		}
		
		
		deptService.deleteDept(id);
		
		
		model.addAttribute("message",new Message(Message.SUCCESS,"部门删除成功","部门管理","dept"));		
		return "background/message";
		
	}
	
}









