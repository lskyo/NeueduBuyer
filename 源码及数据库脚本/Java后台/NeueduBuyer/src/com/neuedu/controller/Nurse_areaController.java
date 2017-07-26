package com.neuedu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.LifecycleListener;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.neuedu.model.Employee;
//import com.neuedu.model.Employee;
import com.neuedu.model.Nurse_area;
import com.neuedu.model.Pager;
import com.neuedu.model.Result;
import com.neuedu.service.Nurse_areaService;

/**
 * @author 刘志杰
 */
@Controller
@RequestMapping("/nursearea")
public class Nurse_areaController {

	private static final Logger logger = Logger.getRootLogger();

	@Autowired
	private Nurse_areaService service;

	// 查询全部
	@RequestMapping("/findall")
	public void findAll(HttpServletResponse response) throws IOException {

		List<Nurse_area> list = service.findAll();
		response.setContentType("text/Html");

		Gson gson = new Gson();
		String gsonData = gson.toJson(list);
		response.getWriter().write(gsonData);
		response.getWriter().flush();
	}

	// 根据区域编号查询护工
	@RequestMapping("/findbyareaid")
	public void findByAreaId(int areaId, HttpServletResponse response) throws IOException {

		List<Nurse_area> list = service.findByAreaId(areaId);
		response.setContentType("text/Html");

		Gson gson = new Gson();
		String gsonData = gson.toJson(list);
		response.getWriter().write(gsonData);
		response.getWriter().flush();
	}

	// 根据员工编号查询员工
	@RequestMapping("/findbynurseid")
	public void findByNurseId(String nurseId, HttpServletResponse response) throws IOException {

		List<Nurse_area> list = service.findByNurseId(nurseId);
		response.setContentType("text/Html");

		Gson gson = new Gson();
		String gsonData = gson.toJson(list);
		response.getWriter().write(gsonData);
		response.getWriter().flush();
	}

	// 根据pri编号查询员工
	@RequestMapping("/findbypriid")
	public void findByPriId(int priId, HttpServletResponse response) throws IOException {

		Nurse_area nurse_area = service.findByPriId(priId);
		response.setContentType("text/Html");

		Gson gson = new Gson();
		String gsonData = gson.toJson(nurse_area);
		response.getWriter().write(gsonData);
		response.getWriter().flush();
	}

	// 查询总数
	@RequestMapping("/findtotal")
	private void findTotal(HttpServletResponse response) throws IOException {

		int total = service.findTotal();
		response.setContentType("text/Html");
		Gson gson = new Gson();
		String gsonData = gson.toJson(total);
		response.getWriter().write(gsonData);
		response.getWriter().flush();
	}

	// 分页查询
	@RequestMapping("/findbypager")
	public void findByPager(Pager pager, HttpServletResponse response) throws IOException {

		List<Nurse_area> list = service.findByPager(pager);
		response.setContentType("text/Html");

		Gson gson = new Gson();
		String gsonData = gson.toJson(list);
		response.getWriter().write(gsonData);
		response.getWriter().flush();
	}

	// 新增员工
	@RequestMapping("/add")
	public void add(Nurse_area nurse_area, HttpServletResponse response) throws IOException {

		boolean result = false;
		try {
			service.add(nurse_area);
			// 如果没有错误，则认为新增成功
			result = true;
		} catch (Exception e) {
			logger.warn("新增失败", e);
		}
		Result result2 = null;
		if (result) {// 如果新增成功
			result2 = new Result(result, "新增成功");
		} else {
			result2 = new Result(result, "新增失败");
		}
		String dataString = new Gson().toJson(result2);
		response.setContentType("text/html");
		response.getWriter().write(dataString);
		response.getWriter().flush();
	}

	// 修改护工信息
	@RequestMapping("/update")
	public void update(Nurse_area nurse_area, HttpServletResponse response) throws IOException {

		Result result = null;
		try {
			service.update(nurse_area);
			result = new Result(true, "修改成功");
		} catch (Exception e) {
			result = new Result(false, "修改失败");
		}

		String dataString = new Gson().toJson(result);
		response.setContentType("text/html");
		response.getWriter().write(dataString);
		response.getWriter().flush();
	}

	// 根据员工编号删除员工
	@RequestMapping("/deletebynurseid")
	public void deleteByNurseId(String nurseId, HttpServletResponse response) throws IOException {

		Result result = null;
		try {
			service.deleteByNurseId(nurseId);
			result = new Result(true, "删除成功");
		} catch (Exception e) {
			result = new Result(false, "删除失败");
		}

		String dataString = new Gson().toJson(result);
		response.setContentType("text/html");
		response.getWriter().write(dataString);
		response.getWriter().flush();
	}

	// 根据pri编号删除员工
	@RequestMapping("/deletebypriid")
	public void deleteByPriId(int priId, HttpServletResponse response) throws IOException {

		Result result = null;
		try {
			service.deleteByPriId(priId);
			result = new Result(true, "删除成功");
		} catch (Exception e) {
			result = new Result(false, "删除失败");
		}

		String dataString = new Gson().toJson(result);
		response.setContentType("text/html");
		response.getWriter().write(dataString);
		response.getWriter().flush();
	}

	// 根据区域编号删除员工
	@RequestMapping("/deletebyareaid")
	public void deleteByAreaId(int areaId, HttpServletResponse response) throws IOException {

		Result result = null;
		try {
			service.deleteByAreaId(areaId);
			result = new Result(true, "删除成功");
		} catch (Exception e) {
			result = new Result(false, "删除失败");
		}
		String dataString = new Gson().toJson(result);
		response.setContentType("text/html");
		response.getWriter().write(dataString);
		response.getWriter().flush();
	}

}
