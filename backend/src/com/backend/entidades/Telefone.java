package com.backend.entidades;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.time.LocalDate;
import javax.persistence.*;

@Entity
public class Telefone implements Serializable {

	@Id
	private Long idTelefone;
	private String dddTelefone;
	private String numeroTelefone;
	private String tipoTelefone;
	private LocalDate dataDeCadastroTelefone;
	private String loginOperador;
	private Long idPessoa;
	private static final long serialVersionUID = 1L;

	public Telefone() {
		super();
	}   
	public Long getIdTelefone() {
		return this.idTelefone;
	}

	public void setIdTelefone(Long idTelefone) {
		this.idTelefone = idTelefone;
	}   
	public String getDddTelefone() {
		return this.dddTelefone;
	}

	public void setDddTelefone(String dddTelefone) {
		this.dddTelefone = dddTelefone;
	}   
	public String getNumeroTelefone() {
		return this.numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}   
	public String getTipoTelefone() {
		return this.tipoTelefone;
	}

	public void setTipoTelefone(String tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}   
	public LocalDate getDataDeCadastroTelefone() {
		return this.dataDeCadastroTelefone;
	}

	public void setDataDeCadastroTelefone(LocalDate dataDeCadastroTelefone) {
		this.dataDeCadastroTelefone = dataDeCadastroTelefone;
	}   
	public String getLoginOperador() {
		return this.loginOperador;
	}

	public void setLoginOperador(String loginOperador) {
		this.loginOperador = loginOperador;
	}   
	public Long getIdPessoa() {
		return this.idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}
   
}
