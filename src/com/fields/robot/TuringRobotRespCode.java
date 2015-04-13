package com.fields.robot;

import java.io.Serializable;

public enum TuringRobotRespCode implements Serializable
{
	/**
	 * 文本
	 */
	text("100000"),
	/**
	 * 列车信息
	 */
	train("305000"),
	/**
	 * 航班信息
	 */
	flight("306000"),
	/**
	 * 网址
	 */
	link("200000"),
	/**
	 * 新闻
	 */
	news("302000"),
	/**
	 * 菜谱，视频，小说
	 */
	recipe("308000"),
	/**
	 * key长度错误
	 */
	error_key_length("40001"),
	/**
	 * key错误或账号未认证
	 */
	error_key_unauth("40003"),
	/**
	 * 当天次数用完
	 */
	error_times_runout("40004"),
	/**
	 * 暂不支持该功能
	 */
	error_not_support("40005"),
	/**
	 * 服务器升级中
	 */
	error_server_updating("40006"),
	/**
	 * 服务器数据格式异常
	 */
	error_server_wrong_data("40007");

	private String code;

	public String getCode()
	{
		return this.code;
	}

	private TuringRobotRespCode(String code)
	{
		this.code = code;
	}
}
