package com.neuedu.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.neuedu.mapper.EmployeeMapper;
import com.neuedu.mapper.Nurse_areaMapper;
import com.neuedu.model.Employee;
import com.neuedu.model.Nurse_area;
import com.neuedu.model.Pager;
import com.neuedu.service.EmployeeService;
import com.neuedu.service.Nurse_areaService;

/**
 * @author 刘志杰
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/config/spring-common.xml")
public class Nurse_areaTest {
	@Autowired
	private Nurse_areaMapper mapper;
	@Autowired
	private Nurse_areaService service;

	// 查询所有
	// @Test
	public void testFindAll() {
		System.out.println("------------------------------------------------");
		List<Nurse_area> list = service.findAll();
		for (Nurse_area nur : list) {
			System.out.println(nur);
		} // end testFindAll
	}

	// 根据区域编号查询
	// @Test
	public void testFindByAreaId() {
		System.out.println("------------------------------------------------");
		List<Nurse_area> list = service.findByAreaId(5);
		try {
			System.out.println("find success");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("find faile!");
		}
		for (Nurse_area nur : list) {
			System.out.println(nur);
		} // end testFindAll
	}

	// 根据护工编号查询
	// @Test
	public void testFindByNurseId() {
		System.out.println("------------------------------------------------");
		List<Nurse_area> list = service.findByNurseId("nurse1");
		try {
			System.out.println("find success");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("find faile!");
		}

		for (Nurse_area nur : list) {
			System.out.println(nur);
		} // end testFindAll
	}

	// 根据pri编号查询
	// @Test
	public void testFindByPriId() {
		System.out.println("------------------------------------------------");
		Nurse_area nurse_area = service.findByPriId(2);
		try {
			System.out.println("find success");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("find faile!");
		}
		System.out.println(nurse_area);

	}

	// 查询总数
	// @Test
	public void testFindTotal() {
		int total = service.findTotal();
		System.out.println("total=" + total);
	}

	// 分页查询
	@Test
	public void testFindByPage() {
		Pager pager = new Pager(1, 2);
		int total = service.findTotal();
		pager.setTotal(total);
		System.out.println("一共可以分 " + pager.getPages() + " 页,现查询第 " + pager.getPage() + " 页。");
		List<Nurse_area> list = service.findByPager(pager);
		for (Nurse_area nurse_area : list) {
			System.out.println(nurse_area);
		}
	}

	// 新增桥表信息
	// @Test
	public void testAdd() {
		testFindAll();
		System.out.println("------------------------------------------------");
		Nurse_area nurse_area = new Nurse_area();
		nurse_area.setPriId(8);
		nurse_area.setNurseId("nurse14");
		nurse_area.setAreaId(7);
		try {
			service.add(nurse_area);
			System.out.println("***done***");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("***faile***");
		}
		System.out.println("-------------------------");
		testFindAll();
	}

	// 更新护工信息
	// @Test
	public void testUpdate() {
		testFindAll();
		System.out.println("-------------------------");
		Nurse_area nurse_area = service.findByPriId(1);
		nurse_area.setNurseId("nurse20");
		nurse_area.setAreaId(3);
		try {
			service.update(nurse_area);
			System.out.println("update success!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("update faile!");
		}
		System.out.println("-------------------------");
		testFindAll();
	}

	// 根据护工编号进行删除
	// @Test
	public void testDeleteByNurseId() {
		String nurse_id = "nurse2";
		testFindAll();
		System.out.println("-------------------------");
		try {
			service.deleteByNurseId(nurse_id);
			System.out.println("delete success!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("delete faile!");
		}
		System.out.println("-------------------------");
		testFindAll();
	}

	// 根据pri编号进行删除
	//@Test
	public void testDeleteByPriId() {
		int pri_id = 1;
		testFindAll();
		System.out.println("-------------------------");
		try {
			service.deleteByPriId(pri_id);
			System.out.println("delete success!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("delete faile!");
		}
		System.out.println("-------------------------");
		testFindAll();
	}

	// 根据区域编号进行删除
	// @Test
	public void testDeleteByAreaId() {
		int area_id = 4;
		testFindAll();
		System.out.println("-------------------------");
		try {
			service.deleteByAreaId(area_id);
			System.out.println("delete success!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("delete faile!");
		}
		System.out.println("-------------------------");
		testFindAll();
	}
}
