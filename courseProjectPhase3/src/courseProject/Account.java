package courseProject;
public abstract class Account {
	String accountNumber;
	final double serviceFee;
	final double interestRate;
	final double overdraftFee;
	double balance = 0;
	public enum TRANSACTION_TYPE {
		DEPOSIT,
		WITHDRAW,
		INTEREST;
		@Override
		public String toString() {
			switch (this) {
			case DEPOSIT:
				return "Deposit";
			case INTEREST:
				return "Interest";
			case WITHDRAW:
				return "Withdrawl";
			}
			return null;
		}
	}
	public String getAccountNumber() {
		return this.accountNumber;
	}
	public void applyInterest() {
		if (this.balance > 0) {
			this.balance = this.balance + (this.balance * this.interestRate);
		} else {
			System.out.println("Accounts with a negative or 0 balance cannot accrue interest.");
		}
	}
	public Account(String accountNumber, double serviceFee, double interestRate, double overdraftFee) {
		this.accountNumber = accountNumber;
		this.serviceFee = serviceFee;
		this.interestRate = interestRate;
		this.overdraftFee = overdraftFee;
	}
}