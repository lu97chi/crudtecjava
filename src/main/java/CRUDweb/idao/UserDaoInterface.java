package CRUDweb.idao;
 
import java.util.List;
 
import CRUDweb.model.User;
 
public interface UserDaoInterface {	
	public boolean createUser(User user);
	public List<User> getAllUsers();
	public boolean uptadeUserByRfc(User user, String rfc);
	public boolean deleteUserByRfc(String rfc);
	public User getUserByRfc(String rfc);
}