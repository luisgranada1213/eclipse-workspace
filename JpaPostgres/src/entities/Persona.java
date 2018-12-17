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
	private Long identificion;

	private String apellido;

	private String nombre;

	public Persona() {
	}

	public Long getIdentificion() {
		return this.identificion;
	}

	public void setIdentificion(Long identificion) {
		this.identificion = identificion;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}