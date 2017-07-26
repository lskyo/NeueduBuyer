package com.neuedu.mapper;

import java.util.List;

import com.neuedu.model.Area;

/**
 * 
 * @author 林培坚
 *
 */

public interface AreaMapper {

	public List<Area> findAll();// 查
	public void add(Area area);// 增
	public void update(Area area);// 改
	public void deleteByAreaId(int areaId);// 删
	// 条件查询

	public Area findByAreaId(int areaId);
	public Area findByCoding(String code);
	public Area findProvince(String provinceName);
	public Area findCity(String cityName);
	public List<Area> findDistrict(String districtName);
	
	public List<Area> findProvinceByCountry(String parent);
	public List<Area> findCityByProvince(String parent);
	public List<Area> findDistrictByCity(String parent);
	

}