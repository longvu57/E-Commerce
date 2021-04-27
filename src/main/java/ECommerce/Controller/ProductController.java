package ECommerce.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ECommerce.Dao.ProductDao;
import ECommerce.Dao.VoucherDao;
import ECommerce.Entity.Product;
import ECommerce.Entity.ProductCategory;
import ECommerce.Entity.Voucher;

@Controller
public class ProductController {

	@Autowired
	ProductDao productDao;
	@Autowired
	VoucherDao voucherDao;

	@RequestMapping(value = { "/admin"}, method = RequestMethod.GET)
	public String admin(Model model, @RequestParam(value = "message", required = false) String message,
			@RequestParam(value = "error", required = false) String error) {
		List<Product> products = new ArrayList<Product>();
		products = productDao.getAllProduct();
		
		List<Voucher> vouchers = new ArrayList<Voucher>();
		vouchers = voucherDao.getProductVoucher();
		
		List<ProductCategory> categories = new ArrayList<ProductCategory>();
		categories = productDao.getAllCategory();
		
		model.addAttribute("vouchers", vouchers);
		model.addAttribute("products", products);
		model.addAttribute("categories", categories);
		model.addAttribute("productCategory", new ProductCategory());
		model.addAttribute("message", message);
		model.addAttribute("error", error);
		return "admin/product-management";
	}

	@RequestMapping(value = { "/admin/edit-product" }, method = RequestMethod.GET)
	public String edit(Model model, @RequestParam int productId) {
		List<Voucher> vouchers = new ArrayList<Voucher>();
		vouchers = voucherDao.getProductVoucher();
		
		List<ProductCategory> categories = new ArrayList<ProductCategory>();
		categories = productDao.getAllCategory();
		
		Product product = new Product();
		product = productDao.getProductById(productId);
		
		model.addAttribute("categories", categories);
		model.addAttribute("vouchers", vouchers);
		model.addAttribute("product", product);
		return "admin/edit-product";
	}

	@RequestMapping(method = RequestMethod.POST, value = "admin/addNewProduct")
	public String addNewProduct(Model model, @RequestParam("productName") String productName,
			@RequestParam("productPrice") double productPrice, @RequestParam("brand") String brand,
			@RequestParam("productDescription") String productDescription, @RequestParam("image") MultipartFile image,
			@RequestParam("productOrigin") String productOrigin, @RequestParam("productCategory") String productCategory) {
		String message = "Adding successfully";
		String error = "Adding failed!";

		String img = productDao.uploadImage(image);

		Product product = new Product();
		product.setProductName(productName);
		product.setProductPrice(productPrice);
		product.setBrand(brand);
		product.setProductDescription(productDescription);
		product.setImage(img);
		product.setProductOrigin(productOrigin);
		product.setProductCategory(productCategory);

		int status = productDao.addNewProduct(product);
		if (status > 0) {
			model.addAttribute("message", message);
			return "redirect:/admin";
		} else {
			model.addAttribute("error", error);
			return "redirect:/admin";
		}
	}

	@RequestMapping(value = "admin/updateProduct", method = RequestMethod.POST)
	public String updateProduct(Model model, @RequestParam("id") int id, @RequestParam("productName") String productName,
			@RequestParam("productPrice") double productPrice, @RequestParam("brand") String brand,
			@RequestParam("productDescription") String productDescription, @RequestParam("image") MultipartFile image,
			@RequestParam("productOrigin") String productOrigin, @RequestParam("productCategory") String productCategory) {
		
		String message = "Update successfully";
		String error = "Update failed!";
		
		String img = productDao.uploadImage(image);

		Product product = new Product();
		product.setId(id);
		product.setProductName(productName);
		product.setProductPrice(productPrice);
		product.setBrand(brand);
		product.setProductDescription(productDescription);
		product.setImage(img);
		product.setProductOrigin(productOrigin);
		product.setProductCategory(productCategory);
		
		int status = productDao.updateProduct(product);
		if (status > 0) {
			model.addAttribute("message", message);
			return "redirect:/admin";
		} else {
			model.addAttribute("error", error);
			return "redirect:/admin";
		}
	}

	@RequestMapping(value = "admin/deleteProduct", method = RequestMethod.POST)
	public String deleteProduct(Product product, @RequestParam int id, Model model) {
		String message = "Delete successfully";
		String error = "Delete failed!";
		int status = productDao.deleteProduct(id);
		if (status > 0) {
			model.addAttribute("message", message);
			return "redirect:/admin";
		} else {
			model.addAttribute("error", error);
			return "redirect:/admin";
		}
	}
	
	@RequestMapping(value = "admin/add-product-category",method = RequestMethod.POST)
	public String addProductCategory(ProductCategory productCategory, Model model) {
		String message = "Add new category successfully";
		String error = "Cannot add new category!";
		
		int status = productDao.addNewCategory(productCategory);
		if (status > 0) {
			model.addAttribute("message", message);
			return "redirect:/admin";
		} else {
			model.addAttribute("error", error);
			return "redirect:/admin";
		}
	}
	
	@RequestMapping(value = "admin/delete-productCategory", method = RequestMethod.POST)
	public String deleteCategory(ProductCategory productCategory, Model model, @RequestParam int id) {
		String message = "Delete successfully";
		String error = "Delete failed!";
		
		int status = productDao.deleteCategory(id);
		if (status > 0) {
			model.addAttribute("message", message);
			return "redirect:/admin";
		} else {
			model.addAttribute("error", error);
			return "redirect:/admin";
		}
	}

}
