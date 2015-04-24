package com.fields.robot;

public class Recipe extends Text<Recipe.RecipeItem>
{
	private static final long serialVersionUID = 834882716421086442L;

	public static class RecipeItem
	{
		private String name;

		private String info;

		private String detailurl;

		private String icon;

		public String getName()
		{
			return name;
		}

		public void setName(String name)
		{
			this.name = name;
		}

		public String getInfo()
		{
			return info;
		}

		public void setInfo(String info)
		{
			this.info = info;
		}

		public String getDetailurl()
		{
			return detailurl;
		}

		public void setDetailurl(String detailurl)
		{
			this.detailurl = detailurl;
		}

		public String getIcon()
		{
			return icon;
		}

		public void setIcon(String icon)
		{
			this.icon = icon;
		}
	}
}
