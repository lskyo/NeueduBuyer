package com.i8080soft.tabhost.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.i8080soft.tabhost.R;
import com.i8080soft.tabhost.login;
import com.i8080soft.tabhost.myAccountset;
import com.i8080soft.tabhost.personalset;


public class settingFragment extends Fragment {
	private Button exit;

	private View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		view = inflater.inflate(R.layout.activity_set, container, false);
		TextView myAccount = (TextView) view.findViewById(R.id.myAccount);
		exit=(Button)view.findViewById(R.id.layout_exit);
		myAccount.setClickable(true);
		myAccount.setOnClickListener(new OnClickListener() {
			// 为个人设置设置监听事件，跳转到完善个人信息界面
			@Override
			public void onClick(View v) {
				Intent myAccountIntent = new Intent(getActivity(),
						myAccountset.class);
				startActivity(myAccountIntent);
			}
		});
		
		TextView personalSetting = (TextView) view
				.findViewById(R.id.personalsetting);
		personalSetting.setClickable(true);
		personalSetting.setOnClickListener(new OnClickListener() {
			// 为个人设置设置监听事件，跳转到完善个人信息界面
			@Override
			public void onClick(View v) {
				Intent personalsetIntent = new Intent(getActivity(),
						personalset.class);
				startActivity(personalsetIntent);
			}
		});
		
		//view = inflater.inflate(R.layout.activity_set, container, false);
	
		exit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity(), "正在退出登录。。", Toast.LENGTH_SHORT).show();
				SharedPreferences preferences = getActivity().getApplicationContext().getSharedPreferences("Registerdata", Context.MODE_PRIVATE);  
			    SharedPreferences.Editor editor = preferences.edit();  
			    //editor.putBoolean("isback", true);
			    editor.clear();
			    editor.commit();  
			}
		});
		return view;
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
			
		/*((TextView) getActivity().findViewById(R.id.appTitle))
				.setText(R.string.tab_more);*/
	}

}
