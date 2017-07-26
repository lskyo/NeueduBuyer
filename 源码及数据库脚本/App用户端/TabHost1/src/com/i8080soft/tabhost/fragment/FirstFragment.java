package com.i8080soft.tabhost.fragment;

/**
 * 首页
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.i8080soft.tabhost.Example1;
import com.i8080soft.tabhost.Example2;
import com.i8080soft.tabhost.Preference1;
import com.i8080soft.tabhost.Preference2;
import com.i8080soft.tabhost.Preference3;
import com.i8080soft.tabhost.Preference4;
import com.i8080soft.tabhost.R;

import com.i8080soft.tabhost.login;

public class FirstFragment extends Fragment {
	private View view;
	
	
	private ListView listView = null;
	private String[] data = null;

	private ViewPager mViewPaper;
	private List<ImageView> images;
	private List<View> dots;
	private int currentItem;
	// 记录上一次点的位置
	private int oldPosition = 0;
	// 存放图片的id
	private int[] imageIds = new int[] { R.drawable.firstpage0,
			R.drawable.firstpage1, R.drawable.firstpage2,
			R.drawable.firstpage3, R.drawable.firstpage4 };
	// 存放图片的标题
	private String[] titles = new String[] { "我们的付出，换你一份心安", "愿时光许你，佑你岁月无忧",
			"自己的世界不大不小，温暖自己却刚刚好", "越过春秋冬夏，赴一日之约", "生活是一场又一场美好事物的追逐" };
	private TextView title;
	private ViewPagerAdapter adapter;
	private ScheduledExecutorService scheduledExecutorService;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.activity_firstpage, container, false);

		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		ImageView loginphoto = (ImageView) getActivity().findViewById(
				R.id.loginphoto);
		loginphoto.setClickable(true);

		// setContentView(R.layout.viewpage);
		mViewPaper = (ViewPager) getActivity().findViewById(R.id.vp);

		// 显示的图片
		images = new ArrayList<ImageView>();
		for (int i = 0; i < imageIds.length; i++) {
			ImageView imageView = new ImageView(getActivity());
			imageView.setBackgroundResource(imageIds[i]);
			images.add(imageView);
		}
		// 显示的小点
		dots = new ArrayList<View>();
		dots.add(getActivity().findViewById(R.id.dot_0));
		dots.add(getActivity().findViewById(R.id.dot_1));
		dots.add(getActivity().findViewById(R.id.dot_2));
		dots.add(getActivity().findViewById(R.id.dot_3));
		dots.add(getActivity().findViewById(R.id.dot_4));

		title = (TextView) getActivity().findViewById(R.id.title);
		title.setText(titles[0]);

		adapter = new ViewPagerAdapter();
		mViewPaper.setAdapter(adapter);

		loginphoto.setOnClickListener(new OnClickListener() {
			// 为标题栏的头像设置监听事件，跳转到登录界面
			@Override
			public void onClick(View v) {
				Intent loginIntent = new Intent(getActivity(), login.class);
				startActivity(loginIntent);
			}
		});
		mViewPaper
				.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

					@Override
					public void onPageSelected(int position) {
						title.setText(titles[position]);
						dots.get(position).setBackgroundResource(
								R.drawable.background);
						dots.get(oldPosition).setBackgroundResource(
								R.drawable.backgroung2);

						oldPosition = position;
						currentItem = position;
					}

					@Override
					public void onPageScrolled(int arg0, float arg1, int arg2) {

					}

					@Override
					public void onPageScrollStateChanged(int arg0) {

					}
				});
		//案例一点击响应事件
		TextView example1TextView = (TextView) view
				.findViewById(R.id.exampleName1);
		example1TextView.setEnabled(true);
		example1TextView.setClickable(true);
		example1TextView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent example1Intent = new Intent(getActivity(),
						Example1.class);
				startActivity(example1Intent);
			}
		});
		//案例二点击响应事件
		TextView example2TextView = (TextView) view
				.findViewById(R.id.exampleName2);
		example2TextView.setEnabled(true);
		example2TextView.setClickable(true);
		example2TextView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent example2Intent = new Intent(getActivity(),
						Example2.class);
				startActivity(example2Intent);
			}
		});
		//优惠相片的响应事件
		ImageView preferencePhoto1=(ImageView)view.findViewById(R.id.preferencephoto1);
		preferencePhoto1.setEnabled(true);
		preferencePhoto1.setClickable(true);
		preferencePhoto1.setOnClickListener(new OnClickListener() {
	    
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent preferencePhoto1Intent = new Intent(getActivity(),
						Preference1.class);
				startActivity(preferencePhoto1Intent);
				
			}
		});
		ImageView preferencePhoto2=(ImageView)view.findViewById(R.id.preferencephoto2);
		preferencePhoto2.setEnabled(true);
		preferencePhoto2.setClickable(true);
		preferencePhoto2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent preferencePhoto2Intent = new Intent(getActivity(),
						Preference2.class);
				startActivity(preferencePhoto2Intent);
			}
		});
		ImageView preferencePhoto3=(ImageView)view.findViewById(R.id.preferencephoto3);
		preferencePhoto3.setEnabled(true);
		preferencePhoto3.setClickable(true);
		preferencePhoto3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent preferencePhoto3Intent = new Intent(getActivity(),
						Preference3.class);
				startActivity(preferencePhoto3Intent);
			}
		});
		ImageView preferencePhoto4=(ImageView)view.findViewById(R.id.preferencephoto4);
		preferencePhoto4.setEnabled(true);
		preferencePhoto4.setClickable(true);
		preferencePhoto4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent preferencePhoto4Intent = new Intent(getActivity(),
						Preference4.class);
				startActivity(preferencePhoto4Intent);
			}
		});
		
		
		
	}

	/**
	 * 自定义Adapter
	 * 
	 * @author
	 * 
	 */
	private class ViewPagerAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return images.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(ViewGroup view, int position, Object object) {
			// TODO Auto-generated method stub
			// super.destroyItem(container, position, object);
			// view.removeView(view.getChildAt(position));
			// view.removeViewAt(position);
			view.removeView(images.get(position));
		}

		@Override
		public Object instantiateItem(ViewGroup view, int position) {
			// TODO Auto-generated method stub
			view.addView(images.get(position));
			return images.get(position);
		}

	}

	/*
	 * @Override public boolean onCreateOptionsMenu(Menu menu) { // Inflate the
	 * menu; this adds items to the action bar if it is present.
	 * getMenuInflater().inflate(R.menu.main, menu); return true; }
	 */

	/**
	 * 利用线程池定时执行动画轮播
	 */
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		scheduledExecutorService.scheduleWithFixedDelay(new ViewPageTask(), 2,
				2, TimeUnit.SECONDS);
	}

	/**
	 * 图片轮播任务
	 * 
	 * @author
	 * 
	 */
	private class ViewPageTask implements Runnable {

		@Override
		public void run() {
			currentItem = (currentItem + 1) % imageIds.length;
			mHandler.sendEmptyMessage(0);
		}
	}

	/**
	 * 接收子线程传递过来的数据
	 */
	private Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			mViewPaper.setCurrentItem(currentItem);
		};
	};

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		if (scheduledExecutorService != null) {
			scheduledExecutorService.shutdown();
			scheduledExecutorService = null;
		}
	}

}
