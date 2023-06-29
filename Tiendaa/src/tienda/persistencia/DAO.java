package tienda.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO {
	
	protected Connection conexion = null;
	protected ResultSet resultado = null;
	protected Statement sentencia = null;
	
	// Constantes que deben cambiar nunca
	
	private final String USER = "root";
	private final String PASSWORD = "root";
	private final String DATABASE = "tienda";
	private final String DRIVER = "com.mysql.jdbc.Driver";
	
	// Crear métodos que van a heredar sus hijos 
	// Método conectarBase
	
	protected void conectarBase() throws Exception {
		
		try {
			Class.forName(DRIVER);
			String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=False";
			conexion = DriverManager.getConnection(urlBaseDeDatos, USER, PASSWORD);
		} catch (ClassNotFoundException | SQLException exception) {
			throw exception;
		}
		
	}
	
	// Método desconectarBase 
	
	protected void desconectarBase() throws Exception {
		try {
			if (resultado != null) {
				resultado.close();
			}
			if (sentencia != null) {
				sentencia.close();
			}
			if (conexion != null) {
				conexion.close();
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	// Método insertarModificarEliminar 
	
	protected void insertarModificarEliminar(String sql) throws Exception {
	    conectarBase();
	    conexion.setAutoCommit(false); // Desactivar el autocommit
	    
	    try {
	        sentencia = conexion.createStatement();
	        sentencia.executeUpdate(sql);
	        
	        conexion.commit(); // Confirmar los cambios si no hay excepciones
	    } catch (SQLException ex) {
	        conexion.rollback(); // Revertir los cambios en caso de excepción
	        throw ex;
	    } finally {
	        conexion.setAutoCommit(true); // Restaurar el autocommit a su estado original
	        desconectarBase();
	    }
	}
	//metodo para consultar una base de datos
	protected void consultarBaseDatos(String sql) throws Exception {
		try {
			//solo es entrar , leer y cerrar base 
			conectarBase();
			sentencia = conexion.createStatement();
			resultado =  sentencia.executeQuery(sql);
			
		} catch (Exception e) {
			throw e;
		}
		
	}

}
