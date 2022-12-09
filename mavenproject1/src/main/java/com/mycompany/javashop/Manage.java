//Libraries
package com.mycompany.javashop;

import java.sql.*;
import java.util.ArrayList;

//Management
public class Manage {

    public static ArrayList<Product> ListProd(Connection con) throws SQLException {
        System.out.println("test");
        ArrayList<Product> listProd = new ArrayList<Product>();
        String sql;
        Statement stmt = con.createStatement();
        sql = "SELECT * FROM product";
        ResultSet rs = stmt.executeQuery(sql);
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
}
