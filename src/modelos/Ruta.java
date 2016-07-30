package modelos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "rutas")
public class Ruta implements Serializable {
	private static final long serialVersionUID = 1L;

	// Variables
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "fecha_de_realizacion")
	private String fecha_de_realizacion;
	
	@Column(name = "dificultad")
	private String dificultad;

	@ManyToOne(optional = false)
	@JoinColumn(name="idactividad")
	private Actividad actividad;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="idusuario")
	private Usuario	usuario;

	@Column(name = "es_publica")
	private Boolean es_publica; 
	
	@Column(name = "es_circular")
	private Boolean	es_circular;
	
	@Column(name = "distancia")
	private Double distancia;
	
	@Column(name = "tiempo_estimado")
	private Double tiempo_estimado;
	
	@OneToMany(orphanRemoval = true, mappedBy = "ruta")
	//@OneToMany(targetEntity = Foto.class, cascade = CascadeType.ALL)
	private List<Foto> fotos;
	
	@OneToMany(orphanRemoval = true, mappedBy = "ruta")
	//@OneToMany(targetEntity = Coordenada.class, cascade = CascadeType.ALL)
	private List<Coordenada> coordenadas;

	// Constructores
	public Ruta() {
		
	}	
	
	public Ruta(String nombre, String descripcion, String fecha_de_realizacion,
					String dificultad, Boolean es_publica, Boolean es_circular,
					Double distancia, Double tiempo_estimado) {
		
		setNombre(nombre);
		setDescripcion(descripcion);
		setFecha_de_realizacion(fecha_de_realizacion);
		setDificultad(dificultad);
		setEs_publica(es_publica);		
		setEs_circular(es_circular);
		setDistancia(distancia);
		setTiempo_estimado(tiempo_estimado);
	}

	// Metodos
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

	public Double getDistancia() {
		return distancia;
	}

	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}

	public Double getTiempo_estimado() {
		return tiempo_estimado;
	}

	public void setTiempo_estimado(Double tiempo_estimado) {
		this.tiempo_estimado = tiempo_estimado;
	}	
	public String getDificultad() {
		return dificultad;
	}
	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}

	public List<Foto> getFotos() {
		return fotos;
	}
	
	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public Actividad getActividad() {
		return actividad;
	}
	
	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Coordenada> getCoordenadas() {
		return coordenadas;
	}
	
	public void setCoordenadas(List<Coordenada> coordenadas) {
		this.coordenadas = coordenadas;
	}
}
