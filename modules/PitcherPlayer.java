package modules;

import modules.*;
import data.*;

/**
 * For use with the PitcherModule
 */
public class PitcherPlayer
{
    // instance variables - replace the example below with your own
    private String name, teamName, teamDemonym;
    private int runs, era, strikeouts, batters;
    private BaseballData d;
    private boolean team;
    /**
     * Constructor for objects of class PitcherPlayer
     */
    public PitcherPlayer(BaseballData d, int team, int index) throws Exception
    {
        if (team == 'a'){
            team = false;
        } else if (team == 'b'){
            team = true;
        } else {
            throw new IllegalArgumentException();
        }
        this.d = d;
    }
    public PitcherPlayer(){
        
    }
    
}
