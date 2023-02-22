package ConLib;



public class CustomerLib {
	int id;
	String Name;
	String Dob;
	String gender;
	String email;
	String Address;
	int Phone;
	public CustomerLib() {
		id = 0;
		Name = "";
		Dob = "";
		this.gender = "";
		this.email = "";
		Address = "";
		Phone = 0;

	}
	public CustomerLib(int Id, String name, String dob, String gender, String email, String address, int phone) {
		id = Id;
		Name = name;
		Dob = dob;
		this.gender = gender;
		this.email = email;
		Address = address;
		Phone = phone;

		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDob() {
		return Dob;
	}
	public void setDob(String dob) {
		Dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getPhone() {
		return Phone;
	}
	public void setPhone(int phone) {
		Phone = phone;
	}
	


		

}
