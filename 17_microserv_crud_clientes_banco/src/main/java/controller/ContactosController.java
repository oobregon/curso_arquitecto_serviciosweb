package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Cliente;
import servicio.ServicioCliente;

@RestController
public class ContactosController {
	@Autowired
	ServicioCliente sCli;
	
	@GetMapping (value = "/autenticar/{usuario}/{contra}",produces = MediaType.TEXT_PLAIN_VALUE)
	public String autenticar(@PathVariable("usuario") String usuario,@PathVariable("contra") String contra) {
		if(sCli.autenticar(usuario, contra)) {
			return "0";
		} else {
			return "1";
		}		
	}
	
	
	@PostMapping (value = "/crear/{usuario}/{contra}",consumes= MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public void altaClienteVUno(@RequestBody Cliente cliente) {
		sCli.crear(cliente);
	}
	
	@PostMapping (value = "/crear",consumes= MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Cliente altaCliente(@RequestBody Cliente cliente) {
		sCli.crear(cliente);
		return cliente;
	}
			
	
	@DeleteMapping (value = "/eliminar/{idCliente}")
	public void eliminarCliente(@PathVariable("idCliente") int idCliente) {
		sCli.eliminar(idCliente);
	}
}
