package com.mastertech.pontoeletronico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mastertech.pontoeletronico.Entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	

}
