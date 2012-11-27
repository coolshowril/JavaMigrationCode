package Zoo;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class AccessingZooAnimalsTable implements ZooInterface 
{
	private static Statement st;
	static String query;
	static Scanner s=new Scanner(System.in);


	public void ZooAnimalsTable() throws Exception 
	{
		int j=1;
		Scanner sc=new Scanner(System.in);
		int ch=0;
		System.out.println("Enter Your choice" +
				"\n1.Read the Data" +
				"\n2.Insert the data" +
				"\n3.Delete Particular Column" +
		"\n4.Updating the record");
		ch=sc.nextInt();
		/*
		 * 1.Reading the data
		 * 2.Inserting the Data
		 * 3.Delete Particular Record
		 * 4.Updating Record
		 */
		switch (ch) 
		{
		case 1:
			readData();
			break;
		case 2:
			while(j==1)
			{
				insertData();
				System.out.println("Do you want insert more data press 1 else press 0");
				j=s.nextInt();
			}
			break;
		case 3:
			deleteData();	
			break;
		case 4:
			updateColumn();
			break;
		default:
			System.out.println("Invalid Choice");
			break;
		}	
	}



	private static void updateColumn() 
	{
		System.out.println("Updating a Column");
		System.out.println("Please Enter the idZooAddress of respective column to Update");
		int temp=s.nextInt();
		s.nextLine();
		System.out.println("Please Enter the Columnlabel which you want to update(it Must be Animals (or) AnimalType (or) FoodType)");
		String temp_col=s.nextLine();
		System.out.println("Enter your Update value");
		String upd=s.nextLine();
		query="UPDATE [dbo].[Zoo_Animals] SET "+temp_col+"='"+upd+"' where idZooAnimals="+temp;
		try
		{
			ZooMain.executeQuery(query);
		}
		catch(Exception e)
		{
			System.out.println("Column Doesn't exists");
		}
	}



	private static void deleteData() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException 
	{
		System.out.println("Delete the data");
		System.out.println("Please Enter the idZooAddress of respective column to delete");
		int temp=s.nextInt();
		query="Delete from [dbo].[Zoo_Animals] where idZooAnimals="+temp;
		ZooMain.executeQuery(query);
	}



	private static void insertData() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException 
	{
		System.out.println("Inserting the data");
		System.out.println("Please Enter the following details");
		System.out.println("1.Animals");
		System.out.println("2.AnimalType");
		System.out.println("3.FoodType");
		ZooAddress zad=new ZooAddress(ZooMain.s.nextLine(), ZooMain.s.nextLine(), ZooMain.s.nextLine());
		query="INSERT INTO [dbo].[Zoo_Animals]([Animals],[AnimalType],[FoodType]) VALUES('"
			+zad.getAnimals()+"','"+zad.getAnimalType()+"','"+zad.getFoodType()+"')";
		ZooMain.executeQuery(query);
	}



	private static void readData() throws Exception 
	{
		Connection con = DBConnectionZoo.getdbconnection();
		System.out.println("Reading the Data");
		st=con.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM dbo.Zoo_Animals");
		while(rs.next())
		{
			System.out.println(rs.getString(IdZooAnimals)+" "+rs.getString(Animals)+" "+rs.getString(AnimalType)+" "+rs.getString(FoodType));
		}
	}


}
