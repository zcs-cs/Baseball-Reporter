package modules;
import java.util.*;
import data.*;
import utilities.*;
public class BestPlayer extends ReportModule<BaseballData>
{
  class Player
   {
    String name = "";
    int hits, atbats, hr, rbi;
    ArrayList<String> typeofhits = new ArrayList();    

    public Player()
    {
        name = "Jose";
        hits = 0;
        atbats = 0;
        hr = 0;
        rbi = 0;      
    }    

    public Player(String playerName, int numHits, int numAtBats, int numHr, int numRbi)
    {
        name = playerName;
        hits = numHits;
        atbats = numAtBats;
        hr = numHr;
        rbi = numRbi;
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
    
    public double getPayerRating()
    {
       /*
        * The Player Rating class takes the data from the player and determines their rating. The points are taken accordingly
        * 
        * HR = 1.00
        * RBI = .25
        * HIT = .5
        * ATBAT = .1
        * 
        */
       double rating = 0.0;
       rating += getHR() * 1;
       rating += getRBI() * .25;
       rating += getHits() * .5;
       rating += getAtBats() * .1;
       
       return rating;
    }
   }  
   
   
public class PlayerSearcher
{
    ArrayList<Player> TeamA = new ArrayList();
    ArrayList<Player> TeamB = new ArrayList();
    public PlayerSearcher()
    {
        
    }
//     public String BestPlayer(ArrayList<Player> team)
//     {
//        double max = 0.0;
//        String name = "";
//        for (int x = 0; x < team.size(); x++)
//        {
//          if (p.getPlayerRating() > max)
//          {
//              max = p.getPlayerRating;
//              name = p.getName();
//         }
//     }
}

public String generate()
{
    return "The best player was Lebron James with 10 HR.";
}
}
