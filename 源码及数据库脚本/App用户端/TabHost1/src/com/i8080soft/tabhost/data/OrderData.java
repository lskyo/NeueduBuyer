package com.i8080soft.tabhost.data;

import android.R.integer;
import android.provider.ContactsContract.Data;

public class OrderData {
	private String userAccount;// 用户账号
	private String nurseId;// 护工编号
	private String reservationId;// 预约信息编号
	private String beginTime;// 服务起始时间
	private String endTime;// 服务结束时间
	private int money;// 金额
	private String place;// 地点
	private int nursephoto;
	private String state;

	public OrderData(String state) {
		super();
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public OrderData(String userAccount, String nurseId, String reservationId,
			String beginTime, String endTime, int money, String place,
			int nursephoto) {
		super();
		this.userAccount = userAccount;
		this.nurseId = nurseId;
		this.reservationId = reservationId;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.money = money;
		this.place = place;
		this.nursephoto = nursephoto;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getNurseId() {
		return nurseId;
	}

	public void setNurseId(String nurseId) {
		this.nurseId = nurseId;
	}

	public String getReservationId() {
		return reservationId;
	}

	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getNursephoto() {
		return nursephoto;
	}

	public void setNursephoto(int nursephoto) {
		this.nursephoto = nursephoto;
	}

}
