//Libraries
package com.mycompany.javashop;
import static com.mycompany.javashop.DB.*;
import java.sql.Connection;
import javax.swing.JFrame;

//Main
public class JavaShop {

    public static void main(String[] args) {
        User user = new User();
        Connection con = connect();
        fenetre wind = new fenetre(user);
        wind.displayConnection();
    }
}
