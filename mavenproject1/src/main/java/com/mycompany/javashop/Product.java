//Libraries
package com.mycompany.javashop;

//Class Product
public class Product {
    private int idP;
    private String nameP;
    private float priceP;
    private String picP;
    private int storageP;

    public Product(int idP, String nameP, float priceP, String picP, int storageP) {
        this.idP = idP;
        this.nameP = nameP;
        this.priceP = priceP;
        this.picP = picP;
        this.storageP = storageP;
    }

    public Product() {
    }

    public int getIdP() {
        return idP;
    }
    
    public String getNameP() {
        return nameP;
    }

    public float getPriceP() {
        return priceP;
    }

    public String getPicP() {
        return picP;
    }
    
    public int getStorageP() {
        return storageP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public void setNameP(String nameP) {
        this.nameP = nameP;
    }

    public void setPriceP(float priceP) {
        this.priceP = priceP;
    }

    public void setPicP(String picP) {
        this.picP = picP;
    }   
    
    public void setStorageP(int storageP) {
        this.storageP = storageP;
    }
    
}