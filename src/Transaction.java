
public class Transaction {

	private TransactionType transactionType; 
	private String date;
	private Double amount;
	private String description;
			
	
	public Transaction() {
		// TODO Auto-generated constructor stub
		
		date = null;
		transactionType = null;
		amount = 0.0;
		description = null;
	}

	public String toString(){
		return 
				this.transactionType + "#" + 
				this.date + "#" + 
				this.amount +"#"+
				this.description;
	}
	
	
	//**************************Getter and Setters ******************************//

	public String getDate() {
		return date;
	}

	public Double getAmount() {
		return amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public void setDescription(String description) {
		this.description = description;
	} 

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
}	
