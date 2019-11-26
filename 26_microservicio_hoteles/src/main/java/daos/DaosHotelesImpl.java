package daos;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import model.Hotel;
@Repository
public class DaosHotelesImpl implements DaosHoteles{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Hotel> findAllByDisponible() {
		System.out.println("findAllBy");
		Query query= em.createNamedQuery("Hotel.findAll");
		List<Hotel> hoteles =(List<Hotel>)query.getResultList();
		return hoteles;
		
	}

}
