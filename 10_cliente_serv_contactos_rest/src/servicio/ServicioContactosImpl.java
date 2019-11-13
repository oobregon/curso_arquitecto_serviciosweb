package servicio;

import java.util.List;
import org.springframework.web.client.RestTemplate;
import model.Contacto;


public class ServicioContactosImpl implements ServicioContactos {
	
	@Override
	public void alta(Contacto c) {
		String url = "http://localhost:8080/07_contactos_rest/accion";
		Contacto con = new Contacto(0,29,"oobregon@hotmail.com","Oscar Obregon Martin");
		RestTemplate rt = new RestTemplate();				
		String resultado = rt.postForObject(url,c,String.class);
		System.out.println("El resultado ha sido " + resultado);
	}

	@Override
	public List<Contacto> obtenerContactos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(int idContacto) {
		// TODO Auto-generated method stub
	}
}
