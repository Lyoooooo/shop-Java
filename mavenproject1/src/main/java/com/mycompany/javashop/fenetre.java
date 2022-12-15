/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javashop;

import java.sql.SQLException;
import javax.swing.*;

/**
 *
 * @author leotr
 */
public class fenetre {

    private String search = "null";
    User user = new User();

    final int WINDOW_HEIGHT = 600;
    final int WINDOW_WIDTH = 1000;

    private JPanel panel = new JPanel();

    public fenetre(User user) {
        this.user = user;
    }

    public fenetre(User user, String search) {
        this.user = user;
        this.search = search;
    }

    public void displayInscription() {
        Inscription page = new Inscription(user);
        JFrame window = new JFrame();
        window.setTitle("Account creation");
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.add(page);

        window.setVisible(true);
    }
    
    public void displayConnection() {
        testInscr page = new testInscr(user);
        JFrame window = new JFrame();
        window.setTitle("Connection");
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.add(page);

        window.setVisible(true);
    }

    public void displayShop() throws SQLException {
        Shop page = new Shop(user, search);
        JFrame window = new JFrame();
        window.setTitle("SHOPPING PARK");
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.add(page);

        window.setVisible(true);
    }
    
    public void displayCart() throws SQLException {
        Cart page = new Cart(user);
        JFrame window = new JFrame();
        window.setTitle("Connection");
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.add(page);

        window.setVisible(true);
    }
}
