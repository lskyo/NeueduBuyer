package com.i8080soft.tabhost;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

/**
 * 
 * @author chensw
 * 
 *         启动页面，每次打开程序时进入该页面，再延时进入其它页面
 *
 */
public class StartActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_activity);

		new UIAsyncTask().execute(null, null);
	}

	// 使用异步线程控制页面跳转
	private class UIAsyncTask extends AsyncTask<Void, Void, Boolean> {

		@Override
		protected Boolean doInBackground(Void... params) {

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				return false;
			}

			return true;

		}

		@Override
		protected void onPostExecute(Boolean result) {

			Intent intent = null;

			// 读取使用状态
			boolean isFirst = getSharedPreferences("TAB_HOST", MODE_PRIVATE)
					.getBoolean("IS_FIRST", true);

			if (isFirst) {
				// 首次登录进入引导页面
				intent = new Intent(getBaseContext(), LoadActivity.class);
			} else {
				// 再次登录进入主页面
				intent = new Intent(getBaseContext(), MainActivity.class);
			}

			startActivity(intent);

			// 销毁当前页面，避免后退到启动页面
			finish();
		}
	}
}
