package lis.damian.project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) throws IOException 
	{
	int inputChoice = Menu.showMenu();
	LinkedList<Employee> list = new LinkedList<Employee>();
	String fileName = "baza.dat";
	File file = new File(fileName);	
	
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
				for (int i = 0; i < list.size(); i++) {
					System.out.println(i+1+".");
				System.out.println(list.get(i).showBasicPersonalData());
				}
			}			
			break;
		case 2:
			list.add(Menu.addEmployee());
			System.out.println("Pracownik dodany");
			break;
		case 3:
			Employee saveLine;
			FileWriter saveToFile = new FileWriter(fileName);
			for (int i = 0; i < list.size(); i++) 
			{
				saveLine = list.get(i);			
				saveToFile.write(i+1+"\n"+saveLine+"\n");				
			}			
			saveToFile.close();
			break;
		case 4:
			for (int i = 0; i < list.size(); i++) 
			{
				System.out.println(i+1+".");
			System.out.println(list.get(i).showBasicPersonalData());
			}
			System.out.println("Wybierz numer pracownika do usuniêcia");
			Scanner scan = new Scanner(System.in);
			inputChoice = scan.nextInt();
			list.remove(inputChoice-1);
			break;		
		case 8:
			Menu.infoAboutProgram();
			break;
		default:
			System.out.println("Z³a cyfra gnoju");
		}
		System.out.println("\nWciœnij Enter, aby kontynuowaæ...");
		System.in.read();
		inputChoice = Menu.showMenu();
	}
	
	System.out.println("Program wy³¹czony");
	
	}

}
