package modelos;

public class Actividad {
	private String  nombre,
					descripcion;
	
	private Boolean esta_habilitada;

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
}
