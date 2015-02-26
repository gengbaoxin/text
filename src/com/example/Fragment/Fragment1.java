/*******************************************************************************
 * Copyright (c) 2015 by dennis Corporation all right reserved.
 * 2015-1-6 
 * 
 *******************************************************************************/ 
package com.example.Fragment;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.Adapter.MyAdapter;
import com.example.Bean.User;
import com.example.Json.MyJson;
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
public class Fragment1 extends Fragment {
	ListView lv;
	MyAdapter adapter;
	List<User> list;
	MyJson json;
	String Url="http://169.254.156.76:8080/json/bawei.json";
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment,null);
		lv = (ListView) v.findViewById(R.id.list);
		json = new MyJson();
		list = json.getList(Url);
		adapter = new MyAdapter(getActivity(),list);
		lv.setAdapter(adapter);
		return v;
	}
}
