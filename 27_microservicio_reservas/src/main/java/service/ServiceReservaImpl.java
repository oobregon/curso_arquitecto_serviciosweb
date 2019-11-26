package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DaoReserva;
import model.Reserva;

@Service
public class ServiceReservaImpl implements ServiceReserva {
	
	
	@Autowired
	DaoReserva dr;

	

	@Override
	public void crearReserva(Reserva reserva) {
		if(!dr.existsById(reserva.getIdreserva())) {
			dr.save(reserva);
		}
		
	}



	@Override
	public List <Reserva> findReserva() {
		List<Reserva> reserva=dr.findAll();
		return reserva;
	}
	
	

	

}
