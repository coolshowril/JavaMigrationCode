package com.transferback;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

@SuppressWarnings("unused")
public class testConnection
{
    public static void main(String[] args) throws SQLException, ClassNotFoundException 
    {
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
		
		Connection con = DriverManager.getConnection("jdbc:sqlserver://KIRAN1-PC\\MSSQLSERVER1;" +
				"databaseName=HelpDeskKOT;integratedSecurity=true;");
		Statement st=con.createStatement();
		String Query="INSERT INTO [HelpDeskKOT].[dbo].[LoginCredentials]"
		           +"([UserName]"+",[Password]"
		                   +",[UserId])"
		             +"VALUES"+"('a','b','c')";
		st.executeUpdate(Query);
		System.out.println("***"+con);
    }
}

