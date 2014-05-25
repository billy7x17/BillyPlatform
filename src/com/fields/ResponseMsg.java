package com.fields;

import java.util.List;

import com.Utils.Constants.msg_type;

/**
 * 文本消息 <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
 * <FromUserName><![CDATA[fromUser]]></FromUserName>
 * <CreateTime>12345678</CreateTime> <MsgType><![CDATA[text]]></MsgType>
 * <Content><![CDATA[content]]></Content> <FuncFlag>0</FuncFlag> </xml>
 * 
 * 音乐消息 <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
 * <FromUserName><![CDATA[fromUser]]></FromUserName>
 * <CreateTime>12345678</CreateTime> <MsgType><![CDATA[music]]></MsgType>
 * <Music> <Title><![CDATA[TITLE]]></Title>
 * <Description><![CDATA[DESCRIPTION]]></Description>
 * <MusicUrl><![CDATA[MUSIC_Url]]></MusicUrl>
 * <HQMusicUrl><![CDATA[HQ_MUSIC_Url]]></HQMusicUrl> </Music>
 * <FuncFlag>0</FuncFlag> </xml>
 * 
 * 图文消息 <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
 * <FromUserName><![CDATA[fromUser]]></FromUserName>
 * <CreateTime>12345678</CreateTime> <MsgType><![CDATA[news]]></MsgType>
 * <ArticleCount>2</ArticleCount> <Articles> <item>
 * <Title><![CDATA[title1]]></Title>
 * <Description><![CDATA[description1]]></Description>
 * <PicUrl><![CDATA[picurl]]></PicUrl> <Url><![CDATA[url]]></Url> </item> <item>
 * <Title><![CDATA[title]]></Title>
 * <Description><![CDATA[description]]></Description>
 * <PicUrl><![CDATA[picurl]]></PicUrl> <Url><![CDATA[url]]></Url> </item>
 * </Articles> <FuncFlag>1</FuncFlag> </xml>
 * 
 * @author Administrator
 * 
 */

public class ResponseMsg
{

	private int FuncFlag;
	private String ToUserName;
	private String FromUserName;
	private long CreateTime;
	private msg_type MsgType;
	// 回复文本消息
	private String Content;

	// 回复音乐消息
	private Music Music;

	// 回复图文消息
	private int ArticleCount;
	private List<Item> Articles;

	public List<Item> getArticles()
	{
		return Articles;
	}

	public void setArticles(List<Item> articles)
	{
		Articles = articles;
	}

	public int getFuncFlag()
	{
		return FuncFlag;
	}

	public void setFuncFlag(int funcFlag)
	{
		FuncFlag = funcFlag;
	}

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

	public String getContent()
	{
		return Content;
	}

	public void setContent(String content)
	{
		Content = content;
	}

	public Music getMusic()
	{
		return Music;
	}

	public void setMusic(Music music)
	{
		Music = music;
	}

	public int getArticleCount()
	{
		return ArticleCount;
	}

	public void setArticleCount(int articleCount)
	{
		ArticleCount = articleCount;
	}
}

/**
 * <Music> <Title><![CDATA[TITLE]]></Title>
 * <Description><![CDATA[DESCRIPTION]]></Description>
 * <MusicUrl><![CDATA[MUSIC_Url]]></MusicUrl>
 * <HQMusicUrl><![CDATA[HQ_MUSIC_Url]]></HQMusicUrl> </Music>
 * 
 * @author Administrator
 * 
 */
class Music
{
	private String Title;
	private String Description;
	private String MusicUrl;
	private String HQMusicUrl;

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

	public String getMusicUrl()
	{
		return MusicUrl;
	}

	public void setMusicUrl(String musicUrl)
	{
		MusicUrl = musicUrl;
	}

	public String getHQMusicUrl()
	{
		return HQMusicUrl;
	}

	public void setHQMusicUrl(String hQMusicUrl)
	{
		HQMusicUrl = hQMusicUrl;
	}

}

/**
 * <Articles> <item> <Title><![CDATA[title1]]></Title>
 * <Description><![CDATA[description1]]></Description>
 * <PicUrl><![CDATA[picurl]]></PicUrl> <Url><![CDATA[url]]></Url> </item> <item>
 * <Title><![CDATA[title]]></Title>
 * <Description><![CDATA[description]]></Description>
 * <PicUrl><![CDATA[picurl]]></PicUrl> <Url><![CDATA[url]]></Url> </item>
 * </Articles>
 * 
 * @author Administrator
 * 
 */
class Articles
{
	List<Item> items;

	public List<Item> getItems()
	{
		return items;
	}

	public void setItems(List<Item> items)
	{
		this.items = items;
	}
}
