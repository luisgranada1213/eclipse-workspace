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
	private long identificion;
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

	public Persona() 
	{
		
	}

	public Persona(long identificion, String primerNombre, String segundoNombre, String primerApellido,
			String segundoApellido, int codigoMunicipio, int codigoDepartamento) 
	{
		this.identificion = identificion;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		Departamento departamento= new Departamento(codigoDepartamento, null);
		Municipio m=new Municipio(codigoMunicipio, null, departamento);
		this.municipioNacimiento=m;
	}

	//metodos set
	public long getIdentificion() {
		return identificion;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public Municipio getMunicipioNacimiento() {
		return municipioNacimiento;
	}

}