/* Progress..
  * there is an old importation and calling of this class in Converter that should probably get removed
  * include additional data retrieval methods as data.json is updated as data is requested
 */

package data;

import org.json.*;
import java.util.ArrayList;

// ReportData:
//
//  [>] intended to provide resource methods for modules' generation methods
//  [>] capable of interpreting a JSON object
//  [>] created by being fed the intended JSON object
//
//  [=] contains [private] general methods for accessing each data category
//
//  [+] provides [public] specific and boolean-specified methods for accessing each JSON value (datum) using corresponding keys of the JSON object (container)
public class BaseballData implements ReportData
{
    // [>] each BaseballData object requires a JSON object to reference ///////////////////////////////////
    private JSONObject data;
    
    public BaseballData(JSONObject data)
    {
        this.data = data;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    
    



    // data retrieval methods (the assumed data type is text) ///////////////////////////////////////////
    // [>] array conversion utilities  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //
    // [>] array converter [precondition: 'arrayJSON' is a text array] //
    private String[] arrayFor(JSONArray arrayJSON)
    {
        String[] array = new String[arrayJSON.length()];
        for (int i = 0; i < array.length; i++)
        {
          array[i] = arrayJSON.getString(i);
        }
        return array;
    }
    // [>] array converter - integers [precondition: 'arrayJSON' is an integer array] //
    private int[] arrayForInts(JSONArray arrayJSON)
    {
        int[] array = new int[arrayJSON.length()];
        for (int i = 0; i < array.length; i++)
        {
          array[i] = arrayJSON.getInt(i);
        }
        return array;
    }

    // [>] array converter - across parallel containers
    // [preconditions]:
    //     'arrayJSON' is a text array
    //     key 'key' is present and corresponds to (parallel) texts
    private String[] arrayForParallel(JSONArray arrayJSON, String key)
    {
        String[] array = new String[arrayJSON.length()];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = arrayJSON.getJSONObject(i).getString(key);
        }
        return array;
    }
    // [>] array converter - integers across parallel containers
    // [preconditions]:
    //     'arrayJSON' is an integer array
    //     key 'key' is present and corresponds to (parallel) integers
    private int[] arrayForParallelInts(JSONArray arrayJSON, String key)
    {
        int[] array = new int[arrayJSON.length()];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = arrayJSON.getJSONObject(i).getInt(key);
        }
        return array;
    }

    // [>] array converter - across parallel containers across parallel containers
    // [preconditions]:
    //     'arrayJSON' is a container array
    //     (array) key 'arrayKey' is present and corresponds to (parallel) arrays
    //     key 'key' is present and corresponds to (parallel) texts
    private String[][] arrayForParallelParallel(JSONArray arrayJSON, String arrayKey, String key)
    {
        ArrayList<ArrayList<String>> arraylist = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < arrayJSON.length(); i++)
        {
            arraylist.add(new ArrayList<String>());
            for (int j = 0; j < arrayJSON.getJSONObject(i).getJSONArray(arrayKey).length(); j++)
            {
                arraylist.get(i).add(arrayJSON.getJSONObject(i).getJSONArray(arrayKey).getJSONObject(j).getString(key));
            }
        }
        // convert 'arraylist' to a text array array //
        String[][] array = new String[arraylist.size()][];
        for (int i = 0; i < arraylist.size(); i++)
        {
            String[] arrayComponent = new String[arraylist.get(i).size()];
            for (int j = 0; j < arraylist.get(i).size(); j++)
            {
                arrayComponent[j] = arraylist.get(i).get(j);
            }
            array[i] = arrayComponent;
        }
        return array;
    }
    // [>] array converter - integers across parallel containers across parallel containers
    // [preconditions]:
    //    'arrayJSON' is a container array
    //     (array) key 'arrayKey' is present and corresponds to (parallel) arrays
    //     key 'key' is present and corresponds to (parallel) integers
    private int[][] arrayForParallelParallelInts(JSONArray arrayJSON, String arrayKey, String key)
    {
        ArrayList<ArrayList<Integer>> arraylist = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < arrayJSON.length(); i++)
        {
            arraylist.add(new ArrayList<Integer>());
            for (int j = 0; j < arrayJSON.getJSONObject(i).getJSONArray(arrayKey).length(); j++)
            {
                arraylist.get(i).add(arrayJSON.getJSONObject(i).getJSONArray(arrayKey).getJSONObject(j).getInt(key));
            }
        }
        // convert 'arraylist' to an integer array array //
        int[][] array = new int[arraylist.size()][];
        for(int i = 0; i < arraylist.size(); i++)
        {
            int[] arrayComponent = new int[arraylist.get(i).size()];
            for(int j = 0; j < arraylist.get(i).size(); j++)
            {
                arrayComponent[j] = arraylist.get(i).get(j);
            }
            array[i] = arrayComponent;
        }
        return array;
    }

    // [>] array converter - arrays across parallel containers
    // [preconditions]:
    //     'arrayJSON' is a text array
    //     key 'key' is present and corresponds to (parallel) text arrays
    private String[][] arrayForParallelArrays(JSONArray arrayJSON, String key)
    {
        String[][] array = new String[arrayJSON.length()][];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = arrayFor(arrayJSON.getJSONObject(i).getJSONArray(key));
        }
        return array;
    }
    // [>] array converter - integer arrays across parallel containers
    // [preconditions]:
    //     'arrayJSON' is an integer array
    //     key 'key' is present and corresponds to (parallel) integer arrays
    private int[][] arrayForParallelIntArrays(JSONArray arrayJSON, String key)
    {
        int[][] array = new int[arrayJSON.length()][];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = arrayForInts(arrayJSON.getJSONObject(i).getJSONArray(key));
        }
        return array;
    }
    //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  /


    
    
    

    // [+=] data retrieval methods - obvious and necessary  //  //  //  //  //  //  //  //  //  //  //  /
    // [=] primary statistics [precondition: key 'key' is present and corresponds to text] //
    private String primaryStatistic(String key)
    {
        return data.getString(key);
    }
    // [=] primary statistics - decimals [precondition: key 'key' is present and corresponds to a decimal] //
    private double primaryStatisticDouble(String key)
    {
        return data.getDouble(key);
    }
    // [=] primary statistics - integers [precondition: key 'key' is present and corresponds to an integer] //
    private int primaryStatisticInt(String key)
    {
        return data.getInt(key);
    }
    // [+] location //
    public String location()
    {
        return primaryStatistic("location");
    }
    // [+] city //
    public String city()
    {
        return primaryStatistic("city");
    }
    // [+] temperature //
    public double temperature()
    {
        return primaryStatisticDouble("temperature");
    }
    // [+] rainfall //
    public double rainfall()
    {
        return primaryStatisticDouble("rainfall");
    }
    // [+] date //
    public String date()
    {
        return primaryStatistic("date");
    }
    // [+] start time - integer //
    public int startTime()
    {
        return primaryStatisticInt("startTime");
    }
    // [+] minutes - integer //
    public int minutes()
    {
        return primaryStatisticInt("minutes");
    }
    // [+] innings - integer //
    public int innings()
    {
        return primaryStatisticInt("innings");
    }
    
    
    
    

    // [>] team label (key) chooser based on 'teamA' boolean //
    private String teamFor(boolean teamA)
    {
        if (teamA)     return "teamA";
        else    return "teamB";
    }
    // [=]  statistics
    // (for this and each of its implementations, 'teamA' equals true or false designating Team A or Team B respectively)
    // [precondition: key 'key' is present and corresponds to text]
    private String teamPrimaryStatistic(boolean teamA, String key)
    {
        return data.getJSONObject("teams").getJSONObject(teamFor(teamA)).getString(key);
    }
    // [=] team primary statistics - integers
    // (for this and each of its implementations, 'teamA' equals true or false designating Team A or Team B respectively)
    // [precondition: key 'key' is present and corresponds to an integer]
    private int teamPrimaryStatisticInt(boolean teamA, String key)
    {
        return data.getJSONObject("teams").getJSONObject(teamFor(teamA)).getInt(key);
    }
    // [=] team primary statistics - booleans
    // (for this and each of its implementations, 'teamA' equals true or false designating Team A or Team B respectively)
    // [precondition: key 'key' is present and corresponds to a boolean] //
    private boolean teamPrimaryStatisticBoolean(boolean teamA, String key)
    {
        return data.getJSONObject("teams").getJSONObject(teamFor(teamA)).getBoolean(key);
    }
    // [+] team name //
    public String teamName(boolean teamA)
    {
        return teamPrimaryStatistic(teamA, "name");
    }
    // [+] team demonym //
    public String teamDemonym(boolean teamA)
    {
        return teamPrimaryStatistic(teamA, "demonym");
    }
    // [+] team homecity //
    public String teamHomecity(boolean teamA)
    {
        return teamPrimaryStatistic(teamA, "homecity");
    }
    // [+] team inning scores - integer array //
    public int[] teamInningScores(boolean teamA)
    {
        return arrayForInts(data.getJSONObject("teams").getJSONObject(teamFor(teamA)).getJSONArray("inningScores"));
    }
    // [+] team score - integer //
    public int teamScore(boolean teamA)
    {
        return teamPrimaryStatisticInt(teamA, "score");
    }
    // [+] team result - boolean //
    public boolean teamResult(boolean teamA)
    {
        return teamPrimaryStatisticBoolean(teamA, "result");
    }
    



    // [=] team standings statistics - integers
    // (for this and each of its implementations, 'teamA' equals true or false designating Team A or Team B respectively)
    // [precondition: key 'key' is present and corresponds to an integer] //
    private int teamStandingsStatisticInt(boolean teamA, String key)
    {
        return data.getJSONObject("teams").getJSONObject(teamFor(teamA)).getJSONObject("standings").getInt(key);
    }
    // [+] team standings position - integer //
    public int teamStandingsPosition(boolean teamA)
    {
        return teamStandingsStatisticInt(teamA, "position");
    }
    // [+] team standings wins - integer //
    public int teamStandingsWins(boolean teamA)
    {
        return teamStandingsStatisticInt(teamA, "wins");
    }
    // [+] team standings streak - integer //
    public int teamStandingsStreak(boolean teamA)
    {
        return teamStandingsStatisticInt(teamA, "streak");
    }
    // [+] team standings losses - integer //
    public int teamStandingsLosses(boolean teamA)
    {
        return teamStandingsStatisticInt(teamA, "losses");
    }
    // [+] team standings 'PCT' - integer //
    public int teamStandingsPCT(boolean teamA)
    {
        return teamStandingsStatisticInt(teamA, "PCT");
    }
    
    

    // [=] team players statistics - arrays
    // (for this and each of its implementations, 'teamA' equals true or false designating Team A or Team B respectively)
    // [precondition: key 'key' is present and corresponds to (parallel) texts] //
    private String[] teamPlayersPrimaryStatisticsArrays(boolean teamA, String key)
    {
        return arrayForParallel(data.getJSONObject("teams").getJSONObject(teamFor(teamA)).getJSONArray("players"), key);
    }
    // [=] team players statistics - integer arrays
    // (for this and each of its implementations, 'teamA' equals true or false designating Team A or Team B respectively)
    // [precondition: key 'key' is present and corresponds to (parallel) integers] //
    private int[] teamPlayersPrimaryStatisticsIntArrays(boolean teamA, String key)
    {
        return arrayForParallelInts(data.getJSONObject("teams").getJSONObject(teamFor(teamA)).getJSONArray("players"), key);
    }
    // [=] team players statistics - integer array arrays
    // (for this and each of its implementations, 'teamA' equals true or false designating Team A or Team B respectively)
    // [precondition: key 'key' is present and corresponds to (parallel) text arrays] //
    private int[][] teamPlayersPrimaryStatisticsIntArrayArrays(boolean teamA, String key)
    {
        return arrayForParallelIntArrays(data.getJSONObject("teams").getJSONObject(teamFor(teamA)).getJSONArray("players"), key);
    }
    // [+] team players names - array //
    public String[] teamPlayersNames(boolean teamA)
    {
        return teamPlayersPrimaryStatisticsArrays(teamA, "name");
    }
    // [+] team player bats - integer array //
    public int[] teamPlayersBats(boolean teamA)
    {
        return teamPlayersPrimaryStatisticsIntArrays(teamA, "bats");
    }
    // [+] team players runs innings - integer array array //
    public int[][] teamPlayersRunsInnings(boolean teamA)
    {
        return teamPlayersPrimaryStatisticsIntArrayArrays(teamA, "runsInnings");
    }
    // [+] team players HRs - integer array //
    public int[] teamPlayersHRs(boolean teamA)
    {
        return teamPlayersPrimaryStatisticsIntArrays(teamA, "HRs");
    }
    // [+] team players innings pitched - integer array array //
    public int[][] teamPlayersInningsPitched(boolean teamA)
    {
        return teamPlayersPrimaryStatisticsIntArrayArrays(teamA, "inningsPitched");
    }

   
    // [=] team players hits statistics - array arrays
    // (for this and each of its implementations, 'teamA' equals true or false designating Team A or Team B respectively)
    // [precondition: key 'key' is present and corresponds to (parallel) arrays]
    private String[][] teamPlayersHitsStatisticsArrayArrays(boolean teamA, String key)
    {
        return arrayForParallelParallel(data.getJSONObject("teams").getJSONObject(teamFor(teamA)).getJSONArray("players"), "hits", key);
    }
    // [=] team players hits statistics - integer array arrays
    // (for this and each of its implementations, 'teamA' equals true or false designating Team A or Team B respectively)
    // [precondition: key 'key' is present and corresponds to (parallel) integer arrays]
    private int[][] teamPlayersHitsStatisticsIntArrayArrays(boolean teamA, String key)
    {
        return arrayForParallelParallelInts(data.getJSONObject("teams").getJSONObject(teamFor(teamA)).getJSONArray("players"), "hits", key);
    }
    // [+] team players hits descriptions - array array //
    public String[][] teamPlayersHitsDescriptions(boolean teamA)
    {
        return teamPlayersHitsStatisticsArrayArrays(teamA, "description");
    }
    // [+] team players hits R.B.I.s - integer array array //
    public int[][] teamPlayersHitsRBIs(boolean teamA)
    {
        return teamPlayersHitsStatisticsIntArrayArrays(teamA, "RBI");
    }

    // [=] team players injuries statistics - integer array arrays
    // (for this and each of its implementations, 'teamA' equals true or false designating Team A or Team B respectively)
    // [precondition: key 'key' is present and corresponds to (parallel) integer arrays]
    private int[][] teamPlayersInjuriesStatisticsIntegerArrayArrays(boolean teamA, String key)
    {
        return arrayForParallelParallelInts(data.getJSONObject("teams").getJSONObject(teamFor(teamA)).getJSONArray("players"), "injuries", key);
    }
    // [=] team players injuries statistics - array arrays
    // (for this and each of its implementations, 'teamA' equals true or false designating Team A or Team B respectively)
    // [precondition: key 'key' is present and corresponds to (parallel) text arrays]
    private String[][] teamPlayersInjuriesStatisticsArrayArrays(boolean teamA, String key)
    {
        return arrayForParallelParallel(data.getJSONObject("teams").getJSONObject(teamFor(teamA)).getJSONArray("players"), "injuries", key);
    }
    // [+] team players injuries games missed - integer array array //
    public int[][] teamPlayersInjuriesGamesMissed(boolean teamA)
    {
        return teamPlayersInjuriesStatisticsIntegerArrayArrays(teamA, "gamesMissed");
    }
    // [+] team players injuries types - array array //
    public String[][] teamPlayersInjuriesTypes(boolean teamA)
    {
        return teamPlayersInjuriesStatisticsArrayArrays(teamA, "type");
    }
    // [+] team players injuries locations - array array //
    public String[][] teamPlayersInjuriesLocations(boolean teamA)
    {
        return teamPlayersInjuriesStatisticsArrayArrays(teamA, "location");
    }
    //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  /







    // [+=] data retrieval methods - nonobvious (and necessary) //  //  //  //  //  //  //  //  //  //  /
    // [+] team players R.B.I.s - integer array //
    public int[] teamPlayersRBIs(boolean teamA)
    {
        int[][] teamPlayersHitsRBIs = teamPlayersHitsRBIs(teamA);  
        int[] teamPlayersRBIs = new int[teamPlayersHitsRBIs.length];
        for (int i = 0; i < teamPlayersRBIs.length; i++)
        {
            teamPlayersRBIs[i] = 0;
            for (int j = 0; j < teamPlayersHitsRBIs[i].length; j++)
            {
                teamPlayersRBIs[i] += teamPlayersHitsRBIs[i][j];
            }
        }
        return teamPlayersRBIs;
    }
    // [+] team players hits - integer array //
    public int[] teamPlayersHits(boolean teamA)
    {
        String[][] teamPlayersHitsDescriptions = teamPlayersHitsDescriptions(teamA);        // could have used hits R.B.I.s too //
        int[] teamPlayersHits = new int[teamPlayersHitsDescriptions.length];
        for (int i = 0; i < teamPlayersHits.length; i++)
        {
            teamPlayersHits[i] = teamPlayersHitsDescriptions[i].length;
        }
        return teamPlayersHits;
    }
    // [+] team players runs - integer array //
    public int[] teamPlayersRuns(boolean teamA)
    {
        int[][] teamPlayersRunsInnings = teamPlayersRunsInnings(teamA);
        int[] teamPlayersRuns = new int[teamPlayersRunsInnings.length];
        for (int i = 0; i < teamPlayersRuns.length; i++)
        {
            teamPlayersRuns[i] = teamPlayersRunsInnings[i].length;
        }
        return teamPlayersRuns;
    }
    
    // [>] team label (key) chooser based on 'teamC' boolean //
    private String teamForC(boolean teamC)
    {
        if (teamC)     return "teamC";
        else    return "teamD";
    }
    // [+] other team demonym
    // ('teamC' equals true or false designating Team C or Team D respectively)
    public String otherTeamDemonym(boolean teamC)
    {
        return data.getJSONObject("teams").getJSONObject(teamForC(teamC)).getString("demonym");
    }
    // [+] other team standings 'PCT' - integer
    // ('teamC' equals true or false designating Team C or Team D respectively)
    public int otherTeamStandingsPCT(boolean teamC)
    {
        return data.getJSONObject("teams").getJSONObject(teamForC(teamC)).getJSONObject("standings").getInt("PCT");
    }
    
    //Blah blah
    public int otherTeamStandingsPosition(boolean teamC)
    {
        return data.getJSONObject("teams").getJSONObject(teamForC(teamC)).getJSONObject("standings").getInt("position");
    }
    
    
    //Blah blah
    public int otherTeamStandingsWins(boolean teamC)
    {
        return data.getJSONObject("teams").getJSONObject(teamForC(teamC)).getJSONObject("standings").getInt("wins");
    }
    
    public int otherTeamStandingsStreak(boolean teamC)
    {
        return data.getJSONObject("teams").getJSONObject(teamForC(teamC)).getJSONObject("standings").getInt("streak");
    }
    
    public int otherTeamStandingsLosses(boolean teamC)
    {
        return data.getJSONObject("teams").getJSONObject(teamForC(teamC)).getJSONObject("standings").getInt("losses");
    }
    //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  /
    /////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /**
     * @return String representation of an array.
     */
    private String intArray_toString(int[] arr)
    {
        String output = "[";
        int i;
        for(i = 0; i < arr.length-1; i++) {
            output += arr[i] + ", ";
        }
        output += arr[i] + "]";
        
        return output;
    }
    private String intArrayArray_toString(int[][] arr)
    {
        String output = "[";
        for( int[] tmp : arr) {
            output += intArray_toString(tmp);
        }
        output += "]";
        
        return output;
    }
    private String StringArray_toString(String[] arr)
    {
        String output = "[";
        int i;
        for(i = 0; i < arr.length-1; i++) {
            output += arr[i] + ", ";
        }
        output += arr[i] + "]";
        
        return output;
    }
    private String StringArrarArray_toString(String[][] arr)
    {
        String output = "[";
        int i;
        for(String[] tmp : arr) {
            output += StringArray_toString(tmp);
        }
        output += "]";
        
        return output;
    }
    
    /**
     * @return All implementations for all public methods.
     */
    public String toString()
    {
        String output = "";

        /**
        * @return The location of the game (field).
        */
        output += "String location()\t:" + this.location() + "\n";
        
        /**
        * @return The city where the game was played.
        */
        output += "String city()\t:" + this.city() + "\n";
        
        /**
        * @return The temperature on gameday.
        */
        output += "double temperature()\t:" + this.temperature() + "\n";
        
        /**
        * @return The precipitation on gameday.
        */
        output += "double rainfall()\t:" + this.rainfall() + "\n";

        /**
        * @return The date of the game.
        */
        output += "String date()\t:" + this.date() + "\n";
        
        /**
        * @return The start time of the game.
        */
        output += "int startTime()\t:" + this.startTime() + "\n";
        
        /**
        * @return Minutes the game lasted.
        */
        output += "int minutes()\t:" + this.minutes() + "\n";
        
        /**
        * @return The number of innings the game has.
        */
        output += "int innings()\t:" + this.innings() + "\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (INDIANS & BATS).
        *
        * @return The official team name.
        */
        output += "String teamName(INDIANS)\t:" + this.teamName(INDIANS) + "\n";
        output += "String teamName(BATS)\t:" + this.teamName(BATS) + "\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (INDIANS & BATS).
        *
        * @return The nickname of the team.
        */
        output += "String teamDemonym(INDIANS)\t:" + this.teamDemonym(INDIANS) + "\n";
        output += "String teamDemonym(BATS)\t:" + this.teamDemonym(BATS) + "\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (INDIANS & BATS).
        *
        * @return The home city of the team.
        */
        output += "String teamHomecity(INDIANS)\t:" + this.teamHomecity(INDIANS) + "\n";
        output += "String teamHomecity(BATS)\t:" + this. teamHomecity(BATS) + "\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (INDIANS & BATS).
        *
        * @return An array of scores a team made throughout the game, per inning.
        */
        output += "int[] teamInningScores(INDIANS)\t:" + intArray_toString( this.teamInningScores(INDIANS) ) + "\n";
        output += "int[] teamInningScores(BATS)\t:" + intArray_toString( this.teamInningScores(BATS) ) + "\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (INDIANS & BATS).
        *
        * @return Final score for the team.
        */
        output += "int teamScore(INDIANS)\t:" + this.teamScore(INDIANS) + "\n";
        output += "int teamScore(BATS)\t:" + this.teamScore(BATS) + "\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (INDIANS & BATS).
        *
        * @return Win or loss of the game (true/false)
        */
        output += "boolean teamResult(INDIANS)\t:" + this.teamResult(INDIANS) + "\n";
        output += "boolean teamResult(INDIANS)\t:" + this.teamResult(INDIANS) + "\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (INDIANS & BATS).
        *
        * @return The position within the league of the team.
        */
        output += "int teamStandingsPosition(INDIANS)\t:" + this.teamStandingsPosition(INDIANS) + "\n";
        output += "int teamStandingsPosition(BATS)\t:" + this.teamStandingsPosition(BATS) + "\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (INDIANS & BATS).
        *
        * @return The number of wins the team has for the season.
        */
        output += "int teamStandingsWins(INDIANS)\t:" + this.teamStandingsWins(INDIANS) + "\n";
        output += "int teamStandingsWins(BATS)\t:" + this.teamStandingsWins(BATS) + "\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (INDIANS & BATS).
        *
        * @return The longest winning streak for the team.
        */
        output += "int teamStandingsStreak(INDIANS)\t:" + this.teamStandingsStreak(INDIANS) + "\n";
        output += "int teamStandingsStreak(BATS)\t:" + this.teamStandingsStreak(BATS) + "\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (INDIANS & BATS).
        *
        * @return The number of losses the team has for the season.
        */
        output += "int teamStandingsLosses(INDIANS)\t:" + this.teamStandingsLosses(INDIANS) + "\n";
        output += "int teamStandingsLosses(BATS)\t:" + this.teamStandingsLosses(BATS) + "\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (INDIANS & BATS).
        *
        * @return An array containing all player names on a given team.
        */
        output += "int teamStandingsLosses(INDIANS)\t:" + this.teamStandingsLosses(INDIANS) + "\n";
        output += "int teamStandingsLosses(BATS)\t:" + this.teamStandingsLosses(BATS) + "\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (INDIANS & BATS).
        *
        * @return An array of bats for each corresponding player.
        */
        output += "int[] teamPlayersBats(INDIANS)\t:" + intArray_toString( this.teamPlayersBats(INDIANS) ) + "\n";
        output += "int[] teamPlayersBats(BATS)\t:" + intArray_toString( this.teamPlayersBats(BATS) ) + "\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (INDIANS & BATS).
        *
        * @return A 2D array of runs for each player, for each inning.
        */
        output += "int[][] teamPlayersRunsInnings(INDIANS)\t:" + intArrayArray_toString( this.teamPlayersRunsInnings(INDIANS) ) + "\n";
        output += "int[][] teamPlayersRunsInnings(BATS)\t:" + intArrayArray_toString( this.teamPlayersRunsInnings(BATS) ) + "\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (INDIANS & BATS).
        *
        * @return An array of HRs for each player, for each inning.
        */
        output += "int[] teamPlayersHRs(INDIANS)\t:" + intArray_toString( this.teamPlayersHRs(INDIANS) ) + "\n";
        output += "int[] teamPlayersHRs(BATS)\t:" + intArray_toString( this.teamPlayersHRs(BATS) ) + "\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (INDIANS & BATS).
        *
        * @return A 2D array of pitches for each player, for each inning.
        */
        output += "int[][] teamPlayersInningsPitched(INDIANS)\t:" + intArrayArray_toString( this.teamPlayersInningsPitched(INDIANS) ) + "\n";
        output += "int[][] teamPlayersInningsPitched(BATS)\t:" + intArrayArray_toString( this.teamPlayersInningsPitched(BATS) ) + "\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (INDIANS & BATS).
        *
        * @return A 2D array of hits for each player.
        */
        output += "String[][] teamPlayersHitsDescriptions(INDIANS)\t:" + StringArrarArray_toString( this.teamPlayersHitsDescriptions(INDIANS) ) + "\n";
        output += "String[][] teamPlayersHitsDescriptions(BATS)\t:" + StringArrarArray_toString( this.teamPlayersHitsDescriptions(BATS) ) + "\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (INDIANS & BATS).
        *
        * @return RBIs for each player on a team.
        */
        output += "int[][] teamPlayersHitsRBIs(INDIANS)\t:" + intArrayArray_toString( this.teamPlayersHitsRBIs(INDIANS) ) + "\n";
        output += "int[][] teamPlayersHitsRBIs(BATS)\t:" + intArrayArray_toString( this.teamPlayersHitsRBIs(BATS) ) + "\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (INDIANS & BATS).
        *
        * @return Injuries for all players.
        */
        output += "int[][] teamPlayersInjuriesGamesMissed(INDIANS)\t:" + intArrayArray_toString( this.teamPlayersInjuriesGamesMissed(INDIANS) ) + "\n";
        output += "int[][] teamPlayersInjuriesGamesMissed(BATS)\t:" + intArrayArray_toString( this.teamPlayersInjuriesGamesMissed(BATS) ) + "\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (INDIANS & BATS).
        *
        * @return Injury types for all players.
        */
        output += "String[][] teamPlayersInjuriesTypes(INDIANS)\t:" + StringArrarArray_toString( this.teamPlayersInjuriesTypes(INDIANS) ) + "\n";
        output += "String[][] teamPlayersInjuriesTypes(BATS)\t:" + StringArrarArray_toString( this.teamPlayersInjuriesTypes(BATS) ) + "\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (INDIANS & BATS).
        *
        * @return Locations for all player injuries.
        */
        output += "String[][] teamPlayersInjuriesLocations(INDIANS)\t:" + StringArrarArray_toString( this.teamPlayersInjuriesLocations(INDIANS) ) + "\n";
        output += "String[][] teamPlayersInjuriesLocations(BATS)\t:" + StringArrarArray_toString( this.teamPlayersInjuriesLocations(BATS) ) + "\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (INDIANS & BATS).
        *
        * @return All player RBIs on a team.
        */
        output += "int[] teamPlayersRBIs(INDIANS)\t:" + intArray_toString( this.teamPlayersRBIs(INDIANS) ) + "\n";
        output += "int[] teamPlayersRBIs(BATS)\t:" + intArray_toString( this.teamPlayersRBIs(BATS) ) + "\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (INDIANS & BATS).
        *
        * @return Hit count for each player on a team.
        */
        output += "int[] teamPlayersHits(INDIANS)\t:" + intArray_toString( this.teamPlayersHits(INDIANS) ) + "\n";
        output += "int[] teamPlayersHits(BATS)\t:" + intArray_toString( this.teamPlayersHits(BATS) ) + "\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (INDIANS & BATS).
        *
        * @return Number of runs for each player on a team.
        */
        output += "int[] teamPlayersRuns(INDIANS)\t:" + intArray_toString( this.teamPlayersRuns(INDIANS) ) + "\n";
        output += "int[] teamPlayersRuns(BATS)\t:" + intArray_toString( this.teamPlayersRuns(BATS) ) + "\n";
        
        /**
        * @param teamC
        *        Get information from third team (true) or fourth team (false).
        *        Use the constants defined above (HENS & CLIPPERS)
        *
        * @return The position of the team.
        */
        output += "int otherTeamStandingsPosition(HENS)\t:" + this.otherTeamStandingsPosition(HENS) + "\n";
        output += "int otherTeamStandingsPosition(CLIPPERS)\t:" + this.otherTeamStandingsPosition(CLIPPERS) + "\n";
        
        /**
        * @param teamC
        *        Get information from third team (true) or fourth team (false).
        *        Use the constants defined above (HENS & CLIPPERS)
        *
        * @return The number of wins the team had before the game.
        */
        output += "int otherTeamStandingsWins(HENS)\t:" + this.otherTeamStandingsWins(HENS) + "\n";
        output += "int otherTeamStandingsWins(CLIPPERS)\t:" + this.otherTeamStandingsWins(CLIPPERS) + "\n";
            
        /**
        * @param teamC
        *        Get information from third team (true) or fourth team (false).
        *        Use the constants defined above (HENS & CLIPPERS)
        *
        * @return The team's streak before the game.
        */
        output += "int otherTeamStandingsWins(HENS)\t:" + this.otherTeamStandingsWins(HENS) + "\n";
        output += "int otherTeamStandingsWins(CLIPPERS)\t:" + this.otherTeamStandingsWins(CLIPPERS) + "\n";
        
        /**
        * @param teamC
        *        Get information from third team (true) or fourth team (false).
        *        Use the constants defined above (HENS & CLIPPERS)
        *
        * @return The number of losses the team had before the game.
        */
        output += "int otherTeamStandingsLosses(HENS)\t:" + this.otherTeamStandingsLosses(HENS) + "\n";
        output += "int otherTeamStandingsLosses(CLIPPERS)\t:" + this.otherTeamStandingsLosses(CLIPPERS) + "\n";
        
        return output;
    }
}

// Hunter Bobeck //
