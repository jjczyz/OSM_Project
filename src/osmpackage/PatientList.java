package osmpackage;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PatientList extends JPanel implements ActionListener{
	
	private static PatientList patList;
	private static ArrayList<Patient> patients = new ArrayList<Patient>();   
	private JButton addButton, deleteButton;
	private JTable patientTable;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;
	private static int currentPatientId;

	public PatientList()
	{
		addButton = new JButton("Dodaj");
		addButton.addActionListener( this);
		deleteButton = new JButton("Usuñ");
		deleteButton.addActionListener(this);
		
		String columnNames[] = { "Imiê i Nazwisko", "P³eæ", "Pesel", "Ubezpieczenie", "Badanie" };
		tableModel = new DefaultTableModel(columnNames, 0);    
		patientTable = new JTable(tableModel);
		patientTable.setAutoCreateColumnsFromModel(true);
		scrollPane = new JScrollPane(patientTable);
		
		patientTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){


			public void valueChanged(ListSelectionEvent arg0) {
			
				currentPatientId = patientTable.getSelectedRow();
				System.out.println(currentPatientId);
				if(!(currentPatientId < 0))
				{
				PatientForm patForm = PatientForm.getInstance();
				Patient patient = patients.get(currentPatientId);		
				patForm.setPanelEnabled(patForm,true);
				patForm.setFields(patient);							
			}
			}
			
	
	    });
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
	
	public void  addPatient(String name, String surname, String pesel, String sex, String insurance)
	{	
		Patient pacjent = new Patient();
		if(currentPatientId != -1)
		{
			pacjent = patients.get(currentPatientId);
		}	
		pacjent.setPatientName(name);
		pacjent.setPatientSurname(surname);
		pacjent.setPatientPesel(pesel);
		pacjent.setPatientSex(sex);
		pacjent.setPatientInsurance(insurance);
		
		if(currentPatientId != -1)
		{
			patients.set(currentPatientId, pacjent);
		}
		else
		{			
			patients.add(pacjent);
		}
		refreshPatientsTable();
	}
	
	public void addPatientExamination(int pulse, int systolic, int diastolic)
	{
		Patient pacjent = new Patient();
		if(currentPatientId < patients.size() - 1)
		{
			pacjent = patients.get(currentPatientId);
		}
		pacjent.setPatientPulse(pulse);
		pacjent.setPatientSystolic(systolic);
		pacjent.setPatientDiastolic(diastolic);
		if(currentPatientId < patients.size() - 1)
		{
			patients.set(currentPatientId, pacjent);
		}
		else
		{			
			patients.add(pacjent);
		}
		refreshPatientsTable(); 
		
	}
	
	public void refreshPatientsTable() //to usuwa wszystkie rzêdy tablicy, a potem tworzy nowe, nie wiem jak to zrobiæ lepiej, ¿eby mia³o rêce i nogi :d
	{
		removeTableSelection();
		int rowCount = tableModel.getRowCount();
		for(int i = 0; i < rowCount; i++)
		{
			System.out.println("Usuwam rzad" + i);
			tableModel.removeRow(rowCount-1 - i);
		}
		for(int i = 0; i < patients.size(); i++)
		{
			Patient patient = patients.get(i);
			String name = patient.getPatientName() + " " + patient.getPatientSurname();
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
			Object dane[] = {name, sex, pesel, insurance, examination};
			tableModel.addRow(dane);
		}
	}
	
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == deleteButton)
		{			
			currentPatientId = -1;
			if(patients.size()>0) patients.remove(patientTable.getSelectedRow());
			patientTable.clearSelection();
			refreshPatientsTable();
		}
		if (event.getSource() == addButton)
		{
			PatientForm patForm = PatientForm.getInstance();
			patForm.setPanelEnabled(patForm,true);
			currentPatientId = -1;
			System.out.println(currentPatientId);
		}
	}
	public static synchronized PatientList getInstance( ) {
		if (patList == null) patList=new PatientList();
	      return patList;	      
	}
	
	public void removeTableSelection()
	{
		patientTable.clearSelection();
	}
	
}
	


