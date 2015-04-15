package com.functions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.*;
import org.apache.log4j.Logger;
import net.sf.json.JSONObject;

public class Robot
{
	private final Logger logger = Logger.getLogger(this.getClass());

	private String key = "14d2afbc06b450929bae263e2c1bd0d9";

	private String tulingUrl = "http://www.tuling123.com/openapi/api?";

	public String chat(String q)
	{
		String APIKEY = key;
		String INFO = null;
		try
		{
			INFO = URLEncoder.encode(q , "utf-8");
		}
		catch(UnsupportedEncodingException e)
		{
			logger.error("转码失败," , e);
			return "请输入中文汉字或英文字母";
		}
		String getURL = tulingUrl + "key=" + APIKEY + "&info=" + INFO;
		URL getUrl = null;
		try
		{
			getUrl = new URL(getURL);
		}
		catch(MalformedURLException e)
		{
			logger.error("url格式错误" , e);
			return "网络故障,请稍后再试";
		}
		HttpURLConnection connection = null;
		try
		{
			connection = (HttpURLConnection)getUrl.openConnection();
		}
		catch(IOException e)
		{
			logger.error("开启连接失败" , e);
			return "网络故障,请稍后再试";
		}
		try
		{
			connection.connect();
		}
		catch(IOException e)
		{
			logger.error("与turing123.com之间的网络不通" , e);
			return "网络故障,请稍后再试";
		}

		// 取得输入流，并使用Reader读取
		BufferedReader reader = null;
		try
		{
			reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), "utf-8"));
		}
		catch(UnsupportedEncodingException e)
		{
			logger.error("返回的字符串不能解码为UTF-8" , e);
			return "网络故障,请稍后再试";
		}
		catch(IOException e)
		{
			logger.error("IO流操作异常" , e);
			return "网络故障,请稍后再试";
		}
		StringBuffer sb = new StringBuffer();
		String line = "";
		try
		{
			while(( line = reader.readLine() ) != null)
			{
				sb.append(line);
			}
		}
		catch(IOException e)
		{
			logger.error("IO流操作异常" , e);
			return "网络故障,请稍后再试";
		}
		try
		{
			reader.close();
		}
		catch(IOException e)
		{
			logger.error("IO流关闭异常" , e);
			return "网络故障,请稍后再试";
		}
		// 断开连接
		connection.disconnect();
		logger.info(sb);

		return decodeJson(sb);

	}

	/**
	 * 解析图灵机器人返回的json
	 * 
	 * @param sb
	 * @return
	 */
	private String decodeJson(StringBuffer sb)
	{

		JSONObject resp = JSONObject.fromObject(sb.toString());

		return (String)resp.get("text");

	}
}
