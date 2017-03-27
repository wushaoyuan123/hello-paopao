package cn.bdqn.document.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/background")
public class BackgroundController {

	@RequestMapping("index")
	public String service(){
		return "background/index";
	}
	
}
