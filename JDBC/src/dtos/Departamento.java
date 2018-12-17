package dtos;

import java.util.List;

public class Departamento implements IDto
{
	private Short codigo;
	
	private String nombre;
	
	public Departamento() 
	{
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
	

	public Short getCodigo() 
	{
		return codigo;
	}

	public void setCodigo(Short codigo) 
	{
		this.codigo = codigo;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
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
	public String toString()
	{
		return codigo+","+nombre;
	}

	@Override
	public int insert() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int edit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findPk() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
