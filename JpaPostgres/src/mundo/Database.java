package mundo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Database 
{
	private static EntityManager entityManager;
	private Database()
	{
		
	}
	public static final EntityManager getEntityManager()
	{
		if(entityManager==null)
		{
			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Pruebas");
			entityManager=entityManagerFactory.createEntityManager();
		}
		return entityManager;
	}
}
