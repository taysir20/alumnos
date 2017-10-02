package Modelo;

import java.util.ArrayList;

import Entidad.Alumnos;

public interface InterfaceAccesoDatos {
	public ArrayList<Alumnos> recogerDatosBBDD();
	public String getBBDD();
	 
}
