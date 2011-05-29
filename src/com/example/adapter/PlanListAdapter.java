package com.example.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.data.Plan;
import com.example.roomsearch.R;

public class PlanListAdapter extends ArrayAdapter<Plan>
{
	private Context mContext;
	private LayoutInflater mInflater;

	public PlanListAdapter(Context context, List<Plan> objects)
	{
		this(context, 0, objects);
	}

	public PlanListAdapter(Context context, int textViewResourceId, List<Plan> objects)
	{
		super(context, textViewResourceId, objects);

		mContext = context;
		mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		ViewHolder holder;

		if(convertView == null)
		{
			convertView = mInflater.inflate(R.layout.main_list, null);

			holder = new ViewHolder();
			holder.txtPlan = (TextView)convertView.findViewById(R.id.txtPlan);
			holder.txtRoom = (TextView)convertView.findViewById(R.id.txtRoom);
			holder.txtSampleRate = (TextView)convertView.findViewById(R.id.txtSampleRate);
			holder.txtHotelName = (TextView)convertView.findViewById(R.id.txtHotelName);
			holder.txtAddress = (TextView)convertView.findViewById(R.id.txtAddress);

			convertView.setTag(holder);
		}
		else
		{
			holder = (ViewHolder)convertView.getTag();
		}

		Plan plan = this.getItem(position);
		if(plan != null)
		{
			holder.txtPlan.setText(plan.getPlanName());
			holder.txtRoom.setText(plan.getRoomName());
			holder.txtSampleRate.setText(String.valueOf(plan.getSampleRate()) + mContext.getString(R.string.rate_unit));
			holder.txtHotelName.setText(plan.getHotel().getHotelName());
			holder.txtAddress.setText(plan.getHotel().getHotelAddress());
		}
		return convertView;
	}

	class ViewHolder
	{
		public TextView txtPlan;
		public TextView txtRoom;
		public TextView txtSampleRate;
		public TextView txtHotelName;
		public TextView txtAddress;
	}
}
