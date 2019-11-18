package inicio;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import controller.SaludoController;

@RunWith (SpringRunner.class)
@SpringBootTest (classes = SaludoController.class)
@AutoConfigureMockMvc
public class ApplicationTestMock {
	@Autowired
	MockMvc mock;	
	
	// todas las pruebas que queramos hacer, tienen que ir anotadas con @Test
	
	@Test
	void testSaludo() throws Exception {
		// Genera una peticion get del recurso saludo [get("/saludo")] y después imprimeme el resultado [print()]
		mock.perform(get("/saludo")).andDo(print());
	}
	
	@Test
	void testContar() throws Exception {
		// Genera una peticion get del recurso saludo [get("/saludo")] y después imprimeme el resultado [print()]
		mock.perform(get("/contar/cuenta")).andDo(print());
	}
}
