package com.functions;

import java.io.IOException;
import java.util.Date;

import com.fields.RequestMsg;
import com.fields.ResponseMsg;
import com.functions.handler.impl.HandlerImpl;

public class Choices
{
	private Handler handler = new HandlerImpl();

	public ResponseMsg choose(RequestMsg reqMsg) throws IOException
	{
		ResponseMsg respMsg = new ResponseMsg();

		switch(reqMsg.getMsgType())
		{
			case event:
				respMsg = handler.processEventTypeMsg(reqMsg);
				break;
			case text:
			case news:
				respMsg = handler.processTextTypeMsg(reqMsg);
				break;
			case image:
				respMsg = handler.processImageTypeMsg(reqMsg);
				break;
			case voice:
			case music:
				respMsg = handler.processVoiceTypeMsg(reqMsg);
				break;
			case link:
				respMsg = handler.processLinkTypeMsg(reqMsg);
				break;
			case location:
				respMsg = handler.processLocationTypeMsg(reqMsg);
				break;
			default:
				break;
		}
		respMsg.setCreateTime(new Date().getTime());
		respMsg.setToUserName(reqMsg.getFromUserName());
		respMsg.setFromUserName(reqMsg.getToUserName());

		return respMsg;
	}
}
