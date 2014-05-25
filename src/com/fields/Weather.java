package com.fields;

public class Weather
{
	private String city;

	private String status1; // 天气情况
	private String status2; // 天气情况
	private String figure1; // 天气情况拼音
	private String figure2; // 天气情况拼音
	private String direction1; // 风向
	private String direction2; // 风向
	private String power1; // 风力
	private String power2; // 风力
	private String temperature1; // 温度
	private String temperature2; // 温度
	private String ssd; // 体感指数数值
	private String ssd_l; // 体感度指数
	private String ssd_s; // 体感度指数说明
	private String tgd1; // 体感温度
	private String tgd2; // 体感温度
	private String zwx; // 紫外线指数数值
	private String zwx_l; // 紫外线指数
	private String zwx_s; // 紫外线指数说明
	private String ktk; // 空调指数数值
	private String ktk_l; // 空调指数
	private String ktk_s; // 空调指数说明
	private String pollution; // 污染指数数值
	private String pollution_l; // 污染物扩散条件
	private String pollution_s; // 污染指数说明
	private String xcz; // 洗车指数数值
	private String xcz_l; // 洗车指数
	private String xcz_s; // 洗车指数说明
	private String chy; // 穿衣指数数值
	private String chy_l; // 穿衣指数
	private String chy_shuoming;// 穿衣指数说明
	private String gm; // 感冒指数数值
	private String gm_l; // 感冒指数
	private String gm_s; // 感冒指数说明
	private String yd; // 运动指数数值
	private String yd_l; // 运动指数
	private String yd_s; // 运动指数说明
	private String zho;
	private String zho_l;
	private String zho_shuoming;
	private String diy;
	private String diy_l;
	private String diy_shuoming;
	private String fas;
	private String fas_l;
	private String fas_shuoming;
	private String savedate_weather;// 天气预报日期
	private String savedate_life; // 生活日期
	private String savedate_zhishu; // 指数日期

	public String getSsd()
	{
		return ssd;
	}

	public void setSsd(String ssd)
	{
		this.ssd = ssd;
	}

	public String getSsd_l()
	{
		return ssd_l;
	}

	public void setSsd_l(String ssdL)
	{
		ssd_l = ssdL;
	}

	public String getSsd_s()
	{
		return ssd_s;
	}

	public void setSsd_s(String ssdS)
	{
		ssd_s = ssdS;
	}

	public String getZwx()
	{
		return zwx;
	}

	public void setZwx(String zwx)
	{
		this.zwx = zwx;
	}

	public String getZwx_l()
	{
		return zwx_l;
	}

	public void setZwx_l(String zwxL)
	{
		zwx_l = zwxL;
	}

	public String getZwx_s()
	{
		return zwx_s;
	}

	public void setZwx_s(String zwxS)
	{
		zwx_s = zwxS;
	}

	public String getKtk()
	{
		return ktk;
	}

	public void setKtk(String ktk)
	{
		this.ktk = ktk;
	}

	public String getKtk_l()
	{
		return ktk_l;
	}

	public void setKtk_l(String ktkL)
	{
		ktk_l = ktkL;
	}

	public String getKtk_s()
	{
		return ktk_s;
	}

	public void setKtk_s(String ktkS)
	{
		ktk_s = ktkS;
	}

	public String getPollution()
	{
		return pollution;
	}

	public void setPollution(String pollution)
	{
		this.pollution = pollution;
	}

	public String getPollution_l()
	{
		return pollution_l;
	}

	public void setPollution_l(String pollutionL)
	{
		pollution_l = pollutionL;
	}

	public String getPollution_s()
	{
		return pollution_s;
	}

	public void setPollution_s(String pollutionS)
	{
		pollution_s = pollutionS;
	}

	public String getXcz()
	{
		return xcz;
	}

	public void setXcz(String xcz)
	{
		this.xcz = xcz;
	}

	public String getXcz_l()
	{
		return xcz_l;
	}

	public void setXcz_l(String xczL)
	{
		xcz_l = xczL;
	}

	public String getXcz_s()
	{
		return xcz_s;
	}

	public void setXcz_s(String xczS)
	{
		xcz_s = xczS;
	}

	public String getChy()
	{
		return chy;
	}

	public void setChy(String chy)
	{
		this.chy = chy;
	}

	public String getChy_l()
	{
		return chy_l;
	}

	public void setChy_l(String chyL)
	{
		chy_l = chyL;
	}

	public String getChy_shuoming()
	{
		return chy_shuoming;
	}

