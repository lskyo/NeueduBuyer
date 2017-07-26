package com.neuedu.mapper;
/**
 * 
 * @author 杨越
 */
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neuedu.model.Assess;
import com.neuedu.model.Pager;

public interface AssessMapper  {
		//查
		public List<Assess> findAll();
		
		//条件查询
		
		public Assess findByAssessId(String assessid);
		public List<Assess> findByNurseId(String nurseid);
		public List<Assess> findByUserAccount(String useraccount);

		//统计查询
		public int findTotal();
		public int findTotalByNurseId(String nurseid);
		public int findTotalByUserAccount(String useraccount);
		//分页查询
		
		public List<Assess> findByPager(Pager pager);
		public List<Assess> findNurseIdByPager(int indexSize, int size, String nurseid);
		public List<Assess> findUserAccountByPager(int indexSize, int size,String useraccount);
		
		//增
		public void add(Assess assess);
		
		
		//改
		public void update(Assess assess);
		
		
		//删
		public void deleteByAssessId(String assessid);
		public void deleteByNurseId(String nurseid);
		public void deleteByUserAccount(String useraccount);
}
