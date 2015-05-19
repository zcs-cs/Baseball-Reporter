package modules;
import data.BaseballData;
import java.util.Random;

public class StandingsModule extends ReportModule<BaseballData>
{
    /**
     *  * * * * * *
     * Incomplete *
     *  * * * * * *
     */
    int score1, score2, indianswin = 0, indiansloss = 0, indianspct = 0, batsloss = 0, batswin = 0, batspct = 0, clipperspct, henspct, indiansposition, batsposition, hensposition, clippersposition,function;
    Random generator = new Random();
    public String generate()
    {
        int random = generator.nextInt(1);
        if (random == 0)
        {
            if (function == 1)
                return "The Indians are now in position " + indiansposition + "and the Bats are in position " + batsposition + ".";
            else if (function == 2)
                return "";
            else
                return "The standings can't be found at this time.";
        }
        else
        {
            if (function == 1)
                return "";
            else if (function == 2)
                return "";
            else
                return "The standings are not available right now.";
        }
    }

    private void setScores ()
    {
        score1 = 4; //Indians score
        score2 = 5; //Bats score
        if (score1 > score2) //Indians won
        {
            indianswin += 1; //indians standings win
            batsloss += 1;
            indianspct = (indianswin / (indianswin + indiansloss)) + 100; //pctforindians
            batspct = (batswin / (batswin + batsloss)) + 100;
        }
        else if (score1 < score2) //Bats won
        {
            batswin += 1; //indians standings win
            indiansloss += 1;
            indianspct = (indianswin / (indianswin + indiansloss)) + 100; //pctforindians
            batspct = (batswin / (batswin + batsloss)) + 100;
        }
        else //tied
        {
            indianspct = (indianswin / (indianswin + indiansloss)) + 100; //pctforindians
            batspct = (batswin / (batswin + batsloss)) + 100;
        }
    }

    private void standings()
    {
        if (indianspct > batspct)
        {
            indiansposition = 3;
            batsposition = 4;
            if (indianspct > clipperspct)
            {
                indiansposition = 2;
                clippersposition = 3;
                if (indianspct > henspct)
                {
                    indiansposition = 1;
                    hensposition = 2;
                }
            }
            function = 1;
        }
        else if (indianspct < batspct)
        {
            batsposition = 3;
            indiansposition = 4;
            if (batspct > clipperspct)
            {
                batsposition = 2;
                clippersposition = 3;
                if (batspct > henspct)
                {
                    batsposition = 1;
                    hensposition = 2;
                }
            }
            function = 2;
        }
    }
}