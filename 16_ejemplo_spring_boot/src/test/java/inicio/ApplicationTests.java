package inicio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import controller.SaludoController;

@SpringBootTest (classes = {SaludoController.class})
class ApplicationTests {
	@Autowired
	SaludoController saludo;

	@Test
	void contextLoads() {
		assertEquals(saludo.contar("hola"),"4");
	}
}
