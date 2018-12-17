package entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name = "Departamentos")
@Entity
public class Departamento 
{
	@Id
	@Column(nullable=false, name="codigo_departamento")
	private Short codigo;
	
	@Column(length=100,nullable=false,name="nombre_deparamento")
	private String nombre;
	
	public Departamento() {
		// TODO Auto-generated constructor stub
	}

	public Departamento(Short codigo, String nombre) 
	{
		this.codigo = codigo;
		this.nombre = nombre;
	}
	public Departamento(int codigo, String nombre) 
	{
		this(new Short(codigo+""),nombre);
	}
	

	public Short getCodigo() {
		return codigo;
	}

	public void setCodigo(Short codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Departamento other = (Departamento) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return codigo+","+nombre;
	}
	
	
}
