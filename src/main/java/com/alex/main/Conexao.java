package com.alex.main;

import java.sql.Connection; 

import java.sql.DriverManager; 

import java.sql.SQLException; 





/**
 *
 * @author Aluno
 */
public class Conexao {
    
    private static final String url = "jdbc:mysql://localhost:3306/jogo";
    
    private static final String user = "root";
    private static final String password = "Sen@crs2024";
            
    // CONEXÃO
    
    private static Connection conn;
    
    public static Connection getConexao() throws SQLException{
        try{
            
            if(conn == null){
                conn = DriverManager.getConnection(url, user, password);
            return conn;
            }else{
                return conn;
            }
        
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        
        
    }
    
    
}
