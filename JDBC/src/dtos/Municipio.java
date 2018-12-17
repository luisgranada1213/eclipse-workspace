package dtos;

public class Municipio implements IDto
{
	private int codigo_municipio;
	private String nombre_municipio;
	private Short dep_codigo_departamento;
	
	
	public Municipio(int codigo_municipio, String nombre_municipio, Short dep_codigo_departamento) 
	{
		this.codigo_municipio = codigo_municipio;
		this.nombre_municipio = nombre_municipio;
		this.dep_codigo_departamento = dep_codigo_departamento;
	}
	public Municipio()
	{
		
	}
	//MEtodos get
	public int getCodigo_municipio() 
	{
		return codigo_municipio;
	}
	public String getNombre_municipio() 
	{
		return nombre_municipio;
	}
	public Short getDep_codigo_departamento() 
	{
		return dep_codigo_departamento;
	}
	//Metodos set
	public void setCodigo_municipio(int codigo_municipio) 
	{
		this.codigo_municipio = codigo_municipio;
	}
	public void setNombre_municipio(String nombre_municipio) 
	{
		this.nombre_municipio = nombre_municipio;
	}
	public void setDep_codigo_departamento(Short dep_codigo_departamento) 
	{
		this.dep_codigo_departamento = dep_codigo_departamento;
	}
	@Override
	public String insert() {
		// TODO Auto-generated method stub
		return "INSERT INTO public.municipios(\n" + 
				"	codigo_municipio, nombre_municipio, dep_codigo_departamento)\n" + 
				"	VALUES ("+codigo_municipio+", '"+nombre_municipio+"' ,"+ dep_codigo_departamento.toString()+");";
	}
	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return "DELETE FROM public.municipios\n" + 
				"	WHERE codigo_municipio="+codigo_municipio +";";
	}
	@Override
	public String edit() {
		// TODO Auto-generated method stub
		return "UPDATE public.municipios\n" + 
				"	SET codigo_municipio="+ codigo_municipio+", nombre_municipio='"+nombre_municipio+"', dep_codigo_departamento="+
		dep_codigo_departamento.toString()+"\n" + 
				"	WHERE codigo_municipio="+codigo_municipio+";";
	}
	@Override
	public String findAll() {
		// TODO Auto-generated method stub
		return "select * from municipios";
	}
	@Override
	public String findPk() {
		// TODO Auto-generated method stub
		return "select * from municipios where codigo_municipio="+codigo_municipio;
	}
	
	
}
