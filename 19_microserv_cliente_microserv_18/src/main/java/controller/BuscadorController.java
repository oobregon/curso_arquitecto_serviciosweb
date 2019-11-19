package controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuscadorController {
	@GetMapping(value = "/buscar/{email}",produces = MediaType.APPLICATION_JSON_VALUE)
	public void bucarPersona() {
		
	}
}
