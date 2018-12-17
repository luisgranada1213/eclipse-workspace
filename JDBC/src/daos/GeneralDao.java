package daos;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dtos.IDto;
import mundo.Database;

public abstract class GeneralDao<T extends IDto>
{
	protected Class<T> classDto;
	public GeneralDao(Class<T> classDto)
	{
		this.classDto=classDto;
	}
	public List<T> findAll()
	{
		List<T> result=new ArrayList<>();
		Connection connection= Database.getConnection();
		try 
		{
			PreparedStatement ps=connection.prepareStatement(classDto.newInstance().findAll());
			ResultSet rs=ps.executeQuery();
			ResultSetMetaData rsm= rs.getMetaData();
			String nombreTabla=rsm.getTableName(1);
			int columns=rsm.getColumnCount();
			Method[] metodos=classDto.getMethods();
			metodos= DaoUtils.sortMetodos(metodos, rsm,columns);
			while (rs.next())
			{
				T actual=classDto.newInstance();
				for (int i = 0; i < metodos.length; i++) 
				{
					Object value=rs.getObject(i+1);//valor leido de DB
					//Metada del objeto leido
					Class classValue=value.getClass();
					String classValueTypeName=classValue.getTypeName();
					//Metada del tipo de dato del parametro
					Class typeParameter=metodos[i].getParameterTypes()[0];
					String typeNameParameter=typeParameter.getTypeName();
					if(!typeNameParameter.equals(classValueTypeName))
					{
						//si los tipos de datos no son iguales se procede a hacer la convesion
						Class superClassValue=classValue.getSuperclass();
						String nameSuperClass=superClassValue.getTypeName();
						if(nameSuperClass.equals(DaoUtils.CLASS_NUMBER))
						{
							//Si es un numero AtomicInteger, AtomicLong, BigDecimal, BigInteger, Byte, Double, Float, Integer, Long, Short
							Number number=(Number) value;
							String methodName=typeParameter.getSimpleName().substring(0, 1).toLowerCase()+typeParameter.getSimpleName().substring(1);
							value=superClassValue.getMethod(methodName+"Value", null).invoke(value, null);
						}
					}
					metodos[i].invoke(actual, value);
				}
				result.add(actual);
			}
			rs.close();
			ps.close();
		} 
		catch (InstantiationException e) 
		{
			e.printStackTrace();
		} 
		catch (IllegalAccessException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		catch (InvocationTargetException e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		catch (NoSuchMethodException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	

}
