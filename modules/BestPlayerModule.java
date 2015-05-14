package modules;
import java.util.*;
import data.*;
import utilities.*;
public class BestPlayerModule extends ReportModule<BaseballData>
{
    ArrayList<Player> TeamA = new ArrayList<>();
    ArrayList<Player> TeamB = new ArrayList<>();
      public String generate()
     {
         Player bestplayerA = new Player();
         Player bestplayerB = new Player();
         //TeamA.fill()
         //TeamB.fill()     
         TeamA.tempfill();
         TeamB.tempfill();
         bestplayerA = BestPlayer(TeamA);
         bestplayerB = BestPlayer(TeamB);
         return bestplayerA.toString() + " meanwhile, " + bestplayerB.toString();
     }
     
     public void fill(String teamname)
     {
         
        }
        
     public static void tempfill()
     {
         int rand = (int)(Math.random()*5)+4;
         String jams = new String("Juan");
         int potato = ((int)(Math.random()*4));
         for (int i = 0; i < rand; i++)
         {
             add(new Player(jams, potato, potato + (int)(Math.random()*5), (int)(Math.random()*2), ((int)(Math.random()*6)+1)));
            }
        }
     
     
  class Player
   {
    String name = "", team = "";
    int hits, atbats, hr, rbi;
    double rating = 0.0;
    //Not used - ArrayList<String> typeofhits = new ArrayList();    

    public Player()
    {
        name = "Jose";
        hits = 0;
        atbats = 0;
        hr = 0;
        rbi = 0; 
        rating = 0.0;
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
   
   public String getTeamName()
   {
       return team;
    }
    
   public String toString()
   {
     String intro = "", info = "";
     int rand;
     String intros[] = new String[2];
     String infos[] = new String[2];
     
     intros[0] = getTeamName() + "'s " + getName() + " played well, ";
     //Example Cubs's Alfonso Soriano played well, 
     intros[1] = "The " + getTeamName() + " " + getName() + " had a good day, "; 
     //Example The Cubs Alfonso Soriano had a good day 
     
     
     infos[0] = "contributing " + getHR() + " HRs and " + getRBI() + " RBIs. He went " + getHits() + "-" + getAtBats() + " for the day.";
     //Example contributing 2 HRs and 5 RBIs. He went 4-5 for the day.
     infos[1] = "going " + getHits() + "-" + getAtBats() + " while bringing in " + getRBI() + " RBIs. He also hit " + getHR() + "HRs. ";
     //Example going 4-5 while bringing in 5 RBIs. He also hit 2 HRs.
     
     rand = (int)(Math.random()*2);
     intro = intros[rand];
     rand = (int)(Math.random()*2);
     info = infos[rand];
     return intro + info;
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
