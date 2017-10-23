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
	ArrayList<Cursos> resultados2 = new ArrayList<Cursos>();
	
	private Alumnos alumno = null;
	private Cursos curso = null;
	
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
	public ArrayList recogerDatosBBDDAlumnos() {
	this.recogerDatosBBDDCursos();
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

				
				String datoAlumno="";
				int posCurso=1;
				String curso="";
				
				while((lineaAlumno=br.readLine()) != null){
					StringTokenizer st = new StringTokenizer(lineaAlumno,"-");
					ArrayList<String> datosPorCadaAlumno = new ArrayList<String>();
				    while (st.hasMoreTokens()){
				    	datoAlumno=st.nextToken();
				        datosPorCadaAlumno.add(datoAlumno);
				        if(posCurso==7){
				        	curso=datoAlumno;
				        	posCurso=-1;
				        	
				        }
				        posCurso++;
				        
					}
				  
				    for (int i = 0; i < resultados2.size(); i++) {
						if(resultados2.get(i).getCurso().equals(curso)){
							System.out.println("el curso que busco es: " + curso);
							alumno = new Alumnos(Integer.parseInt(datosPorCadaAlumno.get(0)), datosPorCadaAlumno.get(2).toUpperCase(), datosPorCadaAlumno.get(3).toUpperCase(), datosPorCadaAlumno.get(1).toUpperCase(), datosPorCadaAlumno.get(4).toUpperCase(), Integer.parseInt(datosPorCadaAlumno.get(5)),resultados2.get(i),Integer.parseInt(datosPorCadaAlumno.get(7)));
							resultados.add(alumno);
						}
						
					}
					
					

				}
			
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			
		
		
		return resultados;
	}
	
	public ArrayList recogerDatosBBDDCursos(){
		System.out.println("pato");
		miFichero = new File("src/Ficheros/Datos/DatosTabla2.txt");
		try {
			leerFichero = new FileReader(miFichero);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedReader br = new BufferedReader(leerFichero);
		String lineaCurso="";
		resultados2 = new ArrayList<>();
		try {
			while((lineaCurso=br.readLine()) != null){
				StringTokenizer st = new StringTokenizer(lineaCurso,"_");
				ArrayList<String> datosPorCadaCurso = new ArrayList<String>();
			    while (st.hasMoreTokens()){
			    	datosPorCadaCurso.add(st.nextToken());
				}
			    
				curso = new Cursos(Integer.parseInt(datosPorCadaCurso.get(0)), datosPorCadaCurso.get(1).toUpperCase(), datosPorCadaCurso.get(2).toUpperCase(), datosPorCadaCurso.get(3).toUpperCase(), datosPorCadaCurso.get(4).toUpperCase());
			resultados2.add(curso);

			}
			
			System.out.println("los resultados2 tienen un size de: " + resultados2.size());
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	return resultados2;
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
						System.out.println("Aquí entra?");
						esIgual=true;
					}
								
			}
			if(esIgual==false){
				FileWriter fw = new FileWriter(miFichero, true);
			     BufferedWriter bw = new BufferedWriter(fw);
			     PrintWriter pw = new PrintWriter(bw);
			     System.out.println("el curso correspondiente es: " + alumno.getCurso().getCurso().toUpperCase());
			        pw.println(String.valueOf(cod) + "-" + alumno.getDni().toUpperCase() + "-" + alumno.getNombre().toUpperCase() + "-" + alumno.getApellido().toUpperCase() + "-" + alumno.getNacionalidad().toUpperCase() + "-" + String.valueOf(alumno.getTelefono()) + "-" + alumno.getCurso().getCurso().toUpperCase() + "-" + String.valueOf(alumno.getId_Curso()));
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

	@Override
	public int addUnCurso(Cursos curso) {
		int respuesta=0;
		int cod;
		try {
			miFichero = new File("src/Ficheros/Datos/DatosTabla2.txt");
			leerFichero = new FileReader(miFichero);
			 BufferedReader br = new BufferedReader(leerFichero);
			 String lineaCompletaCurso="";
			 String ultimoCod="";
			 StringTokenizer codUltimoCurso=null;
			 while((lineaCompletaCurso=br.readLine())!=null){
				 codUltimoCurso = new StringTokenizer(lineaCompletaCurso,"_");
				 ultimoCod=codUltimoCurso.nextToken();
				
			 }
			if(ultimoCod==""){
				cod=1;
				
			}else{
				cod =Integer.parseInt(ultimoCod);
				cod++;
			}
			
		boolean esIgual=false;

			for (int i = 0; i < resultados2.size(); i++) {
					if(curso.getCurso().equals(resultados2.get(i).getCurso())){


						esIgual=true;
					}
								
			}
			if(esIgual==false){
				FileWriter fw = new FileWriter(miFichero, true);
			     BufferedWriter bw = new BufferedWriter(fw);
			     PrintWriter pw = new PrintWriter(bw);
			        pw.println(String.valueOf(cod) + "_" + curso.getCurso().toUpperCase() + "_" + curso.getFechaInicio().toUpperCase() + "_" + curso.getFechaFin().toUpperCase() + "_" + curso.getTitulacion().toUpperCase());
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
	public ArrayList<Cursos> getResultados2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteCurso(String codCursos) {
		int respuesta=0;
		try {
			miFichero = new File("src/Ficheros/Datos/DatosTabla2.txt");
			leerFichero = new FileReader(miFichero);
			BufferedReader br = new BufferedReader(leerFichero);
			 String lineaCompletaCurso="";
			 StringTokenizer codTokenizer=null;
			 ArrayList<String> sobreescribir = new ArrayList<String>();
			 String codigo="";
			 
			 while((lineaCompletaCurso=br.readLine())!=null){
				
				 codTokenizer = new StringTokenizer(lineaCompletaCurso,"_");
				if(!String.valueOf(codCursos).equals(codTokenizer.nextToken())){
					 sobreescribir.add(lineaCompletaCurso);    
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
	public int deleteAllCursos() {
		// TODO Auto-generated method stub
		return 0;
	}


}
