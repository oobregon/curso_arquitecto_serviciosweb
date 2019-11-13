package principal;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ListarPaises {
	public static void main(String[] args) throws ParseException {
		metodoUno();
		alternativa();
	}
	
	public static void metodoUno() throws ParseException {
		String url = "https://restcountries.eu/rest/v2/all";
		RestTemplate rt = new RestTemplate();
		
		// Recojemos una ristra. Vamos a usar json simple para poder manipular esta cadena.
		// Hubiera sido mucho m�s dificil intentar mapear el json a un javabean, ya que, dicho javabean tendr�a
		// muchas propiedades, array de propiedades, etc, muy farragoso.
		String cuerpoPetHttp = rt.getForObject(url,String.class);
		
		JSONParser transf = new JSONParser();
		
		// Ya hemos obtenido un array de objetos json
		JSONArray array = (JSONArray)transf.parse(cuerpoPetHttp);
		for(Object ob:array) {
			JSONObject objJson = (JSONObject)ob;
			System.out.println(objJson.get("name"));
		}				
	}
	
	public static void alternativa() throws ParseException {
		String url = "https://restcountries.eu/rest/v2/all";
		RestTemplate rt = new RestTemplate();
		
		ResponseEntity<String> peticionHttp = rt.getForEntity(url,String.class);
		if(peticionHttp.getStatusCodeValue() == 200 ) { // Todo ha ido bien
			String res = peticionHttp.getBody();
			JSONParser transf = new JSONParser();			
			// Ya hemos obtenido un array de objetos json
			JSONArray array = (JSONArray)transf.parse(res);
			for(Object ob:array) {
				JSONObject objJson = (JSONObject)ob;
				System.out.println(objJson.get("name"));
			}
		}				
	}
}
