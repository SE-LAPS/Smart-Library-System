/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookpackage;

import com.sun.istack.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

/**
 *
 * @author LapZ
 */
public class Books {
Statement st;
    

    void addBook(String btitle, String bauthor, String bpub) {
         connectToDb();
         String sql = "insert into books(title,Author,Publisher) VALUES ('"+btitle+"','"+bauthor+"','"+bpub+"')";

    try {
        st.executeUpdate(sql);
    } catch (SQLException ex) {
        
    java.util.logging.Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    private void connectToDb() {
        String url ="jdbc:mysql://localhost:3306/mybooksdb";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,"root","");
            st = con.createStatement();
         
        } catch (ClassNotFoundException|SQLException  ex) {
            
        }
        
      
    }
    
    
}


