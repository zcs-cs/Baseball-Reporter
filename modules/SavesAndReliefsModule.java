package modules;

import data.BaseballData;
import utilities.*;

/**
 * Write a description of class SavesAndReliefsModule here.
 * 
 * @author Alex Han, Jacob Quick, Matt Sibila, Alex van de Sandt
 * 
 * Methods from the BaseballData module:
 *      -teamPlayersInningsPitched
 *      -teamPlayersNames
 *      -teamInningScores
 * How the method works:
 *      1. Find the last pitcher to enter the game
 *          -Loop through the innings pitched 2D array, searching for the earliest inning
 *          -Find the player that entered that inning
 *      2. If the team did not have the lead during that inning, he did not save
 *      3. If he satisfies one  of the following conditions, he saved:
 *          -When he entered, the lead was less than or equal to 3 runs
 *          -He pitched for at least 3 innings (he entered in the 7th inning in a 9 inning game)
 */
public class SavesAndReliefsModule  extends ReportModule<BaseballData> {
    private int lastPitcherIndex, lastPitcherEnterInning;
    private int[] pitchers;
    private int[] relievingPitchers;
    
    /**
     * Constructor that takes data and calls the constructor of the <code>ReportModule</code> interface
     * @param   data    the data of the game, used to generate the report
     */
    public SavesAndReliefsModule (BaseballData data) {
        super(data);
    }
    
    /**
     * Generates a string describing the save status of the relief pitchers
     * @return a string describing the save status of the relief pitchers
     */
    public String generate () {
        String toReturn = "";
        
        //Find the last pitcher to enter the game
        findLastPitcherIndex();
        
        //Check the lead during the inning he entered
        int[] scoresAtEntry = calcRunningScore(lastPitcherEnterInning);
        if (!((data.teamResult(data.INDIANS) && scoresAtEntry[0] > scoresAtEntry[1] + 3) ||
            (data.teamResult(data.BATS)    && scoresAtEntry[1] > scoresAtEntry[0] + 3))) {
             //The pitcher saved, because the lead was less than three when he entered
             
             
        }
        else if (lastPitcherEnterInning < data.innings() - 2) {
            //The pitcher saved, because he pitched for at least 3 innings
            
            
        }
        //else if () { //"He enters the game, regardless of the count, with the potential tying run either on base, at bat or on deck"
            //The number of people at bat, on deck (always 2), or on base is >= the difference in scores
        //}
        else {
            //He didn't save
        }
        
        return "toReturn";
    }
    
    /**
     * Determines if a given player has pitched in a given inning
     * @param the innings pitched array from retrieved data
     * @param the particular inning being searched for
     * @return whether or not the particular inning has been pitched
     */
    public boolean contains (int[] player, int inning){
        for (int i = 0; i < player.length; i++){
            if (player[i] == inning){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Finds all the pitchers of a team
     * @param the team for which the information is being retrieved
     * @return array of the indices of each pitcher
     */
    public int[] findAllPitchers (boolean team){
        //The number of pitchers
        int pitcherCount = 0;
        //Temporary array to store pitcher indices as they are found
        int[] temp = new int[25];
        //Array of pitched innings retrieved from data
        int[][] players = data.teamPlayersInningsPitched(team);
        //loops through inningsPitched array
        for (int i = 0; i < players.length; i++){
            //finds all instances where a player has pitched more than 0 innings
            if (players[i].length > 0){
                //adds index to temporary array and increases count of pitchers
                temp[pitcherCount] = i;
                pitcherCount++;
            }
        }
        
        //creates return array of the appropriate length
        int ret[] = new int[pitcherCount];
        //copies data from temporary array to final array
        for (int i = 0; i < pitcherCount; i++){
            ret[i] = temp[i];
        }
        
        return ret;
    }
    
    /**
     * Finds which pitcher pitched in inning 1
     * then if multiple have, which pitched did not also pitch in inning 2
     * @param which team's pitcher is being searched
     * @return the index of the starting pitcher
     */
    public int findStartingPitcher (boolean team){
        int[] pitchers = findAllPitchers (team);
        int ret = -1;
        int[][] inningsPitched = data.teamPlayersInningsPitched(team);
        
        for (int i = 0; i < pitchers.length; i++){
            if (contains(inningsPitched[i], 1) && ret == -1){
                ret = i;
            }
            if (contains(inningsPitched[i], 1) && !(contains(inningsPitched[i], 1))){
                ret = i;
            }
        }
        
        return pitchers[ret];
    }
    
    /**
     * Finds the last person to pitch in the game for the winning team
     * @return  the index of the last pitcher to enter the game
     */
    public int findLastPitcherIndex () {
        //Find the winning team
        boolean aWin = data.teamResult(data.INDIANS);
        
        int[][] inningsPitched = data.teamPlayersInningsPitched(aWin);
        
        int minInning = data.innings();
        int minIndex = 0;
        //Loop through the innings pitched array (through each player)
        for (int i = 0; i < inningsPitched.length; i++) {
            //Loop through the array for each pitcher
            for (int j = 0; j < inningsPitched[i].length; i++) {
                if (inningsPitched[i][j] < minInning) {
                    minInning = inningsPitched[i][j];
                    minIndex = i;
                }
            }
        }
        
        lastPitcherIndex = minIndex;
        lastPitcherEnterInning = minInning;
        
        return minIndex;
    }
    
    /**
     * Finds the total score for each team at the beginning of the given inning
     * @param   inning  the innning up to which the inning scores will be summed
     * @return          the total score at the beginning of the given inning
     */
    public int[] calcRunningScore (int inning) {
        int[] toReturn = new int[2];
        if (inning < 0 || inning > data.innings()) {
            toReturn[0] = 0;
            toReturn[1] = 0;
            return toReturn;
        }
        
        //Calculate team A
        int[] teamAInningScores = data.teamInningScores(data.INDIANS);
        for (int i = 0; i < inning - 1; i++) {
            toReturn[0] += teamAInningScores[i];
        }
        
        //Calculate team B
        int[] teamBInningScores = data.teamInningScores(data.BATS);
        for (int i = 0; i < inning - 1; i++) toReturn[1] += teamBInningScores[i];
        
        return toReturn;
    }
}
