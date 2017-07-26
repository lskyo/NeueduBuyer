package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.mapper.DepartmentMapper;
import com.neuedu.model.Department;
import com.neuedu.model.Pager;
import com.neuedu.service.DepartmentService;


/**
 * <pre>
 * 业务实现类，本例主要用于做事务控制
 * @Service注解类：可以把本类声明为一个spring的服务组件，声明后可以在spring mvc控制层中进行调用
 * @Transactional注解类：声明本类需要进行事务的统一控制（声明式事务）
 * 本例会完成业务逻辑层和数据访问层的整合，整合需要完成配置文件和代码的整合，
 * 配置文件的整合在配置文件中完成，
 * 代码的整合在代码中完成
 * </pre>
 * @author 罗星华
 *
 */
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	//使用spring核心技术IOC完成业务层和数据访问层间的依赖关系注入
	//本例就是通过spring完成DepartmentMapper接口变量的实例化
	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Override
	public List<Department> findAll() {
		//在 业务逻辑层 调用 数据访问层 代码完成数据库的操作
		return departmentMapper.findAll();
	}

	@Override
	public Department findById(int id) {
		
		return departmentMapper.findById(id);
	}

	@Override
	public int findTotal() {
		
		return departmentMapper.findTotal();
	}

	@Override
	public List<Department> findByPager(Pager pager) {
		
		return departmentMapper.findByPager(pager);
	}

	@Override
	public void add(Department department) throws Exception  {
		if(departmentMapper.findById(department.getDepartmentId())!=null){
			throw new Exception("该部门ID已存在！");
		}else if(departmentMapper.findByDepartmentName(department.getDepartmentName())!=null){
			throw new Exception("该部门名字已存在！");
		}
		departmentMapper.add(department);
	}

	@Override
	public void update(Department department) {
		departmentMapper.update(department);
	}

	@Override
	public void deleteById(int id) throws Exception {
		if(departmentMapper.findById(id)!=null){
			departmentMapper.deleteById(id);
		}else{
			throw new Exception("该部门编号不存在！");
		}
	}

	@Override
	public Department findByDepartmentName(String departmentName) {
		return departmentMapper.findByDepartmentName(departmentName);
	}

}
