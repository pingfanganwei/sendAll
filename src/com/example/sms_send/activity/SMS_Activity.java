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
	private Button mSendButton;// ���Ͷ���
	@ViewInject(R.id.load_contact_btn)
	private Button mLoadContactButton;// ������ϵ��
	@ViewInject(R.id.phone_num_et)
	public EditText mPhoneNumEditText;// �����˵ĺ���
	@ViewInject(R.id.message_text_et)
	private EditText mMessageEditText;// ���͵�����

	private Contact mContact;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sms_);
		ViewUtils.inject(this); // ע��

	}

	/**
	 * ����ϵ�ˣ�ѡ��һ�����Ͷ���
	 * 
	 * @param view
	 */
	public void loadConcart(View view)
	{
		// ��ϵͳ��ϵ�˼��ؽ���
		Intent intent = new Intent();
		intent.setAction("android.intent.action.PICK");
		intent.addCategory("android.intent.category.DEFAULT");
		intent.setType("vnd.android.cursor.dir/contact");
		// intent.setType("vnd.android.cursor.item/contact");
		startActivityForResult(intent, 10);
	}

	/**
	 * ������Ϣ
	 * @param view
	 */
	public void send_message(View view)
	{
		String phoneNum = mPhoneNumEditText.getText().toString().trim();
		String text = mMessageEditText.getText().toString().trim();
		// ��ȡ�����Ź�����
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
			// ����uriȥ��ѯ���ݿ⵱�е�ֵ�� ��ӡ��ѯϵͳ��ϵ�˵õ���Uri
			String[] sp = uri.split("/");

			String id = sp[sp.length - 1];// id
			String lookUp = sp[sp.length - 2];// lookup�е�ֵ��Ψһ��ʾ

			System.out.println(id + "+id");
			System.out.println(lookUp + "+lookUp");
			System.out.println("uri" + uri);

			Uri dataUri = Uri.parse("content://com.android.contacts/data");
			// ����id��ѯ������
			ContentResolver contentResolver = getContentResolver();

			// ��ѯ����
			String[] projection = new String[] { "data1", "mimetype" };
			// while�Ժ������
			String selection = "lookup=?";
			// ���õ�����ֵ
			String[] selectionArgs = new String[] { lookUp };
			Cursor dataCursor = contentResolver.query(dataUri, projection, selection, selectionArgs, null);
			// ��ѯ��Ӧ���������
			while (dataCursor.moveToNext())
			{
				String data1 = dataCursor.getString(0);
				String mimetype = dataCursor.getString(1);

				if ("vnd.android.cursor.item/name".equals(mimetype))
				{
					// ����Ҳ��Ҫ����������
					mContact.setName(mimetype);
				} else if ("vnd.android.cursor.item/phone_v2".equals(mimetype))
				{
					mPhoneNumEditText.setText(data1);
					mContact.setPhoneNum(data1);// ��������

				}

			}
			// ��ѯ��ϵ�ˡ��б�
		}
	}

}
