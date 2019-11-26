package model;

import org.springframework.web.client.RestTemplate;

public class PruebaServicioSaludo {

	public static void main(String[] args) {
		String url = "http://localhost:8080/06_ejemplo_rest_spring/saludo";
		String urlFicha = "http://localhost:8080/06_ejemplo_rest_spring/ficha";
		RestTemplate rt = new RestTemplate();						
		
		// llamarRecursoTres(rt,urlFicha);
		llamarRecursoCuatro(rt,url);
	}
	
	private static void llamarRecursoUno(RestTemplate rt,String url) {
		// llamada a Recurso 1
		String resultado = rt.getForObject(url,String.class);
		System.out.println("Resultado del recurso 1 " + resultado);
	}
	
	private static void llamarRecursoDos(RestTemplate rt,String url,String nombre) {
		// llamada a Recurso 2
		String resultadoDos = rt.getForObject(url+"/"+nombre,String.class);
		System.out.println("Resultado del recurso 2 " + resultadoDos);
	}
	
	private static void llamarRecursoTres(RestTemplate rt,String url) {
		// llamada a Recurso 3		
		Info info = rt.getForObject(url,Info.class);
		System.out.println("Resultado del recurso 3 " +"Edad:" +  info.getEdad() + " Email:" + info.getEmail());
	}
	
	private static void llamarRecursoCuatro(RestTemplate rt,String url) {
		// llamada a Recurso 4
		// En el cuerpo de la petición 
		Info infoDos = new Info("Oscar","oobre@gmail.com",45);
		String resultadoTres = rt.postForObject(url,infoDos,String.class);
		System.out.println("Resultado del recurso 4 " + resultadoTres);
	}
	
	private static void llamarRecursoCinco(RestTemplate rt,String url) {
		// llamada a Recuros 5
		rt.delete(url+"/probandoPeticionDelete");
	}
}
