package servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DaoClientes;
import model.Cliente;

@Service
public class ServicioClienteImpl implements ServicioCliente {
	@Autowired
	DaoClientes daoCli;

	@Override
	public void crear(String usuario, String contra) {		
		Cliente cliente = daoCli.findByUsuarioAndPassword(usuario, contra); 
		if (cliente != null) {
			daoCli.save(cliente);
		}		
	}

	@Override
	public void eliminar(int idCliente) {
		if (daoCli.existsById(idCliente)) {			
			daoCli.deleteById(idCliente);
		}		
	}

	@Override
	public boolean autenticar(String usuario, String contra) {
		return daoCli.findByUsuarioAndPassword(usuario, contra) != null;
	}

	@Override
	public void crear(Cliente cliente) {
		daoCli.save(cliente);
	}
}
