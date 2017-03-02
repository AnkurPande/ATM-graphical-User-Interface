import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;

import acm.gui.DoubleField;
import acm.gui.TableLayout;
import acm.program.Program;

public class ATMGUI extends Program {
	

	private static final long serialVersionUID = 1L;
	private static final int  BUTTON_SIZE = 100;
	private static final int  DISPLAY_SIZE = 200;
	String[] buttonString = {"WITHDRAW", "DEPOSIT", "TRANSFER", "BALANCE",
            				 "SAVE", "LOGOFF", "EXIT", "LOGON"};
	
	JButton[] button = null;
	JTextField displayInfix = null;
	DoubleField result = new DoubleField(0.0);
	JLabel left = new JLabel();	
	JLabel right = new JLabel();	
	public void initialize(){
		        	    
	    displayInfix.setText("0");
	}
	
	public void init(){
		setLayout(new TableLayout(1,2));
		left.setLayout(new TableLayout(4,1));
		right.setLayout(new TableLayout(3,1));
		setSize(500, 500);
		
		
		//Initialize UI elements.
		button = new JButton[20];
	    displayInfix = new JTextField("0");
		
		
		//Initialize variables and constants.
		initialize();
		
		//Set layout of elements.
		displayInfix.setHorizontalAlignment(JTextField.RIGHT);
	 
		
       	addLeftButtons();
       	addRightButtons();
       	addActionListeners();
       	add(left, "width=" + 150 + " height=" + 400);
       	add(right, "width=" + 150 + " height=" + 400);
	}
	
	public void addLeftButtons(){
		for(int i = 0; i<3;i++){
			button[i] = new JButton();
			button[i].setText(buttonString[i]);
			left.add(button[i], "width=" + BUTTON_SIZE + " height=" + 50);
		}
	}
	
	public void addRightButtons(){
		for(int i = 3; i<6;i++){
			button[i] = new JButton();
			button[i].setText(buttonString[i]);
			right.add(button[i], "width=" + BUTTON_SIZE + " height=" + 50);
		}
	}
	
	public void actionPerformed(ActionEvent ae){
		String buttonString = ae.getActionCommand();
		
		
	}
	
	
}

