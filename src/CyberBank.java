import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CyberBank {

	private String bankName;
	private String address;
	private String phoneNumber;
	private Double bankBalance;
	private ArrayList<Customer> customers;
	
	public CyberBank() {
		// TODO Auto-generated constructor stub
		bankName = null;
		address = null;
		phoneNumber = null;
		bankBalance = 0.0;
		customers = new ArrayList<Customer>();
	}

	public String toString(){
		return 
				this.bankName +"#" + 
				this.address + "#" + 
				this.phoneNumber + "#" +
				this.getNumCustomers() +System.getProperty("line.separator") +
				this.printcustomers();
				
	}
	
	//Utility method to print the Customer detail of each account.

	public String printcustomers(){
		String str = "";
		for(Customer cust : customers){
			str = str + cust.toString() + System.getProperty("line.separator");
		}
			
		str = str.trim();
		return str;
	}
		
	//****Utility methods for Customer list **************//

	public int getNumCustomers(){
		return this.customers.size();
	}
		
	public Customer getCustomer(int index){
		return this.customers.get(index);
	}
		
	public void setCustomer(int index, Customer tc){
		this.customers.add(index, tc);
	}
		
	public void addCustomer(Customer tc){
		this.customers.add(tc);
	}
		
	public Customer deleteCustomer(int index){
		return this.customers.remove(index);
	}

	//****Utility methods for Bank**********************//
	
	public Customer authenticateCustomer(int custId, int pin){
		Customer customer = null;
		for(Customer cust: customers){
			//Check to see if customer with given id exist.
			if(cust.getCustomerId() == custId){
				//if its pin matches then save the reference.
				if(cust.getPin()==pin){
					customer = cust;
					break; //No need to check further since we found our customer.
				}
			}
		}
		
		return customer;
	}
	
	//*********Load Bank Data from Input File**************//
	
	public void loadBankData(String inputFileName){
		BufferedReader br = null;
		String line = null;
		String[] parts = null;
		Account account = null;
		Customer customer = null;
		Transaction transaction = null;
		try {
			br = new BufferedReader(new FileReader(inputFileName));
			while((line=br.readLine())!=null){
			line = line.trim();
				parts = line.split("#");
				if(parts.length==8){
					//# of fields are 8 .. hence it is customer info
					customer = new Customer();
					customer.setFirstName(parts[0]);
					customer.setLastName(parts[1]);
					customer.setCustomerId(Integer.parseInt(parts[2]));
					customer.setDob(parts[3]);
					customer.setAddress(parts[4]);
					customer.setPhoneNumber(parts[5]);
					customer.setPin(Integer.parseInt(parts[6]));
					this.addCustomer(customer);
				}else if(parts.length==4){
					//# of fields is 4. hence, it can be account or transaction details.
					if(Character.isDigit(parts[3].charAt(0))){
						//Check if last value is integer then its account details. 
						account = new Account();
						account.setAccountType(AccountType.valueOf(parts[0]));
						account.setAccountNumber(parts[1]);
						account.setBalance(Double.parseDouble(parts[2]));
						customer.addAccount(account);
					}else{
						//else it is transaction details.
						transaction = new Transaction();
						transaction.setTransactionType(TransactionType.valueOf(parts[0]));
						transaction.setDate(parts[1]);
						transaction.setAmount(Double.parseDouble(parts[2]));
						transaction.setDescription(parts[3]);
						account.addTransaction(transaction);
					}
				}else if(parts.length==3){
					//# of fields are 3 . Hence, it is Bank details
					this.setBankName(parts[0]);
					this.setAddress(parts[1]);
					this.setPhoneNumber(parts[2]);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.print("File does not exist..error message is "+e);
		} catch (IOException ie) {
			// TODO Auto-generated catch block
			System.out.print("Encountered the IO Exception while reading the file contents"+ie);
		}
		
	}
	
	//*************Save Bank Data into File****************//

	public void saveBankData(String inputFileName){
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(inputFileName));
			bw.write(this.toString());
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//**********Getters and setters********************//

	public String getBankName() {
		return bankName;
 	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Double getBankBalance() {
		return bankBalance;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setBankBalance(Double bankBalance) {
		this.bankBalance = bankBalance;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}	
	
}
