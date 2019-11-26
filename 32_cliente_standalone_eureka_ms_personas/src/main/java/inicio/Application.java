package inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// ApplicationContext es una referencia a spring en general
		// Cuando se termine de ejecutar el run, ya podemos estar seguro de que spring se ha iniciado. 
		ApplicationContext actx = SpringApplication.run(Application.class, args);
		AccesoServicio acceso = actx.getBean(AccesoServicio.class);
		acceso.imprimirPersonas();
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate getTemplate() {
		return new RestTemplate();
	}
}
