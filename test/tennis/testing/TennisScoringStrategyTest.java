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
import java.lang.reflect.Method;
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

import org.powermock.reflect.Whitebox;


/**
 *
 * @author New User
 */
public class TennisScoringStrategyTest {
    protected Players mockPlayers;
    protected Player player1;
    protected Player player2;
    protected Game mockGame;
    
    public TennisScoringStrategyTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        player1 = new Player("A");
        player2 = new Player("B");
        
        mockPlayers = EasyMock.createMock(Players.class);       
        mockGame = EasyMock.createMock(Game.class);               
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void TestIsDeuce_true() 
            throws Exception
    {
        EasyMock.expect( mockPlayers.getPlayer(1)).andReturn(player1);
        EasyMock.expect( mockPlayers.getPlayer(2)).andReturn(player2);
        EasyMock.expect( mockPlayers.count()).andReturn(0);
        EasyMock.expect( mockGame.getPlayers()).andReturn(mockPlayers);
        EasyMock.expect( mockGame.getPlayers()).andReturn(mockPlayers);
        EasyMock.expect( mockGame.getPlayerPoints(player1)).andReturn(3);
        EasyMock.expect( mockGame.getPlayerPoints(player2)).andReturn(3);
        EasyMock.expect( mockGame.getPlayerPoints(player1)).andReturn(3);
        
        EasyMock.replay( mockPlayers, mockGame);
        
        TennisScoringStrategy s = new TennisScoringStrategy();

        boolean result = Whitebox.invokeMethod(s, "isDeuce", mockGame);
        boolean expected = true;
        
        assertEquals("IsDeuce should be true", result, expected);   
    }
    
    
    @Test
    public void TestIsDeuce_false() 
            throws Exception
    {
        EasyMock.expect( mockPlayers.getPlayer(1)).andReturn(player1);
        EasyMock.expect( mockPlayers.getPlayer(2)).andReturn(player2);
        EasyMock.expect( mockPlayers.count()).andReturn(0);
        EasyMock.expect( mockGame.getPlayers()).andReturn(mockPlayers);
        EasyMock.expect( mockGame.getPlayers()).andReturn(mockPlayers);
        EasyMock.expect( mockGame.getPlayerPoints(player1)).andReturn(3);
        EasyMock.expect( mockGame.getPlayerPoints(player2)).andReturn(2);
        EasyMock.expect( mockGame.getPlayerPoints(player1)).andReturn(3);
        
        EasyMock.replay( mockPlayers, mockGame);
        
        TennisScoringStrategy s = new TennisScoringStrategy();

        boolean result = Whitebox.invokeMethod(s, "isDeuce", mockGame);
        boolean expected = false;
        
        assertEquals("IsDeuce should be true", result, expected);   
    }
}
