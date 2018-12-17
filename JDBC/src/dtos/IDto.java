package dtos;

import java.util.List;

public interface IDto
{
	public int insert();
	public int delete();
	public int edit();
	public List findAll();
	public List findPk();
}
