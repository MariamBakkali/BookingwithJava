package paquete;

public class Hotel {
	
	private int idHotel;
	private String nombreHotel;
	
	public Hotel() {
		super();
	}
	public Hotel(int idHotel, String nombreHotel) {
		super();
		this.idHotel = idHotel;
		this.nombreHotel = nombreHotel;
	}
	public int getIdHotel() {
		return idHotel;
	}
	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}
	public String getNombreHotel() {
		return nombreHotel;
	}
	public void setNombreHotel(String nombreHotel) {
		this.nombreHotel = nombreHotel;
	}
	
}
