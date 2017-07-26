package com.neuedu.test;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.jdbc.Null;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.validator.PublicClassValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neuedu.mapper.ReservationMapper;
import com.neuedu.model.Employee;
import com.neuedu.model.Pager;
import com.neuedu.model.Reservation;
import com.neuedu.service.ReservationService;

import oracle.net.aso.d;

/**
 * 测试类需要加载数据的链接参数，及m'y'ba'ti
 * 
 * @author 青计
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/config/spring-common.xml")
public class ReservationTest {
	// 测试部门数据库操作接口
	// 使用spring的核心IOC功能完成对DepartmentMapper的实例化操作

	@Autowired
	private ReservationMapper mapper;
	// 业务层代码也需要进行测试
	// 针对越接口进行测试
	// 在使用spring的核心功能完成对DepartmentMapper的实例化操作
	@Autowired
	private ReservationService service;

	// 编写测试方法，查询数据并显示
	// 测试实验junit单元测试框架进行测试

	// @Test
	public void testFindAll() {
		List<Reservation> list = service.findAll();

		for (Reservation dep : list) {
			System.out.println("用户账号：" + dep.getUserAccount() + "护工编号：" + dep.getNurseId() + "预约信息编号："
					+ dep.getReservationId() + "服务起始时间：" + dep.getBeginTime() + "服务结束时间：" + dep.getEndTime() + "金额："
					+ dep.getMoney() + "地点：" + dep.getPlace());
		}
	}// end testFindAll

	public void testFindByUserAccount() {

		List<Reservation> list = service.findByUserAccount("user3");
		if (list.size() > 0) {
			for (Reservation reservation : list) {
				System.out.println(reservation);
			}
		} else
			System.out.println("查询结果为零");

	}
    
	public void testFindByNurseId() {

		List<Reservation> list = service.findByNurseId("2");
		if (list.size() > 0) {
			for (Reservation reservation : list) {
				System.out.println(reservation);
			}
		} else
			System.out.println("查询结果为零");

	}
	//@Test
	public void testFindByReservationId() {

		Reservation reservation = service.findByReservationId("9");
		System.out.println(reservation);	
	}
	
	//@Test
	public void testFindByState() {
		int state=1;
		List<Reservation> list = service.findByState(state);
		System.out.println("------------------------------------------------");
		try {
			
			System.out.println("find success");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("find faile!");
		}
		System.out.println("-------------------------");
		for (Reservation reservation : list) {
			System.out.println(reservation);
		}
	}
	

	//@Test
	public void testSave() {
		// 1. 构造新的部门数据
		Reservation reservation = new Reservation();
		reservation.setUserAccount("无敌");
		reservation.setNurseId("8");
		reservation.setReservationId("9");
		//reservation.setBeginTime(new Date());
		//reservation.setEndTime(new Date());
		reservation.setMoney(100);
		reservation.setPlace("山东蓝翔职业技术学院");

		// 2. 调用操作接口把数据保存到数据库中
		try {
			service.add(reservation);
			System.out.println("新增成功");
		} catch (Exception e) {
			e.printStackTrace();// 打印堆栈异常信息
			System.out.println("新增失败");
		}

	}// end save

	@Test
	public void testUpdate() {
		// 1. 查询出要修改的数据
		List<Reservation> list = service.findByUserAccount("123");

		if (list.size() > 0) {
			for (Reservation reservation : list) {
				System.out.println("修改前：");
				System.out.println(reservation);
				reservation.setReservationId("很无敌啊啊啊啊");
				try {
					service.update(reservation);
					System.out.println("更新成功");
					System.out.println("修改后：");
					System.out.println(reservation);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("更新失败");
				}
			}
		}

	}// end update

	public void testDeleteByUserAccount() {
		// 1.确定要删除的数据
		String id = "李四";
		// 2.调用接口进行删除
		try {
			service.deleteByUserAccount("李四");
			System.out.println("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("删除失败");
		}
	}

	public void testDeleteByNurseId() {
		// 1.确定要删除的数据
		String id = "王五";
		// 2.调用接口进行删除
		try {
			service.deleteByNurseId("nurse4");
			System.out.println("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("删除失败");
		}

	}

	public void testDeleteByReservation() {
		// 1.确定要删除的数据
		String id = "赵大";
		// 2.调用接口进行删除
		try {
			service.deleteByReservationId("000006");
			System.out.println("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("删除失败");
		}

	}

	public void testFindBypager() {
		// 1.测试分页
		Pager pager = new Pager(1, 2);
		// 查询第一页，每页查2条数据
		// 查询出总记录数
		int total = service.findTotal();
		pager.setTotal(total);

		System.out.println("一共可以分" + pager.getPages() + "页");
		List<Reservation> list = service.findByPager(pager);
		for (Reservation reservation : list) {
			System.out.println(reservation.getUserAccount() + "   :::::  " + reservation.getNurseId() + "   "
					+ reservation.getReservationId() + reservation.getNurseId() + reservation.getBeginTime()
					+ reservation.getEndTime() + reservation.getMoney() + reservation.getPlace());
		}
	}// end findByPager
}
