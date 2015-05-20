package modules;
import data.*;
import utilities.*;
public class InjuryModule extends ReportModule<BaseballData>
{
    public InjuryModule(BaseballData data) { super(data); }
    //THIS IS A WORK OF CALEB DONOHO
    public String generate()
    {
        String end = "";
        String[][] names;
        int[][] timeOut;
        String[][] type;
        String[][] location;
        return end;
    }
    private static String randomName(String first, String last, boolean capital, boolean firstln)
    {
        int rand;
        if(firstln)
        {
            rand = (int)(Math.random() * 3);
        }
        else
        {        
            rand = (int)(Math.random() * 4);
        }
        if(rand == 0)
        {
            return first;
        }
        else if(rand == 1)
        {
            return last;
        }
        else if(rand == 2)
        {
            return first + " " + last;
        }
        else
        {
            if(capital)
            {
                return "He";
            }
            else
            {
                return "he";
            }
        }
    }
    public static String reportInjury(String name, String type, String location, int timeOut)
    {
        String first = name.substring(0, name.indexOf(" "));
        String last = name.substring(name.indexOf(" ") + 1, name.length());
        String end = "";
        int rand = (int)(Math.random() * 4);
        if(rand == 0)
        {
            end += ("As for injuries, " + randomName(first, last, false, true) + " " +  type + " his " + location + ".");
        }
        else if(rand == 1)
        {
            end += (randomName(first, last, true, true) + " " +  type + " his " + location + ".");
        }
        else if(rand == 2)
        {
            end += (randomName(first, last, true, true) + " got hurt in the game. He " + type + " his " + location + ".");
        }
        else if(rand == 3)
        {
            end += ("Unfortunately, " + randomName(first, last, false, true) + " " + type + " his " + location + ".");
        }
        rand = (int)(Math.random() * 2);
        if(rand == 0)
        {
            end += (" " + randomName(first, last, true, false) + " will be out for " + timeOut + " games.");
        }
        else
        {
            end += (" The number of games " + randomName(first , last, false, false) + " will be out for is " + timeOut + ". ");
        }
        return end;
    }
}