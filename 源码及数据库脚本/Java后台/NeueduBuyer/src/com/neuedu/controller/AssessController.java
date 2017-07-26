package com.neuedu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.neuedu.model.Assess;
import com.neuedu.model.Pager;
import com.neuedu.model.Result;
import com.neuedu.service.AssessService;

/**
 * 这是spring mvc的控制类，需要使用注解标签进行注解
 * 
 * @author 杨越
 */
@Controller
@RequestMapping("/assess")
public class AssessController {

	@Autowired
	private AssessService service;

	// 用log4j日志框架，输出程序运行的记录
	private static final Logger logger = Logger.getRootLogger();

	// Pager pager是用户接收用户输入的变量，
	// HttpServletResponse response是java服务器管理的一个用户向客户端（如浏览器）进行响应的对象

	// 查询所有
	@RequestMapping("/findall")
	public void findAll(HttpServletResponse response) throws IOException {

		List<Assess> list = service.findAll();
		response.setContentType("text/Html");

		Gson gson = new Gson();
		String gsonData = gson.toJson(list);
		response.getWriter().write(gsonData);
		response.getWriter().flush();
	}

	// 分页查询
	@RequestMapping("/findbypager")
	public void findByPager(Pager pager, HttpServletResponse response) throws IOException {
		List<Assess> list = service.findByPager(pager);
		// 设置返回的内容格式
		response.setContentType("text/html");
		// 使用Gson进行json数据的解析与转换
		Gson gson = new Gson();
		// 把java集合对象转换成json字符串
		String gsonData = gson.toJson(list);
		// 把json字符串通过网络io传回客户端
		response.getWriter().write(gsonData);
		// 刷新缓存
		response.getWriter().flush();
	}

	// 按nurseid进行分页查询
	@RequestMapping("/findnurseidbypager")
	public void findNurseIdByPager(Pager pager, String nurseId, HttpServletResponse response) throws IOException {
		List<Assess> list = service.findNurseIdByPager(pager, nurseId);
		// 设置返回的内容格式
		response.setContentType("text/html");
		// 使用Gson进行json数据的解析与转换
		Gson gson = new Gson();
		// 把java集合对象转换成json字符串
		String gsonData = gson.toJson(list);
		// 把json字符串通过网络io传回客户端
		response.getWriter().write(gsonData);
		// 刷新缓存
		response.getWriter().flush();
	}

	// 按useraccount进行分页查询
	@RequestMapping("/finduseraccountbypager")
	public void findUserAccountByPager(Pager pager, String userAccount, HttpServletResponse response)
			throws IOException {
		List<Assess> list = service.findUserAccountByPager(pager, userAccount);
		// 设置返回的内容格式
		response.setContentType("text/html");
		// 使用Gson进行json数据的解析与转换
		Gson gson = new Gson();
		// 把java集合对象转换成json字符串
		String gsonData = gson.toJson(list);
		// 把json字符串通过网络io传回客户端
		response.getWriter().write(gsonData);
		// 刷新缓存
		response.getWriter().flush();
	}

	// 按assessid查询
	@RequestMapping("/findbyassessid")
	public void findByAssessId(String assessId, HttpServletResponse response) throws IOException {

		Assess assess = service.findByAssessId(assessId);
		response.setContentType("text/Html");

		Gson gson = new Gson();
		String gsonData = gson.toJson(assess);
		response.getWriter().write(gsonData);
		response.getWriter().flush();
	}

	// 按nurseid查询
	@RequestMapping("/findbynurseid")
	public void findByNurseId(String nurseId, HttpServletResponse response) throws IOException {

		List<Assess> assess = service.findByNurseId(nurseId);
		response.setContentType("text/Html");

		Gson gson = new Gson();
		String gsonData = gson.toJson(assess);
		response.getWriter().write(gsonData);
		response.getWriter().flush();
	}

