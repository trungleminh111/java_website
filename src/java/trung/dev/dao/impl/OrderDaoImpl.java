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
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class OrderDaoImpl implements OrderDao {

    @Override
    public void insert(Order order) {
        // TODO Auto-generated method stub
        Connection conn = MysqlDriver.getInstance().getConnection();
        try {
            String sql = "INSERT INTO ORDERS(id, code, description, status, user_id) VALUES(NULL,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, order.code);
            stmt.setString(2, order.description);
            stmt.setString(3, order.status);
            stmt.setInt(4, order.userId);
            stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
            Logger.getLogger("insert order").log(Level.SEVERE, e.toString());
        }
    }

    @Override
    public void update(Order order) {
        // TODO Auto-generated method stub
        Connection conn = MysqlDriver.getInstance().getConnection();
        try {
            String sql = "UPDATE ORDERS SET code=?, DESCRIPTION=?, status=?, user_id=? WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, order.code);
            stmt.setString(2, order.description);
            stmt.setString(3, order.status);
            stmt.setInt(4, order.userId);
            stmt.setInt(5, order.id);
            stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public void delete(int orderId) {
        // TODO Auto-generated method stub
        try {
            Connection conn = MysqlDriver.getInstance().getConnection();
            String sql = "DELETE FROM ORDERS WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, orderId);
            stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public Order find(int orderId) {
        // TODO Auto-generated method stub
        Connection conn = MysqlDriver.getInstance().getConnection();
        try {
            String sql = "SELECT * FROM ORDERS WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String code = rs.getString("code");
                String description = rs.getString("description");
                String status = rs.getString("status");
                int userId = rs.getInt("user_id");

                return new Order(id, code, description, status, userId);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    @Override
    public List<Order> findAll() {
        // TODO Auto-generated method stub
        List<Order> orderList = new ArrayList<>();
        Connection conn = MysqlDriver.getInstance().getConnection();
        try {
            String sql = "SELECT * FROM ORDERS";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String code = rs.getString("code");
                String description = rs.getString("description");
                String status = rs.getString("status");
                int user_id = rs.getInt("user_id");
                orderList.add(new Order(id, code, description, status, user_id));
            }
        } catch (SQLException ex) {
        }

        return orderList;
    }

    @Override
    public Order find(String code) {
        Connection conn = MysqlDriver.getInstance().getConnection();
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

    @Override
    public List<Order> findByStatus(String status) {
        List<Order> orderList = new ArrayList<>();
        Connection conn = MysqlDriver.getInstance().getConnection();
        try {
            String sql = "SELECT * FROM ORDERS WHERE STATUS=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, status);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String code = rs.getString("code");
                String description = rs.getString("description");
                int userId = rs.getInt("user_id");
                orderList.add(new Order(id, code, description, status, userId));
            }
        } catch (SQLException ex) {
        }

        return orderList;
    }

    @Override
    public int countOrderByDay(String date) {
        int count = 0;
        Connection conn = MysqlDriver.getInstance().getConnection();
        String sql = "SELECT COUNT(*) AS count FROM orders where date(created_at)=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, date);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    @Override
    public int countOrder() {
        String sql = "SELECT COUNT(*) AS count FROM orders";
        try {
            Connection conn = MysqlDriver.getInstance().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int countOrder = rs.getInt("count");
                return countOrder;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int countPendingOrder() {
        String sql = "SELECT COUNT(*) AS count FROM orders WHERE STATUS = 'PENDING'";
        try {
            Connection conn = MysqlDriver.getInstance().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int countPendingOrder = rs.getInt("count");
                return countPendingOrder;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int countShippingOrder() {
        String sql = "SELECT COUNT(*) AS count FROM orders WHERE STATUS = 'SHIPPING'";
        try {
            Connection conn = MysqlDriver.getInstance().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int countShippingOrder = rs.getInt("count");
                return countShippingOrder;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int countDeliveredOrder() {
        String sql = "SELECT COUNT(*) AS count FROM orders WHERE STATUS = 'DELIVERED'";
        try {
            Connection conn = MysqlDriver.getInstance().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int countDeliveredOrder = rs.getInt("count");
                return countDeliveredOrder;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int countCanceledOrder() {
        String sql = "SELECT COUNT(*) AS count FROM orders WHERE STATUS = 'CANCELED'";
        try {
            Connection conn = MysqlDriver.getInstance().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int countDeliveredOrder = rs.getInt("count");
                return countDeliveredOrder;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}
