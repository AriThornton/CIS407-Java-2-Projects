package courseProject;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class BankAcctApp {
	public static void main(String[] args) {
		try (Scanner userInput = new Scanner(System.in)) {
			List<Customer> allCustomers = new ArrayList<>();
			String userCont = "";
			do {
				Customer customer = new Customer();
				System.out.print("Enter Customer's ID: ");
				String customerID = userInput.nextLine();
				while (!DataEntry.validateStringLength(customerID, 5)) {
					System.out.println("Error: Customer's ID must be 5 characters max and must not be blank.");
					System.out.print("Enter Customer's ID: ");
					customerID = userInput.nextLine();
				}
				customer.setCustomerID(customerID);
				System.out.print("Enter Customer's SSN: ");
				String customerSSN = userInput.nextLine();
				while (!DataEntry.validateStringExactLength(customerSSN, 9) || !DataEntry.validateStringNumeric(customerSSN)) {
					System.out.println("Error: Customer's SSN must be exactly 9 numbers and must not be blank.");
					System.out.print("Enter Customer's SSN: ");
					customerSSN = userInput.nextLine();
				}
				customer.setSSN(customerSSN);
				System.out.print("Enter Customer's Last Name: ");
				String customerLastName = userInput.nextLine();
				while (!DataEntry.validateStringLength(customerLastName, 20)) {
					System.out.println("Error: Customer's Last Name must be 20 characters max and must not be blank.");
					System.out.print("Enter Customer's Last Name: ");
					customerLastName = userInput.nextLine();
				}
				customer.setLastName(customerLastName);
				System.out.print("Enter Customer's First Name: ");
				String customerFirstName = userInput.nextLine();
				while (!DataEntry.validateStringLength(customerFirstName, 15)) {
					System.out.println("Error: Customer's First Name must be 15 characters max and must not be blank.");
					System.out.print("Enter Customer's First Name: ");
					customerFirstName = userInput.nextLine();
				}
				customer.setFirstName(customerFirstName);
				System.out.print("Enter Customer's Street Name: ");
				String customerStreet = userInput.nextLine();
				while (!DataEntry.validateStringLength(customerStreet, 20)) {
					System.out.println("Error: Customer's Street Name must be 20 characters max and must not be blank.");
					System.out.print("Enter Customer's Street Name: ");
					customerStreet = userInput.nextLine();
				}
				customer.setStreet(customerStreet);
				System.out.print("Enter Customer's City Name: ");
				String customerCity = userInput.nextLine();
				while (!DataEntry.validateStringLength(customerCity, 20)) {
					System.out.println("Error: Customer's City Name must be 20 characters max and must not be blank.");
					System.out.print("Enter Customer's City Name: ");
					customerCity = userInput.nextLine();
				}
				customer.setCity(customerCity);
				System.out.print("Enter Customer's State: ");
				String customerState = userInput.nextLine();
				while (!DataEntry.validateStringExactLength(customerState, 2)) {
					System.out.println("Error: Customer's State must be exactly 2 characters and must not be blank.");
					System.out.print("Enter Customer's State: ");
					customerState = userInput.nextLine();
				}
				customer.setState(customerState);
				System.out.print("Enter Customer's Zip Code: ");
				String customerZip = userInput.nextLine();
				while (!DataEntry.validateStringExactLength(customerZip, 5) || !DataEntry.validateStringNumeric(customerZip)) {
					System.out.println("Error: Customer's Zip Code must be exactly 5 numbers and must not be blank.");
					System.out.print("Enter Customer's Zip Code: ");
					customerZip = userInput.nextLine();
				}
				customer.setZip(customerZip);
				System.out.print("Enter Customer's Phone Number: ");
				String customerPhone = userInput.nextLine();
				while (!DataEntry.validateStringExactLength(customerPhone, 10) || !DataEntry.validateStringNumeric(customerPhone)) {
					System.out.println("Error: Customer's Phone Number must be exactly 10 numbers and must not be blank.");
					System.out.print("Enter Customer's Phone Number: ");
					customerPhone = userInput.nextLine();
				}
				customer.setPhone(customerPhone);
				allCustomers.add(customer);
				System.out.print("Add another customer (y/n)? ");
				userCont = userInput.nextLine();
			} while (userCont.equals("y"));
			List<String> headerRow = new ArrayList<>() {{
				add("Customer ID");
				add("SSN");
				add("Last Name");
				add("First Name");
				add("Street");
				add("City");
				add("State");
				add("Zip Code");
				add("Phone Number");
			}};
			List<List<String>> customerData = new ArrayList<>();
			for (int i = 0; i < allCustomers.size(); i++) {
				customerData.add(allCustomers.get(i).toStringList());
			}
			List<List<String>> everything = new ArrayList<>();
			for (int col = 0; col < headerRow.size(); col++) {
				everything.add(new ArrayList<>());
				everything.get(col).add(headerRow.get(col));
				for (int row = 0; row < allCustomers.size(); row++) {
					everything.get(col).add(customerData.get(row).get(col));
				}
			}
			for (int row = 0; row < allCustomers.size()+1; row++) {
				for (int col = 0; col < headerRow.size(); col++) {
					System.out.print(everything.get(col).get(row));
				}
				System.out.print("\n");
			}
		}
	}
}