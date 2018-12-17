package mundo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class ConsultaGeneral<T>
{
	private Class<T> entityClass;
	
	public ConsultaGeneral(Class<T> entityClass) 
	{
		this.entityClass=entityClass;
	}
	
	protected abstract EntityManager getEntityManager();
	
	public void create(T entity)
	{
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(entity);
		getEntityManager().getTransaction().commit();
	}
	public void edit(T entity)
	{
		getEntityManager().getTransaction().begin();
		getEntityManager().merge(entity);
		getEntityManager().getTransaction().commit();
	}
	public void remove(T entity)
	{
		getEntityManager().getTransaction().begin();
		getEntityManager().remove(entity);
		getEntityManager().getTransaction().commit();	
	}
	public T find(Object id)
	{
		return getEntityManager().find(entityClass, id);
	}
	public List<T> findAll()
	{
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
		TypedQuery<T> query = getEntityManager().createQuery(criteriaQuery);
		return query.getResultList();
	}
	public List<T> findRange(int [] range)
	{
		List<T> result= new ArrayList<>();
		if(range[0] > range[1] || range[0] < 0)
		{
			System.out.println("No se puede realizar la consulta");
		}
		else
		{
			CriteriaBuilder criteriaBuilder=getEntityManager().getCriteriaBuilder();
			CriteriaQuery<T> criteriaQuery= criteriaBuilder.createQuery(entityClass);
			Query query=getEntityManager().createQuery(criteriaQuery);
			query.setMaxResults(range[1]-range[0]);
			query.setFirstResult(range[0]);
			result = query.getResultList();
		}
		
		return result;
	}
	public int count()
	{
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
		Root entity = criteriaQuery.from(entityClass);
		criteriaQuery.select(criteriaBuilder.count(entity));
		Query query = getEntityManager().createQuery(criteriaQuery);
		Long result = (Long) query.getSingleResult();
		return result.intValue();
	}
}
