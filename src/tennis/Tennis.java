/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author New User
 */
public class Tennis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String playerOne;
        String playerTwo;
        String pointScorer;
        Match m;
        
        try
        {
            writeLine("Welcome to SUPER HAPPY TENNIS FUN TIME!!!");
            writeLine("Please enter the name of Player One:");
            playerOne = readLine();
            writeLine("Please enter the name of Player Two:");
            playerTwo = readLine();
            writeLine(String.format("%s vs %s.  Get ready...", playerOne, playerTwo));

            m = new TennisMatch(playerOne, playerTwo);
            while(true)
            {
                writeLine(m.score());
                writeLine(String.format("Point won by [%s, %s]:", playerOne, playerTwo));
                pointScorer = readLine();
                m.pointWonBy(pointScorer);
                

                if(m.isMatchComplete())
                {
                    writeLine(String.format("Match complete. Final score: %s", m.score()));
                    break;
                }
            }
        }
        catch(Exception e)
        {
            writeLine("Uh oh, something went horribly wrong: " + e.getMessage());
        }
    }
    
    protected static String readLine()
    {       
        String input = null;
        
        try {
            BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
            input = new String();
            while( input.length() < 1 ){
                    System.out.print( ">" );
                    input = reader.readLine();
                    }	
            
            //System.out.println( "You typed: '" + input + "'." );
        }
        catch( Exception e ){
            System.out.println( "An exception occured!" );
            System.out.println( e.toString() );
        }
        return input;
    }
    
    
    protected static void writeLine(String s)
    {
        System.out.println(s);
    }
}

