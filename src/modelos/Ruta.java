package modelos;

public class Ruta {
	private String	nombre,
					descripcion,
					fecha_de_realizacion;
					
	private Boolean es_publica, 
					es_circular;
	
	private Float 	distancia,
					tiempo_estimado;
	
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

	public dificultades getDificultad() {
		return dificultad;
	}

	public void setDificultad(dificultades dificultad) {
		this.dificultad = dificultad;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	private dificultades dificultad;
	
		private enum dificultades {
			FACIL, MODERADO, DIFICIL, MUY_DIFICIL, SOLO_EXPERTOS;
		}
	
	private Actividad actividad;
	
	// FALTA RECORRIDO
	// FALTAN FOTOS
	// PREGUNTAR BORRADO LOGICO
}
