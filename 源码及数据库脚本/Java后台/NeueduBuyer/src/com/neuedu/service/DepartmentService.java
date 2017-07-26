package com.neuedu.service;

import java.util.List;

import com.neuedu.model.Department;
import com.neuedu.model.Pager;

/**
 * 设计一个业务接口，定义业务操作，本例业务操作与数据库操作基本一致，只是使用业务层代码进行数据库事务管理
 * @author 罗星华
 */
public interface DepartmentService {

	//查
	public List<Department> findAll();
	public Department findByDepartmentName(String departmentName);
	public Department findById(int departmentId);
	public int findTotal();
	public List<Department> findByPager(Pager pager);
	
	//增
	public void add(Department department) throws Exception;
	
	
	//改
	public void update(Department department);
	
	
	//删
	public void deleteById(int departmentId) throws Exception;
}
