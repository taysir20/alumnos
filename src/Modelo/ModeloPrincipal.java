package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import Vista.VistaAlumnos;
import Modelo.ModeloSQL;
import Modelo.ModeloFicheros;

public class ModeloPrincipal {

	private VistaAlumnos vistaAlumnos;
	private InterfaceAccesoDatos modelo; // atributo de interface que usamos para poder llamar a los métodos de la interface
	private Alumnos alumno;
	ArrayList<Alumnos> resultados;
	
	public void conexionDatos() { // preguntamos si es null 
			if(modelo.AccesoBBDD().equals("error")){
				this.vistaAlumnos.generarRespuesta("No se ha podido establecer conexión con la fuente de datos");
			}

		
	}
	public void setVistaPrincipal(VistaAlumnos vistaAlumnos) {
		this.vistaAlumnos=vistaAlumnos;
		
	}


	public void recogerDatosBBDD() {
		resultados = this.modelo.recogerDatosBBDD();
		this.vistaAlumnos.crearTablaAlumnos(resultados);			
	}

	public void NuevoDato(String tipoDeDato) {
		if(tipoDeDato.equalsIgnoreCase("SQL")){
			modelo=new ModeloSQL();
		}else if(tipoDeDato.equalsIgnoreCase("FICHEROS")){
			modelo=new ModeloFicheros();
		}
	}
	
	public void addAlumnos(String txtNombre, String txtApellido, String txtDNI, String comboBoxNacionalidad,
			int txtTelefono) {
		alumno= new Alumnos(txtNombre,txtApellido,txtDNI,comboBoxNacionalidad,txtTelefono);
		if(modelo.addUnAlumno(alumno)==1){
			this.vistaAlumnos.generarRespuesta("Nuevo registro almacenado satisfactoriamente.");
			this.recogerDatosBBDD();
		}else{
			this.vistaAlumnos.generarRespuesta("Ya existe un registro con este DNI.");
		}

		
		
	}
	public void enviarMensajeError(String mensaje) {
		this.vistaAlumnos.generarRespuesta(mensaje);
	
	}
	public void actualizarTablaAlumnos(ArrayList<Alumnos> arrayListAlumnos) {
		this.vistaAlumnos.actualizarTablaAlumnos(arrayListAlumnos); // volvemos a llamar a recoger Datos de la bbdd y lo pasamos por parametro a actualziar tabla
		
	}
	public void borrarAlumnos(String cod) {
		if(modelo.deleteAlumno(cod)==1){
			this.recogerDatosBBDD();
			this.vistaAlumnos.generarRespuesta("Registro borrado satisfactoriamente");
		}else{
			this.vistaAlumnos.generarRespuesta("No se ha podido borrar el registro");
		}
		
	}
	public void borrarTodosAlumnos() {
		if(modelo.deleteAllAlumnos()>0){
			this.recogerDatosBBDD();
			this.vistaAlumnos.generarRespuesta("Todos los registros han sido borrados satisfactoriamente.");
		}else{
			this.vistaAlumnos.generarRespuesta("No se ha podido borrar los registros");
		}
		
		
		
	}
	

	

	

}
