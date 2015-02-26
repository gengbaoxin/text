package com.example.activity;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.Fragment.Fragment1;
import com.example.Fragment.Fragment2;
import com.example.Fragment.Fragment3;
import com.example.Fragment.FragmentAdapter;

public class MainActivity extends FragmentActivity {

	ViewPager pager;
	List<Fragment> list;
	FragmentAdapter adapter;
	LinearLayout ll;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		pager = (ViewPager) findViewById(R.id.page);
		ll = (LinearLayout) findViewById(R.id.layout);
		ll.getChildAt(0).setBackgroundColor(Color.RED);
		setListener();
		list = new ArrayList<Fragment>();
		list.add(new Fragment1());
		list.add(new Fragment2());
		list.add(new Fragment3());
		adapter = new FragmentAdapter(getSupportFragmentManager(),list);
		pager.setAdapter(adapter);
		pager.setOnPageChangeListener(new OnPageChangeListener() {
			int checked;
			@Override
			public void onPageSelected(int arg0) {
				TextView tv = (TextView) ll.getChildAt(checked);
				tv.setBackgroundColor(Color.WHITE);
				TextView vt = (TextView) ll.getChildAt(arg0);
				vt.setBackgroundColor(Color.RED);
				checked=arg0;
			}
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}
			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
	}
	/**
	 * 方法说明：
	 *
	 */
	private void setListener() {
		for (int i = 0; i < ll.getChildCount(); i++) {
			ll.getChildAt(i).setOnClickListener(listener);
		}
	}
	OnClickListener listener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.gong:
				pager.setCurrentItem(0);
				break;
			case R.id.love:
				pager.setCurrentItem(1);
				break;
			case R.id.ti:
				pager.setCurrentItem(2);
				break;
			}
		}
	};
}