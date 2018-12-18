package dtos;

public class Persona implements IDto
{

	private long id;
	private String primer_nombre;
	private String segundo_nombre;
	private String primer_apellido;
	private String segundo_apellido;
	private int municipionacimiento_codigo_municipio;
	private int edad;
	//Constructores
	public Persona(long id, String primer_nombre, String segundo_nombre, String primer_apellido,
			String segundo_apellido, int municipionacimiento_codigo_municipio, int edad) 
	{
		this.id = id;
		this.primer_nombre = primer_nombre;
		this.segundo_nombre = segundo_nombre;
		this.primer_apellido = primer_apellido;
		this.segundo_apellido = segundo_apellido;
		this.municipionacimiento_codigo_municipio = municipionacimiento_codigo_municipio;
		this.edad = edad;
	}	
	public Persona()
	{
		
	}
	//Metodos get
	public long getId() {
		return id;
	}
	
	public String getPrimer_nombre() {
		return primer_nombre;
	}
	public String getSegundo_nombre() {
		return segundo_nombre;
	}
	public String getPrimer_apellido() {
		return primer_apellido;
	}
	public String getSegundo_apellido() {
		return segundo_apellido;
	}
	public int getMunicipionacimiento_codigo_municipio() {
		return municipionacimiento_codigo_municipio;
	}
	public int getEdad() {
		return edad;
	}
	//Metodos set
	
	public void setId(long id) {
		this.id = id;
	}
	public void setPrimer_nombre(String primer_nombre) {
		this.primer_nombre = primer_nombre;
	}
	public void setSegundo_nombre(String segundo_nombre) {
		this.segundo_nombre = segundo_nombre;
	}
	public void setPrimer_apellido(String primer_apellido) {
		this.primer_apellido = primer_apellido;
	}
	public void setSegundo_apellido(String segundo_apellido) {
		this.segundo_apellido = segundo_apellido;
	}
	public void setMunicipionacimiento_codigo_municipio(int municipionacimiento_codigo_municipio) {
		this.municipionacimiento_codigo_municipio = municipionacimiento_codigo_municipio;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	@Override
	public String insert() 
	{
		return "INSERT INTO public.personas(\n" + 
				"            id, edad, primer_apellido, primer_nombre, segundo_apellido, segundo_nombre, \n" + 
				"            municipionacimiento_codigo_municipio)\n" + 
				"    VALUES ("+ id + ", "+edad+", '"+ primer_apellido + "','"+primer_nombre+
				"','"+segundo_apellido+"' ,'"+segundo_nombre+"',"+municipionacimiento_codigo_municipio+");";
	}
	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String edit() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String findPk() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}