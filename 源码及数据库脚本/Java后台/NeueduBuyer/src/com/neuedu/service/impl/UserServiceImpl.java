package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.mapper.UserMapper;
import com.neuedu.model.Pager;
import com.neuedu.model.User;
import com.neuedu.service.UserService;


/**
 * 
 * @author 罗星华
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> findAll() {
		return userMapper.findAll();
	}

	@Override
	public User findByUserMobile(String userMobile) {
		
		return userMapper.findByUserMobile(userMobile);
	}

	@Override
	public User findByUserName(String userName) {
		
		return userMapper.findByUserName(userName);
	}

	@Override
	public User findByUserAccount(String userAccount) {
		
		return userMapper.findByUserAccount(userAccount);
	}

	@Override
	public int findTotal() {
		
		return userMapper.findTotal();
	}

	@Override
	public List<User> findByPager(Pager pager) {
		
		return userMapper.findByPager(pager);
	}

	@Override
	public void add(User user) throws Exception {
		if(userMapper.findByUserAccount(user.getUserAccount())!=null){
			throw new Exception("该用户账号已存在！");
		}else if(userMapper.findByUserMobile(user.getUserMobile())!=null){
			throw new Exception("该用户手机号已存在！");
		}else{
			userMapper.add(user);
		}
	}
	
	@Override
	public User findByUserIdcard(String userIdcard) {
		return userMapper.findByUserIdcard(userIdcard);
	}

	@Override
	public void update(User user) {
		userMapper.update(user);

	}

	@Override
	public void deleteByUserAccount(String userAccount) throws Exception {
		if(userMapper.findByUserAccount(userAccount)!=null){
			userMapper.deleteByUserAccount(userAccount);
		}else{
			throw new Exception("该用户账号不存在！");
		}

	}


}
