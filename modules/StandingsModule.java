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
        int random = generator.nextInt(1);
        if (random == 0)
        {
            if (function == 1)
                return "Since the " + name + " won, " + teamCDemonym + "are in position " + teamCPosition + ", " + teamDDemonym + " are in position " + teamDPosition + ", " + teamADemonym + " are in position " + teamAPosition + ", and " + teamBDemonym + " are in position " + teamBPosition + ".";
            else if (function == 2)
                return "Since the " + name + " won, " + teamCDemonym + "are in position " + teamCPosition + ", " + teamADemonym + " are in position " + teamAPosition + ", " + teamDDemonym + " are in position " + teamDPosition + ", and " + teamBDemonym + " are in position " + teamBPosition + ".";
            else if (function == 3)
                return "Since the " + name + " won, " + teamADemonym + "are in position " + teamAPosition + ", " + teamCDemonym + " are in position " + teamCPosition + ", " + teamADemonym + " are in position " + teamAPosition + ", and " + teamBDemonym + " are in position " + teamBPosition + ".";
            else if (function == 4)
                return "Since the " + name + " won, " + teamCDemonym + "are in position " + teamCPosition + ", " + teamDDemonym + " are in position " + teamDPosition + ", " + teamBDemonym + " are in position " + teamBPosition + ", and " + teamADemonym + " are in position " + teamAPosition + ".";
            else if (function == 5)
                return "Since the " + name + " won, " + teamCDemonym + "are in position " + teamCPosition + ", " + teamBDemonym + " are in position " + teamBPosition + ", " + teamDDemonym + " are in position " + teamDPosition + ", and " + teamADemonym + " are in position " + teamAPosition + ".";
            else if (function == 6)
                return "Since the " + name + " won, " + teamBDemonym + "are in position " + teamBPosition + ", " + teamCDemonym + " are in position " + teamCPosition + ", " + teamDDemonym + " are in position " + teamDPosition + ", and " + teamADemonym + " are in position " + teamAPosition + ".";
            else
                return "The standings can't be found at this time.";
        }
        else
        {
            if (function == 1)
                return teamCDemonym + " stand in place " + teamCPosition + ", " + teamDDemonym + " stand in place " + teamDPosition + ", " + teamADemonym + " stand in place " + teamAPosition + ", and " + teamBDemonym + " stand in place " + teamBPosition + ", since the " + name + " won.";
            else if (function == 2)
                return teamCDemonym + " stand in place " + teamCPosition + ", " + teamADemonym + " stand in place " + teamAPosition + ", " + teamDDemonym + " stand in place " + teamDPosition + ", and " + teamBDemonym + " stand in place " + teamBPosition + ", since the " + name + " won.";
            else if (function == 3)
                return teamADemonym + " stand in place " + teamAPosition + ", " + teamCDemonym + " stand in place " + teamCPosition + ", " + teamDDemonym + " stand in place " + teamDPosition + ", and " + teamBDemonym + " stand in place " + teamBPosition + ", since the " + name + " won.";
            else if (function == 4)
                return teamCDemonym + " stand in place " + teamCPosition + ", " + teamDDemonym + " stand in place " + teamDPosition + ", " + teamBDemonym + " stand in place " + teamBPosition + ", and " + teamADemonym + " stand in place " + teamAPosition + ", since the " + name + " won.";
            else if (function == 5)
                return teamCDemonym + " stand in place " + teamCPosition + ", " + teamBDemonym + " stand in place " + teamBPosition + ", " + teamDDemonym + " stand in place " + teamDPosition + ", and " + teamADemonym + " stand in place " + teamAPosition + ", since the " + name + " won.";
            else if (function == 6)
                return teamBDemonym + " stand in place " + teamBPosition + ", " + teamCDemonym + " stand in place " + teamDPosition + ", " + teamCDemonym + " stand in place " + teamDPosition + ", and " + teamADemonym + " stand in place " + teamAPosition + ", since the " + name + " won.";
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
            teamAPCT = (teamAWins / (teamAWins + teamALosses)) + 100; //pctforindians
            teamBPCT = (teamBWins / (teamBWins + teamBLosses)) + 100;
        }
        else if (teamAScore < teamBScore) //Bats won
        {
            name = teamBDemonym;
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

    /**
     * Find standings of each team based on PCT
     */
    private void standings()
    {
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
    }
}