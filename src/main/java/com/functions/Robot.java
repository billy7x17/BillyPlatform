package com.functions;

import com.fields.ResponseMsg;

public interface Robot
{
	/**
	 * chat 机器人实现方法 <br>
	 * 接入网络机器人或自己实现~
	 * 
	 * @param content
	 *            接收的消息
	 * @return 添加响应消息的微信响应实体(只需赋值消息类型和内容即可)
	 */
	public ResponseMsg chat(String content);
}
