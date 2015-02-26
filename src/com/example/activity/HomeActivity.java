/*******************************************************************************
 * Copyright (c) 2015 by dennis Corporation all right reserved.
 * 2015-1-6 
 * 
 *******************************************************************************/ 
package com.example.activity;

import java.util.List;

import org.apache.http.client.HttpClient;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.Adapter.MyAdapter;
import com.example.Bean.User;
import com.example.Json.MyJson;

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
public class HomeActivity extends Activity {
	
	HttpClient client;
	String path;
	MyJson json;
	MyAdapter adapter;
	ListView lv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment);
		lv = (ListView) findViewById(R.id.list);
		json = new MyJson();
		path = "http://192.172.10.14:8080/json/bawei.json";
		List<User> list = json.getList(path);
		adapter = new MyAdapter(this, list);
		lv.setAdapter(adapter);
	}
}
