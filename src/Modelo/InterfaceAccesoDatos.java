package Modelo;

import java.util.ArrayList;

public interface InterfaceAccesoDatos {
	public ArrayList<Alumnos> recogerDatosBBDD();
	public String AccesoBBDD();
	public int addUnAlumno(Alumnos alumno);
	public int deleteAlumno(String cod);
	public int deleteAllAlumnos();
}
