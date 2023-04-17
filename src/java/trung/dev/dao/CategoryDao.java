/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package trung.dev.dao;

/**
 *
 * @author Administrator
 */
import java.util.List;
import trung.dev.dao.model.Category;
public interface CategoryDao {
    public boolean insert(Category category);
	public boolean update (Category category);
	public boolean delete (int id);
	public Category find(int id);
	public List<Category> findAll();
}
