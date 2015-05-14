package modules;

import data.BaseballData;
import utilities.*;

public class ExamplesModule extends ReportModule<BaseballData>
{
    // generation example of example title and concatenated method call examples //
    public String generate()
    {
        return "Baseball Game was a great success.\n"+examplesConcatenated()/*+nextMethods()*/;
    }
    
    // method calling examples - altogether //
    private String examplesConcatenated()
    {
        return primaryStatisticsExample()+"\n"+teamPrimaryStatisticsExample()+"\n"+TeamPlayerStatisticsExample();
    }

    // method calling examples - primary statistics //
    private String primaryStatisticsExample()
    {
        return "location: "+data.location()+"\ncity: "+data.city()+"\ntemperature: "+data.temperature()+"\nrainfall: "+data.rainfall()+"\ndate: "+data.date()+"\nstart time: "+data.startTime()+"\nminutes: "+data.minutes();+"\ninnings: "+data.innings();
    }

    // method calling examples - team primary statistics [including 'Random.text_of()' example] //
    private String teamPrimaryStatisticsExample()
    {
        String statement = "The "+data.teamName(true)+", or '"+data.teamDemonym(true)+"' for short, are from "+data.teamHomecity(true)+". ";
        if (data.teamResult(true))       statement += "They won their game!";
        else        statement += "They lost their game!";
        System.out.println();
        int[] teamInningScores = data.teamInningScores(true);
        String[] ordinals = {"first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth"};
        for (int i = 0; i < teamInningScores.length; i++)
        {
            statement += "The score for the "+ordinals[i + 1]+" inning was "+teamInningScores[i]+".\n";
        }
        statement += Random.text_of(new String[] {"Their total score was "+data.teamScore(true), "The final tally for the team was "+data.teamScore(true)})+".";
        return statement;
    }
    /*
    // method calling examples - team player statistics //
    private String TeamPlayerStatisticsExample()
    {
        String hits_pluralization = "";
        if (data.getTeamPlayerHits(true, "S. Pitch") == 1)     hits_pluralization = "hit";
        else        hits_pluralization = "hits";
        String[] run_descriptions = new String[] {"no", "one good", "two", "several", "many"};
        int run_description_index = -1;
        if (data.getTeamPlayerRuns(true, "S. Pitch") > 5)       run_description_index = 5;
        else        run_description_index = Function.line(0, 0, run_descriptions.length, 5, data.getTeamPlayerRuns(true, "S. Pitch"));
        String runs_description = run_descriptions[run_description_index];
        String run_punctuation = "";
        if (run_description_index <= 2)     run_punctuation = ".";
        else        run_punctuation = "!";
        return "S. Pitch got "+data.getTeamPlayerHits(true, "S. Pitch")+" "+hits_pluralization+" out of "+data.getTeamPlayerBats(true, "S. Pitch")+" bats. He achieved "+runs_description+" ("+data.getTeamPlayerRuns(true, "S. Pitch")+") runs"+run_punctuation;
    }
    // method calling examples - team primary statistics //
    private String TeamPrimaryStatistics()
    {
        return ;
    }
    */
}