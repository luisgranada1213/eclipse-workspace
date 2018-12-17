package mundo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import entities.Departamento;
import entities.Municipio;


public class Utils 
{
	/**
	 * Consulta todos los departamentos de la base de datos y los guarda en un archivo 
	 * @throws FileNotFoundException
	 */
	public void saveFileDepartamentosFromDatabase() throws FileNotFoundException 
	{
		// TODO Auto-generated constructor stub
		DepFacade depFacade= new DepFacade();
		PrintWriter printWriter= new PrintWriter(new File("./data/departamentos.txt"));
		printWriter.println(depFacade.count());
		List<Departamento> list= depFacade.findAll();
		for (int i = 0; i < list.size(); i++) 
		{
			printWriter.println(list.get(i));
		}
		printWriter.close();
	}
	/**
	 * Lee un archivo con los departamentos y los guarda en la base de datos
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static void readFileDepartamentosAndOnSaveDatabase() throws NumberFormatException, IOException
	{
		DepFacade depFacade= new DepFacade();
		BufferedReader br= new BufferedReader(new FileReader("./data/departamentos.txt"));
		int count= Integer.parseInt(br.readLine());
		for (int i=0; i<count; i++)
		{
			String [] partes= br.readLine().split(",");
			Departamento departamento= new Departamento(Integer.parseInt(partes[0]), partes[1]);
			depFacade.create(departamento);
		}
		br.close();
	}
	
	/**
	 * Consulta los municipios y los guarda en un archivo
	 * @throws FileNotFoundException
	 */
	public static void saveFileMunicipioFromDatabase() throws FileNotFoundException 
	{
		MunicipioFacade municipioFacade= new MunicipioFacade();
		PrintWriter printWriter= new PrintWriter(new File("./data/municipios.txt"));
		printWriter.println(municipioFacade.count());
		List<Municipio> list= municipioFacade.findAll();
		for (int i = 0; i < list.size(); i++) 
		{
			printWriter.println(list.get(i));
		}
		printWriter.close();
	}
	/**
	 * Lee un archivo con los municipios y los guarda en la base de datos
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static void readFileMunicipiosAndOnSaveDatabase() throws NumberFormatException, IOException
	{
		MunicipioFacade municipioFacade= new MunicipioFacade();
		DepFacade depFacade=new DepFacade();
		BufferedReader br= new BufferedReader(new FileReader("./data/municipios.txt"));
		int count= Integer.parseInt(br.readLine());
		for (int i=0; i<count; i++)
		{
			String [] partes= br.readLine().split(",");
			Departamento departamento= depFacade.find(new Short(new Short(partes[2])));
			Municipio municipio= new Municipio(Integer.parseInt(partes[0]), partes[1],departamento);
			municipioFacade.create(municipio);
		}
		br.close();
	}
	
	public static void main(String[] args) 
	{
		try {
			Utils.readFileDepartamentosAndOnSaveDatabase();
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DepFacade depFacade=new DepFacade();
		System.out.println(depFacade.count());
		try {
			Utils.readFileMunicipiosAndOnSaveDatabase();
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MunicipioFacade municipioFacade= new MunicipioFacade();
		System.out.println(municipioFacade.count());
	}
}
