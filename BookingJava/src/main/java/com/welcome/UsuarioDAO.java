package com.welcome;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

public class UsuarioDAO {
	
	private final String JDBC = "com.mysql.cj.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/agencia";
	private final String USUARIO = "root";
	private final String CLAVE = "";
	
	/**
	 * Inserta un registro en la tabla Usuario.
	 * @param usuario Un objeto de tipo Usuario.
	 * @return Un valor num�rico que indica el resultado de la operaci�n:
	 * <p>
	 * 0 - Registro insertado con �xito
	 * <p>
	 * 1 - Error al cargar el driver JDBC, debe existir el archivo /lib/mysql-connector-java-8.0.29.jar y estar en el Classpath
	 * <p>
	 * 2 - Error de conexi�n con la BD
	 * <p>
	 * 3 - El nombre del usuario ya existe
	 */
	
	// ATENCION: Falta hacer UNIQUE sobre el campo MailUsu.
	public int add(Usuario usuario) {
        Connection conn = null;
        try {
            Class.forName(JDBC);
            conn = DriverManager.getConnection(URL,USUARIO,CLAVE);
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Usuario (idUsuario,NombreUsu,ApellidoUsu,TelefonoUsu,MailUsu,PasswordUsu,idDescuento) VALUES (?,?,?,?,?,?,?)");
        	ps.setInt(1,usuario.getIdUsuario());
            ps.setString(2,usuario.getNombreUsu());
        	ps.setString(3,usuario.getApellidoUsu());
        	ps.setString(4,usuario.getTelefonoUsu());
        	ps.setString(5,usuario.getMailUsu());
        	ps.setString(6,usuario.getPasswordUsu());
        	ps.setInt(7,usuario.getIdDescuento());
        	ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: no se ha cargado el driver JDBC.");
            e.printStackTrace();
            return 1;
        } catch (SQLIntegrityConstraintViolationException e) {
        	System.out.println("El usuario ya existe, o descuento no existe");
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
	 * Busca un usuario por el mail.
	 * @param mailUsu El mail del usuario a buscar.
	 * @return Un objeto de tipo Usuario si se ha encontrado, o un valor null si el mail no existe o se produjo un error.
	 */
	public Usuario findOne(String mailUsu) {
        Connection conn = null;
        Usuario usuario = null;
        if(mailUsu != null) {
            try {
                Class.forName(JDBC);
                conn = DriverManager.getConnection(URL,USUARIO,CLAVE);
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM Usuario WHERE mailUsu = ?");
                ps.setString(1, mailUsu);
                ResultSet rs = ps.executeQuery(); 
                if (rs.next()) {
                    usuario = new Usuario(
                    		rs.getInt("idUsuario"),
                    		rs.getString("NombreUsu"),
                    		rs.getString("ApellidoUsu"),
                    		rs.getString("TelefonoUsu"),
                    		rs.getString("MailUsu"),
                    		rs.getString("PasswordUsu"),
                    		rs.getInt("idDescuento"));
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
        return usuario;
	}
	
	/**
	 * Devuelve todas los usuarios de la tabla.
	 * @return Una lista de todos los usuarios ordenada por apellido y nombre, o un valor null si no existe ning�n usuario o se produjo un error.
	 */
	public ArrayList<Usuario> findAll() {
        Connection conn = null;
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        Usuario usuario = null;
        try {
            Class.forName(JDBC);
            conn = DriverManager.getConnection(URL,USUARIO,CLAVE);
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Usuario ORDER BY ApellidoUsu,NombreUsu");
            ResultSet rs = ps.executeQuery(); 
            while (rs.next()) {
                usuario = new Usuario(
                		rs.getInt("idUsuario"),
                		rs.getString("NombreUsu"),
                		rs.getString("ApellidoUsu"),
                		rs.getString("TelefonoUsu"),
                		rs.getString("MailUsu"),
                		rs.getString("PasswordUsu"),
                		rs.getInt("idDescuento"));
                usuarios.add(usuario);
            } 
           if(usuarios.isEmpty()) {
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
        return usuarios;
	}
	
	
	/**
	 * Elimina un registro por su id.
	 * @param idUsuario El identificador num�rico del usuario a eliminar.
	 * @return True si se ha eliminado el registro, o False si no se ha encontrado el registro o se produjo un error.
	 */
	public boolean delete(int idUsuario) {
        Connection conn = null;
        try {
            Class.forName(JDBC);
            conn = DriverManager.getConnection(URL,USUARIO,CLAVE);
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Usuario WHERE idUsuario = ?");
            ps.setInt(1, idUsuario);
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
	 * modifica los datos de un usuario.
	 * @param idUsuario El identificador numerico del usuario a modificar.
	 * @param nombreUsu El nuevo nombre de usuario.
	 * @param apellidoUsu El nuevo apellido de usuario.
	 * @param telefonoUsu El nuevo telefono del usuario.
	 * @param mailUsu El nuevo mail del usuario.
	 * @param passwordUsu El nuevo password del usuario.
	 * @param idDescuento El identificador numerico del descuento que tiene el usuario, debe existir en la tabla Descuentos
	 * @return True si se ha modificado el registro, o False si no se ha encontrado el registro o se produjo un error.
	 */
	//public boolean update(int idUsuario, String nombreUsu, String apellidoUsu, String telefonoUsu, String mailUsu, String passwordUsu, int idDescuento) {
	public boolean update(int idUsuario, String telefonoUsu, String mailUsu, String passwordUsu) {
        Connection conn = null;
        try {
            Class.forName(JDBC);
            conn = DriverManager.getConnection(URL,USUARIO,CLAVE);
            //PreparedStatement ps = conn.prepareStatement("UPDATE Usuario SET NombreUsu = ?, ApellidoUsu = ?, TelefonoUsu = ?, MailUsu = ?, PasswordUsu = ?, idDescuento = ? WHERE idUsuario = ?");
            PreparedStatement ps = conn.prepareStatement("UPDATE Usuario SET  TelefonoUsu = ?, MailUsu = ?, PasswordUsu = ? WHERE idUsuario = ?");
            //ps.setString(1, nombreUsu);
            //ps.setString(2, apellidoUsu);
            ps.setString(1, telefonoUsu);
            ps.setString(2, mailUsu);
            ps.setString(3, passwordUsu);
            //ps.setInt(6, idDescuento);
            ps.setInt(4, idUsuario);
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
    		System.out.println("Error en la conexi�n para UPDATE");
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
