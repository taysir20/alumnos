package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mysql.jdbc.Statement;

public class ModeloHibernate implements InterfaceAccesoDatos {
	private SessionFactory sessionFactory;
	Session session;
	private Alumnos alumno = null;
	private Cursos curso = null;
	ArrayList<Alumnos> resultados = new ArrayList<Alumnos>();
	ArrayList<Cursos> resultados2 = new ArrayList<Cursos>();

	@Override
	public String AccesoBBDD() {
		String aviso;
		this.HibernateUtils();
		this.iniciarSesion();
		if (sessionFactory != null && session != null) {
			aviso = "¡Conexión satisfactoria!";
		} else {
			System.out.println(" – Error de Conexión con MySQL -");
			aviso = "error";
		}

		return aviso;
	}

	public void HibernateUtils() {

		try {
			// Create the SessionFactory from standard (hibernate.cfg.xml)
			// config file.
			sessionFactory = new Configuration().configure().buildSessionFactory();

		} catch (Throwable ex) {
			// Log the exception.
			System.err.println("Initial SessionFactory creation failed." + ex);
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void iniciarSesion() {
		session = this.getSessionFactory().openSession();

	}

	@Override
	public ArrayList recogerDatosBBDDAlumnos() {

		Query q = session.createQuery("select alumn from Alumnos alumn"); // cuando

		List results = q.list();// esa lista almacenañra objetos equipo de la
		// base de datos

		Iterator alumnosIterator = results.iterator(); // mete esos objetos en
		// un iterador
		this.resultados = new ArrayList<Alumnos>();
		while (alumnosIterator.hasNext()) { // recorremos ese iterador
			alumno = (Alumnos) alumnosIterator.next();
			for (int i = 0; i < this.resultados2.size(); i++) {
				if (this.resultados2.get(i).getCurso().equals(alumno.getCurso().getCurso())) {
					curso = this.resultados2.get(i);
				}

			}
			this.resultados.add(alumno);
		}

		return resultados;

	}

	@Override
	public ArrayList recogerDatosBBDDCursos() {

		Query q = session.createQuery("select curs from Cursos curs"); // cuando

		List results = q.list();// esa lista almacenañra objetos equipo de la
		// base de datos

		Iterator cursosIterator = results.iterator(); // mete esos objetos en
		// un iterador
		this.resultados2 = new ArrayList<Cursos>();
		while (cursosIterator.hasNext()) { // recorremos ese iterador
			curso = (Cursos) cursosIterator.next();
			this.resultados2.add(curso);
		}

		return resultados2;

	}

	@Override
	public int addUnAlumno(Alumnos alumno) {
		int respuesta = 0;
		try {
			session.beginTransaction();
			session.save(alumno);
			session.getTransaction().commit();// si se ejecuta toda la
			respuesta = 1; // transacciones se realzia un
			// commit es decir un "yo firmo"

		} catch (Exception e) {
			respuesta = 0;
		}

		return respuesta;

	}

	@Override
	public int addUnCurso(Cursos curso) {
		int respuesta = 0;
		try {
			session.beginTransaction();
			session.saveOrUpdate(curso);
			session.getTransaction().commit();// si se ejecuta toda la
			respuesta = 1; // transacciones se realzia un
			// commit es decir un "yo firmo"

		} catch (Exception e) {
			respuesta = 0;
		}

		return respuesta;
	}

	@Override
	public int deleteAlumno(String cod) {
		int respuesta = 0;
		try {
			for (int i = 0; i < resultados.size(); i++) {
				if (Integer.parseInt(cod) == resultados.get(i).getCod()) {
					session.beginTransaction();
					session.delete(resultados.get(i));
					session.getTransaction().commit();
					respuesta = 1;
				}

			}

		} catch (Exception e) {
			respuesta = 0;
		}

		return respuesta;
	}

	@Override
	public int deleteCurso(String codCursos) {
		int respuesta = 0;
		try {
			for (int i = 0; i < resultados2.size(); i++) {
				if (Integer.parseInt(codCursos) == resultados2.get(i).getId()) {
					session.beginTransaction();
					session.delete(resultados2.get(i));
					session.getTransaction().commit();// si se ejecuta toda la
					respuesta = 1; // transacciones se realzia un
					// commit es decir un "yo firmo"
				}

			}

		} catch (Exception e) {
			respuesta = 0;
		}

		return respuesta;
	}

	@Override
	public int deleteAllAlumnos() {
		int respuesta = 0;
		try {
			for (int i = 0; i < resultados.size(); i++) {
				session.beginTransaction();
				session.delete(resultados.get(i));
				session.getTransaction().commit();// si se ejecuta toda la
				respuesta++; // transacciones se realzia un
				// commit es decir un "yo firmo"

			}

		} catch (Exception e) {
			respuesta = 0;
		}
		return respuesta;
	}

	@Override
	public int deleteAllCursos() {
		int respuesta = 0;
		try {
			for (int i = 0; i < resultados2.size(); i++) {
				session.beginTransaction();
				session.delete(resultados2.get(i));
				session.getTransaction().commit();// si se ejecuta toda la
				respuesta++; // transacciones se realzia un
				// commit es decir un "yo firmo"

			}

		} catch (Exception e) {
			respuesta = 0;
		}
		return respuesta;
	}

	@Override
	public int actualizarJugadores(Alumnos alumno) {
		int respuesta = 0;
		System.out.println("udpate hibernate!!");
		try {
			session.beginTransaction();
			session.merge(alumno);
			session.getTransaction().commit();// si se ejecuta toda la
			respuesta = 1; // transacciones se realiza un
			// commit es decir un "yo firmo"

		} catch (Exception e) {
			System.out.println("catch hibernate!");
			respuesta = 0;
		}

		return respuesta;
	}

	@Override
	public ArrayList<Cursos> getResultados2() {
		// TODO Auto-generated method stub
		return null;
	}

}
