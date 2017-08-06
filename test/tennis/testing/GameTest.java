/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis.testing;

import java.lang.reflect.Field;
import org.easymock.EasyMock;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import tennis.*;


/**
 *
 * @author New User
 */
public class GameTest {
    
    @Test
    public void testGetPlayers() 
    {
        Players expectedPlayers = new Players(new String[]{});
        Game g = new Game(expectedPlayers, null);        
        Players resultPlayers = g.getPlayers();        
        assertEquals("Player does not match", resultPlayers, expectedPlayers);
    }
    
    
    @Test
    public void TestGetPlayerPoints() 
            throws Exception
    {
        final int[] points = new int[]{2};
        final Player playerA = new Player("A");
        final Players mockPlayers = EasyMock.createMock(Players.class);
        EasyMock.expect( mockPlayers.getPlayerIndex(playerA)).andReturn(0);
        EasyMock.expect( mockPlayers.count()).andReturn(0);
        EasyMock.replay( mockPlayers );
        
        Game g = new Game(mockPlayers, null);
        
        final Field pointsField = g.getClass().getDeclaredField("points");        
        pointsField.setAccessible(true);       
        pointsField.set(g,points);
        
        int resultPoints = g.getPlayerPoints(playerA);
        int expectedPoints = 2;
        
        assertEquals("Return points for player incorrect", resultPoints, expectedPoints);        
    }
    
    
    @Test
    public void TestPointWonBy() 
            throws Exception
    {
        final int[] points = new int[]{2};
        final Player playerA = new Player("A");
        final Players mockPlayers = EasyMock.createMock(Players.class);
        EasyMock.expect( mockPlayers.getPlayerIndex(playerA)).andReturn(0);
        EasyMock.expect( mockPlayers.count()).andReturn(0);
        EasyMock.replay( mockPlayers );
        
        Game g = new Game(mockPlayers, null);
        
        final Field pointsField = g.getClass().getDeclaredField("points");        
        pointsField.setAccessible(true);       
        pointsField.set(g,points);
        
        g.pointWonBy(playerA);
        
        int resultPoints = ((int[])pointsField.get(g))[0];
        int expectedPoints = 3;
        
        assertEquals("Return points for player incorrect", resultPoints, expectedPoints);        
    }
    
    
    @Test
    public void TestHasPlayerWon() 
            throws Exception
    {
        final Player playerA = new Player("A");
        
        final Players mockPlayers = EasyMock.createMock(Players.class);
        EasyMock.expect( mockPlayers.getPlayerIndex(playerA)).andReturn(0);
        EasyMock.expect( mockPlayers.count()).andReturn(0);
        EasyMock.replay( mockPlayers );
        
        final ScoringStrategy mockScorer = EasyMock.createMock(ScoringStrategy.class);
        Game g = new Game(mockPlayers, mockScorer);        
        
        EasyMock.expect( mockScorer.hasPlayerWon(g, playerA)).andReturn(true);
        EasyMock.replay( mockScorer );
        
        boolean result = g.hasPlayerWon(playerA);
        boolean expected = true;
        
        assertEquals("Return points for player incorrect", result, expected);        
    }
    
    
    @Test
    public void TestScore() 
            throws Exception
    {
        final Player playerA = new Player("A");
        
        final Players mockPlayers = EasyMock.createMock(Players.class);
        EasyMock.expect( mockPlayers.getPlayerIndex(playerA)).andReturn(0);
        EasyMock.expect( mockPlayers.count()).andReturn(0);
        EasyMock.replay( mockPlayers );
        
        final ScoringStrategy mockScorer = EasyMock.createMock(ScoringStrategy.class);
        Game g = new Game(mockPlayers, mockScorer);        
        
        EasyMock.expect( mockScorer.score(g)).andReturn("40-40");
        EasyMock.replay( mockScorer );
        
        String result = g.score();
        String expected = "40-40";
        
        assertEquals("Return points for player incorrect", result, expected);        
    }
}
