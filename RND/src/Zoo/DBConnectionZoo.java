package Zoo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DBConnectionZoo {
	private static final String PROP_FILE = "input.properties";
	public static Connection getdbconnection() throws ClassNotFoundException, FileNotFoundException, IOException, SQLException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
		File f=new File(System.getProperty("user.dir") + "\\" + PROP_FILE);
		Properties prop=new Properties();
		prop.load(new FileInputStream(f));
		//System.out.println(prop.getProperty("Sql_User_Name"));
		Connection con = DriverManager.getConnection(prop.getProperty("Sql_Url") );
		return con;	
	}
}


