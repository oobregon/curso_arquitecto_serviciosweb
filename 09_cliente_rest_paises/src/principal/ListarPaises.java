package principal;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.client.RestTemplate;

public class ListarPaises {
	public static void main(String[] args) throws ParseException {
		String url = "https://restcountries.eu/rest/v2/all";
		RestTemplate rt = new RestTemplate();
		
		// Recojemos una ristra. Vamos a usar json simple para poder manipular esta cadena.
		// Hubiera sido mucho más dificil intentar mapear el json a un javabean, ya que, dicho javabean tendría
		// muchas propiedades, array de propiedades, etc, muy farragoso.
		String resultado = rt.getForObject(url,String.class);
		
		JSONParser transf = new JSONParser();
		
		// Ya hemos obtenido un array de objetos json
		JSONArray array = (JSONArray)transf.parse(resultado);
		for(Object ob:array) {
			JSONObject objJson = (JSONObject)ob;
			System.out.println(objJson.get("name"));
		}	
	}
}
