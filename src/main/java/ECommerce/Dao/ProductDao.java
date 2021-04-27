package ECommerce.Dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

import ECommerce.Entity.Product;
import ECommerce.Entity.ProductCategory;
import ECommerce.Entity.ProductCategoryMapper;
import ECommerce.Entity.ProductMapper;

@Repository
public class ProductDao implements ProductService {

	@Value("${aws.bucket_name}")
	private String BUCKET_NAME;
	@Value("${aws.access_key}")
	private String ACCESS_KEY;
	@Value("${aws.secret_key}")
	private String SECRET_KEY;
	@Value("${aws.region}")
	private String REGION;

	@Autowired
	JdbcTemplate template;

	@Override
	public int addNewProduct(Product product) {
		String sql = "INSERT INTO `products` (`id`, `product_name`, `product_price`, `product_description`, `product_origin`, `brand`, `image`, `product_category`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		return template.update(sql, null, product.getProductName(), product.getProductPrice(),
				product.getProductDescription(), product.getProductOrigin(), product.getBrand(), product.getImage(), product.getProductCategory());
	}

	@Override
	public int updateProduct(Product product) {
		String sql = "UPDATE `products` SET `product_name` = ?, `product_price` = ?, `product_description` = ?, `product_origin` = ?, `brand` = ?, `image` = ?, `product_category` = ? WHERE `products`.`id` = ?";
		return template.update(sql, product.getProductName(), product.getProductPrice(),
				product.getProductDescription(), product.getProductOrigin(), product.getBrand(), product.getImage(), product.getProductCategory(), product.getId());
	}

	@Override
	public int deleteProduct(int id) {
		String sql = "DELETE FROM `products` WHERE `products`.`id` = ?";
		return template.update(sql, id);
	}

	@Override
	public Product getProductById(int id) {
		Product product = new Product();
		String sql = "SELECT * FROM products WHERE id = " + id;
		product = template.queryForObject(sql, new ProductMapper());
		return product;
	}

	@Override
	public List<Product> getAllProduct() {
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT * FROM products";
		products = template.query(sql, new ProductMapper());
		return products;
	}

	@Override
	public String uploadImage(MultipartFile image) {
		BasicAWSCredentials cred = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);

		String fileName = image.getOriginalFilename();

		AmazonS3 s3client = AmazonS3Client.builder().withRegion(REGION)
				.withCredentials(new AWSStaticCredentialsProvider(cred)).build();

		String bucketName = BUCKET_NAME;

		try {
			InputStream is = image.getInputStream();
			s3client.putObject(new PutObjectRequest(bucketName, fileName, is, new ObjectMetadata())
					.withCannedAcl(CannedAccessControlList.PublicRead));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		S3Object s3object = s3client.getObject(new GetObjectRequest(bucketName, image.getOriginalFilename()));
		String imageUrl = s3object.getObjectContent().getHttpRequest().getURI().toString();

		return imageUrl;
	}

	@Override
	public List<ProductCategory> getAllCategory() {
		List<ProductCategory> categories = new ArrayList<ProductCategory>();
		String sql = "SELECT * FROM product_category";
		categories = template.query(sql, new ProductCategoryMapper());
		return categories;
	}

	@Override
	public int deleteCategory(int id) {
		String sql = "DELETE FROM product_category WHERE id = ?";
		return template.update(sql, id);
	}

	@Override
	public int addNewCategory(ProductCategory productCategory) {
		String sql = "INSERT INTO product_category (id, category_name) VALUES (?,?)";
		return template.update(sql, null, productCategory.getCategoryName());
	}

	@Override
	public List<Product> sortByPrice(String price) {
		String sql = "SELECT * FROM products ORDER BY product_price " + price;
		List<Product> products = new ArrayList<Product>();
		products = template.query(sql, new ProductMapper());
		return products;
	}

	@Override
	public List<Product> sortByAlphabet(String alphabet) {
		String sql = "SELECT * FROM products ORDER BY product_name " + alphabet;
		List<Product> products = new ArrayList<Product>();
		products = template.query(sql, new ProductMapper());
		return products;
	}

	@Override
	public List<Product> sortByCategory(String category) {
		String sql = "SELECT * FROM products WHERE product_category = '" + category + "'";
		List<Product> products = new ArrayList<Product>();
		products = template.query(sql, new ProductMapper());
		return products;
	}

}
