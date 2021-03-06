package controlador;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import servicio.ServicioContactos;

@Controller
public class ContactosController {
	@Autowired
	ServicioContactos sCont;

	@GetMapping (value = "/listarContactos")
	public String obtenerContactos(HttpServletRequest req) {
		req.setAttribute("contactos",sCont.obtenerContactos());
		return "contactos";
	}
	
	@GetMapping (value = "/eliminar")
	public String eliminarContacto(@RequestParam("idContacto") int idContacto) {
		sCont.eliminar(idContacto);
		return "forward:/listarContactos";
	}
}
