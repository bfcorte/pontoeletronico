package com.mastertech.pontoeletronico.services;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastertech.pontoeletronico.Entity.Usuario;
import com.mastertech.pontoeletronico.repository.UsuarioRepository;

@RunWith(SpringRunner.class)
public class UsuarioServicesTest {
		
		
		@Mock
		private UsuarioRepository repository;
		
		@InjectMocks
		private UsuarioService service;
		
		@org.junit.Before
		public void setup () {
			MockitoAnnotations.initMocks(this);
		}
		
		@Test
		public void deveCriarUmUsuario() {
			
			Usuario usuario = new Usuario();
			Mockito.when(repository.save(Mockito.any(Usuario.class))).thenReturn(usuario);
			
			usuario = service.criar(usuario);
			
			Assert.assertNotNull(usuario);
		}
		
		@Test
		public void deveBuscarUsuario() {
			
			Usuario usuario = new Usuario();
			Mockito.when(service.buscaUsuario(Mockito.anyLong())).thenReturn(Optional.of(usuario));
			
			Optional<Usuario> usuarioOptional = service.buscaUsuario(1);
			
			Assert.assertNotNull(usuarioOptional);
			
		}

}