	public void setChy_shuoming(String chyShuoming)
	{
		chy_shuoming = chyShuoming;
	}

	public String getGm()
	{
		return gm;
	}

	public void setGm(String gm)
	{
		this.gm = gm;
	}

	public String getGm_l()
	{
		return gm_l;
	}

	public void setGm_l(String gmL)
	{
		gm_l = gmL;
	}

	public String getGm_s()
	{
		return gm_s;
	}

	public void setGm_s(String gmS)
	{
		gm_s = gmS;
	}

	public String getYd()
	{
		return yd;
	}

	public void setYd(String yd)
	{
		this.yd = yd;
	}

	public String getYd_l()
	{
		return yd_l;
	}

	public void setYd_l(String ydL)
	{
		yd_l = ydL;
	}

	public String getYd_s()
	{
		return yd_s;
	}

	public void setYd_s(String ydS)
	{
		yd_s = ydS;
	}

	public String getZho()
	{
		return zho;
	}

	public void setZho(String zho)
	{
		this.zho = zho;
	}

	public String getZho_l()
	{
		return zho_l;
	}

	public void setZho_l(String zhoL)
	{
		zho_l = zhoL;
	}

	public String getZho_shuoming()
	{
		return zho_shuoming;
	}

	public void setZho_shuoming(String zhoShuoming)
	{
		zho_shuoming = zhoShuoming;
	}

	public String getDiy()
	{
		return diy;
	}

	public void setDiy(String diy)
	{
		this.diy = diy;
	}

	public String getDiy_l()
	{
		return diy_l;
	}

	public void setDiy_l(String diyL)
	{
		diy_l = diyL;
	}

	public String getDiy_shuoming()
	{
		return diy_shuoming;
	}

	public void setDiy_shuoming(String diyShuoming)
	{
		diy_shuoming = diyShuoming;
	}

	public String getFas()
	{
		return fas;
	}

	public void setFas(String fas)
	{
		this.fas = fas;
	}

	public String getFas_l()
	{
		return fas_l;
	}

	public void setFas_l(String fasL)
	{
		fas_l = fasL;
	}

	public String getFas_shuoming()
	{
		return fas_shuoming;
	}

	public void setFas_shuoming(String fasShuoming)
	{
		fas_shuoming = fasShuoming;
	}

	public String getSavedate_weather()
	{
		return savedate_weather;
	}

	public void setSavedate_weather(String savedateWeather)
	{
		savedate_weather = savedateWeather;
	}

	public String getSavedate_life()
	{
		return savedate_life;
	}

	public void setSavedate_life(String savedateLife)
	{
		savedate_life = savedateLife;
	}

	public String getSavedate_zhishu()
	{
		return savedate_zhishu;
	}

	public void setSavedate_zhishu(String savedateZhishu)
	{
		savedate_zhishu = savedateZhishu;
	}

	public String getStatus1()
	{
		return status1;
	}

	public void setStatus1(String status1)
	{
		this.status1 = status1;
	}

	public String getStatus2()
	{
		return status2;
	}

	public void setStatus2(String status2)
	{
		this.status2 = status2;
	}

	public String getFigure1()
	{
		return figure1;
	}

	public void setFigure1(String figure1)
	{
		this.figure1 = figure1;
	}

	public String getFigure2()
	{
		return figure2;
	}

	public void setFigure2(String figure2)
	{
		this.figure2 = figure2;
	}

	public String getDirection1()
	{
		return direction1;
	}

	public void setDirection1(String direction1)
	{
		this.direction1 = direction1;
	}

	public String getDirection2()
	{
		return direction2;
	}

	public void setDirection2(String direction2)
	{
		this.direction2 = direction2;
	}

	public String getPower1()
	{
		return power1;
	}

	public void setPower1(String power1)
	{
		this.power1 = power1;
	}

	public String getPower2()
	{
		return power2;
	}

	public void setPower2(String power2)
	{
		this.power2 = power2;
	}

	public String getTemperature1()
	{
		return temperature1;
	}

	public void setTemperature1(String temperature1)
	{
		this.temperature1 = temperature1;
	}

	public String getTemperature2()
	{
		return temperature2;
	}

	public void setTemperature2(String temperature2)
	{
		this.temperature2 = temperature2;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getTgd1()
	{
		return tgd1;
	}

	public void setTgd1(String tgd1)
	{
		this.tgd1 = tgd1;
	}

	public String getTgd2()
	{
		return tgd2;
	}

	public void setTgd2(String tgd2)
	{
		this.tgd2 = tgd2;
	}
}
