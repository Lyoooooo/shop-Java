/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javashop;

import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author leotr
 */
public class ImageRenderer extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        String photoName = value.toString();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(photoName).getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT));
        return new JLabel(imageIcon);
    }

    public ImageRenderer() {
    }
    
}
