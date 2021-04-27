package ECommerce.Dto;

import ECommerce.Entity.Product;

public class CartDto {
	private int quantity;
	private double totalPrice;
	private Product product;
	public CartDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartDto(int quantity, double totalPrice, Product product) {
		super();
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
}
