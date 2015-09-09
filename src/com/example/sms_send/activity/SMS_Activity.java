package com.example.sms_send.activity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sms_send.R;
import com.example.sms_send.Bean.Contact;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class SMS_Activity extends Activity
{
	@ViewInject(R.id.send_msg_btn)
	private Button mSendButton;// 发送短信
	@ViewInject(R.id.load_contact_btn)
	private Button mLoadContactButton;// 加载联系人
	@ViewInject(R.id.phone_num_et)
	public EditText mPhoneNumEditText;// 发送人的号码
	@ViewInject(R.id.message_text_et)
	private EditText mMessageEditText;// 发送的内容

	private Contact mContact;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sms_);
		ViewUtils.inject(this); // 注解

	}

	/**
	 * 打开联系人，选择一个发送短信
	 * 
	 * @param view
	 */
	public void loadConcart(View view)
	{
		// 打开系统联系人加载界面
		Intent intent = new Intent();
		intent.setAction("android.intent.action.PICK");
		intent.addCategory("android.intent.category.DEFAULT");
		intent.setType("vnd.android.cursor.dir/contact");
		// intent.setType("vnd.android.cursor.item/contact");
		startActivityForResult(intent, 10);
	}

	/**
	 * 发送信息
	 * @param view
	 */
	public void send_message(View view)
	{
		String phoneNum = mPhoneNumEditText.getText().toString().trim();
		String text = mMessageEditText.getText().toString().trim();
		// 获取到短信管理器
		SmsManager message = SmsManager.getDefault();
		message.sendTextMessage(phoneNum, null, text, null, null);
	}

	/**
	 * 
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		mContact = new Contact();
		if (data != null)
		{
			String phone = data.getStringExtra("phone");
		}

		if (requestCode == 10)
		{
			// com.android.contacts
			String uri = data.getDataString();
			// 根据uri去查询数据库当中的值。 打印查询系统联系人得到的Uri
			String[] sp = uri.split("/");

			String id = sp[sp.length - 1];// id
			String lookUp = sp[sp.length - 2];// lookup列的值。唯一标示

			System.out.println(id + "+id");
			System.out.println(lookUp + "+lookUp");
			System.out.println("uri" + uri);

			Uri dataUri = Uri.parse("content://com.android.contacts/data");
			// 根据id查询到号码
			ContentResolver contentResolver = getContentResolver();

			// 查询的列
			String[] projection = new String[] { "data1", "mimetype" };
			// while以后的条件
			String selection = "lookup=?";
			// 设置的条件值
			String[] selectionArgs = new String[] { lookUp };
			Cursor dataCursor = contentResolver.query(dataUri, projection, selection, selectionArgs, null);
			// 查询到应该是许多列
			while (dataCursor.moveToNext())
			{
				String data1 = dataCursor.getString(0);
				String mimetype = dataCursor.getString(1);

				if ("vnd.android.cursor.item/name".equals(mimetype))
				{
					// 名字也需要保存起来、
					mContact.setName(mimetype);
				} else if ("vnd.android.cursor.item/phone_v2".equals(mimetype))
				{
					mPhoneNumEditText.setText(data1);
					mContact.setPhoneNum(data1);// 保存名字

				}

			}
			// 查询联系人。列表
		}
	}

}
