package com.mastertech.pontoeletronico.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastertech.pontoeletronico.Entity.Usuario;
import com.mastertech.pontoeletronico.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Usuario criar(Usuario usuario) {
		
		return usuarioRepository.save(usuario);
		 
	}
	
	public Optional<Usuario> buscaUsuario (long id){
		
		return usuarioRepository.findById(id);
	}

}
