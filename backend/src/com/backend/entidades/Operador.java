package com.backend.entidades;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Operador implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public enum Perfil {GERENTE, ANALISTA}
	
	@Id
	@NotNull(message = "id do operador é obrigatório")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idOperador;
	
	@NotNull(message = "Nome do operador é obrigatório")
	@Size(max = 100, message="No máximo {max} caracteres. Você digitou: ${validatedValue}")
	@Pattern(regexp = "[A-Za-z]*", message = "Não deve conter números")
	private String nomeOperador;
	
	@NotNull(message = "Login do operador é obrigatório")
	@Size(max = 15, message="No máximo {max} caracteres. Você digitou: ${validatedValue}")
	@Pattern(regexp = "[A-Za-z\\-\\_]*", message = "Deve conter somente letras, - ou _")
	private String loginOperador;
	
	@Size(min = 6, max = 15, message="No mínimo {min} e no máximo {max} caracteres. Você digitou: ${validatedValue}")
	@Pattern(regexp = "[^\\s]*", message = "Não deve conter espaços em branco")
	private String senhaOperador;
	
	@NotNull(message = "Perfil do operador é obrigatório")
	private Perfil perfilOperador;
	
	@NotNull(message = "Data de Cadastro do operador é obrigatório")
	private LocalDate dataDeCadastroOperador;
	
	public Operador() {
		super();
	}   
	public Long getIdOperador() {
		return this.idOperador;
	}

	public void setIdOperador(Long idOperador) {
		this.idOperador = idOperador;
	}   
	public String getNomeOperador() {
		return this.nomeOperador;
	}

	public void setNomeOperador(String nomeOperador) {
		this.nomeOperador = nomeOperador;
	}   
	public String getLoginOperador() {
		return this.loginOperador;
	}

	public void setLoginOperador(String loginOperador) {
		this.loginOperador = loginOperador;
	}   
	public String getSenhaOperador() {
		return this.senhaOperador;
	}

	public void setSenhaOperador(String senhaOperador) {
		this.senhaOperador = senhaOperador;
	}   
	public Perfil getPerfilOperador() {
		return this.perfilOperador;
	}

	public void setPerfilOperador(Perfil perfilOperador) {
		this.perfilOperador = perfilOperador;
	}   
	public LocalDate getDataDeCadastroOperador() {
		return this.dataDeCadastroOperador;
	}

	public void setDataDeCadastroOperador(LocalDate dataDeCadastroOperador) {
		this.dataDeCadastroOperador = dataDeCadastroOperador;
	}
   
}
