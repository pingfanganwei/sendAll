package com.example.sms_send.page;

import com.example.sms_send.R;

import android.content.Context;
import android.view.View;

/**
 * �༭����
 * 
 * @author H_lang
 * 
 */
public class EditContactPage extends BasePage
{
	public EditContactPage(Context context)
	{
		super(context);
		this.context = context;

	}

	//����һ����ͼ
	@Override
	public View initView()
	{
		View view = View.inflate(context,R.layout.page_edit_contact,null);
		return view;
	}

	@Override
	public void initData()
	{
		// TODO Auto-generated method stub

	}

}
