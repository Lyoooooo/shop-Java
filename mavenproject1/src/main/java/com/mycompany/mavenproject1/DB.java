/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author NATHAN
 */
public class DB {
    
    public static Connection connect() {
        
        Connection con = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop-java?serverTimezone=UTC","root","");
            System.out.println("Connection is Successful to the database");
            String query = "Insert into client(idc,nom) values(null,'ram')";
            Statement statement = con.createStatement();
            statement.execute(query);

        }
        catch(Exception e) {
            System.out.println(e);
        }
        return con;
    }
}
