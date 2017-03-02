import java.util.ArrayList;

/**
 * @author Ankurp
 *
 */
public class Customer {

	private String firstName;
	private String lastName;
	private int customerId;
	private String dob;
	private String address;
	private String phoneNumber;
	private int pin;
	private ArrayList<Account> accounts ;
	
	public Customer(){
		// TODO Auto-generated constructor stub
		firstName = null;
		lastName = null;
		customerId = 0;
		dob = null;
		address = null;
		phoneNumber = null;
		pin = 0;
		accounts = new ArrayList<Account>();
	}


	public String toString(){
		return 
				this.firstName + "#" + 
				this.lastName + "#"+ 
				this.customerId+ "#" +
				this.dob + "#" +
				this.address + "#" + 
				this.phoneNumber + "#" + 
				this.pin+ "#" +
				this.getNumAccounts() + System.getProperty("line.separator") +
				this.printAccounts();
	}

	//Utility method to print the Account detail of each account.
	public String printAccounts(){
		String str = "";
		for(Account ac : accounts){
			str = str + ac.toString() + System.getProperty("line.separator");
		}
		str = str.trim();
		return str;
	}
		
	//****Utility methods for Account list **************//
		
	public int getNumAccounts(){
		return this.accounts.size();
	}
		
	public Account getAccount(int index){
		return this.accounts.get(index);
	}
		
	public void setAccount(int index, Account ac){
		this.accounts.add(index, ac);
	}
		
	public void addAccount(Account ac){
		this.accounts.add(ac);
	}
		
	public Account deleteAccount(int index){
		return this.accounts.remove(index);
	}
	
	//**************getter and setter *********************//

	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public int getCustomerId() {
		return customerId;
	}


	public String getDob() {
		return dob;
	}


	public String getAddress() {
		return address;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public int getPin() {
		return pin;
	}


	public ArrayList<Account> getAccounts() {
		return accounts;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public void setPin(int pin) {
		this.pin = pin;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}
}
