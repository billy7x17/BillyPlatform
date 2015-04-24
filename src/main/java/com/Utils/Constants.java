package com.Utils;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.functions.RobotFactory;

public final class Constants
{
	private final static Logger logger = Logger.getLogger(Constants.class);

	private final static String propFileRoute = "/conf/other/system.properties";

	/**
	 * <b>Application describing: 消息类型</b> <br>
	 * 
	 * @author <a href="mailto:billy7x17@gmail.com">Billy </a>
	 * @version 1.0.0 2015年4月24日 上午11:16:57
	 */
	public static enum msg_type
	{
		event, link, location, image, text, news, music, voice
	};

	public static enum result
	{
		Error, Succuss, doNotHaveAuthority
	};

	public static enum event
	{
		subscribe, unsubscribe
	};

	public final static String ErrorMsg = "填写错误，请按照格式进行填写：\n"
			+ "选项:内容(例如,  1:abc)";

	public final static Properties prop;

	static
	{
		prop = new Properties();
		try
		{
			prop.load(RobotFactory.class.getClassLoader().getResourceAsStream(
					propFileRoute));
		}
		catch(IOException e)
		{
			logger.error("加载配置文件异常" , e);
		}

		Map<Object , Object> sysProp = new Hashtable<Object , Object>();

		sysProp.putAll(prop);

	}
}
