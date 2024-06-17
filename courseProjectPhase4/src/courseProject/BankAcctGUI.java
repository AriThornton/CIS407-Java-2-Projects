package courseProject;
public class BankAcctGUI {
	public static void main(String[] args) {
		NewCustomerGUI newGUI = new NewCustomerGUI();
		TransactionsGUI secondGUI = new TransactionsGUI(newGUI);
	}
}