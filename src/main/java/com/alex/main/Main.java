
package com.alex.main;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexsandre
 */
public class Main {
    
    private static final String url = "jdbc:mysql://localhost:3306/jogo";

    private static final String user = "root";
    private static final String password = "Sen@crs2024";
    
    public static void main(String[] args) {
         Jogo j = new Jogo();
        
        j.criarPersonagem();
        
        
        
        
    }
}
