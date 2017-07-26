package com.neuedu.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.helpers.Loader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.neuedu.model.Reservation;
import com.neuedu.model.Pager;
import com.neuedu.model.Result;
import com.neuedu.service.ReservationService;

/**
 * 这是SPring mvc的控制类，需要使用@Controller注解标签进行zhu'shi
 * 
 * @author 青计
 *
 */
@Controller
@RequestMapping("/reservation")
public class ReservationController {

	// 使用log4j日志框架，日志框架用于输出程序运行的记录（即做运行记录）
	// 实例化一个log4j日志器
	private static final Logger logger = Logger.getRootLogger();

	// 在控制层通过spring ioc 核心进行整合service层
	@Autowired
	private ReservationService service;

	// Pager pager是用于接收用户输入的变量，
	// HttpServletRequest response是JAva服务器管理的一个用户向客户端（如浏览器进行响应的对象
	@RequestMapping("/findall")
	public void findAll(Pager pager, HttpServletResponse response) throws IOException {

		List<Reservation> list = service.findAll();
		// 设置返回的内容格式
		response.setContentType("text/json");
		// 使用gson进行json数据的解析与转换
		Gson gson = new Gson();
		// 把java集合对象转换成json字串符
		String gsonData = gson.toJson(list);
		// 把json字符串通过网络IO留传回客户端（如浏览器）
		response.getWriter().write(gsonData);
		// 刷新缓存
		response.getWriter().flush();
	}

	@RequestMapping("/findbypager")
	public void findByPager(Pager pager, HttpServletResponse response) throws IOException {

		List<Reservation> list = service.findByPager(pager);
		// 设置返回的内容格式
		response.setContentType("text/json");
		// 使用gson进行json数据的解析与转换
		Gson gson = new Gson();
		// 把java集合对象转换成json字串符
		String gsonData = gson.toJson(list);
		// 把json字符串通过网络IO留传回客户端（如浏览器）
		response.getWriter().write(gsonData);
		// 刷新缓存
		response.getWriter().flush();
	}

	@RequestMapping("/findbyuseraccount")
	public void findByUserAccount(String userAccount, HttpServletResponse response) throws IOException {

		List<Reservation> list = service.findByUserAccount(userAccount);
		// 设置返回的内容格式
		response.setContentType("text/json");
		// 使用gson进行json数据的解析与转换
		Gson gson = new Gson();
		// 把java集合对象转换成json字串符
		String gsonData = gson.toJson(list);
		// 把json字符串通过网络IO留传回客户端（如浏览器）
		response.getWriter().write(gsonData);
		// 刷新缓存
		response.getWriter().flush();

	}

	@RequestMapping("/findbynurseid")
	public void findByNurseId(String nurseId, HttpServletResponse response) throws IOException {

		List<Reservation> list = service.findByNurseId(nurseId);
		// 设置返回的内容格式
		response.setContentType("text/json");
		// 使用gson进行json数据的解析与转换
		Gson gson = new Gson();
		// 把java集合对象转换成json字串符
		String gsonData = gson.toJson(list);
		// 把json字符串通过网络IO留传回客户端（如浏览器）
		response.getWriter().write(gsonData);
		// 刷新缓存
		response.getWriter().flush();

	}

	@RequestMapping("/findbyreservationid")
	public void findByReservationId(String reservationId, HttpServletResponse response) throws IOException {

		Reservation reservation = service.findByReservationId(reservationId);
		// 设置返回的内容格式
		response.setContentType("text/json");
		// 使用gson进行json数据的解析与转换
		Gson gson = new Gson();
		// 把java集合对象转换成json字串符
		String gsonData = gson.toJson(reservation);
		// 把json字符串通过网络IO留传回客户端（如浏览器）
		response.getWriter().write(gsonData);
		// 刷新缓存
		response.getWriter().flush();

	}
	
