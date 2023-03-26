package com.welcome;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

/**
 * Esta clase ejecuta los m�todos CRUD para la tabla Ciudad.
 */
public class CiudadDAO {

	private final String JDBC = "com.mysql.cj.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/agencia";
	private final String USUARIO = "root";
	private final String CLAVE = "";
	
	/**
	 * Inserta un registro en la tabla Ciudad.
	 * @param ciudad Un objeto de tipo Ciudad.
	 * @return Un valor num�rico que indica el resultado de la operaci�n:
	 * <p>
	 * 0 - Registro insertado con �xito
	 * <p>
	 * 1 - Error al cargar el driver JDBC, debe existir el archivo /lib/mysql-connector-java-8.0.29.jar y estar en el Classpath
	 * <p>
	 * 2 - Error de conexi�n con la BD
	 * <p>
	 * 3 - El nombre de la ciudad ya existe
	 */
	public int add(Ciudad ciudad ) {
        Connection conn = null;
        try {
            Class.forName(JDBC);
            conn = DriverManager.getConnection(URL,USUARIO,CLAVE);
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Ciudad (NombreCiudad) VALUES (?)");
        	ps.setString(1,ciudad.getNombreCiudad());
        	ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: no se ha cargado el driver JDBC.");
            e.printStackTrace();
            return 1;
        } catch (SQLIntegrityConstraintViolationException e) {
        	System.out.println("La ciudad ya existe");
    		e.printStackTrace();
    		return 3;
        } catch (SQLException e) {
    		System.out.println("Error en la conexi�n para m�todo ADD() - insert");
    		e.printStackTrace();
    		return 2;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                	System.out.println("Error en la conexi�n para m�todo ADD() - close");
                    e.printStackTrace();
                    return 2;
                }
            }
        }
    	return 0;
	}
	
	/**
	 * Busca una ciudad por el nombre.
	 * @param nombreCiudad El nombre exacto de la ciudad a buscar.
	 * @return Un objeto de tipo Ciudad si se ha encontrado, o un valor null si el nombre no existe o se produjo un error.
	 */
	public Ciudad findOne(String nombreCiudad) {
        Connection conn = null;
        Ciudad ciudad = null;
        if(nombreCiudad != null) {
            try {
                Class.forName(JDBC);
                conn = DriverManager.getConnection(URL,USUARIO,CLAVE);
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM Ciudad WHERE NombreCiudad = ?");
                ps.setString(1, nombreCiudad);
                ResultSet rs = ps.executeQuery(); 
                if (rs.next()) {
                    ciudad = new Ciudad(
                    		rs.getInt("idCiudad"),
                    		rs.getString("NombreCiudad"));
                } else {
                	return null;
                } 
            } catch (ClassNotFoundException e) {
                System.out.println("ERROR: cargar JDBC driver.");
                e.printStackTrace();
                return null;
            } catch (SQLException e) {
        		System.out.println("Error en la conexi�n para SELECT");
        		e.printStackTrace();
        		return null;
            } finally {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return ciudad;
	}
	
	/**
	 * Devuelve todas las ciudades de la tabla.
	 * @return Una lista de todas la ciudades ordenadas por el nombre, o un valor null si no existe nniguna ciudad o se produjo un error.
	 */
	public ArrayList<Ciudad> findAll() {
        Connection conn = null;
        ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
        Ciudad ciudad = null;
        try {
            Class.forName(JDBC);
            conn = DriverManager.getConnection(URL,USUARIO,CLAVE);
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Ciudad ORDER BY NombreCiudad");
            ResultSet rs = ps.executeQuery(); 
            while (rs.next()) {
                ciudad = new Ciudad(
                		rs.getInt("idCiudad"),
                		rs.getString("NombreCiudad"));
                ciudades.add(ciudad);
            } 
           if(ciudades.isEmpty()) {
        	   return null;
           }
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: cargar JDBC driver.");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
    		System.out.println("Error en la conexi�n para SELECT");
    		e.printStackTrace();
    		return null;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return ciudades;
	}
	
	/**
	 * Elimina un registro por su id.
	 * @param idCiudad El identificador num�rico de la ciudad a eliminar.
	 * @return True si se ha eliminado el registro, o False si no se ha encontrado el registro o se produjo un error.
	 */
	public boolean delete(int idCiudad) {
        Connection conn = null;
        try {
            Class.forName(JDBC);
            conn = DriverManager.getConnection(URL,USUARIO,CLAVE);
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Ciudad WHERE idCiudad = ?");
            ps.setInt(1, idCiudad);
            if(ps.executeUpdate()==1) {
                return true;            	
            } else {
                return false;
            }
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: cargar JDBC driver.");
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
    		System.out.println("Error en la conexi�n para DELETE");
    		e.printStackTrace();
    		return false;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	
	/**
	 * Elimina un registro por el nombre de ciudad.
	 * @param idCiudad El nombre de la ciudad a eliminar
	 * @return True si se ha eliminado el registro, o False si no se ha encontrado el registro o se produjo un error.
	 */
	public boolean delete(String nombreCiudad) {
        Connection conn = null;
        try {
            Class.forName(JDBC);
            conn = DriverManager.getConnection(URL,USUARIO,CLAVE);
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Ciudad WHERE nombreCiudad = ?");
            ps.setString(1, nombreCiudad);
            if(ps.executeUpdate()==1) {
                return true;            	
            } else {
                return false;
            }
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: cargar JDBC driver.");
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
    		System.out.println("Error en la conexi�n para DELETE");
    		e.printStackTrace();
    		return false;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	
	/**
	 * Modifica el nombre de una ciudad.
	 * @param idCiudad El identificador num�rico de la ciudad a modificar.
	 * @param nombreCiudad El nuevo nombre de ciudad.
	 * @return True si se ha modificado el registro, o False si no se ha encontrado el registro o se produjo un error.
	 */
	public boolean update(int idCiudad, String nombreCiudad) {
        Connection conn = null;
        try {
            Class.forName(JDBC);
            conn = DriverManager.getConnection(URL,USUARIO,CLAVE);
            PreparedStatement ps = conn.prepareStatement("UPDATE Ciudad SET NombreCiudad = ? WHERE idCiudad = ?");
            ps.setString(1, nombreCiudad);
            ps.setInt(2, idCiudad);
            if(ps.executeUpdate()==1) {
                return true;            	
            } else {
                return false;
            }
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: cargar JDBC driver.");
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
    		System.out.println("Error en la conexi�n para DELETE");
    		e.printStackTrace();
    		return false;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
	}

	

}
