package com.neuedu.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neuedu.mapper.AreaMapper;
import com.neuedu.model.Area;

import com.neuedu.service.AreaService;

/**
 * 
 * @author 林培坚
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/config/spring-common.xml")
public class AreaTest {

	
	//测试部门数据库操作接口
	//使用spring的核心ioc容器对DepartmentMapper实例化
	@Autowired
	private AreaMapper mapper;
	
	@Autowired
	private AreaService service;
	//@Test
	public void testFindAll(){
		List<Area> list = service.findAll();
		for(Area dep : list){
		}
	}// end testFindAll
	//新增区域
	//@Test
	public void testAdd(){
		
		System.out.println("-------------------------");
		
		//构造新数据
		Area area = new Area();
		area.setAreaId(4003);
		area.setProvince(" ");
		area.setCity(" ");
		area.setDistrict("朝阳区");
		area.setParent("3924");
		
		//新增数据
		try{
			service.add(area);
			System.out.println("***done***");
		}catch (Exception e) {

			e.printStackTrace();
			System.out.println("***faile***");
		}
		
		
		System.out.println("-------------------------");
		
		
	}
	
//修改区域
	//@Test
	public void testUpdate(){
		
		
		System.out.println("-------------------------");
		
		
		//提供要修改的数据
		Area area = new Area();
		area.setAreaId(4003);
		area.setProvince(" ");
		area.setCity(" ");
		area.setDistrict("东城区");
		area.setParent("3921");
		
		//调用数据接口操作数据库
		try{
			service.update(area);
			System.out.println("update success!");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("update faile!");
		}
		
		System.out.println("-------------------------");
		
		
	}
	//删除区域
	//@Test
	public void testDeleteByAreaId(){
		int areaId = 4003;
		
		System.out.println("-------------------------");
		
		try{
			service.deleteByAreaId(areaId);
			System.out.println("delete success!");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("delete faile!");
		}
		
		
		System.out.println("-------------------------");
		
		
	}
	//按id查询
	//@Test
	public void testFindByAreaId(){
		
		int areaId = 2;
		Area area = null;
		
		try{
			area = service.findByAreaId(areaId);
			System.out.println(areaId);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("select faile!");
		}
	}
	//按编号查询
	//@Test
	public void testFindByCode(){
		String code = "110105";
		Area area = null;
		
		try{
			area = service.findByCoding(code);
			System.out.println(code);
		
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("select faile!");
		}
	}
	//按国家查询省
		//@Test
		public void testFindProvinceByCountry(){
			
			String countryName = "1";
			List<Area> area = null;
			try{
				area = service.findProvinceByCountry(countryName);
				List<Area> list=service.findProvinceByCountry(countryName);
				System.out.println(countryName);
				for(Area dep : list){
			}
				
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("select faile!");
			}
		}
		
	//按省份查询市
	//@Test
	public void testFindCityByProvince(){
		
		String provinceName = "36";
		List<Area> area = null;
		try{
			area = service.findCityByProvince(provinceName);
			List<Area> list=service.findCityByProvince(provinceName);
			System.out.println(provinceName);
			for(Area dep : list){
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("select faile!");
		}
	}
	//按市查询区
	//@Test
	public void testFindDistrictByCity(){
		
		String cityName = "37";
		List<Area> area = null;
		try{
			area = service.findDistrictByCity(cityName);
			List<Area> list=service.findDistrictByCity(cityName);
			System.out.println(cityName);
			for(Area dep : list){
		}
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("select faile!");
		}
	}
	//查询省
		//@Test
		public void testFindProvince(){
			
			String provinceName = "河北省";
			Area area = null;
			
			try{
				area = service.findProvince(provinceName);
				System.out.println(provinceName);
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("select faile!");
			}
		}
		//查询市
		//@Test
		public void testFindCity(){
			
			String cityName = "石家庄市";
			Area area = null;
			
			try{
				area = service.findCity(cityName);
				System.out.println(cityName);
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("select faile!");
			}
		}
		//查询区
		//@Test
		public void testFindDistrict(){
			
			String districtName = "朝阳区";
			List<Area> area = null;
			try{
				area = service.findDistrict(districtName);
				List<Area> list=service.findDistrict(districtName);
				System.out.println(districtName);
				for(Area dep : list){
			}
				
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("select faile!");
			}
		}
	
}
