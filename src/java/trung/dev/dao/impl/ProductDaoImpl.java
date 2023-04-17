package trung.dev.dao.impl;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import trung.dev.dao.ProductDao;
import trung.dev.dao.model.Product;
import trung.dev.dao.model.User;

import trung.dev.data.MysqlDriver;

public class ProductDaoImpl implements ProductDao {

    private Connection conn;

    public ProductDaoImpl() {
        this.conn = MysqlDriver.getInstance().getConnection();
    }

    @Override
    public boolean insert(Product product) {
        // TODO Auto-generated method stub
        try {
            String sql = "INSERT INTO PRODUCTS(ID, NAME, DESCRIPTION, PRICE, QUANTITY, VIEW, CATEGORY_ID, CREATED_AT)VALUES(NULL, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setString(3, product.getImg());

            stmt.setDouble(4, product.getPrice());
            stmt.setInt(5, product.getQuantity());
            stmt.setInt(6, product.getView());
            stmt.setInt(7, product.getCategoryId());
            stmt.setTimestamp(8, product.getCreatedAt());

            return stmt.execute();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Product product) {
        // TODO Auto-generated method stub
        try {
            String sql = "UPDATE PRODUCTS SET NAME=?, DESCRIPTION=?, IMG=?, PRICE=?, QUANTITY=?, VIEW=?, CATEGORY_ID=?, CREATED_AT=?  WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setString(3, product.getImg());

            stmt.setDouble(4, product.getPrice());
            stmt.setInt(5, product.getQuantity());
            stmt.setInt(6, product.getView());
            stmt.setInt(7, product.getCategoryId());
            stmt.setTimestamp(8, product.getCreatedAt());
            stmt.setInt(9, product.getId());
            return stmt.execute();

        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }

    public boolean delete(int id) {
        // TODO Auto-generated method stub
        try {
            String sql = "DELETE FROM PRODUCTS WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            return stmt.execute();

        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }

    @Override
    public Product find(int id) {
        // TODO Auto-generated method stub
        try {
            String sql = "SELECT * FROM PRODUCTS WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                String img = rs.getString("img");
                Double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                int categoryId = rs.getInt("category_id");
                Timestamp createdAt = rs.getTimestamp("created_at");
                return new Product(id, name, description, img, price, quantity, view, categoryId, createdAt);
            }
        } catch (SQLException e) {
            // TODO: handle exception
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        // TODO Auto-generated method stub
        List<Product> productList = new ArrayList<Product>();
        try {
            String sql = "SELECT *FROM PRODUCTS WHERE ID > ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 2);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String img = rs.getString("img");

                Double price = rs.getDouble("price");
                Integer quantity = rs.getInt("quantity");
                Integer view = rs.getInt("view");
                Integer categoryId = rs.getInt("category_id");
                Timestamp createdAt = rs.getTimestamp("created_at");
                productList.add(new Product(id, name, description, img, price, quantity, view, categoryId, createdAt));
            }
        } catch (Exception ex) {
            // TODO: handle exception
        }
        return productList;
    }

}
