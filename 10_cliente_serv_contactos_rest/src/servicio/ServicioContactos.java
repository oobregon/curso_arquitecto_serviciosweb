package servicio;

import model.Contacto;

public interface ServicioContactos {
	public void alta(Contacto c);
	public Contacto[] obtenerContactos();
	public void eliminar(int idContacto);
}
