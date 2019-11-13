package controlador;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Persona;

@RestController
public class SaludoController {
	
	// Recurso 1
	@GetMapping (value = "/saludo",produces = MediaType.TEXT_PLAIN_VALUE)
	public String saludar() {
		return "Bienvenido a mi servicio rest";
	}
		
	// Recurso 2
	// Método con variables que va a recibir el método
	// Dicha variable la tenemos que mapear en el método; este mapeo lo hacemos con @PathVariable
	@GetMapping (value = "/saludo/{name}",produces = MediaType.TEXT_PLAIN_VALUE)
	public String saludar(@PathVariable("name") String n) {
		return "Bienvenido a mi servicio rest " + n;
	}
	
	//Recurso 3
	// Nosotros trabajamos con la clase Persona como tipo de devolución. Internamente, cuando se produzca la devolución, jackson mapea
	// auotmáticmetne el javabean a json. 
	// Entonces no retorna un objeto Persona, sino que retorna un objeto json 
	@GetMapping (value = "/ficha",produces = MediaType.APPLICATION_JSON_VALUE)
	public Persona obtenerFichaJson() {
		return new Persona("Oscar","espana@gmail.com",45);
	}
	
	
	// Recurso 4
	@PostMapping(value="/saludo", produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String recibirJson(@RequestBody Persona persona) {
		return "Bienvenido " + persona.getNombre()+ " "+persona.getEmail();
	}
	
	// Recurso 5
	@DeleteMapping(value="/saludo/{name}")
	public void eliminar(@PathVariable("name") String n) {
		System.out.println("Eliminar a " + n);
	}
}
