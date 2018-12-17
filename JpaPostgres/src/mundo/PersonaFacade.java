package mundo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import entities.Persona;

public class PersonaFacade extends ConsultaGeneral<Persona> 
{
	private EntityManager em;

	public PersonaFacade() 
	{
		super(Persona.class);
		em=Database.getEntityManager();
	}

	@Override
	protected EntityManager getEntityManager() 
	{
		return em;
	}

}
