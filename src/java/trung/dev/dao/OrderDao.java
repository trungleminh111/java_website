/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package trung.dev.dao;

import java.util.List;
import trung.dev.dao.model.Order;

/**
 *
 * @author Administrator
 */
public interface OrderDao {

    public boolean insert(Order order);

    public boolean update(Order order);

    public boolean delete(int id);

    public Order find(int id);

    public List<Order> findAll();

    public Order find(String code);
}
