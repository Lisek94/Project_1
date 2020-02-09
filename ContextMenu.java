package lis.damian.project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



@SuppressWarnings("serial")
public class ContextMenu implements Serializable
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
		int input = contextMenuForNumberFive();		
			
		while(input != 0)
		{
			switch (input) 
			{
			case 1:
				changeSurname(list, inputGetList);					
				break;
			case 2:
				System.out.println("Podaj nowy numer dzia³u");
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
				System.out.println("Podaj stan cywilny");
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
			System.out.println("Opcja dostêpna tylko dla kobiet");
		}
	}
	
	public static int contextMenuForNumberSix()
	{
		System.out.println("\nWybierz opcje");
		
		int input = 0;
		boolean isNotDigit = true;
		
		 System.out.println("1. Oblicz liczbê pracowników zarabiaj¹cych powy¿ej podanej kwoty");
	     System.out.println("2. Oblicz sredni¹ p³ace w dziale");
	     System.out.println("3. Wyœwietl najwiêksze p³ace wœrod kobiet i mê¿czyzn");
	     System.out.println("4. Wyœwietl numery wszystkich dzia³ów oraz dodatkowe informacje");
	     System.out.println("5. Wyœwietl stosunek œredniej p³acy kobiet do œredniej p³acy mê¿czyzn");
	     System.out.println("6. Zwiêksz zarobki o 10% + premiê wszystkim pracownikom");
	     System.out.println("7. Zwiêksz zarobki o podan¹ kwotê wszystkim pracownikom");
	     System.out.println("8. Posortuj pracowników wg. nazwiska");
	     System.out.println("9. Posortuj pracowników wg. zarobków");
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
				showAllDepartmentsNumbers(list);
				break;
			case 5:
				showRatioForWomanAndMan(list);
				break;
			case 6:
				salaryIncreaseByTenPercent(list);
				break;
			case 7:
				showSalaryIncreaseByInput(list);
				break;	
			case 8:				
				input = sortBySurname(list);				
				break;
			case 9:
				input = sortBySalary(list);
				break;
			default:
				System.out.println("Nieprawid³owy wybór, spróbuj jeszcze raz");
			}
			System.out.println("\nWciœnij Enter, aby kontynuowaæ...");
			System.in.read();
			input = contextMenuForNumberSix();
		}
		
	}
	
	public static int contextMenuForNumberSeven()
	{
		System.out.println("\nWybierz opcje");
		
		int input = 0;
		boolean isNotDigit = true;
		
		 System.out.println("1. Wyswietl osobe z najd³u¿szym nazwiskiem");
	     System.out.println("2. Oblicz sredni wiek dla osób posiadaj¹cych dzieci");
	     System.out.println("3. Zakoduj nazwiska");
	     System.out.println("4. Stwórz tabele w HTML");	     
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
	
	public static void switchCaseContextMenuSeven(LinkedList<Employee> list) throws IOException 
	{
		String fileName = Menu.exportData(list);
		int input = contextMenuForNumberSeven();		
			
		while(input != 0)
		{
			switch (input) 
			{
			case 1:
				showTheLongestSurname(fileName);
				break;
			case 2:
				avarageAge(fileName);
				break;
			case 3:					
				encodeFile(fileName);
				break;
			case 4:				
				System.out.println("Funkcja wkrótce zostanie dodana");
				break;			
			default:
				System.out.println("Nieprawid³owy wybór, spróbuj jeszcze raz");
			}
			System.out.println("\nWciœnij Enter, aby kontynuowaæ...");
			System.in.read();
			input = contextMenuForNumberSeven();
		}
		
	}

	public static double calculateAvSalary(String fileName) throws IOException 
	{
		String readLine = "";	
		int counter = 0;
		double avSalary = 0;
		double salary = 0;
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		
		while((readLine = reader.readLine())!=null ) 
		{		
			Pattern salaryPattern = Pattern.compile("Wynagrodzenie: (\\d+.\\d+) z³");	
			Matcher matcherSalary = salaryPattern.matcher(readLine);
			if (matcherSalary.matches()) 
			{
				String holder = matcherSalary.group(1);
				salary = Double.parseDouble(holder);
				avSalary += salary;
				counter++;
			}
			
			
		}		
		reader.close();
		return avSalary /= counter;
	}

	public static void encodeFile(String fileName) throws IOException
	{
		double avSalary = calculateAvSalary(fileName);
		int counter = 0;	
		String lineEncodeHolder = "";
		String lineHolder = "";
		String readLine = "";		
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		LinkedList<String> strings = new LinkedList<String>();
		
		while((readLine = reader.readLine())!=null ) 
		{			
			Pattern surnamePattern = Pattern.compile("Nazwisko: (\\w+)");
			Matcher surnameMatcher = surnamePattern.matcher(readLine);
			if(surnameMatcher.matches()) 
			{
				lineHolder = readLine;
			}
			
			Pattern salaryPattern = Pattern.compile("Wynagrodzenie: (\\d+.\\d+) z³");	
			Matcher matcherSalary = salaryPattern.matcher(readLine);
			if (matcherSalary.matches()) 
			{
				String salaryHolder = matcherSalary.group(1);
				double salary = Double.parseDouble(salaryHolder);	
				if(salary<avSalary)
				{
					lineEncodeHolder = encodeSurname(lineEncodeHolder, lineHolder);	
					strings.set(counter-4, lineEncodeHolder);
				}
			}
			
			strings.add(readLine);
			counter++;
		}
		saveEncodeListToFile(strings,fileName);
		reader.close();
	}

	public static String encodeSurname(String lineEncodeHolder, String lineHolder) 
	{
		Character letter = ' ';
		for (int i = 0; i < lineHolder.length(); i++) 
		{
			letter = lineHolder.charAt(i);
			if(i>10&&i<lineHolder.length()-1)
			{
				lineEncodeHolder += "*";
			} else
			{
				lineEncodeHolder += letter;
			}						
		}
		return lineEncodeHolder;
	}
			
	public static void saveEncodeListToFile(LinkedList<String> strings, String fileName) throws IOException
	{
		FileWriter fileWriter = new FileWriter(fileName);
		
		for (int i = 0; i < strings.size(); i++) 
		{
			fileWriter.write(strings.get(i)+"\n");
		}
		fileWriter.close();		
	}
	
	public static void showTheLongestSurname(String fileName) throws FileNotFoundException, IOException 
	{
		String readLine = "";
		String theLongestSurname = "";
		int surnameSize = 0;
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		while((readLine = reader.readLine())!=null ) 
		{			
			Pattern pattern = Pattern.compile("Nazwisko: (\\w+)");
			Matcher matcher = pattern.matcher(readLine);
			if(matcher.matches()) 
			{
				String surname = matcher.group(1);
				if (surname.length()>surnameSize) 
				{
					surnameSize = surname.length();
					theLongestSurname = surname;
				}
								
			}
		}
		System.out.println("Najd³u¿sze nazwisko to: " + theLongestSurname);
		reader.close();
	}
	
	public static void avarageAge(String fileName) throws FileNotFoundException, IOException 
	{
		String readLine = "";		
		int age = 0;
		String holder = "";
		double avarageAge = 0;
		int counter = 0;
		int childNumber = 0;
		
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		try 
		{
			while((readLine = reader.readLine())!=null ) 
			{			
				Pattern agePattern = Pattern.compile("Wiek: (\\d+)");	
				Matcher matcherAge = agePattern.matcher(readLine);	
				if (matcherAge.matches()) 
				{
					holder = matcherAge.group(1);
					age = Integer.parseInt(holder);
					readLine = reader.readLine();
					Pattern childrenPattern = Pattern.compile("Liczba dzieci: (\\d+)");
					Matcher matcherChildren = childrenPattern.matcher(readLine);
					matcherChildren.matches();					
					holder = matcherChildren.group(1);
					childNumber = Integer.parseInt(holder);
					
					if(childNumber!=0) 
					{							
						avarageAge += age;				
						counter++;
					}
				}
				
			}
			avarageAge /= counter;
			System.out.println("Œrednia wieku to: " + avarageAge);
			reader.close();
		} catch (IllegalStateException e) 
		{
			System.out.println("B³¹d odczytu danych");
		}
		
	}

	public static int sortBySalary(LinkedList<Employee> list) 
	{
		int input = 0;
		System.out.println("1. Posortuj rosn¹co"+"\n2. Posortuj malej¹co"+"\n0. Powrót");
		input = scan.nextInt();
		if (input==1) 
		{
			list.sort(Comparator.comparing(Employee::getSalary));
		} else if(input==2)
		{
			list.sort(Comparator.comparing(Employee::getSalary).reversed());
		}
		return input;
	}
	public static int sortBySurname(LinkedList<Employee> list) 
	{
		int input = 0;
		System.out.println("1. Posortuj rosn¹co"+"\n2. Posortuj malej¹co"+"\n0. Powrót");
		input = scan.nextInt();
		if (input==1) 
		{
			list.sort(Comparator.comparing(Employee::getSurname));
		} else if(input==2)
		{
			list.sort(Comparator.comparing(Employee::getSurname).reversed());
		}
		return input;
	}
	
	public static void showSalaryIncreaseByInput(LinkedList<Employee>list)
	{
		double increase = calculateSalaryIncreaseByInput(list);
		System.out.println("Stosunek podwy¿ek dla kobiet i mê¿czyzn wynosi: "+ increase);
	}

	public static double calculateSalaryIncreaseByInput(LinkedList<Employee> list) 
	{
		System.out.println("Podaj kwote podwy¿ki");
		float increase = scan.nextFloat();
		float sumIncrease = 0;
		float sumIncreaseForWoman = 0;
		float sumIncreaseForMan = 0;
		for (int i = 0; i < list.size(); i++) 
		{
			float salary = list.get(i).getSalary();
			list.get(i).setSalary(salary+increase);
			sumIncrease += increase;
			
			if (list.get(i).getGender()=='K') 
			{
				sumIncreaseForWoman += increase;
			} else
			{
				sumIncreaseForMan += increase;
			}
		}
		System.out.println("Suma podwy¿ek wynosi " + sumIncrease);
		
		double ratio = sumIncreaseForWoman/sumIncreaseForMan;
		return ratio;
	}

	public static void salaryIncreaseByTenPercent(LinkedList<Employee> list) 
	{
		double sumIncrease = 1.1;
		for (int i = 0; i < list.size(); i++) 
		{
			float newSalary = list.get(i).getSalary();
			if (list.get(i).getNumberOfChildren()>0) 
			{
				sumIncrease += list.get(i).getNumberOfChildren()*0.02;
			}
			if (list.get(i).isMarried()==true) 
			{
				sumIncrease += (float)0.03;
			}
			list.get(i).setSalary(newSalary*(float)sumIncrease);
		}
		
		System.out.println("Pensja zosta³a zwiêkszona");
	}

	public static void calculateTheNumberOfEmployeeForInputSalary(LinkedList<Employee> list) 
	{
		System.out.println("Podaj kwotê");
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
		System.out.println("Liczba pracowników zarabiaj¹ca powy¿ej podanej kwoty wynosi " + counter);
	}
	
	public static void calculateAvarageSalaryForInput(LinkedList<Employee> list)
	{
		System.out.println("Podaj numer dzia³u");
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
			System.out.println("Œrednia p³aca w dziale "+ inputDepartmentNumber + " wynosi " + avarageSalary + " z³");
		} 
			else 
			{
				System.out.println("Brak pracowników w tym dziale");
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
		
		System.out.println("Najwiêksza pensja wsród kobiet wynosi " + womanMaxSalary + " z³");
		System.out.println("Najwiêksza pensja wsród kobiet wynosi " + manMaxSalary + " z³");	
	}
	
	public static void toShowRatioWomanAndMan(LinkedList<Employee> list)
	{
		int numberOfWoman = 0;
		int numberOfMan = 0;
		for (int i = 0; i < list.size(); i++) 
		{
			if (list.get(i).getGender()=='K') 
			{
				numberOfWoman++;				
			} 
			else 
			{
				numberOfMan++;
			}
		}
		
		if (numberOfWoman>numberOfMan) 
		{
			System.out.println("W firmie jest wiêcej kobiet.");
		} 
		else if(numberOfMan>numberOfWoman)
		{
			System.out.println("W firmie jest wiêcej mê¿czyzn.");
		}
		else
		{
			System.out.println("W firmie jest tyle samo kobiet co mê¿czyzn.");
		}
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
			calculateAvarageSalaryForDepartment(list, departmentNumber);
		}
		
		toShowRatioWomanAndMan(list);
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
					break;
				}
			}
		}
	}
	
	public static void calculateAvarageSalaryForDepartment(LinkedList<Employee> list, int departmentNumber)
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
			System.out.println("Œrednia p³aca w dziale "+ departmentNumber + " wynosi " + avarageSalary + " z³");
		} 
			else 
			{
				System.out.println("Brak pracowników w tym dziale");
			}			
	}
	
	public static double calculateAvarageSalaryForWoman(LinkedList<Employee> list)
	{
		int avarageSalary = 0;
		int counter = 0;
		for (int i = 0; i < list.size(); i++) 
		{
			if (list.get(i).getGender()=='K') 
			{
				avarageSalary += list.get(i).getSalary();
				counter++;
			}
		}
		return avarageSalary /= counter;
	}
	
	public static double calculateAvarageSalaryForMan(LinkedList<Employee> list)
	{
		int avarageSalary = 0;
		int counter = 0;
		for (int i = 0; i < list.size(); i++) 
		{
			if (list.get(i).getGender()=='M') 
			{
				avarageSalary += list.get(i).getSalary();
				counter++;
			}
		}
		return avarageSalary /= counter;
	}
	
	public static double calculateRatioSalaryForWomanAndMan(LinkedList<Employee> list)
	{
		double ratio = 0;
		ratio = calculateAvarageSalaryForWoman(list)/calculateAvarageSalaryForMan(list);		
		return ratio;
	}
	
	public static void showRatioForWomanAndMan(LinkedList<Employee> list) 
	{
		double ratio = calculateRatioSalaryForWomanAndMan(list);
		System.out.println("Stosunek œredniej p³acy kobiet do mê¿czyzn wynosi: "+ ratio);
	}
}