package modules;

import modules.*;
import data.*;
import org.json.*;

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
    private int playaIndex;
    /**
     * Constructor for objects of class PitcherPlayer
     */
    public PitcherPlayer(BaseballData d, int team, int i) throws Exception
    {
        if (team == 'a'){
            this.team = false;
        } else if (team == 'b'){
            this.team = true;
        } else {
            throw new IllegalArgumentException();
        }
        this.d = d;
        playaIndex = i;
        
        int numberOfPlayers = 0; // something here
        int counter = 0;
        JSONObject player;
        String playerType = "";
        for (int j = 0; j < numberOfPlayers; j++){
            // set player object
            // set playerType object
            if(playerType.equals("pitcher")){ // if the player is a pitcher
                if (counter == j){ // is this the right pitcher?
                    // set player data variables
                    break;
                }
                counter++;
            }
            if (j == numberOfPlayers-1){
                throw new IllegalArgumentException(); // uuh no pitcher
            }
        }
    }
    public PitcherPlayer(){
        
    }
    
}
