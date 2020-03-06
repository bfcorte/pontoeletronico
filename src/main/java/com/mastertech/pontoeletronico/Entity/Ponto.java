package com.mastertech.pontoeletronico.Entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Ponto {
	
	@ManyToOne 
	@JoinColumn(name="usuario_id")
	@JsonBackReference
	private Usuario usuario;
	private Date dataPonto;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String entrada;
	private String saida;
	
	public Date getDataPonto() {
		return dataPonto;
	}
	public void setDataPonto(Date dataPonto) {
		this.dataPonto = dataPonto;
	}
	public String getEntrada() {
		return entrada;
	}
	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}
	public String getSaida() {
		return saida;
	}
	public void setSaida(String saida) {
		this.saida = saida;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

}
