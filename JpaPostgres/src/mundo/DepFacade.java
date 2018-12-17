package mundo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import entities.Departamento;

public class DepFacade extends ConsultaGeneral<Departamento>
{
	private EntityManager em;
	
	public DepFacade() 
	{
		super(Departamento.class);
		em=Database.getEntityManager();
	}

	@Override
	protected EntityManager getEntityManager() 
	{
		return em;
	}
	
}
