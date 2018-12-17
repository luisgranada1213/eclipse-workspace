package mundo;

import dtos.Departamento;

public class Main 
{
	public static void main(String[] args) 
	{
		Database.getConnection();
		Departamento departamento= new Departamento(100, "B");
		System.out.println(departamento.delete());
		System.out.println(departamento.findPk());
		
		Class<Departamento> dep= Departamento.class;
		System.out.println(dep.getName());
		System.out.println(dep.getSimpleName());
		System.out.println(dep.getTypeName());
	}
}
