package com.functions;

import static com.Utils.Constants.ErrorMsg;
import static com.Utils.Constants.billy;
import static com.Utils.Constants.QQQ;
import static com.Utils.Constants.result;

import java.util.HashMap;
import java.util.Map;

import com.fields.RequestMsg;
import com.fields.ResponseMsg;

public class FirstVictory
{
	private static Map<String , Long> FV;

	public String setFVtime(RequestMsg reqMsg)
	{
		return "设置成功！\n虽然我想这么说，但是~仍在开发中哦~";
	}

	public String getFVtime(RequestMsg reqMsg)
	{
		return "仍在开发中哦~";
	}
}
