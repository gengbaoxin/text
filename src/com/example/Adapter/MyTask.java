/*******************************************************************************
 * Copyright (c) 2015 by dennis Corporation all right reserved.
 * 2015-1-8 
 * 
 *******************************************************************************/ 
package com.example.Adapter;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

/**
 * <pre>
 * 业务名:
 * 功能说明: 
 * 编写日期:	2015-1-8
 * 作者:	 耿瑞泽
 * 
 * 历史记录
 * 1、修改日期：
 *    修改人：
 *    修改内容：
 * </pre>
 */
public class MyTask extends AsyncTask<String, Void, Bitmap>{

	ongetimagelistener ongetimagelistener;
	public MyTask(ongetimagelistener ongetimagelistener) {
		super();
		this.ongetimagelistener = ongetimagelistener;
	}

	@Override
	protected Bitmap doInBackground(String... params) {
		String url = params[0];
		URL uri;
		Bitmap bitmap = null;
		try {
			uri = new URL(url);
			HttpURLConnection connection =  (HttpURLConnection) uri.openConnection();
			InputStream stream = connection.getInputStream();
			bitmap = BitmapFactory.decodeStream(stream);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bitmap;
	}
	
	/* (non-Javadoc)
	 * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
	 */
	@Override
	protected void onPostExecute(Bitmap result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		ongetimagelistener.geton(result);
	}

}
