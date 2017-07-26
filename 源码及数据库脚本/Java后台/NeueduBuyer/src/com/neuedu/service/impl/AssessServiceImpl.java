package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.mapper.AssessMapper;
import com.neuedu.model.Assess;
import com.neuedu.model.Pager;
import com.neuedu.service.AssessService;

/**
 * <pre>
 * 业务实现类，本例主要用于做事务控制
 * @Service注解类：可以把本类声明为一个spring的服务组件，声明后可以在spring mvc控制层中进行调用
 * @Transactional注解类：声明本类需要进行事务的统一控制（声明式事务）
 * 本例会完成业务逻辑层和数据访问层的整合，整合需要完成配置文件和代码的整合，
 * 配置文件的整合在配置文件中完成，
 * 代码的整合在代码中完成
 * </pre>
 * @author 杨越
 *
 */
@Service
@Transactional

public class AssessServiceImpl implements AssessService {
	
	//使用spring核心技术IOC完成业务层和数据访问层间的依赖关系注入
	//本例就是通过spring完成DepartmentMapper接口变量的实例化
	@Autowired
	private AssessMapper assessMapper;

	@Override
	public List<Assess> findAll() {
		return assessMapper.findAll();
	}

	@Override
	public Assess findByAssessId(String assessid) {
		return assessMapper.findByAssessId(assessid);
	}

	@Override
	public List<Assess> findByNurseId(String nurseid) {
		return assessMapper.findByNurseId(nurseid);
	}

	@Override
	public List<Assess> findByUserAccount(String useraccount) {
		return assessMapper.findByUserAccount(useraccount);
	}

	@Override
	public int findTotal() {
		return assessMapper.findTotal();
	}
	

	

	@Override
	public List<Assess> findByPager(Pager pager) {
		return assessMapper.findByPager(pager);
	}

	@Override
	public void add(Assess assess) {
		assessMapper.add(assess);
	}

	@Override
	public void update(Assess assess) {
		assessMapper.update(assess);
	}
	
	@Override
	public void deleteByAssessId(String assessid) {
		 assessMapper.deleteByAssessId(assessid);
	}

	@Override
	public int findTotalByNurseId(String nurseid) {
		return assessMapper.findTotalByNurseId(nurseid);
	}

	@Override
	public int findTotalByUserAccount(String useraccount) {
		return assessMapper.findTotalByUserAccount(useraccount);
	}

	@Override
	public void deleteByNurseId(String nurseid) {
		assessMapper.deleteByNurseId(nurseid);
	}

	@Override
	public void deleteByUserAccount(String useraccount) {
		assessMapper.deleteByUserAccount(useraccount);
	}

	@Override
	public List<Assess> findNurseIdByPager(Pager pager, String nurseid) {
		
		
		return assessMapper.findNurseIdByPager(pager.getStartIndex(),pager.getSize(), nurseid);
	}

	@Override
	public List<Assess> findUserAccountByPager(Pager pager, String useraccount) {
		
		return assessMapper.findUserAccountByPager(pager.getStartIndex(),pager.getSize(), useraccount);
	}



}
