//Libraries
package com.mycompany.javashop;

import java.sql.*;
import java.util.ArrayList;

//Management
public class Manage {

    public static ArrayList<Product> ListProd(Connection con) throws SQLException {
        ArrayList<Product> listProd = new ArrayList<>();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM product");
        while (rs.next()) {
            Product prod = new Product();
            prod.setIdP(rs.getInt("idP"));
            prod.setNameP(rs.getString("nameP"));
            prod.setPriceP(rs.getFloat("priceP"));
            prod.setStorageP(rs.getInt("storageP"));
            prod.setPicP(rs.getString("picP"));
            listProd.add(prod);
        }
        return listProd;
    }
    
    public static ArrayList<Product> ResearchProd(Connection con, String search) throws SQLException {
        ArrayList<Product> researchProd = new ArrayList<>();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM product WHERE nameP LIKE %"+search+"%");
        while (rs.next()) {
            Product prod = new Product();
            prod.setIdP(rs.getInt("idP"));
            prod.setNameP(rs.getString("nameP"));
            prod.setPriceP(rs.getFloat("priceP"));
            prod.setStorageP(rs.getInt("storageP"));
            prod.setPicP(rs.getString("picP"));
            researchProd.add(prod);
        }
        return researchProd;
    }

    public static boolean isAvailable(Connection con, int idP, int quantity) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT storageP FROM product WHERE idP = '" + idP + "'");
        while (rs.next()) {
            if (quantity <= rs.getInt("storageP")) {
                return true;
            }
        }
        return false;
    }
    
    public static void addToCart(Connection con, int idP, int idU, int quantity) throws SQLException {
        PreparedStatement p = con.prepareStatement("SELECT * FROM cart WHERE idP="+idP+" AND idU="+idU);
        ResultSet rs = p.executeQuery();
        if (rs.next()) {
            quantity += rs.getInt("quantity");
            p = con.prepareStatement("UPDATE cart SET quantity=? WHERE idP="+idP+" AND idU="+idU);
            p.setInt(1,quantity);
            p.executeUpdate();
        } else {
        Statement stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO cart VALUES (null,"+idU+","+idP+","+quantity+")");
        }
    }
}
