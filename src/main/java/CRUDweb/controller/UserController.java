package CRUDweb.controller;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import CRUDweb.Responses.Responses;
import CRUDweb.dao.UserDAO;
import CRUDweb.helpers.Helpers;
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
		String rfc = body.get("rfc");
		if (!Helpers.validateRfc(rfc)) {
			res.json(Responses.FailResponse("Invalid RFC"));
		}
		String name = body.get("name");
		if (!Helpers.validateName(name)) {
			res.json(Responses.FailResponse("Invalid Name"));
		}
		String city_id = body.get("city_id");
		String age = body.get("age");
		User newUser = new User(name, age, rfc, city_id);
		Boolean created = userDAO.createUser(newUser);
		if (created) {
			JSONObject data = new JSONObject(newUser);
			res.json(Responses.SuccessResponse(data));
			return;
		} 
		res.json(Responses.FailResponse());
		return;
	}
	
	public void update(Request req, Response res) {
		UserDaoInterface userDAO= new UserDAO();
		String rfc = req.getParam("rfc");
		if (!Helpers.validateRfc(rfc)) {
			res.json(Responses.FailResponse("Invalid RFC"));
			return;
		}
		Map<String, String> body = req.getBody();
		String name = body.get("name");
		if (!Helpers.validateName(name)) {
			res.json(Responses.FailResponse("Invalid Name"));
			return;
		}
		String city_id = body.get("city_id");
		String age = body.get("age");
		User newUser = new User(name, age, rfc, city_id);
		Boolean updated = userDAO.uptadeUserByRfc(newUser, rfc);
		if (updated) {
			JSONObject data = new JSONObject(newUser);
			res.json(Responses.SuccessResponse(data));
			return;
		} 
		res.json(Responses.FailResponse());
		return;
	}
	
	public void delete(Request req, Response res) {
		UserDaoInterface userDAO= new UserDAO();
		String rfc = req.getParam("rfc");
		if (!Helpers.validateRfc(rfc)) {
			res.json(Responses.FailResponse("Invalid RFC"));
			return;
		}
		Boolean deleted = userDAO.deleteUserByRfc(rfc);
		if (deleted) {
			res.json(Responses.SuccessResponse("User deleted!"));
			return;
		} 
		res.json(Responses.FailResponse());
		return;
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
		res.json(Responses.SuccessResponse(usersList));
	}

	public void getUserByRfc(Request req, Response res) {
		UserDaoInterface userDAO = new UserDAO();
		String rfc = req.getParam("rfc");
		User user = userDAO.getUserByRfc(rfc);
		if (user == null) res.json(Responses.FailResponse("User not found"));
		else {
			JSONObject userByRfc = new JSONObject()
			.put("city_id", user.getcity_id())
			.put("name", user.getname())
			.put("age", user.getAge())
			.put("rfc", user.getRfc());
			res.json(Responses.SuccessResponse(userByRfc));
		}
	}
}