package modules;

import data.BaseballData;

public class TitleModule extends ReportModule<BaseballData>
{
	public String generate()
	{
		return "The game was a great success!";
	}
}