package com.example.sms_send.page;

import com.example.sms_send.R;

import android.content.Context;
import android.view.View;

/*
 * ∑¢ÀÕΩÁ√Ê
 */
public class SendPage extends BasePage
{
	
	public SendPage(Context context)
	{
		super(context);
		
	}

	@Override
	public View initView()
	{	
		View view = View.inflate(context, R.layout.page_send, null);
		return view;
	}

	@Override
	public void initData()
	{
		// TODO Auto-generated method stub
		
	}

}
