package osmpackage;

import javax.swing.*;
import java.awt.*;
public class PatientExamination extends JPanel {
	
	  private JButton saveButton, cancelButton;
	    private JTextField nameField, surnameField, peselField;
	    private JLabel nameLabel, surnameLabel, peselLabel, sexLabel, insuranceLabel;
	    private JRadioButton male, female;
	    private JComboBox insuranceBox;
	    private String[] insuranceStrings = {"NFZ", "Prywatnie", "Brak"};
	    
	PatientExamination()
	{
		saveButton = new JButton();
		cancelButton = new JButton();
		
          
        nameField = new JTextField("(imiê)");
        surnameField = new JTextField("(nazwisko)");
        peselField = new JTextField("(PESEL)");

        nameLabel = new JLabel("Imiê:");
        surnameLabel = new JLabel("Nazwisko:");
        peselLabel = new JLabel("PESEL:");
        sexLabel = new JLabel("P³eæ:");
        insuranceLabel = new JLabel("Ubezpieczenie:");
       
        
        female = new JRadioButton("kobieta");
        male = new JRadioButton("mê¿czyzna");

        insuranceBox = new JComboBox(insuranceStrings);
       
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
       // c.insets = new Insets(5,5,5,5);
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        add(nameLabel, c);
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 2;
        add(nameField, c);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        add(surnameLabel, c);
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 2;
        add(surnameField, c);
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        add(peselLabel, c);
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 2;
        add(peselField, c);
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        add(sexLabel, c);
        c.gridx = 1;
        c.gridy = 3;
        add(female, c);
        c.gridx = 2;
        c.gridy = 3;
        add(male, c);
        c.gridx = 0;
        c.gridy = 4;
        add(insuranceLabel, c);
        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 2;
        add(insuranceBox, c);
        c.gridx = 1;
        c.gridy = 5;
        c.gridwidth = 1;
        add(saveButton, c);
        c.gridx = 2;
        c.gridy = 5;
        add(cancelButton, c);
       
        setBorder(BorderFactory.createTitledBorder("Dane pacjenta"));
       
    
	}
	
	
	
}
