package com.neuedu.model;


/**
 * 用户类
 * @author 罗星华
 */
public class User {
	private String userAccount; //账号
	private String userName; //姓名
	private String password;  //密码
	private String userMobile;  //手机号
	private String userIdcard;  //身份证号
	private int userCredit;  //信誉度
	private int userBalance;  //余额
	
	public User() {
		super();
	}
	public User(String userAccount, String userName, String password, String userMobile, String userIdcard,
			int userCredit, int userBalance) {
		super();
		this.userAccount = userAccount;
		this.userName = userName;
		this.password = password;
		this.userMobile = userMobile;
		this.userIdcard = userIdcard;
		this.userCredit = userCredit;
		this.userBalance = userBalance;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public String getUserIdcard() {
		return userIdcard;
	}
	public void setUserIdcard(String userIdcard) {
		this.userIdcard = userIdcard;
	}
	public int getUserBalance() {
		return userBalance;
	}
	public void setUserBalance(int userBalance) {
		this.userBalance = userBalance;
	}
	public int getUserCredit() {
		return userCredit;
	}
	public void setUserCredit(int userCredit) {
		this.userCredit = userCredit;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", userAccount=" + userAccount + ", password=" + password
				+ ", userMobile=" + userMobile + ", userIdcard=" + userIdcard + ", userBalance=" + userBalance
				+ ", userCredit=" + userCredit + "]";
	}
	
	
	
}
