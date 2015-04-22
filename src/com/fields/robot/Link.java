package com.fields.robot;

/**
 * <b>Application describing: 链接类bean</b> <br>
 * 
 * @author <a href="mailto:billy7x17@gmail.com">Billy </a>
 * @version 1.0.0 2015年4月16日 上午10:59:16
 */
public class Link extends Text<Object>
{
	private static final long serialVersionUID = 760879505774817590L;

	private String url;

	/**
	 * 获取url字段数据
	 * 
	 * @return Returns the url.
	 */
	public String getUrl()
	{
		return url;
	}

	/**
	 * 设置url字段数据
	 * 
	 * @param url
	 *            The url to set.
	 */
	public void setUrl(String url)
	{
		this.url = url;
	}
}
