package com.neuedu.model;
/**
 *  护工表
 * *@author 青计
 * 
 */
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Nurse {

	private String nurseId;
	private String nurseName;
	private String nurseIdcard;
	private int    sex;
	private String   birthday;
	private int    age;
	private String major;
	private String   createTime;
	private String introduce;
	private int    isfree;
	private int    wage;
	private String address;
	private String nursePicture;
	private int    nurseLevel;
	

	@Override
	public String toString() {
		return "Nurse [nurseId=" + nurseId + ", nurseName=" + nurseName + ", nurseIdcard=" + nurseIdcard + ", sex="
				+ sex + ", birthday=" + birthday + ", age=" + age + ", major=" + major + ", createTime=" + createTime
				+ ", introduce=" + introduce + ", isfree=" + isfree + ", wage=" + wage + ", address=" + address
				+ ", nursePicture=" + nursePicture + ", nurseLevel=" + nurseLevel + "]";
	}
	public Nurse() {
		super();
	}
	public Nurse(String nurseId, String nurseName, String nurseIdcard, int sex, String birthday, int age, String major,
			String createTime, String introduce, int isfree, int wage, String address, String nursePicture,
			int nurseLevel) {
		super();
		this.nurseId = nurseId;
		this.nurseName = nurseName;
		this.nurseIdcard = nurseIdcard;
		this.sex = sex;
		this.birthday = birthday;
		this.age = age;
		this.major = major;
		this.createTime = createTime;
		this.introduce = introduce;
		this.isfree = isfree;
		this.wage = wage;
		this.address = address;
		this.nursePicture = nursePicture;
		this.nurseLevel = nurseLevel;
	}
	public String getNurseId() {
		return nurseId;
	}
	public void setNurseId(String nurseId) {
		this.nurseId = nurseId;
	}
	public String getNurseName() {
		return nurseName;
	}
	public void setNurseName(String nurseName) {
		this.nurseName = nurseName;
	}
	public String getNurseIdcard() {
		return nurseIdcard;
	}
	public void setNurseIdcard(String nurseIdcard) {
		this.nurseIdcard = nurseIdcard;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public int getIsfree() {
		return isfree;
	}
	public void setIsfree(int isfree) {
		this.isfree = isfree;
	}
	public int getWage() {
		return wage;
	}
	public void setWage(int wage) {
		this.wage = wage;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNursePicture() {
		return nursePicture;
	}
	public void setNursePicture(String nursePicture) {
		this.nursePicture = nursePicture;
	}
	public int getNurseLevel() {
		return nurseLevel;
	}
	public void setNurseLevel(int nurseLevel) {
		this.nurseLevel = nurseLevel;
	}
	

	
}
