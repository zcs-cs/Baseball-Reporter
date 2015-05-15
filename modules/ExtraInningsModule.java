package modules;

import data.*;
import utilities.*;

public class ExtraInningsModule extends ReportModule<BaseballData>
{
    public String generate ()
    {
        //int innings = 10;
        //String team1 = this.teamName(true);
        //String team2 = teamName(false);
        
        if (data.innings() > 9)
        {
            String x;
            int a = (int) (Math.random() * 5);
            if (a == 0)
            {
                x = "The " + data.teamName(true) + " beat the " + data.teamName(false) + " in a " + data.innings() + " inning game today.";
            }
            else if (a ==1)
            {
                x = "The game went to " + data.innings() + " innings.";
            }
            
            else if (a == 2)
            {
                x = "After the first nine innings, the game lasted " + (data.innings() - 9) +
                    " more innings.";
            }
            else if (a == 3)
            {
                x = "Fans got more than they payed for today as the game lasted " + (data.innings()) +
                " innings.";
            }
            else
            {
                x = "The fans were tossing back the bud lights in this " + (data.innings()) + " inning thriller.";
            }
        
    
              
                
            if (data.innings() > 33 )
            {
                if (data.teamResult(true) ) {
                    x = x.concat (" The previous record for the longest MLB game was 33 innings, however " +
                    " that record has been broken today as the " + data.teamName(true) + " beat the " + data.teamName(false) + 
                    " in a " + data.innings() + " inning affair."); }
                else {
                    x = x.concat (" The previous record for the longest MLB game was 33 innings, however " +
                    " that record has been broken today as the " + data.teamName(false) + " beat the " + data.teamName(true) + 
                    " in a " + data.innings() + " inning affair."); }
               
            }
            else if (data.innings() > 13)
            {
                x = x.concat (" The record for the longest MLB game " + 
                " is a 33 inning game between the Chicago White Sox and the Milwaukee Brewers. " +
                "This particular game lasted 8 hours and 6 minutes.");
                
            }
            return x;
        }
            
        return "";
    }
}