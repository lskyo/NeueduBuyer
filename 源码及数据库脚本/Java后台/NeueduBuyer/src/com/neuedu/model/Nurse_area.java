package com.neuedu.model;
/**
 * @author 刘志杰
 */
public class Nurse_area {
	private int priId;
	private String nurseId;//护工编号
	private int areaId;//区域编号
	
	
	@Override
	public String toString() {
		return "Nurse_area [priId=" + priId + ", nurseId=" + nurseId + ", areaId=" + areaId + "]";
	}
	
	public Nurse_area() {
		super();
	}

	public Nurse_area(int priId, String nurseId, int areaId) {
		super();
		this.priId = priId;
		this.nurseId = nurseId;
		this.areaId = areaId;
	}

	public int getPriId() {
		return priId;
	}
	public void setPriId(int priId) {
		this.priId = priId;
	}
	public String getNurseId() {
		return nurseId;
	}
	public void setNurseId(String nurseId) {
		this.nurseId = nurseId;
	}
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

}
