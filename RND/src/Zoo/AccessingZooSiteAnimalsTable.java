package Zoo;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;


@SuppressWarnings("unused")
public class AccessingZooSiteAnimalsTable implements ZooInterface
{
	public void ZooSiteAnimalsTable() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException 
	{
		int i=1,j=1,temp=0;String temp_col,upd;
		Statement st;ResultSet rs;
		Scanner sc=new Scanner(System.in);
		Scanner s;
		Connection con = DBConnectionZoo.getdbconnection();
		int ch=0;
		System.out.println("Enter Your choice\n" +
				"1.Read the Data\n" +
				"2.Insert the data\n" +
				"3.Delete Particular Column\n" +
		"4.Updating the record");
		/*
		 * 1.Reading the data
		 * 2.Inserting the Data
		 * 3.Delete Particular Record
		 * 4.Updating Record
		 */
		ch=sc.nextInt();
		switch (ch) 
		{
		case 1:
			readdata();
			break;
		case 2:
			while(j==1)
			{
				insertData();
				System.out.println("Do you want insert more data press 1 else press 0");
				j=ZooMain.s.nextInt();
			}
			break;
		case 3:
			deleteData();
			break;
		case 4:
			updateColumn();
			break;
		}
	}

	private void updateColumn()
	{
		System.out.println("Updating a Column");
		System.out.println("Please Enter the idZooAddress of respective column to Update");
		int temp=ZooMain.s.nextInt();
		ZooMain.s.nextLine();
		System.out.println("Please Enter the Columnlabel which you want to update(it Must be Animals (or) AnimalType (or) FoodType)");
		String temp_col=ZooMain.s.nextLine();
		System.out.println("Enter your Update value");
		String upd=ZooMain.s.nextLine();
		ZooMain.Query="UPDATE [dbo].[Zoo_SiteAnimals] SET "+temp_col+"='"+upd+"' where IdZooSite="+temp;
		try
		{
			ZooMain.executeQuery(ZooMain.Query);
		}
		catch(Exception e)
		{
			System.out.println("Column Doesn't exists");
		}
	}

	private void deleteData() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException
	{
		System.out.println("Delete the data");
		System.out.println("Please Enter the idZooAddress of respective column to delete");
		int temp=ZooMain.s.nextInt();
		ZooMain.Query="Delete from [dbo].[Zoo_SiteAnimals] where idZooAddress="+temp;
		ZooMain.executeQuery(ZooMain.Query);
	}

	private void insertData() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException 
	{
		System.out.println("Inserting the data");
		System.out.println("Please Enter the following details");
		System.out.println("1.IdZooAnimals");
		System.out.println("2.IdZooAddress");
		System.out.println("3.Counts");
		ZooAddress zad=new ZooAddress( ZooMain.s.nextLine(), ZooMain.s.nextLine(), ZooMain.s.nextLine());
		ZooMain.Query="INSERT INTO [dbo].[Zoo_SiteAnimals]([IdZooAnimals],[IdZooAddress],[Counts]) VALUES("
			+zad.getIdZooAnimals()+","+zad.getIdZooAddress()+","+zad.getCounts()+")";
		ZooMain.executeQuery(ZooMain.Query);
	}

	private void readdata() throws SQLException, FileNotFoundException, ClassNotFoundException, IOException 
	{
		Connection con = DBConnectionZoo.getdbconnection();
		System.out.println("Reading the Data");
		ZooMain.st=con.createStatement();
		ResultSet rs=ZooMain.st.executeQuery("SELECT * FROM dbo.Zoo_SiteAnimals");
		while(rs.next())
		{
			System.out.println(rs.getString(IdZooAnimals)+" "+rs.getString(idZooAddress)+" "+rs.getString(Counts));
		}
	}
}
