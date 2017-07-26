package com.neuedu.mapper;

/**
 * 
 * 
 //* @author 青计
 *
 */
import java.util.List;
import java.util.Map;

import com.neuedu.model.Department;
import com.neuedu.model.Pager;
import com.neuedu.model.Reservation;

public interface ReservationMapper {
	
	
	public List<Reservation> findAll();

	// 新增
	public void add(Reservation reservation);

	// 修改
	public void update(Reservation reservation);

	// 删除 按条件删除
	public void deleteByUserAccount(String id);
	public void deleteByNurseId(String id);
	public void deleteByReservationId(String id);

	// 条件查询
	public List<Reservation> findByUserAccount(String id);
	public List<Reservation> findByNurseId(String id);
	public Reservation findByReservationId(String id);
	public List<Reservation> findByState(int state);
	public List<Reservation> findByMap(Map<String, String> map);

	// 统计查询
	public int findTotal();// 查询总数
	public List<Reservation> findByPager(Pager pager);

}
