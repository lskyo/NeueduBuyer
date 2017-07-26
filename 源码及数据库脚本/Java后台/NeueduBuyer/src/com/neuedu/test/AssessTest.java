package com.neuedu.test;

import java.util.HashMap;
/**
 * 
 * @author 杨越
 */
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neuedu.mapper.AssessMapper;
import com.neuedu.model.Assess;
import com.neuedu.model.Pager;
import com.neuedu.service.AssessService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/config/spring-common.xml")

public class AssessTest {

	// 测试部门数据库操作接口
	// 使用spring的核心ioc容器对DepartmentMapper实例化
	@Autowired
	private AssessMapper mapper;

	@Autowired
	private AssessService service;

	// 查询所有评论
	//@Test
	public void testFindAll() {
		List<Assess> list = mapper.findAll();
		for (Assess dep : list) {
			System.out.println("评价编号：" + dep.getAssessId() + "   护工编号：" + dep.getNurseId() + "评论：" + dep.getSummary()
					+ "评分：" + dep.getLevel() + "用户编号：" + dep.getUserAccount() + "是否匿名" + dep.getIsShowName());
		}
	}

	// 按assessid查询评论
	// @Test
	public void testFindByAssessId() {
		String assessId = "11";
		Assess assess = null;

		try {
			assess = service.findByAssessId(assessId);
			System.out.println(assessId);
			System.out.println(assess);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("select faile!");
		}
	}

	// 按nurseid查询评论
	// @Test
	public void testFindByNurseId() {
		String nurseId = "222";
		List<Assess> assess = null;

		try {
			assess = service.findByNurseId(nurseId);
			System.out.println(nurseId);
			System.out.println(assess);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("select faile!");
		}
	}

	// 按useraccount查询评论
	// @Test
	public void testFindByUserAccount() {
		String userAccount = "user3";
		List<Assess> assess = null;

		try {
			assess = service.findByUserAccount(userAccount);
			System.out.println(userAccount);
			System.out.println(assess);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("select faile!");
		}
	}

	// 分页查询

	// @Test
	public void testFindByPage() {
		testFindAll();

		// 测试分页
		Pager pager = new Pager(2, 2);

		// 查询出总记录数
		int total = service.findTotal();
		pager.setTotal(total);

		System.out.println("一共可以分 " + pager.getPages() + " 页,现查询第 " + pager.getPage() + " 页。");

		List<Assess> list = service.findByPager(pager);
		for (Assess assess : list) {
			System.out.println(assess);
		}

	}

	// 按nurseid进行分页查询

	@Test
	public void testFindNurseIdByPager() {
		//testFindAll();

		int index = 3;//
		int size = 3;
		// 测试分页
		Pager pager = new Pager(index, size);

		// 查询出总记录数
		int total = mapper.findTotalByNurseId("00000");
		pager.setTotal(total);

		System.out.println("一共可以分 " + pager.getPages() + " 页,现查询第 " + pager.getPage() + " 页。");

		Map<String, String> params = new HashMap<String,String>();
		
		List<Assess> list = mapper.findNurseIdByPager(index, size, "00000");
		for (Assess assess : list) {
			System.out.println(assess);
		}

	}
	
	//@Test
	public void testFindUserAccountByPager() {
		testFindAll();

		// 测试分页
		Pager pager = new Pager(2, 2);

		// 查询出总记录数
		int total = mapper.findTotal();
		pager.setTotal(total);

		System.out.println("一共可以分 " + pager.getPages() + " 页,现查询第 " + pager.getPage() + " 页。");

		List<Assess> list = mapper.findUserAccountByPager(2, 2, "user2");
		for (Assess assess : list) {
			System.out.println(assess);
		}

	}

	// 总数查询
	// 查询所有评论
	// @Test
	public void testFindTotal() {
		testFindAll();

		// 查询出总记录数
		int total = service.findTotal();
		System.out.println("一共有 ：" + total + "条数据 ");
	}

	// 按nurseid查询评论
	// @Test
	public void testFindTotalNurseId() {
		testFindAll();
		// int totalNurseId;
		// 查询出总记录数
		int totalNurseId = 0;
		System.out.println("222");
		totalNurseId = service.findTotalByNurseId("111");

		System.out.println(totalNurseId);
	}

	// 按useraccount查询评论
	// @Test
	public void testFindTotalByUserAccount() {
		testFindAll();
		System.out.println("一共有 ：");
		// 查询出总记录数
		int totalNurseId = service.findTotalByUserAccount("user2");
		System.out.println("一共有 ：" + totalNurseId + " 条数据 ");
	}

	// 增加评论
	// @Test
	public void testAdd() {
		testFindAll();
		System.out.println("-------------------------");

		// 构造新数据
		Assess assess = new Assess();
		assess.setAssessId("12");
		assess.setNurseId("00000");
		assess.setSummary("123");
		assess.setLevel(1);
		assess.setUserAccount("user2");
		assess.setIsShowName(1);

		// 新增数据
		try {
			service.add(assess);
			System.out.println("***done***");
		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("***faile***");
		}

		System.out.println("-------------------------");
		testFindAll();

	}

	// 修改评论
	// @Test
	public void testUpdate() {

		testFindAll();
		System.out.println("-------------------------");

		// 提供要修改的数据
		Assess assess = new Assess();
		assess.setAssessId("12");
		assess.setNurseId("00000");
		assess.setSummary("12");
		assess.setLevel(2);
		assess.setUserAccount("user1");
		assess.setIsShowName(1);

		// 调用数据接口操作数据库
		try {
			service.update(assess);
			System.out.println("update success!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("update faile!");
		}

		System.out.println("-------------------------");
		testFindAll();

	}

	// 删除评论
	// 按assessid删除评论
	// @Test
	public void testDeleteByAssessId() {
		String assessId = "12";
		testFindAll();
		System.out.println("-------------------------");

		try {
			service.deleteByAssessId(assessId);
			System.out.println("delete success!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("delete faile!");
		}

		System.out.println("-------------------------");
		testFindAll();

	}

	// 按nurseid删除评论
	// @Test
	public void testDeleteByNurseId() {
		String nurseId = "222";
		testFindAll();
		System.out.println("-------------------------");

		try {
			service.deleteByNurseId(nurseId);
			System.out.println("delete success!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("delete faile!");
		}

		System.out.println("-------------------------");
		testFindAll();

	}

	// @Test
	public void testDeleteByUserAccount() {
		String userAccount = "user2";
		testFindAll();
		System.out.println("-------------------------");

		try {
			service.deleteByUserAccount(userAccount);
			System.out.println("delete success!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("delete faile!");
		}

		System.out.println("-------------------------");
		testFindAll();

	}

}