	// 按useraccount查询
	@RequestMapping("/findbyuseraccount")
	public void findByUserAccount(String userAccount, HttpServletResponse response) throws IOException {

		List<Assess> assess = service.findByUserAccount(userAccount);
		response.setContentType("text/Html");

		Gson gson = new Gson();
		String gsonData = gson.toJson(assess);
		response.getWriter().write(gsonData);
		response.getWriter().flush();
	}

	// 按nurseid查询评论数
	@RequestMapping("/findtotalbynurseid")
	public void findTotalByNurseId(String nurseId, HttpServletResponse response) throws IOException {

		int total = service.findTotalByNurseId(nurseId);
		response.setContentType("text/Html");

		Gson gson = new Gson();
		String gsonData = gson.toJson(total);
		response.getWriter().write(gsonData);
		response.getWriter().flush();
	}

	// 按useraccount查询评论数
	@RequestMapping("/findtotalbyuseraccount")
	public void findTotalByUserAccount(String userAccount, HttpServletResponse response) throws IOException {

		int total = service.findTotalByUserAccount(userAccount);
		response.setContentType("text/Html");

		Gson gson = new Gson();
		String gsonData = gson.toJson(total);
		response.getWriter().write(gsonData);
		response.getWriter().flush();
	}

	// 查询评论总数
	@RequestMapping("/findtotal")
	public void findTotal(HttpServletResponse response) throws IOException {

		int total = service.findTotal();
		response.setContentType("text/Html");

		Gson gson = new Gson();
		String gsonData = gson.toJson(total);
		response.getWriter().write(gsonData);
		response.getWriter().flush();
	}

	// 增加评论
	@RequestMapping("/add")
	private void add(Assess assess, HttpServletResponse response) throws IOException {

		boolean result = false;
		try {
			service.add(assess);
			result = true;
		} catch (Exception e) {
			// e.printStackTrace();
			logger.warn("新增评价失败！", e);
			result = false;
		}
		// 根据结果向客户端返回json提示信息
		Result result2 = null;
		if (result) {
			result2 = new Result(result, "新增评价成功！");
		} else {
			result2 = new Result(result, "新增评价失败！");
		}

		// 使用gson进行转换成json字符串，并使用response对象返回
		String dataString = new Gson().toJson(result2);
		response.setContentType("text/html");
		response.getWriter().write(dataString);
		response.getWriter().flush();
	}

	// 修改评论
	@RequestMapping("/update")
	public void update(Assess assess, HttpServletResponse response) throws IOException {

		Result result = null;
		try {
			service.update(assess);
			result = new Result(true, "修改成功");
		} catch (Exception e) {
			result = new Result(false, "修改失败");
		}

		String dataString = new Gson().toJson(result);
		response.setContentType("text/html");
		response.getWriter().write(dataString);
		response.getWriter().flush();

	}

	// 删除评论
	// 按assessid删除
	@RequestMapping("/deletebyassessid")
	public void deleteByAssessId(String assessId, HttpServletResponse response) throws IOException {
		Result result = null;
		try {
			service.deleteByAssessId(assessId);
			result = new Result(true, "删除评价成功！");
		} catch (Exception e) {
			result = new Result(false, "删除评价成功！");
		}
		String dataString = new Gson().toJson(result);
		response.setContentType("text/html");
		response.getWriter().write(dataString);
		response.getWriter().flush();
	}

	// 按nurseid删除
	@RequestMapping("deletebynurseid")
	public void deleteByNurseId(String nurseId, HttpServletResponse response) throws IOException {
		Result result = null;
		try {
			service.deleteByNurseId(nurseId);
			result = new Result(true, "删除评价成功！");
		} catch (Exception e) {
			result = new Result(false, "删除评价成功！");
		}
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
			result = new Result(true, "删除评价成功！");
		} catch (Exception e) {
			result = new Result(false, "删除评价成功！");
		}
		String dataString = new Gson().toJson(result);
		response.setContentType("text/html");
		response.getWriter().write(dataString);
		response.getWriter().flush();
	}

}
