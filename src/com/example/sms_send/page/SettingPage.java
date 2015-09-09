package com.example.sms_send.page;

import com.example.sms_send.R;

import android.content.Context;
import android.view.View;

/**
 * …Ë÷√“≥√Ê
 * 
 * @author H_lang
 * 
 */
public class SettingPage extends BasePage
{

	public SettingPage(Context context)
	{
		super(context);
		
	}

	@Override
	public View initView()
	{
		View view = View.inflate(context, R.layout.page_setting, null);
		return view;
	}

	@Override
	public void initData()
	{
		// TODO Auto-generated method stub
		
	}
	
}
