package daos;

import java.util.List;

import model.Hotel;

public interface DaosHoteles  {

//	@Query("select h From Hotel h Where h.disponible=?1")
     List<Hotel> findAllByDisponible();

}
