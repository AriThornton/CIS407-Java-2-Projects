package courseProject;
public class Customer {
	private String customerID;
	private String SSN;
	private String lastName;
	private String firstName;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String phone;
	private String accountNumber;
	Customer(String customerID, String SSN, String lastName, String firstName, String street, String city, String state, String zip, String phone) {
		this.customerID = customerID;
		this.SSN = SSN;
		this.lastName = lastName;
		this.firstName = firstName;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
	}
	public void setCustomerID(String id) {
		this.customerID = id;
	}
	public String getCustomerID() {
		return this.customerID;
	}
	public void setSSN(String ssn) {
		this.SSN = ssn;
	}
	public String getSSN() {
		return this.SSN;
	}
	public void setCustomerLastName(String name) {
		this.lastName = name;
	}
	public String getLastName() {
		return this.lastName;
	}
	public void setCustomerFirstName(String name) {
		this.firstName = name;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public void setCustomerStreet(String street) {
		this.street = street;
	}
	public String getStreet() {
		return this.street;
	}
	public void setCustomerCity(String city) {
		this.city = city;
	}
	public String getCity() {
		return this.city;
	}
	public void setCustomerState(String state) {
		this.state = state;
	}
	public String getState() {
		return this.state;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getZip() {
		return this.zip;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone() {
		return this.phone;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountNumber() {
		return this.accountNumber;
	}
}