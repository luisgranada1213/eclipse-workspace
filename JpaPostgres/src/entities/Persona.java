package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "Persona" database table.
 * 
 */
@Entity
@Table(name="Persona")
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id" ,nullable = false)
	private long identificacion;
	@Column(nullable=false, length=25,name ="Primer_Nombre")
	private String primerNombre;
	@Column(nullable=false, length=25,name ="Segundo_Nombre")
	private String segundoNombre;
	@Column(nullable=false, length=25,name ="Primer_Apellido")
	private String primerApellido;
	@Column(nullable=false, length=25,name ="Segundo_Apellido")
	private String segundoApellido;
	@ManyToOne(targetEntity=Municipio.class)
	private Municipio municipioNacimiento;

	//Constructores
	public Persona(long identificion, String primerNombre, String segundoNombre, String primerApellido,
			String segundoApellido, Municipio municipioNacimiento) 
	{
		this.identificacion = identificion;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.municipioNacimiento = municipioNacimiento;
	}

	public Persona() 
	{
		
	}
	//Metodos set
	public void identificacion(long identificacion) 
	{
		this.identificacion = identificacion;
	}

	public void setPrimerNombre(String primerNombre) 
	{
		this.primerNombre = primerNombre;
	}

	public void setSegundoNombre(String segundoNombre) 
	{
		this.segundoNombre = segundoNombre;
	}

	public void setPrimerApellido(String primerApellido) 
	{
		this.primerApellido = primerApellido;
	}

	public void setSegundoApellido(String segundoApellido) 
	{
		this.segundoApellido = segundoApellido;
	}

	public void setMunicipioNacimiento(Municipio municipioNacimiento) 
	{
		this.municipioNacimiento = municipioNacimiento;
	}
	

}