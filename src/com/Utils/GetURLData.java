package com.Utils;

import java.io.*;
import java.net.*;

public class GetURLData
{
	public static String stringSendGet(String url , String param)
	{
		String result = "";
		String urlName = "";
		BufferedReader in = null;
		try
		{
			urlName = url + param;
			URL U = new URL(urlName);
			URLConnection connection = U.openConnection();
			connection.connect();
			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), "UTF-8"));
			String line;
			while(( line = in.readLine() ) != null)
			{
				result += line;
			}
			in.close();

		}
		catch(Exception e)
		{

			System.out.println("与服务器连接发生异常错误:" + e.toString());
			System.out.println("连接地址是:" + urlName);
		}
		return result;
	}

	// public static void main(String[] args)
	// {
	// String city1 = null;
	// try
	// {
	// city1 = java.net.URLEncoder.encode("武汉" , "gb2312");
	// }
	// catch(UnsupportedEncodingException e1)
	// {
	// // TODO Auto-generated catch block
	// e1.printStackTrace();
	// }
	//
	// String result = GetURLData.stringSendGet(
	// "http://php.weather.sina.com.cn/xml.php?city=" + city1
	// + "&password=DJOYnieT8234jlsK&day=0" , "");
	//
	// System.out.println(result);
	//
	// JSONArray array = null;
	// JSONObject object = null;
	//
	// try
	// {
	// // array = new JSONArray(result);
	// // System.out.println(array.length());
	// // for (int i = 0; i < array.length(); i++)
	// // {
	// // System.out.println(array.get(i));
	// // }
	// object = new JSONObject(result);
	//
	// System.out.println(object.length());
	//
	// System.out.println(object.get("weatherinfo"));
	//
	// // Weather object1 = (Weather)object.get("weatherinfo");
	// //
	// // System.out.println(object1.getCity());
	// }
	// catch(Exception e)
	// {
	// e.printStackTrace();
	// }
	// }
}