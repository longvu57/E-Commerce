package ECommerce.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import ECommerce.Entity.Product;
import ECommerce.Entity.ProductCategory;
@Repository
public interface ProductService {
	public Product getProductById(int id);
	public List<Product> getAllProduct();
	public String uploadImage(MultipartFile image);
	public int addNewProduct(Product product);
	public int updateProduct(Product product);
	public int deleteProduct(int id);
	public int addNewCategory(ProductCategory productCategory);
	public List<ProductCategory> getAllCategory();
	public int deleteCategory(int id);
	public List<Product> sortByPrice(String price);
	public List<Product> sortByAlphabet(String alphabet);
	public List<Product> sortByCategory(String category);
}
