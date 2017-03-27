package cn.bdqn.document.controller.emp;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.code.kaptcha.Constants;

import cn.bdqn.document.controller.BaseController;
import cn.bdqn.document.entity.Dept;
import cn.bdqn.document.entity.Emp;
import cn.bdqn.document.form.LoginForm;
import cn.bdqn.document.service.emp.LoginResult;

@Controller
@RequestMapping("/")
public class LoginController extends BaseController {
	
	//将LoginForm对象添加到数据模型，属性名为"loginForm"
	@ModelAttribute
	public LoginForm getLoginForm(){
		return new LoginForm();
	}
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String doGet(){
		return "login";
	}
	
	
	/*
	 在准备调用doPost()方法的时候，先根据参数LoginForm类型转换出属性名"loginForm"
	 根据属性名在数据模型中查找是否有对应的对象
	 如果找到对应对象，就使用模型中的对象接收数据，并传递给方法参数
	 如果在数据模型中没有找到对应的对象，则创建新对象，接收数据，并存入数据模型，再传递给方法参数 	 
	 * */	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String doPost(
		@Valid LoginForm loginForm,
		BindingResult br,
		HttpSession session
	){
		String vcode=loginForm.getVcode();
		if(vcode!=null && !vcode.equals("")){
			//从session中获得正确的验证码
			String correctVcode=(String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
			if(!vcode.equals(correctVcode)){
				br.rejectValue("vcode","invalid.vcode");
			}
		}
		
		//判断是否有错误
		if(br.hasErrors()){
			return "login";
		}
		
		LoginResult result=empService.login(loginForm.getUserName(),loginForm.getPassword());
		if(result.getStatus()==LoginResult.INVALID_USER_NAME){
			br.rejectValue("userName","invalid.userName");
			return "login";
		}
		else if(result.getStatus()==LoginResult.INVALID_PASSWORD){
			br.rejectValue("password","invalid.password");
			return "login";
		}
		else{
			Emp emp=result.getEmp();
			
			//如果当前登录的员工不是管理员
			if(emp.getAdmin()==false){
				//获取部门对象
				Dept dept=deptService.getDept(emp.getDid());
				session.setAttribute("dept",dept);
			}
			else{
				//获得第一个部门
				Dept dept=deptService.getFirstDept();
				session.setAttribute("dept",dept);
			}
			
			//将员工和部门存入session
			session.setAttribute("emp",emp);
			
			//重定向到后台首页
			return "redirect:background/index.html";
		}		
	}
	
	
	
	
}






