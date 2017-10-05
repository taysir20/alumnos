package Modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

public class ModeloSQL implements InterfaceAccesoDatos{ 
	
	private ModeloPrincipal modeloPrincipal;
	private Alumnos alumno = null;
	private Connection conexion;
	Properties propiedades = new Properties();
	private String Usuario;
	private String Pass;
	private String bbdd;
	ArrayList<Alumnos> resultados = new ArrayList<Alumnos>();
	
	
	public void leerFicheroBBDD() {
		Properties propiedades = new Properties();
		InputStream entrada = null;
		try {
			File miFichero = new File("src/Ficheros/Conexion/conexionBBDD.ini");
			if (miFichero.exists()) {
				entrada = new FileInputStream(miFichero);
				// cargamos el archivo de propiedades
				propiedades.load(entrada);
				// obtenemos las propiedades y las imprimimos
				this.Usuario = propiedades.getProperty("Usuario");
				this.Pass = propiedades.getProperty("Pass");
				this.bbdd = propiedades.getProperty("Url");
			} else
				System.err.println("Fichero no encontrado");
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (entrada != null) {
				try {
					entrada.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	public ArrayList<Alumnos> recogerDatosBBDD() {
		
		try {
			if (conexion == null) {
				System.out.println("NO EXISTE");
				System.exit(-1);
			}
			PreparedStatement pstmt = conexion.prepareStatement("SELECT * FROM alumnos");
			ResultSet rset = pstmt.executeQuery();
			resultados = new ArrayList<Alumnos>();
			while (rset.next()) {
				alumno = new Alumnos(rset.getInt("cod"), rset.getString("nombre"), rset.getString("apellido"), rset.getString("dni"), rset.getString("nacionalidad"), rset.getInt("telefono"));
				resultados.add(alumno);
				
				
			}
			

		} catch (SQLException s) {
			s.printStackTrace();
		}
		
		return resultados;
		
		
	}
	
	
	public void setModeloPrincipal(ModeloPrincipal modeloPrincipal) {
		this.modeloPrincipal=modeloPrincipal;
		
	}
	@Override
	public String AccesoBBDD() {
		String aviso;
		try {
			leerFicheroBBDD();
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(this.bbdd, this.Usuario, this.Pass);
			System.out.println(" - Conexión con MySQL establecida -");
			aviso = "¡Conexión satisfactoria!";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(" – Error de Conexión con MySQL -");
			aviso = "error";
			e.printStackTrace();
			
		}
		return aviso;
		

	}



	@Override
	public int addUnAlumno(Alumnos alumno) {
		int respuesta=0;
		try {
			PreparedStatement pstmt;
			String query = "INSERT INTO `alumnos` (`dni`, `nombre`, `apellido`, `telefono`, `nacionalidad`) VALUES ( ?,?,?,?,? )";
			pstmt = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, alumno.getDni().toUpperCase());
			pstmt.setString(2, alumno.getNombre().toUpperCase());
			pstmt.setString(3, alumno.getApellido().toUpperCase());
			pstmt.setInt(4, alumno.getTelefono());
			pstmt.setString(5, alumno.getNacionalidad().toUpperCase());
			respuesta=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return respuesta;

	}



	@Override
	public int deleteAlumno(String cod) {
		int retorno = 0;
		try {
			if (conexion == null) {
				System.out.println("NO EXISTE");
				System.exit(-1);
			}
			PreparedStatement pstmt = conexion.prepareStatement("DELETE FROM `alumnos` WHERE `alumnos`.`cod` =" + cod);
			retorno=pstmt.executeUpdate();
				
	} catch (SQLException s) {
		s.printStackTrace();
	}

		return retorno;
	}



	@Override
	public int deleteAllAlumnos() {
		int respuesta=0;
		try {
			if (conexion == null) {
				System.out.println("NO EXISTE");
				System.exit(-1);
			}
			PreparedStatement pstmt = conexion.prepareStatement("DELETE FROM `alumnos` ");

			respuesta=pstmt.executeUpdate();
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return respuesta;
		
	}



	
	
	
	
}
