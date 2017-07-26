package com.neuedu.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neuedu.mapper.DepartmentMapper;
import com.neuedu.mapper.EmployeeMapper;
import com.neuedu.model.Department;
import com.neuedu.model.Employee;
import com.neuedu.model.Pager;
import com.neuedu.service.DepartmentService;
import com.neuedu.service.EmployeeService;

/**
 * @author 刘志杰
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/config/spring-common.xml")
public class EmployeeTest {
	// 测试员工数据库操作接口
	// 使用spring的核心ioc功能完成对EmployeeMapper的实例化操作
	//
	@Autowired
	private EmployeeMapper mapper;

	// 业务层代码也需要进行测试
	// 针对业务接口进行测试
	// 使用spring的核心ioc功能完成对EmployeeService的实例化操作
	@Autowired
	private EmployeeService service;

	// 编写测试方法，查询数据并显示
	// 测试使用junit单元测试框架进行测试

	// 查询所有
	// @Test
	public void testFindAll() {
		System.out.println("------------------------------------------------");
		List<Employee> list = service.findAll();
		for (Employee dep : list) {
			System.out.println("员工编号" + dep.getEmployeeId() + ",  员工名称：  " + dep.getEmployeeName());
		} // end testFindAll
	}

	// 新增员工信息
	// @Test
	public void testAdd() {
		testFindAll();
		System.out.println("------------------------------------------------");

		// 构造新数据
		Employee employee = new Employee();
		employee.setEmployeeId("333");
		employee.setEmployeeAccount("yangyue333");
		employee.setPassword("11Gzzz");
		employee.setEmployeeName("yangyue");
		employee.setDepartmentId(3);
		employee.setEmployeeMobile("1111111");
		// 新增数据
		try {
			service.add(employee);
			System.out.println("***done***");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("***faile***");
		}

		System.out.println("-------------------------");
		testFindAll();
	}

	// 更新员工信息
	// @Test
	public void testUpdate() {

		testFindAll();
		System.out.println("-------------------------");
		// 提供要修改的数据
		Employee employee = service.findByEmployeeId("abc456");
		employee.setEmployeeName("miaodongwang");

		// 调用数据接口操作数据库
		try {
			service.update(employee);
			System.out.println("update success!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("update faile!");
		}

		System.out.println("-------------------------");
		testFindAll();
	}

	// 根据员工编号进行删除
	// @Test
	public void testDeleteByEmployeeId() {
		String employee_id = "A123456";
		testFindAll();
		System.out.println("-------------------------");

		try {
			service.deleteByEmployeeId(employee_id);
			System.out.println("delete success!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("delete faile!");
		}

		System.out.println("-------------------------");
		testFindAll();
	}

	// 根据部门编号进行删除
	// @Test
	public void testDeleteByDepartmentId() {
		int department_id = 1;
		testFindAll();
		System.out.println("-------------------------");

		try {
			service.deleteByDepartmentId(department_id);
			System.out.println("delete success!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("delete faile!");
		}

		System.out.println("-------------------------");
		testFindAll();
	}

	// 根据员工编号查询
	// @Test
	public void testFindByEmployeeId() {
		String employee_id = "employee1";
		Employee employee = null;
		System.out.println("------------------------------------------------");
		try {
			employee = service.findByEmployeeId(employee_id);
			System.out.println("find success");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("delete faile!");
		}
		System.out.println("-------------------------");
		System.out.println(employee);

	}

	// 根据部门编号查询
	// @Test
	public void testFindByDepartmentId() {
		System.out.println("------------------------------------------------");
		List<Employee> list = service.findByDepartmentId(1);
		try {

			System.out.println("find success");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("delete faile!");
		}
		for (Employee dep : list) {
			System.out.println("员工编号" + dep.getEmployeeId() + ",  员工名称：  " + dep.getEmployeeName());
		} // end testFindAll
	}

	// 根据员工账号查询
	// @Test
	public void testFindByEmployeeAccount() {
		String employee_account = "12341234";
		Employee employee = null;
		System.out.println("------------------------------------------------");
		try {
			employee = service.findByEmployeeAccount(employee_account);
			System.out.println("find success");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("delete faile!");
		}
		System.out.println("-------------------------");
		System.out.println(employee);

	}

	// 根据员工手机号查询
	// @Test
	public void testFindByEmployeeMobile() {
		String employee_mobile = "12345678912";
		Employee employee = null;
		System.out.println("------------------------------------------------");
		try {
			employee = service.findByEmployeeMobile(employee_mobile);
			System.out.println("find success");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("delete faile!");
		}
		System.out.println("-------------------------");
		System.out.println(employee);
	}

	// 根据员工名进行查询
	// @Test
	public void testFindByEmployeeName() {
		String employee_name = "name2";
		Employee employee = null;
		System.out.println("------------------------------------------------");
		try {
			employee = service.findByEmployeeName(employee_name);
			System.out.println("find success");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("delete faile!");
		}
		System.out.println("-------------------------");
		System.out.println(employee);
	}

	// 查询总数
	//@Test
	public void testFindTotal() {
		int total = service.findTotal();
		System.out.println("total=" + total);
	}

	// 分页查询
	// @Test
	public void testFindByPage() {

		// 测试分页
		Pager pager = new Pager(1, 2);

		// 查询出总记录数
		int total = service.findTotal();
		pager.setTotal(total);

		System.out.println("一共可以分 " + pager.getPages() + " 页,现查询第 " + pager.getPage() + " 页。");

		List<Employee> list = service.findByPager(pager);
		for (Employee employee : list) {
			System.out.println(employee);
		}

	}

}
