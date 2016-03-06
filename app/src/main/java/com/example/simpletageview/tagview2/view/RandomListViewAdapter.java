package com.example.simpletageview.tagview2.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;


import com.example.simpletageview.R;

import java.util.List;

public class RandomListViewAdapter extends CustomAdapter {

	private List<TagBean> mData;
	private Context mContext;
	private LayoutInflater mInflater;

	public RandomListViewAdapter(List<TagBean> mData, Context mContext) {
		this.mData = mData;
		this.mContext = mContext;
		mInflater = LayoutInflater.from(mContext);
	}

	@Override
	public int getCount() {
		return mData.size();
	}

	@Override
	public Object getItem(int position) {
		return mData.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if(null==convertView){
			convertView = mInflater.inflate(R.layout.item_comment_tag,null);
			holder = new ViewHolder(convertView);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		TagBean bean = mData.get(position);
		holder.cb_tag_name.setText(" "+bean.getTagName()+" ");
		holder.cb_tag_name.setChecked(bean.isCheck());
		holder.cb_tag_name.setTag(position);
		return convertView;
	}

	class ViewHolder{
		CheckBox cb_tag_name;
		public ViewHolder(View v){
			cb_tag_name = (CheckBox)v.findViewById(R.id.cb_tag_name);
			cb_tag_name.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					int pos = (int)v.getTag();
					mData.get(pos).setCheck(!mData.get(pos).isCheck());
				}
			});
		}
	}

}
