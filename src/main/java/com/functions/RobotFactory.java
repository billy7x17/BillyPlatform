package com.functions;

import com.Utils.Constants;
import com.functions.robot.TuringRobot;

public class RobotFactory
{
	public static Robot getRobot()
	{
		String choice = (String)Constants.prop.get("robotChoice");

		if("1".equals(choice))
		{
			return new TuringRobot();
		}
		return null;
	}
}
