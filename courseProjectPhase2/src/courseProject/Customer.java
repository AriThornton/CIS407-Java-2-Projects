package courseProject;
import java.util.ArrayList;
import java.util.List;
public class Customer {
	String customerID;
	String SSN;
	String lastName;
	String firstName;
	String streetName;
	String cityName;
	String state;
	String zipCode;
	String phoneNumber;
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
	public String getCustomerLastName() {
		return this.lastName;
	}
	public void setCustomerFirstName(String name) {
		this.firstName = name;
	}
	public String getCustomerFirstName() {
		return this.firstName;
	}
	public void setCustomerStreet(String street) {
		this.streetName = street;
	}
	public String getCustomerStreet() {
		return this.streetName;
	}
	public void setCustomerCity(String city) {
		this.cityName = city;
	}
	public String getCustomerCity() {
		return this.cityName;
	}
	public void setCustomerState(String state) {
		this.state = state;
	}
	public String getCustomerState() {
		return this.state;
	}
	public void setZip(String zip) {
		this.zipCode = zip;
	}
	public String getZip() {
		return this.zipCode;
	}
	public void setPhone(String phone) {
		this.phoneNumber = phone;
	}
	public String getPhone() {
		return this.phoneNumber;
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
		result.add(this.streetName);
		result.add(this.cityName);
		result.add(this.state);
		result.add(this.zipCode);
		result.add(this.phoneNumber);
		result.add(this.accountNumber);
		return result;
	}
	public String toString() {
		String result = this.customerID + "\t";
		result += this.SSN + "\t";
		result += this.lastName + "\t";
		result += this.firstName + "\t";
		result += this.streetName + "\t";
		result += this.cityName + "\t";
		result += this.state + "\t";
		result += this.zipCode + "\t";
		result += this.phoneNumber + "\t";
		result += this.accountNumber;
		return result;
	}
}