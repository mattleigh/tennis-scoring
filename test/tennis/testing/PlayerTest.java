package tennis.testing;

import tennis.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
//import org.easymock.Capture;
import org.easymock.EasyMock;
//import org.junit.Test;
import static org.junit.Assert.*;

//import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertEquals;
//import static org.powermock.api.easymock.PowerMock.expectNew;
//import static org.powermock.api.easymock.PowerMock.replay;
//import static org.powermock.api.easymock.PowerMock.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
//import org.powermock.api.easymock.annotation.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
 

/**
 *
 * @author New User
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(Player.class)
public class PlayerTest {
    
    public PlayerTest() {
        Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
    }   

    @Test
    public void testGetName() {
        
        String expectedName = "Test";        
        Player player = new Player(expectedName);
        assertEquals(expectedName, player.getName());
    }
    
    
    
    @Test
    public void testSetOpponent_NoOpponents() 
            throws IllegalAccessException, NoSuchFieldException
    {
        final Player player = new Player("A");       
        final Player[] players = new Player[]{player};
       
        player.setOpponents(players);
   
        final Field opponentsField = player.getClass().getDeclaredField("opponents");        
        opponentsField.setAccessible(true);       
        Players opponents = (Players) opponentsField.get(player);
        final Field playersField = opponents.getClass().getDeclaredField("players");
        playersField.setAccessible(true);        
        
        int expectedCount = 0;
        int opponentCount = ((Player[])playersField.get(opponents)).length;
        assertEquals("More opponents than expected", opponentCount, expectedCount);
    }
    
    
    
    @Test
    public void testDetermineOpponents_NoOpponents() 
           throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
    {
        final Player playerA = new Player("A");
        final Player[] players = new Player[]{playerA};
        final Player[] expectedOpponents = new Player[]{};
        
        Class<?>[] cArg = new Class<?>[1];
        cArg[0] = Player[].class;
         
        Method method = playerA.getClass().getDeclaredMethod("DetermineOpponents", cArg);
        method.setAccessible(true);
        Player[] opponents = (Player[])method.invoke(playerA, (Object)players);
        
        assertArrayEquals("More opponents than expected", opponents, expectedOpponents);
    }
    
    
    @Test
    public void testDetermineOpponents_OneOpponent() 
           throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
    {
        final Player playerA = new Player("A");
        final Player playerB = new Player("B");
        final Player[] players = new Player[]{playerA, playerB};
        final Player[] expectedOpponents = new Player[]{playerB};
        
        Class<?>[] cArg = new Class<?>[1];
        cArg[0] = Player[].class;
         
        Method method = playerA.getClass().getDeclaredMethod("DetermineOpponents", cArg);
        method.setAccessible(true);
        Player[] opponents = (Player[])method.invoke(playerA, (Object)players);
        
        assertArrayEquals("More opponents than expected", opponents, expectedOpponents);
    }
    
    
    @Test
    public void testGetOpponent() 
            throws IllegalAccessException, NoSuchFieldException
    {
        final Player playerA = new Player("A");
        final Player expectedOpponent = new Player("B");
       
        Players playersMock = EasyMock.createMock(Players.class);
        EasyMock.expect(playersMock.getPlayer(1)).andReturn(expectedOpponent);
        EasyMock.replay(playersMock);
  
        final Field opponentsField = playerA.getClass().getDeclaredField("opponents");        
        opponentsField.setAccessible(true);
        opponentsField.set(playerA, playersMock);
        
        Player opponent = playerA.getOpponent(1); //One based index   
        assertEquals("More opponents than expected", opponent, expectedOpponent);        
    }
    
}
