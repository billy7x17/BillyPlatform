package com.functions.robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.util.Base64;
import org.apache.log4j.Logger;

import com.Utils.Constants.msg_type;
import com.fields.Item;
import com.fields.ResponseMsg;
import com.fields.robot.Flight;
import com.fields.robot.Flight.FlightItem;
import com.fields.robot.Link;
import com.fields.robot.News;
import com.fields.robot.Recipe;
import com.fields.robot.Recipe.RecipeItem;
import com.fields.robot.RespCode;
import com.fields.robot.News.NewsItem;
import com.fields.robot.Train.trainFlight;
import com.fields.robot.Train;
import com.functions.Robot;

import net.sf.json.JSONObject;

public class TuringRobot implements Robot
{
	private final Logger logger = Logger.getLogger(this.getClass());

	private String key = "14d2afbc06b450929bae263e2c1bd0d9";

	private String tulingUrl = "http://www.tuling123.com/openapi/api?";

	/**
	 * 微信最多支持10个图文信息
	 */
	private final int teletextMaxNum = 10;

	@Override
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
			InetSocketAddress sa = new InetSocketAddress("proxy.neusoft.com",
					8080);
			Proxy proxy = new Proxy(Proxy.Type.HTTP, sa);
			connection = (HttpURLConnection)getUrl.openConnection(proxy);

			connection.setRequestProperty("Proxy-Authorization" , "li-zr:Huskarbitch110");
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

		@SuppressWarnings("rawtypes")
		Map<String , Class> classMap = new HashMap<String , Class>();

		StringBuffer content = null;

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
				classMap.put("list" , NewsItem.class);
				News news = (News)JSONObject.toBean(resp , News.class ,
						classMap);
				List<NewsItem> newsList = news.getList();
				respMsg.setMsgType(msg_type.news);
				respMsg.setArticleCount(newsList.size() > teletextMaxNum ? teletextMaxNum
						: newsList.size());
				respMsg.setArticles(formatNews(newsList));
				break;
			case train:
				classMap.put("list" , trainFlight.class);
				Train train = (Train)JSONObject.toBean(resp , Train.class ,
						classMap);
				List<trainFlight> trainList = train.getList();
				respMsg.setMsgType(msg_type.text);
				content = new StringBuffer();
				for (trainFlight it : trainList)
					content.append(
							"·<a href=\"http://touch.qunar.com/h5/train/trainList?startStation=")
							.append(it.getStart()).append("&endStation=")
							.append(it.getTerminal()).append("\" >")
							.append(it.getTrainnum()).append("</a>\n")
							.append(it.getStarttime()).append("  -  ")
							.append(it.getEndtime()).append("\n");
				respMsg.setContent(content.toString());
				break;
			case flight:
				classMap.put("list" , FlightItem.class);
				Flight flight = (Flight)JSONObject.toBean(resp , Flight.class ,
						classMap);
				List<FlightItem> flightList = flight.getList();
				respMsg.setMsgType(msg_type.text);
				content = new StringBuffer();
				for (FlightItem it : flightList)
					content.append("·").append(it.getFlight()).append("\n")
							.append(it.getStarttime()).append("  -  ")
							.append(it.getEndtime()).append("\n");
				content.append("<a href='http://touch.qunar.com/h5/flight/'>查看更多详情</a>");
				respMsg.setContent(content.toString());
				break;
			case recipe:
				classMap.put("list" , RecipeItem.class);
				Recipe recipe = (Recipe)JSONObject.toBean(resp , Recipe.class ,
						classMap);
				List<RecipeItem> recipeList = recipe.getList();
				respMsg.setMsgType(msg_type.news);
				respMsg.setArticleCount(recipeList.size() > teletextMaxNum ? teletextMaxNum
						: recipeList.size());
				respMsg.setArticles(formatRecipe(recipeList));
				break;
			default:
				logger.info("没有识别\"机器人语言\"状态码:");
				logger.info(resp.get("code"));
				respMsg = simpleTextMsg("\"机器人语言\"状态码转码失败!");
				break;
		}

		return respMsg;

	}

	/**
	 * 
	 * formatNews 新闻 -> 图文信息
	 * 
	 * @param 新闻list
	 * @return 图文信息的articleList
	 */
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
			if(resultList.size() == teletextMaxNum)
				break;
		}

		return resultList;
	}

	/**
	 * 
	 * formatRecipe 菜谱等 -> 图文信息
	 * 
	 * @param list
	 *            菜谱list
	 * @return 图文信息的articleList
	 */
	private List<Item> formatRecipe(List<RecipeItem> list)
	{
		List<Item> resultList = new ArrayList<Item>();

		for (RecipeItem it : list)
		{
			Item tmp = new Item();
			tmp.setTitle(it.getName());
			tmp.setUrl(it.getDetailurl());
			tmp.setPicUrl(it.getIcon());
			tmp.setDescription(it.getInfo());
			resultList.add(tmp);
			/* 微信平台默认接受10条以内的图文消息,多了会无响应 */
			if(resultList.size() == teletextMaxNum)
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
