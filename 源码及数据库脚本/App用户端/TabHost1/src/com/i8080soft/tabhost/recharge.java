package com.i8080soft.tabhost;

import com.i8080soft.tabhost.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class recharge extends Activity {
	Button enter;
	//EditText numEdit;
	int num;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recharge);
		enter = (Button) findViewById(R.id.enter);
		enter.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				num=Integer.parseInt(((EditText)findViewById(R.id.numEdit)).getText().toString());
				Intent myaccountintent = new Intent(recharge.this, myAccountset.class);
				Bundle bundle = new Bundle(); // 创建并实例化一个bundle对象
				bundle.putInt("rmb", num);
				
				Log.e("my",num+" ");
				myaccountintent.putExtras(bundle);// 将bundle对象添加到intent对象中
				setResult(2, myaccountintent);
				finish();
			}
		});
	}

}
