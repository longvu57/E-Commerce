package ECommerce.Entity;

import java.util.Date;

public class Voucher {
	private int id;
	private String voucherCode;
	private String voucherType;
	private int voucherAmount;
	private int voucherLimit;
	private Date expiryDate;
	private int status;
	public Voucher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Voucher(int id, String voucherCode, String voucherType, int voucherAmount, int voucherLimit, Date expiryDate,
			int status) {
		super();
		this.id = id;
		this.voucherCode = voucherCode;
		this.voucherType = voucherType;
		this.voucherAmount = voucherAmount;
		this.voucherLimit = voucherLimit;
		this.expiryDate = expiryDate;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVoucherCode() {
		return voucherCode;
	}
	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}
	public String getVoucherType() {
		return voucherType;
	}
	public void setVoucherType(String voucherType) {
		this.voucherType = voucherType;
	}
	public int getVoucherAmount() {
		return voucherAmount;
	}
	public void setVoucherAmount(int voucherAmount) {
		this.voucherAmount = voucherAmount;
	}
	public int getVoucherLimit() {
		return voucherLimit;
	}
	public void setVoucherLimit(int voucherLimit) {
		this.voucherLimit = voucherLimit;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
