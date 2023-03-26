package paquete;

public class Descuento {
	
	private int idDescuento;
	private String nombreDescuento;
	private int porcentajeDescuento;
	public Descuento() {
		super();
	}
	
	public Descuento(int idDescuento, String nombreDescuento, int porcentajeDescuento) {
		super();
		this.idDescuento = idDescuento;
		this.nombreDescuento = nombreDescuento;
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public int getIdDescuento() {
		return idDescuento;
	}

	public void setIdDescuento(int idDescuento) {
		this.idDescuento = idDescuento;
	}

	public String getNombreDescuento() {
		return nombreDescuento;
	}

	public void setNombreDescuento(String nombreDescuento) {
		this.nombreDescuento = nombreDescuento;
	}

	public int getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(int porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

}