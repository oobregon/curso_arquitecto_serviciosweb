package servicio;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import model.Contacto;

@Service
public class ServicioContactosImpl implements ServicioContactos {
	
	@Override
	public void alta(Contacto c) {
		String url = "http://localhost:8080/07_contactos_rest/accion";
		RestTemplate rt = new RestTemplate();				
		String resultado = rt.postForObject(url,c,String.class);
		System.out.println("El resultado ha sido " + resultado);
	}

	@Override
	public Contacto[] obtenerContactos() {
		String url = "http://localhost:8080/07_contactos_rest/busqueda";
		RestTemplate rt = new RestTemplate();
		Contacto[] contactos = rt.getForObject(url,Contacto[].class);
		return contactos;
	}

	@Override
	public void eliminar(int idContacto) {
		// TODO Auto-generated method stub
	}
}
