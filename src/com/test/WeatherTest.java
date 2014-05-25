package com.test;

import java.io.IOException;

import com.functions.WeatherQuery;

public class WeatherTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		WeatherQuery wq = new WeatherQuery();
		
		try
		{
			System.out.println(wq.weatherQuery("沈阳" , 5));
		}
		catch(IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
