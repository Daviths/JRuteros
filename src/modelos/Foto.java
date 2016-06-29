package modelos;
import javax.persistence.*;

@Entity
@Table(name = "fotos")
public class Foto {
	//variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idfotos")
	private Integer id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "contenido")
	private String contenido;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="ruta_id")
	private Ruta Ruta;
	
	//Contructor
	public Foto(){}
	
	//metodos
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
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
