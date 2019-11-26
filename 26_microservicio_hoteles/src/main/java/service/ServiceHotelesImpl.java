package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import daos.DaosHoteles;

import model.Hotel;

@Service
public class ServiceHotelesImpl implements ServiceHoteles {
	@Autowired
	DaosHoteles dao;

	@Override
	public List<Hotel> getHotelesDisponibles() {
		List<Hotel> hoteles = dao.findAllByDisponible();
		System.out.println("hoteles :" + hoteles);
		int i=0;
		for (Hotel h : hoteles) {		
			System.out.println("hotel :" + h);
			System.out.println("hotel :" + h.getDisponible());
			if (h.getDisponible() !=1) {
				hoteles.remove(i);
				System.out.println("borrado: "+ i);
			}
			i++;		
		}
		return hoteles;
	}

}