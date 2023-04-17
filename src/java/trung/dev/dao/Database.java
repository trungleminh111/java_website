/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trung.dev.dao;

import trung.dev.dao.impl.CategoryDaoImpl;
import trung.dev.dao.impl.ProductDaoImpl;
import trung.dev.dao.impl.UserDaoImpl;

/**
 *
 * @author Administrator
 */
public class Database extends DatabaseDao {
     @Override
    public UserDao getUserDao() {
        // TODO Auto-generated method stub
        return new UserDaoImpl();
    }

    @Override
    public ProductDao getProductDao() {
        return new ProductDaoImpl();
    }

    @Override
    public CategoryDao getCategoryDao() {
        return new CategoryDaoImpl();
    }
    
}
