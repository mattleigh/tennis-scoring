package tennis;

/**
 *
 * @author New User
 */
public class Players{
    
    protected Player[] players;
    
    
    public Players(String[] playerNames)
    {
        this.players = new Player[playerNames.length];
        
        for(int i=0; i < playerNames.length; i++)
        {
            this.players[i] = new Player(playerNames[i]);
        }        
        
        for(Player p : this.players)
        {            
            p.setOpponents(this.players);
        }        
    }
    
    
    public Players(Player[] playerNames)
    {
        this.players = playerNames;       
    }
    
    
    public int count()
    {
        return this.players.length;
    }
    
    
    /**
     * 
     * @param playerName
     * @return
     * @throws Exception 
     */
    public Player getPlayerByName(String playerName)            
            throws Exception
    {
        for(Player player : this.players) {     // foreach grade in grades
            if(player.getName().equals(playerName))
            {
                return player;
            }  
        }
        
        //Player not found
        throw new Exception("No player named " + playerName + " exists!");                      
    }
    
    
    public int getPlayerIndex(Player player)
            throws Exception
    {
        for(int i=0; i < this.players.length; i++) {     // foreach grade in grades
            if(this.players[i].equals(player))
            {
                return i;
            }  
        }
        
        //Player not found
        throw new Exception("No player not found!");    
    }
    
    
    /**
     * 
     * @param playerNumber One based index of players
     * @return 
     */
    public Player getPlayer(int playerNumber)
    {
        return players[playerNumber-1];
    }
    
    
    public Player[] getPlayers()
    {
        return this.players;
    }
}
