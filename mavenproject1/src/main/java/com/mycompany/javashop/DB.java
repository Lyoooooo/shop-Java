//Libraries
package com.mycompany.javashop;
import java.sql.*;

//DB Class
public class DB {
    
    public static Connection connect() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop-java?serverTimezone=UTC","root","");
            System.out.println("Connection is Successful to the database");
            String query = "Insert into user(idU,nameU,surnameU,mailU,pwU) values(null,'ram','test','test2','test3')";
            Statement statement = con.createStatement();
            statement.execute(query);

        }
        catch(SQLException e) {
            System.out.println(e);
        }
        return con;
    }
    
}
