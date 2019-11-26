package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import model.Vuelo;
@CrossOrigin(origins="*")
@RestController
public class VueloController {
	
	//http://servicio-vuelos/vuelos
	@Value("${server.vuelo.url}")
    static String url;
	

	@Autowired
	RestTemplate template;
	
	
	@PutMapping(value = "/actualizar/{idVuelo}/{plazas}" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public Vuelo actualizarPlazaVuelo(@PathVariable("idVuelo") int idVuelo, @PathVariable("plazas") int plazas) {
		Vuelo vuelo=template.getForObject(url+"/actualizarPlazas/"+idVuelo+"/"+plazas, Vuelo.class);
		return vuelo;	
	}

}
