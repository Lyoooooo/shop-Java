//Libraries
package com.mycompany.mavenproject1;
import java.sql.*;

//DB Class
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
        catch(ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return con;
    }
    
    
    
}
