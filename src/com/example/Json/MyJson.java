/*******************************************************************************
 * Copyright (c) 2015 by dennis Corporation all right reserved.
 * 2015-1-6 
 * 
 *******************************************************************************/ 
package com.example.Json;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.Bean.User;

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
public class MyJson {
	HttpClient client;
	List<User> list;
	public List<User> getList(String Url){
		list = new ArrayList<User>();
		client = new DefaultHttpClient();
		HttpPost post = new HttpPost(Url);
		try {
		HttpResponse response = client.execute(post);
		if(response.getStatusLine().getStatusCode()==200){
			InputStream stream = response.getEntity().getContent();
			byte[] b = new byte[4*1024];
			int length;
			StringBuffer buffer = new StringBuffer();
			while((length = stream.read(b))!=-1){
				buffer.append(new String(b,0,length));
			}
			System.out.println(buffer.toString());
			JSONArray array = new JSONArray(buffer.toString());
			for (int i = 0; i < array.length(); i++) {
				JSONObject object = array.getJSONObject(i);
				String name = object.getString("name");
				String address = object.getString("address");
				String logo = object.getString("logo");
				System.out.println("name====="+name);
				System.out.println("addresss===="+address);
				System.out.println("logo======"+logo);
				User u = new User();
				u.setName(name);
				u.setAddress(address);
				u.setLogo(logo);
				list.add(u);
			}
	}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return list;
	}
}