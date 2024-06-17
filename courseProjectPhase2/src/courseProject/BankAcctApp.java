package courseProject;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import courseProject.Account.ACCOUNT_TYPE;
public class BankAcctApp {
	public static void main(String[] args) {
		int TOTAL_ACCOUNTS = 0;
		List<Customer> allCustomers = new ArrayList<>();
		HashMap<String, Account> allAccounts = new HashMap<String, Account>();
		try (Scanner userInput = new Scanner(System.in)) {
			String userCont = "";
			do {
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
				Account customerAccount;
				while (true) {
					try {
						System.out.print("Enter account type: ");
						String accountTypeInput = userInput.nextLine();
						ACCOUNT_TYPE accountType;
						if (accountTypeInput.equals("CHK")) {
							accountType = ACCOUNT_TYPE.CHK;
						} else if (accountTypeInput.equals("SAV")) {
							accountType = ACCOUNT_TYPE.SAV;
						} else {
							throw new Exception("Error: Account type must be exactly CHK or SAV.");
						}
						String accountNumber = String.valueOf(TOTAL_ACCOUNTS);
						TOTAL_ACCOUNTS += 1;
						customerAccount = new Account(accountNumber, accountType);
						customer.setAccountNumber(accountNumber);
						break;
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				while (true) {
					try {
						System.out.print("Enter account service fee: ");
						double serviceFee = Double.valueOf(userInput.nextLine());
						if (!DataEntry.validateDecimalRange(serviceFee, 0.0, 10.0)) {
							throw new Exception();
						}
						customerAccount.setServiceFee(serviceFee);
						break;
					} catch (Exception e) {
						System.out.println("Error: Service fee must be a number between 0 and 10.0.");
					}
				}
				while (true) {
					try {
						System.out.print("Enter account interest rate: ");
						double interestRate = Double.valueOf(userInput.nextLine());
						if (!DataEntry.validateDecimalRange(interestRate, 0.0, 10.0)) {
							throw new Exception();
						}
						customerAccount.setInterestRate(interestRate);
						break;
					} catch (Exception e) {
						System.out.println("Error: Interest rate must be a number between 0 and 10.0.");
					}
				}
				while (true) {
					try {
						System.out.print("Enter account overdraft fee: ");
						double overdraftFee = Double.valueOf(userInput.nextLine());
						customerAccount.setOverdraftFee(overdraftFee);
						break;
					} catch (Exception e) {
						System.out.println("Error: Overdraft fee must be a decimal value.");
					}
				}
				while (true) {
					try {
						System.out.print("Enter account balance: ");
						double balance = Double.valueOf(userInput.nextLine());
						customerAccount.setBalance(balance);
						break;
					} catch (Exception e) {
						System.out.println("Error: Balance must be a decimal value.");
					}
				}
				allCustomers.add(customer);
				allAccounts.put(customerAccount.getAccountNumber(), customerAccount);
				System.out.print("Add another customer and account (y/n)? ");
				userCont = userInput.nextLine();
			} while (userCont.equals("y"));
			List<String> customerHeaderRow = new ArrayList<>() {{
				add("Customer ID");
				add("SSN");
				add("Last Name");
				add("First Name");
				add("Street");
				add("City");
				add("State");
				add("Zip Code");
				add("Phone Number");
				add("Account Number");
			}};
			List<String> accountHeaderRow = new ArrayList<>() {{
				add("Account Number");
				add("Account Type");
				add("Service Fee");
				add("Interest Rate");
				add("Overdraft Fee");
				add("Balance");
			}};
			List<List<String>> customerData = new ArrayList<>();
			for (int i = 0; i < allCustomers.size(); i++) {
				customerData.add(allCustomers.get(i).toStringList());
			}
			List<List<String>> accountData = new ArrayList<>();
			for (String accountNum : allAccounts.keySet()) {
				accountData.add(allAccounts.get(accountNum).toStringList());
			}
			List<List<String>> customerPivot = new ArrayList<>();
			for (int col = 0; col < customerHeaderRow.size(); col++) {
				customerPivot.add(new ArrayList<>());
				customerPivot.get(col).add(customerHeaderRow.get(col));
				for (int row = 0; row < allCustomers.size(); row++) {
					customerPivot.get(col).add(customerData.get(row).get(col));
				}
			}
			List<List<String>> accountPivot = new ArrayList<>();
			for (int col = 0; col < accountHeaderRow.size(); col++) {
				accountPivot.add(new ArrayList<>());
				accountPivot.get(col).add(accountHeaderRow.get(col));
				for (int row = 0; row < allAccounts.size(); row++) {
					accountPivot.get(col).add(accountData.get(row).get(col));
				}
			}
			for (int row = 0; row < allCustomers.size()+1; row++) {
				for (int col = 0; col < customerHeaderRow.size(); col++) {
					System.out.print(customerPivot.get(col).get(row));
				}
				System.out.print("\n");
			}
			System.out.println();
			for (int row = 0; row < allAccounts.size()+1; row++) {
				for (int col = 0; col < accountHeaderRow.size(); col++) {
					System.out.print(accountPivot.get(col).get(row));
				}
				System.out.print("\n");
			}
			System.out.println();
		}
	}
}