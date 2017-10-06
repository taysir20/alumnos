package Controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Modelo.Alumnos;
import Modelo.ModeloPrincipal;
import Vista.VistaAlumnos;
import javafx.collections.ObservableList;

public class Controlador {

	private ModeloPrincipal modeloPrincipal;
	private VistaAlumnos vistaAlumnos;
	private String cod;
	// Alumnos persona = new Persona(nombre, apellido,
	// String.valueOf(decimales.format(mediaNotas)), fola, ssii, prog, ends,
	// lmsgi, bbdd);
	// controladorVP.getPersonas().set(index,persona);

	public void crearTablaAlumnos() {

		modeloPrincipal.recogerDatosBBDD();

	}

	public void conexionDatos() {
		modeloPrincipal.conexionDatos();

	}

	public void setVistaPrincipal(VistaAlumnos vistaAlumnos) {
		this.vistaAlumnos = vistaAlumnos;

	}

	public void setModeloPrincipal(ModeloPrincipal modeloPrincipal) {
		this.modeloPrincipal = modeloPrincipal;

	}

	

	public void addAlumnos() {
		if (this.vistaAlumnos.getTxtTelefono() != -1) {
			if (this.vistaAlumnos.getTxtNombre().replaceAll(" ", "").isEmpty()
					|| this.vistaAlumnos.getTxtApellido().replaceAll(" ", "").isEmpty()
					|| this.vistaAlumnos.getTxtDNI().replaceAll(" ", "").isEmpty()
					|| this.vistaAlumnos.getComboBoxNacionalidad().replaceAll(" ", "").isEmpty()) {
				this.vistaAlumnos.generarRespuesta("Todos los campos han de estar rellenos.");
			} else {
				this.modeloPrincipal.addAlumnos(this.vistaAlumnos.getTxtNombre(), this.vistaAlumnos.getTxtApellido(),
						this.vistaAlumnos.getTxtDNI(), this.vistaAlumnos.getComboBoxNacionalidad(),
						this.vistaAlumnos.getTxtTelefono());
				this.vistaAlumnos.getBtnActualizar().setEnabled(false);
				this.vistaAlumnos.getBtnBorrar().setEnabled(false);
			}
		}

	}

	public void verInformacionRegistroSeleccionado() {
		cod = String.valueOf(this.vistaAlumnos.getTableAlumnos()
				.getValueAt(this.vistaAlumnos.getTableAlumnos().getSelectedRow(), 0));
		this.vistaAlumnos.mostrarDatosAlumno(cod);

	}

	public void borrarAlumnos() {
		modeloPrincipal.borrarAlumnos(cod);

	}

	public void borrarTodosAlumnos() {
		modeloPrincipal.borrarTodosAlumnos();

	}

	public void intercambioDatos() {
		modeloPrincipal.intercambioDatos();
		
		
		
	}

	public void recogerDatosCualquierFicheroAbbdd(String ruta) {
		System.out.println("entra al controlador");
		//modeloPrincipal.recogerDatosCualquierFichero(ruta);
		
	}

	public void actualizarDatosAlumnos() {
		if (this.vistaAlumnos.getTxtTelefono() != -1) {
			if (this.vistaAlumnos.getTxtNombre().replaceAll(" ", "").isEmpty()
					|| this.vistaAlumnos.getTxtApellido().replaceAll(" ", "").isEmpty()
					|| this.vistaAlumnos.getTxtDNI().replaceAll(" ", "").isEmpty()
					|| this.vistaAlumnos.getComboBoxNacionalidad().replaceAll(" ", "").isEmpty()) {
				this.vistaAlumnos.generarRespuesta("Todos los campos han de estar rellenos.");
			} else {
				this.modeloPrincipal.actualizarDatosAlumnos(cod,this.vistaAlumnos.getTxtNombre(), this.vistaAlumnos.getTxtApellido(),
						this.vistaAlumnos.getTxtDNI(), this.vistaAlumnos.getComboBoxNacionalidad(),
						this.vistaAlumnos.getTxtTelefono());
				this.vistaAlumnos.getBtnActualizar().setEnabled(false);
				this.vistaAlumnos.getBtnBorrar().setEnabled(false);
			}
		}
		
		
		
		
		
		
		
	}

}
