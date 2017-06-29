package com.hy.viewpagerandfragment.adapter;

import java.util.List;

import com.hy.viewpagerandfragment.base.BaseFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by ying on 2016/1/29.
 */
public class FragmentAdapter extends FragmentPagerAdapter {
	private List<BaseFragment> list;

	public FragmentAdapter(FragmentManager fm, List<BaseFragment> list) {
		super(fm);
		this.list = list;
	}

	// 得到数据
	@Override
	public Fragment getItem(int position) {

		return list.get(position);
	}

	@Override
	public int getCount() {
		
		return list.size();
	}

}
