package com.functions;

import java.net.URLEncoder;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.Utils.GetURLData;
import com.fields.Youdao;

/**
 * http://fanyi.youdao.com/openapi.do?keyfrom=&key=&type=data&doctype=&version=
 * 1.1&q=要翻译的文本 ? 版本：1.1，请求方式：get，编码方式：utf-8 主要功能：中英互译，同时获得有道翻译结果和有道词典结果（可能没有）
 * 参数说明： 　type - 返回结果的类型，固定为data 　doctype - 返回结果的数据格式，xml或json或jsonp 　version -
 * 版本，当前最新版本为1.1 　q - 要翻译的文本，不能超过200个字符，需要使用utf-8编码 errorCode： 　0 - 正常 　20 -
 * 要翻译的文本过长 　30 - 无法进行有效的翻译 　40 - 不支持的语言类型 　50 - 无效的key
 * 
 * @author Administrator
 * 
 */

public class Translate
{

	/**
	 * { "errorCode":0 "query":"翻译", "translation":["translation"], // 有道翻译
	 * "basic":{ // 有道词典-基本词典 "phonetic":"fān yì", "explains":[ "translate",
	 * "interpret" ] }, "web":[ // 有道词典-网络释义 { "key":"翻译",
	 * "value":["translator","translation","translate","Interpreter"] }, {...} ]
	 * }
	 * 
	 * @param source
	 * @return
	 */

	public String getText(String source)
	{

		if(null == source || "".equals(source))
		{
			return "亲，请输入要翻译的语句哦！";
		}

		try
		{
			source = URLEncoder.encode(source , "utf-8");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		String url = "http://fanyi.youdao.com/openapi.do?keyfrom=BillyPlatform&key=218884037&type=data&doctype=json&version=1.1&q="
				+ source;

		String jsonStr = GetURLData.stringSendGet(url , "");

		JSONObject a = null;

		Youdao youdao = null;

		String result = new String();

		/* 获取错误码和翻译 */
		try
		{
			youdao = new Youdao();

			a = new JSONObject(jsonStr);

			youdao.setErrorCode(a.getInt("errorCode"));

			youdao.setTranslation(a.getString("translation"));
		}
		catch(JSONException e)
		{
			e.printStackTrace();
		}

		/* 错误码判定 */
		switch(youdao.getErrorCode())
		{
			case 0:
				result = youdao.getTranslation().substring(
						youdao.getTranslation().indexOf("\"") + 1 ,
						youdao.getTranslation().indexOf("\"" , 2));
				break;
			case 20:
				result = "亲，要翻译的文本，不能超过200个字符哦！";
				break;
			case 30:
				result = "无法进行有效的翻译";
				break;
			case 40:
				result = "不支持的语言类型";
				break;
			case 50:
				result = "无效的key";
				break;
			default:
				result = "不知怎么回事，就是不好使了！";
				break;
		}

		return result;

	}

	public static void main(String[] args)
	{
		Translate t = new Translate();

		String a = t.getText("    fuck you");

		System.out.println(a);
	}
}
