/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trung.dev.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import trung.dev.dao.CategoryDao;
import trung.dev.dao.model.Category;
import trung.dev.dao.model.Product;

import trung.dev.data.MysqlDriver;

/**
 *
 * @author Administrator
 */
public class CategoryDaoImpl implements CategoryDao {

    private final Connection conn;

    public CategoryDaoImpl() {
        this.conn = MysqlDriver.getInstance().getConnection();
    }

    @Override
    public boolean insert(Category category) {
        try {
            String sql = "INSERT INTO CATEGORIES(id, NAME, IMG, DESCRIPTION) VALUES(NULL, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, category.getName());
            stmt.setString(2, category.getImg());
            stmt.setString(3, category.getDescription());

            return stmt.execute();
        } catch (SQLException e) {
            // TODO: handle exception

        }
        return false;
    }

    @Override
    public boolean update(Category category) {
        try {
            String sql = "UPDATE CATEGORIES SET NAME=?, IMG=?, DESCRIPTION=? WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, category.getName());
            stmt.setString(2, category.getImg());
            stmt.setString(3, category.getDescription());

            stmt.setInt(4, category.getId());

            stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            Connection conn = MysqlDriver.getInstance().getConnection();
            String sql = "DELETE FROM CATEGORIES WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);
            stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }

    @Override
    public Category find(int id) {
        try {
            String sql = "SELECT * FROM CATEGORIES WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {

                String name = rs.getString("name");
                String img = rs.getString("img");
                String description = rs.getString("description");

                return new Category(id, name, img, description);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    @Override
    public List<Category> findAll() {
        List<Category> categoryList = new ArrayList<Category>();

        try {
            String sql = "SELECT * FROM CATEGORIES";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String img = rs.getString("img");
                String description = rs.getString("description");

                categoryList.add(new Category(id, name, img, description));
            }
        } catch (SQLException ex) {
        }

        return categoryList;

    }

}
