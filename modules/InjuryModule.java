 
import data.*;
import utilities.*;
public class InjuryModule extends ReportModule<BaseballData>
{
    public String generate()
    {
        end = "";
        String[] teamAPlayersNames = data.teamPlayersNames(true);
        String[] teamBPlayersNames = data.teamPlayersNames(false);
        int[][] teamAPlayersInjuriesGamesMissed = data.teamPlayersInjuriesGamesMissed(true);
        int[][] teamBPlayersInjuriesGamesMissed = data.teamPlayersInjuriesGamesMissed(false);
        String[][] teamAPlayersInjuriesTypes = data.teamPlayersInjuriesTypes(true);
        String[][] teamBPlayersInjuriesTypes = data.teamPlayersInjuriesTypes(false);
        String[][] teamAPlayersInjuriesLocations = data.teamPlayersInjuriesLocations(true);
        String[][] teamBPlayersInjuriesLocations = data.teamPlayersInjuriesLocations(false);
        String name = "";
        String type = "";
        String location = "";
        int timeOut = 0;
        for(int i = 0; i < teamAPlayersNames.length; i++)
        {
            name = "";
            type = "";
            location = "";
            timeOut = 0;
            if(teamAPlayersInjuriesGamesMissed[i] != null)
            {
                for(int j = 0; j < teamAPlayersInjuriesGamesMissed[i].length; j++)
                {
                    name = teamAPlayersNames[i];
                    timeOut = teamAPlayersInjuriesGamesMissed[i][j];
                    type = teamAPlayersInjuriesTypes[i][j];
                    location = teamAPlayersInjuriesLocations[i][j];
                    end += reportInjury(name, type, location, timeOut);
                }
            }
        }
        for(int i = 0; i < teamBPlayersNames.length; i++)
        {
            name = "";
            type = "";
            location = "";
            timeOut = 0;
            if(teamBPlayersInjuriesGamesMissed[i] != null)
            {
                for(int j = 0; j < teamBPlayersInjuriesGamesMissed[i].length; j++)
                {
                    name = teamBPlayersNames[i];
                    timeOut = teamBPlayersInjuriesGamesMissed[i][j];
                    type = teamBPlayersInjuriesTypes[i][j];
                    location = teamBPlayersInjuriesLocations[i][j];
                    end += reportInjury(name, type, location, timeOut);
                }
            }
        }
        return end;
    }
    private static String randomName(String first, String last, boolean capital)
    {
        int rand = (int)(Math.random() * 4);
        if(rand == 0)
        {
            return first;
        }
        else if(rand == 1)
        {
            return last;
        }
        else if(rand == 2)
        {
            return first + " " + last;
        }
        else
        {
            if(capital)
            {
                return "He";
            }
            else
            {
                return "he";
            }
        }
    }
    public static String reportInjury(String name, String type, String location, int timeOut)
    {
        String first = name.substring(0, name.indexOf(" "));
        String last = name.substring(name.indexOf(" ") + 1, name.length());
        String end = "";
        int rand = (int)(Math.random() * 4);
        if(rand == 0)
        {
            end += ("As for injuries, " + randomName(first, last, false) + " " +  type + " his " + location + ".");
        }
        else if(rand == 1)
        {
            end += (randomName(first, last, true) + " " +  type + " his " + location + ".");
        }
        else if(rand == 2)
        {
            end += (randomName(first, last, true) + " got hurt in the game. He " + type + " his " + location + ".");
        }
        else if(rand == 3)
        {
            end += ("Unfortunately, " + randomName(first, last, false) + " " + type + " his " + location + ".");
        }
        rand = (int)(Math.random() * 2);
        if(rand == 0)
        {
            end += (" " + randomName(first, last, true) + " will be out for " + timeOut + " games.");
        }
        else
        {
            end += (" The number of games " + randomName(first , last, false) + " will be out for is " + timeOut + ". ");
        }
        return end;
    }
}