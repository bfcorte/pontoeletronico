package com.mastertech.pontoeletronico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mastertech.pontoeletronico.Entity.Ponto;

public interface PontoRepository extends JpaRepository<Ponto, Long>{

}
