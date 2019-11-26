package model;

public class Hotel {
	private int idHotel;
	private int categoria;
	private byte disponible;
	private String nombre;
	private double precio;
	
	public Hotel() {
		
	}
	
	public Hotel(int idHotel, int categoria, byte disponible, String nombre, double precio) {
		super();
		this.idHotel = idHotel;
		this.categoria = categoria;
		this.disponible = disponible;
		this.nombre = nombre;
		this.precio = precio;
	}
	public int getIdHotel() {
		return idHotel;
	}
	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public byte getDisponible() {
		return disponible;
	}
	public void setDisponible(byte disponible) {
		this.disponible = disponible;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}	
}
