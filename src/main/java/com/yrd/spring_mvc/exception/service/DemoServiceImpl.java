package com.yrd.spring_mvc.exception.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.springframework.stereotype.Service;

import com.yrd.spring_mvc.exception.myexception.MyException;



@Service
public class DemoServiceImpl implements DemoService {

	
	
	@SuppressWarnings("unused")
	public void show1() {
		System.out.println("抛出类型转换异常......");
		Object str = "zhangsan";		
		Integer num = (Integer) str;
		
	}
	
	public void show2() {
		System.out.println("抛出除零异常......");
		int i =1/0;
		System.out.println(i);
	}

	
	public void show3() throws FileNotFoundException {
		System.out.println("文件找不到异常.....");
		InputStream in = new FileInputStream("C:/xxx/xxx/xxx.text");
		System.out.println(in);
	}
	
	@SuppressWarnings("null")
	public void show4() {
		System.out.println("空指针异常....");
		String str = null;
		str.length();
		System.out.println(str);
	}
	
	public void show5() throws MyException {
		System.out.println("自定义异常......");
		throw new MyException();
	}

}
