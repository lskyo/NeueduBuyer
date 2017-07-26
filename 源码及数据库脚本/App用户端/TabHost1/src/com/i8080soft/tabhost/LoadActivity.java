/**
 * 
 */
package com.i8080soft.tabhost;

import com.i8080soft.tabhost.demo2.TabMainActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * @author Administrator
 *
 */
public class LoadActivity extends Activity {
	private int current = 0;
	private int[] pics = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.load_activity);
		pics = new int[] { R.drawable.ic_load_1, R.drawable.ic_load_2,
				R.drawable.ic_load_3, R.drawable.ic_load_4 };
		current = 0;
		((ImageView) findViewById(R.id.imageView1))
				.setImageDrawable(getResources().getDrawable(pics[current]));
	}

	public void next(View view) {
		current++;
		if (current < pics.length - 1) {//
			((ImageView) findViewById(R.id.imageView1))
					.setImageDrawable(getResources().getDrawable(pics[current]));
		} else if (current < pics.length) {
			((ImageView) findViewById(R.id.imageView1))
					.setImageDrawable(getResources().getDrawable(pics[current]));
			((Button) view).setText("进入...");
		}
		else {
			/*Intent intent = new Intent(getBaseContext(), ChooseActivity.class);
			startActivity(intent);*/
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);
			// 修改使用状态
			getSharedPreferences("TAB_HOST", MODE_PRIVATE).edit()
					.putBoolean("IS_FIRST", false).commit();

			finish();
		}

	}

}
