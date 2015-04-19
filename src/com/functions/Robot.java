package com.functions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.Utils.Constants.msg_type;
import com.fields.Item;
import com.fields.ResponseMsg;
import com.fields.robot.Link;
import com.fields.robot.News;
import com.fields.robot.RespCode;
import com.fields.robot.News.NewsItem;
import com.fields.robot.Train.trainFlight;
import com.fields.robot.Train;

import net.sf.json.JSONObject;

public class Robot
{
	private final Logger logger = Logger.getLogger(this.getClass());

	private String key = "14d2afbc06b450929bae263e2c1bd0d9";

	private String tulingUrl = "http://www.tuling123.com/openapi/api?";

	public ResponseMsg chat(String q)
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
			return simpleTextMsg("请输入中文汉字或英文字母");
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
			return simpleTextMsg("网络故障,请稍后再试");
		}
		HttpURLConnection connection = null;
		try
		{
			connection = (HttpURLConnection)getUrl.openConnection();
		}
		catch(IOException e)
		{
			logger.error("开启连接失败" , e);
			return simpleTextMsg("网络故障,请稍后再试");
		}
		try
		{
			connection.connect();
		}
		catch(IOException e)
		{
			logger.error("与tuling123.com之间的网络不通" , e);
			return simpleTextMsg("网络故障,请稍后再试");
		}

		// 鍙栧緱杈撳叆娴侊紝骞朵娇鐢≧eader璇诲彇
		BufferedReader reader = null;
		try
		{
			reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), "utf-8"));
		}
		catch(UnsupportedEncodingException e)
		{
			logger.error("返回的字符串不能解码为UTF-8" , e);
			return simpleTextMsg("网络故障,请稍后再试");
		}
		catch(IOException e)
		{
			logger.error("IO流操作异常" , e);
			return simpleTextMsg("网络故障,请稍后再试");
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
			return simpleTextMsg("网络故障,请稍后再试");
		}
		try
		{
			reader.close();
		}
		catch(IOException e)
		{
			logger.error("IO流关闭异常" , e);
			return simpleTextMsg("网络故障,请稍后再试");
		}
		// 鏂紑杩炴帴
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
				Map classMap = new HashMap();
				classMap.put("list" , NewsItem.class);
				News news = (News)JSONObject.toBean(resp , News.class ,
						classMap);
				List<NewsItem> newsList = news.getList();
				respMsg.setMsgType(msg_type.news);
				respMsg.setArticleCount(newsList.size());
				respMsg.setArticles(formatNews(newsList));
				break;
			case train:
				Train train = (Train)JSONObject.toBean(resp , Train.class);
				List<trainFlight> trainList = train.getList();
				respMsg.setMsgType(msg_type.text);
				StringBuffer content = new StringBuffer();
				for (trainFlight it : trainList)
					content.append(
							"<a style=\"color:green;\" href=\"http://touch.qunar.com/h5/train/trainList?startStation=")
							.append(it.getStart()).append("&endStation=")
							.append(it.getTerminal()).append("\" />\n")
							.append(it.getStarttime()).append("  -  ")
							.append(it.getEndtime()).append("\n");
				respMsg.setContent(content.toString());
				break;
			default:
				break;
		}

		return respMsg;

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

	/**
	 * 回复简单文本消息
	 * 
	 * @param msg
	 * @return
	 */
	private ResponseMsg simpleTextMsg(String msg)
	{
		ResponseMsg resp = new ResponseMsg();
		resp.setMsgType(msg_type.text);
		resp.setContent(msg);
		return resp;
	}
}
