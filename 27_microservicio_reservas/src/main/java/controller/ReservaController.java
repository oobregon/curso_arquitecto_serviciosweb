package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Reserva;
import service.ServiceReserva;
@CrossOrigin(origins="*")
@RestController
public class ReservaController {
	
	@Autowired
	ServiceReserva sr;
	
	@Autowired
	VueloController vuelo;
	
	@PostMapping (value = "/alta", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void realizarReserva(@RequestBody Reserva reserva, @PathVariable plazasAvion) {
		
		if (vuelo.actualizarPlazaVuelo(idVuelo, plazas))
		sr.crearReserva(reserva);
	}

	@GetMapping (value = "/lista", produces = MediaType.APPLICATION_JSON_VALUE)
	public List <Reserva> buscarReserva() {
		return  sr.findReserva();
		
	}
	
}
