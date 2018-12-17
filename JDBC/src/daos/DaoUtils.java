package daos;

import java.lang.reflect.Method;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DaoUtils 
{
	//Nombre de superclase de AtomicInteger, AtomicLong, BigDecimal, BigInteger, Byte, Double, Float, Integer, Long, Short
	public static final String CLASS_NUMBER="java.lang.Number";
	public static Method[] sortMetodos(Method[] metodos, ResultSetMetaData rsm, int columns) 
	{
		Method[] setMethods=new Method[columns];
		try 
		{
			for(int i=1; i<=columns;i++)
			{
				String nombreMetodo="set"+rsm.getColumnName(i).substring(0, 1).toUpperCase()+rsm.getColumnName(i).substring(1);
				for (int j = 0; j < metodos.length; j++) 
				{
					if(metodos[j].getName().equals(nombreMetodo))
					{
						setMethods[i-1]=metodos[j];
						break;
					}
				}
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return setMethods;
	}
}
