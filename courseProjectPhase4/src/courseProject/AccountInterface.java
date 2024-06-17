package courseProject;
import java.time.LocalDate;
import java.util.List;
import courseProject.Account.TRANSACTION_TYPE;
public interface AccountInterface {
	List<String> prepForPrint();
	void performTransaction(TRANSACTION_TYPE type, double amnt, LocalDate date) throws Exception;
	void withdraw() throws Exception;
	void deposit();
	void applyInterest() throws Exception;
	double balance();
	double transactionFee();
}