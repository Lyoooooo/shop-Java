/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javashop;
import javax.swing.*;


/**
 *
 * @author leotr
 */
public class fenetre {
    User user = new User();
    
    final int WINDOW_HEIGHT = 400;
    final int WINDOW_WIDTH = 500;
    
    private JPanel panel = new JPanel();
    
    public fenetre(User user){
        this.user = user;
    }

    public void displayInscription(){
        Inscription page = new Inscription(user);
        JFrame window = new JFrame();
        window.setTitle("Account creation");
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        window.add(page);
    
        window.setVisible(true);
    }
    
    public void displayConnection(){
        testInscr page = new testInscr(user);
        JFrame window = new JFrame();
        window.setTitle("Connection");
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        window.add(page);
    
        window.setVisible(true);
    }
    
    public void displayShop(){
        Shop page = new Shop(user);
        JFrame window = new JFrame();
        window.setTitle("Account creation");
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        window.add(page);
    
        window.setVisible(true);
    }
}
