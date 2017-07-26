package com.i8080soft.tabhost.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


public class DBContent implements DBDao {

	private static final String TAG = "DBContent";
	private DBHelper dbHelper = null;

	private Context mctx;

	private SQLiteDatabase mdb;

	private Cursor cursor = null;
//	private AdvApplication application;

	public DBContent(Context ctx) {
		this.mctx = ctx;
//		application = (AdvApplication) ctx.getApplicationContext();
	}

	public void open() throws SQLException {
		dbHelper = new DBHelper(mctx);
		mdb = dbHelper.getWritableDatabase();
	}

	public void close() {
		if (dbHelper != null) {
			dbHelper.close();
		}
		if (cursor != null) {
			cursor.close();
		}
	}

	@Override
	public long saveBCCard(BCCard bcCard) {
		open();
		try {
			StringBuffer sql = new StringBuffer(
					"INSERT INTO cardbookcontent (CardBookId,name,EnglishName,HeadShow,Company,Position,MobileTelephone,OfficePhone," +
					"Fax,Address,Email,Postcode,WebUrl,Templet,Department,QQNumber,Remarke,City,Other)");

			sql.append(" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
//			Date d = DateUtill.parse(adv.getExpdate(), DateUtill.MEDIUM);
			Log.i("print", sql.toString());
//			Log.i("print", "saveAdv" + application.getUserId());
			mdb.execSQL(
					sql.toString(),
					new String[] { 
							bcCard.getCardId() + "",
							bcCard.getName(),
							bcCard.getEnglishName(),
							bcCard.getHeadShowUrl() + "",
							bcCard.getCompany(), 
							bcCard.getPosition(),
							bcCard.getTelephoneNumber(),
							bcCard.getOfficeCall(),
							bcCard.getFax(),
							bcCard.getAddress(),
							bcCard.getEmail() + "",
							bcCard.getPostcode() + "",
							bcCard.getWebUrl() + "",
							bcCard.getTemplet() + "", 
							bcCard.getDepartment(),
							bcCard.getQQNumber(), 
							bcCard.getRemarke() + "",
							bcCard.getCity() + "",
							bcCard.getOther()
							
							});

			Log.i("print",
					"saveAdv success BCid=" + bcCard.getCardId() + " Company="
							+ bcCard.getCompany() + " Name:"
							+ bcCard.getName());
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0;
	}

	@Override
	public boolean deleteBCCard(BCCard card) {

		try {
			open();
			
			//删除主键表 CustomCardItem
			String sql = "delete from CustomCardItem where cardId=?";
			mdb.execSQL(sql, new String[] { card.getCardId() + "" });
			
			//删除外键表
            sql = "delete from cardbookcontent where itemid=?";
			mdb.execSQL(sql, new String[] { card.getCardId() + "" });
			return true;
		} catch (Exception e) {

		} finally {
			close();
		}
		return false;
	}

	@Override
	public List<BCCard> getUnExpAdvs() {
		List<BCCard> advs = new ArrayList<BCCard>();

		return advs;
	}

	@Override
	public List<BCCard> getExpAdvs() {
		List<BCCard> advs = new ArrayList<BCCard>();
		return advs;
	}

	@Override
	public boolean updateBCCard(BCCard card) {
		try {
			open();
			String sql = "update cardbookcontent set company =?  where itemid=?";
			mdb.execSQL(sql,
					new String[] { card.getCompany() + "",
					card.getCardId() + "" });
			return true;
		} catch (SQLException e) {
		} finally {
			close();
		}
		return false;
	}

	@Override
	public BCCard getBCCardById(int itemid) {
		try {
			open();
			String sql = "Select * From " + DBHelper.TABLE_BC
					+ " Where CardBookId=?";

			cursor = mdb.rawQuery(sql, new String[] { itemid + "" });

			cursor.moveToFirst();
			BCCard card = null;
			if (cursor != null && cursor.getCount() > 0) {
				card = getBcCard(card, cursor);
			}
			return card;

		} catch (SQLException e) {
		} finally {
			close();
		}
		return null;
	}
	
	public BCCard getBCCardByName(String name){
		
		try {
			open();
			String sql = "Select * From " + DBHelper.TABLE_BC
					+ " Where name=?";

			cursor = mdb.rawQuery(sql, new String[] { name + "" });

			cursor.moveToFirst();
			BCCard card = null;
			if (cursor != null && cursor.getCount() > 0) {
				card = getBcCard(card, cursor);
			}
			return card;

		} catch (SQLException e) {
		} finally {
			close();
		}
		
		return null;
	}
	

	private BCCard getBcCard(BCCard bcCard, Cursor cursor) {
		bcCard = new BCCard();
		
		
		bcCard.setCardId(cursor.getInt(cursor.getColumnIndex(DBHelper.CB_INDEX)));
		
		bcCard.setName(cursor.getString(cursor
				.getColumnIndex(DBHelper.CB_NAME)));
		
		bcCard.setEnglishName(cursor.getString(cursor
				.getColumnIndex(DBHelper.CB_ENGLISHNAME)));
		
		bcCard.setHeadShowUrl(cursor.getString(cursor
				.getColumnIndex(DBHelper.CB_HEADSHOW)));
		
		bcCard.setCompany(cursor.getString(cursor
				.getColumnIndex(DBHelper.CB_COMPANY)));
		
		bcCard.setPosition(cursor.getString(cursor
				.getColumnIndex(DBHelper.CB_POSITION)));
		
		bcCard.setTelephoneNumber(cursor.getString(cursor
				.getColumnIndex(DBHelper.CB_TELEPHONE)));
		
		bcCard.setOfficeCall(cursor.getString(cursor
				.getColumnIndex(DBHelper.CB_CALL)));
		
		bcCard.setFax(cursor.getString(cursor
				.getColumnIndex(DBHelper.CB_FAX)));
		
		bcCard.setAddress(cursor.getString(cursor
				.getColumnIndex(DBHelper.CB_ADDRESS)));
		
		bcCard.setEmail(cursor.getString(cursor
				.getColumnIndex(DBHelper.CB_EMAIL)));
		
		bcCard.setPostcode(cursor.getString(cursor
				.getColumnIndex(DBHelper.CB_POSTCODE)));
		
		bcCard.setWebUrl(cursor.getString(cursor
				.getColumnIndex(DBHelper.CB_WEBURL)));
		
		bcCard.setTemplet(cursor.getInt(cursor
				.getColumnIndex(DBHelper.CB_TEMPLET)));
		
		bcCard.setDepartment(cursor.getString(cursor
				.getColumnIndex(DBHelper.CB_DEPARTMENT)));
		
		bcCard.setQQNumber(cursor.getString(cursor
				.getColumnIndex(DBHelper.CB_QQNUMBER)));
		
		bcCard.setRemarke(cursor.getString(cursor
				.getColumnIndex(DBHelper.CB_REMARK)));
		
		bcCard.setRemarke(cursor.getString(cursor
				.getColumnIndex(DBHelper.CB_CITY)));
		
		bcCard.setOther(cursor.getString(cursor
				.getColumnIndex(DBHelper.CB_OTHER)));
		
		return bcCard;
	}

	@Override
	public boolean exist(int itemid) {
		try {
			open();
			String sql = "Select 1 From " + DBHelper.TABLE_BC
					+ " Where itemid=?";

			cursor = mdb.rawQuery(sql, new String[] { itemid + "" });

			return cursor.getCount() > 0;

		} catch (SQLException e) {
		} finally {
			close();
		}
		return false;
	}

	/**
	 * 获取名片夹数据表中所有名片
	 * 
	 * */
	@Override
	public List<BCCard> getBCCards() {
		// TODO Auto-generated method stub
		List<BCCard> cards = new ArrayList<BCCard>();
		try {
			open();
			String sql = "Select * From " + DBHelper.TABLE_BC + " Order By "
					+ DBHelper._ID + " Desc";

			cursor = mdb.rawQuery(sql, null);
			
			cursor.moveToFirst();
			BCCard card = null;
			
			Log.i(TAG, "listItem2 getBCCards1 = :" + cursor.moveToFirst() + ":" + cursor.isAfterLast());
			
			for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
				
				Log.i(TAG, "listItem2 getBCCards2 = :" + getBcCard(card, cursor));
				
				card = getBcCard(card, cursor);
				
				
				cards.add(card);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		Log.i(TAG, "listItem2 getBCCards = :" + cards.size());
		return cards;
	}
	
	@Override
	public String[] getColumnNames(){
		try {
			open();
			cursor = mdb.query(DBHelper.TABLE_BC, null, null, null, null, null, null);
			Log.i(TAG, "listItem2 cursor.getColumnNames() = :" + cursor.getColumnNames());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cursor.getColumnNames();
	}
	
	
	/////////////////
	@Override
	public long saveMyCard(BCCard bcCard) {
		open();
		try {
			StringBuffer sql = new StringBuffer(
					"INSERT INTO mycardbookcontent (CardBookId,name,EnglishName,HeadShow,Company,Position,MobileTelephone,OfficePhone," +
					"Fax,Address,Email,Postcode,WebUrl,Templet,Department,QQNumber,Remarke,City,Other)");

			sql.append(" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
//			Date d = DateUtill.parse(adv.getExpdate(), DateUtill.MEDIUM);
			Log.i("print", sql.toString());
//			Log.i("print", "saveAdv" + application.getUserId());
			mdb.execSQL(
					sql.toString(),
					new String[] { 
							bcCard.getCardId() + "",
							bcCard.getName(),
							bcCard.getEnglishName(),
							bcCard.getHeadShowUrl() + "",
							bcCard.getCompany(), 
							bcCard.getPosition(),
							bcCard.getTelephoneNumber(),
							bcCard.getOfficeCall(),
							bcCard.getFax(),
							bcCard.getAddress(),
							bcCard.getEmail() + "",
							bcCard.getPostcode() + "",
							bcCard.getWebUrl() + "",
							bcCard.getTemplet() + "", 
							bcCard.getDepartment(),
							bcCard.getQQNumber(), 
							bcCard.getRemarke() + "",
							bcCard.getCity() + "",
							bcCard.getOther()
							
							});

			Log.i("print",
					"saveAdv success BCid=" + bcCard.getCardId() + " Company="
							+ bcCard.getCompany() + " Name:"
							+ bcCard.getName());
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0;
	}

	@Override
	public boolean deleteMyCard(BCCard card) {

		try {
			open();
			String sql = "delete from mycardbookcontent where CardBookId=?";
			mdb.execSQL(sql, new String[] { card.getCardId() + "" });
			return true;
		} catch (Exception e) {

		} finally {
			close();
		}
		return false;
	}
	
	@Override
	public boolean updateMyCardId(int num, BCCard card) {
		try {
			open();
			String sql = "update mycardbookcontent set CardBookId =?  where CardBookId=?";
			mdb.execSQL(sql,
					new String[] { num + "",
					card.getCardId() + "" });
			return true;
		} catch (SQLException e) {
		} finally {
			close();
		}
		return false;
	}

	@Override
	public BCCard getMyCardById(int itemid) {
		try {
			open();
			String sql = "Select * From " + DBHelper.TABLE_BC_MY
					+ " Where CardBookId=?";

			cursor = mdb.rawQuery(sql, new String[] { itemid + "" });

			cursor.moveToFirst();
			BCCard card = null;
			if (cursor != null && cursor.getCount() > 0) {
				card = getBcCard(card, cursor);
			}
			return card;

		} catch (SQLException e) {
		} finally {
			close();
		}
		return null;
	}
	
	@Override
	public BCCard getMyCardByName(String name){
		try {
			open();
			String sql = "Select * From " + DBHelper.TABLE_BC_MY
					+ " Where name=?";

			cursor = mdb.rawQuery(sql, new String[] { name + "" });

			cursor.moveToFirst();
			BCCard card = null;
			if (cursor != null && cursor.getCount() > 0) {
				card = getBcCard(card, cursor);
			}
			return card;

		} catch (SQLException e) {
		} finally {
			close();
		}
		
		return null;
	}
	
	/**
	 * 获取名片夹数据表中所有名片
	 * 
	 * */
	@Override
	public List<BCCard> getMyCards() {
		// TODO Auto-generated method stub
		List<BCCard> cards = new ArrayList<BCCard>();
		try {
			open();
			String sql = "Select * From " + DBHelper.TABLE_BC_MY + " Order By "
					+ DBHelper.CB_INDEX + " Desc";//asc 升序

			cursor = mdb.rawQuery(sql, null);
			
			cursor.moveToFirst();
			BCCard card = null;
			
			Log.i(TAG, "listItem2 getBCCards1 = :" + cursor.moveToFirst() + ":" + cursor.isAfterLast());
			
			for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
				
				Log.i(TAG, "listItem2 getBCCards2 = :" + getBcCard(card, cursor));
				
				card = getBcCard(card, cursor);
				
				
				cards.add(card);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		Log.i(TAG, "listItem2 getBCCards = :" + cards.size());
		return cards;
	}
	
	@Override
	public String[] getMyColumnNames() {
		try {
			open();
			cursor = mdb.query(DBHelper.TABLE_BC_MY, null, null, null, null, null, null);
			Log.i(TAG, "listItem2 cursor.getColumnNames() = :" + cursor.getColumnNames());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cursor.getColumnNames();
	}

	@Override
	public boolean existInMy(int itemid) {
		try {
			open();
			String sql = "Select 1 From " + DBHelper.TABLE_BC_MY
					+ " Where itemid=?";

			cursor = mdb.rawQuery(sql, new String[] { itemid + "" });

			return cursor.getCount() > 0;

		} catch (SQLException e) {
		} finally {
			close();
		}
		return false;
	}
	
	
	
	/////////////////
	@Override
	public long saveToGroup(BCGroup bcGroup) {
		open();
		try {
			StringBuffer sql = new StringBuffer(
					"INSERT INTO cardGroup (cardGroupName,cardGroupMembersId)");
			
			sql.append(" values(?,?)");
			//Date d = DateUtill.parse(adv.getExpdate(), DateUtill.MEDIUM);
			Log.i("print", sql.toString());
			//Log.i("print", "saveAdv" + application.getUserId());
			mdb.execSQL(
					sql.toString(),
					new String[] {bcGroup.getGroupName() + "",bcGroup.getGroupMembers() + ""});
			
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0;
	}
	
	
	@Override
	public List<BCGroup> getBCGroups() {
		// TODO Auto-generated method stub
		List<BCGroup> groups = new ArrayList<BCGroup>();
		try {
			open();
			String sql = "Select * From " + DBHelper.TABLE_BC_GROUP + " Order By "
					+ DBHelper._ID + " asc";

			cursor = mdb.rawQuery(sql, null);
			
			cursor.moveToFirst();
			BCGroup group = null;
			
			Log.i(TAG, "listItem2 getBCCards1 = :" + cursor.moveToFirst() + ":" + cursor.isAfterLast());
			
			for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
				
//				Log.i(TAG, "listItem2 getBCCards2 = :" + getBcCard(card, cursor));
				
				//group = getBcCard(group, cursor);
				group = new BCGroup();
				group.setGroupName(cursor.getString(cursor
						.getColumnIndex(DBHelper.CB_GROUP_NAME)));
				group.setGroupMembers(cursor.getString(cursor
						.getColumnIndex(DBHelper.CB_GROUP_MEMBER_ID)));
				
				
				groups.add(group);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		Log.i(TAG, "listItem2 getBCCards = :" + groups.size());
		return groups;
	}
	
	
	@Override
	public boolean deleteGroup(BCGroup group) {

		try {
			open();
			String sql = "delete from cardGroup where cardGroupName=?";
			mdb.execSQL(sql, new String[] { group.getGroupName() + "" });
			return true;
		} catch (Exception e) {

		} finally {
			close();
		}
		return false;
	}
	
	@Override
	public boolean updateGroupMembers(String members, BCGroup group) {
		try {
			open();
			String sql = "update cardGroup set cardGroupMembersId =?  where cardGroupName=?";
			mdb.execSQL(sql,
					new String[] { members + "",
					group.getGroupName() + "" });
			return true;
		} catch (SQLException e) {
		} finally {
			close();
		}
		return false;
	}
	
	@Override
	public BCGroup getGroupByName(String name){
		try {
			open();
			String sql = "Select * From " + DBHelper.TABLE_BC_GROUP
					+ " Where cardGroupName=?";

			cursor = mdb.rawQuery(sql, new String[] { name + "" });

			cursor.moveToFirst();
			BCGroup group = new BCGroup();
			
			if (cursor != null && cursor.getCount() > 0) {

//				group = new BCGroup();
				group.setGroupName(cursor.getString(cursor
						.getColumnIndex(DBHelper.CB_GROUP_NAME)));
				group.setGroupMembers(cursor.getString(cursor
						.getColumnIndex(DBHelper.CB_GROUP_MEMBER_ID)));
			}
			return group;

		} catch (SQLException e) {
		} finally {
			close();
		}
		
		return null;
	}
	
	
	
	
	
	
}
