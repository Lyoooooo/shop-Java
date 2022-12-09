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

    public static void main(String[] args) {
        User user = new User();
        Connection con = connect();
        ArrayList<Product> listProd = new ArrayList<Product>();
        fenetre wind = new fenetre(user);
        wind.displayConnection();
    }
}
