package tennis;

/**
 *
 * @author New User
 */
public class Game {
    
    protected Players players;
    protected ScoringStrategy scorer;
    protected int[] points;
   
   
    public Game(Players players, ScoringStrategy scorer)
    {
        this.players = players;
        this.scorer = scorer;
        
        //all values automagically initialised to 0 
        this.points = new int[players.count()];
    }
    
    
    public Players getPlayers()
    {
        return this.players;
    }
    
    
    public int getPlayerPoints(Player player)
            throws Exception
    {
        int playerNo = this.players.getPlayerIndex(player);
        return this.points[playerNo];
    }

    
    public void pointWonBy(Player player)
            throws Exception
    {
        int playerNo = this.players.getPlayerIndex(player);
        this.points[playerNo]++;    
    }

    
    public boolean hasPlayerWon(Player player)
            throws Exception
    {
        return this.scorer.hasPlayerWon(this, player);
    }
   
    public String score()
            throws Exception
    {
        return scorer.score(this);

    }
}
