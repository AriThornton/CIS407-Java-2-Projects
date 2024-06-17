package courseProject;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import javax.swing.*;
import courseProject.Account.TRANSACTION_TYPE;
public class TransactionsGUI implements ActionListener {
	HashMap<String, Customer> allCustomers;
	HashMap<String, CheckingAccount> checkingAccounts;
	HashMap<String, SavingsAccount> savingsAccounts;
	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d/M/uuuu");
	JFrame frame;
	JTextField custIDField;
	String custID;
	String custName;
	String acctNum;
	String acctType;
	JLabel custInfoMessage;
	JRadioButton deposit;
	JRadioButton withdrawal;
	JRadioButton interest;
	JTextField transactionAmt;
	JTextField transactionDate;
	JLabel transactionMessage;
	TransactionsGUI(NewCustomerGUI newCustomerGUI) {
		this.allCustomers = newCustomerGUI.allCustomers;
		this.checkingAccounts = newCustomerGUI.checkingAccounts;
		this.savingsAccounts = newCustomerGUI.savingsAccounts;
		final Insets defaultInset = new Insets(5, 5, 5, 5);
		frame = new JFrame("Transactions");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(new GridBagLayout());
		JPanel customerInfoPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		JLabel title = new JLabel("Customer Information");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		c.insets = defaultInset;
		customerInfoPanel.add(title, c);
		JLabel custIDInput = new JLabel("Customer ID:");
		custIDInput.setHorizontalAlignment(SwingConstants.RIGHT);
		c.gridy = 1;
		c.gridwidth = 1;
		customerInfoPanel.add(custIDInput,c);
		custIDField = new JTextField(20);
		c.gridx = 1;
		customerInfoPanel.add(custIDField, c);
		JButton findCustomer = new JButton("Display Customer and Account Data");
		findCustomer.setActionCommand("display");
		findCustomer.addActionListener(this);
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 2;
		c.fill = GridBagConstraints.NONE;
		customerInfoPanel.add(findCustomer, c);
		custInfoMessage = new JLabel();
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 2;
		c.fill = GridBagConstraints.BOTH;
		customerInfoPanel.add(custInfoMessage, c);
		c.gridx = 0;
		c.gridy = GridBagConstraints.RELATIVE;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(0, 0, 0, 0);
		frame.add(customerInfoPanel, c);
		frame.add(new JSeparator(), c);
		JPanel transactions = new JPanel(new GridBagLayout());
		JPanel transactionType = new JPanel();
		deposit = new JRadioButton("Deposit");
		deposit.setSelected(true);
		withdrawal = new JRadioButton("Withdrawal");
		interest = new JRadioButton("Interest");
		ButtonGroup transactionTypeGroup = new ButtonGroup();
		transactionTypeGroup.add(deposit);
		transactionTypeGroup.add(withdrawal);
		transactionTypeGroup.add(interest);
		transactionType.add(deposit);
		transactionType.add(withdrawal);
		transactionType.add(interest);
		c.gridy = 0;
		c.gridwidth = 2;
		c.insets = defaultInset;
		transactions.add(transactionType, c);
		JLabel transactionAmtLabel = new JLabel("Amount:");
		transactionAmtLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		c.gridy = 1;
		c.gridwidth = 1;
		transactions.add(transactionAmtLabel, c);
		JLabel transactionDateLabel = new JLabel("Date:");
		transactionDateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		c.gridy = 2;
		transactions.add(transactionDateLabel, c);
		transactionAmt = new JTextField(20);
		c.gridx = 1;
		c.gridy = 1;
		transactions.add(transactionAmt, c);
		transactionDate = new JTextField(LocalDate.now().format(dateFormatter), 20);
		c.gridy = 2;
		transactions.add(transactionDate, c);
		JButton performTransaction = new JButton("Perform Transaction");
		performTransaction.setActionCommand("transaction");
		performTransaction.addActionListener(this);
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 2;
		c.fill = GridBagConstraints.NONE;
		transactions.add(performTransaction, c);
		transactionMessage = new JLabel();
		transactionMessage.setHorizontalAlignment(SwingConstants.CENTER);
		c.gridy = 4;
		c.fill = GridBagConstraints.BOTH;
		transactions.add(transactionMessage, c);
		c.gridx = 0;
		c.gridy = GridBagConstraints.RELATIVE;
		c.insets = new Insets(0, 0, 0, 0);
		frame.add(transactions, c);
		frame.pack();
		frame.setVisible(true);
	}
	public void displayCustomer() {
		if (!allCustomers.containsKey(custIDField.getText())) {
			custInfoMessage.setText(messageToHTML("Error: Could not find customer with ID " + custIDField.getText()));
			frame.pack();
			return;
		}
		custID = custIDField.getText();
		Customer customer = allCustomers.get(custID);
		custName = customer.getFirstName() + " " + customer.getLastName();
		acctNum = customer.getAccountNumber();
		if (savingsAccounts.containsKey(acctNum)) {
			acctType = "Savings";
		} else if (checkingAccounts.containsKey(acctNum)) {
			acctType = "Checking";
		} else {
			acctType = "Account not found";
		}
		makeCustomerTable();
	}
	public void makeCustomerTable() {
		String result = "<html><body><table border='1'>";
		result += "<tr><th>Customer ID</th><th>Customer Name</th><th>Account Number</th><th>Account Type</th></tr>";
		result += "<tr><td>" + custID + "</td>";
		result += "<td>" + custName + "</td>";
		result += "<td>" + acctNum + "</td>";
		result += "<td>" + acctType + "</td></tr>";
		result += "</table></body></html>";
		custInfoMessage.setText(result);
		frame.pack();
	}
	public void performTransaction() {
		if (!allCustomers.containsKey(custIDField.getText())) {
			transactionErrorStatus("Error: Please enter a valid customer ID above.");
			return;
		}
		custID = custIDField.getText();
		Customer customer = allCustomers.get(custID);
		Double amnt = 0.0;
		if (!interest.isSelected()) {
			try {
				amnt = Double.valueOf(transactionAmt.getText());
			} catch (Exception e) {
				transactionErrorStatus("Error: Please enter valid decimal for transaction amount");
				return;
			}
		}
		String dateInput = transactionDate.getText();
		if (!DataEntry.validateDate(dateInput)) {
			transactionErrorStatus("Error: Please enter valid date (M/D/YYYY or MM/DD/YYYY)");
			return;
		}
		LocalDate date = LocalDate.parse(dateInput, dateFormatter);
		AccountInterface account;
		String acctID = customer.getAccountNumber();
		if (checkingAccounts.containsKey(acctID)) {
			account = checkingAccounts.get(acctID);
		} else if (savingsAccounts.containsKey(acctID)) {
			account = savingsAccounts.get(acctID);
		} else {
			transactionErrorStatus("Error: Customer exists, but does not have an account!");
			return;
		}
		TRANSACTION_TYPE type;
		if (deposit.isSelected()) {
			type = TRANSACTION_TYPE.DEPOSIT;
		} else if (withdrawal.isSelected()) {
			type = TRANSACTION_TYPE.WITHDRAW;
		} else {
			type = TRANSACTION_TYPE.INTEREST;
		}
		try {
			account.performTransaction(type, amnt, date);
		} catch (Exception e) {
			transactionErrorStatus(e.getMessage());
			return;
		}
		List<String> accountInfo = account.prepForPrint();
		accountInfo.set(0, customer.getCustomerID());
		double fees = 0.0;
		switch (type) {
		case DEPOSIT, WITHDRAW:
			fees = account.transactionFee();
			break;
		case INTEREST:
			break;
		}
		accountInfo.set(6, String.valueOf(fees));
		displayTransaction(accountInfo);
	}
	static final List<String> transactionHeader = new ArrayList<String>() {{
		add("Customer ID");
		add("Account Number");
		add("Account Type");
		add("Transaction Date");
		add("Transaction Type");
		add("Transaction Amount");
		add("Additional Fees");
		add("Balance");
	}};
	public void displayTransaction(List<String> accountInfo) {
		NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
		for (int i = 5; i < 8; i++) {
			accountInfo.set(i, formatter.format(Double.valueOf(accountInfo.get(i))));
		}
		String result = "<html><body><table border='1'>";
		result += "<tr>";
		for (String item : transactionHeader) {
			result += "<th>" + item + "</th>";
		}
		result += "</tr><tr>";
		for (String item : accountInfo) {
			result += "<td>" + item + "</td>";
		}
		result += "</tr></table></body></html>";
		transactionMessage.setText(result);
		frame.pack();
	}
	public void transactionErrorStatus(String message) {
		transactionMessage.setText(messageToHTML(message));
		frame.pack();
	}
	public void actionPerformed(ActionEvent e) {
		if ("display".equals(e.getActionCommand())) {
			displayCustomer();
		} else if ("transaction".equals(e.getActionCommand())) {
			performTransaction();
		}
	}
	String messageToHTML(String content) {
		String part1 = "<html><body style='width:250px'><p style='text-align:center'>";
		String part2 = "</p></body></html>";
		String result = part1 + content + part2;
		return result;
	}
}