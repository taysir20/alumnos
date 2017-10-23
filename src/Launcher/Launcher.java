package Launcher;

import Controlador.Controlador;
import Modelo.ModeloPrincipal;
import Modelo.ModeloSQL;
import Vista.VistaAlumnos;


public class Launcher {

	public static void main(String[] args) {
		VistaAlumnos vistaAlumnos = new VistaAlumnos();
		ModeloPrincipal modeloPrincipal = new ModeloPrincipal();
		Controlador controlador = new Controlador();
		ModeloSQL modeloSQL= new ModeloSQL();
		vistaAlumnos.setControlador(controlador);
		//vistaAlumnos.setModeloPrincipal(modeloPrincipal); No lo va a conocer
		controlador.setVistaPrincipal(vistaAlumnos);
		controlador.setModeloPrincipal(modeloPrincipal);
		modeloPrincipal.setVistaPrincipal(vistaAlumnos);
		modeloPrincipal.NuevoDato(vistaAlumnos.tipoDeDatos());
		controlador.conexionDatos();
		modeloPrincipal.recogerDatosBBDDCursos();
		controlador.crearComboBoxCursos();
		controlador.crearTablaAlumnos();
		vistaAlumnos.setVisible(true);
	

	}
	
	

}
