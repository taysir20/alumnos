package Controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Entidad.Alumnos;
import Modelo.ModeloPrincipal;
import Vista.VistaAlumnos;
import javafx.collections.ObservableList;

public class Controlador {

	private ModeloPrincipal modeloPrincipal;
	private VistaAlumnos vistaAlumnos;
	// Alumnos persona = new Persona(nombre, apellido,
	// String.valueOf(decimales.format(mediaNotas)), fola, ssii, prog, ends,
	// lmsgi, bbdd);
	// controladorVP.getPersonas().set(index,persona);

	public void crearTablaAlumnos() {
		
		ArrayList<Alumnos> resultados = modeloPrincipal.recogerDatosBBDD();
		//
		
		
		
		
		
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		model.addColumn("COD");
		model.addColumn("DNI");
		model.addColumn("NOMBRE");
		model.addColumn("APELLIDO");
		model.addColumn("NACIONALIDAD");
		model.addColumn("TELEFONO");

		for (int i = 0; i < resultados.size(); i++) {
			model.addRow(new String[] { String.valueOf(resultados.get(i).getCod()), resultados.get(i).getDni(),
					resultados.get(i).getNombre(), resultados.get(i).getApellido(), resultados.get(i).getNacionalidad(),
					String.valueOf(resultados.get(i).getTelefono()) });
		}

		this.vistaAlumnos.getTableAlumnos().setModel(model);

	}

	

	

	public void getBBDD() {
		modeloPrincipal.getBBDD();

	}

	public void setVistaPrincipal(VistaAlumnos vistaAlumnos) {
		this.vistaAlumnos = vistaAlumnos;

	}

	public void setModeloPrincipal(ModeloPrincipal modeloPrincipal) {
		this.modeloPrincipal = modeloPrincipal;

	}





	public String tipoDeBBDD() {
		String[] tipoBBDD = { "SQL", "FICHEROS", };
		return (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de acceso a datos", "Tipo",
				JOptionPane.DEFAULT_OPTION, null, tipoBBDD, tipoBBDD[0]); //pro defecto nos conecta a SQL
		
	}
}
