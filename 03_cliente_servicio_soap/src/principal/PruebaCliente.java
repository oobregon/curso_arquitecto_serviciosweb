package principal;

import java.rmi.RemoteException;

import controller.AutenticacionController;
import controller.AutenticacionControllerProxy;

public class PruebaCliente {
	
	public static void main(String[] args) throws RemoteException {
		String usuario ="test1";
		String contra = "test2";
		AutenticacionController px;
		AutenticacionControllerProxy proxy = new AutenticacionControllerProxy();
		px = proxy.getAutenticacionController();
		if (px.autenticar(usuario,contra)) {
			System.out.println("El usuario existe");
		} else {
			System.out.println("El usuario no existe");
		}
	}
}
