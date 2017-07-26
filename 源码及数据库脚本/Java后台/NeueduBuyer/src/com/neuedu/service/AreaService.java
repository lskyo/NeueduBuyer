package com.neuedu.service;

import java.util.List;

import com.neuedu.model.Area;
/**
 * 
 * @author 林培坚
 *
 */




//服务层，做业务的处理,案例中主要做数据库事务管理
public interface AreaService {

	public void add(Area area);//增
	public void update(Area area);//改
	
	public void deleteByAreaId(int areaId);//删
	//条件查询
	public Area findByAreaId(int areaId);
	public Area findByCoding(String code);
	public Area findProvince(String provinceName);
	public Area findCity(String cityName);
	public List<Area> findDistrict(String districtName);
	
	public List<Area> findProvinceByCountry(String countryName);
	public List<Area> findCityByProvince(String provinceName);
	public List<Area> findDistrictByCity(String cityName);
	
	
	//public List<Area> findProvince(String parent);
	//public List<Area> findCity(String parent);
	//public List<Area> findDistrict(String parent);
	//public List<Area> findByProvince(String province);
	//public List<Area> findByCity(String city);
	//public List<Area> findByDistrict(String district);
	
	//public List<Area> findByParent(String parent);
	//查找所有的区域信息
	public List<Area> findAll();
	
	
}
