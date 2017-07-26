package com.neuedu.service.impl;

/**
 * @author 刘志杰
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.neuedu.mapper.DepartmentMapper;
import com.neuedu.mapper.EmployeeMapper;
//import com.neuedu.model.Department;
import com.neuedu.model.Employee;
import com.neuedu.model.Pager;
import com.neuedu.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	
	//使用spring 核心技术IOC完成业务层和数据访问层间的依赖关系注入
	//本例就是通过spring 完成EmployeeMapper 接口变量的实例化
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Override
	public List<Employee> findAll() {
		//在业务逻辑层中调用数据访问层代码完成数据库操作
		return employeeMapper.findAll();
	}
	
	@Override
	public void add(Employee employee) {
		
		employeeMapper.add(employee);
	}
	
	@Override
	public void update(Employee employee) {
		
		employeeMapper.update(employee);
	}
	
	@Override
	public void deleteByEmployeeId(String employee_id) {
		
		employeeMapper.deleteByEmployeeId(employee_id);
	}
	
	@Override
	public void deleteByDepartmentId(int department_id) {
		
		employeeMapper.deleteByDepartmentId(department_id);
	}
	
	@Override
	public Employee findByEmployeeId(String employee_id) {
		
		return employeeMapper.findByEmployeeId(employee_id);
	}
	
	@Override
	public Employee findByEmployeeAccount(String employee_account) {
		
		return employeeMapper.findByEmployeeAccount(employee_account);
	}
	
	@Override
	public Employee findByEmployeeMobile(String employee_mobile) {
		
		return employeeMapper.findByEmployeeMobile(employee_mobile);
	}
	
	@Override
	public Employee findByEmployeeName(String employee_name) {
		
		return employeeMapper.findByEmployeeName(employee_name);
	}
	
	@Override
	public List<Employee> findByDepartmentId(int department_id) {
		
		return employeeMapper.findByDepartmentId(department_id);
	}
	
	@Override
	public int findTotal() {
		
		return employeeMapper.findTotal();
	}
	
	@Override
	public List<Employee> findByPager(Pager pager) {
		
		return employeeMapper.findByPager(pager);
	}
	
}
