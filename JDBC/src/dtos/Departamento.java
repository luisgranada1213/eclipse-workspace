package dtos;
import java.util.List;
public class Departamento implements IDto
{
	private Short codigo_departamento;
	private String nombre_deparamento;
	
	//Constructores
	public Departamento() 
	{
		// TODO Auto-generated constructor stub
	}

	public Departamento(Short codigo, String nombre) 
	{
		this.codigo_departamento = codigo;
		this.nombre_deparamento = nombre;
	}
	public Departamento(int codigo, String nombre) 
	{
		this(new Short(codigo+""),nombre);
	}
	
	//Metodos get
	public Short getCodigo_departamento() {
		return codigo_departamento;
	}

	public String getNombre_deparamento() {
		return nombre_deparamento;
	}
	//Metodos set

	public void setCodigo_departamento(Short codigo_departamento) {
		this.codigo_departamento = codigo_departamento;
	}

	public void setNombre_deparamento(String nombre_deparamento) {
		this.nombre_deparamento = nombre_deparamento;
	}
	//Metodos
	@Override
	public String toString()
	{
		return codigo_departamento+","+nombre_deparamento;
	}

	@Override
	public String insert() 
	{
		return "INSERT INTO public.departamentos(\n" + 
				"	codigo_departamento, nombre_deparamento)\n" + 
				"	VALUES ("+codigo_departamento.toString()+ " , '"+ nombre_deparamento+"' );";
	}

	@Override
	public String delete() 
	{
		// TODO Auto-generated method stub
		return "DELETE FROM public.departamentos\n" + 
				"	WHERE codigo_departamento="+codigo_departamento.toString()+";";
	}

	@Override
	public String edit() 
	{
		// TODO Auto-generated method stub
		return "UPDATE public.departamentos\n" + 
				"	SET codigo_departamento="+codigo_departamento.toString()+" , nombre_deparamento='"+nombre_deparamento+"'\n" + 
				"	WHERE codigo_departamento=" + codigo_departamento.toString()+";";
	}

	@Override
	public String findAll() {
		// TODO Auto-generated method stub
		return "select * from departamentos";
	}

	@Override
	public String findPk() 
	{
		return "select * from departamentos where codigo_departamento="+codigo_departamento.toString();
	}
	
}
