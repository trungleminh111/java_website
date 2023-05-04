/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trung.dev.dao.model;

import trung.dev.dao.DatabaseDao;

/**
 *
 * @author Administrator
 */
public class OrderDetail {

    public int id;
    public int productId;
    public int orderId;
    public int quantity;
    public double price;
    public double amount;

    public OrderDetail(int productId, int orderId, int quantity, double price) {
        super();
        this.productId = productId;
        this.orderId = orderId;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderDetail(int id, int productId, int orderId, int quantity, double price) {
        super();
        this.id = id;
        this.productId = productId;
        this.orderId = orderId;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
