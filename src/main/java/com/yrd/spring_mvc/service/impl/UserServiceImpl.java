package com.yrd.spring_mvc.service.impl;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.yrd.spring_mvc.dao.IUserDao;
import com.yrd.spring_mvc.service.IUserService;


//<bean id="userService" class="com.yrd.spring.quick_develop.service.impl.UserServiceImpl"> 
@Service("userService")
@Scope("singleton")
public class UserServiceImpl implements IUserService {

	//属性注入
	// <property name="userDao" ref="userDao"></property>
	//@Autowired
	//@Qualifier("userDao")
	@Resource(name = "userDao") // @Autowired+@Qualifier("userDao")
	private IUserDao userDao;

	// 无参构造函数
	public UserServiceImpl() {
		System.out.println("annotation_develop===>UserServiceImpl 创建了。。");
	}

	// 有参构造函数
	public UserServiceImpl(IUserDao userDao) {
		this.userDao = userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void save() {

		System.out.println("annotation_develop===>UserServiceImpl...save  running...");

		userDao.save();

	}

}
