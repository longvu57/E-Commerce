package ECommerce.Entity;

public class ProductCategory {
	private int id;
	private String categoryName;
	public ProductCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductCategory(int id, String categoryName) {
		super();
		this.id = id;
		this.categoryName = categoryName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
