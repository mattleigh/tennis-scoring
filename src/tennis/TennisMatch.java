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
public class TennisMatch implements Match {

    protected Players players;
    protected Set currentSet;
    protected boolean matchComplete;
    
    
    public TennisMatch(String playerOneName, String playerTwoName)
    {
        String[] playerNames = {playerOneName, playerTwoName};
        this.players = new Players(playerNames);
        this.currentSet = new Set(this.players);
    }  
    
    
    @Override
    public void pointWonBy(String playerName)
            throws Exception
    {
        Player player = this.players.getPlayerByName(playerName);
        this.currentSet.pointWonBy(player);
        
        if(this.currentSet.hasPlayerWonSet(player))
        {
            matchComplete = true;
        }
    }
    
    
    @Override
    public String score()
            throws Exception
    {
        return this.currentSet.score();
    }

    
    @Override
    public boolean isMatchComplete() {
        return matchComplete;
    }
    
    
    
    
}
