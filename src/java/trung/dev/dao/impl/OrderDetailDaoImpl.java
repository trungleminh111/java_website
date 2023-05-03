/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trung.dev.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import trung.dev.dao.OrderDetailDao;

import trung.dev.dao.model.OrderDetail;
import trung.dev.data.MysqlDriver;

/**
 *
 * @author Administrator
 */
public class OrderDetailDaoImpl implements OrderDetailDao {

    private Connection conn;

    public OrderDetailDaoImpl() {
        this.conn = MysqlDriver.getInstance().getConnection();
    }

    @Override
    public boolean insert(OrderDetail orderDetail) {
        try {
            String sql = "INSERT INTO ORDERDETAIL(ID,AMOUNT,PRODUCT_ID,ORDER_ID,PRICE) VALUES(NULL,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, orderDetail.getAmount());
            stmt.setInt(2, orderDetail.getProduct_id());
            stmt.setInt(3, orderDetail.getOrder_id());
            stmt.setDouble(4, orderDetail.getPrice());
            stmt.execute();

            return stmt.execute();
        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public boolean update(OrderDetail orderDetail) {
        try {
            String sql = "UPDATE ORDERDETAIL SET  AMOUNT=?, PRODUCT_ID=?, ORDER_ID =?, PRICE=? WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, orderDetail.getAmount());
            stmt.setInt(2, orderDetail.getProduct_id());
            stmt.setInt(3, orderDetail.getOrder_id());
            stmt.setDouble(4, orderDetail.getPrice());
            stmt.execute();
        } catch (SQLException ex) {

        }
        return false;

    }

    @Override
    public boolean delete(int id) {
        try {
            String sql = "DELETE FROM ORDERDETAIL WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException ex) {

        }
        return false;
    }

    @Override
    public OrderDetail find(int id) {
        String sql = "SELECT * FROM ORDERDETAIL WHERE ID=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int amount = rs.getInt("amount");
                int productId = rs.getInt("product_id");

                int orderId = rs.getInt("order_id");
                double price = rs.getInt("price");

                return new OrderDetail(id, amount, productId, orderId, price);
            }
        } catch (SQLException ex) {

        }
        return null;
    }

    @Override
    public List<OrderDetail> findAll() {
        List<OrderDetail> orderDetailsList = new ArrayList<OrderDetail>();
        try {
            String sql = "SELECT *FROM ORDERDETAIL WHERE ID > ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 2);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");

                int amount = rs.getInt("amount");
                int productId = rs.getInt("product_id");

                int orderId = rs.getInt("order_id");
                double price = rs.getInt("price");

                orderDetailsList.add(new OrderDetail(id, amount, productId, orderId, price));
            }
        } catch (Exception ex) {
            // TODO: handle exception
        }
        return orderDetailsList;
    }

}
