package lis.damian.project;

import java.io.IOException;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class ContextMenu 
{

	static Scanner scan = new Scanner(System.in);
	
	public static int contextMenuForNumberFive()
	{
		System.out.println("\nWybierz dane do edycji");
		
		int input = 0;
		boolean isNotDigit = true;
		
		 System.out.println("1. Nazwisko");
	     System.out.println("2. Numer departamentu");
	     System.out.println("3. Wynagrodzenie");
	     System.out.println("4. Wiek");
	     System.out.println("5. Liczba dzieci");
	     System.out.println("6. Stan cywilny");
	     System.out.println("0. Powr�t");
	   
	     while(isNotDigit)
	        {
		        try 
		        {
		        	input = scan.nextInt();
		        	isNotDigit = false;
				} catch (InputMismatchException e) 
		        {
					System.out.println("To nie jest liczba, spr�buj jeszcze raz");		
					isNotDigit = true;
					scan.nextLine();
				}	        
	        }        
	        return input;      
	}
	
	public static void switchCaseContextMenuFive(LinkedList<Employee> list, int inputGetList) throws IOException 
	{
		int input = contextMenuForNumberFive();		
			
		while(input != 0)
		{
			switch (input) 
			{
			case 1:
				changeSurname(list, inputGetList);					
				break;
			case 2:
				System.out.println("Podaj nowy numer dzia�u");
				int newdepartmentNumber = scan.nextInt();
				list.get(inputGetList-1).setDepartmentNumber(newdepartmentNumber);
				break;
			case 3:
				System.out.println("Podaj nowe wynagrodzenie");
				int newSalary = scan.nextInt();
				list.get(inputGetList-1).setSalary(newSalary);
				break;
			case 4:
				System.out.println("Podaj obecny wiek pracownika");
				int newAge = scan.nextInt();
				list.get(inputGetList-1).setAge(newAge);
				break;	
			case 5:
				System.out.println("Podaj liczb� dzieci");
				int newNumberOfChildren = scan.nextInt();
				list.get(inputGetList-1).setNumberOfChildren(newNumberOfChildren);
				break;
			case 6:
				System.out.println("Podaj stan cywilny");
				System.out.println("1.M�atka/�onaty" + "\n2.Panna/Kawaler");
				if(scan.nextInt()==1) 
				{
					list.get(inputGetList-1).setMarried(true);;
				}
				else
				{
					list.get(inputGetList-1).setMarried(false);
				}
				break;
			default:
				System.out.println("Nieprawid�owy wyb�r, spr�buj jeszcze raz");
			}
			System.out.println("\nWci�nij Enter, aby kontynuowa�...");
			System.in.read();
			input = contextMenuForNumberFive();
		}
		
	}

	public static void changeSurname(LinkedList<Employee> list, int inputGetList) 
	{
		
		if (list.get(inputGetList-1).getGender()=='K') 
		{
			System.out.println("Podaj nowe nazwisko");
			String newSurname = scan.nextLine();
			list.get(inputGetList-1).setSurname(newSurname);
		} 
		else 
		{
			System.out.println("Opcja dost�pna tylko dla kobiet");
		}
	}
	
	public static int contextMenuForNumberSix()
	{
		System.out.println("\nWybierz opcje");
		
		int input = 0;
		boolean isNotDigit = true;
		
		 System.out.println("1. Oblicz liczb� pracownik�w zarabiaj�cych powy�ej podanej kwoty");
	     System.out.println("2. Oblicz sredni� p�ace w dziale");
	     System.out.println("3. Wy�wietl najwi�ksze p�ace w�rod kobiet i m�czyzn");
	     System.out.println("4. Wy�wietl numery wszystkich dzia��w oraz dodatkowe informacje");
	     System.out.println("5. Wy�wietl stosunek �redniej p�acy kobiet do �redniej p�acy m�czyzn");
	     System.out.println("6. Zwi�ksz zarobki o 10% + premi� wszystkim pracownikom");
	     System.out.println("7. Zwi�ksz zarobki o podan� kwot� wszystkim pracownikom");
	     System.out.println("8. Posortuj pracownik�w wg. nazwiska");
	     System.out.println("9. Posortuj pracownik�w wg. zarobk�w");
	     System.out.println("0. Powr�t");
	   
	     while(isNotDigit)
	        {
		        try 
		        {
		        	input = scan.nextInt();
		        	isNotDigit = false;
				} catch (InputMismatchException e) 
		        {
					System.out.println("To nie jest liczba, spr�buj jeszcze raz");		
					isNotDigit = true;
					scan.nextLine();
				}	        
	        }        
	        return input;      
	}
	
	public static void switchCaseContextMenuSix(LinkedList<Employee> list) throws IOException 
	{
		int input = contextMenuForNumberSix();		
			
		while(input != 0)
		{
			switch (input) 
			{
			case 1:
				calculateTheNumberOfEmployeeForInputSalary(list);
				break;
			case 2:
				calculateAvarageSalaryForInput(list);
				break;
			case 3:
				showMaxSalary(list);
				break;
			case 4:
				System.out.println("Funkcja wkr�tce zostanie dodana");
				/*showAllDepartmentsNumbers(list);
				break;*/
			case 5:
				System.out.println("Funkcja wkr�tce zostanie dodana");
				break;
			case 6:
				System.out.println("Funkcja wkr�tce zostanie dodana");
				break;
			case 7:
				System.out.println("Funkcja wkr�tce zostanie dodana");
				break;	
			case 8:
				System.out.println("Funkcja wkr�tce zostanie dodana");
				break;
			case 9:
				System.out.println("Funkcja wkr�tce zostanie dodana");
				break;
			default:
				System.out.println("Nieprawid�owy wyb�r, spr�buj jeszcze raz");
			}
			System.out.println("\nWci�nij Enter, aby kontynuowa�...");
			System.in.read();
			input = contextMenuForNumberSix();
		}
		
	}

	public static void calculateTheNumberOfEmployeeForInputSalary(LinkedList<Employee> list) 
	{
		System.out.println("Podaj kwot�");
		int inputSalary = scan.nextInt();
		int counter = 0;
		for (int i = 0; i < list.size(); i++) 
		{
			float salary = list.get(i).getSalary();
			if (salary>=inputSalary) 
			{
				counter++;
			}
		}
		System.out.println("Liczba pracownik�w zarabiaj�ca powy�ej podanej kwoty wynosi " + counter);
	}
	
	public static void calculateAvarageSalaryForInput(LinkedList<Employee> list)
	{
		System.out.println("Podaj numer dzia�u");
		int inputDepartmentNumber = scan.nextInt();
		int avarageSalary = 0;
		int counter = 0;
		for (int i = 0; i < list.size(); i++) 
		{
			if (inputDepartmentNumber==list.get(i).getDepartmentNumber()) 
			{
				avarageSalary += list.get(i).getSalary();
				counter++;
			}
		}
		
		if (counter > 0) 
		{
			avarageSalary /= counter;
			System.out.println("�rednia p�aca w dziale "+ inputDepartmentNumber + " wynosi " + avarageSalary + " z�");
		} 
			else 
			{
				System.out.println("Brak pracownik�w w tym dziale");
			}			
	}
	
	public static void showMaxSalary(LinkedList<Employee> list)
	{
		float womanMaxSalary = 0;
		float manMaxSalary = 0;
		for (int i = 0; i < list.size(); i++) 
		{
			if(list.get(i).getGender()=='K'&&list.get(i).getSalary()>womanMaxSalary)
			{
				womanMaxSalary = list.get(i).getSalary();
			}
			else if(list.get(i).getGender()=='M'&&list.get(i).getSalary()>manMaxSalary)
			{
				manMaxSalary = list.get(i).getSalary();
			}
		}
		
		System.out.println("Najwi�ksza pensja wsr�d kobiet wynosi " + womanMaxSalary + " z�");
		System.out.println("Najwi�ksza pensja wsr�d kobiet wynosi " + manMaxSalary + " z�");	
	}
	
	public static void showAllDepartmentsNumbers(LinkedList<Employee> list)
	{
		int departmentNumber = 0;
		LinkedList<Integer> departmentNumbers = new LinkedList<>();
		searchAllDepartmentsNumber(list, departmentNumbers);
		Collections.sort(departmentNumbers);
		
		for (int i = 0; i < departmentNumbers.size(); i++) 
		{
			departmentNumber = departmentNumbers.get(i);
			System.out.println(departmentNumber);
			calculateAvarageSalary(list, departmentNumber);
		}
	}

	public static void searchAllDepartmentsNumber(LinkedList<Employee> list, LinkedList<Integer> departmentNumbers) 
	{
		int departmentNumber;
		for (int i = 0; i < list.size(); i++) 
		{
			departmentNumber = list.get(i).getDepartmentNumber();
			if(departmentNumbers.size()==0)
			{
				departmentNumbers.add(departmentNumber);
			}
			
			for (int j = 0; j < departmentNumbers.size(); j++) 
			{
				if (list.get(j).getDepartmentNumber()==departmentNumber) 
				{
					break;
				} 
					else if(list.get(j).getDepartmentNumber()!=departmentNumber&&j==departmentNumbers.size()-1)
					{
						departmentNumbers.add(departmentNumber);
					}
			}
		}
	}
	
	public static void calculateAvarageSalary(LinkedList<Employee> list, int departmentNumber)
	{
		int avarageSalary = 0;
		int counter = 0;
		for (int i = 0; i < list.size(); i++) 
		{
			if (departmentNumber==list.get(i).getDepartmentNumber()) 
			{
				avarageSalary += list.get(i).getSalary();
				counter++;
			}
		}
		
		if (counter > 0) 
		{
			avarageSalary /= counter;
			System.out.println("�rednia p�aca w dziale "+ departmentNumber + " wynosi " + avarageSalary + " z�");
		} 
			else 
			{
				System.out.println("Brak pracownik�w w tym dziale");
			}			
	}
}