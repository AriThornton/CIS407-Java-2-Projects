package courseProject;
import java.util.ArrayList;
import java.util.List;
public class Account {
	String accountNumber;
	ACCOUNT_TYPE accountType;
	double serviceFee, interestRate, overdraftFee, balance = 0;
	public enum ACCOUNT_TYPE {
		CHK,
		SAV
	}
	public Account(String accountNumber, ACCOUNT_TYPE accountType) {
		if (0 < accountNumber.length() && accountNumber.length() <= 5) {
			this.accountNumber = accountNumber;
		} else {
			System.out.println("Invalid account number provided. Blank number assigned by default.");
			this.accountNumber = "";
		}
		this.accountType = accountType;
	}
	public String getAccountNumber() {
		return this.accountNumber;
	}
	public void setServiceFee(double serviceFee) {
		this.serviceFee = serviceFee;
	}
	public double getServiceFee() {
		return this.serviceFee;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public double getInterestRate() {
		return this.interestRate;
	}
	public void setOverdraftFee(double overdraftFee) {
		this.overdraftFee = overdraftFee;
	}
	public double getOverdraftFee() {
		return this.overdraftFee;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getBalance() {
		return this.balance;
	}
	public List<String> toStringList() {
		List<String> result = new ArrayList<String>();
		result.add(this.accountNumber);
		result.add(this.accountType.toString());
		result.add(String.valueOf(this.serviceFee));
		result.add(String.valueOf(this.interestRate));
		result.add(String.valueOf(this.overdraftFee));
		result.add(String.valueOf(this.balance));
		return result;
	}
}