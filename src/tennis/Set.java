/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

/**
 *
 * @author New User
 */
public class Set {
    
    protected Players players;
    protected Game currentGame;
    protected int[] gamesWon;
    
    
    public Set(Players players)
    {
        this.players = players;
        this.currentGame = new Game(this.players, new TennisScoringStrategy());
        this.gamesWon = new int[this.players.count()];
    }
    
    //@Override
    public void pointWonBy(Player player) 
            throws Exception
    {
        this.currentGame.pointWonBy(player);
        
        //TODO
        if(this.currentGame.hasPlayerWon(player))
        {
            attributeWin( player);
            startNewGame();
        }
    }
    
    
    public void attributeWin(Player player)
            throws Exception
    {
        this.gamesWon[this.players.getPlayerIndex(player)]++;
    }
    
    
    public void startNewGame()
    {
        this.currentGame = new Game(this.players, new TennisScoringStrategy());
    }
    
    public String score()
            throws Exception
    {
        return String.format("%d-%d, %s", this.getGamesWon(players.getPlayer(1)), this.getGamesWon(players.getPlayer(2)), this.currentGame.score());
    }
    
    
    /**
     * A player wins a set by winning at least 6 games and at least 2 games more than the opponent.
     * @param player
     * @return 
     * @throws java.lang.Exception 
     */
    protected boolean hasPlayerWonSet(Player player)
            throws Exception
    {
        return this.getGamesWon(player) > 6 && 
                this.getGamesWon(player) >= this.getGamesWon(player.getOpponent(1)) + 2;
    }
    
    
    protected int getGamesWon(Player player)
            throws Exception
    {
        return this.gamesWon[this.players.getPlayerIndex(player)];
    }
}
