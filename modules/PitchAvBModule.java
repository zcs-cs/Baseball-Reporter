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
 *  by bryce bryce josh and dan
 */
public class PitchAvBModule extends ReportModule<BaseballData>
{
    public PitchAvBModule(BaseballData data) { super(data); }
    boolean DEBUG = false;
    
    int runs1, runs2, strikeouts1, strikeouts2, battersFaced1, battersFaced2;
    String Name1, Name2, Team1, Team2, output;
    ArrayList<PitcherPlayer> aPitchers, bPitchers;
    PitcherPlayer aBest, bBest;
    public String generate()
    {
        dp("Starting AvB module");
        BaseballData d = (BaseballData)data;
        //This is a generic statement generator
        // populate pitcher list
        aPitchers = new ArrayList<PitcherPlayer>();
        bPitchers = new ArrayList<PitcherPlayer>();
        dp("Initialized pitcher arrays.");
        int counter = 0;
        try{
            while(counter < 15){
                dp("  Trying to create a new pitcher for team A with index "+counter);
                PitcherPlayer p = new PitcherPlayer(d, 'a', counter);
                dp("    Success! Made "+p.toString());
                aPitchers.add(p);
                counter++;
            }
        }catch (Exception e){
        }
        dp(aPitchers.toString());
        counter = 0;
        try{
            while(counter < 15){
                dp("  Trying to create a new pitcher for team B with index "+counter);
                PitcherPlayer p = new PitcherPlayer(d, 'b', counter);
                dp("    Success! Made "+p.toString());
                bPitchers.add(p);
                dp("("+p.firstName()+") ("+p.lastName()+")");
                counter++;
            }
        }catch (Exception e){
        }
        dp(bPitchers.toString());
        // find the best pitchie
        int numIn = 0;
        for(PitcherPlayer pp : aPitchers){
            if (numIn < pp.totalInningsPitched()){
                aBest = pp;
                numIn = pp.totalInningsPitched();
            }
        }
        numIn = 0;
        for(PitcherPlayer pp : bPitchers){
            if (numIn < pp.totalInningsPitched()){
                bBest = pp;
                numIn = pp.totalInningsPitched();
            }
        }
        
        ////////////////////opening sentence introducing best pitchers////////////////////
        
        int select = (int)(Math.random()*5.0); // 5 options
        Name1 = aBest.name();
        Name2 = bBest.name();
        Team1 = aBest.teamDemonym();
        Team2 = bBest.teamDemonym();
        switch(select){
            case 0:
                output = "Best pitchers for the game were " +Name1+ " of the " +Team1+ ", and " +Name2+ " pitching for the " +Team2+ ". "; 
                break;
            case 1:
                output = "The " + Team1+ "'s best pitcher, " +Name1+ ", went up against "+Name2+" of the " +Team2+ ". ";
                break;
            case 2:
                output = "The " + Team2+ "'s best pitcher, " +Name2+ ", went up against "+Name1+" of the " +Team1+ ". ";
                break;
            case 3:
                output = "Pitchers " +Name1+ " and " +Name2+ " faced off in the game between " +Team1+ " and " +Team2+ ". ";
                break;
            case 4:
                output = "Pitchers " +Name2+ " and " +Name1+ " faced off in the game between " +Team2+ " and " +Team1+ ". ";
                break;
        }
        
        //////////////////////////////////////////////////////////////////////////////////
        
        ////////////////////////////////next sentence/////////////////////////////////////
        output += saves();
        //betterGame();
        
        //////////////////////////////////////////////////////////////////////////////////
        
        
        return output;
    }
    public String betterGame()
    {
        
      if (strikeouts1 > strikeouts2 && battersFaced1 > battersFaced2)
      {
        if(strikeouts1 >= battersFaced1 / 2)
        {
            output += Name1 + " destroyed the " + Team2 + ", with more than half of the batters faced being struck out.";
        }
        else if(strikeouts1 >= battersFaced1 / 3)
        {
            output += Name1 + " had a good game against" + Team2 + " with a total of " +strikeouts1+ ".";
        }
        else
        {
            output += Name1 + " had a better game than " + Name2 + ".";
        }
     }
     
     else if (strikeouts1 < strikeouts2 && battersFaced1 < battersFaced2)
        {
            if(strikeouts2 >= battersFaced2 / 2)
        {
            output += Name2 + " destroyed the " + Team1 + ", with more than half of the batters faced being struck out.";
        }
        else if(strikeouts1 >= battersFaced1 / 3)
        {
            output += Name2 + ", striking out " +strikeouts2+ " players,  had a good game against" + Team1 + ".";
        }
        else
        {
            output += Name2 + " had a better game than " + Name1 + ".";
        }
      }
     else 
     {
        if(strikeouts1 > strikeouts2)
        {
            output += Name1 + " struck out the most batters.";
        }
        else if(strikeouts1 < strikeouts2)
        {
            output += Name2 + " struck out the most batters.";
        }
        else
        {
            output += "The two best pitchers in the game were absolutely incomperable.";
        }
        }
     return output;
    
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
    
    public String saves(){
        String out = "";
        int[] aInnings = aBest.inningsPitched(), bInnings = bBest.inningsPitched();
        int aLastInning = 0, bLastInning = 0;
        for(int i = 0; i < aInnings.length; i++){
            if (aInnings[i] > aLastInning){
                aLastInning = aInnings[i];
            }
        }
        for(int i = 0; i < bInnings.length; i++){
            if (bInnings[i] > bLastInning){
                bLastInning = bInnings[i];
            }
        }
        
        // find pitchers that pitched the same inning or the inning after the main pitcher
        PitcherPlayer aSave = null, bSave = null;
        int aSaveInning = 9, bSaveInning = 9;
        if (aBest.totalInningsPitched() > 3){ // is the pitcher tired?
            for (PitcherPlayer pp : aPitchers){
                if (pp != aBest){
                    int[] innings = pp.inningsPitched();
                    
                    for(int i : innings){
                        if (i == aLastInning || i == aLastInning+1){
                            aSaveInning = i;
                            aSave = pp;
                        }
                    }
                    
                }
            } // REPEAT FOR TEAM B;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
        }
        if (bBest.totalInningsPitched() > 3){
            for (PitcherPlayer pp : bPitchers){
                if (pp != bBest){
                    int[] innings = pp.inningsPitched();
                    
                    for(int i : innings){
                        if (i == bLastInning || i == bLastInning+1){
                            bSaveInning = i;
                            bSave = pp;
                        }
                    }
                    
                }
            }
        }
        
        // generate sentence if aSave or bSave is not null
        if(aSave != null && bSave == null){
            out = " "+ aSave.name() + " gave " + aBest.lastName() + " a well deserved break in the " + intToText(aSaveInning) +
                " inning. " + aSave.lastName()+" took the mound after " + aBest.lastName() + " had pitched " +
                aBest.totalInningsPitched() + " innings earlier.";
        } else if (aSave == null && bSave != null){
            out = " "+ bSave.name() + " gave " + bBest.lastName() + " a well deserved break in the " + intToText(bSaveInning) +
                " inning. " + bSave.lastName()+" took the mound after " + bBest.lastName() + " had pitched " +
                bBest.totalInningsPitched() + " innings earlier.";
        } else if (aSave != null && bSave != null){ // both relieved star pitchers, which was more impressive?
            if (aBest.totalInningsPitched() > bBest.totalInningsPitched()){
                out = " "+ aSave.name() + " gave " + aBest.lastName() + " a well deserved break in the " + intToText(aSaveInning) +
                    " inning. " + aSave.lastName()+" took the mound after " + aBest.lastName() + " had pitched " +
                    aBest.totalInningsPitched() + " innings earlier.";
            } else if (bBest.totalInningsPitched() > aBest.totalInningsPitched()){
                out = " "+ bSave.name() + " gave " + bBest.lastName() + " a well deserved break in the " + intToText(bSaveInning) +
                    " inning. " + bSave.lastName()+" took the mound after " + bBest.lastName() + " had pitched " +
                    bBest.totalInningsPitched() + " innings earlier.";
            } else {
            }
        }
        
        if (out == ""){
            out = "Both teams utilized a variety of pitchers; relief pitchers were common in this game.";
        }
        return out;
    }
    private String intToText(int in){
        String[] nums = {"first",
                         "second",
                         "third",
                         "fourth",
                         "fifth",
                         "sixth",
                         "seventh",
                         "eighth",
                         "ninth"};
        try{
            return nums[in-1];
        } catch (Exception e){
            return "final";
        }
    }
    private void dp(String in){ // debug printer
        if(DEBUG){
            System.out.println("Pitch AvB: "+in);
        }
    }
}










