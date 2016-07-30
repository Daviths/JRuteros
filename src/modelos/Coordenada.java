package modelos;

import javax.persistence.*;

@Entity
@Table(name = "coordenadas")
public class Coordenada {
	
	// Variables
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;	
	
	@Column(name = "x")
	private Double x;
	
	@Column(name = "y")
	private Double y;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="ruta", referencedColumnName = "id", table = "coordenadas", unique = true)
	private Ruta ruta;
	
	// Constructores
	public Coordenada() {
		
	}
	
	public Coordenada(Double x, Double y) {
		setX(x);
		setY(y);
	}
	
	// Métodos
	public Double getX() {
		return x;
	}
	
	public void setX(Double x) {
		this.x = x;
	}
	
	public Double getY() {
		return y;
	}
	
	public void setY(Double y) {
		this.y = y;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Ruta getRuta() {
		return ruta;
	}

	public void setRuta(Ruta r) {
		ruta = r;
	}
	
}
