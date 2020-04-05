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
public class Telefone implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public enum TipoTelefone {CELULAR, FIXO, COMERCIAL}
	
	@Id
	@NotNull(message = "id do operador é obrigatório")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTelefone;
	
	@NotNull(message = "ddd do telefone é obrigatório")
	@Size(max = 3, message="No máximo {max} números. Você digitou: ${validatedValue}")
	@Pattern(regexp = "\\d{3}", message = "Deve conter somente números")
	private String dddTelefone;
	
	@NotNull(message = "ddd do telefone é obrigatório")
	@Size(min = 8, max = 10, message="No mínimo {min} e no máximo {max} números. Você digitou: ${validatedValue}")
	@Pattern(regexp = "(?:[0-9]{6}|[0-9]{4})[0-9]{4}", message = "Deve conter somente números")
	private String numeroTelefone;
	
	@NotNull(message = "O tipo do telefone é obrigatório")
	private TipoTelefone tipoTelefone;
	
	@NotNull(message = "A data do cadastro do telefone é obrigatório")
	private LocalDate dataDeCadastroTelefone;
	
	@ManyToOne
	@JoinColumn(name = "loginOperador")
	private Operador loginOperador;
	
	@ManyToOne
	@JoinColumn(name = "idPessoa")
	private Pessoa idPessoa;

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
	public TipoTelefone getTipoTelefone() {
		return this.tipoTelefone;
	}

	public void setTipoTelefone(TipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}   
	public LocalDate getDataDeCadastroTelefone() {
		return this.dataDeCadastroTelefone;
	}

	public void setDataDeCadastroTelefone(LocalDate dataDeCadastroTelefone) {
		this.dataDeCadastroTelefone = dataDeCadastroTelefone;
	}   
	public Operador getLoginOperador() {
		return this.loginOperador;
	}

	public void setLoginOperador(Operador loginOperador) {
		this.loginOperador = loginOperador;
	}   
	public Pessoa getIdPessoa() {
		return this.idPessoa;
	}

	public void setIdPessoa(Pessoa idPessoa) {
		this.idPessoa = idPessoa;
	}
   
}
