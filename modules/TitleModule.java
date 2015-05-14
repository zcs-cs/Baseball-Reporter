package modules;

import data.BaseballData;

public class TitleModule extends ReportModule<BaseballData>
{
	/**
	 * Generates a title for a Baseball game report.
	 */
	public String generate()
	{
	    //Please see the interface data/ReportData for method listings.
	    return "The game was a great success with " + data.innings() +  " innings!";
	    //Previous work below.
		//return "The game was a great success with " + data.getInnings() +  " innings!";
	}
}