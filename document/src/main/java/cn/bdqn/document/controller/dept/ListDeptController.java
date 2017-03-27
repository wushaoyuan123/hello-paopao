package cn.bdqn.document.controller.dept;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.bdqn.document.controller.BaseController;
import cn.bdqn.document.entity.Dept;
import cn.bdqn.document.form.DeptSearchForm;

@Controller
@RequestMapping("/background/dept")
public class ListDeptController extends BaseController{

	/*
	 在调用方法时，会根据方法参数类型DeptSearchForm转换出属性名deptSearchForm
	 再使用属性名deptSearchForm在数据模型中查找有没有对应的对象
	 如果没有找到对应的对象，则创建新的DeptSearchForm对象，接收请求提交的数据
	 并且使用DeptSearchForm属性名将对象存入数据模型，然后传递给方法参数
	 * */
	
	@RequestMapping("index")
	public ModelAndView service(DeptSearchForm searchForm){
		//查询部门列表
		List<Dept> depts=deptService.findDept(searchForm.getName());
		
		return new ModelAndView("background/dept/index").addObject("depts",depts);
	}
	
	
	
	
}






