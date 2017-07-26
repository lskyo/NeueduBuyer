package com.neuedu.model;

/**
 * 
 * @author 林培坚
 *
 */
public class Area {

	private int areaId;
	private String coding;
	private String province;
	private String city;
	private String district;
	private String parent;

	public Area() {
		super();
	}

	public Area(int areaId, String code, String province, String city, String district, String parent) {
		super();
		this.areaId = areaId;
		this.coding = code;
		this.province = province;
		this.city = city;
		this.district = district;
		this.parent = parent;
	}

	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	
	public String getCoding() {
		return coding;
	}

	public void setCoding(String coding) {
		this.coding = coding;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

}
