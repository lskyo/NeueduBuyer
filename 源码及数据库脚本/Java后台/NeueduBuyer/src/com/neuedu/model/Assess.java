package com.neuedu.model;

/**
 * 
 * @author 杨越
 *
 */
public class Assess {
	private String assessId;
	private String nurseId;
	private String summary;
	private int level;
	private String userAccount;
	private int isShowName;

	@Override
	public String toString() {
		return "Assess [assessId=" + assessId + ", nurseId=" + nurseId + ", summary=" + summary + ", level=" + level
				+ ", userAccount=" + userAccount + ", isShowName=" + isShowName + "]";
	}

	public Assess(String assessId, String nurseId, String summary, int level, String userAccount, int isShowName) {
		super();
		this.assessId = assessId;
		this.nurseId = nurseId;
		this.summary = summary;
		this.level = level;
		this.userAccount = userAccount;
		this.isShowName = isShowName;
	}

	public Assess() {
		super();
	}

	public String getAssessId() {
		return assessId;
	}

	public void setAssessId(String c) {
		this.assessId = c;
	}

	public String getNurseId() {
		return nurseId;
	}

	public void setNurseId(String nurseId) {
		this.nurseId = nurseId;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public int getIsShowName() {
		return isShowName;
	}

	public void setIsShowName(int isShowName) {
		this.isShowName = isShowName;
	}

}
