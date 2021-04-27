package ECommerce.Dao;

import java.util.List;

import ECommerce.Entity.Voucher;

public interface VoucherService {
	public int addNewVoucher(Voucher vourcher);
	public List<Voucher> getAllVoucher();
	public int deleteVoucher(int id);
	public List<Voucher> getProductVoucher();
	public Voucher getVoucherByName(String voucherCode);
}
