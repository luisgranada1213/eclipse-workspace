package daos;

import java.util.List;

import dtos.Departamento;
import dtos.Municipio;

public class Main {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		DepartamentoDao departamentoDao= new DepartamentoDao();
		List<Departamento> deList=departamentoDao.findAll();
		System.out.println(deList.size());
		MunicipioDao municipioDao= new MunicipioDao();
		List<Municipio> listm=municipioDao.findAll();
		System.out.println(listm.size());
	}

}
