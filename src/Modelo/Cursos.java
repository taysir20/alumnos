package Modelo;

import java.util.HashMap;

public class Cursos {
	private int id;
	private String curso;
	private String fechaInicio;
	private String fechaFin;
	private String titulacion;
	
	
	public Cursos() {
		super();
	}

	public Cursos(int id, String curso, String fechaInicio, String fechaFin, String titulacion) {
		this.id = id;
		this.curso = curso;
		this.fechaInicio= fechaInicio;
		this.fechaFin= fechaFin;
		this.titulacion = titulacion;
	}
	
	public Cursos(String curso, String fechaInicio, String fechaFin, String titulacion) {
		this.curso = curso;
		this.fechaInicio= fechaInicio;
		this.fechaFin= fechaFin;
		this.titulacion = titulacion;
	}
	
	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	public String toString(){
		String aux="";
		aux+=this.id + " " + this.curso;
		return aux;
	}
	
}
