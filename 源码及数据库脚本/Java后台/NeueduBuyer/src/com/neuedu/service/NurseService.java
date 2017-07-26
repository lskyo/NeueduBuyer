package com.neuedu.service;

import java.util.List;
import java.util.Map;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;

import com.neuedu.model.Nurse;
import com.neuedu.model.Pager;


/**
 * 
 * @author 青计
 *
 */
public interface NurseService {
	//查找
	public List<Nurse> findAll();
	public int findTotal();//查询总数
	public List<Nurse> findByPager(Pager pager);
	//按类查找
	public Nurse findByNurseId(String nurseId);
	public List<Nurse> findByNurseName(String nurseName);
	public Nurse findByNurseIdcard(String nurseIdcard);
	public List<Nurse> findBySex(int sex);
	public List<Nurse> findByAge(int age);
	public List<Nurse> findByMajor(String major);
	public List<Nurse> findByIsfree(int isfree);
	public List<Nurse> findByWage(int wage);
	public List<Nurse> findByNurseLevel(int nurseLevel);
	public List<Nurse> findByMap(Nurse nurse);
	public List<Nurse> findByNurseIds(List<String> list);
	//新增
	public void add(Nurse nurse);
	//修改
	public void update(Nurse nurse);
	//删除
    public void deleteByNurseId(String nurseId);
	
	
	
	


	
	//查找
	

}
