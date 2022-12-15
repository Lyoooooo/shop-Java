//Libraries
package com.mycompany.javashop;

import java.sql.*;
import java.util.ArrayList;

//Management
public class Manage {

    public ArrayList<Product> ListProd(Connection con) throws SQLException {
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

    public ArrayList<Product> ListCart(Connection con, int id) throws SQLException {
        System.out.println("test cart3");

        ArrayList<Product> listProd = new ArrayList<>();
        Statement stmt = con.createStatement();
        Statement stmt2 = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM cart WHERE idU = " + id);
        ResultSet rs2;

        while (rs.next()) {
            int idp = rs.getInt("idP");
            rs2 = stmt2.executeQuery("SELECT * FROM product WHERE idP = " + idp);
            rs2.next();

            Product prod = new Product();
            prod.setIdP(rs.getInt("idP"));
            prod.setNameP(rs2.getString("nameP"));
            prod.setPriceP(rs2.getFloat("priceP"));
            prod.setStorageP(rs.getInt("quantity"));
            prod.setPicP(rs2.getString("picP"));

            listProd.add(prod);
        }
        return listProd;
    }

    public ArrayList<Product> ResearchProd(Connection con, String search) throws SQLException {
        ArrayList<Product> researchProd = new ArrayList<>();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM product WHERE nameP LIKE '%" + search + "%'");
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

    public boolean isAvailable(Connection con, int idP, int quantity) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT storageP FROM product WHERE idP = '" + idP + "'");
        while (rs.next()) {
            if (quantity <= rs.getInt("storageP")) {
                return true;
            }
        }
        return false;
    }

    public void addToCart(Connection con, int idP, int idU, int quantity) throws SQLException {
        int q, stock;
        if (isAvailable(con, idP, quantity) == true) {
            PreparedStatement p = con.prepareStatement("SELECT * FROM cart WHERE idP=" + idP + " AND idU=" + idU);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                q = rs.getInt("quantity");
                q = quantity + q;
                p = con.prepareStatement("UPDATE cart SET quantity=? WHERE idP=" + idP + " AND idU=" + idU);
                p.setInt(1, q);
                p.executeUpdate();
            } else {
                Statement stmt = con.createStatement();
                stmt.executeUpdate("INSERT INTO cart VALUES (null," + idU + "," + idP + "," + quantity + ")");
            }
            p = con.prepareStatement("SELECT * FROM product WHERE idP=" + idP);
            rs = p.executeQuery();
            if (rs.next()) {
                stock = rs.getInt("storageP") - quantity;
                p = con.prepareStatement("UPDATE product SET storageP=? WHERE idP=" + idP);
                p.setInt(1, stock);
                p.executeUpdate();
            }
        }
    }

    public void discardCart(Connection con, int idU) throws SQLException {
        int idP, quantity, storage = 0;
        PreparedStatement p = con.prepareStatement("SELECT * FROM cart WHERE idU=" + idU);
        ResultSet rs = p.executeQuery();
        while (rs.next()) {
            idP = rs.getInt("idP");
            quantity = rs.getInt("quantity");
            PreparedStatement q = con.prepareStatement("SELECT storageP FROM product WHERE idP=" + idP);
            rs = q.executeQuery();
            while (rs.next()) {
                storage = rs.getInt("storageP");
            }
            storage += quantity;
            q = con.prepareStatement("UPDATE product SET quantity=? WHERE idP=" + idP);
            q.setInt(1, storage);
            q.executeUpdate();

            PreparedStatement dlt = con.prepareStatement("DELETE FROM Table WHERE idU = ?");
            dlt.setInt(1, idU);
            dlt.executeUpdate();
        }
    }

    public ArrayList<Product> getCart(Connection con, int idU) throws SQLException {
        ArrayList<Product> listCart = new ArrayList<>();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM product AS p,cart AS c WHERE p.idU=" + idU + " AND c.idu=" + idU);
        while (rs.next()) {
            Product prod = new Product();
            prod.setIdP(rs.getInt("idP"));
            prod.setNameP(rs.getString("nameP"));
            prod.setPriceP(rs.getFloat("priceP"));
            prod.setStorageP(rs.getInt("storageP"));
            prod.setPicP(rs.getString("picP"));
            listCart.add(prod);
        }
        return listCart;
    }
}
