package com.fields.robot;

public class Flight extends Text<Flight.FlightItem>
{
	private static final long serialVersionUID = 2795879986783307616L;

	public static class FlightItem
	{

		private String flight;

		private String route;

		private String starttime;

		private String endtime;

		private String state;

		private String detailurl;

		private String icon;

		public String getFlight()
		{
			return flight;
		}

		public void setFlight(String flight)
		{
			this.flight = flight;
		}

		public String getRoute()
		{
			return route;
		}

		public void setRoute(String route)
		{
			this.route = route;
		}

		public String getStarttime()
		{
			return starttime;
		}

		public void setStarttime(String starttime)
		{
			this.starttime = starttime;
		}

		public String getEndtime()
		{
			return endtime;
		}

		public void setEndtime(String endtime)
		{
			this.endtime = endtime;
		}

		public String getState()
		{
			return state;
		}

		public void setState(String state)
		{
			this.state = state;
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
