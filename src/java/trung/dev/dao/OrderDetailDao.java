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

  public void insert(OrderDetail orderDetail);

    public void update(OrderDetail orderDetail);

    public void delete(int orderDetailId);

    public OrderDetail find(int orderDetailId);

    public List<OrderDetail> findAll();

    public List<OrderDetail> findByOrder(int orderId);
}
