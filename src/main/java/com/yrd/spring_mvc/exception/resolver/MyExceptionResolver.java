package com.yrd.spring_mvc.exception.resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.yrd.spring_mvc.exception.myexception.MyException;



public class MyExceptionResolver implements HandlerExceptionResolver{

	/**
	 * 参数Exception:异常对象，，，返回值ModelAndView:跳转到错误视图信息
	 * @Title:resolveException
	 * @Description:
	 *
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex 
	 * @return 
	 * @see org.springframework.web.servlet.HandlerExceptionResolver#resolveException(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 *
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(ex instanceof MyException) {
			modelAndView.addObject("info", "自定义的异常");
		}else if (ex instanceof ClassCastException) {
			modelAndView.addObject("info", "类转换的异常"+ex.getMessage());
		}else if(ex instanceof ArithmeticException) {
			modelAndView.addObject("info", "除数为零的异常:"
		+ArithmeticException.class.getName()+":"+ex.getMessage());
		}else {
			modelAndView.addObject("info", "其他异常");
		}
		
		modelAndView.setViewName("error_zidingyi");
		return modelAndView;
	}

}
