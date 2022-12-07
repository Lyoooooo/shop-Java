//Libraries
package com.mycompany.mavenproject1;
import javax.swing.*;
import java.sql.*;
import static com.mycompany.mavenproject1.DB.*;

//Main
public class Mavenproject1 {

    public static void main(String[] args) {
        Connection con = connect();
        final int WINDOW_HEIGHT = 400;
        final int WINDOW_WIDTH = 500;
        
        JFrame window = new JFrame();
        
        window.setTitle("Potite fenêtre");
        
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        window.setVisible(true);
    }
}
