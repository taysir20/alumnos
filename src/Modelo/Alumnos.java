package Modelo;

public class Alumnos {
	private int cod;
	private String nombre;
	private String apellido;
	private String dni;
	private String nacionalidad;
	private int telefono;

	public Alumnos(int cod, String nombre, String apellido, String dni, String nacionalidad, int telefono) {
		super();
		this.cod = cod;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
	}
	
	public Alumnos(String nombre, String apellido, String dni, String nacionalidad, int telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
	}
	
	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

}
