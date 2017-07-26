package com.i8080soft.tabhost.fragment;
                                  
/**
 * 订单页面
 */

import java.util.HashMap;
import java.util.Map;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import cn.trinea.android.common.entity.HttpResponse;
import cn.trinea.android.common.util.HttpUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.i8080soft.tabhost.OrderSearchResult1;
import com.i8080soft.tabhost.OrderSearchResult2;
import com.i8080soft.tabhost.OrderSearchResult3;
import com.i8080soft.tabhost.OrderSearchResult4;
import com.i8080soft.tabhost.R;
import com.i8080soft.tabhost.login;
import com.i8080soft.tabhost.data.OrderData;



public class SearchOrderFragment extends Fragment {
	private View view;
    private UIAsyncTask handler =new  UIAsyncTask();

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
			ImageView loginphoto = (ImageView)getActivity().findViewById(R.id.loginphoto);
			loginphoto.setClickable(true);
			loginphoto.setOnClickListener(new OnClickListener() {
				// 为个人设置设置监听事件，跳转到完善个人信息界面
				@Override
				public void onClick(View v) {
					Intent loginIntent = new Intent(getActivity(),
							login.class);
					startActivity(loginIntent);
				}
			});
			
		
		/*((TextView) getActivity().findViewById(R.id.appTitle)).setText(R.string.tab_search);
*/
	}
	 /*  public class UIAsyncTask extends AsyncTask<Void, Void,  String> {
	        @Override
	        protected  String doInBackground(Void... params) {
	            String url6 = "http://localhost:8080/gmsystem/reservation/findall.do";
	            HttpResponse response = HttpUtils.httpGet(url6);
	            String searchJson = response.getResponseBody();
	            Log.e("OrderSearch", " <><><><><:::  " + searchJson);
	            Log.e("OrderSearch", "============================");
	            Gson gson = new GsonBuilder().create();
	            //java.lang.reflect.Type type = new TypeToken<Employeedata>() {}.getType();
	            if(searchJson!=null)
	            {
	            	String employeedata=gson.fromJson(searchJson, new TypeToken<String>() {}.getType());

	                return  employeedata;
	            }

	            return null;
	        }

	        @Override
	        protected void onPostExecute( String result) {
	            //在这里显示绑定数据
	            Log.e("Employee", " <><><><><::: mmmmmmmmmmmmm " );
	            if(result!=null){
	                
	            }
	        }
	    }*/
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		view = inflater.inflate(R.layout.tab_search, container, false);
		TextView orderReservition = (TextView)view.findViewById(R.id.orderReservition);
		TextView orderFinish = (TextView)view.findViewById(R.id.orderFinish);
		TextView orderNofinish = (TextView)view.findViewById(R.id.orderNofinish);
		TextView orderHistory = (TextView)view.findViewById(R.id.orderHistory);
		
		orderReservition.setClickable(true);
		orderFinish.setClickable(true);
		orderNofinish.setClickable(true);
		orderHistory.setClickable(true);
		
		orderFinish.setEnabled(true);
		orderReservition.setEnabled(true);
		orderNofinish.setEnabled(true);
		orderHistory.setEnabled(true);
		  //这是一个异步线程类，用于在后台进行网络操作，连接到云端平台
		orderReservition.setOnClickListener(new OnClickListener() {
		
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity(), "预约订单", Toast.LENGTH_SHORT).show();
				//new UIAsyncTask().execute();
				
			Intent orderSearchIntent = new Intent(getActivity(),
						OrderSearchResult1.class);
				startActivity(orderSearchIntent);
			}
		});
		
		
		
		orderFinish.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity(), "已完成订单", Toast.LENGTH_SHORT).show();
				Intent orderSearchIntent2 = new Intent(getActivity(),
						OrderSearchResult2.class);
				startActivity(orderSearchIntent2);
				
			}
		});
		orderNofinish.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			 Toast.makeText(getActivity(), "未完成订单", Toast.LENGTH_SHORT).show();
			 Intent orderSearchIntent3 = new Intent(getActivity(),
						OrderSearchResult3.class);
				startActivity(orderSearchIntent3);
			}
		});
		orderHistory.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity(), "历史订单", Toast.LENGTH_SHORT).show();
				Intent orderSearchIntent4 = new Intent(getActivity(),
						OrderSearchResult4.class);
				startActivity(orderSearchIntent4);
			}
		});
		
		return view;
	}
	 //这是一个异步线程类，用于在后台进行网络操作，连接到云端平台
    private class UIAsyncTask extends AsyncTask<Void, Void,  OrderData> {
        @Override
        protected  OrderData doInBackground(Void... params) {
            //新增员工
            String httpUrl1 = "http://192.168.43.80:8080/gmsystem/reservation/findall.do";
            Map<String,String> parasMap=new HashMap<String,String>();
           /* parasMap.put("employeeId","employee555");
            parasMap.put("employeeAccount","jimoruxue");
            parasMap.put("password","653424554");
            parasMap.put("employeeName","wangba");
            parasMap.put("employeeMobile","13558476548");
            parasMap.put("departmentId","1");*/
            HttpUtils.httpPostString(httpUrl1,parasMap);

            HttpResponse response = HttpUtils.httpGet(httpUrl1);
            Gson gson = new GsonBuilder().create();
            String orderJson = response.getResponseBody();
            Log.e("Order", " <><><><><::: mmmmmmmmmmmmm "+orderJson );
            Log.e("Order", "============================");
            if(orderJson!=null) {
                OrderData orderData=gson.fromJson(orderJson, new TypeToken<OrderData>() {}.getType());
                Log.e("Order----NurseId",   " ++ "+ orderData.getNurseId());
                return orderData;
            } 
            return null;
        }

        @Override
        protected void onPostExecute( OrderData result) {
            //在这里显示绑定数据
            if(result!=null) {
                Log.e("Order", " <><><><><::: mmmmmmmmmmmmm " + result.toString());
                //tvresult.setText(result.getInfo());
            }
        }
    }
}
