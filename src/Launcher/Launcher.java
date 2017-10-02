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
		vistaAlumnos.setModeloPrincipal(modeloPrincipal);
		controlador.setVistaPrincipal(vistaAlumnos);
		controlador.setModeloPrincipal(modeloPrincipal);
		modeloPrincipal.setVistaPrincipal(vistaAlumnos);
		modeloPrincipal.NewBBDD(controlador.tipoDeBBDD());
		controlador.getBBDD();
		controlador.crearTablaAlumnos();
		vistaAlumnos.setVisible(true);
		
//		vistaAlumnos.setControlador(controlador);
//		vistaAlumnos.setModelo(modelo);
//		controlador.setVista(vistaAlumnos);
//		modelo.setVista(vistaAlumnos);	
//		vistaAlumnos.setVisible(true);

	}

}
