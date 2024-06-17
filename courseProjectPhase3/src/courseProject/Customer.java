package courseProject;
import java.util.ArrayList;
import java.util.List;
public class Customer {
	String customerID;
	String SSN;
	String lastName;
	String firstName;
	String street;
	String city;
	String state;
	String zip;
	String phone;
	String accountNumber;
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
	public List<String> toStringList() {
		List<String> result = new ArrayList<>();
		result.add(this.customerID);
		result.add(this.SSN);
		result.add(this.lastName);
		result.add(this.firstName);
		result.add(this.street);
		result.add(this.city);
		result.add(this.state);
		result.add(this.zip);
		result.add(this.phone);
		result.add(this.accountNumber);
		return result;
	}
	public String toString() {
		String result = this.customerID + "\t";
		result += this.SSN + "\t";
		result += this.lastName + "\t";
		result += this.firstName + "\t";
		result += this.street + "\t";
		result += this.city + "\t";
		result += this.state + "\t";
		result += this.zip + "\t";
		result += this.phone + "\t";
		result += this.accountNumber;
		return result;
	}
}