package courseProject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class CheckingAccount extends Account implements AccountInterface {
	public LocalDate transactionDate;
	public TRANSACTION_TYPE transactionType;
	public double transactionAmount;
	public double transactionFee;
	public CheckingAccount(String accountNumber) {
		super(accountNumber, 0.5, 0.02, 30.0);
	}
	public void checkForOverdraft() {
		if (this.balance < 0) {
			this.balance -= this.overdraftFee;
			this.transactionFee += this.overdraftFee;
		}
	}
	@Override
	public List<String> prepForPrint() {
		List<String> result = new ArrayList<String>();
		result.add("temp/custID");
		result.add(this.accountNumber);
		result.add("Checking");
		result.add(this.transactionDate.toString());
		result.add(this.transactionType.toString());
		result.add(String.valueOf(this.transactionAmount));
		result.add("temp/fees");
		result.add(String.valueOf(this.balance()));
		return result;
	}
	@Override
	public void performTransaction(TRANSACTION_TYPE type, double amnt, LocalDate date) throws Exception {
		this.transactionDate = date;
		this.transactionType = type;
		this.transactionAmount = amnt;
		switch (type) {
		case DEPOSIT:
			this.deposit();
			break;
		case WITHDRAW:
			this.withdraw();
			break;
		case INTEREST:
			this.transactionAmount = this.balance * this.interestRate;
			this.applyInterest();
			break;
		}
	}
	@Override
	public void withdraw() {
		this.balance = this.balance - this.transactionAmount - this.serviceFee;
		this.transactionFee = this.serviceFee;
		this.checkForOverdraft();
	}
	@Override
	public void deposit() {
		this.balance = this.balance + this.transactionAmount - this.serviceFee;
		this.transactionFee = this.serviceFee;
	}
	@Override
	public double balance() {
		return this.balance;
	}
	@Override
	public double transactionFee() {
		return this.transactionFee;
	}
}