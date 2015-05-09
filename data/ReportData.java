/* Progress..
  * there is old importation and calling of this class in Converter of the converters package that should probably get removed
  * we don't need injury data in the input JSON 'data.json', as there were no injuries at the game we attended
  * include data for Team B (functionality for such retrieval is already developed)
  * include additional data and include functionality for its retrieval
  * how should the index for a team run statistic be determined?
 */

package data;

import org.json.*;

// ReportData:
//  > intended to provide resource methods for Modules' generation methods
//  > capable of interpreting a JSON object
//  > created by being fed the intended JSON object
//  = contains general methods for accessing each data category
//  + provides specific and boolean-specified methods for accessing each JSON value (datum) using corresponding keys of the JSON object
public class ReportData
{
    // > each ReportData object requires a JSON object to reference /////////////////////////////////
    private JSONObject data;
    
    public ReportData(JSONObject data)
    {
        this.data = data;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    // += data retrieval methods /////////////////////////////////////////////////////////////////////
    // = game statistics [precondition: key 'key' is present and corresponds to text] //
    public String getGameStatistic(String key)
    {
        return data.getJSONObject("GameStats").getString(key);
    }
    // = game statistics - integers [precondition: key 'key' is present and corresponds to an integer] //
    public int getGameStatisticInt(String key)
    {
        return data.getJSONObject("GameStats").getInt(key);
    }
    // + innings (integer) //
    public int getInnings()
    {
        return getGameStatisticInt("innings");
    }
    // + length (integer) //
    public int getLength()
    {
        return getGameStatisticInt("length");
    }
    // + location //
    public String getLocation()
    {
        return getGameStatistic("location");
    }
    // + start time //
    public String getStartTime()
    {
        return getGameStatistic("startTime");
    }
    // + weather //
    public String getWeather()
    {
        return getGameStatistic("weather");
    }
    
    
    // = team primary statistics [precondition: key 'key' is present and primary and corresponds to text] //
    public String getTeamPrimaryStatistic(boolean teamA, String key)
    {
        String teamLabel;
        if (teamA)      teamLabel = "TeamA";
        else        teamLabel = "TeamB";
        return data.getJSONObject(teamLabel).getString(key);
    }
    // = team primary statistics - integers [precondition: key 'key' is present and primary and corresponds to an integer] //
    public int getTeamPrimaryStatisticInt(boolean teamA, String key)
    {
        String teamLabel;
        if (teamA)      teamLabel = "TeamA";
        else        teamLabel = "TeamB";
        return data.getJSONObject(teamLabel).getInt(key);
    }
    // + team name //
    public String getTeamName(boolean teamA)
    {
        return getTeamPrimaryStatistic(teamA, "teamName");
    }
    // + team demonym //
    public String getTeamDemonym(boolean teamA)
    {
        return getTeamPrimaryStatistic(teamA, "teamDemonym");
    }
    // + team home city //
    public String getTeamHomeCity(boolean teamA)
    {
        return getTeamPrimaryStatistic(teamA, "homeCity");
    }
    // + team result //
    public String getTeamResult(boolean teamA)
    {
        return getTeamPrimaryStatistic(teamA, "wonGame");
    }
    // + team total score (integer) //
    public int getTeamTotalScore(boolean teamA)
    {
        return getTeamPrimaryStatisticInt(teamA, "totalScore");
    }
    
    // = team players statistics [preconditions: the player named 'playerName' is present in the specified team, and key 'key' is present and is corresponds to text] //
    public String getTeamPlayerStatistic(boolean teamA, String playerName, String key)
    {
        String teamLabel;
        if (teamA)      teamLabel = "TeamA";
        else        teamLabel = "TeamB";
        int index = -1;
        String foundPlayerName = "";
        while (foundPlayerName != playerName)
        {
            index++;
            foundPlayerName = data.getJSONObject(teamLabel).getJSONArray("players").getJSONObject(index).getString("name");
        }
        return data.getJSONObject(teamLabel).getJSONArray("players").getJSONObject(index).getString(key);
    }
    // = team players statistics - integers [preconditions: the player named 'playerName' is present in the specified team, and key 'key' is present and corresponds to an integer] //
    public int getTeamPlayerStatisticInt(boolean teamA, String playerName, String key)
    {
        String teamLabel;
        if (teamA)      teamLabel = "TeamA";
        else        teamLabel = "TeamB";
        int index = -1;
        String foundPlayerName = "";
        while (foundPlayerName != playerName)
        {
            index++;
            foundPlayerName = data.getJSONObject(teamLabel).getJSONArray("players").getJSONObject(index).getString("name");
        }
        return data.getJSONObject(teamLabel).getJSONArray("players").getJSONObject(index).getInt(key);
    }
    // + team player hits (integer) [precondition: the player named 'playerName' is present in the specified team] //
    public int getTeamPlayerHits(boolean teamA, String playerName)
    {
        return getTeamPlayerStatisticInt(teamA, playerName, "hits");
    }
    // + team player bats (integer) [precondition: the player named 'playerName' is present in the specified team] //
    public int getTeamPlayerBats(boolean teamA, String playerName)
    {
        return getTeamPlayerStatisticInt(teamA, playerName, "atBats");
    }
    // + team player batting average [precondition: the player named 'playerName' is present in the specified team] //
    public String getTeamPlayerBattingAverage(boolean teamA, String playerName)
    {
        return getTeamPlayerStatistic(teamA, playerName, "battingAverage");
    }
    // + team player runs (integer) [precondition: the player named 'playerName' is present in the specified team] //
    public int getTeamPlayerRuns(boolean teamA, String playerName)
    {
        return getTeamPlayerStatisticInt(teamA, playerName, "runs");
    }
    // + team player out (integer) [precondition: the player named 'playerName' is present in the specified team] //
    public int getTeamPlayerOut(boolean teamA, String playerName)
    {
        return getTeamPlayerStatisticInt(teamA, playerName, "out");
    }
    // + team player outs (integer) [precondition: the player named 'playerName' is present in the specified team] //
    public int getTeamPlayerOuts(boolean teamA, String playerName)
    {
        return getTeamPlayerStatisticInt(teamA, playerName, "outs");
    }
    // + team player position (integer) [precondition: the player named 'playerName' is present in the specified team] //
    public String getTeamPlayerPosition(boolean teamA, String playerName)
    {
        return getTeamPlayerStatistic(teamA, playerName, "position");
    }
    
    // = team standings statistics - integers [preconditions: key 'key' is present and corresponds to an int] //
    public int getTeamStandingsStatisticInt(boolean teamA, String key)
    {
        String teamLabel;
        if (teamA)      teamLabel = "TeamA";
        else        teamLabel = "TeamB";
        return data.getJSONObject(teamLabel).getJSONObject("teamStandings").getInt(key);
    }
    // + team standings win record (int) //
    public int getTeamStandingsWinRecord(boolean teamA)
    {
        return getTeamStandingsStatisticInt(teamA, "winRecord");
    }
    // + team standings loss record (int) //
    public int getTeamStandingsLossRecord(boolean teamA)
    {
        return getTeamStandingsStatisticInt(teamA, "lossRecord");
    }
    // + team standings win streak (int) //
    public int getTeamStandingsWinStreak(boolean teamA)
    {
        return getTeamStandingsStatisticInt(teamA, "winStreak");
    }
    // + team standings position (int) //
    public int getTeamStandingsPosition(boolean teamA)
    {
        return getTeamStandingsStatisticInt(teamA, "position");
    }
    
    // = team runs statistics [preconditions: index 'index' is present, key 'key' is present and corresponds to text] //
    public String getTeamRunsIndexStatistic(boolean teamA, int index, String key)
    {
        String teamLabel;
        if (teamA)      teamLabel = "TeamA";
        else        teamLabel = "TeamB";
        return data.getJSONObject(teamLabel).getJSONArray("runs").getJSONObject(index).getString(key);
    }
    // = team runs statistics - integers [preconditions: index 'index' is present, key 'key' is present and corresponds to an int] //
    public int getTeamRunsIndexStatisticInt(boolean teamA, int index, String key)
    {
       String teamLabel;
        if (teamA)      teamLabel = "TeamA";
        else        teamLabel = "TeamB";
        return data.getJSONObject(teamLabel).getJSONArray("runs").getJSONObject(index).getInt(key);
    }
    // = team runs statistics - booleans [preconditions: index 'index' is present, key 'key' is present and corresponds to a boolean] //
    public boolean getTeamRunsIndexStatisticBoolean(boolean teamA, int index, String key)
    {
       String teamLabel;
        if (teamA)      teamLabel = "TeamA";
        else        teamLabel = "TeamB";
        return data.getJSONObject(teamLabel).getJSONArray("runs").getJSONObject(index).getBoolean(key);
    }
    // + team runs index hitter [precondition: index 'index' is present] //
    public String getTeamRunsIndexHitter(boolean teamA, int index)
    {
        return getTeamRunsIndexStatistic(teamA, index, "hitter");
    }
    // + team runs index inning (int) [precondition: index 'index' is present] //
    public int getTeamRunsIndexInning(boolean teamA, int index)
    {
        return getTeamRunsIndexStatisticInt(teamA, index, "inning");
    }
    // + team runs index points scored (int) [precondition: index 'index' is present] //
    public int getTeamRunsIndexPointsScored(boolean teamA, int index)
    {
        return getTeamRunsIndexStatisticInt(teamA, index, "pointsScored");
    }
    // + team runs index points scored (boolean) [precondition: index 'index' is present] //
    public boolean getTeamRunsIndexPointsScoredBoolean(boolean teamA, int index)
    {
        return getTeamRunsIndexStatisticBoolean(teamA, index, "overFence");
    }
    
    // = team pitchers statistics //
    // = team pitchers statistics [preconditions: the pitcher named 'pitcherName' is present in the specified team, and key 'key' is present and is corresponds to text] //
    public String getTeamPitcherStatistic(boolean teamA, String pitcherName, String key)
    {
        String teamLabel;
        if (teamA)      teamLabel = "TeamA";
        else        teamLabel = "TeamB";
        int index = -1;
        String foundPitcherName = "";
        while (foundPitcherName != pitcherName)
        {
            index++;
            foundPitcherName = data.getJSONObject(teamLabel).getJSONArray("pitchers").getJSONObject(index).getString("name");
        }
        return data.getJSONObject(teamLabel).getJSONArray("pitchers").getJSONObject(index).getString(key);
    }
    // = team pitchers statistics - integers [preconditions: the pitcher named 'pitcherName' is present in the specified team, and key 'key' is present and is corresponds to an int] //
    public int getTeamPitcherStatisticInt(boolean teamA, String pitcherName, String key)
    {
        String teamLabel;
        if (teamA)      teamLabel = "TeamA";
        else        teamLabel = "TeamB";
        int index = -1;
        String foundPitcherName = "";
        while (foundPitcherName != pitcherName)
        {
            index++;
            foundPitcherName = data.getJSONObject(teamLabel).getJSONArray("pitchers").getJSONObject(index).getString("name");
        }
        return data.getJSONObject(teamLabel).getJSONArray("pitchers").getJSONObject(index).getInt(key);
    }
    // = team pitchers statistics - decimals [preconditions: the pitcher named 'pitcherName' is present in the specified team, and key 'key' is present and is corresponds to a decimal] //
    public double getTeamPitcherStatisticDouble(boolean teamA, String pitcherName, String key)
    {
        String teamLabel;
        if (teamA)      teamLabel = "TeamA";
        else        teamLabel = "TeamB";
        int index = -1;
        String foundPitcherName = "";
        while (foundPitcherName != pitcherName)
        {
            index++;
            foundPitcherName = data.getJSONObject(teamLabel).getJSONArray("pitchers").getJSONObject(index).getString("name");
        }
        return data.getJSONObject(teamLabel).getJSONArray("pitchers").getJSONObject(index).getDouble(key);
    }
    // + team pitcher innings pitched (integer) [precondition: the pitcher named 'pitcherName' is present in the specified team] //
    public int getTeamPitcherInningsPitched(boolean teamA, String pitcherName)
    {
        return getTeamPitcherStatisticInt(teamA, pitcherName, "name");
    }
    // + team pitcher earned run average ('ERA') (decimal) [precondition: the pitcher named 'pitcherName' is present in the specified team] //
    public double getTeamPitcherERA(boolean teamA, String pitcherName)
    {
        return getTeamPitcherStatisticDouble(teamA, pitcherName, "era");
    }
    // + team pitcher walks (integer) [precondition: the pitcher named 'pitcherName' is present in the specified team] //
    public int getTeamPitcherWalks(boolean teamA, String pitcherName)
    {
        return getTeamPitcherStatisticInt(teamA, pitcherName, "walks");
    }
    // + team pitcher outs (integer) [precondition: the pitcher named 'pitcherName' is present in the specified team] //
    public int getTeamPitcherOuts(boolean teamA, String pitcherName)
    {
        return getTeamPitcherStatisticInt(teamA, pitcherName, "outs");
    }
    // + team pitcher runs allowed (integer) [precondition: the pitcher named 'pitcherName' is present in the specified team] //
    public int getTeamPitcherRunsAllowed(boolean teamA, String pitcherName)
    {
        return getTeamPitcherStatisticInt(teamA, pitcherName, "runsAllowed");
    }
    // + team pitcher pitches (integer) [precondition: the pitcher named 'pitcherName' is present in the specified team] //
    public int getTeamPitcherPitches(boolean teamA, String pitcherName)
    {
        return getTeamPitcherStatisticInt(teamA, pitcherName, "pitches");
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////
}

// Hunter Bobeck //