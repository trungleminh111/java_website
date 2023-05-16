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
    public int amount;
    public int orderId;
    public int productId;
    public double price;

    public OrderDetail(int amount, int orderId, int productId, double price) {
        this.amount = amount;
        this.orderId = orderId;
        this.productId = productId;
        this.price = price;
    }

    public OrderDetail(int id, int amount, int orderId, int productId, double price) {
        this.id = id;
        this.amount = amount;
        this.orderId = orderId;
        this.productId = productId;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product getProduct() {
        return DatabaseDao.getInstance().getProductDao().find(productId);
    }

    public Order getOrder() {
        return DatabaseDao.getInstance().getOrderDao().find(orderId);
    }
}   