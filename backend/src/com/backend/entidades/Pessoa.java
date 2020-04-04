package com.backend.entidades;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.time.LocalDate;
import javax.persistence.*;

@Entity
public class Pessoa implements Serializable {

	   
	@Id
	private Long idPessoa;
	private String nomePessoa;
	private String documentoPessoa;
	private LocalDate dataDeNascimentoPessoa;
	private String nomeDaMaePessoa;
	private String nomeDoPaiPessoa;
	private LocalDate dataDeCadastroPessoa;
	private String loginOperador;
	private String tipoPessoa;
	private static final long serialVersionUID = 1L;

	public Pessoa() {
		super();
	}   
	public Long getIdPessoa() {
		return this.idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}   
	public String getNomePessoa() {
		return this.nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}   
	public String getDocumentoPessoa() {
		return this.documentoPessoa;
	}

	public void setDocumentoPessoa(String documentoPessoa) {
		this.documentoPessoa = documentoPessoa;
	}   
	public LocalDate getDataDeNascimentoPessoa() {
		return this.dataDeNascimentoPessoa;
	}

	public void setDataDeNascimentoPessoa(LocalDate dataDeNascimentoPessoa) {
		this.dataDeNascimentoPessoa = dataDeNascimentoPessoa;
	}   
	public String getNomeDaMaePessoa() {
		return this.nomeDaMaePessoa;
	}

	public void setNomeDaMaePessoa(String nomeDaMaePessoa) {
		this.nomeDaMaePessoa = nomeDaMaePessoa;
	}   
	public String getNomeDoPaiPessoa() {
		return this.nomeDoPaiPessoa;
	}

	public void setNomeDoPaiPessoa(String nomeDoPaiPessoa) {
		this.nomeDoPaiPessoa = nomeDoPaiPessoa;
	}   
	public LocalDate getDataDeCadastroPessoa() {
		return this.dataDeCadastroPessoa;
	}

	public void setDataDeCadastroPessoa(LocalDate dataDeCadastroPessoa) {
		this.dataDeCadastroPessoa = dataDeCadastroPessoa;
	}   
	public String getLoginOperador() {
		return this.loginOperador;
	}

	public void setLoginOperador(String loginOperador) {
		this.loginOperador = loginOperador;
	}   
	public String getTipoPessoa() {
		return this.tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
   
}
