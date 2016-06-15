package modelos;

import javax.persistence.*;

@Entity
@Table(name = "puntajes")
public class Puntaje {
	//Variables
	@Id @GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "puntos")
	private Integer puntos;
	
	@Column(name = "fecha")
	private String fecha;
	
	@OneToOne(optional = true, mappedBy="puntaje")
	private Ruta Ruta;
	
	//Contructor
	public Puntaje(){}
	
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Ruta getRuta() {
		return Ruta;
	}

	public void setRuta(Ruta ruta) {
		Ruta = ruta;
	}
}
