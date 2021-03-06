package controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import daos.DaoContactos;
import model.Contacto;

// 
// Podr�amos asignar a todos los m�todos/recursos la misma url, con lo cual, nos ahorramos el mismo
// value en cada m�todo; para conseguir esto tenemos que declarar la url a nivel de Clase:
// Le asignamos la url de base a nivel de clase:
// @RestController (value = "/busqueda")
//
// As�, los m�todos de b�squeda Por ejemplo, en el caso de las urls de busqueda quedar�an de la siguiente manera,
// no siendo necesario especificar la propiedad value porque ya est� establecida a nivel de clase:
// @GetMapping (produces = MediaType.APPLICATION_JSON_VALUE) 
// dameContactos()
//
// @GetMapping (value = "/{email}",produces = MediaType.APPLICATION_JSON_VALUE)
// dameContactoPorCorrElec()

@RestController
public class ContactosController {
	@Autowired
	DaoContactos daoCon;
	
	@GetMapping (value = "/busqueda", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Contacto> dameContactos() {
		List<Contacto> contactos = daoCon.dameContactos();		
		return contactos;
	}
	
	@GetMapping (value = "/busqueda/{email}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Contacto dameContactoPorCorrElec(@PathVariable("email") String corrElect) {
		Contacto contacto = daoCon.dameContacto(corrElect);		
		return contacto;
	}
	
	@DeleteMapping (value = "/accion/{idcontacto}",produces = MediaType.TEXT_PLAIN_VALUE)
	public String eliminarContactoPorIdContacto(@PathVariable("idcontacto") String idContacto) {
		String resultado = "Borrado realizado correctamente";
		try {
			daoCon.eliminarContacto(Integer.parseInt(idContacto));
		} catch (Exception ex) {
			resultado = "Borrado realizado incorrectamente";
		}						
		return resultado;
	}
	
	@PostMapping(value="/accion", consumes = MediaType.APPLICATION_JSON_VALUE, 
								  produces = MediaType.TEXT_PLAIN_VALUE)
	public String altaContacto(@RequestBody Contacto contacto) {
		String resultado = "0"; // Finalizaci�n exitosa
		try {
			daoCon.altaContactoParametrizado(contacto);			
		} catch (Exception ex) {
			resultado = "1";
		}						
		return resultado;
	}
}
