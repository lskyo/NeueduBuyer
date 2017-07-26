package com.neuedu.service;


/**
 * @author 刘志杰
 */
import java.util.List;

import com.neuedu.model.Employee;
import com.neuedu.model.Pager;

public interface EmployeeService {
	
	public List<Employee> findAll();//查
	public void add(Employee employee);//增
	public void update(Employee employee);//改
	public void deleteByEmployeeId(String employee_id);
	public void deleteByDepartmentId(int department_id);//删
	
	//条件查询
	public Employee findByEmployeeId(String employee_id);
	public Employee findByEmployeeMobile(String employee_mobile);
	public Employee findByEmployeeAccount(String account);
	public Employee findByEmployeeName(String employee_name);
	public List<Employee> findByDepartmentId(int department_id);
	
	//统计查询
	public int findTotal();//查询总数
	public List<Employee> findByPager(Pager pager);//分页查询

}
