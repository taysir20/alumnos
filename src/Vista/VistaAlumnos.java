package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Controlador.Controlador;
import Modelo.Alumnos;
import Modelo.ModeloPrincipal;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VistaAlumnos extends JFrame {

	private Controlador controlador;
	private ModeloPrincipal modeloPrincipal;
	
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtDNI;
	private JTextField txtTelefono;
	private JTextField txtApellido;
	private JComboBox comboBoxNacionalidad;
	private JButton btnActualizar;
	private JButton btnBorrar;
	private JButton btnAnadir;
	private JButton btnBorrarTodo;
	private JButton btnCopiarFichero;
	private JButton btnSubirFichero;
	private JTable tableAlumnos;
	private ArrayList<Alumnos> resultados;
	private JTextField txtBuscadorDni;
	private TableRowSorter trsfiltro;


	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAlumnos frame = new VistaAlumnos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaAlumnos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 602);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel label = new JLabel("ALUMNOS");
		label.setFont(new Font("Tahoma", Font.PLAIN, 32));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label_1 = new JLabel("A\u00D1ADIR ALUMNO:");
		
		JLabel label_2 = new JLabel("Apellido:");
		
		JLabel label_3 = new JLabel("Nombre:");
		
		JLabel label_4 = new JLabel("DNI:");
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		JLabel label_5 = new JLabel("Nacionalidad:");
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		
		JLabel label_6 = new JLabel("Tel\u00E9fono:");
		
		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		
		comboBoxNacionalidad = new JComboBox();
		comboBoxNacionalidad.setModel(new DefaultComboBoxModel(new String[] {"ESPA\u00D1OLA", "OTRO"}));
		
		btnAnadir = new JButton("A\u00D1ADIR");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.addAlumnos();
			}
		});
		
		btnBorrar = new JButton("BORRAR");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.borrarAlumnos();
				btnActualizar.setEnabled(false);
				btnBorrar.setEnabled(false);
			}
		});
		btnBorrar.setEnabled(false);
		
		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.actualizarDatosAlumnos();
			}
		});
		btnActualizar.setEnabled(false);
		
		btnSubirFichero = new JButton("VOLCAR DATOS DE CUALQUIER FICHERO A UNA BBDD");
		btnSubirFichero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				escogerFichero();
			}
		});
		
		btnBorrarTodo = new JButton("BORRAR TODO");
		btnBorrarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.borrarTodosAlumnos();
			}
		});
		
		btnCopiarFichero = new JButton("VOLCAR DATOS");
		btnCopiarFichero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.intercambioDatos();
			}
		});
		
		txtBuscadorDni = new JTextField();
		txtBuscadorDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String cadena = (txtBuscadorDni.getText());
				txtBuscadorDni.setText(cadena);
    			repaint();
    			filtro();
    			}
    			});
    			
		
		
		txtBuscadorDni.setColumns(10);
		
		JLabel lblBuscarPorDni = new JLabel("BUSCAR POR DNI");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
								.addComponent(label_1)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(label_2, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
										.addComponent(label_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(label_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(10)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
										.addComponent(txtDNI, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(txtTelefono, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
										.addComponent(comboBoxNacionalidad, 0, 299, Short.MAX_VALUE)))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(btnAnadir)
									.addGap(18)
									.addComponent(btnBorrar, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnActualizar)
									.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnSubirFichero, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(btnBorrarTodo)
											.addGap(18)
											.addComponent(btnCopiarFichero))))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.RELATED, 333, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblBuscarPorDni)
									.addGap(18)))
							.addComponent(txtBuscadorDni, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(37)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtBuscadorDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblBuscarPorDni))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(label_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(label_5)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxNacionalidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_6)
						.addComponent(txtTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(txtDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
					.addComponent(btnSubirFichero)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAnadir)
						.addComponent(btnBorrar)
						.addComponent(btnActualizar)
						.addComponent(btnBorrarTodo)
						.addComponent(btnCopiarFichero))
					.addContainerGap())
		);
		
		tableAlumnos = new JTable();
		tableAlumnos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnBorrar.setEnabled(true);
				btnActualizar.setEnabled(true);
				controlador.verInformacionRegistroSeleccionado();
			}
		});
		scrollPane.setViewportView(tableAlumnos);
		panel.setLayout(gl_panel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 529, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(131, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	public void setControlador(Controlador controlador) {
		this.controlador=controlador;
		
	}

	public void setModeloPrincipal(ModeloPrincipal modeloPrincipal) {
		this.modeloPrincipal=modeloPrincipal;
	}

	public JTable getTableAlumnos() {
		return tableAlumnos;
	}

	public void setTableAlumnos(JTable tableAlumnos) {
		this.tableAlumnos = tableAlumnos;
	}
	
	public void crearTablaAlumnos(ArrayList<Alumnos> resultados) {
		System.out.println(resultados);
		this.resultados=resultados;
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

		this.getTableAlumnos().setModel(model);
		trsfiltro = new TableRowSorter(tableAlumnos.getModel());
		tableAlumnos.setRowSorter(trsfiltro);
		
	}
	
	public void mostrarDatosAlumno(String cod) {
		Alumnos datosAlumno=null;
		for (int i = 0; i < resultados.size(); i++) {
			if(resultados.get(i).getCod()==Integer.parseInt(cod)){
				txtNombre.setText(resultados.get(i).getNombre());
				txtApellido.setText(resultados.get(i).getApellido());
				txtDNI.setText(resultados.get(i).getDni());
				txtTelefono.setText(String.valueOf(resultados.get(i).getTelefono()));
				comboBoxNacionalidad.setSelectedItem(resultados.get(i).getNacionalidad());
				break;
			}
			
		}
		
		
	}
	
	public String getTxtNombre() {
		return txtNombre.getText();
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public String getTxtDNI() {
		return txtDNI.getText();
	}

	public void setTxtDNI(JTextField txtDNI) {
		this.txtDNI = txtDNI;
	}

	public int getTxtTelefono() {
		try{
			return Integer.parseInt(txtTelefono.getText());
		}catch(Exception e){
			this.generarRespuesta("El número de teléfono ha de ser un número.");
		}
		return -1;
	}
	
	
	public void generarRespuesta(String respuesta) {
		JOptionPane.showMessageDialog(null, respuesta);
		
	}
	

	public void setTxtTelefono(JTextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public String getTxtApellido() {
		return txtApellido.getText();
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public String getComboBoxNacionalidad() {
		return comboBoxNacionalidad.getSelectedItem().toString();
	}

	public void setComboBoxNacionalidad(JComboBox comboBoxNacionalidad) {
		this.comboBoxNacionalidad = comboBoxNacionalidad;
	}

	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	public void setBtnActualizar(JButton btnActualizar) {
		this.btnActualizar = btnActualizar;
	}

	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	public void setBtnBorrar(JButton btnBorrar) {
		this.btnBorrar = btnBorrar;
	}

	public JButton getBtnAnadir() {
		return btnAnadir;
	}

	public void setBtnAnadir(JButton btnAnadir) {
		this.btnAnadir = btnAnadir;
	}

	public JButton getBtnBorrarTodo() {
		return btnBorrarTodo;
	}

	public void setBtnBorrarTodo(JButton btnBorrarTodo) {
		this.btnBorrarTodo = btnBorrarTodo;
	}

	public JButton getBtnCopiarFichero() {
		return btnCopiarFichero;
	}

	public void setBtnCopiarFichero(JButton btnCopiarFichero) {
		this.btnCopiarFichero = btnCopiarFichero;
	}

	public JButton getBtnSubirFichero() {
		return btnSubirFichero;
	}

	public void setBtnSubirFichero(JButton btnSubirFichero) {
		this.btnSubirFichero = btnSubirFichero;
	}

	public void actualizarTablaAlumnos(ArrayList<Alumnos> arrayListAlumnos) {
		this.crearTablaAlumnos(arrayListAlumnos);
		
	}
	public String tipoDeDatos() {
		String[] tipoBBDD = { "SQL", "FICHEROS", };
		return (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de acceso a datos", "Tipo",
				JOptionPane.DEFAULT_OPTION, null, tipoBBDD, tipoBBDD[0]); // por
																			// defecto
																			// nos
																			// conecta
																			// a
																			// SQL

	}
	
	public void filtro() {
		trsfiltro.setRowFilter(RowFilter.regexFilter(txtBuscadorDni.getText().toUpperCase(), 1)); //////metodo de filtro de datos
		}

	public void escogerFichero() {
		/*
		try{
			JFileChooser explorador;
			File archivo;
			String ruta;
			explorador = new JFileChooser("src/Ficheros/Datos");
			explorador.setDialogTitle("Abrir documento...");
			explorador.setFileFilter(new FileNameExtensionFilter("TXT - Microsoft", "txt"));
			//Muestro un dialogo sin pasarle parent con el boton de abrir
			int seleccion = explorador.showDialog(null, "Abrir!");
			  
			archivo = explorador.getSelectedFile();

			//y guardar una ruta
			ruta = archivo.getPath();
			//analizamos la respuesta
			switch(seleccion) {
			case JFileChooser.APPROVE_OPTION:
			 //seleccionó abrir
				controlador.recogerDatosCualquierFicheroAbbdd(ruta);
			 break;

			case JFileChooser.CANCEL_OPTION:
			 //dio click en cancelar o cerro la ventana
			 break;

			case JFileChooser.ERROR_OPTION:
			 //llega aqui si sucede un error
			 break;
			
			}
			
			
			
		
		}catch(Exception e){
			
		}
		*/
}
		
}