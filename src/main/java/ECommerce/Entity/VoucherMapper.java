package ECommerce.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class VoucherMapper implements RowMapper<Voucher>{
		public Voucher mapRow(ResultSet rs, int rowNum) throws SQLException {
			Voucher voucher = new Voucher();
			voucher.setId(rs.getInt("id"));
			voucher.setVoucherCode(rs.getString("voucher_code"));
			voucher.setVoucherLimit(rs.getInt("voucher_limit"));
			voucher.setVoucherType(rs.getString("voucher_type"));
			voucher.setVoucherAmount(rs.getInt("voucher_amount"));
			voucher.setExpiryDate(rs.getDate("expiry_date"));
			voucher.setStatus(rs.getInt("status"));
			return voucher;
		}
}
