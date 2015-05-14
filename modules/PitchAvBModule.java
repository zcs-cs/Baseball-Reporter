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
    int runs1, runs2, strikeouts1, strikeouts2, battersFaced1, battersFaced2;
    String Name1, Name2, Team1, Team2, output;
    ArrayList<PitcherPlayer> pitchers;
    public String generate()
    {
        BaseballData d;
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
        int shazbot = (int)Math.random()*5;
        if(shazbot == 0)
        {output = Name1 + " pitched for the " + Team1 + ", with " + Name2 + "pitching for the " + Team2 + ".";}
        else if(shazbot == 1)
        {output = "The Pitcher ";}
        else if(shazbot == 2)
        {output = Name1 + ", the pitcher for " + Team1 ;}
        else if(shazbot == 3)
        {output = Name2 + ", the pitcher for " + Team2 ;}
        else if(shazbot == 4)
        {output = "";}
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
