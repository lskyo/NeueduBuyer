package com.i8080soft.tabhost.adapter;

import com.i8080soft.tabhost.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class GridViewAdapter extends BaseAdapter {
	private Context context;
	private String[] data;

	public GridViewAdapter(Context context, String[] dataStrings) {
		this.context = context;
		this.data = dataStrings;
		if (this.data == null) {
			this.data = new String[] { "Hello" };
		}
	}

	@Override
	public int getCount() {

		return data.length;
	}

	@Override
	public Object getItem(int position) {

		return null;
	}

	@Override
	public long getItemId(int position) {

		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		convertView = LayoutInflater.from(context).inflate(R.layout.grid_item,
				null);
		((TextView) convertView.findViewById(R.id.textView1))
				.setText(data[position]);

		return convertView;
	}

}
