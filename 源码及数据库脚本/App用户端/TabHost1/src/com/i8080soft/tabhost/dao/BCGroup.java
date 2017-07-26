package com.i8080soft.tabhost.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 * 群组内容
 * 
 */
@SuppressWarnings("serial")
public class BCGroup implements Serializable{
	
	private String groupName;//名片编号

	private String groupMembers;//

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public String getGroupMembers() {
		return groupMembers;
	}

	public void setGroupMembers(String groupMembers) {
		this.groupMembers = groupMembers;
	}

}