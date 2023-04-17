/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trung.dev.dao.model;

import java.io.Serializable;

/**
 *
 * @author Administrator
 */
public class OrderDetailSesstion implements Serializable {

    private int productId;
    private String productName;
    private String productImg;
    private int quantity;
    private double productPrice;

    public OrderDetailSesstion(int productId, String productName, String productImg, int quantity, double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productImg = productImg;
        this.quantity = quantity;
        this.productPrice = productPrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

}
