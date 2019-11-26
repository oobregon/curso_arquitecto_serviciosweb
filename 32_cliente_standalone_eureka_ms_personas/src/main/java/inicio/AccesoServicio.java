package inicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import model.Persona;

// Recordemos que cuando spring arranca y encuentra esta anotación lo que hace es instanciar la clase
@Component
public class AccesoServicio {
	@Autowired
	RestTemplate template;
	
	public void imprimirPersonas() {
		String url="http://servicio-personas/personas/lista";
		Persona[] personas=template.getForObject(url, Persona[].class);
		for(Persona p:personas) {
			System.out.println(p.getNombre());
		}
	}
}
