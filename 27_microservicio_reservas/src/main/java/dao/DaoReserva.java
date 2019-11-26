package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Reserva;

public interface DaoReserva extends JpaRepository<Reserva, Integer> {

}
