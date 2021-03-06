package modelos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	// Atributos
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "usuario")
	private String 	usuario;
	
	@Column(name = "password")
	private String	password;
	
	@Column(name = "dni")
	private String	dni;
	
	@Column(name = "apellido")
	private String	apellido;
	
	@Column(name = "nombre")
	private String	nombre;
	
	@Column(name = "domicilio")
	private String	domicilio;
	
	@Column(name = "sexo")
	private String	sexo;
	
	@Column(name = "fecha_de_nacimiento")
	private String	fecha_de_nacimiento;
	
	@Column(name = "email")
	private String	email;
	
	@Column(name = "es_admin")
	private Boolean es_admin;
	
	@Column(name = "esta_habilitado")
	private Boolean	esta_habilitado;	
	
	@OneToMany(mappedBy="usuario", orphanRemoval = true)
	//@OneToMany(targetEntity = Ruta.class, cascade = CascadeType.ALL)
	private List<Ruta> rutas;
	
	// Constructores
	public Usuario() {
		
	}
	
	public Usuario(String usuario, String password, String dni,
			String apellido, String nombre, String domicilio,
			String sexo, String fecha_de_nacimiento, String email,
			Boolean es_admin, Boolean esta_habilitado) {
		setUsuario(usuario);
		setPassword(password);
		setDni(dni);
		setApellido(apellido);
		setNombre(nombre);
		setDomicilio(domicilio);
		setSexo(sexo);
		setFecha_de_nacimiento(fecha_de_nacimiento);
		setEmail(email);
		setEs_admin(es_admin);
		setEsta_habilitado(esta_habilitado);
	}

	// Metodos
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	

	public Boolean getEsta_habilitado() {
		return esta_habilitado;
	}

	public void setEsta_habilitado(Boolean esta_habilitado) {
		this.esta_habilitado = esta_habilitado;
	}

	public Boolean getEs_admin() {
		return es_admin;
	}

	public void setEs_admin(Boolean es_admin) {
		this.es_admin = es_admin;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getFecha_de_nacimiento() {
		return fecha_de_nacimiento;
	}

	public void setFecha_de_nacimiento(String fecha_de_nacimiento) {
		this.fecha_de_nacimiento = fecha_de_nacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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
