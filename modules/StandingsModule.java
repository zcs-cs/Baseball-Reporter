package modules;
import data.BaseballData;
import java.util.Random;

public class StandingsModule extends ReportModule<BaseballData>
{
    public StandingsModule(BaseballData data) { super(data); }
    /**
     *  * * * * * * * *
     *  Claire Berman *
     *  * * * * * * * *
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

    String name;
    int function;
    Random generator = new Random();
    /**
     * Generate a sentence to be returned
     */
    public String generate()
    {
        setScores();
        int random = generator.nextInt(1);
        if (random == 0)
        {
            if (function == 1)
                return "Since the " + name + " won, the " + teamCDemonym + "remain in position " + teamCPosition + ", the " + teamDDemonym + " remain in position " + teamDPosition + ", the " + teamADemonym + " are in position " + teamAPosition + ", and the " + teamBDemonym + " are in position " + teamBPosition + ".";
            else if (function == 2)
                return "Since the " + name + " won, the " + teamCDemonym + "remain in position " + teamCPosition + ", the " + teamADemonym + " are in position " + teamAPosition + ", the " + teamDDemonym + " are in position " + teamDPosition + ", and the " + teamBDemonym + " are in position " + teamBPosition + ".";
            else if (function == 3)
                return "Since the " + name + " won, the " + teamADemonym + "are in position " + teamAPosition + ", the " + teamCDemonym + " are in position " + teamCPosition + ", the " + teamADemonym + " are in position " + teamAPosition + ", and the " + teamBDemonym + " are in position " + teamBPosition + ".";
            else if (function == 4)
                return "Although the " + name + " won, the standings continue to stay the same. The " + teamCDemonym + "remain in position " + teamCPosition + ", the " + teamDDemonym + " remain in position " + teamDPosition + ", the " + teamBDemonym + " remain in position " + teamBPosition + ", and the " + teamADemonym + " remain in position " + teamAPosition + ".";
            else if (function == 5)
                return "Since the " + name + " won, the " + teamCDemonym + "remain in position " + teamCPosition + ", the " + teamBDemonym + " are in position " + teamBPosition + ", the " + teamDDemonym + " are in position " + teamDPosition + ", and the " + teamADemonym + " are in position " + teamAPosition + ".";
            else if (function == 6)
                return "Since the " + name + " won, the " + teamBDemonym + "are in position " + teamBPosition + ", the " + teamCDemonym + " are in position " + teamCPosition + ", the " + teamDDemonym + " are in position " + teamDPosition + ", and the " + teamADemonym + " are in position " + teamAPosition + ".";
            else if (function == 7)
                return "The standings remained the same. Since the " + name + " won, the " + teamCDemonym + "remain in position " + teamCPosition + ", the " + teamDDemonym + " remain in position " + teamDPosition + ", the " + teamBDemonym + " are in position " + teamBPosition + ", and the " + teamADemonym + " are in position " + teamAPosition + ".";
            else
                return "The standings can't be found at this time.";
        }
        else
        {
            if (function == 1)
                return "The " + teamCDemonym + " stayed in place " + teamCPosition + ", the " + teamDDemonym + " stayed in place " + teamDPosition + ", the " + teamADemonym + " stand in place " + teamAPosition + ", and the " + teamBDemonym + " stand in place " + teamBPosition + ", since the " + name + " won.";
            else if (function == 2)
                return "The " + teamCDemonym + " stayed in place " + teamCPosition + ", the " + teamADemonym + " stand in place " + teamAPosition + ", the " + teamDDemonym + " stand in place " + teamDPosition + ", and the " + teamBDemonym + " stand in place " + teamBPosition + ", since the " + name + " won.";
            else if (function == 3)
                return "The " + teamADemonym + " stand in place " + teamAPosition + ", the " + teamCDemonym + " stand in place " + teamCPosition + ", the " + teamDDemonym + " stand in place " + teamDPosition + ", and the " + teamBDemonym + " stand in place " + teamBPosition + ", since the " + name + " won.";
            else if (function == 4)
                return "The " + teamCDemonym + " stayed in place " + teamCPosition + ", the " + teamDDemonym + " stayed in place " + teamDPosition + ", the " + teamBDemonym + " stand in place " + teamBPosition + ", and the " + teamADemonym + " stand in place " + teamAPosition + ", since the " + name + " won.";
            else if (function == 5)
                return "The " + teamCDemonym + " stayed in place " + teamCPosition + ", the " + teamBDemonym + " stand in place " + teamBPosition + ", the " + teamDDemonym + " stand in place " + teamDPosition + ", and the " + teamADemonym + " stand in place " + teamAPosition + ", since the " + name + " won.";
            else if (function == 6)
                return "The " + teamBDemonym + " stand in place " + teamBPosition + ", the " + teamCDemonym + " stand in place " + teamDPosition + ", the " + teamCDemonym + " stand in place " + teamDPosition + ", and the " + teamADemonym + " stand in place " + teamAPosition + ", since the " + name + " won.";
            else
                return "The standings are not available right now.";
        }
    }

    /**
     * Update wins, losses, and PCT based on score of game
     */
    private void setScores ()
    {
        if (teamAScore > teamBScore) //Indians won
        {
            name = teamADemonym;
            teamAWins += 1; //indians standings win
            teamBLosses += 1;
            teamAPCT = (int)((teamAWins*100 / (teamAWins + teamALosses))); //pctforindians
            teamBPCT = (int)((teamBWins*100 / (teamBWins + teamBLosses)));
        }
        else if (teamAScore < teamBScore) //Bats won
        {
            name = teamBDemonym;
            teamBWins += 1; //bats standings win
            teamALosses += 1;
            teamAPCT = (int)((teamAWins*100 / (teamAWins + teamALosses))); //pctforindians
            teamBPCT = (int)((teamBWins*100 / (teamBWins + teamBLosses)));
        }

        if (teamAPCT > teamBPCT)
        {
            teamAPosition = 3;
            teamBPosition = 4;
            function = 1;
            if (teamAPCT > teamDPCT)
            {
                teamAPosition = 2;
                teamDPosition = 3;
                function = 2;
                if (teamAPCT > teamCPCT)
                {
                    teamAPosition = 1;
                    teamCPosition = 2;
                    function = 3;
                }
            }
        }
        else if (teamBPCT > teamAPCT)
        {
            //Indians and Bats do not swith places
            function = 4;
            if (teamBPCT > teamDPCT)
            {
                teamBPosition = 2;
                teamDPosition = 3;
                function = 5;
                if (teamBPCT > teamCPCT)
                {
                    teamBPosition = 1;
                    teamCPosition = 2;
                    function = 6;
                }
            }
        }
        else
        {
            function = 7;
        }
    }

}