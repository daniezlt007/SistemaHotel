/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class Conexao {
    //public String db="basehotel";
    public String url="jdbc:mysql://127.0.0.1/basehotel";
    public String user="root";
    public String pass="root";
    
    public Conexao(){
    }
    public Connection conectar(){
        Connection link = null;
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            link = DriverManager.getConnection(this.url, this.user, this.pass);
            
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);      
        }    
        return link;
    }   
}