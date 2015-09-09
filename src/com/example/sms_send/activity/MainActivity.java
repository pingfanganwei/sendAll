package com.example.sms_send.activity;

import com.example.sms_send.R;
import com.example.sms_send.R.id;
import com.example.sms_send.R.layout;
import com.example.sms_send.R.menu;
import com.example.sms_send.fragment.MainFragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * ����ҳ��
 * 
 * @author H_lang
 * 
 */
public class MainActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// ������Ƭ������
		FragmentManager fragmentManager = getFragmentManager();
		MainFragment fragment = new MainFragment();
		fragmentManager.beginTransaction().replace(R.id.ll_content,fragment,"fragment").commit();
		
	}

}
