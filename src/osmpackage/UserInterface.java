package osmpackage;



import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;


public class UserInterface extends JFrame
{	

/*	static ArrayList<Product> Products = new ArrayList<Product>();         // list holding products in store
	static ArrayList<Product> Receipt = new ArrayList<Product>();		   // list holding products on current shopping list
/*
	public static void main(String[] args) {
		createProductDatabase();
	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                UserInterface frame = new UserInterface();
	                frame.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    });
	}*/
	/*public UserInterface() 
	{	
		this.setTitle("Sales Terminal");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
  
		JTextField scannerInput = new JTextField();		//acts as input for the scanner
		scannerInput.setBounds(6, 20, 150, 30);
	    contentPane.add(scannerInput);
	    
	    JLabel scannerLabel = new JLabel("Scanner");	
	    scannerLabel.setBounds(12, 5, 98, 16);
	    contentPane.add(scannerLabel);
	       
	    JButton scannerRun = new JButton("Scan bar-code");		//acts as activation for the scanner
	    scannerRun.setBounds(20, 60, 120, 30);
	    contentPane.add(scannerRun);
	    
	    JButton exitButton = new JButton("Exit");		//finishes the sale displaying total sum to be paid and saves the receipt to a file
	    exitButton.setBounds(20, 100, 60, 30);
	    contentPane.add(exitButton);
	        	        
	    JTextPane LCDscreen = new JTextPane();		// acts as the LCD display, all single sales will be displayed on this TextPane
	    LCDscreen.setEditable(false);
	    LCDscreen.setBounds(160, 26, 220, 230);
	    contentPane.add(LCDscreen);
	    
	    JLabel LCDlabel = new JLabel("LCD display");	
	    LCDlabel.setBounds(160, 5, 98, 16);
	    contentPane.add(LCDlabel);
	    
	    scannerRun.addActionListener(new ActionListener()
	        {
	            @Override
	            public void actionPerformed(ActionEvent e) 
	            {         
	            	int itemID = scan(scannerInput.getText());
	            	String itemSale = makeSale(itemID);	            	
	            	LCDscreen.setText(itemSale); //displays the product name and it's price on LCD display
	            }
	        });	
	    exitButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {         
            	String totalSum = exit();	            	
            	LCDscreen.setText(totalSum);  //displays the sum to be paid on LCD display
            }
        });
	}
	
	//creates products for the database
	public static void createProductDatabase()
	{
		addProduct("Coca Cola 0.5l",3.99);
		addProduct("Coca Cola 1l",4.99);
		addProduct("Coca Cola 2l",5.99);
		addProduct("Chleb", 1.99);
		addProduct("Bulka maslana",1.49);
		addProduct("Maslo",2.49);
		addProduct("Margaryna",1.99);
		addProduct("Sok pomaranczowy 2l",3.49);
		addProduct("Pomarancza",0.49);
		addProduct("Banan",0.99);
	}
	
	//adds a product to Products ArrayList
	public static void addProduct(String n, double p)
	{
		Product item = new Product();
		item.setProductID(Products.size()+1);
		item.setProductName(n);
		item.setProductPrice(p);
		Products.add(item);
	}

 
	//checks input from the text field, it returns it if it's an integer, otherwise it returns 0
	 public static int scan(String msg)
	 {
		 	int y;
		 	if(isInteger(msg))
		 	{
		 		y = Integer.parseInt(msg);
		 		return y;	
		 	}
		 	else
		 	{
		 		y = 0;
		 		return y;
		 	}

	 }
	 
	 // if provided a valid itemID it puts the item in the Receipt ArrayList and returns a string with sold item productName and productPrice
	 // if itemID is not valid it returns a string containing an error message
	 // if there is no item with provided ID then it returns another error message
	 
	 public static String makeSale(int itemID)
	 {
		 	if(itemID > 0)
		 	{
		 		if (itemID > Products.size())
		 		{
		 			String sale = "Product not found";
		 			return sale;
		 			
		 		}
		 		else
		 		{
		 			Product item = Products.get(itemID - 1);		    
		 			double p = item.getProductPrice();
		 			String sale = item.getProductName() + " " + p + "zl";
		 			item.setProductID(Receipt.size()+1);
		 			Receipt.add(item);
		 			return  sale;
		 		}
		 	}
		 	else
		 	{
		 		String sale = "Invalid bar-code";
		 		return sale;
		 	}

	 }

	 //gets the total sum of productPrice of all items in the Receipt ArrayList and returns it in a string
	 //gives Printer a string containing all sold productName and productPrice and total price
	 public static String exit()
	 {
	 		double p = 0;
	 		String toPrint = "";
	 		for (int i = 0; i < Receipt.size(); i++)
	 		{
	 			Product item = Receipt.get(i);
	 			p += item.getProductPrice();
	 			
	 			toPrint += item.getProductName() + " " + item.getProductPrice() + "zl\r\n";
	 		};
	 		p = round(p, 2);
	 		toPrint += "\r\nSuma: " + p + "zl";
	 		try 
	 		{
				Printer(toPrint);   
			} catch (IOException e) 
	 		{
				e.printStackTrace();
			}			
	 		
	 		Receipt.clear();  // clears the receipt so next transactions can occur
	 		String sale = "Do zaplaty " + p + "zl";
	 		return sale;  // returns the total sum to be paid
	 }
	 
	 // acts as the printer
	 public static void Printer(String toPrint) throws IOException
	 {
			File fout = new File("Printer.txt");
			FileOutputStream fos = new FileOutputStream(fout);
		 
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		 
			bw.write(toPrint);
			bw.close();
	} 
	 
	// checks if string is an integer
	public static boolean isInteger(String s)
	{
		    try 
		    { 
		        Integer.parseInt(s); 
		    } 
		    catch(NumberFormatException e) 
		    { 
		        return false; 
		    } 
		    catch(NullPointerException e) 
		    {
		        return false;
		    }

		    return true;
	}
	
	
	// rounds the double
	public static double round(double value, int places) 
	{
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
*/	
}

