package com.i8080soft.tabhost.dao;

import java.util.List;


public interface DBDao {

	public long saveBCCard(BCCard bcCard);
	public long saveMyCard(BCCard bcCard);
	public long saveToGroup(BCGroup bcGroup);
	
	
	public boolean deleteBCCard(BCCard bcCard);
	public boolean deleteMyCard(BCCard bcCard);
	public boolean deleteGroup(BCGroup group);

	public List<BCCard> getUnExpAdvs();
	public List<BCCard> getExpAdvs();
	
	public List<BCCard> getBCCards();
	public List<BCCard> getMyCards();
	public List<BCGroup> getBCGroups();
	
	public boolean updateBCCard(BCCard card);
	public boolean updateMyCardId(int num, BCCard card);
	public boolean updateGroupMembers(String members, BCGroup group);
	
	public BCCard getBCCardByName(String name);
	public BCCard getMyCardByName(String name);
	public BCGroup getGroupByName(String name);
	
	public BCCard getBCCardById(int itemid);
	public BCCard getMyCardById(int itemid);

	public boolean exist(int itemid);
	public boolean existInMy(int itemid);
	
	public String[] getColumnNames();
	public String[] getMyColumnNames();
	
}
