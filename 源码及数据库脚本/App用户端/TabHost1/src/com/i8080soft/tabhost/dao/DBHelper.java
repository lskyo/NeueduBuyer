package com.i8080soft.tabhost.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

	public DBHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}

	public DBHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	// 数据库名称
	private static final String DB_NAME = "cardbook.db";
	// 数据库版本
	private static final int DB_VERSION = 2;

	// 名片夹数据表
	public static final String TABLE_BC = "cardbookcontent";// 权限表
	public static final String _ID = "_id";// id
	public static final String CB_INDEX = "CardBookId";// 顺序编号
	public static final String CB_NAME = "name";// 职员名字
	public static final String CB_ENGLISHNAME = "EnglishName";// 职员英文名字
	public static final String CB_HEADSHOW = "HeadShow";// 头像
	public static final String CB_COMPANY = "Company";// 公司名
	public static final String CB_POSITION = "Position";// 职位
	public static final String CB_TELEPHONE = "MobileTelephone";// 手机号
	public static final String CB_CALL = "OfficePhone";// 电话
	public static final String CB_FAX = "Fax";// 传真
	public static final String CB_ADDRESS = "Address";// 地址
	public static final String CB_EMAIL = "Email";// 邮箱
	public static final String CB_POSTCODE = "Postcode";// 邮编
	public static final String CB_WEBURL = "WebUrl";// 网址
	public static final String CB_TEMPLET = "Templet";// 模板
	public static final String CB_DEPARTMENT = "Department";//部门
	public static final String CB_QQNUMBER = "QQNumber";//QQ号
	public static final String CB_REMARK = "Remarke";//备注
	
	public static final String CB_CITY = "City";//城市
	
	public static final String CB_OTHER = "Other";//其他
	
	// 我自己的名片数据表---内容列使用名片夹的列名
	public static final String TABLE_BC_MY = "mycardbookcontent";// 权限表
	
	public static final String TABLE_BC_GROUP = "cardGroup";// 群组权限表
	public static final String CB_GROUP_NAME = "cardGroupName";
	public static final String CB_GROUP_MEMBER_ID = "cardGroupMembersId";
	
	/**
	 * 创建名片夹权限表
	 */
	private static String SQL_CREATE_BC_TABLE = "CREATE TABLE IF NOT EXISTS "
			+ TABLE_BC + "(" 
					+ _ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ CB_INDEX + " Integer," 
					+ CB_NAME + " VARCHAR(256)," 
					+ CB_ENGLISHNAME + " VARCHAR(256),"
					+ CB_HEADSHOW + "  VARCHAR(100)," 
					+ CB_COMPANY + " VARCHAR(200),"
					+ CB_POSITION + " VARCHAR(220),"
					+ CB_TELEPHONE + " VARCHAR(240)," 
					+ CB_CALL + " VARCHAR(240)," 
					+ CB_FAX + " VARCHAR(240),"
					+ CB_ADDRESS + " VARCHAR(400)," 
					+ CB_EMAIL + " VARCHAR(240),"
					+ CB_POSTCODE + " VARCHAR(250),"
					+ CB_WEBURL + " VARCHAR(250),"
					+ CB_TEMPLET + " Integer,"
					+ CB_DEPARTMENT + " VARCHAR(250),"
					+ CB_QQNUMBER + " VARCHAR(250),"
					+ CB_REMARK + " VARCHAR(250),"
					+ CB_CITY + " VARCHAR(250),"
					+ CB_OTHER + " VARCHAR(256))";
	
	/**
	 * 创建我自己的名片权限表
	 */
	private static String SQL_CREATE_BC_TABLE_MY = "CREATE TABLE IF NOT EXISTS "
			+ TABLE_BC_MY + "(" 
					+ _ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ CB_INDEX + " Integer," 
					+ CB_NAME + " VARCHAR(256)," 
					+ CB_ENGLISHNAME + " VARCHAR(256),"
					+ CB_HEADSHOW + "  VARCHAR(100)," 
					+ CB_COMPANY + " VARCHAR(200),"
					+ CB_POSITION + " VARCHAR(220),"
					+ CB_TELEPHONE + " VARCHAR(240)," 
					+ CB_CALL + " VARCHAR(240)," 
					+ CB_FAX + " VARCHAR(240),"
					+ CB_ADDRESS + " VARCHAR(400)," 
					+ CB_EMAIL + " VARCHAR(240),"
					+ CB_POSTCODE + " VARCHAR(250),"
					+ CB_WEBURL + " VARCHAR(250),"
					+ CB_TEMPLET + " Integer,"
					+ CB_DEPARTMENT + " VARCHAR(250),"
					+ CB_QQNUMBER + " VARCHAR(250),"
					+ CB_REMARK + " VARCHAR(250),"
					+ CB_CITY + " VARCHAR(250),"
					+ CB_OTHER + " VARCHAR(256))";
	
	
	/**
	 * 创建群组管理权限表
	 */
	private static String SQL_CREATE_BC_TABLE_GROUP = "CREATE TABLE IF NOT EXISTS "
			+ TABLE_BC_GROUP + "(" 
					+ _ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ CB_GROUP_NAME + " VARCHAR(64)," 
					+ CB_GROUP_MEMBER_ID + " VARCHAR(256))";


	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(SQL_CREATE_BC_TABLE);
		db.execSQL(SQL_CREATE_BC_TABLE_MY);
		db.execSQL(SQL_CREATE_BC_TABLE_GROUP);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS cardbookcontent");
		db.execSQL("DROP TABLE IF EXISTS mycardbookcontent");
		db.execSQL("DROP TABLE IF EXISTS cardGroup");
		onCreate(db);
	}

}
