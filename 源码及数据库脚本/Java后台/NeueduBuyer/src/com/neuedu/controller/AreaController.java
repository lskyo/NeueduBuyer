package com.neuedu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.neuedu.model.Area;

import com.neuedu.model.Result;
import com.neuedu.service.AreaService;

/**
 * 
 * @author 林培坚
 *
 */
@Controller
@RequestMapping("/area")
public class AreaController {

	// 使用log4j日志框架，日志框架用于输出程序运行的记录（即做运行记录）
	// 实例化一个log4j日志器
	private static final Logger logger = Logger.getRootLogger();

	// 在控制层通过spring ioc 核心进行整合service层
	@Autowired
	private AreaService service;

	// Pager pager是用于接收用户输入的变量，
	// HttpServletRequest response是JAva服务器管理的一个用户向客户端（如浏览器进行响应的对象

	// 新增区域
	@RequestMapping("/add")
	private void add(Area area, HttpServletResponse response) throws IOException {

		boolean result = false;
		try {
			service.add(area);
			result = true;
		} catch (Exception e) {
			// e.printStackTrace();
			logger.warn("新增失败！", e);
			result = false;
		}
		// 根据结果向客户端返回json提示信息
		Result result2 = null;
		if (result) {
			result2 = new Result(result, "新增成功！");
		} else {
			result2 = new Result(result, "新增失败！");
		}

		// 使用gson进行转换成json字符串，并使用response对象返回
		String dataString = new Gson().toJson(result2);
		response.setContentType("text/html");
		response.getWriter().write(dataString);
		response.getWriter().flush();
	}

	// 删除区域
	@RequestMapping("/deletearea")
	public void delete(int areaId, HttpServletResponse response) throws IOException {
		Result result = null;
		try {
			service.deleteByAreaId(areaId);
			result = new Result(true, "删除成功");

		} catch (Exception e) {
			result = new Result(false, "删除失败");
		}
		// 使用gson进行转换成json字符串，并使用response对象返回
		String dataString = new Gson().toJson(result);
		response.setContentType("text/html");
		response.getWriter().write(dataString);
		response.getWriter().flush();
	}

	// 修改区域
	@RequestMapping("/update")
	public void updateArea(Area area, HttpServletResponse response) throws IOException {
		Result result = null;
		try {
			service.update(area);
			result = new Result(true, "修改成功");

		} catch (Exception e) {
			result = new Result(false, "修改失败");
		}
		// 使用gson进行转换成json字符串，并使用response对象返回
		String dataString = new Gson().toJson(result);
		response.setContentType("text/html");
		response.getWriter().write(dataString);
		response.getWriter().flush();

	}

	// 按id查询
	@RequestMapping("/findbyareaid")
	public void findByAreaId(int areaId, HttpServletResponse response) throws IOException {

		Area area = service.findByAreaId(areaId);
		response.setContentType("text/Html");
		Gson gson = new Gson();
		String gsonData = gson.toJson(area);
		response.getWriter().write(gsonData);
		response.getWriter().flush();
	}

	// 按编号查询
	@RequestMapping("/findbycode")
	public void findByCoding(String code, HttpServletResponse response) throws IOException {

		Area area = service.findByCoding(code);
		response.setContentType("text/Html");

		Gson gson = new Gson();
		String gsonData = gson.toJson(area);
		response.getWriter().write(gsonData);
		response.getWriter().flush();
	}

	// 按国家查询省份
	@RequestMapping("/findprovincebycountryid")
	public void findProvinceByCountryId(String countryId, HttpServletResponse response) throws IOException {

		List<Area> list = service.findProvinceByCountry(countryId);
		response.setContentType("text/Html");

		Gson gson = new Gson();
		String gsonData = gson.toJson(list);
		response.getWriter().write(gsonData);
		response.getWriter().flush();
	}

	// 按省份查询市
	@RequestMapping("/findcitybyprovinceid")
	public void findCityByProvinceId(String provinceId, HttpServletResponse response) throws IOException {

		List<Area> list = service.findCityByProvince(provinceId);
		response.setContentType("text/Html");

		Gson gson = new Gson();
		String gsonData = gson.toJson(list);
		response.getWriter().write(gsonData);
		response.getWriter().flush();
	}

	// 按市查询区
	@RequestMapping("/finddistrictbycityid")
	public void findDistrictByCityId(String cityId, HttpServletResponse response) throws IOException {

		List<Area> list = service.findDistrictByCity(cityId);
		response.setContentType("text/Html");

		Gson gson = new Gson();
		String gsonData = gson.toJson(list);
		response.getWriter().write(gsonData);
		response.getWriter().flush();
	}

	// 查询所有区域
	@RequestMapping("/findall")
	public void findAll(HttpServletResponse response) throws IOException {

		List<Area> list = service.findAll();
		response.setContentType("text/Html");
		Gson gson = new Gson();
		String gsonData = gson.toJson(list);
		response.getWriter().write(gsonData);
		response.getWriter().flush();
	}

	// 查询省
	@RequestMapping("/findprovince")
	public void findProvince(String provinceName, HttpServletResponse response) throws IOException {

		Area area = service.findProvince(provinceName);
		response.setContentType("text/Html");
		Gson gson = new Gson();
		String gsonData = gson.toJson(area);
		response.getWriter().write(gsonData);
		response.getWriter().flush();
	}

	// 查询市
	@RequestMapping("/findcity")
	public void findCity(String cityName, HttpServletResponse response) throws IOException {

		Area area = service.findCity(cityName);
		response.setContentType("text/Html");
		Gson gson = new Gson();
		String gsonData = gson.toJson(area);
		response.getWriter().write(gsonData);
		response.getWriter().flush();
	}

	// 查询区
	@RequestMapping("/finddistrict")
	public void findDistrict(String districtName, HttpServletResponse response) throws IOException {

		List<Area> list = service.findDistrict(districtName);
		response.setContentType("text/Html");
		Gson gson = new Gson();
		String gsonData = gson.toJson(list);
		response.getWriter().write(gsonData);
	}

}
