package lis.damian.project;

import java.io.IOException;
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
	     System.out.println("0. Powrót");
	   
	     while(isNotDigit)
	        {
		        try 
		        {
		        	input = scan.nextInt();
		        	isNotDigit = false;
				} catch (InputMismatchException e) 
		        {
					System.out.println("To nie jest liczba, spróbuj jeszcze raz");		
					isNotDigit = true;
					scan.nextLine();
				}	        
	        }        
	        return input;      
	}
	
	public static void switchCaseContextMenuFive(LinkedList<Employee> list, int inputGetList) throws IOException 
	{
		int input = ContextMenu.contextMenuForNumberFive();		
			
		while(input != 0)
		{
			switch (input) 
			{
			case 1:
				changeSurname(list, inputGetList);					
				break;
			case 2:
				System.out.println("Podaj nowy numer departamentu");
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
				System.out.println("Podaj liczbê dzieci");
				int newNumberOfChildren = scan.nextInt();
				list.get(inputGetList-1).setNumberOfChildren(newNumberOfChildren);
				break;
			case 6:
				System.out.println("Podaj obecny stan cywilny");
				System.out.println("1.Mê¿atka/¯onaty" + "\n2.Panna/Kawaler");
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
				System.out.println("Nieprawid³owy wybór, spróbuj jeszcze raz");
			}
			System.out.println("\nWciœnij Enter, aby kontynuowaæ...");
			System.in.read();
			input = ContextMenu.contextMenuForNumberFive();
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
			System.out.println("Opcja dostêpna tylko dla kobiet");
		}
	}
}
