package br.com.projeto.controller.rest;

import br.com.projeto.model.usuario.dto.EnderecoUsuarioDTO;
import br.com.projeto.model.usuario.dto.TipoUsuarioDTO;
import br.com.projeto.model.usuario.dto.UsuarioDTO;
import br.com.projeto.repository.tipousuario.TipoUsuarioRepository;
import br.com.projeto.repository.usuario.LogradouroEnum;
import br.com.projeto.repository.usuario.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class UsuarioRestTest {


	@MockBean
	public UsuarioRepository usuarioRepository;

	@MockBean
	private TipoUsuarioRepository tipoUsuarioRepository;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void inserirUsuario() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
						.put("/Rest/Usuario")
						.content(asJsonString(new UsuarioDTO(null, "Nome do Usuario", "email@teste",
								"Senha589", new TipoUsuarioDTO(1L, ""), LocalDate.now(),
								new EnderecoUsuarioDTO(456, LogradouroEnum.RUA, "12345678"), true)))
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void consultar() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
				.get("/Rest/Usuario")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
	}

	/**
	 * Converte um objeto em uma String no formato Json
	 *
	 * @param obj
	 * @return
	 */
	public static String asJsonString(final Object obj) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());
			mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
			return mapper.writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}