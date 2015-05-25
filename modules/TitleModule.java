package modules;

import data.BaseballData;
import utilities.*;

public class TitleModule extends ReportModule<BaseballData>
{
    public TitleModule(BaseballData data) { super(data); }
    
    /**
     * Generates a title for a Baseball game report.
     */
    public String generate()
    {
        String winnerTeamDemonym, loserTeamDemonym, scores;
        // prep ~"[Team A]s [Defeat] [Team B]s" output //
        if (data.teamResult(data.teamA))
        {
            winnerTeamDemonym = data.teamDemonym(data.teamA);
            loserTeamDemonym = data.teamDemonym(data.teamB);
            scores = data.teamScore(data.teamA) + "–" + data.teamScore(data.teamB);
        }
        // prep ~"[Team B]s Defeat [Team A]s" output //
        else if (data.teamResult(data.teamB))
        {
            winnerTeamDemonym = data.teamDemonym(data.teamB);
            loserTeamDemonym = data.teamDemonym(data.teamA);
            scores = data.teamScore(data.teamB) + "–" + data.teamScore(data.teamA);
        }
        // return either "[Team A]s Tie [Team B]s" or versa //
        else
        {
            Boolean firstTeam = Random.binary();
            return data.teamDemonym(firstTeam)+" Tie "+data.teamDemonym(!firstTeam);
        }
        return winnerTeamDemonym+" Defeat "+loserTeamDemonym+" "+scores+"\n"+data.date() + "\n";
    }
}
