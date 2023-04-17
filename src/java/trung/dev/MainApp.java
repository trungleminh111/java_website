package trung.dev;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import trung.dev.dao.ProductDao;
import trung.dev.dao.UserDao;	
import trung.dev.dao.CategoryDao;	
import trung.dev.dao.impl.CategoryDaoImpl;

import trung.dev.dao.impl.ProductDaoImpl;
import trung.dev.dao.impl.UserDaoImpl;
import trung.dev.dao.model.Product;
import trung.dev.dao.model.User;
import trung.dev.dao.model.Category;


public class MainApp {
	public static void main(String[] args) {
		
		UserDao userDao = new UserDaoImpl();
		User user = new User("quangbao1@gmail.com", "123456", "nhot");
		userDao.insert(user);
		ProductDao productDao = new ProductDaoImpl();
		Product product = new Product("ao na","giu nhiet","img",200,10,10,1,Timestamp.valueOf(LocalDateTime.now()));
		productDao.insert(product);
                CategoryDao categoryDao = new CategoryDaoImpl();
                Category category = new Category("trung", null);
            
	}

}