	@RequestMapping("/findbystate")
	public void findByState(int state, HttpServletResponse response) throws IOException {

		List<Reservation> list = service.findByState(state);
		// 设置返回的内容格式
		response.setContentType("text/json");
		// 使用gson进行json数据的解析与转换
		Gson gson = new Gson();
		// 把java集合对象转换成json字串符
		String gsonData = gson.toJson(list);
		// 把json字符串通过网络IO留传回客户端（如浏览器）
		response.getWriter().write(gsonData);
		// 刷新缓存
		response.getWriter().flush();

	}

	@RequestMapping("/add")
	public void add(Reservation reservation, HttpServletResponse response) throws IOException {
		// 设置一个新增状态的默认值： 默认为新增失败
		Result result = null;
		try {
			
			System.out.println(reservation);
			service.add(reservation);
			// 如果没有错误，则认为新增成功
			result = new Result(true, "新增预约成功");
			logger.info("新增预约成功");
		} catch (Exception e) {
			// e.printStackTrace();
			result = new Result(false, "新增预约失败");
			logger.warn("新增预约失败", e);
		}

		// 使用gson进行转换成json字符串，并使用response对象返回
		String dataString = new Gson().toJson(result);
		response.setContentType("text/html");
		response.getWriter().write(dataString);
		response.getWriter().flush();
	}

	@RequestMapping("/deletebyuseraccount")
	public void deleteByUserAccount(String userAccount, HttpServletResponse response) throws IOException {
		Result result = null;
		try {
			service.deleteByUserAccount(userAccount);
			result = new Result(true, "删除预约成功");

		} catch (Exception e) {
			result = new Result(false, "删除预约失败");
		}
		// 使用gson进行转换成json字符串，并使用response对象返回
		String dataString = new Gson().toJson(result);
		response.setContentType("text/html");
		response.getWriter().write(dataString);
		response.getWriter().flush();
	}

	@RequestMapping("/deletebynurseid")
	public void deleteByNurseId(String nurseId, HttpServletResponse response) throws IOException {
		Result result = null;
		try {
			service.deleteByNurseId(nurseId);
			result = new Result(true, "删除预约成功");

		} catch (Exception e) {
			result = new Result(false, "删除预约失败");
		}
		// 使用gson进行转换成json字符串，并使用response对象返回
		String dataString = new Gson().toJson(result);
		response.setContentType("text/html");
		response.getWriter().write(dataString);
		response.getWriter().flush();

	}

	@RequestMapping("/deletebyreservationid")
	public void deleteByReservationId(String reservationId, HttpServletResponse response) throws IOException {
		Result result = null;
		try {
			service.deleteByReservationId(reservationId);
			result = new Result(true, "删除预约成功");

		} catch (Exception e) {
			result = new Result(false, "删除预约失败");
		}
		// 使用gson进行转换成json字符串，并使用response对象返回
		String dataString = new Gson().toJson(result);
		response.setContentType("text/html");
		response.getWriter().write(dataString);
		response.getWriter().flush();
	}

	@RequestMapping("/update")
	public void update(Reservation reservation, HttpServletResponse response) throws IOException {
		Result result = null;
		try {
			service.update(reservation);
			result = new Result(true, "修改预约成功");
		} catch (Exception e) {
			result = new Result(false, "修改预约失败");
		}
		String dataString = new Gson().toJson(result);
		response.setContentType("text/html");
		response.getWriter().write(dataString);
		response.getWriter().flush();
	}

	@RequestMapping("/findtotal")
	public void findTotal(HttpServletResponse response) throws IOException {
		int total = service.findTotal();
		String dataString = new Gson().toJson(total);
		response.setContentType("text/html");
		response.getWriter().write(dataString);
		response.getWriter().flush();
	}
	
	@RequestMapping("/findbymap")
	public void findByMap(Map<String, String> map, HttpServletResponse response) throws IOException {
		List<Reservation> list = service.findByMap(map);
		String dataString = new Gson().toJson(list);
		response.setContentType("text/html");
		response.getWriter().write(dataString);
		response.getWriter().flush();
	}

}
