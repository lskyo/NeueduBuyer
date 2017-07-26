package com.i8080soft.tabhost.adapter;

import java.util.List;

import com.i8080soft.tabhost.R;
import com.i8080soft.tabhost.data.NurselookData;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowNurseAdapter extends ArrayAdapter<NurselookData>{
	  private int outresourceId;
	    public ShowNurseAdapter(Context context, int resource, List<NurselookData> objects) {
	        super(context, resource,objects);
	        outresourceId=resource;
	    }
	    
	    @Override
	    public View getView(int position, View convertView, ViewGroup parent) {
	        NurselookData nurselookdata = getItem(position);
	        View view;
	        ShowNurseAdapter.ViewHolder viewHolder;
	        if (convertView == null) {
	            view = LayoutInflater.from(getContext()).inflate(outresourceId, null);
	            viewHolder = new ShowNurseAdapter.ViewHolder();
	            viewHolder.nursename = (TextView) view.findViewById(R.id.nurse_name);
	            viewHolder.nurseid = (TextView) view.findViewById(R.id.nurse_id);
	            viewHolder.nursemajor = (TextView) view.findViewById(R.id.nurse_major);
	            viewHolder.nurseinstruce = (TextView) view.findViewById(R.id.nurse_instruce);
	            viewHolder.nursecreate = (TextView) view.findViewById(R.id.nurse_create);
	            viewHolder.nursepic=(ImageView)view.findViewById(R.id.nursepic);
	            viewHolder.nurseisfress = (TextView) view.findViewById(R.id.nurse_isfress);
	            viewHolder.nursesex = (TextView) view.findViewById(R.id.nurse_sex);
	            viewHolder.nurseaddress = (TextView) view.findViewById(R.id.nurse_adress);
	            view.setTag(viewHolder);
	        } else {
	            view = convertView;
	            viewHolder = (ShowNurseAdapter.ViewHolder) view.getTag();
	        }
	        viewHolder.nursesex.setText(String.valueOf(nurselookdata.getSex()));
	        viewHolder.nursename.setText(String.valueOf(nurselookdata.getNurseName()));
	        viewHolder.nurseaddress.setText(String.valueOf(nurselookdata.getAddress()));
	        viewHolder.nurseid.setText(nurselookdata.getNurseId());
	        viewHolder.nursemajor.setText(nurselookdata.getMajor());
	        viewHolder.nurseinstruce.setText(nurselookdata.getIntroduce());
	        viewHolder.nursecreate.setText(nurselookdata.getCreateTime());
	        viewHolder.nurseisfress.setText(nurselookdata.getIsfree()+" ");
	        viewHolder.nursepic.setBackgroundResource(nurselookdata.getPic());
	        return view;
	    }

	    class ViewHolder {

	        TextView nursename;
	        TextView nurseisfress;
	        TextView nurseid;
	        TextView nursemajor;
	        TextView nurseinstruce;
	        TextView nursecreate;
	        TextView nursesex;
	        TextView nurseaddress;
	        ImageView nursepic;
	    }	    
	    
}
