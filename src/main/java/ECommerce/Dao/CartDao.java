package ECommerce.Dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ECommerce.Dto.CartDto;
import ECommerce.Entity.Product;
import ECommerce.Entity.Voucher;
import ECommerce.Entity.VoucherMapper;

@Repository
public class CartDao implements CartService {
	@Autowired
	ProductDao productDao;

	@Autowired
	JdbcTemplate template;

	@Override
	public HashMap<Integer, CartDto> addCart(int id, HashMap<Integer, CartDto> cart) {
		CartDto itemCart = new CartDto();
		Product product = productDao.getProductById(id);

		if (product != null && cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuantity(itemCart.getQuantity() + 1);
			itemCart.setTotalPrice(itemCart.getProduct().getProductPrice() * itemCart.getQuantity());
		} else {
			itemCart.setProduct(product);
			itemCart.setQuantity(1);
			itemCart.setTotalPrice(product.getProductPrice());
		}
		cart.put(id, itemCart);
		return cart;
	}
	
	@Override
	public HashMap<Integer, CartDto> deleteCartItem(int id, HashMap<Integer, CartDto> cart) {
		CartDto itemCart = new CartDto();
		Product product = productDao.getProductById(id);

		if (product != null && cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuantity(itemCart.getQuantity() - 1);
			itemCart.setTotalPrice(itemCart.getProduct().getProductPrice() * itemCart.getQuantity());
		} else {
			itemCart.setProduct(product);
			itemCart.setQuantity(1);
			itemCart.setTotalPrice(product.getProductPrice());
		}
		cart.put(id, itemCart);
		return cart;
	}

	@Override
	public HashMap<Integer, CartDto> editCart(int id, int quantity, HashMap<Integer, CartDto> cart) {
		CartDto itemCart = new CartDto();

		if (cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuantity(quantity);
			itemCart.setTotalPrice(itemCart.getProduct().getProductPrice() * quantity);
		}

		cart.put(id, itemCart);
		return cart;
	}

	@Override
	public HashMap<Integer, CartDto> deleteCart(int id, HashMap<Integer, CartDto> cart) {
		if (cart == null) {
			return cart;
		}
		if (cart.containsKey(id)) {
			cart.remove(id);
		}
		return cart;
	}

	@Override
	public int totalQuantity(HashMap<Integer, CartDto> cart) {
		int totalQuantity = 0;
		for (Map.Entry<Integer, CartDto> itemCart : cart.entrySet()) {
			totalQuantity += itemCart.getValue().getQuantity();
		}
		return totalQuantity;
	}

	@Override
	public double totalPrice(HashMap<Integer, CartDto> cart) {
		int totalPrice = 0;
		for (Map.Entry<Integer, CartDto> itemCart : cart.entrySet()) {
			totalPrice += itemCart.getValue().getTotalPrice();
		}
		return totalPrice;
	}

	public Voucher getVoucherByName(String voucherCode) {
		List<Voucher> vourchers = new ArrayList<Voucher>();
		String sql = "SELECT * FROM voucher WHERE voucher_code = '" + voucherCode + "' AND voucher_type = 'per_order'";
		vourchers = template.query(sql, new VoucherMapper());
		return vourchers.size() > 0 ? vourchers.get(0) : null;
	}

	public boolean validateVoucher(Voucher voucher) {
		java.util.Date date = new java.util.Date();
		if (voucher.getExpiryDate().before(date)) {
			return false;
		} else {
			return true;
		}
	}

}
