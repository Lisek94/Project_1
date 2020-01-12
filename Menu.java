package lis.damian.project;

import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Menu 
{
	static Scanner scan = new Scanner(System.in);
	
	public static int showMenu()
	{
		int input = 0;
		boolean isNotDigit = true;
				
		System.out.println();
        System.out.println("****************************************");
        System.out.println("*                 MENU                 *");
        System.out.println("****************************************");
        System.out.println("1. Wypisz listê wszystkch pracowników");
        System.out.println("2. Dodaj nowego pracownika");
        System.out.println("3. Zapisz do pliku");
        System.out.println("4. Usuñ pracownika");
        System.out.println("5. Edytuj dane pracownika");
        System.out.println("6. Dodatkowe funkcje");
        System.out.println("7. Dodatkowe funkcje dla plików tekstowych");
        System.out.println("8. Informacja o programie");
        System.out.println("9. Zmiana nazwy dla pliku docelowego");
        System.out.println("0. Koniec");
               
        while(isNotDigit)
        {
	        try 
	        {
	        	input = scan.nextInt();
	        	isNotDigit = false;
			} catch (InputMismatchException e) {
				System.out.println("To nie jest liczba, spróbuj jeszcze raz");		
				isNotDigit = true;
				scan.nextLine();
			}	        
        }        
        return input;       
	}
	
	public static void switchCaseMenu() throws IOException 
	{
		int inputChoice = Menu.showMenu();
		LinkedList<Employee> list = new LinkedList<Employee>();
		String fileName = "baza.dat";	
		Scanner scan = new Scanner(System.in);
			
		while(inputChoice != 0)
		{
			switch (inputChoice) 
			{
			case 1:
				if(list.isEmpty())
				{
					System.out.println("Lista jest pusta!");
				}
				else 
				{
					showWorkersList(list);
				}			
				break;
			case 2:
				list.add(Menu.addEmployee());
				System.out.println("Pracownik dodany");
				break;
			case 3:
				saveToFile(list, fileName);
				break;
			case 4:
				showWorkersList(list);
				inputChoice = deleteEmployeeFromWorkersList(list, scan);
				break;	
			/*case 5:
				showWorkersWithAllInformation(list);
				System.out.println("Wybierz pracownika do edycji");
				inputChoice = scan.nextInt();
				break;*/
			case 8:
				Menu.infoAboutProgram();
				break;
			case 9:
				fileName = changeFileName();
				break;
			default:
				System.out.println("Nieprawid³owy wybór, spróbuj jeszcze raz");
			}
			System.out.println("\nWciœnij Enter, aby kontynuowaæ...");
			System.in.read();
			inputChoice = Menu.showMenu();
		}
		scan.close();
	}

	public static void showWorkersWithAllInformation(LinkedList<Employee> list) {
		for (int i = 0; i < list.size(); i++) 
		{
		System.out.println(i+1+".");
		System.out.println(list.get(i).showAllPersonalData());
		}
	}

	public static void saveToFile(LinkedList<Employee> list, String fileName) throws IOException {
		Employee saveLine;
		FileWriter saveToFile = new FileWriter(fileName);
		for (int i = 0; i < list.size(); i++) 
		{
		saveLine = list.get(i);			
		saveToFile.write(i+1+"\n"+saveLine+"\n");				
		}			
		saveToFile.close();
	}

	public static int deleteEmployeeFromWorkersList(LinkedList<Employee> list, Scanner scan) {
		int inputChoice;
		System.out.println("Wybierz numer pracownika do usuniêcia");					
		inputChoice = scan.nextInt();
		list.remove(inputChoice-1);
		return inputChoice;
	}

	public static void showWorkersList(LinkedList<Employee> list) 
	{
		for (int i = 0; i < list.size(); i++) 
		{
		System.out.println(i+1+".");
		System.out.println(list.get(i).showBasicPersonalData());
		}
	}

	public static String changeFileName() 
	{
		String fileName;
		System.out.println("Podaj now¹ nazwe pliku");	
		scan.nextLine();
		fileName = scan.nextLine()+".dat";
		System.out.println("Nazwa zmieniona");
		return fileName;
	}
	
	public static Employee addEmployee()
	{
		Employee employee = new Employee();
		
		System.out.println("Podaj imiê");
		scan.nextLine();
		employee.setName(scan.nextLine());
		
		System.out.println("Podaj Nazwisko");
		employee.setSurname(scan.nextLine());
		
		System.out.println("Wybierz p³eæ");
		System.out.println("1.Kobieta" + "\n2.Mê¿czyzna");
		if(scan.nextInt()==1) 
		{
			employee.setGender('K');
		}
		else
		{
			employee.setGender('M');
		}
		
		System.out.println("Wpisz numer dzia³u");
		employee.setDepartmentNumber(scan.nextInt());
		
		System.out.println("Wpisz miesiêczne wynagrodzenie");
		employee.setSalary(scan.nextFloat());
		
		System.out.println("Wpisz wiek");
		employee.setAge(scan.nextInt());
		
		System.out.println("Wpisz liczbê dzieci");
		employee.setNumberOfChildren(scan.nextInt());
		
		System.out.println("Wybierz stan cywilny");
		System.out.println("1.Mê¿atka/¯onaty" + "\n2.Panna/Kawaler");
		if(scan.nextInt()==1) 
		{
			employee.setMarried(true);;
		}
			else
			{
				employee.setMarried(false);
			}

		return employee;
	}
	
	public static void infoAboutProgram()
	{
		System.out.println("Wersja proramu 1.0");
	}
	
	
	
}
