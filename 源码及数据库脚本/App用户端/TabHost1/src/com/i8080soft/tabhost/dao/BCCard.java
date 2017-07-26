package com.i8080soft.tabhost.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
//import java.util.Date;

//import com.ctowo.contact.uit.DateUtill;

/**
 * 
 * 名片内容
 * 
 */
@SuppressWarnings("serial")
public class BCCard implements Serializable{
	
	private int cardid;//名片编号
	private String name;//职员名
	private String englishName;//职员英文名
	private String headShowUrl;//头像
	private String company;//公司名称
	private String position;//职位
	private String telephoneNumber;//phone nub
	private String officeCall;//电话
	private String fax;//传真
	private String address;//地址
	private String email;//邮箱
	
	private String postcode;//邮编
	private String webUrl;//网址
	private int templet;//模板
	
	private String department;//部门
	private String qqNumber;//QQ号
	private String remarke;//备注
	
	private String city;//城市
	private String group;//群组
	
	private String other;//
	
	//自定义的名片属性集合，可以添加多个自定义的联系信息
	private List<CustomCardItem> customs = new ArrayList<CustomCardItem>();

	
	public int getCardId() {
		return cardid;
	}

	public void setCardId(int cardid) {
		this.cardid = cardid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEnglishName() {
		return englishName;
	}
	
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	
	public String getHeadShowUrl() {
		return headShowUrl;
	}
	
	public void setHeadShowUrl(String headShowUrl) {
		this.headShowUrl = headShowUrl;
	}
	
	public String getCompany() {
		return company;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	
	public String getOfficeCall() {
		return officeCall;
	}

	public void setOfficeCall(String officeCall) {
		this.officeCall = officeCall;
	}

	public String getFax() {
		return fax;
	}
	
	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}
	
	public int getTemplet() {
		return templet;
	}

	public void setTemplet(int templet) {
		this.templet = templet;
	}
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getQQNumber() {
		return qqNumber;
	}

	public void setQQNumber(String qqNumber) {
		this.qqNumber = qqNumber;
	}
	
	public String getRemarke() {
		return remarke;
	}

	public void setRemarke(String remarke) {
		this.remarke = remarke;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
	
	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

}