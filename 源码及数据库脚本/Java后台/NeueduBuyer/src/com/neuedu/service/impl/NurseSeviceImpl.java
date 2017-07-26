package com.neuedu.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.mapper.DepartmentMapper;
import com.neuedu.mapper.NurseMapper;
import com.neuedu.model.Nurse;
import com.neuedu.model.Pager;
import com.neuedu.service.NurseService;


/**
 * 
 * @author 青计
 *
 */
@Service
@Transactional
public class NurseSeviceImpl implements NurseService {
   
	@Autowired
	private NurseMapper nurseMapper;
	
	//查找
	@Override
	public List<Nurse> findAll() {
	    return nurseMapper.findAll();
	}
	@Override
	public int findTotal() {
		return nurseMapper.findTotal();
	}
    @Override
	public List<Nurse> findByPager(Pager pager) {
		return nurseMapper.findByPager(pager);
	}
    //按类查找
	@Override
	public Nurse findByNurseId(String nurseId) {
		return nurseMapper.findByNurseId(nurseId);
	}
    @Override
	public List<Nurse> findByNurseName(String nurseName) {
		return nurseMapper.findByNurseName(nurseName);
	}
    @Override
	public Nurse findByNurseIdcard(String nurseIdcard) {
		return nurseMapper.findByNurseIdcard(nurseIdcard);
	}
    @Override
	public List<Nurse> findBySex(int sex) {
		return nurseMapper.findBySex(sex);
	}
    @Override
	public List<Nurse> findByAge(int age) {
		return nurseMapper.findByAge(age);
	}
    @Override
	public List<Nurse> findByMajor(String major) {
		return nurseMapper.findByMajor(major);
	}
    @Override
	public List<Nurse> findByIsfree(int isfree) {
		return nurseMapper.findByIsfree(isfree);
	}
    @Override
	public List<Nurse> findByWage(int wage) {
		return nurseMapper.findByWage(wage);
	}
    @Override
	public List<Nurse> findByNurseLevel(int nurseLevel) {
		return nurseMapper.findByNurseLevel(nurseLevel);
	}
    //新增
	@Override
	public void add(Nurse nurse) {
		nurseMapper.add(nurse);
	}
    //修改
	@Override
	public void update(Nurse nurse) {
		nurseMapper.update(nurse);
	}
    //删除
	@Override
	public void deleteByNurseId(String nurseId) {
		nurseMapper.deleteByNurseId(nurseId);
	}
	@Override
	public List<Nurse> findByMap(Nurse nurse) {
		return nurseMapper.findByMap(nurse);
	}
	@Override
	public List<Nurse> findByNurseIds(List<String> list) {
		return nurseMapper.findByNurseIds(list);
	}

}


