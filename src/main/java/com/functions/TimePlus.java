package com.functions;

public class TimePlus
{
	public String plus(String time1 , String time2)
	{
		if(time1.length() == 3)
			time1 = "0" + time1;

		if(time2.length() == 3)
			time2 = "0" + time2;

		Integer h1 , h2 , m1 , m2 , h , m;

		boolean mCarry = false , hCarry = false;

		h1 = Integer.valueOf(time1.substring(0 , 2));

		h2 = Integer.valueOf(time2.substring(0 , 2));

		m1 = Integer.valueOf(time1.substring(2 , 4));

		m2 = Integer.valueOf(time2.substring(2 , 4));

		m = m1 + m2;

		if(m >= 60)
		{
			mCarry = true;
			m -= 60;
		}

		h = h1 + h2 + ( mCarry ? 1 : 0 );

		if(h >= 24)
		{
			hCarry = true;
			h -= 24;
		}

		String resultTime = ( hCarry ? "次日 " : "当日 " )
				+ ( h < 10 ? "0" + h : h ) + ":" + ( m < 10 ? "0" + m : m );

		return resultTime;
	}

	public String minus(String time1 , String time2)
	{
		if(time1.length() == 3)
			time1 = "0" + time1;

		if(time2.length() == 3)
			time2 = "0" + time2;

		Integer h1 , h2 , m1 , m2 , h , m;

		boolean mCarry = false , hCarry = false;

		h1 = Integer.valueOf(time1.substring(0 , 2));

		h2 = Integer.valueOf(time2.substring(0 , 2));

		m1 = Integer.valueOf(time1.substring(2 , 4));

		m2 = Integer.valueOf(time2.substring(2 , 4));

		m = m1 - m2;

		if(m < 0)
		{
			mCarry = true;
			m += 60;
		}

		h = h1 - h2 - ( mCarry ? 1 : 0 );

		if(h < 0)
		{
			hCarry = true;
			h += 24;
		}

		String resultTime = ( hCarry ? "前一天  " : "当日 " )
				+ ( h < 10 ? "0" + h : h ) + ":" + ( m < 10 ? "0" + m : m );

		return resultTime;
	}

}
