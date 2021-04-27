package ECommerce.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import ECommerce.Entity.User;
import ECommerce.Entity.UserMapper;

@Repository
public class UserDao implements UserService {
	@Autowired
	JdbcTemplate template;

	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		String sql = "SELECT * FROM users";
		users = template.query(sql, new UserMapper());
		return users;
	}

	@Override
	public int lockUser(int id) {
		String sql = "UPDATE `users` SET `enabled` = '0' WHERE `users`.`id` = " + id;
		return template.update(sql);
	}

	@Override
	public int unlockUser(int id) {
		String sql = "UPDATE `users` SET `enabled` = '1' WHERE `users`.`id` = " + id;
		return template.update(sql);
	}

	@Override
	public User getByUser(String username) {
		List<User> users = new ArrayList<User>();
		String sql = "SELECT * FROM users WHERE username = '" + username + "'";
		users = template.query(sql, new UserMapper());
		return users.size() > 0 ? users.get(0) : null;
	}

	@Override
	public User findByUser(String username) {
		List<User> users = new ArrayList<User>();
		String sql = "SELECT * FROM users WHERE username = '" + username + "'";
		users = template.query(sql, new UserMapper());
		return users.size() > 0 ? users.get(0) : null;
	}

	@Override
	public int register(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(user.getPassword());

		String sql = "INSERT INTO users(id, username, password, phone, email, role, enabled) VALUES(?,?,?,?,?,?,?)";
		return template.update(sql, null, user.getUsername(), hashedPassword, user.getPhone(), user.getEmail(),
				user.getRole(), user.getEnabled());

	}

}
