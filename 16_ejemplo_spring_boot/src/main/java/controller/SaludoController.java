package controller;

import javax.websocket.server.PathParam;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {
	
	@GetMapping (value = "/saludo",produces = MediaType.TEXT_PLAIN_VALUE)
	public String saludar( ) {
		return "Bienvenido a spring boot";
	}
	
	@GetMapping (value = "/contar",produces = MediaType.TEXT_PLAIN_VALUE)
	public String contar(@PathParam("cad") String cad) {
		return String.valueOf(cad.length());
	}
	
	@GetMapping (value = "/contar/{cadena}",produces = MediaType.TEXT_PLAIN_VALUE)
	public String contarVDos(@PathVariable("cadena") String cad) {
		return String.valueOf(cad.length());
	}
}
