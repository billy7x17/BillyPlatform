package com.fields.robot;

/**
 * <b>Application describing: 火车班次信息bean</b> <br>
 * 
 * @author <a href="mailto:billy7x17@gmail.com">Billy </a>
 * @version 1.0.0 2015年4月16日 上午10:36:06
 */
public class Train extends Text<Train.trainFlight>
{

	private static final long serialVersionUID = -8564958822839098267L;

	public static class trainFlight
	{
		private String trainnum;

		private String start;

		private String terminal;

		private String starttime;

		private String endtime;

		private String detailurl;

		private String icon;

		/**
		 * 获取trainnum字段数据
		 * 
		 * @return Returns the trainnum.
		 */
		public String getTrainnum()
		{
			return trainnum;
		}

		/**
		 * 设置trainnum字段数据
		 * 
		 * @param trainnum
		 *            The trainnum to set.
		 */
		public void setTrainnum(String trainnum)
		{
			this.trainnum = trainnum;
		}

		/**
		 * 获取start字段数据
		 * 
		 * @return Returns the start.
		 */
		public String getStart()
		{
			return start;
		}

		/**
		 * 设置start字段数据
		 * 
		 * @param start
		 *            The start to set.
		 */
		public void setStart(String start)
		{
			this.start = start;
		}

		/**
		 * 获取terminal字段数据
		 * 
		 * @return Returns the terminal.
		 */
		public String getTerminal()
		{
			return terminal;
		}

		/**
		 * 设置terminal字段数据
		 * 
		 * @param terminal
		 *            The terminal to set.
		 */
		public void setTerminal(String terminal)
		{
			this.terminal = terminal;
		}

		/**
		 * 获取starttime字段数据
		 * 
		 * @return Returns the starttime.
		 */
		public String getStarttime()
		{
			return starttime;
		}

		/**
		 * 设置starttime字段数据
		 * 
		 * @param starttime
		 *            The starttime to set.
		 */
		public void setStarttime(String starttime)
		{
			this.starttime = starttime;
		}

		/**
		 * 获取endtime字段数据
		 * 
		 * @return Returns the endtime.
		 */
		public String getEndtime()
		{
			return endtime;
		}

		/**
		 * 设置endtime字段数据
		 * 
		 * @param endtime
		 *            The endtime to set.
		 */
		public void setEndtime(String endtime)
		{
			this.endtime = endtime;
		}

		/**
		 * 获取detailurl字段数据
		 * 
		 * @return Returns the detailurl.
		 */
		public String getDetailurl()
		{
			return detailurl;
		}

		/**
		 * 设置detailurl字段数据
		 * 
		 * @param detailurl
		 *            The detailurl to set.
		 */
		public void setDetailurl(String detailurl)
		{
			this.detailurl = detailurl;
		}

		/**
		 * 获取icon字段数据
		 * 
		 * @return Returns the icon.
		 */
		public String getIcon()
		{
			return icon;
		}

		/**
		 * 设置icon字段数据
		 * 
		 * @param icon
		 *            The icon to set.
		 */
		public void setIcon(String icon)
		{
			this.icon = icon;
		}
	}
}
