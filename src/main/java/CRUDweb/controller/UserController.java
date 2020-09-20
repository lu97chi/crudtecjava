package CRUDweb.controller;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import CRUDweb.dao.UserDAO;
import CRUDweb.idao.UserDaoInterface;
import CRUDweb.model.User;
import express.http.request.Request;
import express.http.response.Response;
import express.utils.Status;
 
public class UserController {
	
	
	public UserController() {
	}
	
	public void create(Request req, Response res) {
		UserDaoInterface userDAO = new UserDAO();
		Map<String, String> body = req.getBody();
		String name = body.get("name");
		String rfc = body.get("rfc");
		String city_id = body.get("city_id");
		String age = body.get("age");
		User newUser = new User(name, age, rfc, city_id);
		Boolean created = userDAO.createUser(newUser);
		if (created) {
			res.send("User Created!");
		} else {
			res.sendStatus(Status._500);
		}
	}
	
	public void update(Request req, Response res) {
		UserDaoInterface userDAO= new UserDAO();
		String rfc = req.getParam("rfc");
		Map<String, String> body = req.getBody();
		String name = body.get("name");
		String city_id = body.get("city_id");
		String age = body.get("age");
		User newUser = new User(name, age, rfc, city_id);
		userDAO.uptadeUserByRfc(newUser, rfc);
		res.send("User updated");
	}
	
	public void delete(Request req, Response res) {
		UserDaoInterface userDAO= new UserDAO();
		String rfc = req.getParam("rfc");
		userDAO.deleteUserByRfc(rfc);
		res.send("User Deleted!");
	}
	
	public void getAll(Request req, Response res){
		List<User> users = new ArrayList<User>();
		UserDaoInterface userDAO= new UserDAO();
		users=userDAO.getAllUsers();
		JSONArray usersList = new JSONArray();
		for (int i = 0; i < users.size(); i+=1) {
			JSONObject current = new JSONObject()
			.put("city_id", users.get(i).getcity_id())
			.put("name", users.get(i).getname())
			.put("age", users.get(i).getAge())
			.put("rfc", users.get(i).getRfc());
			usersList.put(current);
		}
		res.json(usersList);
	}

	public void getUserByRfc(Request req, Response res) {
		UserDaoInterface userDAO = new UserDAO();
		String rfc = req.getParam("rfc");
		User user = userDAO.getUserByRfc(rfc);
		if (user == null) res.send("No user found");
		else {
			JSONObject userByRfc = new JSONObject()
			.put("city_id", user.getcity_id())
			.put("name", user.getname())
			.put("age", user.getAge())
			.put("rfc", user.getRfc());
			res.json(userByRfc);	
		}
	}
}