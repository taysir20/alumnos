package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import Vista.VistaAlumnos;
import Vista.VistaCursos;
import Modelo.ModeloSQL;
import Modelo.ModeloFicheros;

public class ModeloPrincipal {

	private VistaAlumnos vistaAlumnos;
	private InterfaceAccesoDatos modelo; // atributo de interface que usamos para poder llamar a los métodos de la interface
	private Alumnos alumno;
	private Cursos curso;
	private InterfaceAccesoDatos receptor;
	ArrayList<Alumnos> resultados;
	ArrayList<Cursos> resultados2;
	private VistaCursos misCursos;
	
	
	
	public void conexionDatos() { // preguntamos si es null 
			if(modelo.AccesoBBDD().equals("error")){
				this.vistaAlumnos.generarRespuesta("No se ha podido establecer conexión con la fuente de datos");
			}

		
	}
	public void setVistaPrincipal(VistaAlumnos vistaAlumnos) {
		this.vistaAlumnos=vistaAlumnos;
		
	}


	public void recogerDatosBBDDAlumnos() {
		
			resultados = this.modelo.recogerDatosBBDDAlumnos();
			
			
			this.vistaAlumnos.crearTablaAlumnos(resultados);
		
		
					
	}
	
	public void recogerDatosBBDDCursos(){
			resultados2= this.modelo.recogerDatosBBDDCursos();
		
		}
	public void crearTablaCursos(){
		this.misCursos.crearTablaCursos(resultados2);
	}
					



	public void NuevoDato(String tipoDeDato) {
		if(tipoDeDato.equalsIgnoreCase("SQL")){
			modelo=new ModeloSQL();
		}else if(tipoDeDato.equalsIgnoreCase("FICHEROS")){
			
			modelo=new ModeloFicheros();
		}
	}
	
	public void addAlumnos(String txtNombre, String txtApellido, String txtDNI, String comboBoxNacionalidad,
			int txtTelefono, String comboBoxCursos) {
		recogerDatosBBDDCursos();
		for (int i = 0; i < resultados2.size(); i++) {
			
			if(resultados2.get(i).getCurso().equals(comboBoxCursos)){
				alumno= new Alumnos(txtNombre,txtApellido,txtDNI,comboBoxNacionalidad,txtTelefono,resultados2.get(i), resultados2.get(i).getId());
			}
		}
	
		if(modelo.addUnAlumno(alumno)==1){
		
			this.recogerDatosBBDDAlumnos();
		}else{
			this.vistaAlumnos.generarRespuesta("Ya existe un registro con este DNI.");
		}
		
		
		
	}
	public void crearComboBoxCursos(){
		for (int i = 0; i < resultados2.size(); i++) {
			this.vistaAlumnos.actualizarCursos(resultados2.get(i).getCurso());
		}
		
	}
	
	public void addCursos(String txtNombre, String fechaInicio, String fechaFinal, String comboBoxTitulacion) {
		curso= new Cursos(txtNombre,fechaInicio, fechaFinal, comboBoxTitulacion);
		if(modelo.addUnCurso(curso)==1){
			
			this.recogerDatosBBDDCursos();
			
			this.vistaAlumnos.actualizarCursos(curso.getCurso());
			this.misCursos.crearTablaCursos(resultados2);
			
			
		}else{
			this.vistaAlumnos.generarRespuesta("Ya existe un curso con este Nombre.");
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
			this.recogerDatosBBDDAlumnos();
			this.vistaAlumnos.generarRespuesta("Registro borrado satisfactoriamente");
		}else{
			this.vistaAlumnos.generarRespuesta("No se ha podido borrar el registro");
		}
		
	}
	public void borrarTodosAlumnos() {
		if(modelo.deleteAllAlumnos()>0){
			this.recogerDatosBBDDAlumnos();
			this.vistaAlumnos.generarRespuesta("Todos los registros han sido borrados satisfactoriamente.");
		}else{
			this.vistaAlumnos.generarRespuesta("No se ha podido borrar los registros");
		}
		
		
		
	}
	public void intercambioDatos() {
		ArrayList<Alumnos> emisor = resultados;
		this.vistaAlumnos.generarRespuesta("El volcado de datos se producirá desde la Base de Datos a la que estás conectado actualmente. Seleccione a continuación el destino del volcado de datos.");
		String tipoDatos=this.vistaAlumnos.tipoDeDatos();
		if(tipoDatos.equals("SQL")){
			receptor = new ModeloSQL();
		}else if(tipoDatos.equals("FICHEROS")){
			receptor = new ModeloFicheros();
		}
		receptor.AccesoBBDD();
		this.volcarDatos(emisor);
		
		
		
		
	}
	
	public void volcarDatos(ArrayList<Alumnos> emisor) {
		
		for (int i = 0; i < emisor.size(); i++) {
			receptor.recogerDatosBBDDAlumnos();
			alumno= new Alumnos(emisor.get(i).getNombre(), emisor.get(i).getApellido(), emisor.get(i).getDni(), emisor.get(i).getNacionalidad(), emisor.get(i).getTelefono(), emisor.get(i).getCurso(), emisor.get(i).getId_Curso());
			
			receptor.addUnAlumno(alumno);
			
		}
		
		
	}
	
