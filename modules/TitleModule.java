package modules;

import data.BaseballData;

public class TitleModule extends ReportModule<BaseballData>
{
	/**
	 * Generates a title for a Baseball game report.
	 */
	public String generate()
	{
		return "The game was a great success!";
	}
}