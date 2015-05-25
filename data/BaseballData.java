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
    // [+] team player teamB - integer array //
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
        if(arr.length == 0) {
            return "null";
        }
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
        if(arr.length == 0) {
            return "null";
        }
        String output = "[";
        int i;
        for( i = 0; i < arr.length-1; i++ ) {
            output += intArray_toString(arr[i]) + ", ";
        }
        output += intArray_toString(arr[i]) + "]";
        
        return output;
    }
    private String StringArray_toString(String[] arr)
    {
        if(arr.length == 0) {
            return "null";
        }
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
        if(arr.length == 0) {
            return "null";
        }
        String output = "[";
        int i;
        for(i = 0; i < arr.length-1; i++) {
            output += StringArray_toString(arr[i]) + ", ";
        }
        output += StringArray_toString(arr[i]) + "]";
        
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
        output += "String location()\t\t\t\t:" + this.location() + "\n\n";
        
        /**
        * @return The city where the game was played.
        */
        output += "String city()\t\t\t\t\t:" + this.city() + "\n\n";
        
        /**
        * @return The temperature on gameday.
        */
        output += "double temperature()\t\t\t\t:" + this.temperature() + "\n\n";
        
        /**
        * @return The precipitation on gameday.
        */
        output += "double rainfall()\t\t\t\t:" + this.rainfall() + "\n\n";

        /**
        * @return The date of the game.
        */
        output += "String date()\t\t\t\t\t:" + this.date() + "\n\n";
        
        /**
        * @return The start time of the game.
        */
        output += "int startTime()\t\t\t\t\t:" + this.startTime() + "\n\n";
        
        /**
        * @return Minutes the game lasted.
        */
        output += "int minutes()\t\t\t\t\t:" + this.minutes() + "\n\n";
        
        /**
        * @return The number of innings the game has.
        */
        output += "int innings()\t\t\t\t\t:" + this.innings() + "\n\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (teamA & teamB).
        *
        * @return The official team name.
        */
        output += "String teamName(data.teamA)\t\t\t:" + this.teamName(teamA) + "\n\n";
        output += "String teamName(data.teamB)\t\t\t\t:" + this.teamName(teamB) + "\n\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (teamA & teamB).
        *
        * @return The nickname of the team.
        */
        output += "String teamDemonym(teamA)\t\t\t:" + this.teamDemonym(teamA) + "\n\n";
        output += "String teamDemonym(teamB)\t\t\t:" + this.teamDemonym(teamB) + "\n\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (teamA & teamB).
        *
        * @return The home city of the team.
        */
        output += "String teamHomecity(teamA)\t\t\t:" + this.teamHomecity(teamA) + "\n\n";
        output += "String teamHomecity(teamB)\t\t\t:" + this. teamHomecity(teamB) + "\n\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (teamA & teamB).
        *
        * @return An array of scores a team made throughout the game, per inning.
        */
        output += "int[] teamInningScores(teamA)\t\t\t:" + intArray_toString( this.teamInningScores(teamA) ) + "\n\n";
        output += "int[] teamInningScores(teamB)\t\t\t:" + intArray_toString( this.teamInningScores(teamB) ) + "\n\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (teamA & teamB).
        *
        * @return Final score for the team.
        */
        output += "int teamScore(teamA)\t\t\t\t:" + this.teamScore(teamA) + "\n\n";
        output += "int teamScore(teamB)\t\t\t\t:" + this.teamScore(teamB) + "\n\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (teamA & teamB).
        *
        * @return Win or loss of the game (true/false)
        */
        output += "boolean teamResult(teamA)\t\t\t:" + this.teamResult(teamA) + "\n\n";
        output += "boolean teamResult(teamB)\t\t\t:" + this.teamResult(teamB) + "\n\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (teamA & teamB).
        *
        * @return The position within the league of the team.
        */
        output += "int teamStandingsPosition(teamA)\t\t:" + this.teamStandingsPosition(teamA) + "\n\n";
        output += "int teamStandingsPosition(teamB)\t\t\t:" + this.teamStandingsPosition(teamB) + "\n\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (teamA & teamB).
        *
        * @return The number of wins the team has for the season.
        */
        output += "int teamStandingsWins(teamA)\t\t\t:" + this.teamStandingsWins(teamA) + "\n\n";
        output += "int teamStandingsWins(teamB)\t\t\t:" + this.teamStandingsWins(teamB) + "\n\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (teamA & teamB).
        *
        * @return The longest winning streak for the team.
        */
        output += "int teamStandingsStreak(teamA)\t\t:" + this.teamStandingsStreak(teamA) + "\n\n";
        output += "int teamStandingsStreak(teamB)\t\t\t:" + this.teamStandingsStreak(teamB) + "\n\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (teamA & teamB).
        *
        * @return The number of losses the team has for the season.
        */
        output += "int teamStandingsLosses(teamA)\t\t:" + this.teamStandingsLosses(teamA) + "\n\n";
        output += "int teamStandingsLosses(teamB)\t\t\t:" + this.teamStandingsLosses(teamB) + "\n\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (teamA & teamB).
        *
        * @return An array containing all player names on a given team.
        */
        output += "String[] teamPlayersNames(teamA)\t\t:" + StringArray_toString( this.teamPlayersNames(teamA) ) + "\n\n";
        output += "String[] teamPlayersNames(teamB)\t\t\t:" + StringArray_toString( this.teamPlayersNames(teamB) ) + "\n\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (teamA & teamB).
        *
        * @return An array of teamB for each corresponding player.
        */
        output += "int[] teamPlayersBats(teamA)\t\t\t:" + intArray_toString( this.teamPlayersBats(teamA) ) + "\n\n";
        output += "int[] teamPlayersBats(teamB)\t\t\t:" + intArray_toString( this.teamPlayersBats(teamB) ) + "\n\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (teamA & teamB).
        *
        * @return A 2D array of runs for each player, for each inning.
        */
        output += "int[][] teamPlayersRunsInnings(teamA)\t\t:" + intArrayArray_toString( this.teamPlayersRunsInnings(teamA) ) + "\n\n";
        output += "int[][] teamPlayersRunsInnings(teamB)\t\t:" + intArrayArray_toString( this.teamPlayersRunsInnings(teamB) ) + "\n\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (teamA & teamB).
        *
        * @return An array of HRs for each player, for each inning.
        */
        output += "int[] teamPlayersHRs(teamA)\t\t\t:" + intArray_toString( this.teamPlayersHRs(teamA) ) + "\n\n";
        output += "int[] teamPlayersHRs(teamB)\t\t\t:" + intArray_toString( this.teamPlayersHRs(teamB) ) + "\n\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (teamA & teamB).
        *
        * @return A 2D array of pitches for each player, for each inning.
        */
        output += "int[][] teamPlayersInningsPitched(teamA)\t:" + intArrayArray_toString( this.teamPlayersInningsPitched(teamA) ) + "\n\n";
        output += "int[][] teamPlayersInningsPitched(teamB)\t\t:" + intArrayArray_toString( this.teamPlayersInningsPitched(teamB) ) + "\n\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (teamA & teamB).
        *
        * @return A 2D array of hits for each player.
        */
        output += "String[][] teamPlayersHitsDescriptions(teamA)\t:" + StringArrarArray_toString( this.teamPlayersHitsDescriptions(teamA) ) + "\n\n";
        output += "String[][] teamPlayersHitsDescriptions(teamB)\t:" + StringArrarArray_toString( this.teamPlayersHitsDescriptions(teamB) ) + "\n\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (teamA & teamB).
        *
        * @return RBIs for each player on a team.
        */
        output += "int[][] teamPlayersHitsRBIs(teamA)\t\t:" + intArrayArray_toString( this.teamPlayersHitsRBIs(teamA) ) + "\n\n";
        output += "int[][] teamPlayersHitsRBIs(teamB)\t\t:" + intArrayArray_toString( this.teamPlayersHitsRBIs(teamB) ) + "\n\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (teamA & teamB).
        *
        * @return Injuries for all players.
        */
        output += "int[][] teamPlayersInjuriesGamesMissed(teamA)\t:" + intArrayArray_toString( this.teamPlayersInjuriesGamesMissed(teamA) ) + "\n\n";
        output += "int[][] teamPlayersInjuriesGamesMissed(teamB)\t:" + intArrayArray_toString( this.teamPlayersInjuriesGamesMissed(teamB) ) + "\n\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (teamA & teamB).
        *
        * @return Injury types for all players.
        */
        output += "String[][] teamPlayersInjuriesTypes(teamA)\t:" + StringArrarArray_toString( this.teamPlayersInjuriesTypes(teamA) ) + "\n\n";
        output += "String[][] teamPlayersInjuriesTypes(teamB)\t:" + StringArrarArray_toString( this.teamPlayersInjuriesTypes(teamB) ) + "\n\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (teamA & teamB).
        *
        * @return Locations for all player injuries.
        */
        output += "String[][] teamPlayersInjuriesLocations(teamA):" + StringArrarArray_toString( this.teamPlayersInjuriesLocations(teamA) ) + "\n\n";
        output += "String[][] teamPlayersInjuriesLocations(teamB)\t:" + StringArrarArray_toString( this.teamPlayersInjuriesLocations(teamB) ) + "\n\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (teamA & teamB).
        *
        * @return All player RBIs on a team.
        */
        output += "int[] teamPlayersRBIs(teamA)\t\t\t:" + intArray_toString( this.teamPlayersRBIs(teamA) ) + "\n\n";
        output += "int[] teamPlayersRBIs(teamB)\t\t\t:" + intArray_toString( this.teamPlayersRBIs(teamB) ) + "\n\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (teamA & teamB).
        *
        * @return Hit count for each player on a team.
        */
        output += "int[] teamPlayersHits(teamA)\t\t\t:" + intArray_toString( this.teamPlayersHits(teamA) ) + "\n\n";
        output += "int[] teamPlayersHits(teamB)\t\t\t:" + intArray_toString( this.teamPlayersHits(teamB) ) + "\n\n";
        
        /**
        * @param teamA
        *        Get information from first team (true) or second team (false).
        *        Use the constants defined above (teamA & teamB).
        *
        * @return Number of runs for each player on a team.
        */
        output += "int[] teamPlayersRuns(teamA)\t\t\t:" + intArray_toString( this.teamPlayersRuns(teamA) ) + "\n\n";
        output += "int[] teamPlayersRuns(teamB)\t\t\t:" + intArray_toString( this.teamPlayersRuns(teamB) ) + "\n\n";
        
        /**
        * @param teamC
        *        Get information from third team (true) or fourth team (false).
        *        Use the constants defined above (teamC & teamD)
        *
        * @return The position of the team.
        */
        output += "int otherTeamStandingsPosition(teamC)\t\t:" + this.otherTeamStandingsPosition(teamC) + "\n\n";
        output += "int otherTeamStandingsPosition(teamD)\t:" + this.otherTeamStandingsPosition(teamD) + "\n\n";
        
        /**
        * @param teamC
        *        Get information from third team (true) or fourth team (false).
        *        Use the constants defined above (teamC & teamD)
        *
        * @return The number of wins the team had before the game.
        */
        output += "int otherTeamStandingsWins(teamC)\t\t:" + this.otherTeamStandingsWins(teamC) + "\n\n";
        output += "int otherTeamStandingsWins(teamD)\t\t:" + this.otherTeamStandingsWins(teamD) + "\n\n";
            
        /**
        * @param teamC
        *        Get information from third team (true) or fourth team (false).
        *        Use the constants defined above (teamC & teamD)
        *
        * @return The team's streak before the game.
        */
        output += "int otherTeamStandingsWins(teamC)\t\t:" + this.otherTeamStandingsWins(teamC) + "\n\n";
        output += "int otherTeamStandingsWins(teamD)\t\t:" + this.otherTeamStandingsWins(teamD) + "\n\n";
        
        /**
        * @param teamC
        *        Get information from third team (true) or fourth team (false).
        *        Use the constants defined above (teamC & teamD)
        *
        * @return The number of losses the team had before the game.
        */
        output += "int otherTeamStandingsLosses(teamC)\t\t:" + this.otherTeamStandingsLosses(teamC) + "\n\n";
        output += "int otherTeamStandingsLosses(teamD)\t\t:" + this.otherTeamStandingsLosses(teamD) + "\n\n";
        
        return output;
    }
}

// Hunter Bobeck //
