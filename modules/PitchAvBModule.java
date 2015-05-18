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
        }
        
        //being revised and transferred to above ^
        if(shazbot == 0)
        {output = "In this game, " +Name1+ " pitched for the " +Team1+ ", with " +Name2+ "pitching for the " +Team2+ ".";}
        else if(shazbot == 1)
        {output = Team1+ "'s best pitcher, " +Name1+ ", went up against "+Name2+"of the " +Team2+ "s.";}
        else if(shazbot == 2)
        {output = Name1 + ", the pitcher for " + Team1 ;}
        else if(shazbot == 3)
        {output = Name2 + ", the pitcher for " + Team2 ;}
        else if(shazbot == 4 && (Math.abs(Strikeouts1-Strikeouts2) <= 3))
        {output = "The team's best pitchers both had even games. " +Team1+ "'s " +Name1+ " brought " +Strikeouts1+" strikeouts, while "
                            +Name2+ " of the " +Team2+ " had " +Strikeouts2+ " strikeouts.";}
        else 
        {final int demons = 666;}
        
        
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
