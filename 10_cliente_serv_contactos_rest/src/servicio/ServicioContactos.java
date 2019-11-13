package servicio;

import java.util.List;

import model.Contacto;

public interface ServicioContactos {
	public void alta(Contacto c);
	public List<Contacto> obtenerContactos();
	public void eliminar(int idContacto);
}
