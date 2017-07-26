package com.neuedu.service;

import java.util.List;

import com.neuedu.model.Assess;
import com.neuedu.model.Department;
import com.neuedu.model.Pager;
/**
 * 设计一个业务接口，定义业务操作，本例业务操作与数据库操作基本一致，只是使用业务层代码进行数据库事务管理
 * @author 杨越
 *
 */

public interface AssessService {
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
			public List<Assess> findNurseIdByPager(Pager pager,String nurseid);
			public List<Assess> findUserAccountByPager(Pager pager,String useraccount);
			
			//增
			public void add(Assess assess);
			
			
			//改
			public void update(Assess assess);
			
			//删
			public void deleteByAssessId(String assessid);
			public void deleteByNurseId(String nurseid);
			public void deleteByUserAccount(String useraccount);
}
