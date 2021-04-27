package ECommerce.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class OrderMapper implements RowMapper<Order>{
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order order = new Order();
		order.setId(rs.getInt("id"));
		order.setUsername(rs.getString("username"));
		order.setPhone(rs.getString("phone"));
		order.setAddress(rs.getString("address"));
		order.setStatus(rs.getInt("status"));
		order.setContent(rs.getString("content"));
		order.setTotalPrice(rs.getDouble("total_price"));
		order.setVoucher(rs.getString("voucher_code"));
		return order;
	}
}