	public void actualizarDatosAlumnos(String cod, String txtNombre, String txtApellido, String txtDNI, String comboBoxNacionalidad,int txtTelefono,String comboBoxCurso) {
		recogerDatosBBDDCursos();
		for (int i = 0; i < resultados2.size(); i++) {
			if(resultados2.get(i).getCurso()==comboBoxCurso){
				alumno= new Alumnos(txtNombre,txtApellido,txtDNI,comboBoxNacionalidad,txtTelefono,resultados2.get(i), resultados2.get(i).getId());
			}
		}
		if(modelo.actualizarJugadores(cod, alumno)==1){
			this.vistaAlumnos.generarRespuesta("Registro actualizado satisfactoriamente.");
			this.recogerDatosBBDDAlumnos();
		}else{
			this.vistaAlumnos.generarRespuesta("Ya existe un registro con este DNI.");
		}
		
	}
	public void setVentanaCursos(VistaCursos misCursos) {
		this.misCursos=misCursos;
		
	}
	public void intercambioCursos() {
		ArrayList<Cursos> emisor = resultados2;
		this.vistaAlumnos.generarRespuesta("El volcado de datos se producirá desde la Base de Datos a la que estás conectado actualmente. Seleccione a continuación el destino del volcado de datos.");
		String tipoDatos=this.vistaAlumnos.tipoDeDatos();
		if(tipoDatos.equals("SQL")){
			receptor = new ModeloSQL();
		}else if(tipoDatos.equals("FICHEROS")){
			receptor = new ModeloFicheros();
		}
		receptor.AccesoBBDD();
		this.volcarDatosCursos(emisor);
		
	}
	private void volcarDatosCursos(ArrayList<Cursos> emisor) {
		for (int i = 0; i < emisor.size(); i++) {
			receptor.recogerDatosBBDDCursos();
			curso= new Cursos(emisor.get(i).getCurso(), emisor.get(i).getFechaInicio(), emisor.get(i).getFechaFin(), emisor.get(i).getTitulacion());
			
			receptor.addUnCurso(curso);
			
		}
		
	}
	public void borrarCursos(String codCurso) {
		
	
	
		
		
		
		
		String curso="";
		for (int i = 0; i < resultados2.size(); i++) {
			if(codCurso.equals(String.valueOf(resultados2.get(i).getId()))){
				curso=resultados2.get(i).getCurso();
			}
			
		}
		
		this.recogerDatosBBDDCursos();
		this.vistaAlumnos.generarRespuesta("Al borrar un curso borrarás todos los alumnos relacionados con él. ¿Estás seguro?");
		if(modelo.deleteCurso(codCurso)==1){
			
		
		
	
			this.actualizarTablaAlumnos(resultados);
			this.misCursos.crearTablaCursos(resultados2);
			this.vistaAlumnos.crearTablaAlumnos(resultados);
			this.vistaAlumnos.borrarCursos(curso);
			this.vistaAlumnos.generarRespuesta("Registro borrado satisfactoriamente");
		}else{
			this.vistaAlumnos.generarRespuesta("No se ha podido borrar el registro");
		}
		
	}
	public void borrarTodosCursos() {
		this.vistaAlumnos.generarRespuesta("ATENCIÓN: SE BORRARÁN TODOS LOS ALUMNOS PERTENECIENTES A LOS CURSOS.");
		if(modelo.deleteAllCursos()>0){
			
			this.recogerDatosBBDDCursos();
			this.borrarTodosAlumnos();
			this.misCursos.crearTablaCursos(resultados2);
			this.vistaAlumnos.generarRespuesta("Todos los registros han sido borrados satisfactoriamente.");
		}else{
			this.vistaAlumnos.generarRespuesta("No se ha podido borrar los registros");
		}
		
	}
	
	
	
	
	
	
	
	
	
//EXTRA. ESTA PARTE ES UN AÑADIDO PARA PODER ESCOGER TU EL FICHERO QUE QUIEROS SUBIR A UNA BBDD. 
	//LA SEPARO DEL RESTO DEL CÓDIGO POR NO SÉ EXACTAMENTE COMO PODER IMPLEMENTARLA MEJOR
	/*public void recogerDatosCualquierFichero(String ruta) {
		System.out.println("entra al modelo");
		InterfaceAccesoDatos auxiliar = new ModeloSQL();
		auxiliar.AccesoBBDD();
		FileReader fr;
		BufferedReader br;
		ArrayList<Alumnos> arrAlumnos = new ArrayList<Alumnos>();
		try {
			File miFichero = new File(ruta);
			String[] lineaAlumno = null;
			if (miFichero.exists()) {
				fr=new FileReader(miFichero);
				br= new BufferedReader(fr);
				String miAlumno="";
				while((miAlumno=br.readLine())!=null){
					lineaAlumno=miAlumno.split("-");
					alumno =new Alumnos(lineaAlumno[2],lineaAlumno[3],lineaAlumno[1],lineaAlumno[4],Integer.parseInt(lineaAlumno[5]));
					System.out.println("mi alumno está: " + alumno);
					arrAlumnos.add(alumno);
					System.out.println("añade alumno");
				}
				System.out.println("sergioooooooo");
				
				System.out.println("EL size es :" + arrAlumnos);
				for (int i = 0; i < arrAlumnos.size(); i++) {
					System.out.println("add alumno");
					auxiliar.addUnAlumno(arrAlumnos.get(i));
				}
			
			} else
				System.err.println("Fichero no encontrado");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	*/
	

	

	

}
