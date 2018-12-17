package mundo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database 
{
	private static Connection connection=null;
	public static Connection getConnection()
	{
		if(connection==null)
		{
			try
			{
				 String driver="org.postgresql.Driver"; //el driver varia segun la DB que usemos
		         String url="jdbc:postgresql://localhost:5432/postgres?autoReconnect=true";
		         String pwd="colombia";
		         String usr="postgres";
		         Class.forName(driver);
		         connection = DriverManager.getConnection(url,usr,pwd);
		         System.out.println("Conectionesfull");
			}
			catch (SQLException e) 
			{
				// TODO: handle exception
			} catch (ClassNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return connection;
	}
}
