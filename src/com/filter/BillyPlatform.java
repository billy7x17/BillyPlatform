package com.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Utils.SHA1;
import com.Utils.XMLUtil;
import com.fields.RequestMsg;
import com.fields.ResponseMsg;
import com.functions.Choices;

public class BillyPlatform extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String TOKEN = "billy119";

	private Choices choice = new Choices();

	/**
	 * doGet()方法 专门用来做微信验证
	 */

	public void doGet(HttpServletRequest request , HttpServletResponse response)
			throws ServletException , IOException
	{
		// 微信加密签名
		String signature = request.getParameter("signature");
		// 随机字符串
		String echostr = request.getParameter("echostr");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");

		String[] str =
		{TOKEN , timestamp , nonce};
		Arrays.sort(str); // 字典序排序
		String bigStr = str[0] + str[1] + str[2];
		// SHA1加密
		String digest = new SHA1().getDigestOfString(bigStr.getBytes())
				.toLowerCase();

		// 确认请求来至微信
		if(digest.equals(signature))
		{
			response.getWriter().print(echostr);
		}
	}

	/**
	 * doPost()方法 用来完成功能: 目前规则为 用户输入 选项:内容(例如, 1:abc)
	 */

	protected void doPost(HttpServletRequest req , HttpServletResponse resp)
			throws ServletException , IOException
	{

		long curTime = new Date().getTime();

		/* 编码方式 */
		req.setCharacterEncoding("UTF-8");
		// resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		/* 输入 */
		RequestMsg reqMsg = (RequestMsg)XMLUtil.Input(req);
		/* 功能实现 */
		ResponseMsg respMsg = choice.choose(reqMsg);

		long now = new Date().getTime();

		System.out.println("经过服务器总共  占用了 " + ( now - curTime ) + " 毫秒时间");

		/* 输出 */
		XMLUtil.Output(resp , respMsg);
	}

	/**
	 * 去掉头部0
	 * 
	 * @param str
	 * @return
	 */
	/*
	 * private String removeHeadZero(String str) { if(str.startsWith("0")) { str
	 * = str.substring(1); if(str.startsWith("0")) { return removeHeadZero(str);
	 * } else { return str; } } else { return str; } }
	 */
}
