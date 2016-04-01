package osmpackage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainWindow extends JFrame implements ActionListener {

	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem exitButton;
	private static final long serialVersionUID = 1L;
	public int defaulMainFrametWidth = 960, defaultMainFrameHeight = 720;
	
	public MainWindow()
	{
		/*
		 * setMenu
		 */
		this.setTitle("Rejestracja wyników badañ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(defaulMainFrametWidth, defaultMainFrameHeight);
		
		/*
		 * setFrame
		 */
		menuBar=new JMenuBar();
		this.setJMenuBar(menuBar);
		menu = new JMenu("Aplikacja");
		menuBar.add(menu);
		exitButton=new JMenuItem("Zamknij");
		exitButton.addActionListener( this);
		menu.add(exitButton);
		
		/*
		 * setGUI
		 */
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();	
		
		PatientForm patForm = new PatientForm();
		c.fill = GridBagConstraints.BOTH;		             
		c.weighty = 0.5;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		this.add(patForm, c);
		
		PatientExamination patExam = new PatientExamination();
		c.gridx = 0;
		c.gridy = 1;
		this.add(patExam, c);
		
		
		PatientList patList = new PatientList();		
		c.gridheight = 2;
     	c.gridx = 1;
		c.gridy = 0;
		this.add(patList, c);
		
	}
	
/*
	private void setGUI()
	{
	}
	private void setFrame()
	{
	}
	private void setMenu()
	{	 
	}
*/
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == exitButton)
		{
			System.exit(0);
		}

	}
	
	public static void main(String[] args)
	{
	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	            	MainWindow mainWindow = new MainWindow();
	                mainWindow.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    });
	}
}
