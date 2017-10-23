package Controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Modelo.Alumnos;
import Modelo.ModeloPrincipal;
import Vista.VistaAlumnos;
import Vista.VistaCursos;
import javafx.collections.ObservableList;

public class Controlador {

	private ModeloPrincipal modeloPrincipal;
	private VistaAlumnos vistaAlumnos;
	private String cod;
	private VistaCursos misCursos;
	private String codCurso;
	// Alumnos persona = new Persona(nombre, apellido,
	// String.valueOf(decimales.format(mediaNotas)), fola, ssii, prog, ends,
	// lmsgi, bbdd);
	// controladorVP.getPersonas().set(index,persona);

	public void crearTablaAlumnos() {
		
			modeloPrincipal.recogerDatosBBDDAlumnos();
		

	}
	
	public void crearTablaCursos() {
		
		modeloPrincipal.crearTablaCursos();
	

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
					|| this.vistaAlumnos.getComboBoxNacionalidad().replaceAll(" ", "").isEmpty() || this.vistaAlumnos.getComboBoxCurso().replaceAll(" ", "").isEmpty()) {
				this.vistaAlumnos.generarRespuesta("Todos los campos han de estar rellenos.");
			} else {
			
			
			
				this.modeloPrincipal.addAlumnos(this.vistaAlumnos.getTxtNombre(), this.vistaAlumnos.getTxtApellido(),
						this.vistaAlumnos.getTxtDNI(), this.vistaAlumnos.getComboBoxNacionalidad(),this.vistaAlumnos.getTxtTelefono(),this.vistaAlumnos.getComboBoxCurso());
				this.vistaAlumnos.getBtnActualizar().setEnabled(false);
				this.vistaAlumnos.getBtnBorrar().setEnabled(false);
			}
		}

	}
	
	public void addCursos(){
		
			if (this.misCursos.getTxtNombre().replaceAll(" ", "").isEmpty()
					|| this.misCursos.getComboBoxTitulacion().replaceAll(" ", "").isEmpty()
					|| this.misCursos.getDateInicio().replaceAll(" ", "").isEmpty()
					|| this.misCursos.getDateFin().replaceAll(" ", "").isEmpty()) {
				this.misCursos.generarRespuesta("Todos los campos han de estar rellenos.");
			} else {
				System.out.println("FECHA:::::" + this.misCursos.getDateInicio());
			this.modeloPrincipal.addCursos(this.misCursos.getTxtNombre(),
					this.misCursos.getDateInicio(),this.misCursos.getDateFin(), this.misCursos.getComboBoxTitulacion());
				this.misCursos.getBtnActualizar().setEnabled(false);
				this.misCursos.getBtnBorrar().setEnabled(false);
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
					|| this.vistaAlumnos.getComboBoxNacionalidad().replaceAll(" ", "").isEmpty() || this.vistaAlumnos.getComboBoxCurso().replaceAll(" ", "").isEmpty()) {
				this.vistaAlumnos.generarRespuesta("Todos los campos han de estar rellenos.");
			} else {
				this.modeloPrincipal.actualizarDatosAlumnos(cod,this.vistaAlumnos.getTxtNombre(), this.vistaAlumnos.getTxtApellido(),
						this.vistaAlumnos.getTxtDNI(), this.vistaAlumnos.getComboBoxNacionalidad(),
						this.vistaAlumnos.getTxtTelefono(), this.vistaAlumnos.getComboBoxCurso());
				this.vistaAlumnos.getBtnActualizar().setEnabled(false);
				this.vistaAlumnos.getBtnBorrar().setEnabled(false);
			}
		}
		
		
		
		
		
		
		
	}

	public void abrirVentanaCursos() {
		System.out.println("ventanaDos");
		this.misCursos= new VistaCursos();
		this.misCursos.setControlador(this);
		this.setVentanaCursos(this.misCursos);
		this.modeloPrincipal.setVentanaCursos(this.misCursos);
		this.crearTablaCursos();
		this.misCursos.setVisible(true);
		
	}

	private void setVentanaCursos(VistaCursos misCursos) {
		this.misCursos=misCursos;
		
	}

	public void crearComboBoxCursos() {
		this.modeloPrincipal.crearComboBoxCursos();
		
	}

	public void verInformacionCursos() {
		codCurso = String.valueOf(this.misCursos.getTableCursos()
				.getValueAt(this.misCursos.getTableCursos().getSelectedRow(), 0));
		this.misCursos.mostrarDatosCurso(codCurso);

	}

	public void intercambioDatosCursos() {
		modeloPrincipal.intercambioCursos();
		
	}

	public void borrarCursos() {
		modeloPrincipal.borrarCursos(codCurso);
		
	}

}
