package com.neuedu.service;

import java.util.List;

import com.neuedu.model.Pager;
import com.neuedu.model.User;


/**
 * @author 罗星华
 */
public interface UserService {
	//查
	public List<User> findAll();
	public User findByUserMobile(String userMobile);
	public User findByUserName(String userName);
	public User findByUserAccount(String userAccount);
	public int findTotal();
	public List<User> findByPager(Pager pager);
	public User findByUserIdcard(String userIdcard);
	
	//增
	public void add(User user) throws Exception;
	
	
	//改
	public void update(User user);
	
	
	//删
	public void deleteByUserAccount(String userAccount) throws Exception;
}
