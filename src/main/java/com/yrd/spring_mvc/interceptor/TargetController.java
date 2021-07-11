package com.yrd.spring_mvc.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@RequestMapping("/targetController")
@Controller("targetController")
public class TargetController {
	
	@RequestMapping("/target")
	public ModelAndView show() {
		System.out.println("目标资源执行qq。。。。。");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("username", "itcast");
		modelAndView.setViewName("success2");
		return modelAndView;
	}
	
	
	
}
