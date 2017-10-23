package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import Controlador.Controlador;
import Modelo.Alumnos;
import Modelo.Cursos;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class VistaCursos extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JDateChooser dateInicio;
	private JDateChooser dateFin;
	private JTable tableCursos;
	private JComboBox comboBoxTitulacion;
	private JButton button_3;
	private JButton btnBorrarTodo;
	private JButton btnAnadir;
	private JButton btnBorrar;
	private JButton btnActualizar;
	private JButton btnVolcarDatos;
	private Controlador controlador;
	private ArrayList<Cursos> resultados2;
	private SimpleDateFormat parseador;
	private SimpleDateFormat parseador2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaCursos frame = new VistaCursos();
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
	public VistaCursos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 714, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblCursos = new JLabel("Cursos");
		lblCursos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		btnAnadir = new JButton("A\u00D1ADIR");
		btnAnadir.addActionListener(new ActionListener() {

		
			public void actionPerformed(ActionEvent e) {
				controlador.addCursos();
			}
		});
		
		btnBorrar = new JButton("BORRAR");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.borrarCursos();
				btnActualizar.setEnabled(true);
				btnBorrar.setEnabled(true);
				
			}
		});
		btnBorrar.setEnabled(false);
		
		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.setEnabled(false);
		
		button_3 = new JButton("VOLCAR DATOS DE CUALQUIER FICHERO A UNA BBDD");
		
		btnBorrarTodo = new JButton("BORRAR TODO");
		
		btnVolcarDatos = new JButton("VOLCAR DATOS");
		btnVolcarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.intercambioDatosCursos();
			}
		});
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		JLabel label = new JLabel("Nombre:");
		
		JLabel lblTitulacion = new JLabel("Titulaci\u00F3n:");
		
		comboBoxTitulacion = new JComboBox();
		comboBoxTitulacion.setModel(new DefaultComboBoxModel(new String[] {"GRADO", "CICLO FORMATIVO SUPERIOR", "CICLO FORMATIVO MEDIO", "POST GRADO"}));
		
		JLabel lblFechaDeInicio = new JLabel("Fecha de Inicio:");
		
		dateInicio = new JDateChooser();
		
		JLabel lblFechaDeFin = new JLabel("Fecha de Fin:");
		
		dateFin = new JDateChooser();
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnAnadir, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnBorrar, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnActualizar, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnBorrarTodo, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
									.addGap(81)
									.addComponent(btnVolcarDatos, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
								.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblCursos, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(563, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
									.addComponent(comboBoxTitulacion, 0, 276, Short.MAX_VALUE)
									.addComponent(txtNombre))
								.addComponent(lblTitulacion, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
							.addGap(55)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFechaDeFin, GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE)
								.addComponent(dateFin, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
								.addComponent(dateInicio, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
								.addComponent(lblFechaDeInicio, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblCursos, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(lblFechaDeInicio))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTitulacion)
								.addComponent(lblFechaDeFin)))
						.addComponent(dateInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(dateFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(button_3))
						.addComponent(comboBoxTitulacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAnadir)
						.addComponent(btnBorrar)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnActualizar)
							.addComponent(btnBorrarTodo))
						.addComponent(btnVolcarDatos))
					.addGap(40))
		);
		
		tableCursos = new JTable();
		tableCursos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.verInformacionCursos();
				btnActualizar.setEnabled(true);
				btnBorrar.setEnabled(true);
			}
		});
		scrollPane.setViewportView(tableCursos);
		contentPane.setLayout(gl_contentPane);
	}

	public JTable getTableCursos() {
		return tableCursos;
	}

	public void setTableCursos(JTable tableCursos) {
		this.tableCursos = tableCursos;
	}

	public void setControlador(Controlador controlador) {
		this.controlador=controlador;
		
	}

	public String getTxtNombre() {
		return txtNombre.getText();
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public String getDateInicio() {
		parseador = new SimpleDateFormat("dd-MM-yyyy");
	
		return 	parseador.format(dateInicio.getDate()).toString();
	}

	public void setDateInicio(JDateChooser dateInicio) {
		this.dateInicio = dateInicio;
	}

	public String getDateFin() {
		parseador2 = new SimpleDateFormat("dd-MM-yyyy");
		return 	parseador.format(dateFin.getDate()).toString();
	}

	public void setDateFin(JDateChooser dateFin) {
		this.dateFin = dateFin;
	}

	public String getComboBoxTitulacion() {
		return comboBoxTitulacion.getSelectedItem().toString();
	}

	public void setComboBoxTitulacion(JComboBox comboBoxTitulacion) {
		this.comboBoxTitulacion = comboBoxTitulacion;
	}

	public JButton getBtnBorrarTodo() {
		return btnBorrarTodo;
	}

	public void setBtnBorrarTodo(JButton btnBorrarTodo) {
		this.btnBorrarTodo = btnBorrarTodo;
	}

	public JButton getBtnAnadir() {
		return btnAnadir;
	}

	public void setBtnAnadir(JButton btnAnadir) {
		this.btnAnadir = btnAnadir;
	}

	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	public void setBtnBorrar(JButton btnBorrar) {
		this.btnBorrar = btnBorrar;
	}

	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	public void setBtnActualizar(JButton btnActualizar) {
		this.btnActualizar = btnActualizar;
	}

	public JButton getBtnVolcarDatos() {
		return btnVolcarDatos;
	}

	public void setBtnVolcarDatos(JButton btnVolcarDatos) {
		this.btnVolcarDatos = btnVolcarDatos;
	}
	
	public void generarRespuesta(String respuesta) {
		JOptionPane.showMessageDialog(null, respuesta);
		
	}

	public void crearTablaCursos(ArrayList<Cursos> resultados2) {
		System.out.println("mis resutlados 2 son en la vista: " + resultados2);
		if(resultados2.isEmpty()){
			
		}else{
			System.out.println(resultados2.get(0).getFechaInicio());
			//System.out.println("LA FECHA ES" + resultados2.get(0).getFechaInicio());
			this.resultados2=resultados2;
			DefaultTableModel model = new DefaultTableModel() {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};

			model.addColumn("ID");
			model.addColumn("CURSO");
			model.addColumn("FECHA INICIO");
			model.addColumn("FECHA FINAL");
			model.addColumn("TITULACION");

			for (int i = 0; i < this.resultados2.size(); i++) {
				model.addRow(new String[] { String.valueOf(resultados2.get(i).getId()), resultados2.get(i).getCurso(),
						resultados2.get(i).getFechaInicio(), resultados2.get(i).getFechaFin(), resultados2.get(i).getTitulacion()});
			}

			this.getTableCursos().setModel(model);
		}
		
		
	}

	public void mostrarDatosCurso(String codCurso) {
		Cursos datosCursos=null;
		for (int i = 0; i < resultados2.size(); i++) {
			if(resultados2.get(i).getId()==Integer.parseInt(codCurso)){
				txtNombre.setText(resultados2.get(i).getCurso());
				comboBoxTitulacion.setSelectedItem(resultados2.get(i).getTitulacion());
				dateInicio.setDateFormatString("dd-MM-yyyy");
				dateFin.setDateFormatString("dd-MM-yyyy");
				Date date = null;
				Date date2 = null;
				
				
				DateFormat df = new SimpleDateFormat("dd-MM-yyyy"); 
			
				try {
					date = df.parse(resultados2.get(i).getFechaInicio());
					date2= df.parse(resultados2.get(i).getFechaFin());
				   dateInicio.setDate(date);
				   dateFin.setDate(date2);
				} catch (ParseException e) {
				    e.printStackTrace();
				}
				break;
			}
			
		}
		
	}
	
	
	
	
}
