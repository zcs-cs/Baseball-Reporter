package data;

/**
 * Contains a collection of data to be accessed by ReportModules
 */
public interface ReportData
{
    public static final boolean teamA = true;
    public static final boolean teamB = false;
    
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
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (teamA & teamB).
     *
     * @return The official team name.
     */
    public abstract String teamName(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (teamA & teamB).
     *
     * @return The nickname of the team.
     */
    public abstract String teamDemonym(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (teamA & teamB).
     *
     * @return The home city of the team.
     */
    public abstract String teamHomecity(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (teamA & teamB).
     *
     * @return Final score for the team.
     */
    public abstract int teamScore(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (teamA & teamB).
     *
     * @return Win or loss of the game (true/false)
     */
    public abstract boolean teamResult(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (teamA & teamB).
     *
     * @return The position within the league of the team.
     */
    public abstract int teamStandingsPosition(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (teamA & teamB).
     *
     * @return The number of wins the team has for the season.
     */
    public abstract int teamStandingsWins(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (teamA & teamB).
     *
     * @return The longest winning streak for the team.
     */
    public abstract int teamStandingsStreak(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (teamA & teamB).
     *
     * @return The number of losses the team has for the season.
     */
    public abstract int teamStandingsLosses(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (teamA & teamB).
     *
     * @return An array containing all player names on a given team.
     */
    public abstract String[] teamPlayersNames(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (teamA & teamB).
     *
     * @return Injury types for all players.
     */
    public abstract String[][] teamPlayersInjuriesTypes(boolean teamA);
    
    /**
     * @param teamA
     *        Get information from first team (true) or second team (false).
     *        Use the constants defined above (teamA & teamB).
     *
     * @return Locations for all player injuries.
     */
    public abstract String[][] teamPlayersInjuriesLocations(boolean teamA);
    
    /**
     * @param teamC
     *        Get information from third team (true) or fourth team (false).
     *        Use the constants defined above (teamC & teamD)
     *
     * @return The position of the team.
     */
    public abstract int otherTeamStandingsPosition(boolean teamC);
    
    /**
     * @param teamC
     *        Get information from third team (true) or fourth team (false).
     *        Use the constants defined above (teamC & teamD)
     *
     * @return The number of wins the team had before the game.
     */
    public abstract int otherTeamStandingsWins(boolean teamC);
        
    /**
     * @param teamC
     *        Get information from third team (true) or fourth team (false).
     *        Use the constants defined above (teamC & teamD)
     *
     * @return The team's streak before the game.
     */
    public abstract int otherTeamStandingsStreak(boolean teamC);
    
    /**
     * @param teamC
     *        Get information from third team (true) or fourth team (false).
     *        Use the constants defined above (teamC & teamD)
     *
     * @return The number of losses the team had before the game.
     */
    public abstract int otherTeamStandingsLosses(boolean teamC);
}
