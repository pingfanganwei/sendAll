package com.example.sms_send.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.sms_send.R;
import com.example.sms_send.page.BasePage;
import com.example.sms_send.page.EditContactPage;
import com.example.sms_send.page.SendPage;
import com.example.sms_send.page.SettingPage;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * 碎片管理器
 * 
 * @author H_lang
 * 
 */
public class MainFragment extends Fragment
{
	@ViewInject(R.id.vp_sendGroup)
	private ViewPager mSendGroupViewPager;
	private Context context;
	private List<BasePage> mPageList;

	@ViewInject(R.id.imgBtn_tab_bottom__settiog)
	private ImageButton mSettingImageButton;// 设置按钮
	@ViewInject(R.id.imgBtn_tab_bottom_load_contact)
	private ImageButton mLoadContartiImageButton; // 联系人
	@ViewInject(R.id.imgBtn_tab_bottom_send)
	private ImageButton mSendImageButton; // 设置

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		// 获取到上下文
		context = getActivity();
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		// 创建视图
		View rootView = inflater.inflate(R.layout.fragment_main, container, false);
		ViewUtils.inject(this, rootView);

		// 初始化页面
		initPage();

		mSendGroupViewPager.setAdapter(new PagerAdapter()
		{

			@Override
			public boolean isViewFromObject(View arg0, Object arg1)
			{
				return arg0 == arg1;
			}

			@Override
			public int getCount()
			{
				return mPageList.size();
			}

			/**
			 * 创建视图的时候
			 */
			@Override
			public Object instantiateItem(ViewGroup container, int position)
			{
				// 装载布局
				container.addView(mPageList.get(position).getView());
				return mPageList.get(position).getView();
			}

			@Override
			public void destroyItem(ViewGroup container, int position, Object object)
			{
				// 移除View
				container.removeView((View) object);

			}
		});

		// 设置ViewPage监听
		mSendGroupViewPager.setOnPageChangeListener(new OnPageChangeListener()
		{

			// 当页面被选择的时候 切换底部菜单
			@Override
			public void onPageSelected(int position)
			{
				switch (position)
				{
				case 0:
					mSendImageButton.setImageResource(R.drawable.tab_weixin_pressed);
					mLoadContartiImageButton.setImageResource(R.drawable.tab_address_normal);
					mSettingImageButton.setImageResource(R.drawable.tab_settings_normal);
					break;
				case 1:
					mSendImageButton.setImageResource(R.drawable.tab_weixin_normal);
					mLoadContartiImageButton.setImageResource(R.drawable.tab_address_pressed);
					mSettingImageButton.setImageResource(R.drawable.tab_settings_normal);
					break;
				case 2:
					mSendImageButton.setImageResource(R.drawable.tab_weixin_normal);
					mLoadContartiImageButton.setImageResource(R.drawable.tab_address_normal);
					mSettingImageButton.setImageResource(R.drawable.tab_settings_pressed);
					break;
				default:
					break;
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2)
			{

			}

			@Override
			public void onPageScrollStateChanged(int arg0)
			{

			}
		});

		mSendGroupViewPager.setCurrentItem(0);
		return rootView;
	}

	/**
	 * 初始化页面
	 */
	private void initPage()
	{
		mPageList = new ArrayList<BasePage>();
		BasePage page1 = new SendPage(context);
		BasePage page2 = new EditContactPage(context);
		BasePage page3 = new SettingPage(context);

		mPageList.add(page1);
		mPageList.add(page2);
		mPageList.add(page3);
	}
}
