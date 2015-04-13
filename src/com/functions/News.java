package com.functions;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.fields.Item;

public class News
{
	private Properties p;

	public List<Item> showNews()
	{
		p = new Properties();

		InputStream in = getClass().getResourceAsStream("sourse.properties");
		try
		{
			p.load(in);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

		List<Item> list = new ArrayList<Item>();

		Item item1 = new Item();

		item1.setTitle(p.getProperty("Item1.title"));
		item1.setDescription(p.getProperty("Item1.description"));
		item1.setUrl(p.getProperty("Item1.url"));
		item1.setPicUrl(p.getProperty("Item1.picUrl"));

		list.add(item1);

		Item item2 = new Item();

		item2.setTitle(p.getProperty("Item2.title"));
		item2.setDescription(p.getProperty("Item2.description"));
		item2.setUrl(p.getProperty("Item2.url"));
		item2.setPicUrl(p.getProperty("Item2.picUrl"));

		list.add(item2);

		Item item3 = new Item();

		item3.setTitle(p.getProperty("Item3.title"));
		item3.setDescription(p.getProperty("Item3.description"));
		item3.setUrl(p.getProperty("Item3.url"));
		item3.setPicUrl(p.getProperty("Item3.picUrl"));

		list.add(item3);

		return list;
	}
}
