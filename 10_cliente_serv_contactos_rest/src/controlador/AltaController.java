package controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import model.Contacto;
import servicio.ServicioContactos;

@Controller
public class AltaController {
	
	@Autowired
	ServicioContactos sCon;
	
	@PostMapping (value = "/altaContacto")
	public String alta(@ModelAttribute("contacto") Contacto contacto) {
		sCon.alta(contacto);
		return "menu";
	}
}
