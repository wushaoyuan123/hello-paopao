package cn.bdqn.document.controller.emp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.bdqn.document.controller.BaseController;
import cn.bdqn.document.util.Message;

@Controller
@RequestMapping("/background/emp")
public class ResetPasswordController extends BaseController{
	
	//reset_2.html
	@RequestMapping("reset_{id}")
	public String doGet(@PathVariable("id") Integer id,ModelMap model){
		empService.updatePassword(id,"123456");
		
		model.addAttribute("message",new Message(Message.SUCCESS,"密码重置成功","员工管理","emp"));		
		return "background/message";		
	}

}











