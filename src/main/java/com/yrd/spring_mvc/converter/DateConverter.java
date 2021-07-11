package com.yrd.spring_mvc.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String dateString) {
		//将日期字符串转换成日期对象 返回
		//http://localhost:8080/userController/quick18?date=2018-09-09
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null ;
		try {
			 date = format.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	

}
