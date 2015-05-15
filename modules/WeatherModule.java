package modules;

import data.BaseballData;
import utilities.*;

public class WeatherModule extends ReportModule<BaseballData>
{
    public String generate()
    {
        String result = "";
        double temp = data.temperature();
        double rain = data.rainfall();
        int time = data.startTime();
        String loc = data.location();

        //time and location
        int rand = 1 + (int) (Math.random() * 1000);
        if (rand < 333)
        {
            result += "The game went down in the " + timeStr(time) + " at " + loc + ".  ";
        }
        else if (rand < 666)
        {
            result += "A hellish game was played at " + loc + " in the " + timeStr(time) + ".  ";
        }
        else if (rand <= 999)
        {
            result += "It was " + timeStr(time) + " at " + loc + ".  ";
        }
        else if (rand == 1000)
        {
            result += "There was baseball at " + loc + " during the " + timeStr(time) + ".  SPORTS!!!!  ";
        }

        //temperature and rain
        rand = 1 + (int) (Math.random() * 5);
        if (rand == 1)
        {
            result += "It was a " + tempStr(temp) + " and " + rainStr(rain) + " day.";
        }
        else if (rand == 2)
        {
            result += "It was a " + rainStr(rain) + ", " + tempStr(temp) + " day, with the temperature reaching " + temp + " degrees Fahrenheit.";
        }
        else if (rand == 3)
        {
            result += "The skies were " + rainStr(rain) + " on this " + tempStr(temp) + " day.";
        }
        else if (rand == 4)
        {
            result += "The weather was " + tempStr(temp) + " and " + rainStr(rain) + ".";
        }
        else if (rand == 5)
        {
            result += "Fans were blessed with " + rainStr(rain) + " and " + tempStr(temp) + " weather during the game.";
        }

        return result;
    }

    private static String tempStr (double temp)
    {
        if (temp <= 32)
        {
            return "frigid";
        }
        if (temp <= 60)
        {
            return "cool";
        }
        if (temp <= 80)
        {
            return "warm";
        }
        return "hot";
    }

    private static String rainStr (double rain)
    {
        if (rain == 0)
        {
            return "clear";
        }
        if (rain <= 0.3)
        {
            return "drizzly";
        }
        return "rainy";
    }

    private static String timeStr (int time)
    {
        if (time < 1200)
        {
            return "morning";
        }
        if (time < 1800)
        {
            return "afternoon";
        }
        return "evening";
    }
}
