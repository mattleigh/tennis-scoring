/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis.testing;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import tennis.*;
import java.lang.reflect.Field;
import org.easymock.EasyMock;
import org.junit.Test;
import static org.junit.Assert.*;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertEquals;
import static org.powermock.api.easymock.PowerMock.expectNew;
import static org.powermock.api.easymock.PowerMock.replay;
import static org.powermock.api.easymock.PowerMock.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.annotation.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * @author New User
 */
public class PlayersTest {
    
    public PlayersTest() {
    }
      
    
    public void testGetPlayers() 
            throws NoSuchFieldException, IllegalAccessException
    {
        Player[] expectedPlayers = new Player[]{};
        Players players = new Players(expectedPlayers);
        
        Player[] resultPlayers = players.getPlayers();
        
        assertArrayEquals("Players array does not match", resultPlayers, expectedPlayers);
    }
    
    
    @Test
    public void testGetPlayer() 
            throws NoSuchFieldException, IllegalAccessException
    {
        Player expectedPlayer = new Player("A");
        Player[] expectedPlayers = new Player[]{expectedPlayer};
        Players players = new Players(expectedPlayers);
        
        Player resultPlayer = players.getPlayer(1);
        
        assertEquals("Player does not match", resultPlayer, expectedPlayer);
    }
    
    
    @Test
    public void testGetPlayerIndex() 
            throws NoSuchFieldException, IllegalAccessException, Exception
    {
        Player playerA = new Player("A");
        Player[] expectedPlayers = new Player[]{playerA};
        Players players = new Players(expectedPlayers);
        
        int resultIndex = players.getPlayerIndex(playerA);
        int expectedIndex = 0;
        
        assertEquals("Player does not match", resultIndex, expectedIndex);
    }
    
    
    @Test
    public void testGetPlayerByName() 
            throws NoSuchFieldException, IllegalAccessException, Exception
    {
        Player playerA = new Player("A");
        Player[] expectedPlayers = new Player[]{playerA};
        Players players = new Players(expectedPlayers);
        
        Player resultPlayer = players.getPlayerByName("A");
        Player expectedPlayer = playerA;
        
        assertEquals("Player does not match", resultPlayer, expectedPlayer);
    }
    
    
    @Test
    public void testCount() 
            throws NoSuchFieldException, IllegalAccessException, Exception
    {
        Player playerA = new Player("A");
        Player[] expectedPlayers = new Player[]{playerA};
        Players players = new Players(expectedPlayers);
        
        int resultCount = players.count();
        int expectedCount = 1;
        
        assertEquals("Player does not match", resultCount, expectedCount);
    }    
}
