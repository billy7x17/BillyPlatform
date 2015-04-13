package com.functions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.URLEncoder;
import java.util.Date;
import com.Utils.GetURLData;
import com.fields.Weather;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class WeatherQuery
{

	public String weatherQuery(String cityName , int day) throws IOException
	{
		long curTime = new Date().getTime();

		String city = null;

		try
		{
			city = URLEncoder.encode(cityName , "gb2312");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		System.out.println("URL:http://php.weather.sina.com.cn/xml.php?city="
				+ city + "&password=DJOYnieT8234jlsK&day=" + day);

		String string = GetURLData.stringSendGet(
				"http://php.weather.sina.com.cn/xml.php?city=" + city
						+ "&password=DJOYnieT8234jlsK&day=" + day , "");
		System.out.println(string);
		System.out.println(string);

		string = string.replaceAll(
				"<\\?xml version=\"1.0\" encoding=\"UTF-8\"\\?>" , "<xml>");
		string = string.replaceAll("<Profiles><Weather>" , "");
		string = string.replaceAll("</Weather></Profiles>" , "</xml>");
		string = string.replaceAll("(<!--)+[\\S\\s]+(-->)" , "");
		string = string.substring(string.indexOf("<xml") ,
				string.lastIndexOf('>') + 1);

		System.out.println(string);

		XStream a = new XStream(new DomDriver());

		a.alias("xml" , Weather.class);

		StringBuffer sb = new StringBuffer();
		String line = new String();
		// BufferedReader reader = req.getReader();
		// ByteArrayInputStream in = new
		// ByteArrayInputStream(string.getBytes());

		StringReader sr = new StringReader(string);

		BufferedReader reader = new BufferedReader(sr);

		try
		{
			while(( line = reader.readLine() ) != null)
			{
				sb.append(line);

			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		Weather weather = null;
		try
		{
			weather = (Weather)a.fromXML(sb.toString());
		}
		catch(Exception e)
		{
			e.printStackTrace();

			return "未找到您所输入的城市";
		}

		long now = new Date().getTime();

		System.out.println("天气查询 占用了 " + ( now - curTime ) + " 毫秒时间");

		return toXml(weather);
	}

	private String toXml(Weather weather)
	{
		StringBuilder result = new StringBuilder();

		result.append(weather.getCity()).append("天气预报")
				.append(weather.getSavedate_weather()).append("\n");

		result.append("白天天气情况:").append(weather.getStatus1()).append("\n");

		result.append("夜间天气情况:").append(weather.getStatus2()).append("\n");

		result.append("白天风向:").append(weather.getDirection1()).append("\n");

		result.append("夜间风向:").append(weather.getDirection2()).append("\n");

		result.append("白天风力").append(weather.getPower1()).append("\n");

		result.append("夜间风力").append(weather.getPower2()).append("\n");

		result.append("白天温度:").append(weather.getTemperature1()).append("\n");

		result.append("夜间温度:").append(weather.getTemperature2()).append("\n");

		result.append("体感指数:").append(weather.getSsd()).append("\n");

		// result.append("体感度指数").append(weather.getSsd_l()).append("\n");

		result/* .append("体感度指数说明") */.append(weather.getSsd_s()).append("\n");

		result.append("白天体感温度:").append(weather.getTgd1()).append("\n");

		result.append("夜间体感温度:").append(weather.getTgd2()).append("\n");

		result.append("紫外线指数").append(weather.getZwx()).append("\n");

		// result.append("紫外线指数").append(weather.getZwx_l()).append("\n");

		result/* .append("紫外线指数说明") */.append(weather.getZwx_s()).append("\n");

		result.append("空调指数").append(weather.getKtk()).append("\n");

		// result.append("空调指数").append(weather.getKtk_l()).append("\n");

		result/* .append("空调指数说明") */.append(weather.getKtk_s()).append("\n");

		result.append("污染指数").append(weather.getPollution()).append("\n");

		// result.append("污染物扩散条件").append(weather.getPollution_l()).append("\n");

		result/* .append("污染指数说明") */.append(weather.getPollution_s()).append(
				"\n");

		result.append("洗车指数").append(weather.getXcz()).append("\n");

		// result.append("洗车指数").append(weather.getXcz_l()).append("\n");

		result./* append("洗车指数说明"). */append(weather.getXcz_s()).append("\n");

		result.append("穿衣指数").append(weather.getChy()).append("\n");

		// result.append("穿衣指数").append(weather.getChy_l()).append("\n");

		result./* append("穿衣说明"). */append(weather.getChy_shuoming()).append(
				"\n");

		result.append("感冒指数").append(weather.getGm()).append("\n");

		// result.append("感冒指数").append(weather.getGm_l()).append("\n");

		result/* .append("感冒指数说明") */.append(weather.getGm_s()).append("\n");

		result.append("运动指数").append(weather.getYd()).append("\n");

		// result.append("运动指数").append(weather.getYd_l()).append("\n");

		result./* append("运动指数说明"). */append(weather.getYd_s()).append("\n");

		// result.append("??").append(weather.getZho()).append("\n");
		//
		// result.append("??").append(weather.getZho_l()).append("\n");
		//
		// result.append("??").append(weather.getZho_shuoming()).append("\n");
		//
		// result.append("??").append(weather.getDiy()).append("\n");
		//
		// result.append("??").append(weather.getDiy_l()).append("\n");
		//
		// result.append("??").append(weather.getDiy_shuoming()).append("\n");
		//
		// result.append("??").append(weather.getFas()).append("\n");
		//
		// result.append("??").append(weather.getFas_l()).append("\n");
		//
		// result.append("??").append(weather.getFas_shuoming()).append("\n");

		// result.append("天气预报日期").append(weather.getSavedate_weather()).append(
		// "\n");
		//
		// result.append("生活日期").append(weather.getSavedate_life()).append("\n");
		//
		// result.append("指数日期").append(weather.getSavedate_zhishu()).append("\n");

		return result.toString();
	}
}
