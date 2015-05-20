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
 *          -He pitched for at least 3 innings (he entered in the 7th inning
 */
public class SavesAndReliefsModule  extends ReportModule<BaseballData> {
    private int lastPitcherIndex, lastPitcherEnterInning;
    
    public SavesAndReliefsModule (BaseballData data) {
        super(data);
    }
    
    /**
     * Generates a string describing the save status of the relief pitchers
     * @return a string describing the save status of the relief pitchers
     */
    public String generate () {
        
        
        return "Nothing of interest";
    }
    
    /**
     * Finds the last person to pitch in the game for the winning team
     */
    public int findLastPitcherIndex () {
        //Find the winning team
        boolean indianWin = data.teamResult(data.INDIANS);
        
        int[][] inningsPitched = data.teamPlayersInningsPitched(indianWin);
        
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
}
