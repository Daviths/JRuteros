package modelos;

import javax.persistence.*;

@Entity
@Table(name = "puntajes")
public class Puntaje {
	
	// Atributos
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "puntos")
	private Integer puntos;
	
	@Column(name = "fecha")
	private String fecha;

	@OneToOne(optional = true)
	private Ruta Ruta;
	
	@OneToOne(optional = true)
	private Usuario Usuario;

	// Contructores
	public Puntaje() {
		
	}
	
	public Puntaje(Integer puntos, String fecha) {
		setPuntos(puntos);
		setFecha(fecha);
	}
	
	//Metodos
	public Integer getPuntos() {
		return puntos;
	}
	
	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	/*
	public Ruta getRuta() {
		return Ruta;
	}

	public void setRuta(Ruta ruta) {
		Ruta = ruta;
	}
	*/

	public Ruta getRuta() {
		return Ruta;
	}

	public void setRuta(Ruta ruta) {
		Ruta = ruta;
	}

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}
}
