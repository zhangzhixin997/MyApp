package com.hy.viewpagerandfragment.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.viewpagerandfragment.R;
import com.hy.viewpagerandfragment.base.BaseFragment;

public class WeChatFragment extends BaseFragment {

    @Override
    public View initView(LayoutInflater inflater) {
        //添加页面布局
        View view = inflater.inflate(R.layout.fragment_wechat, null);

        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {


    }

}
