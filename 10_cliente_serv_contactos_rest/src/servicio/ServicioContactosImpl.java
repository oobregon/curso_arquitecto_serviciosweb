package servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import model.Contacto;

@Service
public class ServicioContactosImpl implements ServicioContactos {
	@Autowired
	RestTemplate rt;
	
	@Override
	public void alta(Contacto c) {
		String url = "http://localhost:8080/07_contactos_rest/accion";
		String resultado = rt.postForObject(url,c,String.class);
		System.out.println("El resultado ha sido " + resultado);
	}

	@Override
	public Contacto[] obtenerContactos() {
		String url = "http://localhost:8080/07_contactos_rest/busqueda";
		Contacto[] contactos = rt.getForObject(url,Contacto[].class);
		return contactos;
	}

	@Override
	public void eliminar(int idContacto) {
		String url = "http://localhost:8080/07_contactos_rest/accion";
		rt.delete(url+"/"+idContacto);				
	}
}
