package com.neuedu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.neuedu.model.Pager;
import com.neuedu.model.Result;
import com.neuedu.model.User;
import com.neuedu.service.UserService;


/**
 * @author 罗星华
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	
	private static final Logger logger = Logger.getRootLogger();
	
	@RequestMapping("/findall")
	public void findAll(HttpServletResponse response) throws IOException{
		List<User> list = service.findAll();
		response.setContentType("text/html");
		Gson gson = new Gson();
		String gsonData = gson.toJson(list);
		response.getWriter().write(gsonData);
		response.getWriter().flush();
	}
	
	@RequestMapping("/findbyusermobile")
	public void findByUserMobile(String userMobile, HttpServletResponse response) throws IOException {
		User user = service.findByUserMobile(userMobile);
		response.setContentType("text/html");
		Gson gson = new Gson();
		String gsonData = gson.toJson(user);
		response.getWriter().write(gsonData);
		response.getWriter().flush();

	}
	@RequestMapping("/findbyusername")
	public void findByUserName(String userName, HttpServletResponse response) throws IOException {
		User user = service.findByUserName(userName);
		response.setContentType("text/html");
		Gson gson = new Gson();
		String gsonData = gson.toJson(user);
		response.getWriter().write(gsonData);
		response.getWriter().flush();

	}
	@RequestMapping("/findbyuseraccount")
	public void findByUserAccount(String userAccount, HttpServletResponse response) throws IOException {
		User user = service.findByUserAccount(userAccount);
		response.setContentType("text/html");
		Gson gson = new Gson();
		String gsonData = gson.toJson(user);
		response.getWriter().write(gsonData);
		response.getWriter().flush();

	}
	@RequestMapping("/findtotal")
	public void findTotal(HttpServletResponse response) throws IOException {
		int total = service.findTotal();
		response.setContentType("text/html");
		Gson gson = new Gson();
		String gsonData = gson.toJson(total);
		response.getWriter().write(gsonData);
		response.getWriter().flush();

	}
	@RequestMapping("/findbypager")
	public void findByPager(Pager pager, HttpServletResponse response) throws IOException {
		List<User> list = service.findByPager(pager);
		response.setContentType("text/html");
		Gson gson = new Gson();
		String gsonData = gson.toJson(list);
		response.getWriter().write(gsonData);
		response.getWriter().flush();
	}
	@RequestMapping("/findbyuseridcard")
	public void findByUserIdcard(String userIdcard, HttpServletResponse response) throws IOException {
		User user = service.findByUserIdcard(userIdcard);
		response.setContentType("text/html");
		Gson gson = new Gson();
		String gsonData = gson.toJson(user);
		response.getWriter().write(gsonData);
		response.getWriter().flush();
	}
	
	@RequestMapping("/add")
	public void add(User user, HttpServletResponse response) throws IOException {
		Result result = null;
		try{
			service.add(user);
			result = new Result(true, "新增用户成功！");
		}catch (Exception e) {
			result = new Result(false, "新增用户失败！");
		}
		response.setContentType("text/html");
		Gson gson = new Gson();
		String gsonData = gson.toJson(result);
		response.getWriter().write(gsonData);
		response.getWriter().flush();
		

	}
	@RequestMapping("/update")
	public void update(User user, HttpServletResponse response) throws IOException {
		Result result = null;
		try{
			service.update(user);
			result = new Result(true, "修改用户信息成功！");
		}catch (Exception e) {
			result = new Result(false, "修改用户信息失败！");
		}
		response.setContentType("text/html");
		Gson gson = new Gson();
		String gsonData = gson.toJson(result);
		response.getWriter().write(gsonData);
		response.getWriter().flush();

	}
	@RequestMapping("/deletebyuseraccount")
	public void deleteByUserAccount(String userAccount, HttpServletResponse response) throws IOException {
		Result result = null;
		try{
			service.deleteByUserAccount(userAccount);
			result = new Result(true, "删除用户成功！");
		}catch (Exception e) {
			result = new Result(false, "删除用户失败！");
		}
		String dataString = new Gson().toJson(result);
		response.setContentType("text/html");
		response.getWriter().write(dataString);
		response.getWriter().flush();

	}
}
