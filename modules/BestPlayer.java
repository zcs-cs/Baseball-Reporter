package modules;
import java.util.*;
import data.*;
import utilities.*;
public class BestPlayer extends ReportModule<BaseballData>
{
    
      public String generate()
     {
         return "Lebron James is the king and therefore the best player of all time.";
     }
     
     
  class Player
   {
    String name = "";
    int hits, atbats, hr, rbi;
    double rating = 0.0;
    ArrayList<String> typeofhits = new ArrayList();    

    public Player()
    {
        name = "Jose";
        hits = 0;
        atbats = 0;
        hr = 0;
        rbi = 0; 
        /*
        * The Player Rating class takes the data from the player and determines their rating. The points are taken accordingly
        * 
        * HR = 1.00
        * RBI = .25
        * HIT = .5
        * ATBAT = .1
        * 
        */
       rating += hr * 1;
       rating += rbi* .25;
       rating += hits * .5;
       rating += atbats * .1;
    }

    public Player(String playerName, int numHits, int numAtBats, int numHr, int numRbi)
    {
        name = playerName;
        hits = numHits;
        atbats = numAtBats;
        hr = numHr;
        rbi = numRbi;
        /*
        * The Player Rating class takes the data from the player and determines their rating. The points are taken accordingly
        * 
        * HR = 1.00
        * RBI = .25
        * HIT = .5
        * ATBAT = .1
        * 
        */
       rating += hr * 1;
       rating += rbi* .25;
       rating += hits * .5;
       rating += atbats * .1;
    }
    
    public String getName()
    {
        return name;
    }

    public int getHits()
    {
        return hits;
    }   

    public int getAtBats()
    {
        return atbats;
    }    

    public int getHR()
    {
        return hr;
    }

    public int getRBI()
    {
        return rbi;
    }
    
    public double getPlayerRating()
    {
       return rating;
   }  
  }
   
      public Player BestPlayer(ArrayList<Player> team)
      {
       Player max = new Player();
       for (int x = 0; x < team.size(); x++)
       {
         if (team.get(x).getPlayerRating() > max.getPlayerRating())
         {
             max = team.get(x);
        }
      }
      return max;
     }
}
