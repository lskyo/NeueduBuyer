package com.i8080soft.tabhost;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.i8080soft.tabhost.data.OrderData;
import com.i8080soft.tabhost.data.usedata;
import com.i8080soft.tabhost.register.UIAsyncTask;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;
import cn.trinea.android.common.entity.HttpResponse;
import cn.trinea.android.common.util.HttpUtils;
import android.widget.Toast;

public class OrderSure extends Activity {
	// 定义5个记录当前时间的变量
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	private DatePicker datePicker1;
	private TimePicker timePicker1;
	private DatePicker datePicker2;
	private TimePicker timePicker2;
	private EditText show1;
	private EditText show2;
	private EditText getmoney;
	private String beginTime;
	private String endTime;
	private String workAddress;
	private String nurseId;
	private String userAccount;
	private int pay;
	private String money;
	private double time1;
	private double time2;
	private SharedPreferences preferences;
	// 实例化一个异步线程
	private UIAsyncTask handler = new UIAsyncTask();

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.order_sure);
		preferences = getApplicationContext().getSharedPreferences("Registerdata", Context.MODE_PRIVATE);
		datePicker1 = (DatePicker) findViewById(R.id.datePicker1);
		timePicker1 = (TimePicker) findViewById(R.id.timePicker1);
		datePicker2 = (DatePicker) findViewById(R.id.datePicker2);
		timePicker2 = (TimePicker) findViewById(R.id.timePicker2);

		// 获取当前的年、月、日、小时、分钟
		Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);
		hour = c.get(Calendar.HOUR);
		minute = c.get(Calendar.MINUTE);

		// 初始化DatePicker1组件，初始化时指定监听器
		datePicker1.init(year, month, day, new OnDateChangedListener() {

			@Override
			public void onDateChanged(DatePicker arg0, int year, int month, int day) {
				OrderSure.this.year = year;
				OrderSure.this.month = month;
				OrderSure.this.day = day;
				// 显示当前日期、时间
				showDate1(year, month, day, hour, minute);
				time1 = ((year * 365) + (month * 30) + (day + hour / 24.0) + (minute / 60.0 / 24.0));
			}
		});
		datePicker2.init(year, month, day, new OnDateChangedListener() {

			@Override
			public void onDateChanged(DatePicker arg0, int year, int month, int day) {
				OrderSure.this.year = year;
				OrderSure.this.month = month;
				OrderSure.this.day = day;
				// 显示当前日期、时间
				showDate2(year, month, day, hour, minute);
				time2 = ((year * 365) + (month * 30) + (day + hour / 24.0) + (minute / 60.0 / 24.0));
			}
		});
		// 为TimePicker1指定监听器
		timePicker1.setOnTimeChangedListener(new OnTimeChangedListener() {

			@Override
			public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
				OrderSure.this.hour = hourOfDay;
				OrderSure.this.minute = minute;
				// 显示当前日期、时间
				showDate1(year, month, day, hour, minute);
				//
			}
		});

		timePicker2.setOnTimeChangedListener(new OnTimeChangedListener() {

			@Override
			public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
				OrderSure.this.hour = hourOfDay;
				OrderSure.this.minute = minute;
				// 显示当前日期、时间
				showDate2(year, month, day, hour, minute);

			}
		});
		Intent intentGet = getIntent();
		Bundle bundle = intentGet.getExtras();
		nurseId = bundle.getString("nurseid");
		money = bundle.getString("money");
		pay = (int) ((time2 - time1) * (Integer.parseInt(money)));
		getmoney = (EditText) findViewById(R.id.payEdit);
		getmoney.setText(pay + "");
		money = (getmoney.getText()).toString();
		Button surebtn = (Button) findViewById(R.id.submit);

		surebtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				workAddress = ((EditText) findViewById(R.id.workAddressEdit)).getText().toString(); // 获取服务地址
				beginTime = ((EditText) findViewById(R.id.show1)).getText().toString(); // 获取服务开始时间
				endTime = ((EditText) findViewById(R.id.show2)).getText().toString(); // 获取服务结束时间

				if (!"".equals(workAddress) && !"".equals(beginTime) && !"".equals(endTime) && !"".equals(money)) {
					Toast.makeText(OrderSure.this, "支付成功", Toast.LENGTH_SHORT).show();
					handler.execute();
					Intent intent = new Intent(OrderSure.this, MainActivity.class);
					startActivity(intent);
					finish();
				} else {
					Toast.makeText(OrderSure.this, "请将预约信息填写完整", Toast.LENGTH_LONG).show();
				}

			}
		});
	}

	// 定义在EditText中显示当前日期、时间的方法
	private void showDate1(int year, int month, int day, int hour, int minute) {
		EditText show1 = (EditText) findViewById(R.id.show1);
		show1.setText(year + "年" + (month + 1) + "月" + day + "日  " + hour + "时" + minute + "分");
	}

	private void showDate2(int year, int month, int day, int hour, int minute) {
		EditText show2 = (EditText) findViewById(R.id.show2);
		show2.setText(year + "年" + (month + 1) + "月" + day + "日  " + hour + "时" + minute + "分");
	}

	// 这是一个异步线程类，用于在后台进行网络操作，连接到云端平台
	public class UIAsyncTask extends AsyncTask<Void, Void, usedata> {
		@Override
		protected usedata doInBackground(Void... params) {
			// 新增用户
			String httpUrl1 = "http://192.168.43.80:8080/NeueduBuyer/reservation/add.do";
			Map<String, String> parasMap = new HashMap<String, String>();
			userAccount = preferences.getString("userAccount", null);
			parasMap.put("nurseId", nurseId);
			parasMap.put("userAccount", userAccount);
			parasMap.put("reservationId", nurseId + userAccount + "");
			parasMap.put("beginTime", beginTime);/////
			parasMap.put("endTime", endTime);//////
			parasMap.put("place", workAddress);
			parasMap.put("money", pay + "");
			parasMap.put("state", "0");
			String response = HttpUtils.httpPostString(httpUrl1, parasMap);

			/*
			 * string格式转化为Datetime对象： //把string转化为date DateFormat fmt =new
			 * SimpleDateFormat("yyyy-MM-dd"); Date date =
			 * fmt.parse(szBeginTime); test.setStartTime(date);
			 */

			//HttpResponse response = HttpUtils.httpGet(httpUrl1);

			Gson gson = new GsonBuilder().create();
			String departJson = response;
			Log.e("departJson", "》》》》》》》》》》》》》》》》》 " + departJson);
			//Log.e("resevation", "============================");
			if (departJson != null) {
				usedata orderData = gson.fromJson(departJson, new TypeToken<usedata>() {
				}.getType());
				Log.e("resevation----isResult", " ++ " + orderData);
				return orderData;
			}
			return null;
		}

		@Override
		protected void onPostExecute(usedata result) {
			// 在这里显示绑定数据
			if (result != null) {
				Log.e("resevation", " <><><><><::: mmmmmmmmmmmmm " + result.toString());
				// tvresult.setText(result.getInfo());
			}
		}
	}

}
