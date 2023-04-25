/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package trung.dev.dao;

import java.util.List;

import trung.dev.dao.model.OrderDetail;

/**
 *
 * @author Administrator
 */
public interface OrderDetailDao {

    public boolean insert(OrderDetail orderDetail);

    public boolean update(OrderDetail orderDetail);

    public boolean delete(int id);

    public OrderDetail find(int orderId);

    public List<OrderDetail> findAll();
}
