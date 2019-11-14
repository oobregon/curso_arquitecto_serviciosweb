package controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import model.Contacto;
import servicio.ServicioContactos;

@Controller
public class AltaController {
	
	@Autowired
	ServicioContactos sCon;
	
	@GetMapping (value = "aNuevoContacto")
	public String iniciar(Model model) {
		model.addAttribute("contacto",new Contacto());
		return "altaContacto";
	}
	
	@PostMapping (value = "/altaContacto")
	public String alta(@ModelAttribute("contacto") Contacto contacto) {
		sCon.alta(contacto);
		return "menu";
	}
}