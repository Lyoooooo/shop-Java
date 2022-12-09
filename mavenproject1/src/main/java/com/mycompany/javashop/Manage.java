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
         for (Product obj : listProd) {
         System.out.print("ID: "+obj.getIdP()+", ");
         System.out.print("Name: "+obj.getNameP()+", ");
         System.out.print("Salary: "+obj.getPriceP()+", ");
         System.out.print("Country: "+obj.getStorageP()+", ");
         System.out.print("Address: "+obj.getPicP());
         System.out.println();
      }
        return listProd;
    }
}