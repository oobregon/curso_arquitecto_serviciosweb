package servicio;

import model.Cliente;

public interface ServicioCliente {
	public void crear(String usuario,String contra);
	public void crear(Cliente cliente);
	public boolean autenticar(String usuario,String contra);
	public void eliminar(int idCliente);
}
