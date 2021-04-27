package ECommerce.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ECommerce.Entity.Voucher;
import ECommerce.Entity.VoucherMapper;

@Repository
public class VoucherDao implements VoucherService {
	@Autowired
	JdbcTemplate template;

	@Override
	public int addNewVoucher(Voucher voucher) {
		String sql = "INSERT INTO `voucher` (`id`, `voucher_code`, `voucher_type`, `voucher_amount`, `voucher_limit`, `expiry_date`, `status`) VALUES (?, ?, ?, ?, ?, ?, ?)";
		return template.update(sql, null, voucher.getVoucherCode(), voucher.getVoucherType(),
				voucher.getVoucherAmount(), voucher.getVoucherLimit(), voucher.getExpiryDate(), 1);
	}

	@Override
	public List<Voucher> getAllVoucher() {
		List<Voucher> vouchers = new ArrayList<Voucher>();
		String sql = "SELECT * FROM voucher";
		vouchers = template.query(sql, new VoucherMapper());
		return vouchers;
	}

	@Override
	public List<Voucher> getProductVoucher() {
		List<Voucher> vouchers = new ArrayList<Voucher>();
		String sql = "SELECT * FROM voucher WHERE voucher_type = 'per_product' AND status = 1";
		vouchers = template.query(sql, new VoucherMapper());
		return vouchers;
	}

	@Override
	public int deleteVoucher(int id) {
		String sql = "DELETE FROM voucher WHERE id = ?";
		return template.update(sql, id);
	}

	@Override
	public Voucher getVoucherByName(String voucherCode) {
		List<Voucher> vouchers = new ArrayList<Voucher>();
		String sql = "SELECT * FROM voucher WHERE voucher_code = '" + voucherCode + "'";
		vouchers = template.query(sql, new VoucherMapper());
		return vouchers.size() > 0 ? vouchers.get(0) : null;
	}

}
