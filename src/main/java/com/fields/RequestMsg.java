package com.fields;

import com.Utils.Constants.event;
import com.Utils.Constants.msg_type;

public class RequestMsg
{

	private long MsgId;
	private String ToUserName;
	private String FromUserName;
	private long CreateTime;
	private msg_type MsgType;
	// Text 文本消息特有
	private String Content;
	// 图片消息特有
	private String PicUrl;
	private String MediaId;
	// 位置消息特有
	private double Location_X;
	private double Location_Y;
	private double Scale;
	private String Label;
	// 链接消息特有
	private String Title;
	private String Description;
	private String Url;
	// 事件消息特有
	private event Event;
	private String EventKey;
	// 语音消息特有
	private String Recognition;
	private String Format;

	public String getToUserName()
	{
		return ToUserName;
	}

	public void setToUserName(String toUserName)
	{
		ToUserName = toUserName;
	}

	public String getFromUserName()
	{
		return FromUserName;
	}

	public void setFromUserName(String fromUserName)
	{
		FromUserName = fromUserName;
	}

	public long getCreateTime()
	{
		return CreateTime;
	}

	public void setCreateTime(long createTime)
	{
		CreateTime = createTime;
	}

	public msg_type getMsgType()
	{
		return MsgType;
	}

	public void setMsgType(msg_type msgType)
	{
		MsgType = msgType;
	}

	public long getMsgId()
	{
		return MsgId;
	}

	public void setMsgId(long msgId)
	{
		MsgId = msgId;
	}

	public String getPicUrl()
	{
		return PicUrl;
	}

	public void setPicUrl(String picUrl)
	{
		PicUrl = picUrl;
	}

	public String getContent()
	{
		return Content;
	}

	public void setContent(String content)
	{
		Content = content;
	}

	public double getLocation_X()
	{
		return Location_X;
	}

	public void setLocation_X(double location_X)
	{
		Location_X = location_X;
	}

	public double getLocation_Y()
	{
		return Location_Y;
	}

	public void setLocation_Y(double location_Y)
	{
		Location_Y = location_Y;
	}

	public double getScale()
	{
		return Scale;
	}

	public void setScale(double scale)
	{
		Scale = scale;
	}

	public String getLabel()
	{
		return Label;
	}

	public void setLabel(String label)
	{
		Label = label;
	}

	public String getTitle()
	{
		return Title;
	}

	public void setTitle(String title)
	{
		Title = title;
	}

	public String getDescription()
	{
		return Description;
	}

	public void setDescription(String description)
	{
		Description = description;
	}

	public String getUrl()
	{
		return Url;
	}

	public void setUrl(String url)
	{
		Url = url;
	}

	public event getEvent()
	{
		return Event;
	}

	public void setEvent(event event)
	{
		Event = event;
	}

	public String getEventKey()
	{
		return EventKey;
	}

	public void setEventKey(String eventKey)
	{
		EventKey = eventKey;
	}

	public String getMediaId()
	{
		return MediaId;
	}

	public void setMediaId(String mediaId)
	{
		MediaId = mediaId;
	}

	public String getRecognition()
	{
		return Recognition;
	}

	public void setRecognition(String recognition)
	{
		Recognition = recognition;
	}

	public String getFormat()
	{
		return Format;
	}

	public void setFormat(String format)
	{
		Format = format;
	}

}
