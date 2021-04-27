package ECommerce.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ECommerce.Dao.ProductDao;
import ECommerce.Dao.UserDao;
import ECommerce.Entity.Product;
import ECommerce.Entity.ProductCategory;
import ECommerce.Entity.User;

@Controller
public class HomeController {
	@Autowired
	ProductDao productDao;

	@Autowired
	UserDao userDao;

	@RequestMapping(value = { "/", "/home" })
	public String home(Model model) {
		List<Product> products = new ArrayList<Product>();
		products = productDao.getAllProduct();

		List<ProductCategory> categories = new ArrayList<ProductCategory>();
		categories = productDao.getAllCategory();

		model.addAttribute("products", products);
		model.addAttribute("categories", categories);
		return "user/home";
	}

	@RequestMapping("/about")
	public String about(Model model) {
		return "user/about";
	}

	@RequestMapping("/product-detail")
	public String detail(@RequestParam int id, Model model) {
		Product product = new Product();
		product = productDao.getProductById(id);

		model.addAttribute("product", product);
		return "user/details";
	}

	@RequestMapping("/login")
	public String login(@RequestParam(value = "message", required = false) String message, Model model) {
		model.addAttribute("message", message);
		return "user/login";
	}

	@RequestMapping("/register")
	public String register(@RequestParam(value = "error", required = false) String error, Model model) {
		model.addAttribute("error", error);
		return "user/register";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/logout")
	public String logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			new SecurityContextLogoutHandler().logout(httpServletRequest, httpServletResponse, authentication);
		}
		return "redirect:/login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String postRegister(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("confirmPassword") String confirmPassword, @RequestParam("phone") String phone,
			@RequestParam("email") String email, Model model) {
		User existUser = userDao.findByUser(username);
		if (existUser != null || !password.equals(confirmPassword)) {
			String error = "Cannot sign up!";
			model.addAttribute("error", error);
			return "redirect:/register";
		} else {
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setPhone(phone);
			user.setEmail(email);
			user.setEnabled(1);
			user.setRole("ROLE_USER");
			userDao.register(user);
			String message = "Register successfully!";
			model.addAttribute("message", message);
			return "redirect:/login";
		}

	}

	@RequestMapping(value = "/sort-product")
	public String sort(@RequestParam(value = "price", required = false) String price,
			@RequestParam(value = "alphabet", required = false) String alphabet,
			@RequestParam(value = "category", required = false) String category, Model model) {
		List<Product> products = new ArrayList<Product>();
		List<ProductCategory> categories = new ArrayList<ProductCategory>();
		categories = productDao.getAllCategory();

		model.addAttribute("categories", categories);

		if (price != null) {
			products = productDao.sortByPrice(price);
			model.addAttribute("products", products);
			return "user/home";
		} else if (alphabet != null) {
			products = productDao.sortByAlphabet(alphabet);
			model.addAttribute("products", products);
			return "user/home";
		} else {
			products = productDao.sortByCategory(category);
			model.addAttribute("products", products);
			return "user/home";
		}

	}

}
