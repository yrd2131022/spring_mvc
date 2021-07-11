package com.yrd.spring_mvc.my_listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextLoaderListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		ServletContext servletContext = sce.getServletContext();
		
		//读取web.xml中的全局参数
		String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
		
		//创建spring容器
//		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		ApplicationContext app = new ClassPathXmlApplicationContext(contextConfigLocation);

		//将Spring的应用上下文对象，存储到ServletContext域中
		servletContext.setAttribute("app", app);
		
		System.out.println("spring容器创建完毕......");

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
