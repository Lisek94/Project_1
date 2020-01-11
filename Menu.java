package lis.damian.project;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Menu 
{
	public static int showMenu()
	{
		int input = 0;
		boolean isNotDigit = true;
		Scanner scan = new Scanner(System.in);
		
		
		System.out.println();
        System.out.println("****************************************");
        System.out.println("*                 MENU                 *");
        System.out.println("****************************************");
        System.out.println("1. Wypisz list� wszystkch pracownik�w");
        System.out.println("2. Dodaj nowego pracownika");
        System.out.println("3. Zapisz do pliku");
        System.out.println("4. Usu� pracownika");
        System.out.println("5. Edytuj dane pracownika");
        System.out.println("6. Dodatkowe funkcje");
        System.out.println("7. Dodatkowe funkcje dla plik�w tekstowych");
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
				System.out.println("To nie jest liczba, spr�buj jeszcze raz");		
				isNotDigit = true;
				scan.nextLine();
			}	        
        }        
        return input;       
	}
	
	public static Employee addEmployee()
	{
		Scanner scan = new Scanner(System.in);
		Employee employee = new Employee();
		
		System.out.println("Podaj imi�");
		employee.setName(scan.nextLine());
		
		System.out.println("Podaj Nazwisko");
		employee.setSurname(scan.nextLine());
		
		System.out.println("Wybierz p�e�");
		System.out.println("1.Kobieta" + "\n2.M�czyzna");
		if(scan.nextInt()==1) 
		{
			employee.setGender('K');
		}
			else
			{
				employee.setGender('M');
			}
		
		System.out.println("Wpisz numer dzia�u");
		employee.setDepartmentNumber(scan.nextInt());
		
		System.out.println("Wpisz miesi�czne wynagrodzenie");
		employee.setSalary(scan.nextFloat());
		
		System.out.println("Wpisz wiek");
		employee.setAge(scan.nextInt());
		
		System.out.println("Wpisz liczb� dzieci");
		employee.setNumberOfChildren(scan.nextInt());
		
		System.out.println("Wybierz stan cywilny");
		System.out.println("1.M�atka/�onaty" + "\n2.Panna/Kawaler");
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
