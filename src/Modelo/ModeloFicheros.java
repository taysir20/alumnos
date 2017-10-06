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
		System.out.println("pato");
		miFichero = new File("src/Ficheros/Datos/DatosTabla.txt");
		try {
			leerFichero = new FileReader(miFichero);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedReader br = new BufferedReader(leerFichero);
		String lineaAlumno="";
		resultados = new ArrayList<>();
		try {
			//resultados = new ArrayList<Alumnos>();

			
			
			while((lineaAlumno=br.readLine()) != null){
				StringTokenizer st = new StringTokenizer(lineaAlumno,"-");
				ArrayList<String> datosPorCadaAlumno = new ArrayList<String>();
			    while (st.hasMoreTokens()){
			        datosPorCadaAlumno.add(st.nextToken());
				}
				alumno = new Alumnos(Integer.parseInt(datosPorCadaAlumno.get(0)), datosPorCadaAlumno.get(2).toUpperCase(), datosPorCadaAlumno.get(3).toUpperCase(), datosPorCadaAlumno.get(1).toUpperCase(), datosPorCadaAlumno.get(4).toUpperCase(), Integer.parseInt(datosPorCadaAlumno.get(5)));
				resultados.add(alumno);

			}
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return resultados;
	}

	@Override
	public int addUnAlumno(Alumnos alumno) {
		int respuesta=0;
		int cod;
		try {
			miFichero = new File("src/Ficheros/Datos/DatosTabla.txt");
			leerFichero = new FileReader(miFichero);
			 BufferedReader br = new BufferedReader(leerFichero);
			 String lineaCompletaAlumno="";
			 String ultimoCod="";
			 StringTokenizer codUltimoAlumno=null;
			 while((lineaCompletaAlumno=br.readLine())!=null){
				 codUltimoAlumno = new StringTokenizer(lineaCompletaAlumno,"-");
				 ultimoCod=codUltimoAlumno.nextToken();
				
			 }
			if(ultimoCod==""){
				cod=1;
				
			}else{
				cod =Integer.parseInt(ultimoCod);
				cod++;
			}
			
		boolean esIgual=false;
		
			for (int i = 0; i < resultados.size(); i++) {
				
					if(String.valueOf(alumno.getDni()).equals(String.valueOf(resultados.get(i).getDni()))){
						esIgual=true;
					}
								
			}
			if(esIgual==false){
				FileWriter fw = new FileWriter(miFichero, true);
			     BufferedWriter bw = new BufferedWriter(fw);
			     PrintWriter pw = new PrintWriter(bw);
			        pw.println(String.valueOf(cod) + "-" + alumno.getDni() + "-" + alumno.getNombre() + "-" + alumno.getApellido() + "-" + alumno.getNacionalidad() + "-" + String.valueOf(alumno.getTelefono()));
			        pw.close();
			        respuesta=1;		
			}
			 
			
		} catch (IOException e) {
			respuesta=0;
			e.printStackTrace();
		}
		return respuesta;
		
		
	}

	@Override
	public int deleteAlumno(String cod) {
		int respuesta=0;
		try {
			miFichero = new File("src/Ficheros/Datos/DatosTabla.txt");
			leerFichero = new FileReader(miFichero);
			BufferedReader br = new BufferedReader(leerFichero);
			 String lineaCompletaAlumno="";
			 StringTokenizer codTokenizer=null;
			 ArrayList<String> sobreescribir = new ArrayList<String>();
			 String codigo="";
			 
			 while((lineaCompletaAlumno=br.readLine())!=null){
				
				 codTokenizer = new StringTokenizer(lineaCompletaAlumno,"-");
				if(!String.valueOf(cod).equals(codTokenizer.nextToken())){
					 sobreescribir.add(lineaCompletaAlumno);    
				}
				 
			 }
			 FileWriter fw = new FileWriter(miFichero,false);
		     BufferedWriter bw = new BufferedWriter(fw);
		     PrintWriter pw = new PrintWriter(bw);
		     for (int i = 0; i < sobreescribir.size(); i++) {
				pw.println(sobreescribir.get(i));
				 
			}
		     pw.close();
		     respuesta=1;
			
			
		} catch (IOException e) {
			respuesta=0;
			e.printStackTrace();
		}
		 
		return respuesta;
		
		
	}

	@Override
	public int deleteAllAlumnos() {
		int respuesta=0;
		
		
			miFichero = new File("src/Ficheros/Datos/DatosTabla.txt");
			try {
				FileWriter fw = new FileWriter(miFichero);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);
				pw.close();
				respuesta=1;
			} catch (IOException e) {
				respuesta=0;
				e.printStackTrace();
			}
		
		return respuesta;
		
		
	}

	@Override
	public int actualizarJugadores(String cod, Alumnos alumno) {
		int respuesta=0;
		try {
			miFichero = new File("src/Ficheros/Datos/DatosTabla.txt");
			leerFichero = new FileReader(miFichero);
			BufferedReader br = new BufferedReader(leerFichero);
			 String lineaCompletaAlumno="";
			 StringTokenizer codTokenizer=null;
			 ArrayList<String> sobreescribir = new ArrayList<String>();
			 String codigo="";
			 
			 while((lineaCompletaAlumno=br.readLine())!=null){
				
				 codTokenizer = new StringTokenizer(lineaCompletaAlumno,"-");
				if(!String.valueOf(cod).equals(codTokenizer.nextToken())){
					 sobreescribir.add(lineaCompletaAlumno);    
				}else{
					sobreescribir.add(String.valueOf(alumno.getCod()) + "-" + alumno.getDni() + "-" + alumno.getNombre()  + "-" + alumno.getApellido() + "-" + alumno.getNacionalidad() + "-" + String.valueOf(alumno.getTelefono()));
				}
				 
			 }
			 FileWriter fw = new FileWriter(miFichero,false);
		     BufferedWriter bw = new BufferedWriter(fw);
		     PrintWriter pw = new PrintWriter(bw);
		     for (int i = 0; i < sobreescribir.size(); i++) {
				pw.println(sobreescribir.get(i));
				 
			}
		     pw.close();
		     respuesta=1;
			
			
		} catch (IOException e) {
			respuesta=0;
			e.printStackTrace();
		}
		return respuesta;
	}


}
