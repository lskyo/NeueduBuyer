package com.neuedu.controller;

import java.io.IOException;
import java.util.HashMap;
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
import com.neuedu.model.Nurse;
import com.neuedu.model.Pager;
import com.neuedu.model.Result;
import com.neuedu.service.NurseService;


/**
 * 
 * @author 青计
 * @update 罗星华
 * @version 1.1
 *  
 * V1.1 增加findbymap，findbynurseids接口
 */
@Controller
@RequestMapping("/nurse")
public class NurseController {
	
	private static final Logger logger = Logger.getRootLogger();
	@Autowired
	private NurseService service;
	
	//查找
	@RequestMapping("/findall")
	public void findAll(Pager pager, HttpServletResponse response) throws IOException {

		List<Nurse> list = service.findAll();
		// 设置返回的内容格式
		response.setContentType("text/json");
		Gson gson = new Gson();
		String gsonData = gson.toJson(list);
		response.getWriter().write(gsonData);
		response.getWriter().flush();
	}
    @RequestMapping("/findbypager")
	public void findByPager(Pager pager, HttpServletResponse response) throws IOException {
        List<Nurse> list = service.findByPager(pager);
		response.setContentType("text/json");
		Gson gson = new Gson();
		String gsonData = gson.toJson(list);
		response.getWriter().write(gsonData);
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
    //按类查找
    @RequestMapping("/findbynurseid")
	public void findByNurseId(String nurseId, HttpServletResponse response) throws IOException {

	    Nurse nurse = service.findByNurseId(nurseId);
		response.setContentType("text/json");
		Gson gson = new Gson();
		String gsonData = gson.toJson(nurse);
		response.getWriter().write(gsonData);
		response.getWriter().flush();
      }
    @RequestMapping("/findbynursename")
	public void findByNursename(String nurseName, HttpServletResponse response) throws IOException {
        List<Nurse> list = service.findByNurseName(nurseName);
		response.setContentType("text/json");
		Gson gson = new Gson();
		String gsonData = gson.toJson(list);
		response.getWriter().write(gsonData);
		response.getWriter().flush();
	}  
    @RequestMapping("/findbynurseidcard")
	public void findByNurseIdcard(String nurseIdcard, HttpServletResponse response) throws IOException {

	    Nurse nurse = service.findByNurseIdcard(nurseIdcard);
		response.setContentType("text/json");
		Gson gson = new Gson();
		String gsonData = gson.toJson(nurse);
		response.getWriter().write(gsonData);
		response.getWriter().flush();
      }
    @RequestMapping("/findbysex")
   	public void findBySex(int sex, HttpServletResponse response) throws IOException {
           List<Nurse> list = service.findBySex(sex);
   		response.setContentType("text/json");
   		Gson gson = new Gson();
   		String gsonData = gson.toJson(list);
   		response.getWriter().write(gsonData);
   		response.getWriter().flush();
   	}  
    @RequestMapping("/findbyage")
   	public void findByAge(int age, HttpServletResponse response) throws IOException {
           List<Nurse> list = service.findByAge(age);
   		response.setContentType("text/json");
   		Gson gson = new Gson();
   		String gsonData = gson.toJson(list);
   		response.getWriter().write(gsonData);
   		response.getWriter().flush();
   	}  
    @RequestMapping("/findbymajor")
   	public void findByMajor(String major, HttpServletResponse response) throws IOException {
           List<Nurse> list = service.findByMajor(major);
   		response.setContentType("text/json");
   		Gson gson = new Gson();
   		String gsonData = gson.toJson(list);
   		response.getWriter().write(gsonData);
   		response.getWriter().flush();
   	}  
    @RequestMapping("/findbyisfree")
   	public void findByIsfree(int isfree, HttpServletResponse response) throws IOException {
        List<Nurse> list = service.findByIsfree(isfree);
   		response.setContentType("text/json");
   		Gson gson = new Gson();
   		String gsonData = gson.toJson(list);
   		response.getWriter().write(gsonData);
   		response.getWriter().flush();
   	}  
    @RequestMapping("/findbywage")
   	public void findByWage(int wage, HttpServletResponse response) throws IOException {
           List<Nurse> list = service.findByWage(wage);
   		response.setContentType("text/json");
   		Gson gson = new Gson();
   		String gsonData = gson.toJson(list);
   		response.getWriter().write(gsonData);
   		response.getWriter().flush();
   	}  
    @RequestMapping("/findbynurselevel")
   	public void findByNurseLevel(int nurseLevel, HttpServletResponse response) throws IOException {
        List<Nurse> list = service.findByNurseLevel(nurseLevel);
   		response.setContentType("text/json");
   		Gson gson = new Gson();
   		String gsonData = gson.toJson(list);
   		response.getWriter().write(gsonData);
   		response.getWriter().flush();
   	}  
    //新增
    @RequestMapping("/add")
	public void add(Nurse nurse, HttpServletResponse response) throws IOException {
		Result result = null;
		try {
			service.add(nurse);
			// 如果没有错误，则认为新增成功
			result = new Result(true, "新增护工成功");
			logger.info("新增护工成功");
		} catch (Exception e) {
			// e.printStackTrace();
			result = new Result(false, "新增护工失败");
			logger.warn("新增护工失败", e);
		   }
				String dataString = new Gson().toJson(result);
				response.setContentType("text/html");
				response.getWriter().write(dataString);
				response.getWriter().flush();
        }
    //删除
    @RequestMapping("/deletebynurseid")
	public void deleteByNurseId(String nurseId, HttpServletResponse response) throws IOException {
		Result result = null;
		try {
			service.deleteByNurseId(nurseId);
			result = new Result(true, "删除护工成功");
          } catch (Exception e) {
			result = new Result(false, "删除护工失败");
		}
		String dataString = new Gson().toJson(result);
		response.setContentType("text/html");
		response.getWriter().write(dataString);
		response.getWriter().flush();
  }
    @RequestMapping("/update")
	public void update(Nurse nurse, HttpServletResponse response) throws IOException {
		Result result = null;
		try {
			System.out.println(nurse);
			service.update(nurse);
			result = new Result(true, "修改护工成功");
		} catch (Exception e) {
			e.printStackTrace();
			result = new Result(false, "修改护工失败");
		}
		String dataString = new Gson().toJson(result);
		response.setContentType("text/html");
		response.getWriter().write(dataString);
		response.getWriter().flush();
	}
    
    @RequestMapping("/findbymap")
	public void findByMap(Nurse nurse, HttpServletResponse response) throws IOException {
    	List<Nurse> list = service.findByMap(nurse);
		String dataString = new Gson().toJson(list);
		response.setContentType("text/html");
		response.getWriter().write(dataString);
		response.getWriter().flush();
	}
    
    @RequestMapping("/findbynurseids")
	public void findByNurseIds(List<String> ids, HttpServletResponse response) throws IOException {
    	List<Nurse> list = service.findByNurseIds(ids);
		String dataString = new Gson().toJson(list);
		response.setContentType("text/html");
		response.getWriter().write(dataString);
		response.getWriter().flush();
	}
    
    
    
}
