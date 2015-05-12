package data;

/**
 * Contains a collection of data to be accessed by ReportModules
 */
public interface ReportData
{
	public abstract String getGameStatistic(String key);
	public abstract int getGameStatisticInt(String key);
	
	public abstract String getTeamStatistic(boolean team, String key);
	public abstract int getTeamStatisticInt(boolean team, String key);
 	
	public abstract String getPlayerStatistic(boolean team, String key, String player);
	public abstract int getPlayerStatisticInt(boolean team, String key, String player);
}