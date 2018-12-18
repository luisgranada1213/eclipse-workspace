package daos;

import dtos.Persona;

public class PersonaDao extends GeneralDao<Persona> 
{
	public PersonaDao()
	{
		super(Persona.class);
	}
}
