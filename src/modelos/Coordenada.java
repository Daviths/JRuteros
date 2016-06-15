package modelos;

import javax.persistence.*;

@Entity
@Table(name = "coordenadas")
public class Coordenada {
	//variables
	@Id @GeneratedValue
	@Column(name = "id")
	private Integer id;	
	
	@Column(name = "x")
	private Float x;
	
	@Column(name = "y")
	private Float y;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="ruta_id")
	private Ruta Ruta;
	
	//Constructor
	public Coordenada(){}
	
	//metodos
	public Float getX() {
		return x;
	}
	public void setX(Float x) {
		this.x = x;
	}
	public Float getY() {
		return y;
	}
	public void setY(Float y) {
		this.y = y;
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
