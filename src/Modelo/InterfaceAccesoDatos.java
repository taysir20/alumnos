package Modelo;

import java.util.ArrayList;

public interface InterfaceAccesoDatos {
	public ArrayList recogerDatosBBDDAlumnos();
	public ArrayList recogerDatosBBDDCursos();
	public String AccesoBBDD();
	public int addUnAlumno(Alumnos alumno);
	public int addUnCurso(Cursos curso);
	public int deleteAlumno(String cod);
	public int deleteCurso(String codCursos);
	public int deleteAllAlumnos();
	public int deleteAllCursos();
	public int actualizarJugadores(String cod,Alumnos alumno);
	public ArrayList<Cursos> getResultados2();
}
