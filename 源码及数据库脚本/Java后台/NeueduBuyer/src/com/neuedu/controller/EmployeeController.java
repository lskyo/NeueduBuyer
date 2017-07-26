package com.neuedu.controller;
/**
 * 
 * @author 刘志杰
 */

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import com.neuedu.model.Employee;
import com.neuedu.model.Pager;
import com.neuedu.model.Result;

import com.neuedu.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	// 使用log4j日志框架，日志框架用于输出程序运行的记录（即做运行记录）
	private static final Logger logger = Logger.getRootLogger();

	// 在控制层通过spring ioc核心进行整合service层
	@Autowired
	private EmployeeService service;

	// Pager pager 是用于接收用户输入的变量
	// HttpServletResponse response是java服务器管理的一个用于向客户端（如浏览器）进行相应的对象

	@RequestMapping("/findall")
	public void findAll(HttpServletResponse response) throws IOException {

		List<Employee> list = service.findAll();
		response.setContentType("text/Html");

		Gson gson = new Gson();
		String gsonData = gson.toJson(list);
		response.getWriter().write(gsonData);
		response.getWriter().flush();
	}
	
	//查询总数
	@RequestMapping("/findtotal")
	private void findTotal(HttpServletResponse response) throws IOException {
		
		int total = service.findTotal();
		response.setContentType("text/Html");
		Gson gson = new Gson();
		String gsonData = gson.toJson(total);
		response.getWriter().write(gsonData);
		response.getWriter().flush();
	}
	
	//分页查询
	@RequestMapping("/findbypager")
	public void findByPager(Pager pager, HttpServletResponse response) throws IOException {

		List<Employee> list = service.findByPager(pager);
		response.setContentType("text/Html");

		Gson gson = new Gson();
		String gsonData = gson.toJson(list);
		response.getWriter().write(gsonData);
		response.getWriter().flush();
	}

	// 新增员工
	@RequestMapping("/add")
	public void add(Employee employee, HttpServletResponse response) throws IOException {

		// 设置一个新增状态的默认值：默认为新增失败
		boolean result = false;
		try {
			service.add(employee);
			result = true;
		} catch (Exception e) {
			logger.warn("新增员工失败", e);
		}

		Result result2 = null;
		if (result) {// 如果新增成功
			result2 = new Result(result, "新增员工成功");
		} else {
			result2 = new Result(result, "新增员工失败");
		}

		String dataString = new Gson().toJson(result2);
		response.setContentType("text/html");
		response.getWriter().write(dataString);
		response.getWriter().flush();
	}

	// 根据员工编号删除员工
	@RequestMapping("/deletebyemployeeid")
	public void deleteByEmployeeId(String employeeId, HttpServletResponse response) throws IOException {

		Result result = null;
		try {
			service.deleteByEmployeeId(employeeId);
			result = new Result(true, "删除成功");
		} catch (Exception e) {
			result = new Result(false, "删除失败");
		}

		String dataString = new Gson().toJson(result);
		response.setContentType("text/html");
		response.getWriter().write(dataString);
		response.getWriter().flush();
	}

	// 修改员工信息
	@RequestMapping("/update")
	public void update(Employee employee, HttpServletResponse response) throws IOException {

		Result result = null;
		try {
			service.update(employee);
			result = new Result(true, "修改成功");
		} catch (Exception e) {
			result = new Result(false, "修改失败");
		}

		String dataString = new Gson().toJson(result);
		response.setContentType("text/html");
		response.getWriter().write(dataString);
		response.getWriter().flush();

	}

	// 根据部门编号删除员工
	@RequestMapping("/deletebydepartmentid")
	public void deleteByDepartmentId(int departmentId, HttpServletResponse response) throws IOException {

		Result result = null;
		try {
			service.deleteByDepartmentId(departmentId);
			result = new Result(true, "删除成功");
		} catch (Exception e) {
			result = new Result(false, "删除失败");
		}

		String dataString = new Gson().toJson(result);
		response.setContentType("text/html");
		response.getWriter().write(dataString);
		response.getWriter().flush();
	}

	// 根据员工编号查询员工
	@RequestMapping("/findbyemployeeid")
	public void findByEmployeeId(String employeeId, HttpServletResponse response) throws IOException {

		Employee employee = service.findByEmployeeId(employeeId);
		response.setContentType("text/Html");

		Gson gson = new Gson();
		String gsonData = gson.toJson(employee);
		response.getWriter().write(gsonData);
		response.getWriter().flush();
	}

	// 根据部门编号查询员工
	@RequestMapping("/findbydepartmentid")
	public void findByDepartmentId(int departmentId, HttpServletResponse response) throws IOException {

		List<Employee> list = service.findByDepartmentId(departmentId);
		response.setContentType("text/Html");

		Gson gson = new Gson();
		String gsonData = gson.toJson(list);
		response.getWriter().write(gsonData);
		response.getWriter().flush();
	}

	// 根据手机号查询员工
	@RequestMapping("/findbyemployeemobile")
	public void findByEmployeeMobile(String employeeMobile, HttpServletResponse response) throws IOException {

		Employee employee = service.findByEmployeeMobile(employeeMobile);
		response.setContentType("text/Html");

		Gson gson = new Gson();
		String gsonData = gson.toJson(employee);
		response.getWriter().write(gsonData);
		response.getWriter().flush();
	}

	// 根据员工账号查询员工
	@RequestMapping("/findbyemployeeaccount")
	public void findByEmployeeAccount(String employeeAccount, HttpServletResponse response) throws IOException {

		Employee employee = service.findByEmployeeAccount(employeeAccount);
		response.setContentType("text/Html");

		Gson gson = new Gson();
		String gsonData = gson.toJson(employee);
		response.getWriter().write(gsonData);
		response.getWriter().flush();
	}

	// 根据员工姓名查询员工
	@RequestMapping("/findbyemployeename")
	public void findByEmployeeName(String employeeName, HttpServletResponse response) throws IOException {

		Employee employee = service.findByEmployeeName(employeeName);
		response.setContentType("text/Html");

		Gson gson = new Gson();
		String gsonData = gson.toJson(employee);
		response.getWriter().write(gsonData);
		response.getWriter().flush();
	}

}
