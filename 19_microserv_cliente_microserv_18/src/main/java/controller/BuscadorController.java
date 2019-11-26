package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import model.Persona;

@RestController
public class BuscadorController {
	// Inyectame el valor de esta propiedad.
	// Spring busca en todos los ficheros de properties del classpath en busca 
	// de la propiedad indicada.
	@Value("${propia.servicio.rest.personas}")
	String url;
	
	@Autowired
	RestTemplate template;

	
	@GetMapping(value = "/buscar/{email}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Persona bucarPersona(@PathVariable("email") String email) {
		Persona persona = null;
		Persona[] personas = template.getForObject(url,Persona[].class);
		for(Persona p:personas) {
			if(p.getEmail().equals(email)) {
				persona=p;
			}
		}
		return persona;
	}
}
