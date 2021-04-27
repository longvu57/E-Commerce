package ECommerce.Entity;

public class Order {
	private int id;
	private String username;
	private String phone;
	private String address;
	private int status;
	private String content;
	private String voucher;
	private Double totalPrice;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int id, String username, String phone, String address, int status, String content, String voucher,
			Double totalPrice) {
		super();
		this.id = id;
		this.username = username;
		this.phone = phone;
		this.address = address;
		this.status = status;
		this.content = content;
		this.voucher = voucher;
		this.totalPrice = totalPrice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getVoucher() {
		return voucher;
	}
	public void setVoucher(String voucher) {
		this.voucher = voucher;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	
}
