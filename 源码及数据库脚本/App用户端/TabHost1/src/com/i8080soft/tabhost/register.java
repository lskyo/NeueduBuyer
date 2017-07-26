package com.i8080soft.tabhost;

import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.i8080soft.tabhost.data.usedata;

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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;
import cn.trinea.android.common.entity.HttpResponse;
import cn.trinea.android.common.util.HttpUtils;

public class register extends Activity {

	Button registerBtn; // 获取注册按钮
	RadioButton agreeBtn;
	ImageView goback;
	  
	static String registerName;
	static String enterPsw;
	static String reEnterPsw;
	static String idCardNum;
	static String phoneNum;

	// 实例化一个异步线程
	private UIAsyncTask handler = new UIAsyncTask();

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);

		registerBtn = (Button) findViewById(R.id.registerBtn); // 获取注册按钮
		agreeBtn = (RadioButton) findViewById(R.id.agreeBtn);
		goback = (ImageView) findViewById(R.id.goback);
		
		goback.setClickable(true);
		goback.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				finish();

			}
		});
		registerBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				registerName = ((EditText) findViewById(R.id.registerNameEdit)).getText().toString(); // 获取注册的姓名
				enterPsw = ((EditText) findViewById(R.id.enterPswdEdit)).getText().toString(); // 获取输入的密码
				reEnterPsw = ((EditText) findViewById(R.id.reEnterPswEdit)).getText().toString();// 获取输入的确认密码
				idCardNum = ((EditText) findViewById(R.id.idCardNumEdit)).getText().toString();// 获取输入的身份证号
				phoneNum = ((EditText) findViewById(R.id.phoneNumEdit)).getText().toString();// 获取输入的电话号码
				if (!"".equals(enterPsw) && !"".equals(reEnterPsw) && !"".equals(phoneNum) && !"".equals(registerName)
						&& !"".equals(idCardNum)) {
					if (!enterPsw.equals(reEnterPsw)) {// 判断两次输入的密码是否一致
						Toast.makeText(register.this, "两次输入的密码不一致，请重新输入！", Toast.LENGTH_LONG).show();
						((EditText) findViewById(R.id.enterPswdEdit)).setText("");// 清空输入密码编辑框
						((EditText) findViewById(R.id.reEnterPswEdit)).setText("");// 清空确认密码编辑框
						((EditText) findViewById(R.id.enterPswdEdit)).requestFocus();// 让密码编辑框获得焦点
						// }
					} else {// 将输入的信息保存到Bundle中，并启动登录Activity进行登录
						Intent intent = new Intent(register.this, login.class);
						Bundle bundle = new Bundle(); // 创建并实例化一个bundle对象
						bundle.putCharSequence("registerName", registerName);// 保存用户名
						bundle.putCharSequence("enterPsw", enterPsw);// 保存密码
						intent.putExtras(bundle);// 将bundle对象添加到intent对象中
						//startActivity(intent);
						setResult(1, intent);
						finish();
						
						// 调用函数
						handler.execute();
					}
				} else {
					Toast.makeText(register.this, "请将注册信息填写完整", Toast.LENGTH_LONG).show();
				}
			}
		});
	}

	// 这是一个异步线程类，用于在后台进行网络操作，连接到云端平台
	public class UIAsyncTask extends AsyncTask<Void, Void, usedata> {
		@Override
		protected usedata doInBackground(Void... params) {
			// 新增用户
			String httpUrl1 = "http://192.168.43.80:8080/NeueduBuyer/user/add.do";
			Map<String, String> parasMap = new HashMap<String, String>();
			parasMap.put("userName", registerName);
			parasMap.put("password", enterPsw);
			parasMap.put("userIdcard", idCardNum);
			parasMap.put("userMobile", phoneNum);
			parasMap.put("userAccount", registerName);
			parasMap.put("userCredit", "0");
			parasMap.put("userBalance", "0");
			SharedPreferences preferences = getApplicationContext()
					.getSharedPreferences("Registerdata", Context.MODE_PRIVATE);  
		    SharedPreferences.Editor editor = preferences.edit();  
		    editor.putString("userName", registerName); 
		    editor.putString("userIdcard", idCardNum);  
		    editor.putString("userMobile", phoneNum); 
		   
		    editor.putBoolean("isall", true);
		   // editor.putString("userAccount", registerName);  
		    editor.commit();  
			HttpUtils.httpPostString(httpUrl1, parasMap);

			HttpResponse response = HttpUtils.httpGet(httpUrl1);

			Gson gson = new GsonBuilder().create();
			String departJson = response.getResponseBody();
			Log.e("Employee", " <><><><><::: mmmmmmmmmmmmm " + departJson);
			Log.e("Employee", "============================");
			if (departJson != null) {
				usedata usedata = gson.fromJson(departJson, new TypeToken<usedata>() {
				}.getType());
				Log.e("Employee----isResult", " ++ " + usedata.getInfo());
				return usedata;
			}
			return null;
		}

		@Override
		protected void onPostExecute(usedata result) {
			// 在这里显示绑定数据
			if (result != null) {
				Log.e("Employee", " <><><><><::: mmmmmmmmmmmmm " + result.toString());
				// tvresult.setText(result.getInfo());
			}
		}
	}
}
