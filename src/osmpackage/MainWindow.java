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

	
	public static void main(String[] args)
	{
		MainWindow mainWindow = new MainWindow();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Zamknij"))
		{
			System.exit(0);
		}

	}
	
}
