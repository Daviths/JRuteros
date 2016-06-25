package modelos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "rutas", schema = "jruteros")
public class Ruta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Variables
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Integer idruta;
	
	@Column(name = "nombre")
	private String	nombre;
	
	@Column(name = "descripcion")
	private String	descripcion;
	
	@Column(name = "fecha_de_realizacion")
	private String	fecha_de_realizacion;
	
	@Column(name = "dificultad")
	private String	dificultad;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="idactividad")
	private Actividad	idactividad;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="idusuario")
	private Usuario	idusuario;
					
	@Column(name = "es_publica")
	private Boolean es_publica; 
	
	@Column(name = "es_circular")
	private Boolean	es_circular;
	
	@Column(name = "distancia")
	private Float 	distancia;
	
	@Column(name = "tiempo_estimado")
	private Float	tiempo_estimado;
	
	@OneToMany(orphanRemoval = true, mappedBy = "Ruta")
	private List<Foto> fotos;
	
	@OneToMany(orphanRemoval = true, mappedBy = "Ruta")
	private List<Coordenada> coordenadas;


	//Constructores
	public Ruta(){}	
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
	public Integer getIdruta() {
		return idruta;
	}
	public void setIdruta(Integer idruta) {
		this.idruta = idruta;
	}
	public Actividad getIdactividad() {
		return idactividad;
	}
	public void setIdactividad(Actividad idactividad) {
		this.idactividad = idactividad;
	}
	public Usuario getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Usuario idusuario) {
		this.idusuario = idusuario;
	}
	public List<Coordenada> getCoordenadas() {
		return coordenadas;
	}
	public void setCoordenadas(List<Coordenada> coordenadas) {
		this.coordenadas = coordenadas;
	}

}
