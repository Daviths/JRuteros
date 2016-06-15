package modelos;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "rutas")
public class Ruta {
	//Variables
	@Id @GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nombre")
	private String	nombre;
	
	@Column(name = "descripcion")
	private String	descripcion;
	
	@Column(name = "fecha_de_realizacion")
	private String	fecha_de_realizacion;
	
	@Column(name = "dificultad")
	private String	dificultad;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="actividad_id")
	private String	actividad;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="usuario_id")
	private String	usuario;
					
	@Column(name = "es_publica")
	private Boolean es_publica; 
	
	@Column(name = "es_circular")
	private Boolean	es_circular;
	
	@Column(name = "distancia")
	private Float 	distancia;
	
	@Column(name = "tiempo_estimado")
	private Float	tiempo_estimado;
	
	@OneToMany(mappedBy="ruta")
	private List<Foto> fotos;
	
	@OneToMany(mappedBy="ruta")
	private List<Coordenada> coordenadas;


	//Constructores
	public Ruta(){}	
	//Metodos
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public List<Foto> getFotos() {
		return fotos;
	}
	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}
	public List<Coordenada> getCoordenadas() {
		return coordenadas;
	}
	public void setCoordenadas(List<Coordenada> coordenadas) {
		this.coordenadas = coordenadas;
	}

}
