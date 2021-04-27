package ECommerce.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ECommerce.Dao.UserDao;
import ECommerce.Entity.User;

@Controller
public class UserController {
	@Autowired
	UserDao userDao;

	@RequestMapping(value = { "/admin/user-management" }, method = RequestMethod.GET)
	public String user(Model model, @RequestParam(value = "message", required = false)String message, @RequestParam(value = "error", required = false)String error) {
		List<User> users = new ArrayList<User>();
		users = userDao.getAllUsers();
		model.addAttribute("users", users);
		model.addAttribute("message", message);
		model.addAttribute("error", error);
		return "admin/user-management";
	}

	@RequestMapping(value = { "/admin/lock-user" }, method = RequestMethod.POST)
	public String lockUser(@RequestParam int id, Model model) {
		String message = "Lock user successfully!";
		String error = "Cannot lock user!";
		int status = userDao.lockUser(id);
		if (status > 0) {
			model.addAttribute("message", message);
			return "redirect:/admin/user-management";
		} else {
			model.addAttribute("error", error);
			return "redirect:/admin/user-management";
		}
	}
	
	@RequestMapping(value = { "/admin/unlock-user" }, method = RequestMethod.POST)
	public String unlockUser(@RequestParam int id, Model model) {
		String message = "Unlock user successfully!";
		String error = "Cannot unlock user!";
		int status = userDao.unlockUser(id);
		if (status > 0) {
			model.addAttribute("message", message);
			return "redirect:/admin/user-management";
		} else {
			model.addAttribute("error", error);
			return "redirect:/admin/user-management";
		}
	}
}
