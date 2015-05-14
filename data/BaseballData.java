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
        ArrayList<ArrayList<String>> array = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < arrayJSON.length(); i++)
        {
            array.add(new ArrayList<String>());
            for (int j = 0; j < arrayJSON.getJSONArray(i).length(); j++)
            {
                array.get(i).add( arrayJSON.getJSONObject(i).getJSONArray(arrayKey).getJSONObject(j).getString(key) );
            }
        }
        
        //extract the elements from the array and spit them out as a String[][]
        String[][] output = new String[array.size()][];
        for(int k = 0; k < array.size(); k++) {
            output[k] = (String[])(array.get(k).toArray());
        }
        return output;
    }
    // [>] array converter - integers across parallel containers across parallel containers
    // [preconditions]:
    //    'arrayJSON' is a container array
    //     (array) key 'arrayKey' is present and corresponds to (parallel) arrays
    //     key 'key' is present and corresponds to (parallel) integers
    private int[][] arrayForParallelParallelInts(JSONArray arrayJSON, String arrayKey, String key)
    {
        ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
        //int[][] array = new int[][arrayJSON.length()];
        for (int i = 0; i < arrayJSON.length(); i++)
        {
            array.add( new ArrayList<Integer>() );
            for (int j = 0; j < arrayJSON.getJSONArray(i).length(); j++)
            {
                array.get(i).add( arrayJSON.getJSONObject(i).getJSONArray(arrayKey).getJSONObject(j).getInt(key) );
            }
        }
        
        int[][] output = new int[array.size()][];
        for(int k = 0; k < array.size(); k++) {
            Integer[] tmp = (Integer[])(array.get(k).toArray());
            int[] blah = new int[tmp.length];
            for(int l = 0; l < tmp.length; l++) {
                blah[l] = tmp[l];
            }
            
            output[k] = blah;
        }
        return output;
    }

    // [>] array converter - text arrays across parallel containers
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
    // [=] team primary statistics
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
    // [+] team inning scores - integer arrays //
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
    // [=] team players statistics - text array arrays
    // (for this and each of its implementations, 'teamA' equals true or false designating Team A or Team B respectively)
    // [precondition: key 'key' is present and corresponds to (parallel) text arrays] //
    private String[][] teamPlayersPrimaryStatisticsArrayArrays(boolean teamA, String key)
    {
        return arrayForParallelArrays(data.getJSONObject("teams").getJSONObject(teamFor(teamA)).getJSONArray("players"), key);
    }
    // [=] team players statistics - integer array arrays
    // (for this and each of its implementations, 'teamA' equals true or false designating Team A or Team B respectively)
    // [precondition: key 'key' is present and corresponds to (parallel) text arrays] //
    private int[][] teamPlayersPrimaryStatisticsIntArrayArrays(boolean teamA, String key)
    {
        return arrayForParallelIntArrays(data.getJSONObject("teams").getJSONObject(teamFor(teamA)).getJSONArray("players"), key);
    }
    // [+] team players names - arrays //
    public String[] teamPlayersNames(boolean teamA)
    {
        return teamPlayersPrimaryStatisticsArrays(teamA, "name");
    }
    // [+] team player bats - integer arrays //
    public int[] teamPlayersBats(boolean teamA)
    {
        return teamPlayersPrimaryStatisticsIntArrays(teamA, "bats");
    }
    // [+] team players hit descriptions - array arrays //
    public String[][] teamPlayersHitsDescriptions(boolean teamA)
    {
        return teamPlayersPrimaryStatisticsArrayArrays(teamA, "hits");
    }
    // [+] team player R.B.I.s - integer arrays //
    public int[] teamPlayersRBIs(boolean teamA)
    {
        return teamPlayersPrimaryStatisticsIntArrays(teamA, "RBI");
    }
    // [+] team players innings pitched - integer array arrays //
    public int[][] teamPlayersInningsPitched(boolean teamA)
    {
        return teamPlayersPrimaryStatisticsIntArrayArrays(teamA, "inningsPitched");
    }

    // [=] team players runs statistics - integer array arrays
    // (for this and each of its implementations, 'teamA' equals true or false designating Team A or Team B respectively)
    // [precondition: key 'key' is present and corresponds to (parallel) integer arrays]
    private int[][] teamPlayersRunsStatisticsIntegerArrayArrays(boolean teamA, String key)
    {
        return arrayForParallelParallelInts(data.getJSONObject("teams").getJSONObject(teamFor(teamA)).getJSONArray("players"), "runs", key);
    }
    // [+] team players runs innings - integer array arrays //
    public int[][] teamPlayersRunsInnings(boolean teamA)
    {
        return teamPlayersRunsStatisticsIntegerArrayArrays(teamA, "inning");
    }
    // [+] team players runs balls' runs - integer array arrays //
    public int[][] teamPlayersRunsBallsRuns(boolean teamA)
    {
        return teamPlayersRunsStatisticsIntegerArrayArrays(teamA, "ballsRuns");
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
    // [+] team players injuries games missed - integer array arrays //
    public int[][] teamPlayersInjuriesGamesMissed(boolean teamA)
    {
        return teamPlayersInjuriesStatisticsIntegerArrayArrays(teamA, "gamesMissed");
    }
    // [+] team players injuries types - array arrays //
    public String[][] teamPlayersInjuriesTypes(boolean teamA)
    {
        return teamPlayersInjuriesStatisticsArrayArrays(teamA, "type");
    }
    // [+] team players injuries locations - array arrays //
    public String[][] teamPlayersInjuriesLocations(boolean teamA)
    {
        return teamPlayersInjuriesStatisticsArrayArrays(teamA, "location");
    }
    //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  /




    // [+=] data retrieval methods - nonobvious (and necessary) //  //  //  //  //  //  //  //  //  //  /
    // [+] team players hits - integer arrays //
    public int[] teamPlayersHits(boolean teamA)
    {
        String[][] teamPlayersHitsDescriptions = teamPlayersHitsDescriptions(teamA);
        int[] teamPlayersHits = new int[teamPlayersHitsDescriptions.length];
        for (int i = 0; i < teamPlayersHits.length; i++)
        {
            teamPlayersHits[i] = teamPlayersHitsDescriptions[i].length;
        }
        return teamPlayersHits;
    }
    // [+] team players runs - integer arrays //
    public int[] teamPlayersRuns(boolean teamA)
    {
        int[][] teamPlayersRunsInnings = teamPlayersRunsInnings(teamA);        // could have used 'balls' runs too' //
        int[] teamPlayersRuns = new int[teamPlayersRunsInnings.length];
        for (int i = 0; i < teamPlayersRuns.length; i++)
        {
            teamPlayersRuns[i] = teamPlayersRunsInnings[i].length;
        }
        return teamPlayersRuns;
    }
    //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  //  /
    /////////////////////////////////////////////////////////////////////////////////////////////////////
}

// Hunter Bobeck //
