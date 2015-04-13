package com.test;

import java.io.IOException;
import com.fields.Item;
import com.fields.RequestMsg;
import com.fields.ResponseMsg;
import com.functions.Choices;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Test1
{

	public static void main(String[] args)
	{

		ResponseMsg oms = new ResponseMsg();
		XStream xs = new XStream(new DomDriver());
		xs.alias("xml" , RequestMsg.class);
		String xmlMsg = "<xml><ToUserName><![CDATA[gh_6c0582d6aaba]]></ToUserName>"
				+ "<FromUserName><![CDATA[olQyqjomqevt-4ZeJRDga9MpSk_g]]></FromUserName>"
				+ "<CreateTime>1371629632</CreateTime>"
				+ "<MsgType><![CDATA[text]]></MsgType>"
				+ "<Content><![CDATA[0]]></Content>"
				+ "<MsgId>5891104411664515122</MsgId></xml>";
		RequestMsg msg = (RequestMsg)xs.fromXML(xmlMsg);

		Choices choose = new Choices();

		try
		{
			oms = choose.choose(msg);
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}

		System.out.println(oms.getContent());

		XStream xs2 = new XStream(new DomDriver());
		xs2.alias("xml" , ResponseMsg.class);
		xs2.alias("item" , Item.class);
		try
		{
			System.out.println(xs2.toXML(oms));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
