package paquete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

/**
 * Esta clase ejecuta los métodos CRUD para la tabla Hotel.
 */
public class HotelDAO {

	private final String JDBC = "com.mysql.cj.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/agencia";
	private final String USUARIO = "root";
	private final String CLAVE = "1234";
	
	/**
	 * Inserta un registro en la tabla Hotel.
	 * @param hotel Un objeto de tipo Hotel.
	 * @return Un valor numérico que indica el resultado de la operación:
	 * <p>
	 * 0 - Registro insertado con éxito
	 * <p>
	 * 1 - Error al cargar el driver JDBC, debe existir el archivo /lib/mysql-connector-java-8.0.29.jar y estar en el Classpath
	 * <p>
	 * 2 - Error de conexión con la BD
	 * <p>
	 * 3 - El nombre del hotel ya existe
	 */
	public int add(Hotel hotel ) {
        Connection conn = null;
        try {
            Class.forName(JDBC);
            conn = DriverManager.getConnection(URL,USUARIO,CLAVE);
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Hotel (NombreHotel) VALUES (?)");
        	ps.setString(1,hotel.getNombreHotel());
        	ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: no se ha cargado el driver JDBC.");
            e.printStackTrace();
            return 1;
        } catch (SQLIntegrityConstraintViolationException e) {
        	System.out.println("El hotel ya existe");
    		e.printStackTrace();
    		return 3;
        } catch (SQLException e) {
    		System.out.println("Error en la conexión para método ADD() - insert");
    		e.printStackTrace();
    		return 2;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                	System.out.println("Error en la conexión para método ADD() - close");
                    e.printStackTrace();
                    return 2;
                }
            }
        }
    	return 0;
	}
	
	/**
	 * Busca un hotel por el nombre.
	 * @param nombreHotel El nombre exacto del hotel a buscar.
	 * @return Un objeto de tipo Hotel si se ha encontrado, o un valor null si el nombre no existe o se produjo un error.
	 */
	public Hotel findOne(String nombreHotel) {
        Connection conn = null;
        Hotel hotel = null;
        if(nombreHotel != null) {
            try {
                Class.forName(JDBC);
                conn = DriverManager.getConnection(URL,USUARIO,CLAVE);
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM Hotel WHERE NombreHotel = ?");
                ps.setString(1, nombreHotel);
                ResultSet rs = ps.executeQuery(); 
                if (rs.next()) {
                    hotel = new Hotel(
                    		rs.getInt("idHotel"),
                    		rs.getString("NombreHotel"));
                } else {
                	return null;
                } 
            } catch (ClassNotFoundException e) {
                System.out.println("ERROR: cargar JDBC driver.");
                e.printStackTrace();
                return null;
            } catch (SQLException e) {
        		System.out.println("Error en la conexión para SELECT");
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
        return hotel;
	}
	
	/**
	 * Devuelve todas los hoteles de la tabla.
	 * @return Una lista de todos los hoteles ordenada por el nombre, o un valor null si no existe ningún hotel o se produjo un error.
	 */
	public ArrayList<Hotel> findAll() {
        Connection conn = null;
        ArrayList<Hotel> hoteles = new ArrayList<Hotel>();
        Hotel hotel = null;
        try {
            Class.forName(JDBC);
            conn = DriverManager.getConnection(URL,USUARIO,CLAVE);
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Hotel ORDER BY NombreHotel");
            ResultSet rs = ps.executeQuery(); 
            while (rs.next()) {
                hotel = new Hotel(
                		rs.getInt("idHotel"),
                		rs.getString("NombreHotel"));
                hoteles.add(hotel);
            } 
           if(hoteles.isEmpty()) {
        	   return null;
           }
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: cargar JDBC driver.");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
    		System.out.println("Error en la conexión para SELECT");
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
        return hoteles;
	}
	
	/**
	 * Elimina un registro por su id.
	 * @param idHotel El identificador numérico del hotel a eliminar.
	 * @return True si se ha eliminado el registro, o False si no se ha encontrado el registro o se produjo un error.
	 */
	public boolean delete(int idHotel) {
        Connection conn = null;
        try {
            Class.forName(JDBC);
            conn = DriverManager.getConnection(URL,USUARIO,CLAVE);
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Hotel WHERE idHotel = ?");
            ps.setInt(1, idHotel);
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
    		System.out.println("Error en la conexión para DELETE");
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
	 * Elimina un registro por el nombre del hotel.
	 * @param idHotel El nombre del hotel a eliminar
	 * @return True si se ha eliminado el registro, o False si no se ha encontrado el registro o se produjo un error.
	 */
	public boolean delete(String nombreHotel) {
        Connection conn = null;
        try {
            Class.forName(JDBC);
            conn = DriverManager.getConnection(URL,USUARIO,CLAVE);
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Hotel WHERE nombreHotel = ?");
            ps.setString(1, nombreHotel);
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
    		System.out.println("Error en la conexión para DELETE");
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
	 * Modifica el nombre de un hotel.
	 * @param idHotel El identificador numérico del hotel a modificar.
	 * @param nombreHotel El nuevo nombre de hotel.
	 * @return True si se ha modificado el registro, o False si no se ha encontrado el registro o se produjo un error.
	 */
	public boolean update(int idHotel, String nombreHotel) {
        Connection conn = null;
        try {
            Class.forName(JDBC);
            conn = DriverManager.getConnection(URL,USUARIO,CLAVE);
            PreparedStatement ps = conn.prepareStatement("UPDATE Hotel SET NombreHotel = ? WHERE idHotel = ?");
            ps.setString(1, nombreHotel);
            ps.setInt(2, idHotel);
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
    		System.out.println("Error en la conexión para DELETE");
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
