package modules;

import data.BaseballData;
import utilities.*;

public class ExamplesModule extends ReportModule<BaseballData>
{
    // generation of concatenated method call examples //
    public String generate()
    {
        return primaryStatisticsExample()+"\n\n"+teamStatisticsExample()+"\n\n"+TeamPlayersStatisticsExample();
    }
    
    // Please see the ReportData interface for a listing of every data retrieval method in BaseballData.

    // method calling examples - primary statistics [including 'Array.permute()' example] //
    private String primaryStatisticsExample()
    {
        String[] weatherDescriptions = Array.permute(new String[] {"", "quite"}, new String[] {"freezing", "frigid", "cold", "cool", "refreshing", "moderate", "warm", "hot", "sweaty", "unbearable"});
        int weatherDescriptionIndex = (data.temperature() > 100) ? weatherDescriptions.length : (int) Function.line(0, 0, 100, weatherDescriptions.length, data.temperature());
        String rainStatement = (data.rainfall() > 1) ? "It rained "+data.rainfall()+" inches" : "The weather was clear";
        return "The game took place at "+data.location()+" in "+data.city()+". It lasted for "+data.innings()+" innings. The temperature was a "+weatherDescriptions[weatherDescriptionIndex]+" "+data.temperature()+" degrees. "+rainStatement+". The game began at: "+data.startTime()+" (in military time). It lasted for "+data.minutes()+" minutes.";
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
            statement += " The score for the " + ordinals[i] + " inning was " + teamInningScores[i] + ".";
        }
        statement += " "+Random.text_of(new String[] { 
            "Their total score was " + data.teamScore(true), 
            "The final tally for the team was " + data.teamScore(true)
            }) + ".";
        statement += " This puts their standing at " + data.teamStandingsPosition(true) + 
                    ". They have had " + data.teamStandingsWins(true) + " wins. They have had a " + data.teamStandingsStreak(true)+" game win streak. They have had " + data.teamStandingsStreak(true) + " losses.";
        return statement;
    }
    // method calling examples - team players statistics [including 'Text.capitalize()' and 'Function.line()' examples] //
    private String TeamPlayersStatisticsExample()
    {
        String statement = "";
        // general players talk //
        String teamDemonymCapitalized = Text.capitalize(data.teamDemonym(true));
        statement += teamDemonymCapitalized + " players' names: " + Array.text(data.teamPlayersNames(true))+"\n";
        statement += teamDemonymCapitalized + " players' bats: " + Array.text(data.teamPlayersBats(true))+"\n";
        statement += teamDemonymCapitalized + " players' hits (counts): " + Array.text(data.teamPlayersHits(true))+"\n";
        statement += teamDemonymCapitalized + " players' hits' descriptions: " + Array.text(data.teamPlayersHitsDescriptions(true))+"\n";
        statement += teamDemonymCapitalized + " players' hit's RBIs: " + Array.text(data.teamPlayersHitsRBIs(true))+"\n";
        statement += teamDemonymCapitalized + " players' RBIs (totals): " + Array.text(data.teamPlayersRBIs(true))+"\n";
        statement += teamDemonymCapitalized + " players' runs (counts): " + Array.text(data.teamPlayersRuns(true))+"\n";
        statement += teamDemonymCapitalized + " players' runs' innings: " + Array.text(data.teamPlayersRunsInnings(true))+"\n";
        statement += teamDemonymCapitalized + " players' injuries' games missed: " + Array.text(data.teamPlayersInjuriesGamesMissed(true))+"\n";
        statement += teamDemonymCapitalized + " players' injuries' types: " + Array.text(data.teamPlayersInjuriesTypes(true))+"\n";
        statement += teamDemonymCapitalized + " players' injuries' locations: " + Array.text(data.teamPlayersInjuriesLocations(true))+"\n";
        statement += "\n\n";
        
        // specific player talk //
        String hitsPluralization = (data.teamPlayersHits(true)[0] == 1) ? "hit" : "hits";
        String[] runDescriptions = new String[] {"no", "one good", "two", "several", "four", "many"};
        int runDescriptionIndex = (data.teamPlayersRuns(true)[0] > 5) ? 5 : Function.line(0, 0, 5, runDescriptions.length, data.teamPlayersRuns(true)[0]);
        String runsDescription = runDescriptions[runDescriptionIndex];
        String runPunctuation = (runDescriptionIndex <= 2) ? "." : "!";
        statement += data.teamPlayersNames(true)[0]+" got "+data.teamPlayersHits(true)[0]+" "+hitsPluralization+" out of "+data.teamPlayersBats(true)[0]+" bats. He achieved "+runsDescription+" ("+data.teamPlayersRuns(true)[0]+") runs"+runPunctuation;
        
        return statement;
    }
}
