package ECommerce.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductCategoryMapper implements RowMapper<ProductCategory>{
	public ProductCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductCategory productCategory = new ProductCategory();
		productCategory.setId(rs.getInt("id"));
		productCategory.setCategoryName(rs.getString("category_name"));
		return productCategory;
	}
}
