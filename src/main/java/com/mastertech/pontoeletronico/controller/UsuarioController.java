package com.mastertech.pontoeletronico.controller;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mastertech.pontoeletronico.Entity.Usuario;
import com.mastertech.pontoeletronico.repository.UsuarioRepository;
import com.mastertech.pontoeletronico.services.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioService usuarioservice;
	
	@Autowired
	UsuarioRepository usuariorepository;
	
	@PostMapping("/usuario")
	public Usuario criaUsuario(@RequestBody Usuario usuario) {
		
		return usuarioservice.criar(usuario);
	}
	
	@GetMapping("/usuario/busca")
	public ResponseEntity<Usuario> buscaUsuario (@RequestParam(name = "id") long id){
		
		Optional<Usuario> usuarioOptional = usuarioservice.buscaUsuario(id);
		
		return usuarioOptional.isPresent() ? ResponseEntity.ok(usuarioOptional.get()) : ResponseEntity.notFound().build();
	}
	
	@GetMapping("/usuario/buscatudo")
	public List<Usuario> buscaTudos(){
		return usuariorepository.findAll();	
	}
	
	@PutMapping("/usuario/editar/{id}")
	public ResponseEntity<Usuario> editar (@RequestBody Usuario usuario, @PathVariable long id){
		
		Optional<Usuario> usuarioAchado = usuariorepository.findById(id);
		
		if (!usuarioAchado.isPresent())
			return ResponseEntity.notFound().build();
		
		usuario.setId(id);
		usuariorepository.save(usuario);
		
		return ResponseEntity.noContent().build();
	}
	
	
}
