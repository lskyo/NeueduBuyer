package com.neuedu.service.impl;

import java.util.List;
import java.util.Map;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.neuedu.mapper.ReservationMapper;
import com.neuedu.model.Reservation;
import com.neuedu.model.Nurse;
import com.neuedu.model.Pager;
import com.neuedu.service.ReservationService;
/**
 * 业务实现类，本例主要用于做事物控制
 * 
 * @Service注解类可以吧奔雷声明为一个springd服务组件，声明后可以在sprig mvc 控制层中进行调用
 * @Transactional注解类 声明本类需要进行事务的同意控制 ---声明式事务
 *本例会完成业务逻辑层和数据访问层的整合，整合需要完成配置文件和代码的整合，配置文件的整合在配置文件中完成，
 *代码的整合在代码中完成
 *
 * @author 青计
 */


@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {
	
	// 使用spring核心技术IOC完成业务层和数据访问层间的依赖关系注入
	// 本例就是通过spring完成DepartementMapper接口变量的实例化
	@Autowired
	private ReservationMapper reservationMapper;

	@Override
	public List<Reservation> findAll() {
		//在业务逻辑层中调用逻辑访问层 完成
		return reservationMapper.findAll();
	}
    
	
	
	//新增
	@Override
	public void add(Reservation reservation) {
		
		 reservationMapper.add(reservation);
	}
	
   // 修改
	@Override
	public void update(Reservation reservation) { 
		
		 reservationMapper.update(reservation);
		

	}
    //修改
	@Override
	public void deleteByUserAccount(String id) {
		
		 reservationMapper.deleteByUserAccount(id);
	}
	public void deleteByNurseId(String id) {
		
		 reservationMapper.deleteByNurseId(id);
	}
	public void deleteByReservationId(String id) {
		
		 reservationMapper.deleteByReservationId(id);
	}
	
	@Override
	public List<Reservation> findByState(int state) {
		
		 return reservationMapper.findByState(state);
	}

	
	// 
	@Override
	public List<Reservation> findByUserAccount(String id) {
		
		return   reservationMapper.findByUserAccount(id);
	}

	@Override
	public List<Reservation> findByNurseId(String id) {
	
		return reservationMapper.findByNurseId(id);
	}

	@Override
	public Reservation findByReservationId(String id) {
		
		return reservationMapper.findByReservationId(id);
	}
	@Override
	public int findTotal() {
		
		return reservationMapper.findTotal();
	}

	@Override
	public List<Reservation> findByPager(Pager pager) {
		
		return reservationMapper.findByPager(pager);
	}



	@Override
	public List<Reservation> findByMap(Map<String, String> map) {
		return reservationMapper.findByMap(map);
	}

	


}
