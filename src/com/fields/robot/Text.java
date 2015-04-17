package com.fields.robot;

import java.io.Serializable;
import java.util.List;

/**
 * <b>Application describing: 基础文本bean 所有返回参数都有code和text</b> <br>
 * 
 * @author <a href="mailto:billy7x17@gmail.com">Billy </a>
 * @version 1.0.0 2015年4月16日 上午11:00:13
 */
public class Text <E> implements Serializable
{
	private static final long serialVersionUID = -8666078998730789784L;

	/**
	 * 状态码
	 */
	private Integer code;

	/**
	 * 文字内容
	 */
	private String text;

	/**
	 * 详情list(可选)
	 */
	private List<E> list;

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	/**
	 * 获取list字段数据
	 * 
	 * @return Returns the list.
	 */
	public List<E> getList()
	{
		return list;
	}

	/**
	 * 设置list字段数据
	 * 
	 * @param list
	 *            The list to set.
	 */
	public void setList(List<E> list)
	{
		this.list = list;
	}

	/**
	 * 获取code字段数据
	 * 
	 * @return Returns the code.
	 */
	public Integer getCode()
	{
		return code;
	}

	/**
	 * 设置code字段数据
	 * 
	 * @param code
	 *            The code to set.
	 */
	public void setCode(Integer code)
	{
		this.code = code;
	}
}
