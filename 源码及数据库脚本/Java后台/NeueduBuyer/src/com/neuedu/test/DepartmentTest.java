package com.neuedu.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neuedu.mapper.DepartmentMapper;
import com.neuedu.model.Department;
import com.neuedu.model.Pager;
import com.neuedu.service.DepartmentService;


/**
 * Department测试类
 * @author 罗星华
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/config/spring-common.xml")
public class DepartmentTest {

	
	//测试部门数据库操作接口
	//使用spring的核心ioc容器对DepartmentMapper实例化
	@Autowired
	private DepartmentMapper mapper;
	
	@Autowired
	private DepartmentService service;
	
	
	//@Test
	public void testFindTotal(){
		int total = service.findTotal();
		System.out.println("total="+total);
	}
	
	
	@Test
	public void testFindAll(){
		List<Department> list = service.findAll();
		for(Department dep : list){
			System.out.println("编号：" + dep.getDepartmentId() + "   名字：" + dep.getDepartmentName());
		}
	
	}
	
	//@Test
	public void testAdd(){
		testFindAll();
		System.out.println("-------------------------");
		
		//构造新数据
		Department department = new Department();
		department.setDepartmentId(18);
		department.setDepartmentName("服务部2");
		
		//新增数据
		try{
			service.add(department);
			System.out.println("***done***");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("***faile***");
		}
		
		
		System.out.println("-------------------------");
		testFindAll();
		
	}

	//@Test
	public void testUpdate(){
		
		testFindAll();
		System.out.println("-------------------------");
		
		
		//提供要修改的数据
		Department department = new Department();
		department.setDepartmentId(18);
		department.setDepartmentName("销售部2");
		
		//调用数据接口操作数据库
		try{
			service.update(department);
			System.out.println("update success!");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("update faile!");
		}
		
		System.out.println("-------------------------");
		testFindAll();
		
	}
	
	@Test
	public void testDeleteById(){
		int id = 18;
		testFindAll();
		System.out.println("-------------------------");
		
		try{
			service.deleteById(id);
			System.out.println("delete success!");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("delete faile!");
		}
		
		
		System.out.println("-------------------------");
		testFindAll();
		
	}
	
	//@Test
	public void testFindById(){
		int id = 3;
		Department department = null;
		
		try{
			department = service.findById(id);
			System.out.println(department);
			//department.setDepartmentName(department.getDepartmentName() + "1");
			//service.update(department);
			//department = service.findById(id);
			//System.out.println(department);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("select faile!");
		}
	}
	
	//@Test
	public void testFindByPage(){
		testFindAll();
		
		//测试分页
		Pager pager = new Pager(2,2);
		
		//查询出总记录数
		int total = service.findTotal();
		pager.setTotal(total);
		
		System.out.println("一共可以分 " + pager.getPages() + " 页,现查询第 " + pager.getPage() + " 页。");
		
		List<Department> list = service.findByPager(pager);
		for(Department department :list){
			System.out.println(department);
		}
		
	}
	
}
