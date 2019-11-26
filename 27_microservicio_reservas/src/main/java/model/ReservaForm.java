package model;

import java.io.Serializable;

public class ReservaForm implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idreserva;
	private String dni;
	private String nombre;	
	private int vuelo;
	private int plazasVuelo;
	private int hotel;
	
	public ReservaForm() {}
	
	public ReservaForm(int idreserva, String dni, String nombre, int vuelo, int plazasVuelo, int hotel) {
		super();
		this.idreserva = idreserva;
		this.dni = dni;
		this.nombre = nombre;
		this.vuelo = vuelo;
		this.plazasVuelo = plazasVuelo;
		this.hotel = hotel;
	}


	public int getVuelo() {
		return vuelo;
	}


	public void setVuelo(int vuelo) {
		this.vuelo = vuelo;
	}


	public int getHotel() {
		return hotel;
	}


	public void setHotel(int hotel) {
		this.hotel = hotel;
	}

	
	public int getIdreserva() {
		return this.idreserva;
	}

	public void setIdreserva(int idreserva) {
		this.idreserva = idreserva;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPlazasVuelo() {
		return plazasVuelo;
	}

	public void setPlazasVuelo(int plazasVuelo) {
		this.plazasVuelo = plazasVuelo;
	}
}