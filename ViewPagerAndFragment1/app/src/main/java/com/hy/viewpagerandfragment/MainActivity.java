package com.hy.viewpagerandfragment;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;



import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.viewpagerandfragment.R;
import com.hy.viewpagerandfragment.adapter.FragmentAdapter;
import com.hy.viewpagerandfragment.base.BaseFragment;
import com.hy.viewpagerandfragment.fragment.AddressFragment;
import com.hy.viewpagerandfragment.fragment.FriendFragment;
import com.hy.viewpagerandfragment.fragment.SettingFragment;
import com.hy.viewpagerandfragment.fragment.WeChatFragment;

@SuppressLint("CutPasteId")
public class MainActivity extends FragmentActivity implements OnClickListener {
    private ViewPager mViewPager;
    private List<BaseFragment> list;//数据源


    private LinearLayout mTabBtnWeChat;
    private LinearLayout mTabBtnFrd;
    private LinearLayout mTabBtnAddress;
    private LinearLayout mTabBtnSettings;

    private ImageButton mImageWeChat;
    private ImageButton mImageFrd;
    private ImageButton mImageAddress;
    private ImageButton mImageSettings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //添加数据
        list = new ArrayList<BaseFragment>();
        list.add(new WeChatFragment());
        list.add(new FriendFragment());
        list.add(new AddressFragment());
        list.add(new SettingFragment());
        initView();
        


    }

    /**
     * 初始化数据
     */
    @SuppressWarnings("deprecation")
	private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mTabBtnWeChat = (LinearLayout) findViewById(R.id.id_tab_bottom_weixin);
        mTabBtnFrd = (LinearLayout) findViewById(R.id.id_tab_bottom_friend);
        mTabBtnAddress = (LinearLayout) findViewById(R.id.id_tab_bottom_contact);
        mTabBtnSettings = (LinearLayout) findViewById(R.id.id_tab_bottom_setting);
        mImageWeChat = (ImageButton) findViewById(R.id.btn_tab_bottom_weixin);
        mImageFrd = (ImageButton) findViewById(R.id.btn_tab_bottom_friend);
        mImageAddress = (ImageButton) findViewById(R.id.btn_tab_bottom_contact);
        mImageSettings = (ImageButton) findViewById(R.id.btn_tab_bottom_setting);

        //绑定监听
        mTabBtnWeChat.setOnClickListener(this);
        mTabBtnFrd.setOnClickListener(this);
        mTabBtnAddress.setOnClickListener(this);
        mTabBtnSettings.setOnClickListener(this);
        //设置不进行预加载
        mViewPager.setOffscreenPageLimit(0);
        //绑定适配器
        FragmentAdapter adapter=new FragmentAdapter(getSupportFragmentManager(), list);
        mViewPager.setAdapter(adapter);

        //设置viewpager切换监听
        mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                setTabSelection(arg0);

            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {


            }

            @Override
            public void onPageScrollStateChanged(int arg0) {


            }
        });
        setTabSelection(0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_tab_bottom_weixin:
                setTabSelection(0);
                //设置view显示的页面
                mViewPager.setCurrentItem(0);
                break;
            case R.id.id_tab_bottom_friend:
                setTabSelection(1);
                mViewPager.setCurrentItem(1);
                break;
            case R.id.id_tab_bottom_contact:
                setTabSelection(2);
                mViewPager.setCurrentItem(2);
                break;
            case R.id.id_tab_bottom_setting:
                setTabSelection(3);
                mViewPager.setCurrentItem(3);
                break;
        }

    }

    /**
     * 根据传入的index参数来设置选中的tab页
     */

    private void setTabSelection(int index) {
        //清除状态
        clearBtn();
        switch (index) {

            case 0:
                mImageWeChat.setImageResource(R.drawable.tab_weixin_pressed);
                break;
            case 1:
                mImageFrd.setImageResource(R.drawable.tab_find_frd_pressed);

                break;
            case 2:
                mImageAddress.setImageResource(R.drawable.tab_address_pressed);
                break;
            case 3:
                mImageSettings.setImageResource(R.drawable.tab_settings_pressed);
                break;
        }

    }

    /***
     * 清除所有选中状态
     */

    private void clearBtn() {
        mImageWeChat.setImageResource(R.drawable.tab_weixin_normal);
        mImageFrd.setImageResource(R.drawable.tab_find_frd_normal);
        mImageAddress.setImageResource(R.drawable.tab_address_normal);
        mImageSettings.setImageResource(R.drawable.tab_settings_normal);

    }


}
