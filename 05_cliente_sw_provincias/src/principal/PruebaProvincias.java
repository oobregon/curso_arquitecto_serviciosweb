package principal;

import java.rmi.RemoteException;

import org.tempuri.OVCServWeb.OVCCallejero.Callejero_x0020_de_x0020_la_x0020_sede_x0020_electrónica_x0020_del_x0020_catastroSoap;
import org.tempuri.OVCServWeb.OVCCallejero.Callejero_x0020_de_x0020_la_x0020_sede_x0020_electrónica_x0020_del_x0020_catastroSoapProxy;

import es.meh.catastro.www.Provincias;

public class PruebaProvincias {

	public static void main(String[] args) throws RemoteException {
		Callejero_x0020_de_x0020_la_x0020_sede_x0020_electrónica_x0020_del_x0020_catastroSoap px;
		Callejero_x0020_de_x0020_la_x0020_sede_x0020_electrónica_x0020_del_x0020_catastroSoapProxy proxy = new Callejero_x0020_de_x0020_la_x0020_sede_x0020_electrónica_x0020_del_x0020_catastroSoapProxy();
		px = proxy.getCallejero_x0020_de_x0020_la_x0020_sede_x0020_electrónica_x0020_del_x0020_catastroSoap();
		
		Provincias provincias = px.obtenerProvincias();

	}

}
