package com.neuedu.mapper;

import java.util.List;
import com.neuedu.model.Pager;
import com.neuedu.model.User;

/**
 * @author 罗星华
 */
public interface UserMapper {
	//查
	public List<User> findAll();
	public User findByUserMobile(String userMobile);
	public User findByUserName(String userName);
	public User findByUserAccount(String userAccount);
	public int findTotal();
	public List<User> findByPager(Pager pager);
	public User findByUserIdcard(String userIdcard);
	
	//增
	public void add(User user);
	
	
	//改
	public void update(User user);
	
	
	//删
	public void deleteByUserAccount(String userAccount);
}
