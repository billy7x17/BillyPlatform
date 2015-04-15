package com.Utils;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fields.Item;
import com.fields.RequestMsg;
import com.fields.ResponseMsg;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XMLUtil
{

	private static Logger logger = Logger.getLogger(XMLUtil.class);

	/**
	 * 输出方法
	 * 
	 * @param resp
	 * @param reqMsg
	 * @throws IOException
	 */
	public static void Output(HttpServletResponse resp , ResponseMsg respMsg)
			throws IOException
	{
		XStream xs = new XStream(new DomDriver());
		xs.alias("xml" , ResponseMsg.class);
		xs.alias("item" , Item.class);

		try
		{
			xs.toXML(respMsg , resp.getWriter());
		}
		catch(Exception e)
		{
			logger.error("返回XML数据时转化异常" , e);
		}

	}

	/**
	 * 输入方法
	 * 
	 * @param req
	 * @return fields
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object Input(HttpServletRequest req) throws IOException
	{
		XStream a = new XStream(new DomDriver());

		a.alias("xml" , RequestMsg.class);

		StringBuffer sb = new StringBuffer();
		String line = new String();
		BufferedReader reader = req.getReader();

		try
		{
			while(( line = reader.readLine() ) != null)
			{
				sb.append(line);

			}
		}
		catch(Exception e)
		{
			logger.error("微信的请求XML参数解码异常" , e);
		}

		logger.info(sb.toString());

		return a.fromXML(sb.toString());
	}

}
