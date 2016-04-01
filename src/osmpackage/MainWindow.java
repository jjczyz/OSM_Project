package osmpackage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainWindow extends JFrame implements ActionListener {


	private static final long serialVersionUID = 1L;
	public int defaulMainFrametWidth = 960, defaultMainFrameHeight = 720;
	
	public MainWindow()
	{
		setGUI();
		setMenu();
		setFrame();
		
	}
	private void setGUI()
	{
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());
		this.getContentPane().add(mainPanel);

		JPanel patientForm, patientList, patientExamination; 
		patientForm = new JPanel();
		patientList = new JPanel();
		patientExamination= new JPanel();
		mainPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		//natural height, maximum width
		
		
		PatientForm patForm = new PatientForm();
		
		c.fill = GridBagConstraints.BOTH;		             
		c.weighty = 0.5;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		mainPanel.add(patForm, c);
		
		PatientExamination patExam = new PatientExamination();

		c.gridx = 0;
		c.gridy = 1;
		mainPanel.add(patExam, c);
		
		PatientList patList = new PatientList();
		
		c.gridheight = 2;
     	c.gridx = 1;
		c.gridy = 0;
		mainPanel.add(patList, c);
		
		 patientList.setBorder(BorderFactory.createTitledBorder("Lista Pacjentów"));
		// patientExamination.setBorder(BorderFactory.createTitledBorder("Badania"));
		// patientForm.setBorder(BorderFactory.createTitledBorder("Dane Pacjenta"));
		 
	

		
	}
	
	private void setFrame()
	{
		this.setTitle("Rejestracja wyników badañ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(defaulMainFrametWidth, defaultMainFrameHeight);
		this.setVisible(true);
	}
	
	private void setMenu()
	{
		 JMenuBar menuBar=new JMenuBar();
		 this.setJMenuBar(menuBar);
		 menuBar.setVisible(true);
		 JMenu menu=new JMenu("Aplikacja");
		 menuBar.add(menu);
		 JMenuItem menuItem=new JMenuItem("Zamknij");
		 menuItem.addActionListener( this);
		 menu.add(menuItem);
		 

		 
	}

	


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Zamknij"))
		{
			System.exit(0);
		}

	}
	
	public static void main(String[] args)
	{
		MainWindow mainWindow = new MainWindow();
		
		UserInterface inter = new UserInterface();
		
		inter.createProductDatabase();
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
	}
}
