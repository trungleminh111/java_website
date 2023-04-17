package trung.dev.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import trung.dev.dao.UserDao;
import trung.dev.dao.model.User;
import trung.dev.data.MysqlDriver;

public class UserDaoImpl implements UserDao {
	private Connection conn;

	public UserDaoImpl() {
		this.conn = MysqlDriver.getInstance().getConnection();
	}

	@Override
	public boolean insert(User user) {
		// TODO Auto-generated method stub
		try {
			String sql = "INSERT INTO USERS(ID, EMAIL, PASSWORD,ROLE) VALUES(NULL, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getRole());

			return stmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public User find(int id) {
		// TODO Auto-generated method stub
		try {
			String sql = "SELECT * FROM USERS WHERE EMAIL=? AND PASSWORD=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {

				String email = rs.getString("email");
				String password = rs.getString("password");

				String role = rs.getString("role");
				return new User(id,email, password, role);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		try {
			String sql = "UPDATE USERS SET EMAIL=?, PASSWORD=?, ROLE=?, WHERE ID=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getRole());
			return stmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		try {

			String sql = "DELETE FROM USERS WHERE ID=?";
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, id);
			return stmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		List<User> userList = new ArrayList<>();

		try {
			String sql = "SELECT * FROM USERS WHERE ID > ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, 2);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String role = rs.getString("role");
				userList.add(new User(id, email, password, role));
			}
		} catch (SQLException ex) {
		}
		return userList;
	}

}
