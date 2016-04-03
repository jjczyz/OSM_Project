package osmpackage;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;
public class PatientExamination extends JPanel {
	
	    private JButton saveButton, cancelButton, examinationButton;
	    private JTextField systolicField, diastolicField, pulseField;
	    private JLabel dateLabel, systolicLabel, diastolicLabel, pulseLabel;
	    private JSpinner dateSpinner;
	    
	    
	PatientExamination()
	{
		saveButton = new JButton("Zapisz");
		cancelButton = new JButton("Anuluj");
		examinationButton = new JButton("Zbadaj");
		
          
        pulseField = new JTextField();
        systolicField = new JTextField();
        diastolicField = new JTextField();

        dateLabel = new JLabel("Data");
        pulseLabel = new JLabel("Têtno");
        systolicLabel = new JLabel("Ciœnienie skurczowe");
        diastolicLabel = new JLabel("Ciœnienie rozkurczowe");
        
        Date today = new Date();
        dateSpinner = new JSpinner(new SpinnerDateModel(today, null, null, Calendar.DAY_OF_MONTH));
        JSpinner.DateEditor dataEditor = new JSpinner.DateEditor(dateSpinner, "dd/MM/yy");
        dateSpinner.setEditor(dataEditor);

 
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
       // c.insets = new Insets(5,5,5,5);
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        add(dateLabel, c);
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 2;
        add(dateSpinner, c);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        add(pulseLabel, c);
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 2;
        add(pulseField, c);
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        add(systolicLabel, c);
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 2;
        add(systolicField, c);
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        add(diastolicLabel, c);
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 2;
        add(diastolicField, c);
        c.gridx = 0;
        c.gridy = 4;
        add(examinationButton, c);
        c.gridx = 0;
        c.gridy = 5;
        add(saveButton, c);
        c.gridx = 1;
        c.gridy = 5;
        add(cancelButton, c);

     
        setBorder(BorderFactory.createTitledBorder("Badanie"));
       
    
	}
	
	
	
}
