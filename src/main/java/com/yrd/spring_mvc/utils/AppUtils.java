package com.yrd.spring_mvc.utils;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class AppUtils implements ApplicationContextAware {
	
	private static ApplicationContext app;
	
	
	public AppUtils() {
		System.out.println("AppUtils创建了。。。。");
	}
	
	
	//实现ApplicationContextAware接口的context注入函数, 将其存入静态变量
	@Override 
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		AppUtils.app = applicationContext;
		System.out.println("applicationContext正在初始化,application:"+applicationContext);
	}
	
	//取得存储在静态变量中的ApplicationContext.
	public static ApplicationContext getApplicationContext() {
		checkApplicationContext();
		return app;
	}
	
	//从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		checkApplicationContext();
		return (T) app.getBean(name);
	}
	
	//从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
	//如果有多个Bean符合Class, 取出第一个
	public static <T> T getBean(Class<T> cls) {
		checkApplicationContext();
		Map<String, T> beanMap = app.getBeansOfType(cls);
		if(beanMap != null && !beanMap.isEmpty()) {
			return (T) beanMap.values().iterator().next();
		}else {
			return null;
		}
	}
	
	private static void checkApplicationContext() {
		if(app == null) {
			throw new IllegalStateException("applicaitonContext未注入,请在applicationContext.xml中定义AppUtils");
		}
	}

}
