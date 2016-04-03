package osmpackage;

import java.util.ArrayList;

//class used to create Product objects
public class Patient 
{
	private static ArrayList<Patient> Patients = new ArrayList<Patient>();        
	private String patientName;
	private String patientSurname;
	private String patientPESEL;
	private String patientSex;
	private String patientInsurance;
	
	private int patientPulse;  //têtno
	private int patientSystolic; // ciœnienie skurczowe
	private int patientDiastolic; //ciœnienie rozkurczowe

	
	
	public ArrayList<Patient> getList()
	{
	    return Patients;
	}
	
	public void removePatient(int id)
	{
		Patients.remove(id);
	}
	public void addPatient(int id, String name, String surname, String pesel, String sex, String insurance)
	{
		Patient pacjent = new Patient();
		if(id < Patients.size() - 1)
		{
			pacjent = Patients.get(id);
		}	
		pacjent.patientName = name;
		pacjent.patientSurname = surname;
		pacjent.patientPESEL = pesel;
		pacjent.patientSex = sex;
		pacjent.patientInsurance = insurance;
		if(id < Patients.size() - 1)
		{
			Patients.set(id, pacjent);
		}
		else
		{			
			Patients.add(pacjent);
		}
		
	}
	
	public void addPatientExamination(int id, int pulse, int systolic, int diastolic)
	{
		Patient pacjent = new Patient();
		if(id < Patients.size() - 1)
		{
			pacjent = Patients.get(id);
		}
		pacjent.patientPulse = pulse;
		pacjent.patientSystolic = systolic;
		pacjent.patientDiastolic = diastolic;
		if(id < Patients.size() - 1)
		{
			Patients.set(id, pacjent);
		}
		else
		{			
			Patients.add(pacjent);
		}
	}
	
	public Patient getPatient(int id)
	{
		Patient pacjent = Patients.get(id);
		return pacjent;
	}
	public int getPatientsSize()
	{
		return Patients.size();
	}
	
	public String getPatientName( ){
		return patientName;}
	public String getPatientSurname( ){
		return patientSurname;}
	public String getPatientPESEL( ){
		return patientPESEL;}
	public String getPatientSex( ){
		return patientSex;}
	public String getPatientInsurance( ){
		return patientInsurance;}
	
	public int getPatientPulse(){
		return patientPulse;}
	public int getPatientSystolic(){
		return patientSystolic;}
	public int getPatientDiastolic(){
		return patientDiastolic;}

}
