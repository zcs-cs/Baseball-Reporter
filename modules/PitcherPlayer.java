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
    private String name, firstName, lastName, teamName, teamDemonym;
    private int runs, era, strikeouts, batters;
    private BaseballData data;
    private boolean team;
    int[] inningsPitched;
    private int playaIndex;
    
    /**
     * Constructor for objects of class PitcherPlayer
     */
    public PitcherPlayer(BaseballData d, int t, int i) throws Exception
    {
        if (t == 'a'){
            this.team = false;
        } else if (t == 'b'){
            this.team = true;
        } else {
            throw new IllegalArgumentException();
        }
        data = d;
        playaIndex = i;
        
        int numberOfPlayers = 0; // something here
        int counter = 0;
        JSONObject player;
        String playerType = "";
        
        int[][] inningsPitched = data.teamPlayersInningsPitched(team);
        
        for (int j = 0; j < inningsPitched.length; j++){ // player index
            // set player object
            // set playerType object
            
            if(inningsPitched[j].length != 0){ // if the player is a pitcher
                if (counter == j){ // is this the right pitcher?
                    // set player data variables
                    name = data.teamPlayersNames(team)[j];
                    String[] tempName = name.trim().split(" ");
                    firstName = "";
                    for (int k = 1; k < tempName.length; k++){
                        lastName += tempName[k] + " ";
                    }
                    lastName.trim();
                    firstName = tempName[0];
                    teamName = data.teamName(team);
                    teamDemonym = data.teamDemonym(team);
                    runs = data.teamPlayersHRs(team)[j];
                    this.inningsPitched = inningsPitched[j];
                    
                    
                    break;
                }
                counter++;
            }
            if (j == numberOfPlayers-1){
                throw new IllegalArgumentException(); // uuh no pitcher
            }
        }
    }
    public PitcherPlayer() throws Exception{
        throw new IllegalArgumentException(); // uuh no pitcher
    }
    
    public int runs(){
        return runs;
    }
    public String name(){
        return name;
    }
    public String firstName(){
        return firstName;
    }
    public String lastName(){
        return lastName;
    }
    public String teamName(){
        return teamName;
    }
    public String teamDemonym(){
        return teamDemonym;
    }
    public boolean team(){
        return team;
    }
    public int[] inningsPitched(){
        return inningsPitched;
    }
    public int totalInningsPitched(){
        return inningsPitched.length;
    }
    public int playerIndex(){
        return playaIndex;
    }
}
