package courseProject;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
public class BankAcctAppSupport {
	public static Customer newCustomer(Scanner userInput) {
		Customer customer = new Customer();
		while (true) {
			try {
				System.out.print("Enter Customer's ID: ");
				String customerID = userInput.nextLine();
				if (!DataEntry.validateStringLength(customerID, 5)) {
					throw new Exception("Error: Customer's ID must be 5 characters max and must not be blank.");
				}
				customer.setCustomerID(customerID);
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		while (true) {
			try {
				System.out.print("Enter Customer's SSN: ");
				String customerSSN = userInput.nextLine();
				if (!DataEntry.validateStringExactLength(customerSSN, 9) || !DataEntry.validateStringNumeric(customerSSN)) {
					throw new Exception("Error: Customer's SSN must be exactly 9 numbers and must not be blank.");
				}
				customer.setSSN(customerSSN);
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		while (true) {
			try {
				System.out.print("Enter Customer's Last Name: ");
				String customerLastName = userInput.nextLine();
				if (!DataEntry.validateStringLength(customerLastName, 20)) {
					throw new Exception("Error: Customer's Last Name must be 20 characters max and must not be blank.");
				}
				customer.setCustomerLastName(customerLastName);
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		while (true) {
			try {
				System.out.print("Enter Customer's First Name: ");
				String customerFirstName = userInput.nextLine();
				if (!DataEntry.validateStringLength(customerFirstName, 15)) {
					throw new Exception("Error: Customer's First Name must be 15 characters max and must not be blank.");
				}
				customer.setCustomerFirstName(customerFirstName);
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		while (true) {
			try {
				System.out.print("Enter Customer's Street Name: ");
				String customerStreet = userInput.nextLine();
				if (!DataEntry.validateStringLength(customerStreet, 20)) {
					throw new Exception("Error: Customer's Street Name must be 20 characters max and must not be blank.");
				}
				customer.setCustomerStreet(customerStreet);
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		while (true) {
			try {
				System.out.print("Enter Customer's City Name: ");
				String customerCity = userInput.nextLine();
				if (!DataEntry.validateStringLength(customerCity, 20)) {
					throw new Exception("Error: Customer's City Name must be 20 characters max and must not be blank.");
				}
				customer.setCustomerCity(customerCity);
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		while (true) {
			try {
				System.out.print("Enter Customer's State: ");
				String customerState = userInput.nextLine();
				if (!DataEntry.validateStringExactLength(customerState, 2)) {
					throw new Exception("Error: Customer's State must be exactly 2 characters and must not be blank.");
				}
				customer.setCustomerState(customerState);
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		while (true) {
			try {
				System.out.print("Enter Customer's Zip Code: ");
				String customerZip = userInput.nextLine();
				if (!DataEntry.validateStringExactLength(customerZip, 5) || !DataEntry.validateStringNumeric(customerZip)) {
					throw new Exception("Error: Customer's Zip Code must be exactly 5 numbers and must not be blank.");
				}
				customer.setZip(customerZip);
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		while (true) {
			try {
				System.out.print("Enter Customer's Phone Number: ");
				String customerPhone = userInput.nextLine();
				if (!DataEntry.validateStringExactLength(customerPhone, 10) || !DataEntry.validateStringNumeric(customerPhone)) {
					throw new Exception("Error: Customer's Phone Number must be exactly 10 numbers and must not be blank.");
				}
				customer.setPhone(customerPhone);
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return customer;
	}
	public static final List<String> transactionHeader = new ArrayList<String>() {{
		add("Customer ID");
		add("Account Number");
		add("Account Type");
		add("Transaction Date");
		add("Transaction Type");
		add("Transaction Amount");
		add("Additional Fees");
		add("Balance");
	}};
	public static void printTransaction(List<String> accountInfo) {
		NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
		for (int i = 5; i < 8; i++) {
			accountInfo.set(i, formatter.format(Double.valueOf(accountInfo.get(i))));
		}
		List<List<String>> pivoted = new ArrayList<List<String>>();
		for (int col = 0; col < transactionHeader.size(); col++) {
			pivoted.add(new ArrayList<>());
			pivoted.get(col).add(transactionHeader.get(col));
			pivoted.get(col).add(accountInfo.get(col));
		}
		List<List<String>> tabbed = new ArrayList<>();
		for (int col = 0; col < pivoted.size(); col++) {
			tabbed.add(UltimateStringTabber.ultimateStringTabber(pivoted.get(col), true));
		}
		for (int col = 0; col < tabbed.size(); col++) {
			System.out.print(tabbed.get(col).get(0));
		}
		System.out.println();
		for (int col = 0; col < tabbed.size(); col++) {
			System.out.print(tabbed.get(col).get(1));
		}
		System.out.println();
	}
}