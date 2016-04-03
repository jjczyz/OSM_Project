package osmpackage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
public class PatientList extends JPanel {
	
	  private JButton addButton, deleteButton;
	  private JTable patientTable;
	  private JScrollPane scrollPane;
	  
	    
	PatientList()
	{
		addButton = new JButton("Dodaj");
		deleteButton = new JButton("Usuñ");
		
		String columnNames[] = { "Imiê i Nazwisko", "P³eæ", "Pesel", "Ubezpieczenie", "Badanie" };
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		patientTable = new JTable(tableModel);
		scrollPane = new JScrollPane(patientTable);
		
		
		//to pójdzie do jakiegoœ action listenera
		Patient patients = new Patient();
		for(int i = 0; i < patients.getPatientsSize(); i++)
		{
			Patient patient = patients.getPatient(i);
			String name = patient.getPatientName() + patient.getPatientSurname();
			String sex = patient.getPatientSex();
			String pesel = patient.getPatientPESEL();
			String insurance = patient.getPatientInsurance();
			String examination;
			if(patient.getPatientDiastolic()!=0 && patient.getPatientSystolic() != 0 && patient.getPatientPulse() != 0)
				{
				examination = "1";
				}
			else 
				{
				examination = "0";
				}
			Object data[] = {name, sex, pesel, insurance, examination};
			tableModel.addRow(data);
		}
		
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
       // c.insets = new Insets(5,5,5,5);
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 6;
        add(scrollPane, c);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        add(addButton, c);
        c.gridx = 1;
        c.gridy = 1;
        add(deleteButton, c);
   
        setBorder(BorderFactory.createTitledBorder("Lista pacjentów"));
       
    
	}
	
	
	
}
