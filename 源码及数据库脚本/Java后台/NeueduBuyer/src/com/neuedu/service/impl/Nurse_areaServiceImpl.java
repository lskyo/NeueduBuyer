package com.neuedu.service.impl;
/**
 * 
 * @author 刘志杰
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.neuedu.mapper.EmployeeMapper;
import com.neuedu.mapper.Nurse_areaMapper;
import com.neuedu.model.Nurse_area;
import com.neuedu.model.Pager;
//import com.neuedu.service.EmployeeService;
import com.neuedu.service.Nurse_areaService;

@Service
@Transactional
public class Nurse_areaServiceImpl implements Nurse_areaService{
	//使用spring 核心技术IOC完成业务层和数据访问层间的依赖关系注入
	//本例就是通过spring 完成Nurse_areaMapper 接口变量的实例化
	@Autowired
	private Nurse_areaMapper nurse_areaMapper;
	@Override
	public List<Nurse_area> findAll() {
		return nurse_areaMapper.findAll();
	}

	@Override
	public void add(Nurse_area nurse_area) {
		nurse_areaMapper.add(nurse_area);
	}

	@Override
	public void update(Nurse_area nurse_area) {
		nurse_areaMapper.update(nurse_area);
	}

	@Override
	public void deleteByNurseId(String nurse_id) {
		nurse_areaMapper.deleteByNurseId(nurse_id);
	}
	
	@Override
	public void deleteByPriId(int pri_id) {
		nurse_areaMapper.deleteByPriId(pri_id);
	}

	@Override
	public void deleteByAreaId(int area_id) {
		nurse_areaMapper.deleteByAreaId(area_id);
	}

	@Override
	public List<Nurse_area> findByNurseId(String nurse_id) {
		return nurse_areaMapper.findByNurseId(nurse_id);
	}
	
	@Override
	public List<Nurse_area> findByAreaId(int area_id) {
		return nurse_areaMapper.findByAreaId(area_id);
	}
	
	@Override
	public Nurse_area findByPriId(int pri_id) {
		return nurse_areaMapper.findByPriId(pri_id);
	}

	@Override
	public int findTotal() {
		return nurse_areaMapper.findTotal();
	}

	@Override
	public List<Nurse_area> findByPager(Pager pager) {
		return nurse_areaMapper.findByPager(pager);
	}
}
