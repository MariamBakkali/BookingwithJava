package paquete;

import java.sql.Date;

public class Reserva {
	
	private int idReserva;
	private Date fechaRes;
	private int pasajerosRes;
	private int idUsuario;
	private int idViajes;
	
	public Reserva() {
		super();
	}
	
	public Reserva(int idReserva, Date fechaRes, int pasajerosRes, int idUsuario, int idViajes) {
		super();
		this.idReserva = idReserva;
		this.fechaRes = fechaRes;
		this.pasajerosRes = pasajerosRes;
		this.idUsuario = idUsuario;
		this.idViajes = idViajes;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public Date getFechaRes() {
		return fechaRes;
	}

	public void setFechaRes(Date fechaRes) {
		this.fechaRes = fechaRes;
	}

	public int getPasajerosRes() {
		return pasajerosRes;
	}

	public void setPasajerosRes(int pasajerosRes) {
		this.pasajerosRes = pasajerosRes;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdViajes() {
		return idViajes;
	}

	public void setIdViajes(int idViajes) {
		this.idViajes = idViajes;
	}

}