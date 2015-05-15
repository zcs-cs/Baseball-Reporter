package modules;

import data.BaseballData;
import utilities.*;

public class TitleModule extends ReportModule<BaseballData>
{
	/**
	 * Generates a title for a Baseball game report.
	 */
	public String generate()
	{
	    String winnerTeamDemonym, loserTeamDemonym, scores;
	    int scoreDifference;
	    // prep ~"[Team A]s [Defeat] [Team B]s" output //
	    if (data.teamResult(true))
	    {
	    	winnerTeamDemonym = data.teamDemonym(true);
	    	loserTeamDemonym = data.teamDemonym(false);
	    	scoreDifference = data.teamScore(true) - data.teamScore(false);
	    	scores = data.teamScore(true)+"–"+data.teamScore(false);
	    }
	    // prep ~"[Team B]s Defeat [Team A]s" output //
	    else if (data.teamResult(false))
	    {
	    	winnerTeamDemonym = data.teamDemonym(false);
	    	loserTeamDemonym = data.teamDemonym(true);
	    	scoreDifference = data.teamScore(false) - data.teamScore(true);
	    	scores = data.teamScore(false)+"–"+data.teamScore(true);
	    }
	    // return either "[Team A]s Tie [Team B]s" or versa //
	    else
	    {
	    	Boolean firstTeam = Random.binary();
	    	return data.teamDemonym(firstTeam)+" Tie "+data.teamDemonym(!firstTeam);
	    }
	    return winnerTeamDemonym+" Defeat "+loserTeamDemonym+" "+scores+"\n"+data.date();
	}
}
