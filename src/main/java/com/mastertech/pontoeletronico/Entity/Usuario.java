package com.mastertech.pontoeletronico.Entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String nomeCompleto;
	private String cpf;
	private String email;
	private Date dataDoCadastro;
	@OneToMany(mappedBy = "usuario")
	@JsonManagedReference
	private List<Ponto> ponto;
	
	public Usuario() {}
	
	public Usuario(long id, String nomeCompleto, String cpf, String email, Date dataDoCadastro) {
		super();
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
		this.email = email;
		this.dataDoCadastro = dataDoCadastro;
		
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDataDoCadastro() {
		return dataDoCadastro;
	}
	public void setDataDoCadastro(Date dataDoCadastro) {
		this.dataDoCadastro = dataDoCadastro;
	}

	public List<Ponto> getPonto() {
		return ponto;
	}

	public void setPonto(List<Ponto> ponto) {
		this.ponto = ponto;
	}
	
	
	

}
