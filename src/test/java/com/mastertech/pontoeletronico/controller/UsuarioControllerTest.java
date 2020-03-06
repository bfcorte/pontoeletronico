package com.mastertech.pontoeletronico.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mastertech.pontoeletronico.Entity.Usuario;
import com.mastertech.pontoeletronico.repository.UsuarioRepository;
import com.mastertech.pontoeletronico.services.UsuarioService;


@RunWith(SpringRunner.class)
@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private UsuarioRepository repository;
	
	@MockBean
	private UsuarioService service;
	
	@Test
	public void deveCriarUsuario() throws JsonProcessingException, Exception {
		Usuario usuario = new Usuario();
		Mockito.when(service.criar(Mockito.any(Usuario.class))).thenReturn(usuario);
		
        mvc.perform(post("/usuario").contentType(MediaType.APPLICATION_JSON).content(toJson(usuario))).andExpect(status().isOk());

	}
	
	@Test
	public void deveBuscarUsuario() throws JsonProcessingException, Exception {
		Usuario usuario = new Usuario();
		Mockito.when(service.buscaUsuario(Mockito.anyLong())).thenReturn(Optional.of(usuario));
		
		mvc.perform(get("/usuario/busca").param("id", "1")).andExpect(status().isOk());
		
	}
	
	@Test
	public void deveBuscarTodosUsuarios() throws JsonProcessingException, Exception {
		Usuario usuario = new Usuario();
		Mockito.when(repository.save(Mockito.any(Usuario.class))).thenReturn(usuario);
		
		mvc.perform(get("/usuario/buscatudo").contentType(MediaType.APPLICATION_JSON).content(toJson(usuario))).andExpect(status().isOk());
		
	}
	
	
	
	private byte[] toJson(Object object) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
	}
}
