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
// Podríamos poner a todos los métodos las misma url, con lo cual, te ahorras poner la misma:
// Le asignamos la url de base a nivel de clase:
// @RestController (value = "/busqueda")
//
// Así, los métodos de búsqueda POr ejemplo, en el caso de las urls de busqueda quedarían así:
// @GetMapping (produces = MediaType.APPLICATION_JSON_VALUE) 
// dameContactos()
//
// @GetMapping (value = "/{email}",produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class ContactosController {
	@Autowired
	DaoContactos daoCon;
	
	@GetMapping (value = "/busqueda",produces = MediaType.APPLICATION_JSON_VALUE)
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
	
	@PostMapping(value="/accion", produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String altaContacto(@RequestBody Contacto contacto) {
		String resultado = "0"; // Finalización existosa
		try {
			daoCon.altaContactoParametrizado(contacto);			
		} catch (Exception ex) {
			resultado = "1";
		}						
		return resultado;
	}
}
