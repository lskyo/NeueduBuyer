package com.i8080soft.tabhost;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.i8080soft.tabhost.data.logindata;

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
import android.widget.TextView;
import android.widget.Toast;
import cn.trinea.android.common.entity.HttpResponse;
import cn.trinea.android.common.util.HttpUtils;

public class login extends Activity {
	TextView registerNew;
	ImageView goback;
	Button login_bt;
	EditText usernameEdit;
	EditText passwordEdit;
	String username;
	String password;
	// 实例化一个异步线程
	private UIAsyncTask handler = new UIAsyncTask();
	SharedPreferences preferences;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		preferences = getApplicationContext().getSharedPreferences("logindata", Context.MODE_PRIVATE);
		goback = (ImageView) findViewById(R.id.goback);
		goback.setClickable(true);

		goback.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				finish();// 结束当前activity
			}
		});
		registerNew = (TextView) findViewById(R.id.registerNew);

		registerNew.setClickable(true);
		registerNew.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {// 进入注册界面
				Intent registerIntent = new Intent(login.this, register.class);
				startActivityForResult(registerIntent, 1);
			}
		});

		login_bt = (Button) findViewById(R.id.login_bt);
		login_bt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				username = ((EditText) findViewById(R.id.usernameEdit)).getText().toString();
				password = ((EditText) findViewById(R.id.passwordEdit)).getText().toString();
				SharedPreferences.Editor editor = preferences.edit();
				editor.putBoolean("islogin", true);

				editor.commit();
				// 调用函数
				handler.execute();

			}
		});

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 1 && resultCode == 1) {
			Bundle bundle = data.getExtras();
			usernameEdit = ((EditText) findViewById(R.id.usernameEdit));
			usernameEdit.setText(bundle.getString("registerName"));
			usernameEdit = (EditText) findViewById(R.id.passwordEdit);
			usernameEdit.setText(bundle.getString("enterPsw"));
		}

	}

	public class UIAsyncTask extends AsyncTask<Void, Void, List<logindata>> {
		@Override
		protected List<logindata> doInBackground(Void... params) {
			// 按用户名查询
			String httpUrl1 = "http://192.168.43.80:8080/NeueduBuyer/user/findall.do";
			HttpResponse response = HttpUtils.httpGet(httpUrl1);

			Gson gson = new GsonBuilder().create();
			String departJson = response.getResponseBody();
			if (departJson != null) {
				List<logindata> logindata = gson.fromJson(departJson, new TypeToken<List<logindata>>() {
				}.getType());
				Log.e("Employee----isResult", " ++ " + logindata.get(1).getPassword());
				return logindata;
			}
			return null;
		}

		@Override
		protected void onPostExecute(List<logindata> login) {
			// 在这里显示绑定数据
			if (login != null) {
				for (int i = 0; i < login.size(); i++) {
					if ((login.get(i).getPassword().equals(password))
							&& (login.get(i).getUserName().equals(username))) {

						Log.e("Employee----isResult", " ++ lalalalallal");
						Intent intent = new Intent(login.this, personalset.class);
						startActivity(intent);
						finish();

					} else {
						Toast.makeText(login.this, "账号或密码错误", Toast.LENGTH_SHORT).show();
					}
				}

			}

		}
	}
}
