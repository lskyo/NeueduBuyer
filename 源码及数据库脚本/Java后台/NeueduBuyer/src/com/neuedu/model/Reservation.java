package com.neuedu.model;

/**
 * @author 青计
 */
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

public class Reservation {

	private String reservationId;
	private String userAccount;
	private String nurseId;
	private String beginTime;
	private String endTime;
	private int money;
	private String place;
	private int state;
	
	
	
	
	
	public Reservation() {
		super();
	}
	public Reservation(String reservationId, String userAccount, String nurseId, String beginTime, String endTime,
			int money, String place, int state) {
		super();
		this.reservationId = reservationId;
		this.userAccount = userAccount;
		this.nurseId = nurseId;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.money = money;
		this.place = place;
		this.state = state;
	}
	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", userAccount=" + userAccount + ", nurseId=" + nurseId
				+ ", beginTime=" + beginTime + ", endTime=" + endTime + ", money=" + money + ", place=" + place
				+ ", state=" + state + "]";
	}
	public String getReservationId() {
		return reservationId;
	}
	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
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
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	

	
	
	
	
	
	
	
	
	

}
