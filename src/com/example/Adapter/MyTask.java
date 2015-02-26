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
 * ҵ����:
 * ����˵��: 
 * ��д����:	2015-1-8
 * ����:	 ������
 * 
 * ��ʷ��¼
 * 1���޸����ڣ�
 *    �޸��ˣ�
 *    �޸����ݣ�
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
