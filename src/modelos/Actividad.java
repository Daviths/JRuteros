package modelos;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Actividad {
	//Variables
	private String  nombre,
					descripcion;	
	private Boolean esta_habilitada;
	private Integer id;
	
	//Constructores
	public Actividad(){
		this.esta_habilitada=true;
	}
	public Actividad(ResultSet rs) throws SQLException{
		this.id=rs.getInt(1);
		this.nombre=rs.getString(2);
		this.descripcion=rs.getString(3);
		this.esta_habilitada=rs.getBoolean(4);		
	}
	//Metodos
	public Boolean getEsta_habilitada() {
		return esta_habilitada;
	}

	public void setEsta_habilitada(Boolean esta_habilitada) {
		this.esta_habilitada = esta_habilitada;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
