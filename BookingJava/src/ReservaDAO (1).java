package paquete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

public class ReservaDAO {

	private final String JDBC = "com.mysql.cj.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/agencia";
	private final String USUARIO = "root";
	private final String CLAVE = "1234";
	
	/**
	 * Inserta un registro en la tabla Reserva.
	 * @param reserva Un objeto de tipo Reserva.
	 * @return Un valor numérico que indica el resultado de la operación:
	 * <p>
	 * 0 - Registro insertado con éxito
	 * <p>
	 * 1 - Error al cargar el driver JDBC, debe existir el archivo /lib/mysql-connector-java-8.0.29.jar y estar en el Classpath
	 * <p>
	 * 2 - Error de conexión con la BD
	 * <p>
	 * 3 - La reserva ya existe
	 */
	public int add(Reserva reserva ) {
        Connection conn = null;
        try {
            Class.forName(JDBC);
            conn = DriverManager.getConnection(URL,USUARIO,CLAVE);
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Reservas (FechaRes,PasajerosRes,idUsuario,idViajes) VALUES (?,?,?,?)");
        	ps.setDate(1,reserva.getFechaRes());
        	ps.setInt(2, reserva.getPasajerosRes());
        	ps.setInt(3, reserva.getIdUsuario());
        	ps.setInt(4,reserva.getIdViajes());
        	ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: no se ha cargado el driver JDBC.");
            e.printStackTrace();
            return 1;
        } catch (SQLIntegrityConstraintViolationException e) {
        	System.out.println("La reserva ya existe, o restriccion de usuario, o restriccion de viaje");
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
	 * Busca una reserva por el ID.
	 * @param nombreReserva El nombre exacto de la reserva a buscar.
	 * @return Un objeto de tipo Reserva si se ha encontrado, o un valor null si el nombre no existe o se produjo un error.
	 */
	public Reserva findOne(int idReserva) {
        Connection conn = null;
        Reserva reserva = null;
        if(idReserva > 0) {
            try {
                Class.forName(JDBC);
                conn = DriverManager.getConnection(URL,USUARIO,CLAVE);
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM Reservas WHERE idReservas = ?");
                ps.setInt(1, idReserva);
                ResultSet rs = ps.executeQuery(); 
                if (rs.next()) {
                	reserva = new Reserva(
                    		rs.getInt("idReservas"),
                    		rs.getDate("fechaRes"),
                    		rs.getInt("pasajerosRes"),
                    		rs.getInt("idUsuario"),
                    		rs.getInt("idViajes"));
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
        return reserva;
	}
	
	/**
	 * Devuelve todas las reservas de la tabla.
	 * @return Una lista de todas las reservas ordenada por fecha, o un valor null si no existe ninguna reserva o se produjo un error.
	 */
	public ArrayList<Reserva> findAll() {
        Connection conn = null;
        ArrayList<Reserva> reservas = new ArrayList<Reserva>();
        Reserva reserva = null;
        try {
            Class.forName(JDBC);
            conn = DriverManager.getConnection(URL,USUARIO,CLAVE);
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Reservas ORDER BY fechaRes");
            ResultSet rs = ps.executeQuery(); 
            while (rs.next()) {
                reserva = new Reserva(
                		rs.getInt("idReservas"),
                		rs.getDate("fechaRes"),
                		rs.getInt("pasajerosRes"),
                		rs.getInt("idUsuario"),
                		rs.getInt("idViajes"));
                reservas.add(reserva);
            } 
           if(reservas.isEmpty()) {
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
        return reservas;
	}
	
	
	/**
	 * Elimina un registro por su id.
	 * @param idReserva El identificador numérico de la reserva a eliminar.
	 * @return True si se ha eliminado el registro, o False si no se ha encontrado el registro o se produjo un error.
	 */
	public boolean delete(int idReserva) {
        Connection conn = null;
        try {
            Class.forName(JDBC);
            conn = DriverManager.getConnection(URL,USUARIO,CLAVE);
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Reservas WHERE idReservas = ?");
            ps.setInt(1, idReserva);
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
