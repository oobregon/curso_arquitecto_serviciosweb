package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Vuelo;
import servicio.ServicioVuelo;

@RestController
@CrossOrigin (origins = "*")
public class VuelosController {
	
	@Autowired
	private ServicioVuelo sVuelo;
	
	@GetMapping (value ="/disponibilidadVuelos/{plazas}")
	public List<Vuelo> obtenerVuelosDisponibles(@PathVariable("plazas") int numPlazas) {
		return sVuelo.obtenerDisponibilidadVuelos(numPlazas);
	}
	
	@PutMapping (value = "/actualizarPlazas", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public Vuelo actualizarPlazas(@RequestBody Vuelo vuelo) {
		return sVuelo.actualizar(vuelo);		
	}
	
	@PutMapping (value = "/actualizarPlazas/{idVuelo}/{plazas}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Vuelo actualizarPlazas(@PathVariable("idVuelo") int idVuelo,
								  @PathVariable("plazas") int numPlazas) {
		return sVuelo.actualizar(idVuelo, numPlazas);		
	}
}
