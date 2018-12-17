package mundo;

import java.util.List;

import daos.DepartamentoDao;
import dtos.Departamento;

public class Main 
{
	public static void main(String[] args) 
	{
		Database.getConnection();
		DepartamentoDao departamentoDao= new DepartamentoDao();
		List<Departamento> list=departamentoDao.findAll();
		for (Departamento departamento : list) {
			System.out.println(departamento);
		}
		
	}
}
