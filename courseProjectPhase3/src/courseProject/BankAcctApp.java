package courseProject;
import java.util.Scanner;
import java.util.HashMap;
import java.util.List;
import courseProject.Account.TRANSACTION_TYPE;
public class BankAcctApp {
	public static void main(String[] args) {
		int TOTAL_ACCOUNTS = 0;
		HashMap<String, Customer> allCustomers = new HashMap<String,Customer>();
		HashMap<String, CheckingAccount> checkingAccounts = new HashMap<String, CheckingAccount>();
		HashMap<String, SavingsAccount> savingsAccounts = new HashMap<String, SavingsAccount>();
		try (Scanner userInput = new Scanner(System.in)) {
			String userCont = "";
			do {
				Customer customer = BankAcctAppSupport.newCustomer(userInput);
				while (true) {
					try {
						System.out.print("Enter new account type (CHK or SAV only): ");
						String accountTypeInput = userInput.nextLine();
						if (accountTypeInput.equalsIgnoreCase("CHK")) {
							CheckingAccount account = new CheckingAccount(String.valueOf(TOTAL_ACCOUNTS));
							customer.setAccountNumber(account.getAccountNumber());
							checkingAccounts.put(account.getAccountNumber(), account);
						} else if (accountTypeInput.equalsIgnoreCase("SAV")) {
							SavingsAccount account = new SavingsAccount(String.valueOf(TOTAL_ACCOUNTS));
							customer.setAccountNumber(account.accountNumber);
							savingsAccounts.put(account.getAccountNumber(), account);
						} else {
							throw new Exception("Error: Account type must be exactly CHK or SAV.");
						}
						TOTAL_ACCOUNTS += 1;
						break;
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				allCustomers.put(customer.getCustomerID(), customer);
				System.out.print("Add another customer and account (y/n)? ");
				userCont = userInput.nextLine();
			} while (userCont.equals("y"));
			System.out.println("\nBeginning transactions...\n");
			userCont = "";
			do {
				AccountInterface account;
				Customer customer;
				while (true) {
					try {
						System.out.print("Enter customer ID: ");
						String customerID = userInput.nextLine();
						if (allCustomers.containsKey(customerID)) {
							customer = allCustomers.get(customerID);
							String accountID = customer.getAccountNumber();
							if (checkingAccounts.containsKey(accountID)) {
								account = checkingAccounts.get(accountID);
							} else if (savingsAccounts.containsKey(accountID)) {
								account = savingsAccounts.get(accountID);
							} else {
								throw new Exception("Error: Customer with ID " + customerID + " does not have an account.");
							}
						} else {
							throw new Exception("Error: Account with ID " + customerID + " was not found.");
						}
						break;
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				transaction: while (true) {
					System.out.println("\nWorking on account number: " + customer.getAccountNumber());
					TRANSACTION_TYPE type = TRANSACTION_TYPE.DEPOSIT;
					double transactionAmount = 0;
					while (true) {
						try {
							System.out.print("Enter transaction type (DEPOSIT, WITHDRAW, INTEREST, QUIT only): ");
							String transactionTypeInput = userInput.nextLine();
							if (transactionTypeInput.equalsIgnoreCase("QUIT")) {
								break transaction;
							} else if (transactionTypeInput.equalsIgnoreCase("DEPOSIT")) {
								type = TRANSACTION_TYPE.DEPOSIT;
							} else if (transactionTypeInput.equalsIgnoreCase("WITHDRAW")) {
								type = TRANSACTION_TYPE.WITHDRAW;
							} else if (transactionTypeInput.equalsIgnoreCase("INTEREST")) {
								type = TRANSACTION_TYPE.INTEREST;
							} else {
								throw new Exception("Error: Transaction type must be DEP, WTH, INT, or QUIT only");
							}
							break;
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					}
					amount: while (true) {
						switch (type) {
						case INTEREST: break amount;
						}
						try {
							System.out.print("Enter transaction amount: ");
							transactionAmount = Double.valueOf(userInput.nextLine());
							break;
						} catch (Exception e) {
							System.out.println("Error: Input could not be cast to a double. Please input a decimal value.");
						}
					}
					try {
						account.performTransaction(type, transactionAmount);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					List<String> accountInfo = account.prepForPrint();
					accountInfo.set(0, customer.getCustomerID());
					double fees = 0;
					switch (type) {
					case DEPOSIT:
					case WITHDRAW:
						fees = account.transactionFee();
						break;
					case INTEREST:
						break;
					}
					accountInfo.set(6, String.valueOf(fees));
					BankAcctAppSupport.printTransaction(accountInfo);
				}
				System.out.print("Change account? ");
				userCont = userInput.nextLine();
			} while (userCont.equals("y"));
		}
		System.out.println("\nThanks for banking");
	}
}