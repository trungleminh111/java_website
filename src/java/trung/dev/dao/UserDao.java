package trung.dev.dao;

import java.util.List;

import trung.dev.dao.model.User;

public interface UserDao {

    public boolean insert(User user);

    public User find(int id);

    public boolean update(User user);

    public boolean delete(int id);

    public List<User> findAll();

    public User findByEmail(String email);

    public int countUser();
}
