package com.fields.robot;

import java.io.Serializable;

public class TuringResp implements Serializable
{
	private static final long serialVersionUID = -8666078998730789784L;

	private String code;

	private String text;

	private String url;

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

}
