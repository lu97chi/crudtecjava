package CRUDweb.dao;
 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import CRUDweb.connection.DBConnection;
import CRUDweb.idao.UserDaoInterface;
import CRUDweb.model.User;
import CRUDweb.helpers.*;
 
public class UserDAO implements UserDaoInterface {	
	
	@Override
	public boolean createUser(User user) {
		boolean added = false;
		
		Statement statement= null;
		Connection conection =null;
		String[] fields = {"name", "age", "rfc", "city_id"};
		String[] values = {user.getname(), user.getAge(), user.getRfc(), user.getcity_id()};
		String sql = Helpers.insertStatement("Users", fields, values);

		try {			
			conection= DBConnection.connect();
			statement= conection.createStatement();
			statement.execute(sql);
			added=true;
			statement.close();
			conection.close();
		} catch (SQLException e) {
			System.out.println("Couldn't save new user");
			e.printStackTrace();
		}
		return added;
	}
 
	@Override
	public List<User> getAllUsers() {
		Connection conection =null;
		Statement statement= null;
		ResultSet rs=null;
		
		String sql= Helpers.getAllStatement("Users");
		
		List<User> users= new ArrayList<User>();
		
		try {			
			conection= DBConnection.connect();
			statement=conection.createStatement();
			rs=statement.executeQuery(sql);
			while (rs.next()) {
				User c=new User();
				// System.out.println(rs.getString(1));
				// System.out.println(rs.getString(2));
				// System.out.println(rs.getString(3));
				// System.out.println(rs.getString(4));
				c.setRfc(rs.getString(1));
				c.setname(rs.getString(2));
				c.setAge(rs.getString(3));
				c.setcity_id(rs.getString(4));
				// System.out.println(c.getname());
				// System.out.println(c.getAge());
				// System.out.println(c.getRfc());
				// System.out.println(c.getcity_id());
				users.add(c);
			}
			statement.close();
			rs.close();
			conection.close();
		} catch (SQLException e) {
			System.out.println("Couldn't get users list");
			e.printStackTrace();
		}
		return users;
	}
 
	@Override
	public boolean uptadeUserByRfc(User user, String rfc) {
		Connection conection= null;
		Statement statement= null;
		boolean updated=false;
		String[] fields = {"name", "age", "rfc", "city_id"};
		String[] values = {user.getname(), user.getAge(), user.getRfc(), user.getcity_id()};
		String sql = Helpers.updateByRfc("Users", fields, values, rfc, "rfc");		
		try {
			conection=DBConnection.connect();
			statement=conection.createStatement();
			statement.execute(sql);
			updated=true;
			statement.close();
			conection.close();
		} catch (SQLException e) {
			System.out.println("Couldn't update the user");
			e.printStackTrace();
		}		
		return updated;
	}
 
	@Override
	public boolean deleteUserByRfc(String rfc) {
		Connection conection = null;
		Statement statement = null;
		
		boolean deleted=false;
				
		String sql= Helpers.deleteByRfc("Users", rfc, "rfc");
		try {
			conection=DBConnection.connect();
			statement=conection.createStatement();
			statement.execute(sql);
			statement.close();
			conection.close();
		} catch (SQLException e) {
			System.out.println("Couldn't delete user");
			e.printStackTrace();
		}		
		System.out.println("Hello");
		return deleted;
	}

	@Override
	public User getUserByRfc(String rfc) {
		Connection conection = null;
		Statement statement = null;
		User user = null;
		ResultSet rs= null;
		String sql= Helpers.getByRfc("Users", rfc, "rfc");
		try {
			conection=DBConnection.connect();
			statement=conection.createStatement();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				User c = new User();
				c.setRfc(rs.getString(1));
				c.setname(rs.getString(2));
				c.setAge(rs.getString(3));
				c.setcity_id(rs.getString(4));
				user = c;
			}
			statement.close();
			rs.close();
			conection.close();
		} catch (SQLException e) {
			System.out.println("Couldn't get user");
			e.printStackTrace();
		}
		return user;
	}
 
}