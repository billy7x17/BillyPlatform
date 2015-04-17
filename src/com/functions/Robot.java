package com.functions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.Utils.Constants.msg_type;
import com.fields.Item;
import com.fields.ResponseMsg;
import com.fields.robot.Link;
import com.fields.robot.News;
import com.fields.robot.RespCode;
import com.fields.robot.News.NewsItem;

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
			logger.error("与tuling123.com之间的网络不通" , e);
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

		decodeJson(sb);

		return null;

	}

	/**
	 * 解析图灵机器人返回的json
	 * 
	 * @param sb
	 * @return
	 */
	private ResponseMsg decodeJson(StringBuffer sb)
	{

		JSONObject resp = JSONObject.fromObject(sb.toString());

		Integer respCode = resp.getInt("code");

		RespCode code = RespCode.getRespEnum(respCode);

		ResponseMsg respMsg = new ResponseMsg();

		switch(code)
		{
			case text:
				respMsg.setContent(resp.getString("text"));
				respMsg.setMsgType(msg_type.text);
				break;
			case link:
				Link link = (Link)JSONObject.toBean(resp , Link.class);
				respMsg.setContent(link.getText() + "\n" + link.getUrl());
				respMsg.setMsgType(msg_type.text);
				break;
			case news:
				News news = (News)JSONObject.toBean(resp , News.class);
				List<NewsItem> list = news.getList();
				respMsg.setMsgType(msg_type.news);
				respMsg.setArticleCount(list.size());
				respMsg.setArticles(formatNews(list));
				break;
			default:
				break;
		}

		return null;

	}

	private List<Item> formatNews(List<NewsItem> list)
	{
		List<Item> resultList = new ArrayList<Item>();
		for (NewsItem it : list)
		{
			Item tmp = new Item();
			tmp.setTitle(it.getArticle());
			tmp.setUrl(it.getDetailurl());
			tmp.setPicUrl(it.getIcon());
			resultList.add(tmp);
			/* 微信平台默认接受10条以内的图文消息,多了会无响应 */
			if(resultList.size() == 10)
				break;
		}

		return resultList;
	}
}
