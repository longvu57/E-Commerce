package ECommerce.Dao;

import java.util.HashMap;

import ECommerce.Dto.CartDto;

public interface CartService {
	public HashMap<Integer, CartDto> addCart(int id, HashMap<Integer, CartDto> cart);
	public HashMap<Integer, CartDto> editCart(int id, int quantity, HashMap<Integer, CartDto> cart);
	public HashMap<Integer, CartDto> deleteCart(int id, HashMap<Integer, CartDto> cart);
	public int totalQuantity(HashMap<Integer, CartDto> cart);
	public double totalPrice(HashMap<Integer, CartDto> cart);
	public HashMap<Integer, CartDto> deleteCartItem(int id, HashMap<Integer, CartDto> cart);
}
