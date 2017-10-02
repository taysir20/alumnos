package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Controlador;
import Modelo.ModeloPrincipal;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

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
		
		btnBorrar = new JButton("BORRAR");
		btnBorrar.setEnabled(false);
		
		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.setEnabled(false);
		
		btnSubirFichero = new JButton("SUBIR DEL FICHERO A LA BBDD");
		
		btnBorrarTodo = new JButton("BORRAR TODO");
		
		btnCopiarFichero = new JButton("COPIAR A UN FICHERO");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
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
										.addComponent(txtTelefono, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
										.addComponent(comboBoxNacionalidad, 0, 264, Short.MAX_VALUE)))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(btnAnadir)
									.addGap(18)
									.addComponent(btnBorrar, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnActualizar)
									.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnSubirFichero, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(btnBorrarTodo)
											.addGap(18)
											.addComponent(btnCopiarFichero))))))
						.addComponent(label))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(label)
					.addGap(29)
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
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
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
	
	
}
