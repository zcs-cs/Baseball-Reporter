package modules;


/**
 * Write a description of class TempPitchEdits here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TempPitchEdits
{
   public String betterGame()
    {
      if (strikeouts1 > strikeouts2 && battersFaced1 > battersFaced2)
      {
        if(strikeouts1 >= battersFaced1 / 2)
        {
            output += Name1 + " destroyed the " + Team2 + ", with more than half of the batters faced being struck out.";
        }
        else if(strikeouts1 >= battersfaced1 / 3)
        {
            output += Name1 + "Had a good game against" + Team2 + ".";
        }
        else
        {
            output += Name1 + "had a better game than " + Name2 + ".";
        }
     }
     
     else if (strikeouts1 < strikeouts2 && battersFaced1 < battersFaced2)
        {
            if(strikeouts2 >= battersFaced2 / 2)
        {
            output += Name2 + " destroyed the " + Team1 + ", with more than half of the batters faced being struck out.";
        }
        else if(strikeouts1 >= battersfaced1 / 3)
        {
            output += Name2 + "Had a good game against" + Team1 + ".";
        }
        else
        {
            output += Name2 + "had a better game than " + Name1 + ".";
        }
      }
     else 
     {
        if(strikeouts1 > Strikeouts2)
        {
            output += Name1 + " struck out the most batters";
        }
        else if(strikeouts1 < Strikeouts2)
        {
            output += Name2 + "Struck out the most batters";
        }
        else
        {
            output += "The two best pitchers in the game were absolutely incomperable.";
        }
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
