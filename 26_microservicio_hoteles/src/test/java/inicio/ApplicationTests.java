package inicio;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class ApplicationTests {

	@Autowired
	MockMvc mock;
	
	@Test
	void testAuth() throws Exception {
		mock.perform(get("/viajes/hoteles")).andDo(print());
	}
//	@Test
//	void testAuthBad() throws Exception {
//		mock.perform(get("/opercliente/test1/test1wwww")).andDo(print());
//	}
//	
//	@Test
//	void testAlta() throws Exception {
//		mock.perform(post("/opercliente")
//				.contentType(MediaType.APPLICATION_JSON)
//				.content("{\"email\":\"boot@gmail.com\",\"password\":\"bootmicro\",\"telefono\":77777,\"usuario\":\"bootmicro\"}")
//				).andDo(print());
//	}
//
//	@Test
//	void eliminar() throws Exception {
//		mock.perform(delete("/opercliente/23")).andDo(print());
//	}
//	
}
