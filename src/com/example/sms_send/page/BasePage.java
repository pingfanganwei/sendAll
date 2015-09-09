package com.example.sms_send.page;

import android.content.Context;
import android.view.View;

/**
 * 所有页面的基类
 * 
 * @author H_lang
 */
public abstract class BasePage
{
	public View viewRoot;
	public Context context;

	public BasePage(Context context)
	{
		this.context = context;
		viewRoot = initView();
	}

	public abstract View initView();

	public abstract void initData();

	public View getView()
	{
		return viewRoot;
	}
}
