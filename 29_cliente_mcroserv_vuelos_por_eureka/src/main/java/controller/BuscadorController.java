package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import model.Hotel;
import model.Reserva;
import model.Vuelo;

@RestController
public class BuscadorController {
	// Inyectame el valor de esta propiedad.
	// Spring busca en todos los ficheros de properties del classpath en busca 
	// de la propiedad indicada.
	// http://servicio-vuelos/vuelos
	@Value("${servicio.rest.viajes}")
	String url;
	
	@Autowired
	RestTemplate template;
	
	
	// Llamada a Microservicios servicio-vuelos desplegado en Eureka
	@GetMapping (value ="/vuelos/{plazas}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Vuelo[] obtenerVuelosDisponibles(@PathVariable("plazas") int numPlazas) {
		Vuelo[] vuelos = template.getForObject(url+"/disponibilidadVuelos/"+numPlazas,Vuelo[].class);
		return vuelos;
	}
	
	@PutMapping (value = "/actualizarPlazas/{idVuelo}/{plazas}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Vuelo actualizarPlazas(@PathVariable("idVuelo") int idVuelo,
								  @PathVariable("plazas") int numPlazas) {		
		template.getForObject(url+"/actualizarPlazas/"+idVuelo+ "/" + numPlazas,Vuelo[].class);
		return null;
	}
	
	// ###################################################################
	// Llamada a Microservicios servicio-hoteles desplegado en Eureka	
	@GetMapping (value ="/hotel",produces = MediaType.APPLICATION_JSON_VALUE)
	public Hotel[] obtenerHoteles() {		
		Hotel[] hoteles = template.getForObject("http://servicio-hoteles/"+"viajes/hoteles",Hotel[].class);		
		return hoteles;
	}
	
	
	// ###################################################################
	// Llamada a Microservicios servicio-reserva desplegado en Eureka
	@PostMapping (value = "/reserva", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void crearReserva(@RequestBody Reserva reserva) {
		template.postForLocation("http://servicio-reservas/reservas/alta",reserva);		
	}	
	
	@GetMapping (value ="/reserva/{idReserva}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Reserva[] obtenerReservas(@PathVariable("idReserva") int idRer) {		
		Reserva[] reservas = template.getForObject("http://servicio-reservas/reservas/lista",Reserva[].class);		
		return reservas;
	}
}
