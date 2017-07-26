package com.i8080soft.tabhost.adapter;

import java.util.List;


import com.i8080soft.tabhost.R;
import com.i8080soft.tabhost.data.OrderData;

import android.R.integer;
import android.content.Context;
import android.provider.ContactsContract.Data;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class OrderSearchAdapter extends ArrayAdapter<OrderData> {
	private int orderResourceId;

	public OrderSearchAdapter(Context context, int resource,
			List<OrderData> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
		orderResourceId = resource;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		OrderData ordersearchdata = getItem(position);
		View view;

		OrderSearchAdapter.ViewHolder viewHolder;
		if (convertView == null) {
			view = LayoutInflater.from(getContext()).inflate(orderResourceId,
					null);
			viewHolder = new OrderSearchAdapter.ViewHolder();
			viewHolder.userAccount = (TextView) view
					.findViewById(R.id.user_account);
			viewHolder.nurseId = (TextView) view.findViewById(R.id.nurseid);
			viewHolder.reservationId = (TextView) view
					.findViewById(R.id.reservation_id);
			viewHolder.beginTime = (TextView) view
					.findViewById(R.id.begin_time);
			viewHolder.endTime = (TextView) view.findViewById(R.id.end_time);
			viewHolder.place = (TextView) view.findViewById(R.id.place);
			viewHolder.money = (TextView) view.findViewById(R.id.money);
			viewHolder.nursephoto = (ImageView) view
					.findViewById(R.id.nursephoto);
			view.setTag(viewHolder);
		} else {
			view = convertView;
			viewHolder = (OrderSearchAdapter.ViewHolder) view.getTag();
		}
		viewHolder.userAccount.setText(String.valueOf(ordersearchdata
				.getUserAccount()));
		viewHolder.nurseId
				.setText(String.valueOf(ordersearchdata.getNurseId()));
		viewHolder.reservationId.setText(String.valueOf(ordersearchdata
				.getReservationId()));
		viewHolder.beginTime.setText(ordersearchdata.getBeginTime());
		viewHolder.endTime.setText(ordersearchdata.getEndTime());
		viewHolder.nursephoto.setBackgroundResource(ordersearchdata
				.getNursephoto());
		viewHolder.money.setText(String.valueOf(ordersearchdata.getMoney()));
		viewHolder.place.setText(ordersearchdata.getPlace());
		return view;
	}

	class ViewHolder {

		TextView userAccount;
		TextView nurseId;
		TextView reservationId;
		TextView beginTime;
		TextView endTime;
		TextView money;
		TextView place;
		ImageView nursephoto;
	}

}
