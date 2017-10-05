package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ModeloFicheros implements InterfaceAccesoDatos { //Heredamos del padre ModeloPrincipal
	FileReader leerFichero;
	File miFichero;
	ArrayList<Alumnos> resultados = new ArrayList<Alumnos>();
	private Alumnos alumno = null;
	
	@Override
	public String AccesoBBDD() {
		String aviso="";
		miFichero = new File("src/Ficheros/Datos/DatosTabla.txt");
		if (miFichero.exists()) {
			try {
				leerFichero = new FileReader(miFichero);
			} catch ( IOException e) {
				aviso="error";
				e.printStackTrace();
			}
		}
		return aviso;
		
		
	}

	@Override
	public ArrayList<Alumnos> recogerDatosBBDD() {
		BufferedReader br = new BufferedReader(leerFichero);
		String lineaAlumno="";
		try {
			resultados = new ArrayList<Alumnos>();
			while((lineaAlumno=br.readLine()) != null){
				StringTokenizer st = new StringTokenizer(lineaAlumno,"-");
				ArrayList<String> datosPorCadaAlumno = new ArrayList<String>();
			    while (st.hasMoreTokens()){
			        datosPorCadaAlumno.add(st.nextToken());
				}
				alumno = new Alumnos(Integer.parseInt(datosPorCadaAlumno.get(0)), datosPorCadaAlumno.get(1), datosPorCadaAlumno.get(2), datosPorCadaAlumno.get(3), datosPorCadaAlumno.get(4), Integer.parseInt(datosPorCadaAlumno.get(5)));
				resultados.add(alumno);

			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return resultados;
	}

	@Override
	public int addUnAlumno(Alumnos alumno) {
		String ultimoAlumno="";
		int respuesta=0;
		try {
			miFichero = new File("src/Ficheros/Datos/DatosTabla.txt");
			leerFichero = new FileReader(miFichero);
			 BufferedReader br = new BufferedReader(leerFichero);
			 String substring="";
			 
			 
			
			
			 FileWriter fw = new FileWriter(miFichero, true);
		     BufferedWriter bw = new BufferedWriter(fw);
		     PrintWriter pw = new PrintWriter(bw);
		        
		        pw.println(String.valueOf(alumno.getCod()) + "-" + alumno.getDni() + "-" + alumno.getNombre() + "-" + alumno.getApellido() + "-" + alumno.getNacionalidad() + "-" + String.valueOf(alumno.getTelefono()));
		        pw.close();
		        respuesta=1;
		} catch (IOException e) {
			respuesta=0;
			e.printStackTrace();
		}
		return respuesta;
		
		
	}

	@Override
	public int deleteAlumno(String cod) {
		return 0;
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deleteAllAlumnos() {
		return 0;
		// TODO Auto-generated method stub
		
	}

}
