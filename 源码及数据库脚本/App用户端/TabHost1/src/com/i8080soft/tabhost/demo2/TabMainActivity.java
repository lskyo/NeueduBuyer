package com.i8080soft.tabhost.demo2;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;


import com.i8080soft.tabhost.R;
import com.i8080soft.tabhost.fragment.CardsFragment;
import com.i8080soft.tabhost.fragment.FirstFragment;
import com.i8080soft.tabhost.fragment.SearchOrderFragment;
import com.i8080soft.tabhost.fragment.settingFragment;



/**
 * 
 * @author chensw
 * 
 * 打开页面时，一次性加载4个页面的内容;适用于页面内容更新不太频繁的应用
 *
 */
public class TabMainActivity extends FragmentActivity{
	private FragmentTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_tabs_fragment);
        
        mTabHost = (FragmentTabHost)findViewById(R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        mTabHost.addTab(mTabHost.newTabSpec("simple").setIndicator(getString(R.string.tab_cards)),
               CardsFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("contacts").setIndicator(getString(R.string.tab_more)),
                settingFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("custom").setIndicator("我的名片"),
                FirstFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("throttle").setIndicator(getString(R.string.tab_search)),
                SearchOrderFragment.class, null);
    }

}
