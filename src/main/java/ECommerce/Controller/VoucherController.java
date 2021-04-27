package ECommerce.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ECommerce.Dao.VoucherDao;
import ECommerce.Entity.Voucher;

@Controller
public class VoucherController {
	@Autowired
	VoucherDao voucherDao;

	@RequestMapping(value = { "/admin/voucher-management" }, method = RequestMethod.GET)
	public String voucher(Model model, @RequestParam(value = "error", required = false) String error, @RequestParam(value = "message", required = false) String message) {
		List<Voucher> vouchers = new ArrayList<Voucher>();
		vouchers = voucherDao.getAllVoucher();
		
		model.addAttribute("error", error);
		model.addAttribute("message", message);
		model.addAttribute("voucherList", vouchers);
		model.addAttribute("voucher", new Voucher());
		return "admin/voucher-management";
	}

	@RequestMapping(value = { "/admin/add-voucher" }, method = RequestMethod.POST)
	public String addVoucher(Model model, @RequestParam("voucherCode") String voucherCode,
			@RequestParam("voucherType") String voucherType, @RequestParam("voucherAmount") int voucherAmount,
			@RequestParam("voucherLimit") int voucherLimit, @RequestParam("expiryDate") String date) {
		String message = "New voucher added successfully!";
		Voucher voucher = new Voucher();
		if(voucherDao.getVoucherByName(voucherCode) != null) {
			System.out.println("hi");
			String error = "Voucher is already existed!";
			model.addAttribute("error", error);
			return "redirect:/admin/voucher-management";
		}
		voucher.setVoucherCode(voucherCode);
		voucher.setVoucherType(voucherType);
		voucher.setVoucherAmount(voucherAmount);
		voucher.setVoucherLimit(voucherLimit);
		try {
			Date expiryDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			voucher.setExpiryDate(expiryDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		voucherDao.addNewVoucher(voucher);
		
		model.addAttribute("message", message);
		return "redirect:/admin/voucher-management";
	}
	
	@RequestMapping(value = { "/admin/delete-voucher" }, method = RequestMethod.POST)
	public String deleteVoucher(@RequestParam("id") int id) {
		voucherDao.deleteVoucher(id);
		return "redirect:/admin/voucher-management";
	}

}
