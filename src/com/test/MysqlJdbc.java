package com.test;

import java.sql.*;

import com.sina.sae.util.SaeUserInfo;

public class MysqlJdbc
{
	public String mysqlTest()
	{
		String result = new String();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			result += "Success loading Mysql Driver!\t";
		}
		catch(Exception e)
		{
			result += "Error loading Mysql Driver!\t";
			e.printStackTrace();
		}

		Connection connect = null;
		try
		{
			connect = DriverManager.getConnection(
					"jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_billytest" ,
					SaeUserInfo.getAccessKey() , SaeUserInfo.getSecretKey());
		}
		catch(SQLException e1)
		{
			result += "Error connecting with database!\t";
		}

		try
		{

			result += "Success connect Mysql server!\t";
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM  `portal_goods_t` LIMIT 0 , 30");
			while(rs.next())
			{
				result += rs.getString("name");
			}
		}
		catch(Exception e)
		{

			e.printStackTrace();
			result += "get data error!";
		}

		return result;
	}
}