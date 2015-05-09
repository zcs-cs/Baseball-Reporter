package modules;

import utilities.*;
import data.*;

public class Modules
{
    protected ReportData data = null;
    protected String output = null;
    
    /** 
     * Instantiated with specified ReportData.
     */
    public Modules(ReportData data)
    {
        this.data = data;
    }
    
    /**
     * Generates a String from the modules' ReportData object. The string
     * generated is stored in the instance data 'output'. A pointer to
     * 'output' is returned.
     * @note One does not have to store the String returned by this method;
     *  it is stored in 'output' in addition to being returned.
     */
    public String generate()
    {                        /* temporary method calling examples */
        return generateTitle()+"\n"+examples_concatenated()/*+nextMethods()*/;
    }
    
    /**
     * Returns the output string. If the module has not generated output,
     * it will be generated and returned.
     */
    public String getOutput()
    {
        if (output == null) {
            return generate();
        }
        return output;
    }
   
    private String generateTitle()
    {
        return "Baseball Game was a great success!";    /* should be reflective of an analysis of key data */
    }
    
    // method calling examples - altogether //
    private String examples_concatenated()
    {
        return GameStatisticsExample()+"\n"+TeamPrimaryStatisticsExample()+"\n"+TeamPlayerStatisticsExample();
    }
    // method calling examples - game statistics //
    private String GameStatisticsExample()
    {
        return "innings: "+data.getInnings()+"\nlength: "+data.getLength()+"\nlocation: "+data.getLocation()+"\nstart time: "+data.getStartTime()+"\nweather: "+data.getWeather();
    }
    // method calling examples - team primary statistics //
    private String TeamPrimaryStatisticsExample()
    {
        String statement = "The "+data.getTeamName(true)+", or '"+data.getTeamDemonym(true)+"' for short, are from "+data.getTeamHomeCity(true)+". ";
        if (data.getTeamResult(true))       statement += "They won their game!";
        else        statement += "They lost their game!";
        statement += " "+Random.text_of(new String[] {"Their total score was "+data.getTeamTotalScore(true), "The final tally for the team was "+data.getTeamTotalScore(true)})+".";
        return statement;
    }
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
    /*// method calling examples - team primary statistics //
    private String TeamPrimaryStatistics()
    {
        return ;
    }*/
    // GROUPS' METHODS NEEDED //
}




