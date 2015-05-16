package modules;


/**
 * Write a description of class TempPitchEdits here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TempPitchEdits
{
   private int strikeouts1, strikeouts2, battersFaced1, battersFaced2, runs1, runs2;
   private String Name1, Name2, Team1, Team2;
   
   public TempPitchEdits(int strikeouts1, int strikeouts2, 
                         int battersFaced1, int battersFaced2,
                         int runs1, int runs2,
                         String Name1, String Name2,
                         String Team1, String Team2)
   {
       this.strikeouts1 = strikeouts1;
       this.strikeouts2 = strikeouts2; 
       this.battersFaced1 = battersFaced1;
       this.battersFaced2 = battersFaced2;
       this.runs1 = runs1;
       this.runs2 = runs2;
       this.Name1 = Name1;
       this.Name2 = Name2;
       this.Team1 = Team1;
       this.Team2 = Team2;
   }
   
   //Temporary fix above. Please change as needed.
   
   public String betterGame()
    {
     String output = "";
      if (strikeouts1 > strikeouts2 && battersFaced1 > battersFaced2)
      {
        if(strikeouts1 >= battersFaced1 / 2)
        {
            output += Name1 + " destroyed the " + Team2 + ", with more than half of the batters faced being struck out.";
        }
        else if(strikeouts1 >= battersFaced1 / 3)
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
        else if(strikeouts1 >= battersFaced1 / 3)
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
        if(strikeouts1 > strikeouts2)
        {
            output += Name1 + " struck out the most batters";
        }
        else if(strikeouts1 < strikeouts2)
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
