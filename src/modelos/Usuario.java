package modelos;

public class Usuario {
	// Atributos
	private String 	usuario,
					password,
					dni,
					apellido,
					nombre,
					domicilio,
					fecha_de_nacimiento,
					email;
	
	private sexos sexo;
	
		private enum sexos {
			MASCULINO, FEMENINO;
		}
		
	private Boolean es_admin,
					esta_habilitado;
	
	// Constructor
	public Usuario(String usuario, String password, Boolean es_admin, Boolean esta_habilitado,
			String dni, String domicilio, String nombre, String apellido, String fecha_de_nacimiento, 
			String email) {
		this.usuario = usuario;
		this.password = password;
		this.es_admin = es_admin;
		this.esta_habilitado = esta_habilitado;
		this.dni = dni;
		this.domicilio = domicilio;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_de_nacimiento = fecha_de_nacimiento;
		//this.sexo = sexo; ???
		this.email = email;
		
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

	public sexos getSexo() {
		return sexo;
	}

	public void setSexo(sexos sexo) {
		this.sexo = sexo;
	}
	
	
}
