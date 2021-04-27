package ECommerce.Dto;

public class OrderDetailDto {
	private String productName;
	private double productPrice;
	private int quantity;
	private double subTotal;

	public OrderDetailDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetailDto(String productName, double productPrice, int quantity, double subTotal) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.quantity = quantity;
		this.subTotal = subTotal;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

}
