package com.i8080soft.tabhost;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.i8080soft.tabhost.fragment.CardsFragment;
import com.i8080soft.tabhost.fragment.FirstFragment;
import com.i8080soft.tabhost.fragment.SearchOrderFragment;
import com.i8080soft.tabhost.fragment.settingFragment;

public class MainActivity extends FragmentActivity {
	// tab选项卡标识
	private static final String TAB_MY = "tab_my";
	private static final String TAB_CARDS = "tab_cards";
	private static final String TAB_SEARCH = "tab_search";
	private static final String TAB_MORE = "tab_more";

	private TabHost mTabHost;
	private Fragment fragment = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);


		mTabHost = (TabHost) findViewById(R.id.tabhost);
		mTabHost.setup();

		/** Setting tabchangelistener for the tab */
		mTabHost.setOnTabChangedListener(tabChangeListener);

		/** Defining tab builder for 我自己 tab */
		TabHost.TabSpec tSpecCard = mTabHost.newTabSpec(TAB_MY);
		//添加一个tab
		View cardTab = (View) LayoutInflater.from(this).inflate(
				R.layout.tabmini, null);
		((TextView) cardTab.findViewById(R.id.tab_label))
				.setText(R.string.tab_me);

		((ImageView) cardTab.findViewById(R.id.tab_image))
				.setImageDrawable(getResources().getDrawable(
						R.drawable.guide_home_nm));

		tSpecCard.setIndicator(cardTab);
		tSpecCard.setContent(new DummyTabContent(getBaseContext()));
		mTabHost.addTab(tSpecCard);

		/** 名片夹tab */
		TabHost.TabSpec tSpecContact = mTabHost.newTabSpec(TAB_CARDS);
		View contactTab = (View) LayoutInflater.from(this).inflate(
				R.layout.tabmini, null);
		((TextView) contactTab.findViewById(R.id.tab_label))
				.setText(R.string.tab_cards);
		((ImageView) contactTab.findViewById(R.id.tab_image))
				.setImageDrawable(getResources().getDrawable(
						R.drawable.guide_cart_nm));

		tSpecContact.setIndicator(contactTab);
		tSpecContact.setContent(new DummyTabContent(getBaseContext()));
		mTabHost.addTab(tSpecContact);

		/** 发现tab */
		TabHost.TabSpec tSpecCallog = mTabHost.newTabSpec(TAB_SEARCH);
		View callogTab = (View) LayoutInflater.from(this).inflate(
				R.layout.tabmini, null);
		((TextView) callogTab.findViewById(R.id.tab_label))
				.setText(R.string.tab_search);
		((ImageView) callogTab.findViewById(R.id.tab_image))
				.setImageDrawable(getResources().getDrawable(
						R.drawable.guide_discover_nm));

		tSpecCallog.setIndicator(callogTab);
		tSpecCallog.setContent(new DummyTabContent(getBaseContext()));
		mTabHost.addTab(tSpecCallog);

		/** 更多tab */
		TabHost.TabSpec tSpecMore = mTabHost.newTabSpec(TAB_MORE);
		View moreTab = (View) LayoutInflater.from(this).inflate(
				R.layout.tabmini, null);
		((TextView) moreTab.findViewById(R.id.tab_label))
				.setText(R.string.tab_more);
		((ImageView) moreTab.findViewById(R.id.tab_image))
				.setImageDrawable(getResources().getDrawable(
						R.drawable.guide_account_nm));

		tSpecMore.setIndicator(moreTab);
		tSpecMore.setContent(new DummyTabContent(getBaseContext()));
		mTabHost.addTab(tSpecMore);

	}

	/**
	 * Defining Tab Change Listener event. This is invoked when tab is changed
	 */
	TabHost.OnTabChangeListener tabChangeListener = new TabHost.OnTabChangeListener() {

		@Override
		public void onTabChanged(String tabId) {

			Log.i("MainActivity  ", tabId);

			android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
			android.support.v4.app.FragmentTransaction ft = fm
					.beginTransaction();
			// 如果需要每次更新选项卡，使用下面方法1
			if (fragment == null) {
				fragment = new FirstFragment();
				ft.add(R.id.realtabcontent, fragment);
			} else {
				//使用动画切换页面
				//Animation animation = AnimationUtils.loadAnimation(
				//		getApplicationContext(), R.anim.out);
				//fragment.getView().setAnimation(animation);
				ft.remove(fragment);
				if (tabId.equals(TAB_MY)) {
					fragment = new FirstFragment();
				} else if (tabId.equals(TAB_CARDS)) {
					fragment = new CardsFragment();
				} else if (tabId.equals(TAB_SEARCH)) {
					fragment = new SearchOrderFragment();
				} else if (tabId.equals(TAB_MORE)) {
					fragment = new settingFragment();
				}
				ft.add(R.id.realtabcontent, fragment);
			}

		

			ft.commit();
		}
	};

}
