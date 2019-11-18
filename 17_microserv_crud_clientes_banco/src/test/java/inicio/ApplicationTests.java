package inicio;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith (SpringRunner.class)
// @SpringBootTest (classes = SaludoController.class)
@AutoConfigureMockMvc
@SpringBootTest
class ApplicationTests {
	@Autowired
	MockMvc mock;
	
	@Test
	void autentOk() throws Exception {
		mock.perform(get("/autenticar/test1/test1")).andDo(print());
	}
	
	
	@Test
	void autentKo() throws Exception {
		mock.perform(get("/autenticar/testwer/test1")).andDo(print());
	}
	
	
	
	@Test
	void pruebaAlta() throws Exception {
		mock.perform(post("/crear").contentType(MediaType.APPLICATION_JSON_VALUE)
				             .content("{\"email\":\"boot@gmail.com\",\"password\":\"bootmicro\",\"telefono\":77777,\"usuario\":\"bootmicro\"}"))
				             .andDo(print());
	}
	
	
	/*
	@Test
	void eliminar() throws Exception {
		mock.perform(delete("/eliminar/61"));
	}
	*/
}
