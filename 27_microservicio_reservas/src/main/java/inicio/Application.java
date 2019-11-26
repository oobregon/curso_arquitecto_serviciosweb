package inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import controller.VueloController;


@ComponentScan(basePackages = {"controller", "service"})
@EntityScan(basePackages = {"model"})
@EnableJpaRepositories(basePackages = {"dao"})
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@LoadBalanced //habilita el uso de la libraría Ribbon para poder comunicarse con el servidor eureka
	@Bean
	public RestTemplate getRestTemplate() {
	    return new RestTemplate();
	}
	
	@LoadBalanced //habilita el uso de la libraría Ribbon para poder comunicarse con el servidor eureka
	@Bean
	public VueloController getVueloController() {
	    return new VueloController();
	}
}
