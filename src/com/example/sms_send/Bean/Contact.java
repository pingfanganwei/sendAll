package com.example.sms_send.Bean;

/**
 * ��ϵ�˰�װ
 * 
 * @author xiaobailong
 */
public class Contact
{
	public Contact()
	{
		
	}
	
	private String name; // ����
	private String phoneNum;//�绰����
	private String nameAbbreviation;//��ϵ�˼�д

	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPhoneNum()
	{
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum)
	{
		this.phoneNum = phoneNum;
	}

	public String getNameAbbreviation()
	{
		return nameAbbreviation;
	}

	public void setNameAbbreviation(String nameAbbreviation)
	{
		this.nameAbbreviation = nameAbbreviation;
	}

}
