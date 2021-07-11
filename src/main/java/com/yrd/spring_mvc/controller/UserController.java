package com.yrd.spring_mvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yrd.spring_mvc.domain.User;
import com.yrd.spring_mvc.domain.VO;

@Controller()
@RequestMapping("/userController")
public class UserController {
	
	//===============================springmvc数据响应方式：页面跳转======================================
	//springmvc数据响应方式：页面跳转：直接返回字符串
	@RequestMapping("/quick")
	public String save() {
		System.out.println("quick save running....");
//		return "forward:/jsp/success2.jsp";//转发，请求 地址没变
//		return "redirect:/jsp/success2.jsp";//重定向，请求 地址发生改变
		//配置资源解析器后（viewResolver）
		return "success2";//这里实际上是：return "forward:/jsp/success2.jsp
	}
	
	
	//springmvc数据响应方式：页面跳转：直接返回ModelAndView对象
		@RequestMapping("/quick2")
		public ModelAndView save2() {
			System.out.println("quick2 save running....");
			/*
			 * Model:模型：作用封装数据
			 * view：视图：作用展示数据
			 */
			User user = new User();
			user.setAddr("北京");
			user.setName("Lucy");
			
			ModelAndView modelAndView = new ModelAndView();
			//设置视图名称//如果没有success2.jsp文件，则报文.件[/jsp/success2.jsp] 未找到
			modelAndView.setViewName("success2");
			//设置模型数据
			modelAndView.addObject("username", user);
			return modelAndView;
		}
		
		
		
		//springmvc数据响应方式：页面跳转：直接返回ModelAndView对象,spring会自动帮我们创建ModelAndView对象
			@RequestMapping("/quick3")
			public ModelAndView save3(ModelAndView modelAndView) {
				System.out.println("quick3 save running....");
				//设置视图名称//如果没有success2.jsp文件，则报文.件[/jsp/success2.jsp] 未找到
				modelAndView.setViewName("success2");
				//设置模型数据
				modelAndView.addObject("username", "yrd-quick3");
				return modelAndView;
			}
				
		//springmvc数据响应方式：页面跳转：直接返回ModelAndView对象,spring会自动帮我们创建ModelAndView对象
		@RequestMapping("/quick4")
		public String save4(Model model) {
			System.out.println("quick4 save running....");
			//设置视图名称//如果没有success2.jsp文件，则报文.件[/jsp/success2.jsp] 未找到
			model.addAttribute("username", "yrd-quick4");
			return "success2";
		}		
				
				
		//springmvc数据响应方式：页面跳转：尽量不使用HttpServletRequest作为参数，为了解耦合
		@RequestMapping("/quick5")
		public String save5(HttpServletRequest request) {
			System.out.println("quick5 save running....");
			//设置视图名称//如果没有success2.jsp文件，则报文.件[/jsp/success2.jsp] 未找到
			request.setAttribute("username", "yrd-quick5");
			return "success2";
		}		
				
		//===============================springmvc数据响应方式：返回数据===================================		

		
		//springmvc数据响应方式：返回数据：尽量不使用HttpServletResponse作为参数，为了解耦合
		@RequestMapping("/quick6")
		public void save6(HttpServletResponse response) throws IOException {
			System.out.println("quick6 save running....");
			//设置视图名称//如果没有success2.jsp文件，则报文.件[/jsp/success2.jsp] 未找到
			response.getWriter().println( "yrd-quick6");
		}		
		
		
		
		//为了解耦合这里不要参数：HttpServletResponse response,这里又和/quick相似了。怎么办呢？？？
		//将需要回写的字符串直接返回，但此时需要通过@ResponseBody注解告诉SpringMVC框架，不进行视图跳转  直接进行数据响应
		//方法返回的字符串不是跳转是直接在http响应体中返回。
		@RequestMapping("/quick7")
		@ResponseBody
		public String save7() throws IOException {
			System.out.println("quick7 save running....");
			return"hello itcastheima";
		}
		
		//springmvc数据响应方式：返回数据
		@RequestMapping("/quick8")
		@ResponseBody //告诉Springmvc框架 不进行视图跳转  直接进行数据响应
		public String save8() throws IOException {
			System.out.println("quick8 save running....");
			
			return "{\"username\":\"zhangsan\",\"age\":18}";
		}		
		
		//springmvc数据响应方式：返回数据
		@RequestMapping("/quick9")
		@ResponseBody //告诉Springmvc框架 不进行视图跳转  直接进行数据响应
		public String save9() throws IOException {
			System.out.println("quick9 save running....");
			
			User user = new User();
			user.setAddr("beijing");
			user.setName("lucy");
			
			//使用json的转换工具将对象转json数据
			ObjectMapper mapper = new ObjectMapper();
			String userString = mapper.writeValueAsString(user);
			
			return userString;
		}		
		
		//springmvc数据响应方式：返回数据
		@RequestMapping("/quick10")
		@ResponseBody //告诉Springmvc框架 不进行视图跳转  直接进行数据响应
		//期望SpringMVC自动将User转换成json格式的字符串
		public User save10() throws IOException {
			System.out.println("quick10 save running....");
			
			User user = new User();
			user.setAddr("beijing");
			user.setName("lucy10");
			
			return user;
		}
		
		
		@RequestMapping("/quick11")
		@ResponseBody//ResponseBody代表不进行页面跳转
		//springMVC获得请求数据,Controller中的业务方法的参数名称要与请求参数的name一致，参数值会自动映射匹配
		//http://localhost:8080/userController/quick11?username=zh&age=23
		public void save11(String username,int age) throws IOException {
			System.out.println("quick11 save running....");
			System.out.println(username);
			System.out.println(age);
		}
		
