package ECommerce.Controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ECommerce.Dao.CartDao;
import ECommerce.Dao.OrderDao;
import ECommerce.Dao.UserDao;
import ECommerce.Dto.CartDto;
import ECommerce.Entity.User;
import ECommerce.Entity.Voucher;

@Controller
public class CartController {
	@Autowired
	CartDao cartDao;

	@Autowired
	UserDao userDao;

	@Autowired
	OrderDao orderDao;

	@RequestMapping("/view-cart")
	public String viewCart(@RequestParam(value = "alert", required = false) String alert, Model model) {
		model.addAttribute("alert", alert);
		return "user/cart";
	}

	@RequestMapping("/add-to-cart")
	public String addToCart(HttpSession session, @RequestParam(value = "id", required = false) int id) {
		HashMap<Integer, CartDto> cart = (HashMap<Integer, CartDto>) session.getAttribute("cart");
		if (cart == null) {
			cart = new HashMap<Integer, CartDto>();
		}
		cart = cartDao.addCart(id, cart);
		session.setAttribute("cart", cart);
		session.setAttribute("totalItem", cartDao.totalQuantity(cart));
		session.setAttribute("totalPrice", cartDao.totalPrice(cart));
		return "redirect:/view-cart";
	}

	@RequestMapping("/checkout")
	public String checkOut(@RequestParam("address") String address, @RequestParam("voucherCode") String voucherCode,
			@RequestParam("phone") String phone, @RequestParam(value = "message", required = false) String message,
			Model model, HttpSession session, Principal principal) {
		Voucher voucher = new Voucher();

		String username = principal.getName();
		System.out.println(voucherCode);
		if(voucherCode.isEmpty()) {			
			double totalPrice = (double) session.getAttribute("totalPrice");
			model.addAttribute("finalPrice", totalPrice);
			
			model.addAttribute("address", address);
			model.addAttribute("phone", phone);
			model.addAttribute("username", username);
			return "user/order-placement";
		}else {
			voucher = cartDao.getVoucherByName(voucherCode);
			
			if (voucher == null || cartDao.validateVoucher(voucher) == false) {
				String alert = "Voucher is not valid!";
				model.addAttribute("alert", alert);
				return "redirect:/view-cart";
			} else {
				int voucherAmount = voucher.getVoucherAmount();
				double totalPrice = (double) session.getAttribute("totalPrice");
				double finalPrice = totalPrice * ((100.0 - (double) voucherAmount) / 100.0);
				session.setAttribute("totalPrice", finalPrice);
				model.addAttribute("finalPrice", finalPrice);
				model.addAttribute("address", address);
				model.addAttribute("phone", phone);
				model.addAttribute("username", username);
				model.addAttribute("voucherCode", voucherCode);
				return "user/order-placement";
			}
		}	
		
	}

	@RequestMapping(value = "/place-order", method = RequestMethod.POST)
	public String placeOrder(HttpSession session, Principal principal, Model model,
			@RequestParam("address") String address, @RequestParam("phone") String phone,
			@RequestParam("voucherCode") String voucherCode) {
		HashMap<Integer, CartDto> cart = (HashMap<Integer, CartDto>) session.getAttribute("cart");
		ObjectMapper mapper = new ObjectMapper();
		List<CartDto> items = new ArrayList<CartDto>();
		double totalPrice = (double) session.getAttribute("totalPrice");

		for (Map.Entry<Integer, CartDto> entry : cart.entrySet()) {
			items.add(entry.getValue());
		}

		String content;
		try {
			content = mapper.writeValueAsString(items);
			String username = principal.getName();
			User user = userDao.getByUser(username);
			orderDao.order(user, address, phone, content, totalPrice, voucherCode);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String message = "Order successfully!";
		model.addAttribute("message", message);
		session.removeAttribute("totalItem");
		session.removeAttribute("cart");
		session.removeAttribute("totalPrice");
		return "user/order-placement";
	}
	
	@RequestMapping("/remove-cart")
	public String removeCart(@RequestParam("id") int id, Model model, HttpSession session) {
		HashMap<Integer, CartDto> cart = (HashMap<Integer, CartDto>) session.getAttribute("cart");
		cartDao.deleteCart(id, cart);
		session.setAttribute("totalItem", cartDao.totalQuantity(cart));
		session.setAttribute("totalPrice", cartDao.totalPrice(cart));
		return "redirect:/view-cart";
	}
	
	@RequestMapping("/add-item-cart")
	public String addItemCart(@RequestParam("id") int id, Model model, HttpSession session) {
		HashMap<Integer, CartDto> cart = (HashMap<Integer, CartDto>) session.getAttribute("cart");
		cartDao.addCart(id, cart);
		session.setAttribute("totalItem", cartDao.totalQuantity(cart));
		session.setAttribute("totalPrice", cartDao.totalPrice(cart));
		return "redirect:/view-cart";
	}
	
	@RequestMapping("/remove-item-cart")
	public String removeItemCart(@RequestParam("id") int id, Model model, HttpSession session) {
		HashMap<Integer, CartDto> cart = (HashMap<Integer, CartDto>) session.getAttribute("cart");
		cartDao.deleteCartItem(id, cart);
		session.setAttribute("totalItem", cartDao.totalQuantity(cart));
		session.setAttribute("totalPrice", cartDao.totalPrice(cart));
		return "redirect:/view-cart";
	}
}
