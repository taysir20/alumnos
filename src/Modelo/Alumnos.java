package Modelo;

public class Alumnos {
	private int cod;
	private String nombre;
	private String apellido;
	private String dni;
	private String nacionalidad;
	private int telefono;
	private Cursos curso;
	private int id_Curso;
	
	

	public Alumnos() {
		super();
	}

	public Alumnos(int cod, String nombre, String apellido, String dni, String nacionalidad, int telefono,
			Cursos curso, int id_Curso) {
		super();
		this.cod = cod;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.curso = curso;
		this.id_Curso= id_Curso;
	}

	public Alumnos(int cod, String nombre, String apellido, String dni, String nacionalidad, int telefono, int id_Curso) {
		this.cod = cod;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.id_Curso= id_Curso;
	}
	
	
	
	public Alumnos(String txtNombre, String txtApellido, String txtDNI, String comboBoxNacionalidad, int txtTelefono,
			Cursos cursos, int id_curso) {
		this.nombre = txtNombre;
		this.apellido = txtApellido;
		this.dni = txtDNI;
		this.nacionalidad = comboBoxNacionalidad;
		this.telefono = txtTelefono;
		this.curso=cursos;
		this.id_Curso= id_curso;
		
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
	
	public Cursos getCurso() {
		return curso;
	}

	public void setCurso(Cursos curso) {
		this.curso = curso;
	}

	public int getId_Curso() {
		return id_Curso;
	}

	public void setId_Curso(int id_Curso) {
		this.id_Curso = id_Curso;
	}
	
	
	public String toString(){
		String aux="";
		aux+=this.dni + " " + this.nombre;
		return aux;
	}

}
