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
public interface Match {
    
    void pointWonBy(String player) throws Exception;
    String score() throws Exception;
    boolean isMatchComplete();
}
