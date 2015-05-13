package modules;
import data.*;
import utilities.*;

public class ExtraInnings extends ReportModule<BaseballData>
{
    public String generate ()
    {
        int numInnings = 10;
        String team1 = "Angels";
        String team2 = "Balls";
        
        if (numInnings > 9)
        {
            String x;
            int a = (int) (Math.random() * 5);
            if (a == 0)
            {
                x = "The " + team1 + " beat the " + team2 + " in a " + numInnings + " inning game today.";
            }
            else if (a ==1)
            {
                x = "The game went to " + numInnings + " innings.";
            }
            
            else if (a == 2)
            {
                x = "After the first nine innings, the game lasted " + (numInnings - 9) +
                    " more innings.";
            }
            else if (a == 3)
            {
                x = "Fans got more than they payed for today as the game lasted " + (numInnings) +
                " innings.";
            }
            else
            {
                x = "The fans were tossing back the bud lights in this " + (numInnings) + " inning thriller.";
            }
        
    
              
                
            if (numInnings > 33 )
            {
                x = x.concat (" The previous record for the longest MLB game was 33 innings, however " +
                " that record has been broken today as the " + team1 + " beat the " + team2 + 
                " in a " + numInnings + " inning affair.");
               
            }
            else if (numInnings > 13)
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