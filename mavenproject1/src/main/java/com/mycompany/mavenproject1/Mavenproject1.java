/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.mavenproject1;
import javax.swing.*;

import static com.mycompany.mavenproject1.DB.*;
import java.sql.*;

/**
 *
 * @author leotr
 */
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
