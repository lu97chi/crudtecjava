package CRUDweb.model;
 
public class User {
	
	private String name;
	private String age;
	private String rfc;
	private String city_id;
	public User() {
	}
	
	public User(String name, String age, String city_id) {
		this.name = name;
		this.age = age;
		this.city_id = city_id;
	}

	public User(String name, String age, String rfc, String city_id) {
		this.name = name;
		this.age = age;
		this.rfc = rfc;
		this.city_id = city_id;
	}
 

	public String getname() {
		return name;
	}
 
	public void setname(String name) {
		this.name = name;
	}


	public String getAge() {
		return age;
	}
	
	public void setAge(String age) {
		this.age = age;
	}

	public String getRfc() {
		return rfc;
	}
	
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getcity_id() {
		return city_id;
	}
	
	public void setcity_id(String city_id) {
		this.city_id = city_id;
	}
}