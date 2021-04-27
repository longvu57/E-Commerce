package ECommerce.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import ECommerce.Dao.OrderDao;
import ECommerce.Dto.OrderDetailDto;
import ECommerce.Entity.Order;

@Controller
public class OrderController {
	@Autowired
	OrderDao orderDao;

	@RequestMapping(value = { "/admin/order-management" }, method = RequestMethod.GET)
	public String order(Model model) {
		List<Order> orders = new ArrayList<Order>();
		orders = orderDao.getAllOrders();
		model.addAttribute("orders", orders);
		return "admin/order-management";
	}

	@RequestMapping(value = "/admin/order-details", method = RequestMethod.GET)
	public String orderDetails(@RequestParam("id") int id, Model model) {
		Order order = orderDao.getOrderById(id);
		String content = order.getContent();
		String username = order.getUsername();
		double totalPrice = order.getTotalPrice();
		String voucherCode = order.getVoucher();
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode contentObject = mapper.readTree(content);
			List<OrderDetailDto> orderDetails = new ArrayList<OrderDetailDto>();
			for (int i = 0; i < contentObject.size(); i++) {
				
				OrderDetailDto orderDetail = new OrderDetailDto();
				JsonNode item = contentObject.get(i);
				String productName = item.get("product").get("productName").asText();
				double productPrice = item.get("product").get("productPrice").asDouble();
				int quantity = item.get("quantity").asInt();
				
				orderDetail.setProductName(productName);
				orderDetail.setProductPrice(productPrice);
				orderDetail.setQuantity(quantity);
				orderDetail.setSubTotal(productPrice*quantity);
				
				orderDetails.add(orderDetail);
			}
			model.addAttribute("content", orderDetails);
			model.addAttribute("username", username);
			model.addAttribute("totalPrice", totalPrice);
			model.addAttribute("voucherCode", voucherCode);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "admin/order-details";
	}
	
	@RequestMapping(value = "/admin/reject-order", method = RequestMethod.POST)
	public String rejectOrder(@RequestParam("id") int id, Model model) {
		orderDao.rejectOrder(id);
		return "redirect:/admin/order-management";
	}
	
	@RequestMapping(value = "/admin/accept-order", method = RequestMethod.POST)
	public String acceptOrder(@RequestParam("id") int id, Model model) {
		orderDao.acceptOrder(id);
		return "redirect:/admin/order-management";
	}

}
