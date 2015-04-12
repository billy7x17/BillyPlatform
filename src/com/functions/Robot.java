package com.functions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.*;

public class Robot
{

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
			e.printStackTrace();
		}
		String getURL = tulingUrl + "key=" + APIKEY + "&info=" + INFO;
		URL getUrl = null;
		try
		{
			getUrl = new URL(getURL);
		}
		catch(MalformedURLException e)
		{
			e.printStackTrace();
		}
		HttpURLConnection connection = null;
		try
		{
			connection = (HttpURLConnection)getUrl.openConnection();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		try
		{
			connection.connect();
		}
		catch(IOException e)
		{
			e.printStackTrace();
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
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
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
			e.printStackTrace();
		}
		try
		{
			reader.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		// 断开连接
		connection.disconnect();
		System.out.println(sb);

		return sb.toString();
	}

	/**
	 * 解析图灵机器人返回的json
	 * 
	 * @param sb
	 * @return
	 */
	private String decodeJson(StringBuffer sb)
	{
		
		
		
		return null;
	}
}
