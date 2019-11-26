package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the reservas database table.
 * 
 */
@Entity
@Table(name="reservas")
@NamedQuery(name="Reserva.findAll", query="SELECT r FROM Reserva r")
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idreserva;

	private String dni;

	private String nombre;
	
	private int vuelo;
	
	private int hotel;

	public int getVuelo() {
		return vuelo;
	}

	public Reserva(int idreserva, String dni, String nombre, int vuelo, int hotel) {
		super();
		this.idreserva = idreserva;
		this.dni = dni;
		this.nombre = nombre;
		this.vuelo = vuelo;
		this.hotel = hotel;
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


	public Reserva() {
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

}