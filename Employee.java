package lis.damian.project;

public class Employee 

{
	private String name;
	private String surname;
	private char gender;
	private int departmentNumber;
	private float salary;
	private int age;
	private int numberOfChildren;
	private boolean isMarried;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public int getDepartmentNumber() {
		return departmentNumber;
	}
	public void setDepartmentNumber(int departmentNumber) {
		this.departmentNumber = departmentNumber;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getNumberOfChildren() {
		return numberOfChildren;
	}
	public void setNumberOfChildren(int numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}
	public boolean isMarried() {
		return isMarried;
	}
	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}
	
	public String showAllPersonalData() 
	{
		
		return "Imi�: " + name + " \nNazwisko: " + surname + " \nP�e�: " + genderExtracted() + " \nNumer oddzia�u: "
				+ departmentNumber + " \nWynarodzenie: " + salary+ " z�" + " \nWiek: " + age + " \nLiczba dzieci: " + numberOfChildren
				+ " \nStan Cywilny: " + isMarriedExtracted();
	}
	
	private String isMarriedExtracted() {
		String isMarried = "";
		if(this.isMarried == true)
		{
			isMarried = "�onaty";
		}
		else
		{
			isMarried = "Kawaler";
		}
		return isMarried;
	}
	
	private String genderExtracted() {
		String gender;
		if(this.gender=='K')
		{
			gender = "Kobieta";
		}
		else
		{
			gender = "M�czyzna";
		}
		return gender;
	}	
	
	public String showBasicPersonalData()
	{
	return "Imi�: " + name + " \nNazwisko: " + surname + "\nWynarodzenie: " + salary+ " z�";
	}
	
	public String showNameAndSurname()
	{
		return "Imi�: " + name.toUpperCase() + "\nNazwisko: " + surname.toUpperCase();
	}
	
	public String toString()
	{
		return "Nazwisko: " + surname + "\nImi�: " + name +  "\nP�e�: " + genderExtracted() + " \nNumer oddzia�u: "
				+ departmentNumber + " \nWynarodzenie: " + salary+ " z�" + " \nWiek: " + age + " \nLiczba dzieci: " + numberOfChildren;
	}
	
}
