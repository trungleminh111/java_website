package trung.dev.dao;

import java.util.List;

import trung.dev.dao.model.Product;
import trung.dev.dao.model.User;

public interface ProductDao {
	public boolean insert(Product product);
	public boolean update(Product product);
	public boolean delete(int id);
	public Product find(int productId);
	public List<Product> findAll();

}