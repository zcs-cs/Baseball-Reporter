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
    public SavesAndReliefsModule (BaseballData data) {
        super(data);
    }
    
    public String generate () {
        
        
        return "Nothing of interest";
    }
    
}
