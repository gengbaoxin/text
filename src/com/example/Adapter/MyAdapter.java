/*******************************************************************************
 * Copyright (c) 2015 by dennis Corporation all right reserved.
 * 2015-1-6 
 * 
 *******************************************************************************/ 
package com.example.Adapter;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.Bean.User;
import com.example.activity.R;

/**
 * <pre>
 * 业务名:
 * 功能说明: 
 * 编写日期:	2015-1-6
 * 作者:	 耿瑞泽
 * 
 * 历史记录
 * 1、修改日期：
 *    修改人：
 *    修改内容：
 * </pre>
 */
public class MyAdapter extends BaseAdapter {
	List<User> list;
	Context context;
	public MyAdapter(Context context,List<User> list) {
		super();
		this.context = context;
		this.list = list;
	}
	@Override
	public int getCount() {
		if(list!=null){
		return list.size();
		}
		return 0;
	}
	@Override
	public Object getItem(int position) {
		return null;
	}
	@Override
	public long getItemId(int position) {
		return 0;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHelp vh;
		if(convertView==null){
			vh = new ViewHelp();
			convertView = LayoutInflater.from(context).inflate(R.layout.item,null);
			vh.view = (ImageView) convertView.findViewById(R.id.iv);
			vh.name = (TextView) convertView.findViewById(R.id.name);
			vh.address = (TextView) convertView.findViewById(R.id.address);
			convertView.setTag(vh);
		}else{
			vh = (ViewHelp) convertView.getTag();
		}
		User u = list.get(position);
		vh.name.setText(u.getName());
		vh.address.setText(u.getAddress());
		String url = "http://169.254.156.76:8080/"+u.getLogo();
		System.out.println(url);
		new MyTask( new ongetimagelistener(){
			@Override
			public void geton(Bitmap bitmap) {
				super.geton(bitmap);
				if(bitmap!=null)
				{
					vh.view.setImageBitmap(bitmap);
				}
			}
		}).execute(url);
		return convertView;
	}
class ViewHelp{
	ImageView view;
	TextView name,address;
}
}