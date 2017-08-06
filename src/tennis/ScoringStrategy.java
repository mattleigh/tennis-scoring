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
public interface ScoringStrategy {
    boolean hasPlayerWon(Game game, Player player) throws Exception;
    String score(Game game) throws Exception;    
}
