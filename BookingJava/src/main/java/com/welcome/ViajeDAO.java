package com.welcome;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

public class ViajeDAO {
	
	private final String JDBC = "com.mysql.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/agencia";
	private final String USUARIO = "root";
	public static String CLAVE = "";
	

	public int add(Viaje viaje) {
		Connection conn = null;
		
		try {
			Class.forName(JDBC);
			conn = DriverManager.getConnection(URL, USUARIO, CLAVE);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Viajes (NombreVia,DescripcionVia,DuracionVia,PrecioVia,FotoVia,idHotel,idCiudad) VALUES (?,?,?,?,?,?,?)");
			
			ps.setString(1, viaje.getNombreVia());
			ps.setString(2, viaje.getDescripcionVia());
			ps.setString(3, viaje.getDuracionVia());
			ps.setFloat(4, viaje.getPrecioVia());
			ps.setString(5, viaje.getFotoVia());
			ps.setInt(6, viaje.getIdHotel());
			ps.setInt(7, viaje.getIdCiudad());
			
			ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR: no se ha cargado el driver JDBC.");
			e.printStackTrace();
			return 1;
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("El viaje ya existe, o hotel no existe, o ciuda dno existe.");
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
	
	
	
	public Viaje findOne(String nombreVia) {
		Connection conn = null;
		Viaje viaje = null;
		
		if(nombreVia != null) {
			try {
				Class.forName(JDBC);
				conn = DriverManager.getConnection(URL, USUARIO, CLAVE);
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM Viajes WHERE nombreVia = ?");
				
				ps.setString(1, nombreVia);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					viaje = new Viaje (
							rs.getInt("idViajes"),
							rs.getString("NombreVia"),
							rs.getString("DescripcionVia"),
							rs.getString("DuracionVia"),
							rs.getFloat("PrecioVia"),
							rs.getString("FotoVia"),
							rs.getInt("idHotel"),
							rs.getInt("idCiudad"));
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
					}catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return viaje;
	}
	
	
	public ArrayList<Viaje> findAll() {
		Connection conn = null;
		ArrayList<Viaje> viajes = new ArrayList<Viaje>();
		Viaje viaje = null;
		try {
			Class.forName(JDBC);
			conn = DriverManager.getConnection(URL,USUARIO,CLAVE);
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM viajes ORDER BY NombreVia");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				viaje = new Viaje(
					rs.getInt("idViajes"),
					rs.getString("NombreVia"),
					rs.getString("DescripcionVia"),
					rs.getString("DuracionVia"),
					rs.getFloat("PrecioVia"),
					rs.getString("FotoVia"),
					rs.getInt("idHotel"),
					rs.getInt("idCiudad"));
				viajes.add(viaje);
			}
			
			if(viajes.isEmpty()) {
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
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return viajes;
	}
	
	
	
	public boolean delete(int idViaje) {
		Connection conn = null;
		
		try {
			Class.forName(JDBC);
			conn = DriverManager.getConnection(URL,USUARIO,CLAVE);
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Viajes WHERE idViajes= ?");
			
			ps.setInt(1, idViaje);
			if(ps.executeUpdate()==1) {
				return true;
			} else {
				return false;
			}
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR: cargar JDBC driver");
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
	
	
	public boolean update(int idViaje, String nombreVia, String descripcionVia, String duracionVia, float precioVia, String fotoVia, int idHotel, int idCiudad) {
		Connection conn = null;
		try {
			Class.forName(JDBC);
			conn = DriverManager.getConnection(URL,USUARIO,CLAVE);
			PreparedStatement ps = conn.prepareStatement("UPDATE Viajes SET NombreVia = ?, DescripcionVia = ?, DuracionVia = ?, PrecioVia = ?, FotoVia = ?, idHotel = ?, idCiudad = ? WHERE id Viajes = ? ");
			
			ps.setString(1, nombreVia);
			ps.setString(2, descripcionVia);
			ps.setString(3, descripcionVia);
			ps.setFloat(4, precioVia);
			ps.setString(5, fotoVia);
			ps.setInt(6, idHotel);
			ps.setInt(7, idCiudad);
			ps.setInt(8, idViaje);
			if (ps.executeUpdate()==1) {
				return true;
			} else {
				return false;
			}
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR: cargar JDBC driver");
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			System.out.println("Error en la conexión para DELETE");
			e.printStackTrace();
			return false;
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	


}
