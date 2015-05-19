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
     * @return The official team name.
     */
    public abstract String teamName(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return The nickname of the team.
     */
    public abstract String teamDemonym(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return The home city of the team.
     */
    public abstract String teamHomecity(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return An array of scores a team made throughout the game, per inning.
     */
    public abstract int[] teamInningScores(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return Final score for the team.
     */
    public abstract int teamScore(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return Win or loss of the game (true/false)
     */
    public abstract boolean teamResult(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return The position within the league of the team.
     */
    public abstract int teamStandingsPosition(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return The number of wins the team has for the season.
     */
    public abstract int teamStandingsWins(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return The longest winning streak for the team.
     */
    public abstract int teamStandingsStreak(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return The number of losses the team has for the season.
     */
    public abstract int teamStandingsLosses(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return An array containing all player names on a given team.
     */
    public abstract String[] teamPlayersNames(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return An array of bats for each corresponding player.
     */
    public abstract int[] teamPlayersBats(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return A 2D array of runs for each player, for each inning.
     */
    public abstract int[][] teamPlayersRunsInnings(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return An array of HRs for each player, for each inning.
     */
    public abstract int[] teamPlayersHRs(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return A 2D array of pitches for each player, for each inning.
     */
    public abstract int[][] teamPlayersInningsPitched(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return A 2D array of hits for each player.
     */
    public abstract String[][] teamPlayersHitsDescriptions(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return RBIs for each player on a team.
     */
    public abstract int[][] teamPlayersHitsRBIs(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return Injuries for all players.
     */
    public abstract int[][] teamPlayersInjuriesGamesMissed(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return Injury types for all players.
     */
    public abstract String[][] teamPlayersInjuriesTypes(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return Locations for all player injuries.
     */
    public abstract String[][] teamPlayersInjuriesLocations(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return All player RBIs on a team.
     */
    public abstract int[] teamPlayersRBIs(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return Hit count for each player on a team.
     */
    public abstract int[] teamPlayersHits(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (INDIANS & BATS).
     *
     * @return Number of runs for each player on a team.
     */
    public abstract int[] teamPlayersRuns(boolean teamA);
    
    public abstract int otherTeamStandingsPosition(boolean teamC);
    
    public int otherTeamStandingsWins(boolean teamC);
        
    public int otherTeamStandingsStreak(boolean teamC);
        
    public int otherTeamStandingsLosses(boolean teamC);
}
