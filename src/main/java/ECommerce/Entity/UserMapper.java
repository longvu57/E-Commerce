package ECommerce.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User>{
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setPhone(rs.getString("phone"));
		user.setEmail(rs.getString("email"));
		user.setRole(rs.getString("role"));
		user.setEnabled(rs.getInt("enabled"));
		return user;
	}
}