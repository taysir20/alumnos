package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidad.Alumnos;
import Vista.VistaAlumnos;
import Modelo.ModeloSQL;
import Modelo.ModeloFicheros;

public class ModeloPrincipal {

	private VistaAlumnos vistaAlumnos;
	private ModeloPrincipal modelo;
	
	
	
	public String getBBDD() {
			return modelo.getBBDD();	
	}
	public void setVistaPrincipal(VistaAlumnos vistaAlumnos) {
		this.vistaAlumnos=vistaAlumnos;
		
	}


	public ArrayList<Alumnos> recogerDatosBBDD() {
			return this.modelo.recogerDatosBBDD();
		
	}

	public void NewBBDD(String tipoDeBBDD) {
		if(tipoDeBBDD.equalsIgnoreCase("SQL")){
			modelo=new ModeloSQL();
		}else if(tipoDeBBDD.equalsIgnoreCase("FICHEROS")){
			modelo=new ModeloFicheros();
		}
	}

	

	

}
