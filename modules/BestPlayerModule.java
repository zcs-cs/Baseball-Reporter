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
//<<<<<<< HEAD
         //TeamA.fill()
         //TeamB.fill()     
         tempfill(TeamA);
         tempfill(TeamB);
//=======
         //TeamA.fill();
         //TeamB.fill() ;        
//>>>>>>> origin/master
         bestplayerA = BestPlayer(TeamA);
         bestplayerB = BestPlayer(TeamB);
         return bestplayerA.toString() + " meanwhile, " + bestplayerB.toString();
     }
     
     public void fill(String teamname)
     {
         
        }
        
     public void tempfill(ArrayList<Player> team)
     {
         for (int i = 0; i < 8; i++)
         {
             team.add(new Player());
            }
         team.add(new Player("BestPlayer", 10, 10, 10, 40, "Cubs"));
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
        team = "Marlins";
    }

    public Player(String playerName, int numHits, int numAtBats, int numHr, int numRbi, String teamnam)
    {
        name = playerName;
        hits = numHits;
        atbats = numAtBats;
        hr = numHr;
        rbi = numRbi;
        team = teamnam;
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
    
   public String generate()
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
