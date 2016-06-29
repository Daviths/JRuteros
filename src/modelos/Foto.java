package modelos;
import javax.persistence.*;

@Entity
@Table(name = "fotos")
public class Foto {
	// Atributos
	@Id
	@GeneratedValue()
	@Column(name = "id")
	private int id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "contenido")
	private String contenido;
	/*
	@ManyToOne(optional = false)
	@JoinColumn(name="ruta_id")
	private Ruta Ruta;
	*/
	// Contructor
	public Foto() {
		
	}
	
	public Foto(String nombre, String tipo, String contenido) {
		setNombre(nombre);
		setTipo(tipo);
		setContenido(contenido);
	}
	
	// Metodos
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
}
