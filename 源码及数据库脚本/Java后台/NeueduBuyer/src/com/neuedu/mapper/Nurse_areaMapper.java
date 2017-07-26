package com.neuedu.mapper;

/**
 * 
 * @author 刘志杰
 */
import java.util.List;


import com.neuedu.model.Nurse_area;
import com.neuedu.model.Pager;

public interface Nurse_areaMapper {
	
	public List<Nurse_area> findAll();//查
	public void add(Nurse_area nurse_area);//增
	public void update(Nurse_area nurse_area);//改
	public void deleteByPriId(int pri_id);
	public void deleteByNurseId(String nurse_id);
	public void deleteByAreaId(int area_id);//删
	
	//条件查询
	public List<Nurse_area> findByNurseId(String nurse_id);
	public List<Nurse_area> findByAreaId(int area_id);
	public Nurse_area findByPriId(int pri_id);
	
	//统计查询
	public int findTotal();//查询总数
	public List<Nurse_area> findByPager(Pager pager);//分页查询

}
