package data;

/**
 * Contains a collection of data to be accessed by ReportModules
 */
public interface ReportData
{
    public static final boolean INDIANS = true;
    public static final boolean BATS = false;

    /**
     * @return The location of the game (field).
     */
    public abstract String location();
    
    /**
     * @return The city where the game was played.
     */
    public abstract String city();
    
    /**
     * @return The temperature on gameday.
     */
    public abstract double temperature();
    
    /**
     * @return The precipitation on gameday.
     */
    public abstract double rainfall();
    
    /**
     * @return The date of the game.
     */
    public abstract String date();
    
    /**
     * @return The start time of the game.
     */
    public abstract int startTime();
    
    /**
     * @return Minutes the game lasted.
     */
    public abstract int minutes();
    
    /**
     * @return The number of innings the game has.
     */
    public abstract int innings();
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return 
     */
    public abstract String teamName(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return 
     */
    public abstract String teamDemonym(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return 
     */
    public abstract String teamHomecity(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return 
     */
    public abstract int[] teamInningScores(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return 
     */
    public abstract int teamScore(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return 
     */
    public abstract boolean teamResult(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return 
     */
    public abstract int teamStandingsPosition(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return 
     */
    public abstract int teamStandingsWins(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return 
     */
    public abstract int teamStandingsStreak(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return 
     */
    public abstract int teamStandingsLosses(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return 
     */
    public abstract String[] teamPlayersNames(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return 
     */
    public abstract int[] teamPlayersBats(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return 
     */
    public abstract int[][] teamPlayersRunsInnings(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return 
     */
    public abstract int[][] teamPlayersInningsPitched(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return 
     */
    public abstract String[][] teamPlayersHitsDescriptions(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return 
     */
    public abstract int[][] teamPlayersHitsRBIs(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return 
     */
    public abstract int[][] teamPlayersInjuriesGamesMissed(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return 
     */
    public abstract String[][] teamPlayersInjuriesTypes(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return 
     */
    public abstract String[][] teamPlayersInjuriesLocations(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return 
     */
    public abstract int[] teamPlayersRBIs(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return 
     */
    public abstract int[] teamPlayersHits(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return 
     */
    public abstract int[] teamPlayersRuns(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return 
     */
}