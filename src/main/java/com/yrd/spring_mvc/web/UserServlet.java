package com.yrd.spring_mvc.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.yrd.spring_mvc.service.IUserService;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//已经在ContextLoaderListener中，将Spring的应用上下文对象存储到ServletContext域中
//		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ServletContext servletContext = this.getServletContext();
		//每次访问Servlet，取出Spring的应用上下文对象，都要记住之前保存的app名字。这是写死的明显不好。
		//如果servlete很多时，需要改很多地方。写成公共类获取ApplicationContext时，如果需要修改app名字时，只需要修改一个地方。
//		ApplicationContext app = (ApplicationContext) servletContext.getAttribute("app");
//		ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		WebApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		IUserService userService = app.getBean(IUserService.class);
		userService.save();
	}
	
	

}
