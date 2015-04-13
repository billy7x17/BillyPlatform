package com.Utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

public class Log4jListener implements ServletContextListener
{
	public static final String CONFIG_LOCATION_PARAM = "log4jConfigLocation";
	public static final String XML_FILE_EXTENSION = ".xml";

	public void contextDestroyed(ServletContextEvent event)
	{
		LogManager.shutdown();
	}

	public void contextInitialized(ServletContextEvent event)
	{

		String location = event.getServletContext().getInitParameter(
				CONFIG_LOCATION_PARAM);
		if(location != null)
		{
			if(!location.startsWith("/"))
			{
				location = "/" + location;
			}
			location = event.getServletContext().getRealPath(location);
			if(location.toLowerCase().endsWith(XML_FILE_EXTENSION))
			{
				DOMConfigurator.configure(location);
			}
			else
			{
				PropertyConfigurator.configure(location);
			}
		}
	}
}