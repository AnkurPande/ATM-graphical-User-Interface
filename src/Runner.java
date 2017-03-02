import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Runner {

	void testData(){
		Transaction tc1 = new Transaction();
		tc1.setDate("2017/02/23");
		tc1.setTransactionType(TransactionType.credit);
		tc1.setAmount(100.0);
		tc1.setDescription("Credited 100$");
		
		Transaction tc2 = new Transaction();
		tc2.setDate("2017/02/23");
		tc2.setTransactionType(TransactionType.debit);
		tc2.setAmount(50.0);
		tc2.setDescription("debited 50$");
		
		Transaction tc3 = new Transaction();
		tc3.setDate("2017/02/23");
		tc3.setTransactionType(TransactionType.credit);
		tc3.setAmount(100.0);
		tc3.setDescription("Credited 100$");
		
		Transaction tc4 = new Transaction();
		tc4.setDate("2017/02/23");
		tc4.setTransactionType(TransactionType.credit);
		tc4.setAmount(45.0);
		tc4.setDescription("debited 45$");
		
		Transaction tc5 = new Transaction();
		tc5.setDate("2017/02/23");
		tc5.setTransactionType(TransactionType.credit);
		tc5.setAmount(100.0);
		tc5.setDescription("Credited 100$");
		
		Transaction tc6 = new Transaction();
		tc6.setDate("2017/02/23");
		tc6.setTransactionType(TransactionType.credit);
		tc6.setAmount(100.0);
		tc6.setDescription("Credited 100$");
	
		Transaction tc7 = new Transaction();
		tc7.setDate("2017/02/23");
		tc7.setTransactionType(TransactionType.credit);
		tc7.setAmount(100.0);
		tc7.setDescription("Credited 100 $");
		
		Transaction tc8 = new Transaction();
		tc8.setDate("2017/02/23");
		tc8.setTransactionType(TransactionType.credit);
		tc8.setAmount(100.0);
		tc8.setDescription("Credited 100$");
		
		Account savings = new Account();
		savings.setAccountType(AccountType.savings);
		savings.setAccountNumber("10964914049");
		savings.addTransaction(tc1);
		savings.addTransaction(tc2);
		savings.addTransaction(tc3);
		savings.addTransaction(tc4);
					
		Account checkings = new Account();
		checkings.setAccountType(AccountType.checking);
		checkings.setAccountNumber("10964914048");
		checkings.addTransaction(tc5);
		checkings.addTransaction(tc6);
		checkings.addTransaction(tc7);
		checkings.addTransaction(tc8);
		
		Customer customer = new Customer();
		customer.setFirstName("Ankur");
		customer.setLastName("Pandey");
		customer.setDob("1988/07/01");
		customer.setPhoneNumber("514-512-7917");
		customer.setPin(3639);
		customer.setAddress("Montreal, Canada");
		customer.setCustomerId(01);
		customer.setAccount(0, savings);
		customer.setAccount(1,checkings);
		
		CyberBank bank = new CyberBank();
		bank.setBankName("Peoples Bank");
		bank.setAddress("Montreal");
		bank.setPhoneNumber("514-7917-512");
		bank.setCustomer(0, customer);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CyberBank bank = new CyberBank();
		bank.loadBankData("bigBankData.txt");
		System.out.println(bank.toString());
		bank.saveBankData("Output.txt");		
		
		JTextArea textArea = new JTextArea("Hello");
		JScrollPane scrollPane = new JScrollPane();
		textArea.setLineWrap(true);  
		textArea.setWrapStyleWord(true); 
		scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
		JOptionPane.showMessageDialog(null, scrollPane, "dialog test with textarea",  
		                                       JOptionPane.YES_NO_OPTION);
	}

}
