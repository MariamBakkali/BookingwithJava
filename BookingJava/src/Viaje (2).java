package paquete;

public class Viaje {
	
	private int idViaje;
	private String descripcionVia;
	private String duracionVia;
	private float precioVia;
	private String fotoVia;
	private int idHotel;
	private int idCiudad;
	
	public Viaje() {
		super();
	}

	public Viaje(int idViaje, String descripcionVia, String duracionVia, float precioVia, String fotoVia, int idHotel,
			int idCiudad) {
		super();
		this.idViaje = idViaje;
		this.descripcionVia = descripcionVia;
		this.duracionVia = duracionVia;
		this.precioVia = precioVia;
		this.fotoVia = fotoVia;
		this.idHotel = idHotel;
		this.idCiudad = idCiudad;
	}

	public int getIdViaje() {
		return idViaje;
	}

	public void setIdViaje(int idViaje) {
		this.idViaje = idViaje;
	}

	public String getDescripcionVia() {
		return descripcionVia;
	}

	public void setDescripcionVia(String descripcionVia) {
		this.descripcionVia = descripcionVia;
	}

	public String getDuracionVia() {
		return duracionVia;
	}

	public void setDuracionVia(String duracionVia) {
		this.duracionVia = duracionVia;
	}

	public float getPrecioVia() {
		return precioVia;
	}

	public void setPrecioVia(float precioVia) {
		this.precioVia = precioVia;
	}

	public String getFotoVia() {
		return fotoVia;
	}

	public void setFotoVia(String fotoVia) {
		this.fotoVia = fotoVia;
	}

	public int getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}

	public int getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}

}