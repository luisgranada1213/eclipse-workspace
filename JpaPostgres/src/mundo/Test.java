package mundo;

import java.util.List;

import entities.Departamento;
import entities.Municipio;
import entities.Persona;

public class Test 
{
	public static void main(String[] args) 
	{
		DepFacade depFacade=new DepFacade();
		System.out.println("Actualmente hay "+ depFacade.count()+ " departamentos");
		List<Departamento> listDep=depFacade.findRange(new int [] {0,33});
		for (Departamento departamento : listDep) 
		{
			System.out.println(departamento);
		}
		MunicipioFacade municipioFacade=new MunicipioFacade();
		System.out.println("Actualmente hay "+municipioFacade.count()+ " municipios");
		List<Municipio> listMun=municipioFacade.findRange(new int [] {0,30});
		for (Municipio municipio : listMun) 
		{
			System.out.println(municipio);
		}
		PersonaFacade personaFacade=new PersonaFacade();
		System.out.println("Actualmente hay "+personaFacade.count()+ " personas");
		List<Persona> listPersonas=personaFacade.findAll();
		for (Persona persona : listPersonas) 
		{
			System.out.println(persona);
		}
		
	}
}
