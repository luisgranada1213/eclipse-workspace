package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Municipios")
public class Municipio 
{
	@Id
	@Column(nullable=false, name="Codigo_Municipio")
	private int codigoMunicipio;
	
	@Column(nullable=false, length=50,name ="Nombre_Municipio")
	private String nombreMunicipio;
	
	@ManyToOne(targetEntity=Departamento.class)
	private Departamento dep;
	
	public Municipio() {
		// TODO Auto-generated constructor stub
	}

	public Municipio(int codigoMunicipio, String nombreMunicipio, Departamento departamento) {
		
		this.codigoMunicipio = codigoMunicipio;
		this.nombreMunicipio = nombreMunicipio;
		this.dep = departamento;
	}

	public int getCodigoMunicipio() {
		return codigoMunicipio;
	}

	public void setCodigoMunicipio(int codigoMunicipio) {
		this.codigoMunicipio = codigoMunicipio;
	}

	public String getNombreMunicipio() {
		return nombreMunicipio;
	}

	public void setNombreMunicipio(String nombreMunicipio) {
		this.nombreMunicipio = nombreMunicipio;
	}

	public Departamento getDepartamento() {
		return dep;
	}

	public void setDepartamento(Departamento departamento) {
		this.dep = departamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigoMunicipio;
		result = prime * result + ((dep == null) ? 0 : dep.hashCode());
		result = prime * result + ((nombreMunicipio == null) ? 0 : nombreMunicipio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Municipio other = (Municipio) obj;
		if (codigoMunicipio != other.codigoMunicipio)
			return false;
		if (dep == null) {
			if (other.dep != null)
				return false;
		} else if (!dep.equals(other.dep))
			return false;
		if (nombreMunicipio == null) {
			if (other.nombreMunicipio != null)
				return false;
		} else if (!nombreMunicipio.equals(other.nombreMunicipio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return codigoMunicipio+","+nombreMunicipio+","+dep.getCodigo();
	}
	
	

}
