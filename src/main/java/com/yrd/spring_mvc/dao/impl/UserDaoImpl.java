package com.yrd.spring_mvc.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.yrd.spring_mvc.dao.IUserDao;
import com.yrd.spring_mvc.domain.User;


//<bean id="userDao"  class="com.yrd.spring.annotation_develop.dao.impl.UserDaoImpl" 
@Repository("userDao")
@Scope("singleton")
public class UserDaoImpl implements IUserDao {
	
	private List<String> strList;
	private Map<String, User> userMap;
	private Properties properties;
	
	@Value("${jdbc.driver}")
	private String username;
	@Value("30")
	private int age;
	
	public UserDaoImpl() {
		System.out.println("annotation_develop==>UserDaoImpl创建.....");
	}
	
	public void save() {
		System.out.println("annotation_develop==>UserDaoImpl-->save running.....username:"+username+"====age:"+age);
		System.out.println("annotation_develop==>UserDaoImpl-->strList:"+strList);
		System.out.println("annotation_develop==>UserDaoImpl-->userMap:"+userMap);
		System.out.println("annotation_develop==>UserDaoImpl-->properties:"+properties);
		
//		ApplicationContext app = AppUtils.getApplicationContext();
//		JdbcTemplate jdbcTemplate = (JdbcTemplate) app.getBean("jdbcTemplate");
//		
//		String sql="create table tbl_account( "
//				+ "id int primary key auto_increment,"
//				+ "username varchar(30),"
//				+ "balance double)";
//		jdbcTemplate.execute(sql);
//		System.out.println("账户表 tbl_account 创建成功!");
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setStrList(List<String> strList) {
		this.strList = strList;
	}

	public void setUserMap(Map<String, User> userMap) {
		this.userMap = userMap;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
	
	//init-method="init"
//	@PostConstruct
	public void init() {
		System.out.println("annotation_develop==>UserDaoImpl初始化方法....");
	}
	//destroy-method="destroy"
//	@PreDestroy
	public void destroy() {
		System.out.println("annotation_develop==>UserDaoImpl销毁方法....");
	}


}
