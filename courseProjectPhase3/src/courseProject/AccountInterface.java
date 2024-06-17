package courseProject;
import java.util.List;
import courseProject.Account.TRANSACTION_TYPE;
public interface AccountInterface {
	List<String> prepForPrint();
	void performTransaction(TRANSACTION_TYPE type, double amt) throws Exception;
	void withdraw() throws Exception;
	void deposit();
	void applyInterest();
	double balance();
	double transactionFee();
}