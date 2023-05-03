/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trung.dev.dao.impl;

import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.util.List;
import trung.dev.dao.OrderDao;
import trung.dev.dao.model.Order;
import trung.dev.data.MysqlDriver;
import trung.dev.dao.model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class OrderDaoImpl implements OrderDao {

    private Connection conn;

    public OrderDaoImpl() {
        this.conn = MysqlDriver.getInstance().getConnection();
    }

    @Override
    public boolean insert(Order order) {
        try {
            String sql = "INSERT INTO ORDERS(ID,CODE, DESCRIPTION, STATUS,USER_ID) VALUES(NULL,?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, order.getCode());

            stmt.setString(2, order.getDescription());

            stmt.setString(3, order.getStatus());
            stmt.setInt(4, order.getUserId());
            stmt.execute();

            return stmt.execute();
        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public boolean update(Order order) {

        try {
            String sql = "UPDATE ORDERs SET CODE=?, STATUS=?, USER_ID=? where id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, order.getCode());
            stmt.setString(2, order.getStatus());
            stmt.setInt(3, order.getUserId());
            stmt.setInt(4, order.getId());
            stmt.execute();
        } catch (SQLException ex) {

        }
        return false;
    }

    @Override
    public boolean delete(int id) {

        try {
            String sql = "DELETE FROM ORDERS WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException ex) {

        }
        return false;
    }

    @Override
    public Order find(int id) {
        String sql = "SELECT * FROM ORDERS WHERE ID=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String code = rs.getString("code");
                String description = rs.getString("description");
                String status = rs.getString("status");
                int userId = rs.getInt("user_id");

                return new Order(id, code, description, status, userId);
            }
        } catch (SQLException ex) {

        }
        return null;
    }

    @Override
    public List<Order> findAll() {
        List<Order> orderList = new ArrayList<Order>();
        try {
            String sql = "SELECT *FROM ORDERS WHERE ID > ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 2);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String code = rs.getString("code");
                String description = rs.getString("description");
                String status = rs.getString("status");
                int userId = rs.getInt("user_id");

                orderList.add(new Order(id, code, description, status, userId));
            }
        } catch (Exception ex) {
            // TODO: handle exception
        }
        return orderList;
    }

    @Override
    public Order find(String code) {
       
        try {
            String sql = "SELECT * FROM ORDERS WHERE CODE = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, code);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String description = rs.getString("description");
                String status = rs.getString("status");
                int userId = rs.getInt("user_id");
                return new Order(id, code, description, status, userId);
            }

        } catch (SQLException e) {
        }
        return null;
    }

}