		@RequestMapping("/quick12")
		@ResponseBody//ResponseBody代表不进行页面跳转
		//springMVC获得请求数据,自动封装到User中的username和age中
		//http://localhost:8080/userController/quick11?username=zh&age=23
		public User save12(User user) throws IOException {
			
			System.out.println(user);
			return user;
			
			
		}
		@RequestMapping("/quick13")
		@ResponseBody//ResponseBody代表不进行页面跳转
		//springMVC获得请求数据,自动封装到数组中的
		//http://localhost:8080/userController/quick13?strs=aaa&strs=bbb&strs=ccc
		public void save13(String[] strs) throws IOException {
			
			System.out.println(Arrays.asList(strs));
			
		}
		
		@RequestMapping("/quick14")
		@ResponseBody//ResponseBody代表不进行页面跳转
		//springMVC获得请求数据,自动封装到集合中的,form.jsp提交http://localhost:8080/spring_mvc/form.jsp
		public VO save14(VO vo) throws IOException {
			
			System.out.println(vo);		
			return vo;
			
		}
		@RequestMapping("/quick15")
		@ResponseBody//ResponseBody代表不进行页面跳转
		//springMVC获得请求数据,自动封装到集合中的,ajax.jsp提交参数要加：@RequestBody
		public void save15(@RequestBody List<User> userList) throws IOException {
			
			System.out.println(userList);			
		}
		
		@RequestMapping("/quick16")
		@ResponseBody//ResponseBody代表不进行页面跳转,当请求参数名name与方法形参名不同时。使用@RequestParam注解
		//http://localhost:8080/userController/quick16?name=hello
		public void save16(@RequestParam(value = "name",required = false,defaultValue = "itcast") String username) throws IOException {
			
			System.out.println(username);			
		}
		
		@RequestMapping(method = {RequestMethod.GET},value = "/quick17/{username}")
//		@RequestMapping("/quick17/{username}")
		@ResponseBody//ResponseBody代表不进行页面跳转,restful风格获取参数/quick17/xiaomingnihao
		///quick17/{username}中的username名和@PathVariable(value = "username",中的username名一样。
		//http://localhost:8080/userController/quick17/xiaomingnihao
		public void save17(@PathVariable(value = "username",required = false) String username1) throws IOException {
			
			System.out.println(username1);			
		}
		
		@RequestMapping("/quick18")
		@ResponseBody//ResponseBody代表不进行页面跳转,
		//http://localhost:8080/userController/quick18?date=2018-09-09
		public void save18(Date date) throws IOException {
			
			System.out.println(date);			
		}
		
		@RequestMapping("/quick19")
		@ResponseBody//ResponseBody代表不进行页面跳转,
		//http://localhost:8080/userController/quick19
		public void save19(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
			
			System.out.println("request"+request);
			System.out.println("response"+response);
			System.err.println("session:"+session);
		}
		
		@RequestMapping("/quick20")
		@ResponseBody//ResponseBody代表不进行页面跳转,
		//http://localhost:8080/userController/quick20
		public void save20(@RequestHeader(value = "User-Agent" ,required = false) String user_agent) throws IOException {
			
			System.out.println(user_agent);
		}
		
		@RequestMapping("/quick21")
		@ResponseBody//ResponseBody代表不进行页面跳转,
		//http://localhost:8080/userController/quick19
		public void save21(@CookieValue(value = "JSESSIONID" ,required = false) String jsessionID) throws IOException {
			
			System.out.println(jsessionID);
		}
		
		@RequestMapping("/quick22")
		@ResponseBody//ResponseBody代表不进行页面跳转,
		//这里的参数名：uploadFile 必须根表单upload.jsp中的name同名。(文件<input type="file" name="uploadFile"><br>)
		//http://localhost:8080/upload.jsp
		public void save22(String username,MultipartFile uploadFile,MultipartFile uploadFile2) throws IOException {
			System.out.println(username);
			System.out.println(uploadFile);
			//获得上传文件名称
			String originalFilename = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("D:\\upload\\"+originalFilename));
			
			String originalFilename2 = uploadFile2.getOriginalFilename();
			uploadFile2.transferTo(new File("D:\\upload\\"+originalFilename2));
			System.out.println(originalFilename);
			
		}
		
		@RequestMapping("/quick23")
		@ResponseBody//ResponseBody代表不进行页面跳转,
		//这里的参数名：uploadFile 必须根表单upload.jsp中的name同名。(文件<input type="file" name="uploadFile"><br>)
		//http://localhost:8080/upload.jsp
		public void save23(String username,MultipartFile[] uploadFile) throws IOException {
		
			for (int i = 0; i < uploadFile.length; i++) {
				String originalFilename = uploadFile[i].getOriginalFilename();
				uploadFile[i].transferTo(new File("D:\\upload\\"+originalFilename));			
			}
			
		}
		
		@RequestMapping("/login")
		public String login(String username,String password,HttpSession session) {
			
//			User user = userService.login(username,password);
//			if(user!=null) {
//				//登录成功  将user存储到session
//				session.setAttribute("user", user);
//				return "redirect:/index.jsp";
//			}
			
			return "redirect:/jsp/login.jsp";
		}
		
		
		
		
}
