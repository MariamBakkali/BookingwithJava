package com.welcome;

public class Usuario {
	
	private int idUsuario;
	private String nombreUsu;
	private String apellidoUsu;
	private String telefonoUsu;
	private String mailUsu;
	private String passwordUsu;
	private int idDescuento;
	
	public Usuario() {
		super();
	}

	public Usuario(int idUsuario, String nombreUsu, String apellidoUsu, String telefonoUsu, String mailUsu,
			String passwordUsu, int idDescuento) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsu = nombreUsu;
		this.apellidoUsu = apellidoUsu;
		this.telefonoUsu = telefonoUsu;
		this.mailUsu = mailUsu;
		this.passwordUsu = passwordUsu;
		this.idDescuento = idDescuento;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsu() {
		return nombreUsu;
	}

	public void setNombreUsu(String nombreUsu) {
		this.nombreUsu = nombreUsu;
	}

	public String getApellidoUsu() {
		return apellidoUsu;
	}

	public void setApellidoUsu(String apellidoUsu) {
		this.apellidoUsu = apellidoUsu;
	}

	public String getTelefonoUsu() {
		return telefonoUsu;
	}

	public void setTelefonoUsu(String telefonoUsu) {
		this.telefonoUsu = telefonoUsu;
	}

	public String getMailUsu() {
		return mailUsu;
	}

	public void setMailUsu(String mailUsu) {
		this.mailUsu = mailUsu;
	}

	public String getPasswordUsu() {
		return passwordUsu;
	}

	public void setPasswordUsu(String passwordUsu) {
		this.passwordUsu = passwordUsu;
	}

	public int getIdDescuento() {
		return idDescuento;
	}

	public void setIdDescuento(int idDescuento) {
		this.idDescuento = idDescuento;
	}

}
