package com.example.sms_send.Bean;

/**
 * 联系人包装
 * 
 * @author xiaobailong
 */
public class Contact
{
	public Contact()
	{
		
	}
	
	private String name; // 姓名
	private String phoneNum;//电话号码
	private String nameAbbreviation;//联系人简写

	
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
