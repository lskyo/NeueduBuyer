package com.neuedu.mapper;
/**
 *护工表
 * @author 青计
 * 
 */
import java.util.List;
import java.util.Map;

import com.neuedu.model.Nurse;
import com.neuedu.model.Pager;
import com.neuedu.model.Reservation;

public interface NurseMapper {

	
	//查找
	public List<Nurse>  findAll();
	public Nurse findByNurseId(String nurseId);
	public List<Nurse> findByNurseIds(List<String> list);
	public Nurse findByNurseIdcard(String nurseIdcard);
	public List<Nurse>findByNurseName(String nurseName);
	public List<Nurse>findBySex(int sex);
	public List<Nurse>findByAge(int age);
	public List<Nurse>findByIsfree(int isfree);
	public List<Nurse>findByMajor(String major);
	public List<Nurse>findByWage(int wage);
	public List<Nurse>findByNurseLevel(int nurseLevel);
	public int findTotal();//查询总数
	public List<Nurse> findByPager(Pager pager);
	public List<Nurse> findByMap(Nurse nurse);
	
	//增加
	public void add(Nurse nurse);
	
	
	//修改
	public void update(Nurse nurse);
	
	
	//删除
	public void deleteByNurseId(String nurseId);

	
	
	
}
