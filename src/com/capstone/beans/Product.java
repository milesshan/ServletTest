package com.capstone.beans;

public class Product {
    private int productId;
    private String productName;
    private float productPrice;

    public Product(int productId, String productName, float productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }
    
    public int getProductId() {
        return productId;
    }
    public String getProductName() {
        return productName;
    }
    public float getProductPrice() {
        return productPrice;
    }
    
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setProductImgPath(float productPrice) {
        this.productPrice = productPrice;
    }
}

