package com.fields;

/**
 * <item> <Title><![CDATA[title1]]></Title>
 * <Description><![CDATA[description1]]></Description>
 * <PicUrl><![CDATA[picurl]]></PicUrl> <Url><![CDATA[url]]></Url> </item>
 * 
 * @author Administrator
 * 
 */
public class Item
{
	private String Title;
	private String Description;
	private String PicUrl;
	private String Url;

	public String getTitle()
	{
		return Title;
	}

	public void setTitle(String title)
	{
		Title = title;
	}

	public String getDescription()
	{
		return Description;
	}

	public void setDescription(String description)
	{
		Description = description;
	}

	public String getPicUrl()
	{
		return PicUrl;
	}

	public void setPicUrl(String picUrl)
	{
		PicUrl = picUrl;
	}

	public String getUrl()
	{
		return Url;
	}

	public void setUrl(String url)
	{
		Url = url;
	}
}
