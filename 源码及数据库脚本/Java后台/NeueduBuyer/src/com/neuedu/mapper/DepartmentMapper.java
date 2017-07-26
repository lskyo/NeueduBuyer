package com.neuedu.mapper;


import java.util.List;

import com.neuedu.model.Department;
import com.neuedu.model.Pager;

/**
 * @author 罗星华
 */
public interface DepartmentMapper {

	//查
	public List<Department> findAll();
	public Department findByDepartmentName(String departmentName);
	public Department findById(int departmentId);
	public int findTotal();
	public List<Department> findByPager(Pager pager);
	
	//增
	public void add(Department department);
	
	
	//改
	public void update(Department department);
	
	
	//删
	public void deleteById(int departmentId);
	
	
}
