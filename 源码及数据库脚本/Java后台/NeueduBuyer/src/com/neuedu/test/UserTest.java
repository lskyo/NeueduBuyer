package com.neuedu.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neuedu.mapper.UserMapper;
import com.neuedu.model.Pager;
import com.neuedu.model.User;
import com.neuedu.service.UserService;



/**
 * @author 罗星华
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/config/spring-common.xml")
public class UserTest {
	
	
	@Autowired
	private UserMapper mapper;
	
	@Autowired
	private UserService service;
	
	
	//@Test
	public void testFindAll(){
		List<User> list = service.findAll();
		for(User user : list){
			System.out.println(user);
		}
	}
	
	
	//@Test
	public void testFindByUserMobile(){
		
		User user = service.findByUserMobile("316549832154");
		
		if(user!=null){
			System.out.println(user);
		}else{
			System.out.println("该号码查询失败！");
		}
	}
	
	@Test
	public void testFindByUserName(){
		
		User user = service.findByUserName("name1");
		
		if(user!=null){
			System.out.println(user);
		}else{
			System.out.println("该名字查询失败！");
		}
	}
	
	//@Test
	public void testFindByUserAccount(){
		
		User user = service.findByUserAccount("user1");
		
		if(user!=null){
			System.out.println(user);
		}else{
			System.out.println("该account查询失败！");
		}
	}
	
	
	//@Test
	public void testFindTotal(){
		int total = service.findTotal();
		System.out.println("total="+total);
	}
	
	//@Test
	public void testFindByPager(){
		System.out.println("----------testFindByPager----------");
		Pager pager = new Pager(1,2);
		pager.setTotal(service.findTotal());
		List<User> list = service.findByPager(pager);
		System.out.println("一共可以分 " + pager.getPages() + " 页,现查询第 " + pager.getPage() + " 页。");
		if(list.size()>0){
			for(User user:list){
				System.out.println(user);
			}
		}else{
			System.out.println("查询失败！");
		}
	}
	
	//@Test
	public void testAdd() throws Exception{
		System.out.println("--------------testAdd--------------");
		User user = new User();
		user.setUserAccount("user4");
		user.setPassword("password4");
		
		service.add(user);
		testFindAll();
		
	}
	
	//@Test
	public void testUpdate(){
		System.out.println("--------------testUpdate--------------");
		User user = service.findByUserAccount("user4");
		System.out.println(user);
		user.setUserMobile("12345678912");
		System.out.println("set:" + user);
		service.update(user);
		System.out.println("update:");
		testFindAll();		
	}
	
	//@Test
	public void testDeleteByUserAccount(){
		System.out.println("--------------testDeleteByUserAccount--------------");
		try {
			service.deleteByUserAccount("user4");
		} catch (Exception e) {
			e.printStackTrace();
		}
		testFindAll();
	}
	
	
	
	

}
