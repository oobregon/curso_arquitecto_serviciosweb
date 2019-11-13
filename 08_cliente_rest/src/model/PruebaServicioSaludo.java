package model;

import org.springframework.web.client.RestTemplate;

public class PruebaServicioSaludo {

	public static void main(String[] args) {
		String url = "http://localhost:8080/06_ejemplo_rest_spring/saludo";
		String urlFicha = "http://localhost:8080/06_ejemplo_rest_spring/ficha";
		RestTemplate rt = new RestTemplate();
		
		// llamada a Recurso 1
		String resultado = rt.getForObject(url,String.class);
		System.out.println("Resultado del recurso 1 " + resultado);
		
		// llamada a Recurso 2
		String resultadoDos = rt.getForObject(url+"/Oscar",String.class);
		System.out.println("Resultado del recurso 2 " + resultadoDos);
		
		// llamada a Recurso 3		
		Info info = rt.getForObject(urlFicha,Info.class);
		System.out.println("Resultado del recurso 3 " +"Edad:" +  info.getEdad() + " Email:" + info.getEmail());
		
		// llamada a Recurso 4
		// En el cuerpo de la petición 
		Info infoDos = new Info("Oscar","oobre@gmail.com",45);
		String resultadoTres = rt.postForObject(url,infoDos,String.class);
		System.out.println("Resultado del recurso 4 " + resultadoTres);
		
		// llamada a Recuros 5
		rt.delete(url+"/probandoPeticionDelete");		
	}
}
