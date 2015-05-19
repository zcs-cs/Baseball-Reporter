package modules;
import data.*;
import utilities.*;

import java.util.ArrayList;

/**
 * Write a description of class PitchAvB here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
        
        //
        int shazbot = (int)(Math.random()*5);
        int Strikeouts1 = 0;
        int Strikeouts2 = 0;
        
        switch(shazbot){
            case 0:
                output = Name1 + " pitched for the " + Team1 + ", with " + Name2 + "pitching for the " + Team2 + "."; 
                break;
            case 1:
                output = Team1+ "'s best pitcher, " +Name1+ ", went up against "+Name2+"of the " +Team2+ "s.";
                break;
            case 2:
                output = Team2+ "'s best pitcher, " +Name2+ ", went up against "+Name1+"of the " +Team1+ "s.";
            case 3:
                output = "Pitchers " +Name1+ " and " +Name2+ " faced off in the game between " +Team1+ " and " +Team2+ ".";
            case 4:
                output = "Pitchers " +Name2+ " and " +Name1+ " faced off in the game between " +Team2+ " and " +Team1+ ".";
        }
        
        //being revised and transferred to above ^
        //{output = "The team's best pitchers both had even games. " +Team1+ "'s " +Name1+ " brought " +Strikeouts1+" strikeouts, while "
        //                    +Name2+ " of the " +Team2+ " had " +Strikeouts2+ " strikeouts.";}
        
        
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
