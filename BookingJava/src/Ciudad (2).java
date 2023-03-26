package paquete;

public class Ciudad {
	
	private int idCiudad;
	private String nombreCiudad;
	
	
	public Ciudad() {
		super();
	}

	public Ciudad(String nombreCiudad) {
		super();
		this.nombreCiudad = nombreCiudad;
	}
	
	public Ciudad(int idCiudad, String nombreCiudad) {
		super();
		this.idCiudad = idCiudad;
		this.nombreCiudad = nombreCiudad;
	}

	public int getIdCiudad() {
		return idCiudad;
	}


	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}


	public String getNombreCiudad() {
		return nombreCiudad;
	}


	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}

}