package mundo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Municipio;

public class MunicipioFacade extends ConsultaGeneral<Municipio>
{
	private EntityManager em;

	public MunicipioFacade() 
	{
		super(Municipio.class);
		em=Database.getEntityManager();
	}

	@Override
	protected EntityManager getEntityManager() 
	{
		return em;
	}

}
