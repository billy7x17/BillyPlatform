package com.test;

import java.sql.*;

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
					"jdbc:mysql://119.108.52.6:3306/billydata" , "root" ,
					"admin");
		}
		catch(SQLException e1)
		{
			result += "Error connecting with database!\t";
		}

		try
		{

			result += "Success connect Mysql server!\t";
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("select * from test");
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