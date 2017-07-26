package com.i8080soft.tabhost.fragment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import cn.trinea.android.common.entity.HttpResponse;
import cn.trinea.android.common.util.HttpUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.i8080soft.tabhost.R;
import com.i8080soft.tabhost.SubmitOrder;
import com.i8080soft.tabhost.login;
import com.i8080soft.tabhost.adapter.ShowNurseAdapter;
import com.i8080soft.tabhost.data.NurselookData;

/**
 * 
 * 根据不同的数据使用不同的ItemView
 * 
 * @author chensw
 * 
 */
public class CardsFragment extends Fragment {
	private GridView gridView = null;
	private String[] data = null;
	private View view;
	private ListView nurse_list_result;
	private ShowNurseAdapter showNurseAdapter;
	private List<NurselookData> list;
	private List<String> name_list,id_list,sex_list,wave_list,pic_list,major_list;
	 //实例化一个异步线程
    private UIAsyncTask handler =new UIAsyncTask();
    private Integer[] imgeIDs = {R.drawable.nur1,
			R.drawable.nur2, R.drawable.nur3,
			R.drawable.nur4, R.drawable.nurse1,
			R.drawable.nurse2, R.drawable.nurse3,
			R.drawable.nurse4, R.drawable.nurse5,
			R.drawable.nurse6};
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// 修改title名称
		 view = inflater.inflate(R.layout.activity_listview, container, false);  
		 list = new ArrayList<NurselookData>();
	     nurse_list_result=(ListView)view.findViewById(R.id.employeeresult);
	     name_list=new ArrayList<String>();
	     id_list=new ArrayList<String>();
	     sex_list=new ArrayList<String>();
	     wave_list=new ArrayList<String>();
	     pic_list=new ArrayList<String>();
	     major_list=new ArrayList<String>();
	     handler.execute();
	     Log.e("Employee", " <><><><><:::进入listview  " );
		return view;
	}
	 //这是一个异步线程类，用于在后台进行网络操作，连接到云端平台
    private class UIAsyncTask extends AsyncTask<Void, Void,  List<NurselookData>> {
        @Override
        protected  List<NurselookData> doInBackground(Void... params) {
            //查询全部员工
            String url6 = "http://192.168.43.80:8080/NeueduBuyer/nurse/findall.do";
            HttpResponse response = HttpUtils.httpGet(url6);
            String departJson = response.getResponseBody();
            Log.e("Nurse", " <><><><><:::  " + departJson);
            Log.e("Nurse", "============================");
            Gson gson = new GsonBuilder().create();
            if(departJson!=null)
            {
                List<NurselookData> nurselookdata =gson.fromJson(departJson, new TypeToken<List<NurselookData>>() {}.getType());

                Log.e("Nurse----size",   " ++ "+ nurselookdata.size());
                return nurselookdata;
            }

            return null;
        }

        @Override
        protected void onPostExecute( List<NurselookData> result) {
            //在这里显示绑定数据
            Log.e("Nurse", " <><><><><::: mmmmmmmmmmmmm " );

            if(result!=null){
                //for(NurselookData data: result){
                    for (int i=0;i<result.size();i++)
                    {
                        NurselookData nurselookData =new NurselookData(
                                result.get(i).getNurseId(),
                                result.get(i).getNurseName(),
                                result.get(i).getMajor(),
                                result.get(i).getCreateTime(),
                                result.get(i).getIntroduce(),
                                imgeIDs[i],
                                result.get(i).getIsfree(),
                                result.get(i).getSex(),
                                result.get(i).getAddress()
                        );
                        list.add(nurselookData);
                     
                    }


              //  }
                showNurseAdapter=new ShowNurseAdapter(getActivity(),R.layout.activity_listviewitem,list);
                nurse_list_result.setAdapter(showNurseAdapter);
                nurse_list_result.setOnItemClickListener(new OnItemClickListener() {  
                    @Override  
                    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {  
                        Intent intent = new Intent();  
                        intent.putExtra("listid", arg2);
                        intent.putExtra("list",(Serializable)list);  
                        intent.setClass(getActivity(), SubmitOrder.class);   
                        startActivity(intent);  
                    }  
                });  
            }

        }
    }
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
	
	}
}
