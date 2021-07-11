package com.yrd.spring_mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor2 implements HandlerInterceptor {
	
	//在目标方法执行之前 执行
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("MyInterceptor2===>preHandle2222222.....");
		

		
			return true;
		
		//return如果true代表放行，false代表不放行。
	}

	//在目标方法执行之后 视图返回之前执行
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("MyInterceptor2===>postHandle22222222....");
		
//		modelAndView.addObject("name", "ityrdheima");
	}

	//在流程都执行完毕后，执行
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
			Object handler, Exception ex)
			throws Exception {
		System.out.println("MyInterceptor2===>afterCompletion22222222.....");
	}
	
	

}
