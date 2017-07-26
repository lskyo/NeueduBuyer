package com.neuedu.service;
/**
 * 
 * *@author 青计
 * 
 */
import java.util.List;
import java.util.Map;

import com.neuedu.model.Department;
import com.neuedu.model.Nurse;
import com.neuedu.model.Pager;
import com.neuedu.model.Reservation;

/**
 * 设计一个业务接口，定义业务操作，本例业务操作与数据库操作基本一致，只是使用业务层代码进行运行数据库事物管理
 *
 * @author 青计 
 *
 */

public interface ReservationService {
	

	public List<Reservation> findAll();
	
	//其他数据库操作
	public void add(Reservation reservation);
	public void update(Reservation reservation);
	public void deleteByUserAccount(String id);
	public void deleteByNurseId(String id);
	public void deleteByReservationId(String id);
	
	
	//条件查询
	public List<Reservation> findByUserAccount(String id);
	public List<Reservation> findByNurseId(String id);
	public Reservation findByReservationId(String id);
	public List<Reservation> findByState(int state);
	public List<Reservation> findByMap(Map<String, String> map);
	//统计查询
	public int findTotal();//查询总数
	public List<Reservation> findByPager(Pager pager);



	



	



	



	



	



	
	
	

}
