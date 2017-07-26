package com.neuedu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.neuedu.model.Department;
import com.neuedu.model.Pager;
import com.neuedu.model.Result;
import com.neuedu.service.DepartmentService;

/**
 * 这是spring mvc的控制类，需要使用注解标签进行注解
 * @author 罗星华
 *
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService service;
	
	//用log4j日志框架，输出程序运行的记录
	private static final Logger logger = Logger.getRootLogger();
	
	//Pager pager是用户接收用户输入的变量，
	//HttpServletResponse response是java服务器管理的一个用户向客户端（如浏览器）进行响应的对象
	@RequestMapping("/findbypager")
	public void findByPager(Pager pager,HttpServletResponse response) throws IOException{
		List<Department> list = service.findByPager(pager);
		//设置返回的内容格式
		response.setContentType("text/html");
		//使用Gson进行json数据的解析与转换
		Gson gson = new Gson();
		//把java集合对象转换成json字符串
		String gsonData = gson.toJson(list);
		//把json字符串通过网络io传回客户端
		response.getWriter().write(gsonData);
		//刷新缓存
		response.getWriter().flush();
	}
	
	@RequestMapping("/findbydepartmentname")
	public void findByDepartmentName(String departmentName, HttpServletResponse response) throws IOException{
		Department department = service.findByDepartmentName(departmentName);
		response.setContentType("text/html");
		Gson gson = new Gson();
		String gsonData = gson.toJson(department);
		response.getWriter().write(gsonData);
		response.getWriter().flush();
	}
	
	@RequestMapping("/findall")
	public void findAll(HttpServletResponse response) throws IOException{
		List<Department> list = service.findAll();
		//设置返回的内容格式
		response.setContentType("text/html");
		//使用Gson进行json数据的解析与转换
		Gson gson = new Gson();
		//把java集合对象转换成json字符串
		String gsonData = gson.toJson(list);
		//把json字符串通过网络io传回客户端
		response.getWriter().write(gsonData);
		//刷新缓存
		response.getWriter().flush();
	}
	
	@RequestMapping("/findtotal")
	public void findTotal(HttpServletResponse response) throws IOException{
		int total = service.findTotal();
		//设置返回的内容格式
		response.setContentType("text/html");
		//使用Gson进行json数据的解析与转换
		Gson gson = new Gson();
		//把java集合对象转换成json字符串
		String gsonData = gson.toJson(total);
		//把json字符串通过网络io传回客户端
		response.getWriter().write(gsonData);
		//刷新缓存
		response.getWriter().flush();
	}
	
	@RequestMapping("/add")
	private void add(Department department,HttpServletResponse response) throws IOException{

		Result result = null;
		try{
			service.add(department);
			result = new Result(true,"新增部门成功！");
		}catch (Exception e) {
			//e.printStackTrace();
			logger.warn("新增部门失败！",e);
			result = new Result(false,"新增部门失败！");
		}
		//根据结果向客户端返回json提示信息
		
		//使用gson进行转换成json字符串，并使用response对象返回
		String dataString = new Gson().toJson(result);
		response.setContentType("text/html");
		response.getWriter().write(dataString);
		response.getWriter().flush();
	}
	
	
	@RequestMapping("/deletebyid")
	public void deleteById(int departmentId,HttpServletResponse response) throws IOException{
		Result result = null;
		try{
			service.deleteById(departmentId);
			result = new Result(true, "删除部门成功！");
		}catch (Exception e) {
			logger.warn("删除部门失败！",e);
			result = new Result(false, "删除部门失败！");
		}
		String dataString = new Gson().toJson(result);
		response.setContentType("text/html");
		response.getWriter().write(dataString);
		response.getWriter().flush();
	}
	
	@RequestMapping("/update")
	public void update(Department department, HttpServletResponse response) throws IOException{
		Result result = null;
		try{
			service.update(department);
			result = new Result(true, "修改部门成功！");
		}catch (Exception e) {
			logger.warn("修改部门失败！",e);
			result = new Result(false, "修改部门失败！");
		}
		String dataString = new Gson().toJson(result);
		response.setContentType("text/html");
		response.getWriter().write(dataString);
		response.getWriter().flush();
	}
	
	
	@RequestMapping("/findbyid")
	public void findById(int departmentId, HttpServletResponse response) throws IOException{
		Department department = service.findById(departmentId);
		//设置返回的内容格式
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		//使用Gson进行json数据的解析与转换
		Gson gson = new Gson();
		//把java集合对象转换成json字符串
		String gsonData = gson.toJson(department);
		//把json字符串通过网络io传回客户端
		response.getWriter().write(gsonData);
		//刷新缓存
		response.getWriter().flush();
	}
}
