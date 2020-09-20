package CRUDweb.view;
 
import java.util.List;
 
import CRUDweb.model.User;
 
public class ViewUser {
	public void viewUser(User user) {
		System.out.println("Datos del User: "+user);
	}
	
	public void viewUsers(List<User> users) {
		for (User user : users) {
			System.out.println("Datos de los usuarios: "+user);
		}		
	}

}