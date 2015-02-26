/*******************************************************************************
 * Copyright (c) 2015 by tennis Corporation all right reserved.
 * 2015-1-6 
 * 
 *******************************************************************************/ 
package com.example.Fragment;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
/**
 * <pre>
 * ҵ����:
 * ����˵��: 
 * ��д����:	2015-1-6
 * ����:	 ������
 * 
 * ��ʷ��¼
 * 1���޸����ڣ�
 *    �޸��ˣ�
 *    �޸����ݣ�
 * </pre>
 */
public class FragmentAdapter extends FragmentStatePagerAdapter {

	List<Fragment> list;
	
	public FragmentAdapter(FragmentManager fm, List<Fragment> list) {
		super(fm);
		this.list = list;
	}

	@Override
	public Fragment getItem(int arg0) {
		return list.get(arg0);
	}

	@Override
	public int getCount() {
		return list.size();
	}
}
