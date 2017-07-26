package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.mapper.AreaMapper;
import com.neuedu.model.Area;
import com.neuedu.service.AreaService;

/**
 * 这是服务实现类，目前主要做事务管理，调用mapper接口实现数据的操作
 * 
 * @author 林培坚
 *
 */
@Service
@Transactional
// 此处不再进行创建SqlSession和提交事务，都已交由spring去管理了。
public class AreaServiceImpl implements AreaService {
	@Autowired
	private AreaMapper areaMapper;

	@Override
	public void add(Area area) {
		areaMapper.add(area);
	}

	@Override
	public void update(Area area) {
		areaMapper.update(area);

	}

	@Override
	public void deleteByAreaId(int areaId) {
		areaMapper.deleteByAreaId(areaId);

	}

	@Override
	public Area findByAreaId(int areaId) {
		return areaMapper.findByAreaId(areaId);

	}

	@Override
	public Area findByCoding(String coding) {
		return areaMapper.findByCoding(coding);

	}

	// @Override
	// public List<Area> findByProvince(String province) {
	// return areaMapper.findByProvince(province);
	//
	// }
	//
	// @Override
	// public List<Area> findByCity(String city) {
	// return areaMapper.findByCity(city);
	//
	// }
	//
	// @Override
	// public List<Area> findByDistrict(String district) {
	// return areaMapper.findByDistrict(district);
	//
	// }
	//
	// @Override
	// public List<Area> findByParent(String parent) {
	// return areaMapper.findByParent(parent);
	//
	// }

	@Override
	public List<Area> findAll() {
		return areaMapper.findAll();

	}
	@Override
	public Area findProvince(String provinceName) {
		return areaMapper.findProvince(provinceName);
	}

	@Override
	public Area findCity(String cityName) {
		return areaMapper.findCity(cityName);
	}

	@Override
	public List<Area> findDistrict(String districtName) {
		return areaMapper.findDistrict(districtName);
	}

	
	@Override
	public List<Area> findProvinceByCountry(String countryName) {
		return areaMapper.findProvinceByCountry(countryName);
	}

	@Override
	public List<Area> findCityByProvince(String provinceName) {
		return areaMapper.findCityByProvince(provinceName);
	}

	@Override
	public List<Area> findDistrictByCity(String cityName) {
		return areaMapper.findDistrictByCity(cityName);
	}

	
	
	}

	

