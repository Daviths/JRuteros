package modelos;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Ruta {
	//Variables
	private Integer id;
	private String	nombre,
					descripcion,
					fecha_de_realizacion,
					dificultad,
					actividad,
				  	usuario;
					
	private Boolean es_publica, 
					es_circular;
	
	private Float 	distancia,
					tiempo_estimado;
	
	//Constructores
	public Ruta(){
		
	}
	public Ruta(ResultSet rs) throws SQLException{
		this.id = rs.getInt(1);
		this.nombre = rs.getString(2);
		this.descripcion = rs.getString(3);
		this.fecha_de_realizacion = rs.getString(4);
		this.es_publica = rs.getBoolean(5);
		this.es_circular = rs.getBoolean(6);
		this.distancia = rs.getFloat(7);
		this.tiempo_estimado = rs.getFloat(8);
		this.actividad = rs.getString(9);		
		this.dificultad = rs.getString(10);
		this.usuario = rs.getString(11);
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	//Metodos
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

	public String getFecha_de_realizacion() {
		return fecha_de_realizacion;
	}

	public void setFecha_de_realizacion(String fecha_de_realizacion) {
		this.fecha_de_realizacion = fecha_de_realizacion;
	}

	public Boolean getEs_publica() {
		return es_publica;
	}

	public void setEs_publica(Boolean es_publica) {
		this.es_publica = es_publica;
	}

	public Boolean getEs_circular() {
		return es_circular;
	}

	public void setEs_circular(Boolean es_circular) {
		this.es_circular = es_circular;
	}

	public Float getDistancia() {
		return distancia;
	}

	public void setDistancia(Float distancia) {
		this.distancia = distancia;
	}

	public Float getTiempo_estimado() {
		return tiempo_estimado;
	}

	public void setTiempo_estimado(Float tiempo_estimado) {
		this.tiempo_estimado = tiempo_estimado;
	}	
	// FALTA RECORRIDO
	// FALTAN FOTOS
	// PREGUNTAR BORRADO LOGICO
	public String getDificultad() {
		return dificultad;
	}
	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}
	public String getActividad() {
		return actividad;
	}
	public void setActividad(String actividad) {
		this.actividad = actividad;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
