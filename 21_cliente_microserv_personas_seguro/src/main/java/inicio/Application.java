package inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

// 
@ComponentScan(basePackages = {"controller"})

@SpringBootApplication //Equivale 3 anotaciones: @Configuration, @EnableAutoConfiguration y @ComponentScan (escanea automaticamente el paquete inicio, que es donde está Application)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	// Al iniciarse spring, éste busca las clases anotadas con @Configuration y entonces dentro de estas clases busca todos los metodos anotados con @Bean y los ejecuta.
	// Esta clase Application está anotada implícitamente con @Configuration, ya que, esta clase es @SpringBootApplication y ya implica @Configuration.
	@Bean
	public RestTemplate getTemplate( ) {
		RestTemplate rt = new RestTemplate();
		BasicAuthenticationInterceptor interceptor = new BasicAuthenticationInterceptor("admin","admin"); 		
		rt.getInterceptors().add(interceptor);
		return new RestTemplate(); 
	}
}
