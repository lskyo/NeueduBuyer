package com.i8080soft.tabhost;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class myAccountset extends Activity {
	Button recharge;
	int balance;
	TextView balanceNum;
	String text;
	int line;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_myaccount);
		recharge = (Button) findViewById(R.id.recharge);
		recharge.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				balanceNum = (TextView) findViewById(R.id.balanceNum);
				Layout layout = balanceNum.getLayout(); // layout.draw(canvas);
				line = balanceNum.getLayout().getLineCount();
				text = layout.getText().toString();

				balance = Integer.parseInt(text);
				Intent rechargeintent = new Intent(myAccountset.this, recharge.class);
				startActivityForResult(rechargeintent, 2);

			}
		});

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 2 && resultCode == 2) {
			Bundle bundle = data.getExtras();
			balance = balance + bundle.getInt("rmb");
			text = String.valueOf(balance);
			Log.e("myaccount", text);
			balanceNum.setText(text);

		}

	}

}
