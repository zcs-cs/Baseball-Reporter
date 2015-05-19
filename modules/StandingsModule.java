package modules;
import data.BaseballData;
import java.util.Random;

public class StandingsModule extends ReportModule<BaseballData>
{
     public StandingsModule(BaseballData data) { super(data); }
    /**
     *  * * * * * *
     * Incomplete *
     *  * * * * * *
     */
    
    int teamAScore = data.teamScore(true);
    int teamBScore = data.teamScore(false);
    
    int teamAWins = data.teamStandingsWins(true);
    int teamBWins = data.teamStandingsWins(false);
    
    int teamALosses = data.teamStandingsLosses(true);
    int teamBLosses = data.teamStandingsLosses(false);
    
    int teamAPCT = data.teamStandingsPCT(true);
    int teamBPCT = data.teamStandingsPCT(false);
    int teamCPCT = data.otherTeamStandingsPCT(true);
    int teamDPCT = data.otherTeamStandingsPCT(false);
    
    int teamAPosition = data.teamStandingsPosition(true);
    int teamBPosition = data.teamStandingsPosition(false);
    int teamCPosition = data.otherTeamStandingsPosition(true);
    int teamDPosition = data.otherTeamStandingsPosition(false);
    
    String teamADemonym = data.teamDemonym(true); //Indians
    String teamBDemonym = data.teamDemonym(false); //Bats
    String teamCDemonym = data.otherTeamDemonym(true); //Hens
    String teamDDemonym = data.otherTeamDemonym(false); //Clippers
    
    int function;
    Random generator = new Random();
    
    public String generate()
    {
        int random = generator.nextInt(1);
        if (random == 0)
        {
            if (function == 1)
                return "The Indians are now in position " + teamAPosition + "and the Bats are in position " + teamBPosition + ".";
            else if (function == 2)
                return "";
            else
                return "The standings can't be found at this time.";
        }
        else
        {
            if (function == 1)
                return "";
            else if (function == 2)
                return "";
            else
                return "The standings are not available right now.";
        }
    }

    private void setScores ()
    {
        if (teamAScore > teamBScore) //Indians won
        {
            teamAWins += 1; //indians standings win
            teamBLosses += 1;
            teamAPCT = (teamAWins / (teamAWins + teamALosses)) + 100; //pctforindians
            teamBPCT = (teamBWins / (teamBWins + teamBLosses)) + 100;
        }
        else if (teamAScore < teamBScore) //Bats won
        {
            teamBWins += 1; //indians standings win
            teamALosses += 1;
            teamAPCT = (teamAWins / (teamAWins + teamALosses)) + 100; //pctforindians
            teamBPCT = (teamBWins / (teamBWins + teamBLosses)) + 100;
        }
        else //tied
        {
            teamAPCT = (teamAWins / (teamAWins + teamALosses)) + 100; //pctforindians
            teamBPCT = (teamBWins / (teamBWins + teamBLosses)) + 100;
        }
    }

    private void standings()
    {
        if (teamAPCT > teamBPCT)
        {
            teamAPosition = 3;
            teamBPosition = 4;
            if (teamAPCT > teamDPCT)
            {
                teamAPosition = 2;
                teamDPosition = 3;
                if (teamAPCT > teamCPCT)
                {
                    teamAPosition = 1;
                    teamCPosition = 2;
                }
            }
            function = 1;
        }
        else if (teamBPCT > teamAPCT)
        {
            //Indians and Bats do not swith places
            if (teamBPCT > teamDPCT)
            {
                teamBPosition = 2;
                teamDPosition = 3;
                if (teamBPCT > teamCPCT)
                {
                    teamBPosition = 1;
                    teamCPosition = 2;
                }
            }
            function = 2;
        }
    }
}