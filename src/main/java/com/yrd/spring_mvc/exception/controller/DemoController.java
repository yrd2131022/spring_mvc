package com.yrd.spring_mvc.exception.controller;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yrd.spring_mvc.exception.myexception.MyException;
import com.yrd.spring_mvc.exception.service.DemoServiceImpl;



@Controller
public class DemoController {
	
	@Autowired
	private DemoServiceImpl demoService;

	@RequestMapping(value = "/showexception")
	public String show(@RequestParam(value = "name", required = false) String name) throws FileNotFoundException, MyException {
		System.out.println("show running...");
		demoService.show2();
		return "index";
	}
}
