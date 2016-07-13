package modelos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "actividades")
public class Actividad implements Serializable {
	
	private static final long serialVersionUID = 1L;

	// Variables
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "nombre")
	private String  nombre;
	
	@Column(name = "descripcion")
	private String	descripcion;
	
	@Column(name = "esta_habilitada")
	private Boolean esta_habilitada;	
	
	//@OneToMany(orphanRemoval = true, mappedBy = "id")
	@OneToMany(targetEntity = Ruta.class, cascade = CascadeType.ALL)
	private List<Ruta> rutas;
	
	// Constructores	
	public Actividad(){
		
	}
	
	public Actividad(String nombre, String descripcion, Boolean habilitada) {
		setNombre(nombre);
		setDescripcion(descripcion);
		setEsta_habilitada(habilitada);
	}
	
	// Métodos
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public List<Ruta> getRutas() {
		return rutas;
	}

	public void setRutas(List<Ruta> rutas) {
		this.rutas = rutas;
	}
	
}
