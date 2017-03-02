import java.util.ArrayList;

public class Account {

	private AccountType accountType;
	private String accountNumber;
	private Double balance;
	private ArrayList<Transaction> transactions ;
	
	public Account() {
		// TODO Auto-generated constructor stub
		accountType = null;
		accountNumber = null;
		balance = 0.0;
		transactions = new ArrayList<Transaction>();
	}

	@Override
	public String toString(){
		return 
				this.accountType +"#" + 
				this.accountNumber + "#" + 
				this.balance + "#" + 
				this.getNumTransactions() + System.getProperty("line.separator") +
				this.printTransactions();
				
	}
		
	//Utility method to print the transaction detail of each account.
	
	public String printTransactions(){
		String str = "";
		for(int i=0; i<transactions.size();i++){
			str = str + transactions.get(i).toString() + System.getProperty("line.separator");
		}
		
		str = str.trim();
		return str;
	}
	
	//****Utility methods for transaction list **************//
	
	public int getNumTransactions(){
		return this.transactions.size();
	}
	
	public Transaction getTransaction(int index){
		return this.transactions.get(index);
	}
	
	public void setTransaction(int index, Transaction tc){
		if(tc.getTransactionType() == TransactionType.credit){
			this.balance =  this.balance + tc.getAmount();
		}else if(tc.getTransactionType() == TransactionType.debit){
			this.balance -= tc.getAmount();
		}
		this.transactions.add(index, tc);
	}
	
	public void addTransaction(Transaction tc){
		if(tc.getTransactionType() == TransactionType.credit){
			this.balance =  this.balance + tc.getAmount();
		}else if(tc.getTransactionType() == TransactionType.debit){
			this.balance -= tc.getAmount();
		}
		this.transactions.add(tc);
	}
	
	public Transaction deleteTransaction(int index){
		Transaction tc = this.transactions.remove(index);
		if(tc.getTransactionType() == TransactionType.credit){
			this.balance -= tc.getAmount();
		}else if(tc.getTransactionType() == TransactionType.debit){
			this.balance += tc.getAmount();
		}
		
		return tc;
	}
	
	//*************getter and setter ********************//

	public AccountType getAccountType() {
		return accountType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public Double getBalance() {
		return balance;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

}
