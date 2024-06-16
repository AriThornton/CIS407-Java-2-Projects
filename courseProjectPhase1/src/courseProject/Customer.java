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
	public void setLastName(String name) {
		this.lastName = name;
	}
	public String getLastName() {
		return this.lastName;
	}
	public void setFirstName(String name) {
		this.firstName = name;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public void setStreet(String street) {
		this.streetName = street;
	}
	public String getStreet() {
		return this.streetName;
	}
	public void setCity(String city) {
		this.cityName = city;
	}
	public String getCity() {
		return this.cityName;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getState() {
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
		result += this.phoneNumber;
		return result;
	}
}