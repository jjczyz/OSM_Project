package osmpackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PatientForm extends JPanel implements ActionListener {
	
	private static PatientForm patForm;
	private static final long serialVersionUID = 1L;
	private JButton saveButton, cancelButton;
	private static JTextField nameField;
	private JTextField surnameField;
	private JTextField peselField;
	private JLabel nameLabel, surnameLabel, peselLabel, sexLabel, insuranceLabel;
	private JRadioButton maleButton, femaleButton;
	private ButtonGroup sexButtons;
	private JComboBox<?> insuranceBox;
	private String[] insuranceStrings = {"NFZ","Prywatnie","Brak"};
	   
	PatientForm()
	{
		saveButton = new JButton("Zapisz");
		saveButton.addActionListener( this);
		cancelButton = new JButton("Anuluj");
		cancelButton.addActionListener( this);
		
          
        nameField = new JTextField("(imiê)");
        surnameField = new JTextField("(nazwisko)");
        peselField = new JTextField("(PESEL)");

        nameLabel = new JLabel("Imiê:");
        surnameLabel = new JLabel("Nazwisko:");
        peselLabel = new JLabel("PESEL:");
        sexLabel = new JLabel("P³eæ:");
        insuranceLabel = new JLabel("Ubezpieczenie:");
       
        
        femaleButton = new JRadioButton("kobieta");
        femaleButton.setActionCommand("K");

        maleButton = new JRadioButton("mê¿czyzna");
        maleButton.setActionCommand("M");
        sexButtons = new ButtonGroup();
        sexButtons.add(femaleButton);
        sexButtons.add(maleButton);
        femaleButton.setSelected(true);

        insuranceBox = new JComboBox<Object>(insuranceStrings);
       
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
        add(femaleButton, c);
        c.gridx = 2;
        c.gridy = 3;
        add(maleButton, c);
        c.gridx = 0;
        c.gridy = 4;
        add(insuranceLabel, c);
        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 2;
        add(insuranceBox, c);
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 1;
        add(saveButton, c);
        c.gridx = 1;
        c.gridy = 5;
        add(cancelButton, c);
       
        setBorder(BorderFactory.createTitledBorder("Dane pacjenta"));
        setPanelEnabled(this, false);
    
	}
	
	public void setFields(Patient patient)
	{
		nameField.setText(patient.getPatientName());
		surnameField.setText(patient.getPatientSurname());
		peselField.setText(patient.getPatientPESEL());
		
		String sex = patient.getPatientSex();
		if (sex.equals("M")) maleButton.setSelected(true);
		else femaleButton.setSelected(true);
		
		String insurance = patient.getPatientInsurance();
		if (insurance.equals("NFZ"))insuranceBox.setSelectedIndex(0);
		if (insurance.equals("Prywatnie"))insuranceBox.setSelectedIndex(1);
		if (insurance.equals("Brak"))insuranceBox.setSelectedIndex(2);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == saveButton)
		{
			if(isAlpha(nameField.getText(), "imiê") && isAlpha(surnameField.getText(), "nazwisko"))
			{
				String name = nameField.getText();			
				String surname = surnameField.getText();
				String sex = sexButtons.getSelection().getActionCommand();
				String insurance = (String)insuranceBox.getSelectedItem();
				if(checkPesel(peselField.getText())) 
				{
					String pesel = peselField.getText();
					PatientList patientList = PatientList.getInstance();
					patientList.addPatient(name, surname, pesel, sex, insurance);
					
					nameField.setText("");
					surnameField.setText("");
					peselField.setText("");
					femaleButton.setSelected(true);
					insuranceBox.setSelectedIndex(0); 
					setPanelEnabled(this,false);
				}
				
			}
			
		}
		if (event.getSource() == cancelButton)
		{
			PatientList patientList = PatientList.getInstance();
			patientList.removeTableSelection();
			nameField.setText("");
			surnameField.setText("");
			peselField.setText("");
			femaleButton.setSelected(true);
			insuranceBox.setSelectedIndex(0); 
			setPanelEnabled(this,false);
		}
	}

	public boolean isAlpha(String string, String field) {
	    char[] chars = string.toCharArray();

	    for (char c : chars) {
	        if(!Character.isLetter(c) || chars.length == 0) {
	        	JOptionPane.showMessageDialog(null,"Proszê wpisaæ poprawne " + field);
	            return false;
	        }
	    }

	    return true;
	}
	
	public boolean checkPesel(String string) {
	 
	    char[] chars = string.toCharArray();
	    for (char c : chars) {
	        if(Character.isLetter(c) || chars.length == 0) {
	        	JOptionPane.showMessageDialog(null,"Proszê wpisaæ poprawny pesel");
	            return false;
	        }
	    }
	    if(chars.length != 11){
	    	JOptionPane.showMessageDialog(null,"Proszê wpisaæ poprawny pesel");
	    	return false;
	    }
	    return true;
	}

	void setPanelEnabled(JPanel panel, Boolean isEnabled) {
	    panel.setEnabled(isEnabled);

	    Component[] components = panel.getComponents();

	    for(int i = 0; i < components.length; i++) {
	        if(components[i].getClass().getName() == "javax.swing.JPanel") {
	            setPanelEnabled((JPanel) components[i], isEnabled);
	        }

	        components[i].setEnabled(isEnabled);
	    }
	}

	public static synchronized PatientForm getInstance( ) {
		if (patForm == null) patForm=new PatientForm();
	      return patForm;	      
	   }
}
