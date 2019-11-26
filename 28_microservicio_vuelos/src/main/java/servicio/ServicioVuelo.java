package servicio;

import java.util.List;

import model.Vuelo;

public interface ServicioVuelo {	
	List<Vuelo> obtenerDisponibilidadVuelos(int numPlazas);
	Vuelo obtenerVuelo(int idVuelo);
	Vuelo actualizar(Vuelo vuelo);
	Vuelo actualizar(int idVuelo,int numPlazas);
}
