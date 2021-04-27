package ECommerce.Entity;

public class Product {
	private int id;
	private String productName;
	private double productPrice;
	private String productDescription;
	private String productOrigin;
	private String brand;
	private String image;
	private String productCategory;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int id, String productName, double productPrice, String productDescription, String productOrigin,
			String brand, String image, String productCategory) {
		super();
		this.id = id;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
		this.productOrigin = productOrigin;
		this.brand = brand;
		this.image = image;
		this.productCategory = productCategory;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getProductOrigin() {
		return productOrigin;
	}
	public void setProductOrigin(String productOrigin) {
		this.productOrigin = productOrigin;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	
}
