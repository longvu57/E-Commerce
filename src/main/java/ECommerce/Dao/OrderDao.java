package ECommerce.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ECommerce.Entity.Order;
import ECommerce.Entity.OrderMapper;
import ECommerce.Entity.User;

@Repository
public class OrderDao implements OrderService {
	@Autowired
	JdbcTemplate template;

	@Override
	public int order(User user, String address, String phone, String content, Double totalPrice, String voucherCode) {
		String sql = "INSERT INTO `orders` (`id`, `username`, `phone`, `address`, `status`, `content`, `total_price`, `voucher_code`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		return template.update(sql, null, user.getUsername(), phone, address, 0, content, totalPrice, voucherCode);
	}

	@Override
	public List<Order> getAllOrders() {
		String sql = "SELECT * FROM orders";
		List<Order> orders = new ArrayList<Order>();
		orders = template.query(sql, new OrderMapper());
		return orders;
	}

	@Override
	public Order getOrderById(int id) {
		String sql = "SELECT * FROM orders WHERE id=" + id;
		List<Order> orders = new ArrayList<Order>();
		orders = template.query(sql, new OrderMapper());
		return orders.size() > 0 ? orders.get(0) : null;
	}
	
	@Override
	public int acceptOrder(int id) {
		String sql = "UPDATE orders SET status = 1 WHERE id = "+id;
		return template.update(sql);
	}

	@Override
	public int rejectOrder(int id) {
		String sql = "UPDATE orders SET status = 2 WHERE id = "+id;
		return template.update(sql);
	}	

}
