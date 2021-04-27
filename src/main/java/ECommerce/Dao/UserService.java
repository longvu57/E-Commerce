package ECommerce.Dao;

import java.util.List;

import ECommerce.Entity.User;

public interface UserService {
	public List<User> getAllUsers();
	public int lockUser(int id);
	public int unlockUser(int id);
	public User getByUser(String username);
	public User findByUser(String username);
	public int register(User user);	
}
