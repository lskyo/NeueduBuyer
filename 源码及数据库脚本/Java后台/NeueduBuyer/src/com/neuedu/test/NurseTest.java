package com.neuedu.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.jni.Time;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.neuedu.mapper.NurseMapper;
import com.neuedu.model.Nurse;
import com.neuedu.model.Pager;
import com.neuedu.service.NurseService;

/**
 * 
 * @author 青计
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/config/spring-common.xml")
public class NurseTest {
	@Autowired
	private NurseMapper mapper;

	@Autowired
	private NurseService service;
	// 查找

	public void testFindAll() {
		List<Nurse> list = service.findAll();
		for (Nurse dep : list) {
			System.out.println(dep);
		}
	}
    //@Test
	public void testFindBypager() {
		Pager pager = new Pager(1, 2);
		int total = service.findTotal();
		pager.setTotal(total);
		System.out.println("一共可以分" + pager.getPages() + "页");
		List<Nurse> list = service.findByPager(pager);
		for (Nurse nurse : list) {
			System.out.println(nurse);
		}
	}
	// 按类查找

	public void testFindByNurseId() {
		Nurse nurse = service.findByNurseId("nurse1");
		System.out.println(nurse);
	}

	public void testFindByNurseName() {
		List<Nurse> list = service.findByNurseName("张三");
		if (list.size() > 0) {
			for (Nurse nurse : list) {
				System.out.println(list);
			}
		} else
			System.out.println("查询结果为零");
	}

	public void testFindBySex() {
		List<Nurse> list = service.findBySex(0);
		if (list.size() > 0) {
			for (Nurse nurse : list) {
				System.out.println(list);
			}
		} else
			System.out.println("查询结果为零");
	}

	public void testFindByAge() {
		List<Nurse> list = service.findByAge(23);
		if (list.size() > 0) {
			for (Nurse nurse : list) {
				System.out.println(list);
			}
		} else
			System.out.println("查询结果为零");
	}

	public void testFindByMajor() {
		List<Nurse> list = service.findByMajor("医疗管理");
		if (list.size() > 0) {
			for (Nurse nurse : list) {
				System.out.println(list);
			}
		} else
			System.out.println("查询结果为零");
	}

	public void testFindByWage() {
		List<Nurse> list = service.findByWage(20);
		if (list.size() > 0) {
			for (Nurse nurse : list) {
				System.out.println(list);
			}
		} else
			System.out.println("查询结果为零");
	}

	public void testFindByIsfree() {
		List<Nurse> list = service.findByIsfree(0);
		if (list.size() > 0) {
			for (Nurse nurse : list) {
				System.out.println(list);
			}
		} else
			System.out.println("查询结果为零");
	}

	public void testFindByNurseIdcard() {
		Nurse nurse = service.findByNurseIdcard("123456789123456789");
		System.out.println(nurse);
	}

	public void testFindByNurseLevel() {
		List<Nurse> list = service.findByNurseLevel(3);
		if (list.size() > 0) {
			for (Nurse nurse : list) {
				System.out.println(list);
			}
		} else
			System.out.println("查询结果为零");
	}
	// 新增

	public void testAdd() {
		Nurse nurse = new Nurse();
		nurse.setNurseId("9588");
		nurse.setNurseName("罗星华");
		nurse.setNurseIdcard("98623985985695756");
		nurse.setSex(0);
		nurse.setAge(98);
		nurse.setMajor("职业中单30年");
		//nurse.setCreateTime(new Date());
		//nurse.setBirthday(new Date());
		nurse.setIsfree(0);
		nurse.setIntroduce("大家好，来开黑啊 我打VN");
		nurse.setAddress("518");
		nurse.setNurseLevel(0);
		nurse.setNursePicture("11");
		nurse.setWage(1);
		try {
			service.add(nurse);
			System.out.println("新增成功");
		} catch (Exception e) {
			e.printStackTrace();// 打印堆栈异常信息
			System.out.println("新增失败");
		}
	}

	// 修改
	@Test
	public void testUpdate() {
		// 1. 查询出要修改的数据
		Nurse nurse = service.findByNurseId("nurse1");
		System.out.println("修改前：");
		System.out.println(nurse);
		Map<String, String> map = new HashMap<String, String>();
		map.put("nurseId", nurse.getNurseId());
		map.put("nurseName", "666");
		map.put("age","100");
		try {
			//service.update(map);
			System.out.println("更新成功");
			System.out.println("修改后：");
			nurse = service.findByNurseId("nurse1");
			System.out.println(nurse);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("更新失败");
		}
	}

	// 删除
	
	public void testDeleteByNurseId() {
		// 1.确定要删除的数据
		String id = "nurse3";
		// 2.调用接口进行删除
		try {
			service.deleteByNurseId("nurse3");
			System.out.println("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("删除失败");
		}
	}
	
	//@Test
	public void testFindByNurseIds(){
		System.out.println("------------------testFindByNurseIds--------------------");
		List<String> ids = new ArrayList<String>();
		ids.add("nurse1");
		ids.add("nurse2");
		List<Nurse> list = (List<Nurse>) service.findByNurseIds(ids);
		for (Nurse nurse : list) {
			System.out.println(nurse);
		}
	}
	
	
	
	
	//@Test
	public void testFindByMap(){
		List<Nurse> list = null;
		Map<String, String> map = new HashMap<String, String>();
		System.out.println("------------------nurseLevel=2--------------------");
		map.put("nurseLevel", "0");
		//list = service.findByMap(map);
		for (Nurse nurse : list) {
			System.out.println(nurse);
		}
		
		
		System.out.println("------------------wage=20--------------------");
		map.put("wage", "20");
		//list = mapper.findByMap(map);
		for (Nurse nurse : list) {
			System.out.println(nurse);
		}
//		System.out.println("------------------nurseLevel=2--------------------");
//		map.put("nurseLevel", "2");
//		list = mapper.findByMap(map);
//		for (Nurse nurse : list) {
//			System.out.println(nurse);
//		}
		//String.valueOf(i)
		
	}

}
