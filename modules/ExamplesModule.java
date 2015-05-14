package modules;

import data.BaseballData;
import utilities.*;

public class ExamplesModule extends ReportModule<BaseballData>
{
    // generation example of example title and concatenated method call examples //
    public String generate()
    {
        return "Baseball Game was a great success.\n" 
                + examplesConcatenated() /*+nextMethods()*/;
    }
    
    // method calling examples - altogether //
    private String examplesConcatenated()
    {
        return primaryStatisticsExample() + "\n\n" + 
                teamStatisticsExample() + "\n\n "+ 
                TeamPlayersStatisticsExample();
    }

    // method calling examples - primary statistics //
    private String primaryStatisticsExample()
    {
        return "location: " + data.location() + 
              "\ncity: " + data.city() + 
              "\ntemperature: " + data.temperature() + 
              "\nrainfall: " + data.rainfall() + 
              "\ndate: " + data.date() + 
              "\nstart time: " + data.startTime() + 
              "\nminutes: " + data.minutes() + 
              "\ninnings: " + data.innings();
    }
    // method calling examples - team statistics [including 'Random.text_of()' example] //
    private String teamStatisticsExample()
    {
        String statement = "The " + data.teamName(true) + ", or '" + data.teamDemonym(true) + "' for short, are from " + data.teamHomecity(true) + ". ";
        
        statement += data.teamResult(true) ? "They won their game!" : "They lost their game!";
        
        int[] teamInningScores = data.teamInningScores(true);
        String[] ordinals = {"first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth"};
        for (int i = 0; i < teamInningScores.length; i++)
        {
            statement += "\nThe score for the " + ordinals[i + 1] + " inning was " + teamInningScores[i] + ".";
        }
        statement += "\n";
        statement += Random.text_of(new String[] { 
            "Their total score was " + data.teamScore(true), 
            "The final tally for the team was " + data.teamScore(true)
            }) + ".";
        statement += "This puts their standing at " + data.teamStandingsPosition(true) + 
                    ". They have had " + data.teamStandingsWins(true) + " wins. They have had a " + 
                    data.teamStandingsStreak(true)+" game win streak. They have had " + data.teamStandingsStreak(true) + " losses.";
        return statement;
    }
    // method calling examples - team players statistics [including 'Text.capitalize()' and 'Function.line()' examples] //
    private String TeamPlayersStatisticsExample()
    {
        String statement = "";
        String teamDemonymCapitalized = Text.capitalize(data.teamDemonym(true));
        statement += teamDemonymCapitalized + " players' names: " + Array.text(data.teamPlayersNames(true)) +"\n";
        statement += teamDemonymCapitalized + " players' bats: " + Array.text(data.teamPlayersBats(true));
        statement += teamDemonymCapitalized + " players' RBIs: " + Array.text(data.teamPlayersRBIs(true));
        statement += teamDemonymCapitalized + " players' hits (counts): " + Array.text(data.teamPlayersHits(true));
        statement += teamDemonymCapitalized + " players' hits' descriptions: " + Array.text(data.teamPlayersHitsDescriptions(true));
        statement += teamDemonymCapitalized + " players' runs (counts): " + Array.text(data.teamPlayersRuns(true));
        statement += teamDemonymCapitalized + " players' runs' innings: " + Array.text(data.teamPlayersRunsInnings(true));
        statement += teamDemonymCapitalized + " players' runs' balls' runs: " + Array.text(data.teamPlayersRunsBallsRuns(true));
        statement += teamDemonymCapitalized + " players' injuries' games missed: " + Array.text(data.teamPlayersInjuriesGamesMissed(true));
        statement += teamDemonymCapitalized + " players' injuries' types: " + Array.text(data.teamPlayersInjuriesTypes(true));
        statement += teamDemonymCapitalized + " players' injuries' locations: " + Array.text(data.teamPlayersInjuriesLocations(true));
        statement += "\n";
        
        statement += "Here's some example player talk...";
        String hitsPluralization = "";
        if (data.teamPlayersHits(true)[0] == 1)
            hitsPluralization = "hit";
        else
            hitsPluralization = "hits";
        String[] run_descriptions = new String[] {"no", "one good", "two", "several", "many"};
        int runDescriptionIndex = -1;
        if (data.teamPlayersRuns(true)[0] > 5)       runDescriptionIndex = 5;
        else        runDescriptionIndex = Function.line(0, 0, run_descriptions.length, 5, data.teamPlayersRuns(true)[0]);
        String runsDescription = run_descriptions[runDescriptionIndex];
        String runPunctuation = "";
        if (runDescriptionIndex <= 2)     runPunctuation = ".";
        else        runPunctuation = "!";
        return data.teamPlayersNames(true)[0]+" got "+data.teamPlayersHits(true)[0]+" "+hitsPluralization+" out of "+data.teamPlayersBats(true)[0]+" bats. He achieved "+runsDescription+" ("+data.teamPlayersRuns(true)[0]+") runs"+runPunctuation;
    }
}
