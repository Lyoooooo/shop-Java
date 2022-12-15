//Libraries
package com.mycompany.javashop;
import static com.mycompany.javashop.DB.*;
import static com.mycompany.javashop.Manage.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

//Main
public class JavaShop {

    public static void main(String[] args) throws SQLException {
        User user = new User();
        String search = "null";
        fenetre wind = new fenetre(user,search);
        wind.displayShop();
    }
}
