package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.data.BaseAreaData;

public class AreaListAdapter extends ArrayAdapter<BaseAreaData>
{
	private LayoutInflater mInflater;

	public AreaListAdapter(Context context)
	{
		super(context, 0);
		mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		if(convertView == null)
		{
			convertView = mInflater.inflate(android.R.layout.simple_spinner_item, null);
		}

		BaseAreaData data = this.getItem(position);
		if(data != null)
		{
			TextView lblName = (TextView)convertView.findViewById(android.R.id.text1);
			lblName.setText(data.getName());
		}

		return convertView;
	}

	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent)
	{
		if(convertView == null)
		{
			convertView = mInflater.inflate(android.R.layout.simple_spinner_dropdown_item, null);
		}

		BaseAreaData data = this.getItem(position);
		if(data != null)
		{
			TextView lblName = (TextView)convertView.findViewById(android.R.id.text1);
			lblName.setText(data.getName());
		}

		return convertView;
	}
}
