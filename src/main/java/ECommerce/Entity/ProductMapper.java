package ECommerce.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductMapper implements RowMapper<Product>{
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setId(rs.getInt("id"));
		product.setProductName(rs.getString("product_name"));
		product.setProductPrice(rs.getDouble("product_price"));
		product.setProductDescription(rs.getString("product_description"));
		product.setProductOrigin(rs.getString("product_origin"));
		product.setBrand(rs.getString("brand"));
		product.setImage(rs.getString("image"));
		product.setProductCategory(rs.getString("product_category"));
		return product;
	}
}
