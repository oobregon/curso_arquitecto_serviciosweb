package model;

public class Reserva {
	private int idreserva;
	private String nombre;
	private int dni;	
	private int hotel;
	private int vuelo;
	
	public Reserva() {}
	
	public Reserva(int idreserva, String nombre, int dni, int hotel, int vuelo) {
		super();
		this.idreserva = idreserva;
		this.nombre = nombre;
		this.dni = dni;
		this.hotel = hotel;
		this.vuelo = vuelo;
	}
	public int getIdreserva() {
		return idreserva;
	}
	public void setIdreserva(int idreserva) {
		this.idreserva = idreserva;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public int getHotel() {
		return hotel;
	}
	public void setHotel(int hotel) {
		this.hotel = hotel;
	}
	public int getVuelo() {
		return vuelo;
	}
	public void setVuelo(int vuelo) {
		this.vuelo = vuelo;
	}
	
	
}
