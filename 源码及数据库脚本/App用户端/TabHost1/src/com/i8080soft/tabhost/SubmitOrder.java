package com.i8080soft.tabhost;

import java.util.List;

import com.i8080soft.tabhost.data.NurselookData;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SubmitOrder extends Activity {
	private TextView tvname;
	private TextView tvmajor;
	private TextView tvsex;
	private TextView tvAssess;
	private TextView tvcharacter;
	private TextView tvnameId;
	private TextView tvage;
	private TextView tvspace;
	private TextView tvtime;
	private TextView tvintroduce;
	private TextView tvaddress;
	private TextView tvwage;
	private String money;
	private String nurseid;
	private Button submitOrder;
	private ImageView image;
	private Integer[] imgeIDs = {R.drawable.nur1,
            R.drawable.nur2, R.drawable.nur3,
            R.drawable.nur4, R.drawable.nurse1,
            R.drawable.nurse2,R.drawable.nurse3,
            R.drawable.nurse4,R.drawable.nurse5,R.drawable.nurse6};
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.submit_order);

		// 提交按钮响应事件
		submitOrder = (Button) findViewById(R.id.submitOrder);

		tvname=(TextView)findViewById(R.id.name);
	    tvnameId=(TextView)findViewById(R.id.nameId);
	    tvsex=(TextView)findViewById(R.id.sex);
	    tvage=(TextView)findViewById(R.id.age);
	    tvtime=(TextView)findViewById(R.id.time);
	    tvspace=(TextView)findViewById(R.id.space);
	    tvmajor=(TextView)findViewById(R.id.major);
	    tvaddress=(TextView)findViewById(R.id.address);
	    tvintroduce=(TextView)findViewById(R.id.introduce);
	    tvAssess=(TextView)findViewById(R.id.useAssess);
	    tvcharacter=(TextView)findViewById(R.id.character);
	    tvwage=(TextView)findViewById(R.id.wage);
		initevent();

	}

	public void initevent() {
		Intent intentGet = getIntent();
		List<NurselookData> lstBean = (List<NurselookData>) intentGet.getSerializableExtra("list");
		for (int i = 0; i < lstBean.size(); i++) {
			nurseid=String.valueOf(lstBean.get(intentGet.getIntExtra("listid", 0)).getNurseId());
			money=String.valueOf(lstBean.get(intentGet.getIntExtra("listid", 0)).getWage());
			Toast.makeText(SubmitOrder.this, intentGet.getIntExtra("listid", 0)+"", Toast.LENGTH_SHORT).show();
	    	tvname.setText(lstBean.get(intentGet.getIntExtra("listid", 0)).getNurseName());
	    	tvnameId.setText(String.valueOf(lstBean.get(intentGet.getIntExtra("listid", 0)).getNurseId()));
	 		tvsex.setText(lstBean.get(intentGet.getIntExtra("listid", 0)).getSex()+"");
	 		tvage.setText(String.valueOf(lstBean.get(intentGet.getIntExtra("listid", 0)).getAge()));
	 		tvtime.setText(lstBean.get(intentGet.getIntExtra("listid", 0)).getCreateTime());
	 	    tvspace.setText(String.valueOf(lstBean.get(intentGet.getIntExtra("listid", 0)).getIsfree()));
	 		tvmajor.setText(lstBean.get(intentGet.getIntExtra("listid", 0)).getMajor());
	 	    tvaddress.setText(String.valueOf(lstBean.get(intentGet.getIntExtra("listid", 0)).getAddress()));
	 	    tvintroduce.setText(String.valueOf(lstBean.get(intentGet.getIntExtra("listid", 0)).getIntroduce()));
	 	    tvwage.setText(String.valueOf(lstBean.get(intentGet.getIntExtra("listid", 0)).getWage()));
	 	   }

		submitOrder.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent submitIntent = new Intent(SubmitOrder.this, OrderSure.class);
				Bundle nextbundle = new Bundle();// 创建并实例化一个bundle对象
				nextbundle.putCharSequence("nurseid", nurseid);// 保存护士id
				nextbundle.putCharSequence("money", money);// 保存护士id
				submitIntent.putExtras(nextbundle);// 将bundle对象添加到intent对象中
				startActivity(submitIntent);
				finish();
			}
		});
		// 返回按钮响应事件
		ImageView goback = (ImageView) findViewById(R.id.goback);
		goback.setEnabled(true);
		goback.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				finish();
			}
		});
	}
}
