package com.fields.robot;

/**
 * <b>Application describing: 图灵机器人的图文信息bean</b> <br>
 * 
 * @author <a href="mailto:billy7x17@gmail.com">Billy </a>
 * @version 1.0.0 2015年4月16日 上午9:14:47
 */
public class News extends Text<News.NewsItem>
{
	private static final long serialVersionUID = 3732997917689729579L;

	public static class NewsItem
	{
		/**
		 * 标题
		 */
		private String article;

		/**
		 * 来源
		 */
		private String source;

		/**
		 * 详情url
		 */
		private String detailurl;

		/**
		 * 图标地址
		 */
		private String icon;

		public String getArticle()
		{
			return article;
		}

		public void setArticle(String article)
		{
			this.article = article;
		}

		public String getSource()
		{
			return source;
		}

		public void setSource(String source)
		{
			this.source = source;
		}

		public String getDetailurl()
		{
			return detailurl;
		}

		public void setDetailurl(String detailurl)
		{
			this.detailurl = detailurl;
		}

		public String getIcon()
		{
			return icon;
		}

		public void setIcon(String icon)
		{
			this.icon = icon;
		}
	}

}
