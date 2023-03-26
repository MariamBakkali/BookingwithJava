package com.welcome;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

public class DescuentoDAO {
	
	private final String JDBC = "com.mysql.cj.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/agencia";
	private final String USUARIO = "root";
	private final String CLAVE = "";
	
	/**
	 * Inserta un registro en la tabla Descuento.
	 * @param descuento Un objeto de tipo Descuento.
	 * @return Un valor num�rico que indica el resultado de la operaci�n:
	 * <p>
	 * 0 - Registro insertado con �xito
	 * <p>
	 * 1 - Error al cargar el driver JDBC, debe existir el archivo /lib/mysql-connector-java-8.0.29.jar y estar en el Classpath
	 * <p>
	 * 2 - Error de conexi�n con la BD
	 * <p>
	 * 3 - El nombre del descuento ya existe
	 */
	public int add(Descuento descuento ) {
        Connection conn = null;
        try {
            Class.forName(JDBC);
            conn = DriverManager.getConnection(URL,USUARIO,CLAVE);
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Descuento (NombreDescuento,PorcentajeDescuento) VALUES (?,?)");
        	ps.setString(1,descuento.getNombreDescuento());
        	ps.setInt(2,descuento.getPorcentajeDescuento());
        	ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: no se ha cargado el driver JDBC.");
            e.printStackTrace();
            return 1;
        } catch (SQLIntegrityConstraintViolationException e) {
        	System.out.println("El descuento ya existe");
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
	 * Busca un descuento por el nombre.
	 * @param nombreDescuento El nombre exacto del descuento a buscar.
	 * @return Un objeto de tipo Descuento si se ha encontrado, o un valor null si el nombre no existe o se produjo un error.
	 */
	public Descuento findOne(String nombreDescuento) {
        Connection conn = null;
        Descuento descuento = null;
        if(nombreDescuento != null) {
            try {
                Class.forName(JDBC);
                conn = DriverManager.getConnection(URL,USUARIO,CLAVE);
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM Descuento WHERE NombreDescuento = ?");
                ps.setString(1, nombreDescuento);
                ResultSet rs = ps.executeQuery(); 
                if (rs.next()) {
                    descuento = new Descuento(
                    		rs.getInt("idDescuento"),
                    		rs.getString("NombreDescuento"),
                    		rs.getInt("PorcentajeDescuento"));
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
        return descuento;
	}
	
	/**
	 * Devuelve todas los descuentos de la tabla.
	 * @return Una lista de todos los descuentos ordenada por el nombre, o un valor null si no existe ning�n descuento o se produjo un error.
	 */
	public ArrayList<Descuento> findAll() {
        Connection conn = null;
        ArrayList<Descuento> descuentos = new ArrayList<Descuento>();
        Descuento descuento = null;
        try {
            Class.forName(JDBC);
            conn = DriverManager.getConnection(URL,USUARIO,CLAVE);
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Descuento ORDER BY NombreDescuento");
            ResultSet rs = ps.executeQuery(); 
            while (rs.next()) {
                descuento = new Descuento(
                		rs.getInt("idDescuento"),
                		rs.getString("NombreDescuento"),
                		rs.getInt("PorcentajeDescuento"));
                descuentos.add(descuento);
            } 
           if(descuentos.isEmpty()) {
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
        return descuentos;
	}
	
	/**
	 * Elimina un registro por su id.
	 * @param idDescuento El identificador num�rico del descuento a eliminar.
	 * @return True si se ha eliminado el registro, o False si no se ha encontrado el registro o se produjo un error.
	 */
	public boolean delete(int idDescuento) {
        Connection conn = null;
        try {
            Class.forName(JDBC);
            conn = DriverManager.getConnection(URL,USUARIO,CLAVE);
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Descuento WHERE idDescuento = ?");
            ps.setInt(1, idDescuento);
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
	 * Elimina un registro por el nombre del descuento.
	 * @param idDescuento El nombre del descuento a eliminar
	 * @return True si se ha eliminado el registro, o False si no se ha encontrado el registro o se produjo un error.
	 */
	public boolean delete(String nombreDescuento) {
        Connection conn = null;
        try {
            Class.forName(JDBC);
            conn = DriverManager.getConnection(URL,USUARIO,CLAVE);
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Descuento WHERE nombreDescuento = ?");
            ps.setString(1, nombreDescuento);
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
	 * Modifica el nombre de un descuento.
	 * @param idDescuento El identificador num�rico del descuento a modificar.
	 * @param nombreDescuento El nuevo nombre de descuento.
	 * @return True si se ha modificado el registro, o False si no se ha encontrado el registro o se produjo un error.
	 */
	public boolean update(int idDescuento, String nombreDescuento, int porcentajeDescuento) {
        Connection conn = null;
        try {
            Class.forName(JDBC);
            conn = DriverManager.getConnection(URL,USUARIO,CLAVE);
            PreparedStatement ps = conn.prepareStatement("UPDATE Descuento SET NombreDescuento = ?, PorcentajeDescuento = ? WHERE idDescuento = ?");
            ps.setString(1, nombreDescuento);
            ps.setInt(2, porcentajeDescuento);
            ps.setInt(3, idDescuento);
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
