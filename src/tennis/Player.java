package tennis;

/**
 *
 * @author New User
 */
public class Player {
    protected String name;
    protected Players opponents;
        
    public Player(String name)
    {
        this.name = name;        
    }    
    
    
    public String getName()
    {
        return this.name;
    }    
    
    
    public void setOpponents(Player[] allPlayers)
    {
        Player[] otherPlayers = this.DetermineOpponents(allPlayers);        
        this.opponents = new Players(otherPlayers);
    }
    
    
    protected Player[] DetermineOpponents(Player[] allPlayers)
    {
        Player[] otherPlayers = new Player[allPlayers.length-1];
        int i = 0;
        
        for(Player player : allPlayers)
        {
            if(!player.equals(this))
            {
                otherPlayers[i] = player;
                i++;
            }
        }
        
        return otherPlayers;
    }
    
    public Player getOpponent(int i)
    {
        return this.opponents.getPlayer(i);
    } 
}
