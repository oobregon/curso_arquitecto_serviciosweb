package service;

import java.util.List;

import model.Reserva;

public interface ServiceReserva {
	
	void crearReserva (Reserva reserva);
	
	List<Reserva> findReserva();
}