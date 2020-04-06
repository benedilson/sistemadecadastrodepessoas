package br.com.backend.entidades;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public enum TipoPessoa {FISICA, JURIDICA}
	   
	@Id
	@NotNull(message = "id da pessoa é obrigatório")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPessoa;
	
	@NotNull(message = "Nome da pessoa é obrigatório")
	@Size(max = 100, message="No máximo {max} caracteres. Você digitou: ${validatedValue}")
	@Pattern(regexp = "[A-Za-z]*", message = "Não deve conter números")
	private String nomePessoa;
	
	@Size(min = 11, max = 14, message="No mínimo {min} e no máximo {max} caracteres. Você digitou: ${validatedValue}")
	@Pattern(regexp = "[0-9]*", message = "Deve conter somente números")
	private String documentoPessoa;
	
	@NotNull(message = "Data de nasciemnto da pessoa é obrigatório")
	@Size(max = 6, message="No máximo {max} caracteres. Você digitou: ${validatedValue}")
	private String dataDeNascimentoPessoa;
	
	@NotNull(message = "Nome da pessoa é obrigatório")
	@Size(max = 100, message="No máximo {max} caracteres. Você digitou: ${validatedValue}")
	@Pattern(regexp = "[A-Za-z]*", message = "Não deve conter números")
	private String nomeDaMaePessoa;
	
	@NotNull(message = "Nome da pessoa é obrigatório")
	@Size(max = 100, message="No máximo {max} caracteres. Você digitou: ${validatedValue}")
	@Pattern(regexp = "[A-Za-z]*", message = "Não deve conter números")
	private String nomeDoPaiPessoa;
	
	@NotNull(message = "Data de cadastro da pessoa é obrigatório")
	@Size(max = 6, message="No máximo {max} caracteres. Você digitou: ${validatedValue}")
	private String dataDeCadastroPessoa;
	
	@ManyToOne
	@JoinColumn(name = "loginOperador")
	private Operador loginOperador;
	
	@NotNull(message = "Tipo da pessoa é obrigatório")
	private TipoPessoa tipoPessoa;

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
	public String getDataDeNascimentoPessoa() {
		return this.dataDeNascimentoPessoa;
	}

	public void setDataDeNascimentoPessoa(String dataDeNascimentoPessoa) {
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
	public String getDataDeCadastroPessoa() {
		return this.dataDeCadastroPessoa;
	}

	public void setDataDeCadastroPessoa(String dataDeCadastroPessoa) {
		this.dataDeCadastroPessoa = dataDeCadastroPessoa;
	}   
	public Operador getLoginOperador() {
		return this.loginOperador;
	}

	public void setLoginOperador(Operador loginOperador) {
		this.loginOperador = loginOperador;
	}   
	public TipoPessoa getTipoPessoa() {
		return this.tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
   
}
