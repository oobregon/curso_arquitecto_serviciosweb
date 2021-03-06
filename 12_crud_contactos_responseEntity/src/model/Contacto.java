package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the contactos database table.
 * 
 */
@Entity
@Table(name="contactos")
public class Contacto implements Serializable {
	public Contacto(int idContacto, int edad, String email, String nombre) {
		super();
		this.idContacto = idContacto;
		this.edad = edad;
		this.email = email;
		this.nombre = nombre;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idContacto;

	// Esta anotación de @Column(name = "edad") la he puesto yo. 
	// El asistente no ha puesto esta anotaciones automáticamente porque entiende que solamente van a ser necesarias si 
	// se cambia el nombre de estas variables miembro; se puede cambiar el nombre, pero en la anotación siempre tendría que
	// apararecer el nombre real de la columna
	@Column(name = "edad")
	private int edad;

	private String email;

	private String nombre;

	public Contacto() {
	}

	public int getIdContacto() {
		return this.idContacto;
	}

	public void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}