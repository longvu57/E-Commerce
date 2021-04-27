package ECommerce.Dao;

import java.util.List;

import ECommerce.Entity.Order;
import ECommerce.Entity.User;

public interface OrderService {
	public int order(User user, String address, String phone, String content, Double totalPrice, String voucherCode);
	public List<Order> getAllOrders();
	public Order getOrderById(int id);
	public int rejectOrder(int id);
	public int acceptOrder(int id);
}
