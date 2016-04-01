package osmpackage;

import java.util.ArrayList;

//class used to create Product objects
public class Patient 
{
	private ArrayList<Patient> Patients = new ArrayList<Patient>();        
	private String patientName;
	private String patientSurname;
	private String patientPESEL;
	private String patientSex;
	private String patientInsurance;
	
	private short patientPulse;  //têtno
	private short patientSystolic; // ciœnienie skurczowe
	private short patientDiastolic; //ciœnienie rozkurczowe

	
	public void addPatient(short id, String name, String surname, String pesel, String sex, String insurance)
	{
		Patient pacjent = Patients.get(id-1);
		pacjent.patientName = name;
		pacjent.patientSurname = surname;
		pacjent.patientPESEL = pesel;
		pacjent.patientSex = sex;
		pacjent.patientInsurance = insurance;
	}
	
	public void addPatientExamination(short id, short pulse, short systolic, short diastolic)
	{
		Patient pacjent = Patients.get(id-1);
		pacjent.patientPulse = pulse;
		pacjent.patientSystolic = systolic;
		pacjent.patientDiastolic = diastolic;

	}
	
	public Patient getPatient(short id)
	{
		Patient pacjent = Patients.get(id-1);
		return pacjent;
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
	
	public short getPatientPulse(){
		return patientPulse;}
	public short getPatientSystolic(){
		return patientSystolic;}
	public short getPatientDiastolic(){
		return patientDiastolic;}

}
