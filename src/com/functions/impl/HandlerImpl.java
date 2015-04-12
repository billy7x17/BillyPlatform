package com.functions.impl;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.Utils.Constants.event;
import com.Utils.Constants.msg_type;
import com.fields.Item;
import com.fields.RequestMsg;
import com.fields.ResponseMsg;
import com.functions.FirstVictory;
import com.functions.Handler;
import com.functions.News;
import com.functions.Robot;
import com.functions.TimePlus;
import com.functions.Translate;
import com.functions.WeatherQuery;
import com.test.MysqlJdbc;

public class HandlerImpl implements Handler
{
	private static final FirstVictory fv = new FirstVictory();

	private static final WeatherQuery weather = new WeatherQuery();

	private final String weatherPattern = "^[0-4]:[\u4e00-\u9fa5]+天气";

	private final String timePlusPattern = "^((([1-9]{1})|([0-1][0-9])|([1-2][0-3])))([0-5][0-9])( )*[-+]{1}( )*((([1-9]{1})|([0-1][0-9])|([1-2][0-3])))([0-5][0-9])$";

	/**
	 * 接收文本信息
	 * 
	 * @throws IOException
	 */

	public ResponseMsg processTextTypeMsg(RequestMsg msg) throws IOException
	{

		ResponseMsg response = new ResponseMsg();
		String content;
		if(pattern(msg.getContent() , "^0$" , "^\\?$" , "^？$" , "^help$" ,
				"^帮助$"))
		{
			content = "找向导请输入: 0\n查询天气请输入天数(0~4): 城市汉语名称+天气:\n(例如：0:北京天气     =>查询北京当日天气\n 1:洛杉矶天气   =>查询洛杉矶明日天气\n2: 沈阳天气   =>查询沈阳后天天气 等)"
					+ "\n中英翻译请输入：翻译 + 要翻译的语句\n例如 翻译 我爱中国"
					+ "\n计算时间请直接输入算式  如： 1846 + 1021    或 357 - 1120";
			response.setContent(content);
			response.setMsgType(msg_type.text);
		}
		else if(pattern(msg.getContent() , weatherPattern))
		{
			response.setContent(weather.weatherQuery(msg.getContent()
					.substring(2 , msg.getContent().length() - 2) , Integer
					.valueOf(msg.getContent().substring(0 , 1))));
			response.setMsgType(msg_type.text);
		}
		else if(pattern(msg.getContent() , timePlusPattern))
		{
			String[] timeArr = msg.getContent().split("-|\\+");
			TimePlus bean = new TimePlus();
			String timeResult = null;
			if(-1 != msg.getContent().indexOf('+'))
				timeResult = bean.plus(timeArr[0].trim() , timeArr[1].trim());
			else
				timeResult = bean.minus(timeArr[0].trim() , timeArr[1].trim());

			response.setContent(timeResult);
			response.setMsgType(msg_type.text);
		}
		/* 最新资讯功能 ----- 不要了 不能保持一直最新。。 */
		/*
		 * else if('2' == msg.getContent().charAt(0)) { List<Item> list = new
		 * News().showNews(); response.setArticleCount(list.size());
		 * response.setArticles(list); response.setMsgType(msg_type.news);
		 * 
		 * System.out.println(list.get(0).getTitle());
		 * System.out.println(list.get(1).getTitle());
		 * System.out.println(list.get(2).getTitle()); }
		 */
		// test
		else if("99".equals(msg.getContent()))
		{
			MysqlJdbc test = new MysqlJdbc();
			response.setContent(test.mysqlTest());
			response.setMsgType(msg_type.text);
		}
		else if(msg.getContent().length() > 2
				&& "翻译".equals(msg.getContent().substring(0 , 2)))
		{
			Translate t = new Translate();
			response.setContent(t.getText(msg.getContent().substring(2)));
			response.setMsgType(msg_type.text);
		}
		else
		{
			// response.setContent("要好好看向导哦！找向导请打0");
			Robot bot = new Robot();
			String result = bot.chat(msg.getContent());
			response.setContent(result);
			response.setMsgType(msg_type.text);
		}
		response.setFuncFlag(0);
		return response;
	}

	/**
	 * 事件： 公众平台暂时只支持 关注和取消关注
	 */

	public ResponseMsg processEventTypeMsg(RequestMsg msg)
	{
		ResponseMsg response = new ResponseMsg();
		String content = null;
		System.out.println(msg.getEvent());
		if(msg.getEvent() == event.subscribe)
		{
			content = "欢迎您关注Billy'sPlatform,嘿嘿~。\n找向导先生请输入‘0’! \n本平台正在建设中，如果您有什么好的建议，请直接回复我哦!\n小黑会好好斟酌采纳的!";
		}
		else if(msg.getEvent() == event.unsubscribe)
		{
			System.out.println("退订了");
		}
		else
		{
			content = "收到事件信息 event:" + msg.getEvent();
		}
		System.out.println("content:" + content);
		response.setContent(content);
		response.setMsgType(msg_type.text);
		response.setFuncFlag(0);
		return response;
	}

	public ResponseMsg processImageTypeMsg(RequestMsg msg)
	{
		ResponseMsg response = new ResponseMsg();
		response.setContent("收到图片信息：picurl:" + msg.getPicUrl());
		response.setMsgType(msg_type.text);
		response.setFuncFlag(0);
		return response;
	}

	public ResponseMsg processLinkTypeMsg(RequestMsg msg)
	{
		ResponseMsg response = new ResponseMsg();
		response.setContent("收到链接信息：title:" + msg.getTitle() + "  desc:"
				+ msg.getDescription() + " url:" + msg.getUrl());
		response.setMsgType(msg_type.text);
		response.setFuncFlag(0);
		return response;
	}

	public ResponseMsg processLocationTypeMsg(RequestMsg msg)
	{
		ResponseMsg response = new ResponseMsg();
		response.setContent("收到位置信息：x:" + msg.getLocation_X() + "  y:"
				+ msg.getLocation_Y());
		response.setMsgType(msg_type.text);
		response.setFuncFlag(0);
		return response;
	}

	public ResponseMsg processVoiceTypeMsg(RequestMsg msg)
	{
		ResponseMsg response = new ResponseMsg();
		response.setContent("收到语音信息：voiceurl:" + msg.getMediaId());
		response.setMsgType(msg_type.text);
		response.setFuncFlag(0);
		return response;
	}

	/**
	 * 消息验证方法
	 * 
	 * @param msg
	 *            消息
	 * @param reg
	 *            验证的正则表达式
	 * @return 验证成功与否的boolean值
	 */
	private static boolean pattern(String msg , String... regs)
	{
		boolean flag = false;

		for (int i = 0; i < regs.length; i++)
		{
			Pattern pattern = Pattern.compile(regs[i]);

			Matcher m = pattern.matcher(msg.trim());

			if(m.find())
			{
				flag = true;
				break;
			}
		}

		return flag;
	}
}
