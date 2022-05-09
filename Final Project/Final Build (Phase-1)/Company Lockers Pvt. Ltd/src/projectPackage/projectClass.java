package projectPackage;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;

public class projectClass
{
	public static String projectPath; // = "C:\\Users\\Nawwal\\Desktop\\LockedMe Test Files";
	
	public static void main(String[] args) 
	{
		Scanner obj = new Scanner(System.in);
		
		System.out.println("				");
		
		System.out.println("\tCompany Lockers PVT Ltd");
		System.out.println("\tCode Author: Nawwal");
		
		System.out.println("Please Enter The Directory:");
		
		projectPath = obj.nextLine();
		
		System.out.println("1)Get All Files");
		System.out.println("2)Create Files");
		System.out.println("3)Delete Files");
		System.out.println("4)Search Files");
		System.out.println("5)Exit");
		
		System.out.println("Enter Your Choice");
		
		int ch = Integer.parseInt(obj.nextLine());
		
		switch(ch) 
		{
		  case 1 : getAllFiles();
		  break;
		  case 2 : createFiles();
		  break;
		  case 3 : deleteFiles();
		  break;
		  case 4 : searchFiles();
		  break;
		  case 5 : System.exit(0);
		  break;
		  default : System.out.println("Wrong Choice");
		  break;
		  
		}
	}
	
	public static void getAllFiles() 
	{
		System.out.println("getAllFiles");
		File folder = new File(projectPath);
		File[] listOfFiles = folder.listFiles();
		
		if (listOfFiles.length == 0)
		{
			System.out.println("\nFiles Don't Exist!!!");
		}
		else
		{
		    for(var i : listOfFiles) 
		    {
		    	System.out.println(i.getName());
		    }
		}
		
	}
	
	public static void createFiles() 
	{
		System.out.println("createFiles");
		try 
		{
			Scanner obj = new Scanner(System.in);
			String fileName; int lineCount;
			System.out.println("Enter File Name:");
			fileName = obj.nextLine();
			System.out.println("Enter No Of Lines:");
			lineCount = Integer.parseInt(obj.nextLine());
			FileWriter fwobj = new FileWriter(projectPath+"\\"+fileName);
			for(int i =0;i<lineCount;i++) 
			{
				System.out.println(("Enter File Content:"));
				fwobj.write(obj.nextLine()+"\n");
			}
			System.out.println("File Created Successfully");
			fwobj.close();
		}
		catch (Exception e) 
		{
			System.out.println("Error Occured!!!!!!");
		}
	}
	
	public static void deleteFiles() 
	{
		System.out.println("deleteFiles");
		Scanner obj =new Scanner(System.in);
		try 
		{
			String fileName;
			System.out.println("Enter File To Be Deleted:");
			fileName = obj.nextLine();
			File fl = new File(projectPath+"\\"+fileName);
			
			if(fl.exists())
			{
				fl.delete();
				System.out.println("Specified File Deleted");
			}
			else 
			{
				System.out.println("File Does Not Exist!!!!");
			}
		}
		catch (Exception e) 
		{
			System.out.println("Error Occured!!!!!!");
		}
	}
	
	public static void searchFiles() 
	{
		System.out.println("searchFiles");
		Scanner obj =new Scanner(System.in);
		try 
		{
			LinkedList<String> fileNames = new LinkedList<String>();
			
			String fileName;
			System.out.println("Enter File To Search");
			fileName = obj.nextLine();
			
			File[] listOfFiles = new File(projectPath).listFiles();
			
			for(File l : listOfFiles) 
			{
				fileNames.add(l.getName());
			}
			
			if(fileNames.contains(fileName))
			{
				System.out.println("File Is Present");
			}
			else 
			{
				System.out.println("Files Are Not Present");
			}
		}
		catch (Exception e) 
		{
			System.out.println("Error Occured!!!!!!");
		}
	}
	
}
