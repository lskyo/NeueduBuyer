package com.i8080soft.tabhost;

/**
 * 未完成订单搜索结果页面
 */

import java.util.ArrayList;
import java.util.List;

import cn.trinea.android.common.entity.HttpResponse;
import cn.trinea.android.common.util.HttpUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.i8080soft.tabhost.OrderSearchResult2.UIAsyncTask;
import com.i8080soft.tabhost.adapter.OrderSearchAdapter;
import com.i8080soft.tabhost.data.OrderData;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

public class OrderSearchResult3 extends Activity {
	

	// private View view;
		private List<OrderData> list;
		private ListView order_list_result;
		private Integer[] imgeIDs = { R.drawable.nur1,
				R.drawable.nur2, R.drawable.nur3,
				R.drawable.nur4, R.drawable.nurse1,
				R.drawable.nurse2, R.drawable.nurse3,
				R.drawable.nurse4, R.drawable.nurse5,
				R.drawable.nurse6};
		private OrderSearchAdapter orderSearchAdapter;
		// 实例化一个异步线程
		private UIAsyncTask handler = new UIAsyncTask();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.order_rearch_result3);

		list = new ArrayList<OrderData>();
		order_list_result = (ListView) findViewById(R.id.orderList3);
		handler.execute();
		Log.e("OrderSearch", " <><><><><:::进入listview  ");
	}
	// 这是一个异步线程类，用于在后台进行网络操作，连接到云端平台
			public class UIAsyncTask extends AsyncTask<Void, Void, List<OrderData>> {
				@Override
				protected List<OrderData> doInBackground(Void... params) {
					String url6 = "http://192.168.43.80:8080/NeueduBuyer/reservation/findall.do";
					HttpResponse response = HttpUtils.httpGet(url6);
					String searchJson = response.getResponseBody();
					Log.e("OrderSearch", " <><><><><:::  " + searchJson);
					Log.e("OrderSearch", "============================");
					Gson gson = new GsonBuilder().create();
					// java.lang.reflect.Type type = new TypeToken<Employeedata>()
					// {}.getType();
					if (searchJson != null) {
						List<OrderData> orderSearchData = gson.fromJson(searchJson,
								new TypeToken<List<OrderData>>() {
								}.getType());

						return orderSearchData;
					}

					return null;
				}
				@Override
				protected void onPostExecute(List<OrderData> result) {
					// 在这里显示绑定数据
					Log.e("OrderSearch", " <><><><><::: mmmmmmmmmmmmm ");
					if (result != null) {
						for (int i = 0; i < result.size(); i++) {
							if((result.get(i).getState()).equals("2")){
							OrderData orderData = new OrderData(
									result.get(i).getUserAccount(),
									result.get(i).getNurseId(),
									result.get(i).getReservationId(),
									result.get(i)
											.getBeginTime(),
									result.get(i).getEndTime(), result.get(i)
											.getMoney(), result.get(i).getPlace(),
									imgeIDs[i]);
							list.add(orderData);}
						}
						orderSearchAdapter = new OrderSearchAdapter(
								OrderSearchResult3.this, R.layout.reservation_item,
								list);
						order_list_result.setAdapter(orderSearchAdapter);
					}
				}
			}
}
