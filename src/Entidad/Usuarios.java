package Entidad;

public class Usuarios {
	
	private String nombre_usuario;
	private String pass;
	private int tipo;
	private String DNI;
	private String nombre;
	private String apellido;
	
	public Usuarios(String nombre_usuario, String pass, int tipo, String dNI, String nombre, String apellido) {
		
		this.nombre_usuario = nombre_usuario;
		this.pass = pass;
		this.tipo = tipo;
		DNI = dNI;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public Usuarios() {
		
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
}
