package Zoo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ZooMain 
{

	/**
	 * @param args
	 * @throws Exception 
	 */

	final static String idZooAddress="idZooAddress";
	final static String Address1="Address1";
	final static String Address2="Address2";
	final static String City="City";
	final static String State="State";
	final static String Country="Country";
	final static String IdZooSite="IdZooSite";
	final static String IdZooAnimals="IdZooAnimals";
	final static String Counts="Counts";
	final static String Animals="Animals";
	final static String AnimalType="AnimalType";
	final static String FoodType="FoodType";

	static String Query;
	static Scanner s=new Scanner(System.in);
	static Statement st;
	public static void main(String[] args) throws Exception 
	{
		int choice,userch=1;
		while(userch==1)
		{
			System.out.println("Select one of Following tables on which you want to Perform Operations");
			System.out.println("\n" +
					"1.Zoo_Address\n" +
					"2.Zoo_Animals\n" +
					"3.Zoo_SiteAnimals");
			/*
			 * Accesing the tables
			 * 1.Zoo_Address
			 * 2.Zoo_Animals
			 * 3.Zoo_SiteAnimals
			 */
			Scanner scanner=new Scanner(System.in);
			choice=scanner.nextInt();
			switch(choice)
			{
			case 1:
				AccesingZooAddressTables zooaddress=new AccesingZooAddressTables();
				zooaddress.ZooAddressTables();
				break;
			case 2:
				AccessingZooAnimalsTable zooanimals=new AccessingZooAnimalsTable();
				zooanimals.ZooAnimalsTable();
				break;
			case 3:
				AccessingZooSiteAnimalsTable siteanimals=new AccessingZooSiteAnimalsTable();
				siteanimals.ZooSiteAnimalsTable();
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
			System.err.println("Press 1 if you want to go back again or Press any button to exit");
			scanner.nextLine();
			userch=scanner.nextInt();
		}
	}
	static void executeQuery(String string) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException 
	{
		Connection con = DBConnectionZoo.getdbconnection();
		st=con.createStatement();
		st.execute(string);
	}
}
