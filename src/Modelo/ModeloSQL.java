package Modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

public class ModeloSQL implements InterfaceAccesoDatos{ 
	
	private ModeloPrincipal modeloPrincipal;
	private Alumnos alumno = null;
	private Cursos curso = null;
	private Connection conexion;
	Properties propiedades = new Properties();
	private String Usuario;
	private String Pass;
	private String bbdd;
	ArrayList<Alumnos> resultados = new ArrayList<Alumnos>();
	ArrayList<Cursos> resultados2 = new ArrayList<Cursos>();

	
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
	
	
	
	public ArrayList recogerDatosBBDDAlumnos() {
		
			try {
				if (conexion == null) {
					System.out.println("NO EXISTE");
					System.exit(-1);
				}
				
				PreparedStatement pstmt = conexion.prepareStatement("SELECT * FROM alumnos JOIN cursos ON alumnos.id_curso=cursos.ID");
				ResultSet rset = pstmt.executeQuery();
				resultados = new ArrayList<Alumnos>();
				
				while (rset.next()) {
				
					for (int i = 0; i < this.resultados2.size(); i++) {
					
						if(this.resultados2.get(i).getCurso().equals(rset.getString("nombreCurso"))){
							System.out.println("esta entrando en el rset??");
							curso=this.resultados2.get(i);
							
							alumno = new Alumnos(rset.getInt("cod"), rset.getString("nombre"), rset.getString("apellido"), rset.getString("dni"), rset.getString("nacionalidad"), rset.getInt("telefono"),curso, rset.getInt("id_curso"));	
							System.out.println("el alumno es: " + alumno);
						
						}
						
						
					
					}
					resultados.add(alumno);
				
					
					
					
					
					
				}
				
			

			} catch (SQLException s) {
				s.printStackTrace();
			}
		
	
			
		return resultados;
		
		
	}
	
	public ArrayList recogerDatosBBDDCursos(){
		try {
			if (conexion == null) {
				System.out.println("NO EXISTE");
				System.exit(-1);
			}
			PreparedStatement pstmt = conexion.prepareStatement("SELECT * FROM cursos");
			ResultSet rset = pstmt.executeQuery();
			this.resultados2 = new ArrayList<Cursos>();
			while (rset.next()) {
				curso = new Cursos (rset.getInt("id"), rset.getString("nombreCurso"),  rset.getString("fechaInicial"), rset.getString("fechaFinal"), rset.getString("titulacion"));
				
				this.resultados2.add(curso);
				System.out.println("Curso: " + curso);
				
			}
			

		} catch (SQLException s) {
			s.printStackTrace();
		}
		return resultados2;
}
	

	
	
	public void setModeloPrincipal(ModeloPrincipal modeloPrincipal) {
		this.modeloPrincipal=modeloPrincipal;
		
	}
	@Override
	public String AccesoBBDD() {
		System.out.println("tuvilllaaaa");
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
		
		int id_curso = 0;
		
		try {
			System.out.println("el get alumno es: " + alumno.getCurso().getCurso());
			PreparedStatement pstmt2 = conexion.prepareStatement("SELECT cursos.ID FROM cursos WHERE cursos.nombreCurso='" + alumno.getCurso().getCurso()+"'");
			ResultSet rset2;
			rset2 = pstmt2.executeQuery();
			while (rset2.next()) {
				id_curso=rset2.getInt("ID");
				System.out.println("el id es " + id_curso);
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
		
		int respuesta=0;
		try {
			PreparedStatement pstmt;
			String query = "INSERT INTO `alumnos` (`dni`, `nombre`, `apellido`, `telefono`, `nacionalidad`, `id_curso`) VALUES ( ?,?,?,?,?,? )";
			pstmt = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, alumno.getDni().toUpperCase());
			pstmt.setString(2, alumno.getNombre().toUpperCase());
			pstmt.setString(3, alumno.getApellido().toUpperCase());
			pstmt.setInt(4, alumno.getTelefono());
			pstmt.setString(5, alumno.getNacionalidad().toUpperCase());
			pstmt.setInt(6, id_curso);
			respuesta=pstmt.executeUpdate();
					
			
			
			
		} catch (SQLException e) {
			
		}
		return respuesta;

	}
	
	
	@Override
	public int addUnCurso(Cursos curso) {
		
		int respuesta=0;
		try {
			PreparedStatement pstmt;
			String query = "INSERT INTO `cursos` (`nombreCurso`, `fechaInicial`, `fechaFinal`, `titulacion`) VALUES ( ?,?,?,?)";
			pstmt = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, curso.getCurso().toUpperCase());
			pstmt.setString(2, curso.getFechaInicio().toUpperCase());
			pstmt.setString(3, curso.getFechaFin().toUpperCase());
			pstmt.setString(4, curso.getTitulacion().toUpperCase());
			respuesta=pstmt.executeUpdate();
					
			
			
			
		} catch (SQLException e) {
			
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


	@Override
	public int actualizarJugadores(String cod, Alumnos alumno) {
		int respuesta=0;
		try {
			PreparedStatement pstmt;
			String query="UPDATE `alumnos` SET `dni` = ?,`nombre` = ?, `apellido` = ?"
					+ ", `nacionalidad` = ?, `telefono` = ? WHERE `alumnos`.`cod` = '" + cod + "'";
			pstmt = conexion.prepareStatement(query);
			pstmt.setString(1, alumno.getDni().toUpperCase());
			pstmt.setString(2, alumno.getNombre().toUpperCase());
			pstmt.setString(3, alumno.getApellido().toUpperCase());
			pstmt.setString(4, alumno.getNacionalidad().toUpperCase());
			pstmt.setInt(5, alumno.getTelefono());
			respuesta=pstmt.executeUpdate();
			System.out.println(respuesta);
			respuesta=1;
		} catch (SQLException e) {
			respuesta=0;
			e.printStackTrace();
		}

		return respuesta;
	}



	public ArrayList<Alumnos> getResultados() {
		return resultados;
	}



	public void setResultados(ArrayList<Alumnos> resultados) {
		this.resultados = resultados;
	}



	public ArrayList<Cursos> getResultados2() {
		return resultados2;
	}



	public void setResultados2(ArrayList<Cursos> resultados2) {
		this.resultados2 = resultados2;
	}



	@Override
	public int deleteCurso(String codCursos) {
		int retorno = 0;
		try {
			if (conexion == null) {
				System.out.println("NO EXISTE");
				System.exit(-1);
			}
			PreparedStatement pstmt = conexion.prepareStatement("DELETE FROM `cursos` WHERE `cursos`.`ID` =" + codCursos);
			retorno=pstmt.executeUpdate();
				
	} catch (SQLException s) {
		s.printStackTrace();
	}

		return retorno;
	}



	@Override
	public int deleteAllCursos() {
		int respuesta=0;
		try {
			if (conexion == null) {
				System.out.println("NO EXISTE");
				System.exit(-1);
			}
			PreparedStatement pstmt = conexion.prepareStatement("DELETE FROM `cursos` ");

			respuesta=pstmt.executeUpdate();
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return respuesta;
	}



	
	
}
