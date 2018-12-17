package daos;

import dtos.Departamento;

public class DepartamentoDao extends GeneralDao<Departamento>
{
	public DepartamentoDao() 
	{
		super(Departamento.class);
	}
}
