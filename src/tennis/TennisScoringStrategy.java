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
public class TennisScoringStrategy implements ScoringStrategy {

    @Override
    public boolean hasPlayerWon(Game game, Player player)
            throws Exception
    {        
        return game.getPlayerPoints(player) >= 4 && 
                game.getPlayerPoints(player) + 2 > game.getPlayerPoints(player.getOpponent(1));
    }

    
    /**
     * 
     * @param game
     * @return 
     * @throws java.lang.Exception 
     */
    @Override
    public String score(Game game)
            throws Exception 
    {
        Player playerOne;
        Player playerTwo;
            
        try
        {
            
            playerOne = game.getPlayers().getPlayer(1);
            playerTwo = game.getPlayers().getPlayer(2);

            if(this.isDeuce(game))
            {
                return "Deuce";
            }
            else if(this.hasAdvantage(game, playerOne))
            {
                return String.format("%d-%d, Advantage %s", this.getScoreForDisplay(game, playerOne), this.getScoreForDisplay(game, playerTwo), playerOne.getName());
            }
            else if(this.hasAdvantage(game, playerTwo))
            {
                return String.format("%d-%d, Advantage %s", this.getScoreForDisplay(game, playerOne), this.getScoreForDisplay(game, playerTwo), playerTwo.getName());
            }
            else
            {
                return String.format("%d-%d", this.getScoreForDisplay(game, playerOne), this.getScoreForDisplay(game, playerTwo));            
            }
        }
        catch(Exception e)
        {
            throw e;
        }
    }
    
    
    /**
     * If at least 3 points have been scored by each player, and the scores are equal, the score is "deuce".
     * @param game
     * @return 
     * @throws java.lang.Exception 
     */
    protected boolean isDeuce(Game game)
            throws Exception
    {
        Player playerOne = game.getPlayers().getPlayer(1);
        Player playerTwo = game.getPlayers().getPlayer(2);

        return game.getPlayerPoints(playerOne) == game.getPlayerPoints(playerTwo) && 
            game.getPlayerPoints(playerOne) >= 3;
    }
    
    
    /**
     * If at least 3 points have been scored by each side and a player has one more point than his opponent, the score of the game is "advantage" for the player in the lead.
     * @param game
     * @param player
     * @return 
     * @throws java.lang.Exception 
     */
    protected boolean hasAdvantage(Game game, Player player)
            throws Exception
    {
        return game.getPlayerPoints(player) > 3 && 
            game.getPlayerPoints(player.getOpponent(1)) > 3 && 
            game.getPlayerPoints(player) == game.getPlayerPoints(player.getOpponent(1)) + 1;
    }
    
    
    
    //The running score of each game is described in a manner peculiar to tennis: scores from zero to three points are described as 0, 15, 30, 40, respectively
    protected int getScoreForDisplay(Game game, Player player)
            throws Exception
    {
        switch(game.getPlayerPoints(player))
        {
            case 0:
                return 0;
            case 1:
                return 15;
            case 2:
                return 30;
            case 3:
                return 40;
            case 4:
                return 50;
            default:
                throw new Exception("Player has an invalid score!");
        }
    }
    
}
