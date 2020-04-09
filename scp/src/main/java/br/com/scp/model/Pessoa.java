package br.com.scp.model;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Version;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Pessoa implements Serializable {

	public enum TipoPessoa {
		FISICA, JURIDICA
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	private static final long serialVersionUID = 1L;
	@Version
	@Column(name = "version")
	private int version;

	@Column(nullable = false)
	private TipoPessoa tipo;

	@ManyToOne
	@JoinColumn(name = "login")
	@Column(nullable = false)
	private Pessoa loginOperador;

	@Size(max = 6, message = "No máximo {max} caracteres. Você digitou: ${validatedValue}")
	@Column(nullable = false)
	private String dataDeCadastro;

	@Size(max = 100, message = "No máximo {max} caracteres. Você digitou: ${validatedValue}")
	@Pattern(regexp = "[A-Za-z]*", message = "Não deve conter números")
	@Column(nullable = false)
	private String nomeDoPai;

	@Size(max = 100, message = "No máximo {max} caracteres. Você digitou: ${validatedValue}")
	@Pattern(regexp = "[A-Za-z]*", message = "Não deve conter números")
	@Column(nullable = false)
	private String nomeDaMee;

	@Size(max = 6, message = "No máximo {max} caracteres. Você digitou: ${validatedValue}")
	@Column(nullable = false)
	private String dataDeNascimento;

	@Size(min = 11, max = 14, message = "No mínimo {min} e no máximo {max} caracteres. Você digitou: ${validatedValue}")
	@Pattern(regexp = "[0-9]*", message = "Deve conter somente números")
	@Column(nullable = false)
	private String documento;

	@Size(max = 100, message = "No máximo {max} caracteres. Você digitou: ${validatedValue}")
	@Pattern(regexp = "[A-Za-z]*", message = "Não deve conter números")
	@Column(nullable = false)
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Pessoa)) {
			return false;
		}
		Pessoa other = (Pessoa) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public TipoPessoa getTipo() {
		return tipo;
	}

	public void setTipo(TipoPessoa tipo) {
		this.tipo = tipo;
	}

	public Pessoa getLoginOperador() {
		return loginOperador;
	}

	public void setLoginOperador(Pessoa loginOperador) {
		this.loginOperador = loginOperador;
	}

	public String getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(String dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	public String getNomeDoPai() {
		return nomeDoPai;
	}

	public void setNomeDoPai(String nomeDoPai) {
		this.nomeDoPai = nomeDoPai;
	}

	public String getNomeDaMee() {
		return nomeDaMee;
	}

	public void setNomeDaMee(String nomeDaMee) {
		this.nomeDaMee = nomeDaMee;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (id != null)
			result += "id: " + id;
		result += ", version: " + version;
		if (tipo != null)
			result += ", tipo: " + tipo;
		if (loginOperador != null)
			result += ", loginOperador: " + loginOperador;
		if (dataDeCadastro != null && !dataDeCadastro.trim().isEmpty())
			result += ", dataDeCadastro: " + dataDeCadastro;
		if (nomeDoPai != null && !nomeDoPai.trim().isEmpty())
			result += ", nomeDoPai: " + nomeDoPai;
		if (nomeDaMee != null && !nomeDaMee.trim().isEmpty())
			result += ", nomeDaMee: " + nomeDaMee;
		if (dataDeNascimento != null && !dataDeNascimento.trim().isEmpty())
			result += ", dataDeNascimento: " + dataDeNascimento;
		if (documento != null && !documento.trim().isEmpty())
			result += ", documento: " + documento;
		if (nome != null && !nome.trim().isEmpty())
			result += ", nome: " + nome;
		return result;
	}
}