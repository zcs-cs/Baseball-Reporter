package modules;
import data.*;
import utilities.*;

import java.util.ArrayList;

/**
 *         ____  _ __       __       ___             ____ 
 *        / __ \(_) /______/ /_     /   |_   _______/ __ )
 *       / /_/ / / __/ ___/ __ \   / /| | | / / ___/ __  |
 *      / ____/ / /_/ /__/ / / /  / ___ | |/ (__  ) /_/ / 
 *     /_/   /_/\__/\___/_/ /_/  /_/  |_|___/____/_____/ 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 *  by bryce josh and dan
 */
public class PitchAvBModule extends ReportModule<BaseballData>
{
    public PitchAvBModule(BaseballData data) { super(data); }
    
    int runs1, runs2, strikeouts1, strikeouts2, battersFaced1, battersFaced2;
    String Name1, Name2, Team1, Team2, output;
    ArrayList<PitcherPlayer> pitchers;
    public String generate()
    {
        BaseballData d = (BaseballData)data;
        //This is a generic statement generator
        // populate pitcher list
        pitchers = new ArrayList<PitcherPlayer>();
        int counter = 0;
        try{
            while(counter < 10){
                PitcherPlayer p = new PitcherPlayer(d, 'a', counter);
                pitchers.add(p);
                counter++;
            }
        }catch (Exception e){
            
        }
        counter = 0;
        try{
            while(counter < 10){
                PitcherPlayer p = new PitcherPlayer(d, 'b', counter);
                pitchers.add(p);
                counter++;
            }
        }catch (Exception e){
            
        }
        
        ////////////////////opening sentence introducing best pitchers////////////////////
        
        int select = (int)(Math.random()*5);
        
        switch(select){
            case 0:
                output = "Best pitchers for the game were " +Name1+ " of the " +Team1+ ", and " +Name2+ " pitching for the " +Team2+ "."; 
                break;
            case 1:
                output = Team1+ "'s best pitcher, " +Name1+ ", went up against "+Name2+"of the " +Team2+ "s.";
                break;
            case 2:
                output = Team2+ "'s best pitcher, " +Name2+ ", went up against "+Name1+"of the " +Team1+ "s.";
                break;
            case 3:
                output = "Pitchers " +Name1+ " and " +Name2+ " faced off in the game between " +Team1+ " and " +Team2+ ".";
                break;
            case 4:
                output = "Pitchers " +Name2+ " and " +Name1+ " faced off in the game between " +Team2+ " and " +Team1+ ".";
                break;
        }
        
        //////////////////////////////////////////////////////////////////////////////////
        
        //next sentence
        
        
        
        //
        
        
        return output;
    }
    public String betterGame()
    {
        if (strikeouts1 > strikeouts2 && battersFaced1 > battersFaced2)
        {
            
        }
        else if (strikeouts1 < strikeouts2 && battersFaced1 < battersFaced2)
        {
            
        }
        else 
        {
            
        }
        return "";
    }
    public String moreRuns()
    {
       if (runs2 > runs1)
       { 
           
       }
       else if (runs2 < runs1)
       {
           
       }
       else 
       {
           
       }
       return "";
    }
}
